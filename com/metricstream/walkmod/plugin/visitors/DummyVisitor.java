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

import org.walkmod.javalang.ast.CompilationUnit;
import org.walkmod.walkers.VisitorContext;

/**
 * The Class DummyVisitor.
 * 
 * @author mohanasundar.n
 *
 */
public class DummyVisitor extends CustomPluginAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.walkmod.javalang.visitors.VoidVisitorAdapter#visit(org.walkmod.javalang.ast.CompilationUnit,
	 * java.lang.Object)
	 */
	@Override
	public void visit(CompilationUnit n, VisitorContext arg) {
		arg.put("WRITE", true);
		super.visit(n, arg);
	}
}
