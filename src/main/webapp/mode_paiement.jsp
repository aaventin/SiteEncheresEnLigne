<%-- 
    Document   : mode_paiement
    Created on : 14 mars 2016, 12:23:02
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
            Choix du mode de paiement
            <br>
            <br>
            <a href="payer_payPal_servlet?idArticle=${idArticle}"><img src="Images/PayPal.png" alt=""/></a>
            
            <a href="payer_cb_servlet?idArticle=${idArticle}"><img src="Images/CB.jpg" alt=""/></a>
            
        </div>
        
        <c:import url="_PIED.jsp"></c:import>  
     </body>
</html>      
