<%@ page import="com.example.documentsmanager.DbManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //Description et titre dans des listes
    Class.forName("com.mysql.jdbc.Driver");
    ArrayList<String > ListDescription=new ArrayList<String>();
    ArrayList<String> ListTitre= new ArrayList<String>();
    DbManager manager= new DbManager();

    try{
        String requete = "SELECT * FROM Rubrique";
        Connection c = manager.getConnection();
        Statement stm = c.createStatement();
        ResultSet result = stm.executeQuery(requete);
        while(result.next()){
            ListTitre.add(result.getString(2));
            ListDescription.add(result.getString(3));
        }
    }
    catch (SQLException e){
        e.getMessage();
    }
%>
<html>
<head>
    <title>Documentation</title>
    <link rel="stylesheet" href="style.css">
    <p>betterJSP</p>
    <script type="text/javascript">
    </script>
</head>


<body>
<div id="globalDiv">
    <div id="titre">
        <ul id="listTitres">
        <%
            for (String s: ListTitre
            ) {
                out.println("<li >"+s+"</li>");

            }
        %>
        </ul>

    </div>
    <div id="description">
        <ul id="listDescriptions">
        <%
            for (String s: ListDescription
                 ) {
                out.println("<li>"+s+"</li>");

            }
        %>
        </ul>
    </div>
    <div id="divcurrentdescription">
        <p id="currentDescription"> currentDescription</p>

    </div>

</div>
<div id="formInsert">
    <form action="doc" method="get">
        <input type="text" id="newTitre" name="newtitle">
        <input type="text" id="newDescription" name="newdesc">
        <button type="submit">Ajouter documentation </button>
    </form>
</div>
<script type="text/javascript" src ="script.js"></script>
</body>
</html>