<%@ include file="header.jsp" %>
<%@ page import="java.util.*" %>
<% List<tp4.Entity.Membre> membres = (List<tp4.Entity.Membre>)request.getAttribute("membres");%>
<% String currentPseudo = (String)request.getAttribute("currentPseudo");%>

  <h1>Changer de pseudo</h1>

  <div class="col-md-6">
    <form action="account" method="POST">
      <div class="form-group">
        <label>Pseudo</label>
        <select name="pseudo">
          <% for (tp4.Entity.Membre membre : membres) {%>
        	<option value="<%= membre.pseudo%>"<%= (currentPseudo.compareTo(membre.pseudo) == 0) ? " selected" : ""%>><%= membre.prenom%> <%= membre.nom%></option>
          <% }%>
        </select>
      </div>
      <input type="hidden" name="id" />
      <button type="submit" class="btn btn-primary">Changer</button>
    </form>
  </div>

<%@ include file="footer.jsp" %>