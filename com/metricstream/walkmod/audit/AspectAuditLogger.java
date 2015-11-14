/*
 * SYSTEMi Copyright © 2000-2015, MetricStream, Inc. All rights reserved.
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

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * The Class AspectAuditLogger.
 *
 * @author mohanasundar.n
 */
@Aspect
public class AspectAuditLogger {

	/**
	 * Aspect point cut for org.walkmod.WalkModFacade.apply method
	 */
	@Pointcut("call(public void org.walkmod.WalkModFacade.apply(*))")
	public void doInit() {

	}

	/**
	 * This method will be invoked while entering to the point cut {@link #doInit()}.
	 * 
	 * Here we are initializing the {@link AuditLogger}
	 * 
	 */
	@Before("doInit()")
	public void beforeProcessing() {
		AuditLogger.initialize();
	}

	/**
	 * THis method will be invoked on exit of the point cut {@link #doInit()}
	 * 
	 * Here we are writing the {@link AuditData}.
	 */
	@After("doInit()")
	public void afterProcessing() {
		AuditLogger.write();
	}
}
