
<%@include file="init.jsp"%>

<liferay-ui:search-container emptyResultsMessage="There is no requests actually ">
    <liferay-ui:search-container-results results="${evenements}" />

    <liferay-ui:search-container-row className="com.orange.model.EvenementObs" modelVar="demand">
        <liferay-ui:search-container-column-text property="description"/>
        <liferay-ui:search-container-column-text property="startDate"/>
        <liferay-ui:search-container-column-text property="endDate"/>
        <liferay-ui:search-container-column-text property="entity"/>
        <liferay-ui:search-container-column-text property="nbrUserConfirmed"/>
        <liferay-ui:search-container-column-text property="lieu"/>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>

</liferay-ui:search-container>