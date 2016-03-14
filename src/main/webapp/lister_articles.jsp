<%-- 
    Document   : encheres
    Created on : 10 mars 2016, 16:09:27
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
            <%-- 
       Menu déroulant pour choix catégorie
            --%>
            <form action="lister_articles_servlet" method="get">
                <label>Categorie :</label>
                <select name="categorie">
                    <c:forEach items="${categories}" var="categorie">
                        <option value=${categorie.id}>${categorie.nom}</option> 
                    </c:forEach>               
                </select>
                <input type="submit" value="trouver articles">
            </form>
            <br>
            <%-- 
            Résultat de la recherche
            --%>
            <table>
                <tr>
                    <td>Vendeur</td>
                    <td>Article</td>
                    <td>Prix actuel</td>
                    <td>Date de vente</td>
                </tr>
                <c:forEach items="${articles}" var="article">
                    <tr>
                        <td>
                            ${article.utilisateur.login}   
                        </td>
                        <td>
                            ${article.nom}   
                        </td>
                        <td>
                            ${article.prixActuel}   
                        </td>
                        <td>
                            ${article.dateVente}                       
                        </td>    
                        <td>
                            <c:if test="${article.utilisateur.login!=sessionScope.login}">                                
                                <c:if test="${article.dernierEncherisseur.login!=sessionScope.login}">
                                    <a href="encherir_servlet?idArticle=${article.id}"><input type="button" value="Ench&eacute;rir"></a>     
                                    </c:if>   
                                </c:if>

                        </td>
                    </tr>                 
                </c:forEach>
            </table>
        </div>

        <c:import url="_PIED.jsp"></c:import>  
    </body>
</html>      

