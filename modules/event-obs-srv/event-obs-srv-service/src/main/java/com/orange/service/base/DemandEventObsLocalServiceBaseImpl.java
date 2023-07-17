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

import com.orange.model.DemandEventObs;
import com.orange.service.DemandEventObsLocalService;
import com.orange.service.DemandEventObsLocalServiceUtil;
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
 * Provides the base implementation for the demand event obs local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.orange.service.impl.DemandEventObsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.orange.service.impl.DemandEventObsLocalServiceImpl
 * @generated
 */
public abstract class DemandEventObsLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DemandEventObsLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DemandEventObsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DemandEventObsLocalServiceUtil</code>.
	 */

	/**
	 * Adds the demand event obs to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DemandEventObsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param demandEventObs the demand event obs
	 * @return the demand event obs that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DemandEventObs addDemandEventObs(DemandEventObs demandEventObs) {
		demandEventObs.setNew(true);

		return demandEventObsPersistence.update(demandEventObs);
	}

	/**
	 * Creates a new demand event obs with the primary key. Does not add the demand event obs to the database.
	 *
	 * @param idDemand the primary key for the new demand event obs
	 * @return the new demand event obs
	 */
	@Override
	@Transactional(enabled = false)
	public DemandEventObs createDemandEventObs(long idDemand) {
		return demandEventObsPersistence.create(idDemand);
	}

	/**
	 * Deletes the demand event obs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DemandEventObsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idDemand the primary key of the demand event obs
	 * @return the demand event obs that was removed
	 * @throws PortalException if a demand event obs with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DemandEventObs deleteDemandEventObs(long idDemand)
		throws PortalException {

		return demandEventObsPersistence.remove(idDemand);
	}

	/**
	 * Deletes the demand event obs from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DemandEventObsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param demandEventObs the demand event obs
	 * @return the demand event obs that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DemandEventObs deleteDemandEventObs(DemandEventObs demandEventObs) {
		return demandEventObsPersistence.remove(demandEventObs);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return demandEventObsPersistence.dslQuery(dslQuery);
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
			DemandEventObs.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return demandEventObsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.orange.model.impl.DemandEventObsModelImpl</code>.
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

		return demandEventObsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.orange.model.impl.DemandEventObsModelImpl</code>.
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

		return demandEventObsPersistence.findWithDynamicQuery(
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
		return demandEventObsPersistence.countWithDynamicQuery(dynamicQuery);
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

		return demandEventObsPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DemandEventObs fetchDemandEventObs(long idDemand) {
		return demandEventObsPersistence.fetchByPrimaryKey(idDemand);
	}

	/**
	 * Returns the demand event obs matching the UUID and group.
	 *
	 * @param uuid the demand event obs's UUID
	 * @param groupId the primary key of the group
	 * @return the matching demand event obs, or <code>null</code> if a matching demand event obs could not be found
	 */
	@Override
	public DemandEventObs fetchDemandEventObsByUuidAndGroupId(
		String uuid, long groupId) {

		return demandEventObsPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the demand event obs with the primary key.
	 *
	 * @param idDemand the primary key of the demand event obs
	 * @return the demand event obs
	 * @throws PortalException if a demand event obs with the primary key could not be found
	 */
	@Override
	public DemandEventObs getDemandEventObs(long idDemand)
		throws PortalException {

		return demandEventObsPersistence.findByPrimaryKey(idDemand);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(demandEventObsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DemandEventObs.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("idDemand");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			demandEventObsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(DemandEventObs.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("idDemand");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(demandEventObsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DemandEventObs.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("idDemand");
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
			new ActionableDynamicQuery.PerformActionMethod<DemandEventObs>() {

				@Override
				public void performAction(DemandEventObs demandEventObs)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, demandEventObs);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(DemandEventObs.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return demandEventObsPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement DemandEventObsLocalServiceImpl#deleteDemandEventObs(DemandEventObs) to avoid orphaned data");
		}

		return demandEventObsLocalService.deleteDemandEventObs(
			(DemandEventObs)persistedModel);
	}

	@Override
	public BasePersistence<DemandEventObs> getBasePersistence() {
		return demandEventObsPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return demandEventObsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the demand event obses matching the UUID and company.
	 *
	 * @param uuid the UUID of the demand event obses
	 * @param companyId the primary key of the company
	 * @return the matching demand event obses, or an empty list if no matches were found
	 */
	@Override
	public List<DemandEventObs> getDemandEventObsesByUuidAndCompanyId(
		String uuid, long companyId) {

		return demandEventObsPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of demand event obses matching the UUID and company.
	 *
	 * @param uuid the UUID of the demand event obses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of demand event obses
	 * @param end the upper bound of the range of demand event obses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching demand event obses, or an empty list if no matches were found
	 */
	@Override
	public List<DemandEventObs> getDemandEventObsesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DemandEventObs> orderByComparator) {

		return demandEventObsPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the demand event obs matching the UUID and group.
	 *
	 * @param uuid the demand event obs's UUID
	 * @param groupId the primary key of the group
	 * @return the matching demand event obs
	 * @throws PortalException if a matching demand event obs could not be found
	 */
	@Override
	public DemandEventObs getDemandEventObsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return demandEventObsPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the demand event obses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.orange.model.impl.DemandEventObsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demand event obses
	 * @param end the upper bound of the range of demand event obses (not inclusive)
	 * @return the range of demand event obses
	 */
	@Override
	public List<DemandEventObs> getDemandEventObses(int start, int end) {
		return demandEventObsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of demand event obses.
	 *
	 * @return the number of demand event obses
	 */
	@Override
	public int getDemandEventObsesCount() {
		return demandEventObsPersistence.countAll();
	}

	/**
	 * Updates the demand event obs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DemandEventObsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param demandEventObs the demand event obs
	 * @return the demand event obs that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DemandEventObs updateDemandEventObs(DemandEventObs demandEventObs) {
		return demandEventObsPersistence.update(demandEventObs);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DemandEventObsLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		demandEventObsLocalService = (DemandEventObsLocalService)aopProxy;

		_setLocalServiceUtilService(demandEventObsLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DemandEventObsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DemandEventObs.class;
	}

	protected String getModelClassName() {
		return DemandEventObs.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = demandEventObsPersistence.getDataSource();

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
		DemandEventObsLocalService demandEventObsLocalService) {

		try {
			Field field = DemandEventObsLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, demandEventObsLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ContactSupportPersistence contactSupportPersistence;

	protected DemandEventObsLocalService demandEventObsLocalService;

	@Reference
	protected DemandEventObsPersistence demandEventObsPersistence;

	@Reference
	protected EvenementObsPersistence evenementObsPersistence;

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
		DemandEventObsLocalServiceBaseImpl.class);

}