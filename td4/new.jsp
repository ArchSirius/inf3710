<%@ page import="java.util.*" %>
<%@ include file="header.jsp" %>

    <h1>Nouvelle sortie</h1>

    <div class="col-md-6">
    <form action="sortie" method="POST">
      <div class="form-group">
        <label>Titre</label>
        <input type="text" class="form-control" maxlength="80">
      </div>
      <div class="form-group">
        <label>Nombre maximal de participants</label>
        <input type="number" min="0" class="form-control">
      </div>
      <div class="form-group">
        <label>Date et heure</label>
        <input type="text" class="form-control" id="datetimepicker" maxlength="19">
        <p class="help-block">Format: yyyy-mm-dd hh:ii:ss</p>
      </div>
      <div class="form-group">
        <label>Lieu de rendez-vous</label>
        <input type="text" class="form-control" maxlength="80">
      </div>
      <div class="form-group">
        <label>Description</label>
        <textarea class="form-control"></textarea>
      </div>
      <input type="hidden" name="id" />
      <button type="submit" class="btn btn-primary">Créer</button>
    </form>
    </div>

    <!--<%= request.getAttribute("message")%>
    <form name="equipe" action="equipe" method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="text" name="id" size="3" maxlength="3"></td>
        </tr>
        <tr>
            <td>Nom:</td>
            <td><input type="text" name="nom" size="30" maxlength="80"></td>
        </tr>
        <tr>
            <td>Pays:</td>
            <td>
                <select name="pays">
<%  /*List<String[]> pays = (List<String[]>)request.getAttribute("pays");
    ListIterator<String[]> iterator = pays.listIterator();
    while(iterator.hasNext()) {
        String[] monPays = iterator.next();%>
                    <option value="<%= monPays[0] %>"><%= monPays[1] %></option>
<%  }*/%>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
				<input type="submit" value="Insert" name="option">
				<input type="reset" value="Reset">
				<a href="equipe?option=list">Liste</a>
            </td>
        </tr>
    </table>
    </form>-->
<%@ include file="footer.jsp" %>