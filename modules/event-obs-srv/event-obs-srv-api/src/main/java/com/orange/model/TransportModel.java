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
 * The base model interface for the Transport service. Represents a row in the &quot;OBS_Transport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.orange.model.impl.TransportModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.orange.model.impl.TransportImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Transport
 * @generated
 */
@ProviderType
public interface TransportModel
	extends BaseModel<Transport>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a transport model instance should use the {@link Transport} interface instead.
	 */

	/**
	 * Returns the primary key of this transport.
	 *
	 * @return the primary key of this transport
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this transport.
	 *
	 * @param primaryKey the primary key of this transport
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this transport.
	 *
	 * @return the uuid of this transport
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this transport.
	 *
	 * @param uuid the uuid of this transport
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the id transport of this transport.
	 *
	 * @return the id transport of this transport
	 */
	public long getIdTransport();

	/**
	 * Sets the id transport of this transport.
	 *
	 * @param idTransport the id transport of this transport
	 */
	public void setIdTransport(long idTransport);

	/**
	 * Returns the group ID of this transport.
	 *
	 * @return the group ID of this transport
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this transport.
	 *
	 * @param groupId the group ID of this transport
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this transport.
	 *
	 * @return the company ID of this transport
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this transport.
	 *
	 * @param companyId the company ID of this transport
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this transport.
	 *
	 * @return the create date of this transport
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this transport.
	 *
	 * @param createDate the create date of this transport
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this transport.
	 *
	 * @return the modified date of this transport
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this transport.
	 *
	 * @param modifiedDate the modified date of this transport
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the collec of this transport.
	 *
	 * @return the collec of this transport
	 */
	public boolean getCollec();

	/**
	 * Returns <code>true</code> if this transport is collec.
	 *
	 * @return <code>true</code> if this transport is collec; <code>false</code> otherwise
	 */
	public boolean isCollec();

	/**
	 * Sets whether this transport is collec.
	 *
	 * @param collec the collec of this transport
	 */
	public void setCollec(boolean collec);

	/**
	 * Returns the prive of this transport.
	 *
	 * @return the prive of this transport
	 */
	public boolean getPrive();

	/**
	 * Returns <code>true</code> if this transport is prive.
	 *
	 * @return <code>true</code> if this transport is prive; <code>false</code> otherwise
	 */
	public boolean isPrive();

	/**
	 * Sets whether this transport is prive.
	 *
	 * @param prive the prive of this transport
	 */
	public void setPrive(boolean prive);

	/**
	 * Returns the id event of this transport.
	 *
	 * @return the id event of this transport
	 */
	public long getIdEvent();

	/**
	 * Sets the id event of this transport.
	 *
	 * @param idEvent the id event of this transport
	 */
	public void setIdEvent(long idEvent);

	@Override
	public Transport cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}