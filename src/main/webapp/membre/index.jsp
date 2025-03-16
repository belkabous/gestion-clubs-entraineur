<%@ page import="com.example.gestion_clubs.model.Membre" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>membre List</title>
</head>
<body>
<h2>List of Membres</h2>
<table border="1">
    <thead>
    <tr>
        <th>Nom</th>
        <th>Sport Pratiquee</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <% List<Membre> membres = (List<Membre>) request.getAttribute("membres");
        for (Membre membre : membres) { %>
    <tr>
        <td><%= membre.getNom_membre() %></td>
        <td><%= membre.getSport_pratiquee() %></td>
        <td>
            <a href="membres?action=edit&id=<%= membre.getId() %>">Edit</a>
            <a href="membre?action=delete&id=<%= membre.getId() %>">Delete</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<a href="MembreServlet?action=add">Add a new membre</a>
</body>
</html>