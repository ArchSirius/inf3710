<%@ page import="java.util.*" %>
<%@ include file="header.jsp" %>

<% tp4.Entity.Sortie sortie = (tp4.Entity.Sortie)request.getAttribute("sortie");%>

    <h1>Nouvelle sortie</h1>

    <div class="col-md-6">
    <form action="sortie" method="POST">
      <div class="form-group">
        <label>Titre</label>
        <input type="text" class="form-control" value="<%= sortie.title%>" maxlength="80">
      </div>
      <div class="form-group">
        <label>Nombre maximal de participants</label>
        <input type="number" min="0" value="<%= Integer.toString(sortie.nbMax)%>" class="form-control">
      </div>
      <div class="form-group">
        <label>Date et heure</label>
        <input type="text" class="form-control" id="datetimepicker" value="<%= sortie.datetime%>" maxlength="19">
        <p class="help-block">Format: yyyy-mm-dd hh:ii:ss</p>
      </div>
      <div class="form-group">
        <label>Lieu de rendez-vous</label>
        <input type="text" class="form-control" value="<%= sortie.adresse%>" maxlength="80">
      </div>
      <div class="form-group">
        <label>Description</label>
        <textarea class="form-control"><%= sortie.description%></textarea>
      </div>
      <input type="hidden" name="id" value="<%= Integer.toString(sortie.id)%>" />
      <button type="submit" class="btn btn-primary">Créer</button>
    </form>
    </div>

<%@ include file="footer.jsp" %>