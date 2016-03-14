<%-- 
    Document   : AjouterArticleServlet
    Created on : 11 mars 2016, 13:20:53
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="_CSS.jsp"></c:import>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>MesEncheres.com</title>
        </head>
        <body>
        <c:import url="_ONGLETPERSO.jsp"></c:import>
        <c:import url="_TITRE.jsp"></c:import>
        <c:import url="_MENU.jsp"></c:import>        

            <div class="contenu">
                <form action="ajouter_article_servlet" method="post">
                    <label>Nom :</label>
                    <input type="text" name="nom">                    
                    <br> <label>Categorie :</label>
                    <select name="categorie">
                    <c:forEach items="${categories}" var="categorie">
                        <option value=${categorie.id}>${categorie.nom}</option> 
                    </c:forEach>               
                    </select>
                    <br> <label>Prix de départ :</label>
                    <input type="text" name="prixDepart">
                    <br> <input type="submit" value="Créer article">
            </form>
        </div>

        <c:import url="_PIED.jsp"></c:import>  
    </body>
</html> 
