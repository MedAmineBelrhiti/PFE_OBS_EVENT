/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.orange.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.Session;
import com.orange.exception.NoSuchDemandEventObsException;
import com.orange.model.DemandEventObs;
import com.orange.service.DemandEventObsLocalServiceUtil;
import com.orange.service.DemandEventObsServiceUtil;
import com.orange.service.base.DemandEventObsLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.orange.model.DemandEventObs",
	service = AopService.class
)
public class DemandEventObsLocalServiceImpl extends DemandEventObsLocalServiceBaseImpl {
	public DemandEventObs addDemand(String content,String firstName,String lastName)
	{
		long idDemand = counterLocalService.increment(DemandEventObs.class.getName());
		DemandEventObs demand = demandEventObsPersistence.create(idDemand);

		demand.setStatus("waiting");
		demand.setContent(content);
		demand.setFirstName(firstName);
		demand.setLastName(lastName);

		demandEventObsLocalService.addDemandEventObs(demand);
		return demand;
	}
	public DemandEventObs ApproveDemand(long idDemand){
		DemandEventObs demand = demandEventObsPersistence.fetchByPrimaryKey(idDemand);
		demand.setStatus("Approved");
		demandEventObsLocalService.updateDemandEventObs(demand);
		return demand;
	}

	public List<DemandEventObs> findByStatus(String status){
		return demandEventObsPersistence.findByStatus(status);
	}
}