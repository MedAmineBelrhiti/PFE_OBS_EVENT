<%@include file="init.jsp"%>

<liferay-ui:search-container emptyResultsMessage="There is no reclamations actually ">
	<liferay-ui:search-container-results results="${reclamations}" />

	<liferay-ui:search-container-row className="com.orange.model.ContactSupport" modelVar="reclmation">
		<liferay-ui:search-container-column-text property="nom"/>
		<liferay-ui:search-container-column-text property="prenom"/>
		<liferay-ui:search-container-column-text property="entite"/>
		<liferay-ui:search-container-column-text property="objet"/>
		<liferay-ui:search-container-column-text property="email"/>
		<liferay-ui:search-container-column-text property="objet"/>
		<liferay-ui:search-container-column-text property="telephone"/>
		<liferay-ui:search-container-column-text property="message"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>

</liferay-ui:search-container>


	<h2 class="pb-2 border-bottom">Liste Users</h2>
<liferay-ui:search-container emptyResultsMessage="There is no users actually ">
	<liferay-ui:search-container-results results="${users}" />

	<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User">
		<liferay-ui:search-container-column-text property="fullName"/>
		<liferay-ui:search-container-column-text property="emailAddress"/>
		<liferay-ui:search-container-column-text property="roles"/>
		<liferay-ui:search-container-column-text property="createDate"/>
		<liferay-ui:search-container-column-text property="group"/>
		<liferay-ui:search-container-column-text property="phones"/>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>

</liferay-ui:search-container>