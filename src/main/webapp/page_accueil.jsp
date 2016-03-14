<%-- 
    Document   : page_accueil
    Created on : 11 mars 2016, 09:19:29
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
        
        <div class="bienvenue">
            Bienvenue sur MesEnch&egrave;res.com!
        </div>
        <div class="contenu">
            Connexion
            <form action="connexion_servlet" method="post">
                <input type="text" name="login">
                <input type="password" name="mdp">
                <input type="submit" value="connexion">
            </form>
            <br>
            Pas encore membre? <a href="inscription.jsp">Inscription par ici</a>
        </div>
        
        <c:import url="_PIED.jsp"></c:import>  
     </body>
</html>      

