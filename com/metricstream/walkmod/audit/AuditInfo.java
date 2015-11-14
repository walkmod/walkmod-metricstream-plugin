/*
 * SYSTEMi Copyright � 2000-2015, MetricStream, Inc. All rights reserved.
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

package com.metricstream.walkmod.audit;

/**
 * The class AuditInfo used to store the audit information of the source code change.
 *
 * @author mohanasundar.n
 */
public class AuditInfo {

	/** The name. */
	private String name;

	/** The old code. */
	private String oldCode;

	/** The new code. */
	private String newCode;

	/**
	 * Gets the name.
	 *
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the old code.
	 *
	 * @return The old code
	 */
	public String getOldCode() {
		return oldCode;
	}

	/**
	 * Sets the old code.
	 *
	 * @param oldCode
	 *            The old code
	 */
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}

	/**
	 * Gets the new code.
	 *
	 * @return The new code
	 */
	public String getNewCode() {
		return newCode;
	}

	/**
	 * Sets the new code.
	 *
	 * @param newCode
	 *            The new code
	 */
	public void setNewCode(String newCode) {
		this.newCode = newCode;
	}
}
