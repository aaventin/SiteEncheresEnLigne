<%-- 
    Document   : mes_articles
    Created on : 11 mars 2016, 12:22:14
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
                Mes articles <a href="ajouter_article_servlet"><input type="button" value="Ajouter article"></a>
                <table>
                    <tr>                
                        <td>Article</td>
                        <td>Prix de d&aacute;part</td>
                        <td>Prix actuel</td>
                        <td>Date de vente</td>
                        <td>Statut</td>
                    </tr>
                <c:forEach items="${articles}" var="article">
                    <tr>                    
                        <td>
                            ${article.nom}   
                        </td>
                        <td>
                            ${article.prixDepart}   
                        </td>
                        <td>
                            ${article.prixActuel}   
                        </td>
                        <td>
                            ${article.dateVente}  
                        </td>
                        <td>
                            ${article.statutArticle}  
                        </td>
                    </tr>                 
                </c:forEach>
            </table>
        </div>

        <c:import url="_PIED.jsp"></c:import>  
    </body>
</html>      

