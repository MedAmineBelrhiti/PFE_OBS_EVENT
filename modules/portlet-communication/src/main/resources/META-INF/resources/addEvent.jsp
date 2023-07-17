<%@include file="init.jsp"%>
<portlet:actionURL name="addEvent" var="addEventUrl" />
<div class="container">
  <main>
    <div class="col-md-7 col-lg-8">
      <h4 class="mb-3">Ajouter un evenement</h4>
      <aui:form action="<%=addEventUrl.toString()%>" name="addEvent" class="needs-validation" method="POST" onsubmit="validateDates()">
        <div class="row g-3">
          <div class="col-sm-6">
            <aui:input name="startDate" type="date" class="form-control">
              <aui:validator name="required"/>
            </aui:input>
          </div>
          <div class="col-sm-6">
            <aui:input name="endDate" type="date" class="form-control">
              <aui:validator name="required"/>
            </aui:input>
          </div>
          <div class="col-sm-6">
            <aui:input name="lieu" class="form-control">
              <aui:validator name="required"/>
            </aui:input>
          </div>
          <div class="col-sm-6">
            <aui:input name="description" class="form-control">
              <aui:validator name="required"/>
            </aui:input>
          </div>
          <div class="col-sm-6">
            <aui:input name="votingEndDate" type="date" class="form-control">
              <aui:validator name="required"/>
            </aui:input>
          </div>
          <div class="col-sm-6">
            <aui:input name="nbrUserMax" type="number" class="form-control">
              <aui:validator name="required"/>
            </aui:input>
          </div>
          <div class="col-sm-6">
            <aui:input name="entity"  class="form-control">
              <aui:validator name="required"/>
            </aui:input>
          </div>
          <div class="col-sm-6">
            <aui:input name="managerName" class="form-control">
              <aui:validator name="required"/>
            </aui:input>
          </div>
          <aui:button type="submit" name="" value="Soumettre" class="w-100 btn btn-primary btn-lg" />
        </div>
      </aui:form>
    </div>
  </main>
</div>
