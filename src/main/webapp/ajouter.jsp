<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Membre</title>
</head>
<body>
<h2>Ajouter Nouvel Membre</h2>


<form action="MembreServlet" method="post">


    Title: <input type="text" name="nom_membre" required /><br />

    Sport pratiquee: <input type="text" name="sport_pratiquee" required /><br />

    <button type="submit"  > add </button>

</form>
</body>
</html>