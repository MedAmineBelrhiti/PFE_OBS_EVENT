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

import com.liferay.portal.kernel.exception.PortalException;
import com.orange.model.EvenementObs;
import com.orange.service.base.EvenementObsLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.orange.model.EvenementObs",
	service = AopService.class
)
public class EvenementObsLocalServiceImpl extends EvenementObsLocalServiceBaseImpl {
	public EvenementObs addEvenement (Date startDate, Date endDate, String lieu,String description, Date votingEndDate, int nbrUserMax ,String entity, String managerName){
		long idEvent = counterLocalService.increment(EvenementObs.class.getName());
		EvenementObs event = evenementObsPersistence.create(idEvent);

		event.setStartDate(startDate);
		event.setEndDate(endDate);
		event.setLieu(lieu);
		event.setDescription(description);
		event.setVotingEndDate(votingEndDate);
		event.setNbrUserMax(nbrUserMax);
		event.setEntity(entity);
		event.setManagerName(managerName);

		evenementObsLocalService.addEvenementObs(event);
		return event;
	}
}