<%-- 
    Document   : _ONGLETPERSO
    Created on : 11 mars 2016, 09:22:41
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="ongletPerso">
    <c:if test="${sessionScope['login']!=null}">
     Bonjour ${sessionScope['login']}
     <a href="mes_encheres_servlet"><input type="button" value="Mes enchères"></a>
     <a href="mes_articles_servlet"><input type="button" value="Mes ventes"></a>
    </c:if>     
</div>