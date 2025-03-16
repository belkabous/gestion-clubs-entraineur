<%@ page import="com.example.gestion_clubs.model.Membre" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Membre</title>
</head>
<body>
<h2>Edit Membre</h2>
<% Membre membre= (Membre) request.getAttribute("edit"); %>
<form action="membres" method="post">
    <input type="hidden" name="action" value="update" />
    <input type="text" name="id" value="<%= membre.getId()  %>">
    Nom: <input type="text" name="nom_membre" value="<%=  membre.getNom_membre() %>"  /><br />
    sport pratiquee: <input type="text" name="sport_pratiquee" value="<%=  membre.getSport_pratiquee() %>"  /><br />

    <input type="submit" value="Update" />
</form>
</body>
</html>