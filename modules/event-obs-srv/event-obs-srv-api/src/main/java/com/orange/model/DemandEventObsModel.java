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

package com.orange.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DemandEventObs service. Represents a row in the &quot;OBS_DemandEventObs&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.orange.model.impl.DemandEventObsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.orange.model.impl.DemandEventObsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DemandEventObs
 * @generated
 */
@ProviderType
public interface DemandEventObsModel
	extends BaseModel<DemandEventObs>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a demand event obs model instance should use the {@link DemandEventObs} interface instead.
	 */

	/**
	 * Returns the primary key of this demand event obs.
	 *
	 * @return the primary key of this demand event obs
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this demand event obs.
	 *
	 * @param primaryKey the primary key of this demand event obs
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this demand event obs.
	 *
	 * @return the uuid of this demand event obs
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this demand event obs.
	 *
	 * @param uuid the uuid of this demand event obs
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the id demand of this demand event obs.
	 *
	 * @return the id demand of this demand event obs
	 */
	public long getIdDemand();

	/**
	 * Sets the id demand of this demand event obs.
	 *
	 * @param idDemand the id demand of this demand event obs
	 */
	public void setIdDemand(long idDemand);

	/**
	 * Returns the group ID of this demand event obs.
	 *
	 * @return the group ID of this demand event obs
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this demand event obs.
	 *
	 * @param groupId the group ID of this demand event obs
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this demand event obs.
	 *
	 * @return the company ID of this demand event obs
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this demand event obs.
	 *
	 * @param companyId the company ID of this demand event obs
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this demand event obs.
	 *
	 * @return the create date of this demand event obs
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this demand event obs.
	 *
	 * @param createDate the create date of this demand event obs
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this demand event obs.
	 *
	 * @return the modified date of this demand event obs
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this demand event obs.
	 *
	 * @param modifiedDate the modified date of this demand event obs
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the content of this demand event obs.
	 *
	 * @return the content of this demand event obs
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this demand event obs.
	 *
	 * @param content the content of this demand event obs
	 */
	public void setContent(String content);

	/**
	 * Returns the status of this demand event obs.
	 *
	 * @return the status of this demand event obs
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this demand event obs.
	 *
	 * @param status the status of this demand event obs
	 */
	public void setStatus(String status);

	/**
	 * Returns the first name of this demand event obs.
	 *
	 * @return the first name of this demand event obs
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this demand event obs.
	 *
	 * @param firstName the first name of this demand event obs
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this demand event obs.
	 *
	 * @return the last name of this demand event obs
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this demand event obs.
	 *
	 * @param lastName the last name of this demand event obs
	 */
	public void setLastName(String lastName);

	@Override
	public DemandEventObs cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}