<%@ include file="header.jsp" %>

<%  tp4.Entity.Sortie sortie = (tp4.Entity.Sortie)request.getAttribute("sortie");%>
<div class="row">
  <div class="col-md-6">
    <button type="button" class="btn btn-default">Modifier cette sortie</button>
    <div class="page-header">
      <h1>Sortie #<%= Integer.toString(sortie.id)%>: <%= sortie.title%><br><small>Organis&eacute; par <%= sortie.getOrganisateur().prenom%> <%= sortie.getOrganisateur().nom%></small></h1>
    </div>
  </div>
</div>

<div class="row">
  <div class="col-md-6">
    <div class="sortie-infos row">
      <div class="col-md-4"><span class="glyphicon glyphicon-time" aria-hidden="true"></span> <%= sortie.datetime%></div>
      <div class="col-md-2"><span class="glyphicon glyphicon-user" data-toggle="tooltip" data-placement="bottom" title="Nombre maximum" aria-hidden="true"></span> <%= Integer.toString(sortie.nbMax)%></div>
    </div>
    <div class="sortie-infos row">
      <div class="col-md-12"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> <%= sortie.adresse%></div>
    </div>
    <p style="margin-top: 20px;"><%= sortie.description%></p>
  </div>
  <div class="col-md-3">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">S'inscrire</h3>
      </div>
      <div class="panel-body">
        <form action="#">
          <div class="form-group">
            <label>Nombre d'invit&eacute;s</label>
            <input type="number" class="form-control" max="7" min="0" />
          </div>
          <input type="hidden" name="sortieId" />
          <button type="submit" class="btn btn-primary">Continuer &raquo;</button>
        </form>
        <hr />
        <h3><%= sortie.getParticipants().size()%> Personnes inscrites</h3>
        <ul>
        <% for (tp4.Entity.Membre participant : sortie.getParticipants()) {%>
          <li><%= participant.prenom%> <%= participant.nom%></li>
        <% }%>
        </ul>
      </div>
    </div>
  </div>
</div>


<div class="row">
  <div class="col-md-6">
    <form action="sortie?option=addcomment" method="POST">
      <div class="form-group">
        <p class="help-block">Ajouter un commentaire</p>
        <textarea class="form-control" name="text"></textarea>
      </div>
      <input type="hidden" name="idsort" value="<%= sortie.id%>" />
      <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
  </div>
</div>
<h2>Commentaires</h2>
<% for(tp4.Entity.Commentaire comment : sortie.getCommentaires()) {%>
<div class="row">
  <div class="col-md-6">
    <h4>Par <%= comment.getAuteur().prenom%> <%= comment.getAuteur().nom%><small> le <%= comment.date%></small></h4>
    <p><%= comment.text%></p>
    <hr />
  </div>
</div>
<%}%>

<%@ include file="footer.jsp" %>