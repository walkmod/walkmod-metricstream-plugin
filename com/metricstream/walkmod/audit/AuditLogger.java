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
 * The Class AuditLogger.
 *
 * @author mohanasundar.n
 */
public class AuditLogger {

	/** The audit logger instance. */
	private static AuditLogger auditLogger;

	/** The {@link AuditData} instance. */
	private AuditData auditData;

	/**
	 * Instantiates a new audit logger.
	 */
	private AuditLogger() {
		auditData = new AuditData();
	}

	/**
	 * Gets the single instance of audit logger.
	 *
	 * @return The audit logger instance
	 */
	public static AuditLogger getInstance() {
		if (auditLogger == null) {
			throw new NullPointerException("Audit logger instance is not yet instantiated");
		}
		return auditLogger;
	}

	/**
	 * Initializes the audit logger.
	 */
	public static void initialize() {
		if (auditLogger == null) {
			auditLogger = new AuditLogger();
		}
	}

	/**
	 * Gets the {@link AuditData}.
	 *
	 * @return The {@link AuditData}
	 */
	public AuditData getAuditData() {
		return auditData;
	}

	/**
	 * Write the {@link AuditData}.
	 */
	public static void write() {
		System.out.println("\n\n****Code analyzed****");
		System.out.println(auditLogger.getAuditData().getData());
	}
}
