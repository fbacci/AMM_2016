<%-- 
    Document   : listaOggetti_json
    Created on : 6-giu-2016, 15.49.01
    Author     : Francy
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="obj" items="${listaOggetti}">
        <json:object>
            <json:property name="titolo" value="${obj.titolo}"/>
            <json:property name="quantità" value="${obj.quantita}"/>
            <json:property name="prezzo" value="${obj.prezzo}"/>
        </json:object>
    </c:forEach>
</json:array>
