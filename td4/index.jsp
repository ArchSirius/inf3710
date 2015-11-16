<%@ include file="header.jsp" %>
  <div class="jumbotron">
    <h1>Menu principal</h1>
    <p>Vous vouvez ici gérer les sorties et votre compte</p>
    <p>
      <a class="btn btn-lg btn-primary" href="sortie?option=new" role="button">Créer une nouvelle sortie</a>
      <a class="btn btn-lg btn-primary" href="sortie?option=list" role="button">Liste des sorties à venir</a>
      <a class="btn btn-lg btn-primary" href="account" role="button">Changer le pseudo de l'utilisateur courant</a>
    </p>
  </div>
<%@ include file="footer.jsp" %>