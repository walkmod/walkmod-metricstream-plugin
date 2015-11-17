/*
 * SYSTEMi Copyright © 2015, MetricStream, Inc. All rights reserved.
 * 
 * Walkmod is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Walkmod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Walkmod.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Mohanasundar N(mohanasundar.n@metricstream.com)
 * created 05/01/2015
 */

package com.metricstream.walkmod.plugin.visitors;

import java.util.ArrayList;
import java.util.List;

import org.sonar.java.checks.JavaFootprint;
import org.sonar.squid.recognizer.CodeRecognizer;
import org.walkmod.javalang.ast.Comment;
import org.walkmod.javalang.ast.CompilationUnit;
import org.walkmod.javalang.ast.LineComment;
import org.walkmod.walkers.VisitorContext;

/**
 * The Class RemoveCodeComment.
 *
 * @author mohanasundar.n
 */
public class RemoveCodeComment extends CustomPluginAdapter {

	/** The Constant THRESHOLD. */
	private static final double THRESHOLD = 0.9;

	/** The Constant codeRecognizer. */
	private static final CodeRecognizer codeRecognizer;

	/** The start with list. */
	private List<String> startWithList;

	static {
		codeRecognizer = new CodeRecognizer(THRESHOLD, new JavaFootprint());
	}

	/**
	 * Instantiates a new removes the code comment.
	 */
	public RemoveCodeComment() {
		this.startWithList = new ArrayList<String>();
	}

	/**
	 * Sets the start with list.
	 *
	 * @param startWithList
	 *            the new start with list
	 */
	public void setStartWithList(String startWithList) {
		if (startWithList != null) {
			String[] startWithLists = startWithList.split(",");
			for (int i = 0; i < startWithLists.length; i++) {
				this.startWithList.add(startWithLists[i].trim());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.walkmod.javalang.visitors.VoidVisitorAdapter#visit(org.walkmod.javalang.ast.CompilationUnit,
	 * java.lang.Object)
	 */
	@Override
	public void visit(CompilationUnit n, VisitorContext arg) {
		List<Comment> comments = n.getComments();
		if (comments != null) {
			for (int i = 0; i < comments.size();) {
				Comment comment = comments.get(i);
				if (canRemoved(comment)) {
					comments.remove(i);
					continue;
				}
				i++;
			}
		}
		n.setComments(comments);
	}

	/**
	 * Can removed.
	 *
	 * @param comment
	 *            the comment
	 * @return true, if successful
	 */
	private boolean canRemoved(Comment comment) {
		String str = comment.getContent();
		if (codeRecognizer.isLineOfCode(str)) {
			return true;
		}
		if (comment instanceof LineComment) {
			for (String string : startWithList) {
				if (str.trim().startsWith(string)) {
					return true;
				}
			}
		}
		return false;
	}
}
