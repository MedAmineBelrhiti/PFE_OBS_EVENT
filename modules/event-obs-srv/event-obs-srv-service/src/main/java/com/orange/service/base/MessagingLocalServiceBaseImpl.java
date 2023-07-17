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

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.orange.model.Messaging;
import com.orange.service.MessagingLocalService;
import com.orange.service.MessagingLocalServiceUtil;
import com.orange.service.persistence.ContactSupportPersistence;
import com.orange.service.persistence.DemandEventObsPersistence;
import com.orange.service.persistence.EvenementObsPersistence;
import com.orange.service.persistence.MessagingPersistence;
import com.orange.service.persistence.TransportPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the messaging local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.orange.service.impl.MessagingLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.orange.service.impl.MessagingLocalServiceImpl
 * @generated
 */
public abstract class MessagingLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, MessagingLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>MessagingLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>MessagingLocalServiceUtil</code>.
	 */

	/**
	 * Adds the messaging to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MessagingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param messaging the messaging
	 * @return the messaging that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Messaging addMessaging(Messaging messaging) {
		messaging.setNew(true);

		return messagingPersistence.update(messaging);
	}

	/**
	 * Creates a new messaging with the primary key. Does not add the messaging to the database.
	 *
	 * @param idMessage the primary key for the new messaging
	 * @return the new messaging
	 */
	@Override
	@Transactional(enabled = false)
	public Messaging createMessaging(long idMessage) {
		return messagingPersistence.create(idMessage);
	}

	/**
	 * Deletes the messaging with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MessagingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idMessage the primary key of the messaging
	 * @return the messaging that was removed
	 * @throws PortalException if a messaging with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Messaging deleteMessaging(long idMessage) throws PortalException {
		return messagingPersistence.remove(idMessage);
	}

	/**
	 * Deletes the messaging from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MessagingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param messaging the messaging
	 * @return the messaging that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Messaging deleteMessaging(Messaging messaging) {
		return messagingPersistence.remove(messaging);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return messagingPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Messaging.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return messagingPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.orange.model.impl.MessagingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return messagingPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.orange.model.impl.MessagingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return messagingPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return messagingPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return messagingPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Messaging fetchMessaging(long idMessage) {
		return messagingPersistence.fetchByPrimaryKey(idMessage);
	}

	/**
	 * Returns the messaging matching the UUID and group.
	 *
	 * @param uuid the messaging's UUID
	 * @param groupId the primary key of the group
	 * @return the matching messaging, or <code>null</code> if a matching messaging could not be found
	 */
	@Override
	public Messaging fetchMessagingByUuidAndGroupId(String uuid, long groupId) {
		return messagingPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the messaging with the primary key.
	 *
	 * @param idMessage the primary key of the messaging
	 * @return the messaging
	 * @throws PortalException if a messaging with the primary key could not be found
	 */
	@Override
	public Messaging getMessaging(long idMessage) throws PortalException {
		return messagingPersistence.findByPrimaryKey(idMessage);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(messagingLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Messaging.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("idMessage");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			messagingLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Messaging.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("idMessage");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(messagingLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Messaging.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("idMessage");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Messaging>() {

				@Override
				public void performAction(Messaging messaging)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, messaging);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Messaging.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return messagingPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement MessagingLocalServiceImpl#deleteMessaging(Messaging) to avoid orphaned data");
		}

		return messagingLocalService.deleteMessaging((Messaging)persistedModel);
	}

	@Override
	public BasePersistence<Messaging> getBasePersistence() {
		return messagingPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return messagingPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the messagings matching the UUID and company.
	 *
	 * @param uuid the UUID of the messagings
	 * @param companyId the primary key of the company
	 * @return the matching messagings, or an empty list if no matches were found
	 */
	@Override
	public List<Messaging> getMessagingsByUuidAndCompanyId(
		String uuid, long companyId) {

		return messagingPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of messagings matching the UUID and company.
	 *
	 * @param uuid the UUID of the messagings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of messagings
	 * @param end the upper bound of the range of messagings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching messagings, or an empty list if no matches were found
	 */
	@Override
	public List<Messaging> getMessagingsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Messaging> orderByComparator) {

		return messagingPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the messaging matching the UUID and group.
	 *
	 * @param uuid the messaging's UUID
	 * @param groupId the primary key of the group
	 * @return the matching messaging
	 * @throws PortalException if a matching messaging could not be found
	 */
	@Override
	public Messaging getMessagingByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return messagingPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the messagings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.orange.model.impl.MessagingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of messagings
	 * @param end the upper bound of the range of messagings (not inclusive)
	 * @return the range of messagings
	 */
	@Override
	public List<Messaging> getMessagings(int start, int end) {
		return messagingPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of messagings.
	 *
	 * @return the number of messagings
	 */
	@Override
	public int getMessagingsCount() {
		return messagingPersistence.countAll();
	}

	/**
	 * Updates the messaging in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MessagingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param messaging the messaging
	 * @return the messaging that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Messaging updateMessaging(Messaging messaging) {
		return messagingPersistence.update(messaging);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			MessagingLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		messagingLocalService = (MessagingLocalService)aopProxy;

		_setLocalServiceUtilService(messagingLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return MessagingLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Messaging.class;
	}

	protected String getModelClassName() {
		return Messaging.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = messagingPersistence.getDataSource();

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

	private void _setLocalServiceUtilService(
		MessagingLocalService messagingLocalService) {

		try {
			Field field = MessagingLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, messagingLocalService);
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

	protected MessagingLocalService messagingLocalService;

	@Reference
	protected MessagingPersistence messagingPersistence;

	@Reference
	protected TransportPersistence transportPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		MessagingLocalServiceBaseImpl.class);

}