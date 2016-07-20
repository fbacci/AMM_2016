<%-- 
    Document   : login
    Created on : 14-apr-2016, 16.17.11
    Author     : Francy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Pagina di login</title>
        <meta charset="UTF-8">
        <meta name="keywords" content="ecommerce dvd, film, serie TV, dvd">
        <meta name="author" content="Francesca Bacci">
        <meta name="description" content="Vendita online di DVD">
        
        <!-- CSS -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen">
    </head>
    <body>
        
        <div class="menu">
            <ul>
                <li class="currentp"><a href="login.html">Login</a></li>
                <li><a href="descrizione.jsp">Descrizione</a></li>
                <li><a href="venditore.html">Venditore</a></li>
                <li><a href="cliente.html">Cliente</a></li>
            </ul>
        </div>       
        
        <jsp:include page="header.jsp" />
        
        <div class="page">
                            
        <jsp:include page="sidebar.jsp" />    
            
        <!-- contenuto pagina -->
        <div class="content">
        
        <!-- Form di login -->
        
        <c:if test="${errore != null}">
            <h2>Errore</h2>
            <div>Il login non è andato a buon fine, riprova.</div>
        </c:if>        
        
        <c:if test="${errore == null}">    
            <h2>Benvenuto, accedi al tuo profilo!</h2>
        </c:if>
        <form method="post" action="login.html" id="login">
            <div id="formlog">
                <label for="user" id="us">Username</label>
                <input type="text" name="Username" id="user"/>
                <label for="passw" id="pw">Password</label>
                <input type="password" name="Password" id="passw"/>
            </div>
            
            <br />
            
            <button type="submit" name="Submit">Accedi</button> <button type="reset">Cancella</button>
        </form>
        
        </div>
        
        </div>
    </body>
</html>