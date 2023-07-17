<%@ include file="init.jsp"%>
<div class="card">
    <h5 class="card-header">Actualités</h5>
    <div class="card-body">
<c:forEach var="event" items="${evenements}">
<h5 class="card-title">${event.description}</h5>
        <p class="card-text">${event.lieu} / ${event.startDate}</p>
        <a href="#" class="btn btn-primary"><liferay-ui:message key="participant.confirm"/></a>
</c:forEach>
    </div>
</div>
