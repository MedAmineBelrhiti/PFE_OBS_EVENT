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
 * The base model interface for the ContactSupport service. Represents a row in the &quot;OBS_ContactSupport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.orange.model.impl.ContactSupportModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.orange.model.impl.ContactSupportImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactSupport
 * @generated
 */
@ProviderType
public interface ContactSupportModel
	extends BaseModel<ContactSupport>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a contact support model instance should use the {@link ContactSupport} interface instead.
	 */

	/**
	 * Returns the primary key of this contact support.
	 *
	 * @return the primary key of this contact support
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this contact support.
	 *
	 * @param primaryKey the primary key of this contact support
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this contact support.
	 *
	 * @return the uuid of this contact support
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this contact support.
	 *
	 * @param uuid the uuid of this contact support
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the id message of this contact support.
	 *
	 * @return the id message of this contact support
	 */
	public long getIdMessage();

	/**
	 * Sets the id message of this contact support.
	 *
	 * @param idMessage the id message of this contact support
	 */
	public void setIdMessage(long idMessage);

	/**
	 * Returns the group ID of this contact support.
	 *
	 * @return the group ID of this contact support
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this contact support.
	 *
	 * @param groupId the group ID of this contact support
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this contact support.
	 *
	 * @return the company ID of this contact support
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this contact support.
	 *
	 * @param companyId the company ID of this contact support
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this contact support.
	 *
	 * @return the create date of this contact support
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this contact support.
	 *
	 * @param createDate the create date of this contact support
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this contact support.
	 *
	 * @return the modified date of this contact support
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this contact support.
	 *
	 * @param modifiedDate the modified date of this contact support
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the nom of this contact support.
	 *
	 * @return the nom of this contact support
	 */
	@AutoEscape
	public String getNom();

	/**
	 * Sets the nom of this contact support.
	 *
	 * @param nom the nom of this contact support
	 */
	public void setNom(String nom);

	/**
	 * Returns the prenom of this contact support.
	 *
	 * @return the prenom of this contact support
	 */
	@AutoEscape
	public String getPrenom();

	/**
	 * Sets the prenom of this contact support.
	 *
	 * @param prenom the prenom of this contact support
	 */
	public void setPrenom(String prenom);

	/**
	 * Returns the entite of this contact support.
	 *
	 * @return the entite of this contact support
	 */
	@AutoEscape
	public String getEntite();

	/**
	 * Sets the entite of this contact support.
	 *
	 * @param entite the entite of this contact support
	 */
	public void setEntite(String entite);

	/**
	 * Returns the objet of this contact support.
	 *
	 * @return the objet of this contact support
	 */
	@AutoEscape
	public String getObjet();

	/**
	 * Sets the objet of this contact support.
	 *
	 * @param objet the objet of this contact support
	 */
	public void setObjet(String objet);

	/**
	 * Returns the email of this contact support.
	 *
	 * @return the email of this contact support
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this contact support.
	 *
	 * @param email the email of this contact support
	 */
	public void setEmail(String email);

	/**
	 * Returns the telephone of this contact support.
	 *
	 * @return the telephone of this contact support
	 */
	@AutoEscape
	public String getTelephone();

	/**
	 * Sets the telephone of this contact support.
	 *
	 * @param telephone the telephone of this contact support
	 */
	public void setTelephone(String telephone);

	/**
	 * Returns the message of this contact support.
	 *
	 * @return the message of this contact support
	 */
	@AutoEscape
	public String getMessage();

	/**
	 * Sets the message of this contact support.
	 *
	 * @param message the message of this contact support
	 */
	public void setMessage(String message);

	@Override
	public ContactSupport cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}