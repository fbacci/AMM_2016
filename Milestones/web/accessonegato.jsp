<%-- 
    Document   : accessonegato
    Created on : 27-apr-2016, 9.56.34
    Author     : Francy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Accesso negato</title>
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
        
        <h2>Accesso negato</h2>
        
        <p>Non hai i diritti necessari per visualizzare questa pagina.</p>
        
        </div>
        
        </div>
    </body>
</html>
