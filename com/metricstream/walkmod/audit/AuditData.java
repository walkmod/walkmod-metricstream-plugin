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

package com.metricstream.walkmod.audit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class AuditData used to store audit information of the code changes against the specified rule id.
 *
 * @author mohanasundar.n
 */
public final class AuditData {

	/** The audit data. */
	private Map<String, List<AuditInfo>> mData = new HashMap<String, List<AuditInfo>>();

	/**
	 * Sets the {@link AuditInfo} against the given ruleId.
	 *
	 * @param ruleId
	 *            the rule id
	 * @param auditInfo
	 *            the audit info
	 */
	public void setData(String ruleId, AuditInfo auditInfo) {
		List<AuditInfo> list;
		if (mData.containsKey(ruleId)) {
			list = (List<AuditInfo>) mData.get(ruleId);
		} else {
			list = new ArrayList<AuditInfo>();
		}
		list.add(auditInfo);
		mData.put(ruleId, list);
	}

	/**
	 * Gets the audit informations of all the rule id.
	 *
	 * @return The audit informations
	 */
	public Map<String, List<AuditInfo>> getData() {
		return mData;
	}

	/**
	 * Gets the audit information for the given rule id.
	 *
	 * @param ruleID
	 *            The rule id
	 * @return The audit informations
	 */
	public List<AuditInfo> getData(String ruleID) {
		List<AuditInfo> list = mData.get(ruleID);
		if (list == null) {
			list = new ArrayList<AuditInfo>();
		}
		return list;
	}
}
