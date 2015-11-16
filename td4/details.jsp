<%@ include file="header.jsp" %>

<%  tp4.Entity.Sortie sortie = (tp4.Entity.Sortie)request.getAttribute("sortie");%>
<div class="row">
  <div class="col-md-6">
    <button type="button" class="btn btn-default">Modifier cette sortie</button>
    <div class="page-header">
      <h1>Sortie #<%= Integer.toString(sortie.id)%>: <%= sortie.title%></h1>
    </div>
  </div>
</div>

<div class="row">
  <div class="col-md-6">
    <div class="sortie-infos row">
      <div class="col-md-4"><span class="glyphicon glyphicon-time" aria-hidden="true"></span> <%= sortie.datetime%></div>
      <div class="col-md-2"><span class="glyphicon glyphicon-user" data-toggle="tooltip" data-placement="bottom" title="Nombre maximum" aria-hidden="true"></span> 8</div>
    </div>
    <div class="sortie-infos row">
      <div class="col-md-12"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> Dongeon du corp pendue, rue St-Denis, Montréal</div>
    </div>
    <p style="margin-top: 20px;">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam in tellus a libero pulvinar viverra. Integer fermentum eget leo in finibus. Sed bibendum metus in porta fermentum. Nunc interdum aliquam convallis. Aliquam tincidunt finibus luctus. Cras vehicula convallis porttitor. Sed ac massa sollicitudin magna sagittis ultrices vitae eu turpis. Donec dui sapien, vestibulum ut aliquet nec, pulvinar ac odio. Nullam sed vehicula neque, in congue odio. Nam dapibus dolor nunc, vulputate lobortis elit varius vel. Curabitur mollis, nisl at pharetra ornare, risus risus pulvinar urna, non lacinia nulla massa et felis. Maecenas nec lorem dapibus, commodo neque et, consectetur libero. Nunc sit amet viverra lacus. Praesent felis nulla, pulvinar eget velit sit amet, tincidunt scelerisque erat. Proin dapibus pharetra arcu, et luctus nunc eleifend vel. In condimentum dui ante, ac semper orci interdum vel.</p>
  </div>
  <div class="col-md-3">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">S'inscrire</h3>
      </div>
      <div class="panel-body">
        <form action="#">
          <div class="form-group">
            <label>Nombre d'invités</label>
            <input type="number" class="form-control" max="7" min="0" />
          </div>
          <input type="hidden" name="sortieId" />
          <button type="submit" class="btn btn-primary">Continuer &raquo;</button>
        </form>
        <hr />
        <h3>3 Personnes inscrites</h3>
        <ul>
          <li>Jean Jacques</li>
          <li>Louis Racicot</li>
          <li>Franchesca</li>
        </ul>
      </div>
    </div>
  </div>
</div>


<div class="row">
  <div class="col-md-6">
    <form action="comment" method="POST">
      <div class="form-group">
        <p class="help-block">Ajouter un commentaire</p>
        <textarea class="form-control"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
  </div>
</div>

<%@ include file="footer.jsp" %>