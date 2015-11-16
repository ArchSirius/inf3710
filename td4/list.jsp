<%@ page import="java.util.*" %>
<%@ include file="header.jsp" %>

<%  Set<String> dates = (Set<String>)request.getAttribute("dates");
    for (String date : dates) {%>
<div class="row">
    <div class="col-md-9">
        <h3><%= date%></h3>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th style="width: 20%">Heure</th>
                    <th style="width: 50%">Titre</th>
                    <th style="width: 30%">Organisateur</th>
                </tr>
            </thead>
            <tbody>
            <%  Map<String,List<tp4.Entity.Sortie>> sorties = (Map<String,List<tp4.Entity.Sortie>>)request.getAttribute("sorties");
                for (tp4.Entity.Sortie sortie : sorties.get(date)) {%>
                <tr>
                    <td><a href="sortie?option=details&id=<%= sortie.id%>"><%= sortie.getTime()%></a></td>
                    <td><a href="sortie?option=details&id=<%= sortie.id%>"><%= sortie.title%></a></td>
                    <td><a href="sortie?option=details&id=<%= sortie.id%>"><%= sortie.getOrganisateur().prenom%> <%= sortie.getOrganisateur().nom%></a></td>
                </tr>
            <%  }%>
            </tbody>
        </table>
    </div>
</div>
<%  }%>

<%@ include file="footer.jsp" %>
