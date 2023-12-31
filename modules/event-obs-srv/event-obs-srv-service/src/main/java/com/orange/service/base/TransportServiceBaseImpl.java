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

package com.orange.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.orange.model.Transport;
import com.orange.service.TransportService;
import com.orange.service.TransportServiceUtil;
import com.orange.service.persistence.ContactSupportPersistence;
import com.orange.service.persistence.DemandEventObsPersistence;
import com.orange.service.persistence.EvenementObsPersistence;
import com.orange.service.persistence.MessagingPersistence;
import com.orange.service.persistence.TransportPersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the transport remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.orange.service.impl.TransportServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.orange.service.impl.TransportServiceImpl
 * @generated
 */
public abstract class TransportServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, TransportService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TransportService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>TransportServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TransportService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		transportService = (TransportService)aopProxy;

		_setServiceUtilService(transportService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TransportService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Transport.class;
	}

	protected String getModelClassName() {
		return Transport.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = transportPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(TransportService transportService) {
		try {
			Field field = TransportServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, transportService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ContactSupportPersistence contactSupportPersistence;

	@Reference
	protected DemandEventObsPersistence demandEventObsPersistence;

	@Reference
	protected EvenementObsPersistence evenementObsPersistence;

	@Reference
	protected MessagingPersistence messagingPersistence;

	@Reference
	protected com.orange.service.TransportLocalService transportLocalService;

	protected TransportService transportService;

	@Reference
	protected TransportPersistence transportPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	private static final Log _log = LogFactoryUtil.getLog(
		TransportServiceBaseImpl.class);

}