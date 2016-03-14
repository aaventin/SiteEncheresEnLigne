<%-- 
    Document   : mes_encheres
    Created on : 14 mars 2016, 10:11:16
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
                Mes ench&egrave;res
                <br>
                <table>
                    <tr>
                        <td>
                            Article
                        </td>
                        
                        <td>
                            Prix de départ
                        </td>
                        <td>
                            Prix actuel
                        </td>
                        <td>
                            Dernier ench&eacute;risseur
                        </td>
                        <td>
                            Date de vente
                        </td>
                        <td>
                            Statut
                        </td>
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
                            ${article.dernierEncherisseur.login}  
                        </td>
                        <td>
                            ${article.dateVente}  
                        </td>
                        <td>
                            ${article.statutArticle}  
                        </td>

                        <c:if test="${article.dernierEncherisseur.login!=sessionScope.login && article.statutArticle=='Disponible'}">
                            <td>
                                <a href="encherir_servlet?idArticle=${article.id}"><input type="button" value="Ench&eacute;rir"></a>
                            </td>
                        </c:if>  
                        <c:if test="${article.statutArticle=='Remporté'}">
                            <td>
                                <a href="mode_paiement_servlet?idArticle=${article.id}"><input type="button" value="Payer"></a>
                            </td>
                        </c:if>  

                    </tr> 
                </c:forEach>
            </table>
        </div>

        <c:import url="_PIED.jsp"></c:import>  
    </body>
</html> 