<%@ include file="header.jsp" %>

  <h1>Changer de pseudo</h1>

  <div class="col-md-6">
    <form action="account" method="POST">
      <div class="form-group">
        <label>Pseudo</label>
        <select>
        	<option value="pedro">Pedro</option>
        </select>
      </div>
      <input type="hidden" name="id" />
      <button type="submit" class="btn btn-primary">Changer</button>
    </form>
  </div>

<%@ include file="footer.jsp" %>