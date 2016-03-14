<%-- 
    Document   : payer_CB
    Created on : 14 mars 2016, 15:02:00
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
            <form action="payer_CB_servlet" method="post">
                <input type="hidden" name="idArticle" value="${idArticle}">
            <label>Type de carte</label>
            <select>
                <option>Visa</option>
                <option>Master Card</option>
            </select>
            <br> <label>Nom du titulaire</label>
            <input type="text">
            <br> <label>Adresse</label>
            <textarea></textarea>
            <br> <label>N°CB</label>
            <input type="text">
            <br> <label>Date d'expiration</label>
            <input type="number">
            <br>
            <input type="submit" value="Valider paiement">            
            </form>
        </div>
        
        <c:import url="_PIED.jsp"></c:import>  
     </body>
</html>    
