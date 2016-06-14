<%-- 
    Document   : cliente
    Created on : 14-apr-2016, 16.17.59
    Author     : Francy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="keywords" content="ecommerce dvd, film, serie TV, dvd">
        <meta name="author" content="Francesca Bacci">
        <meta name="description" content="Vendita online di DVD">
        
        <!-- CSS -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen">
        
        <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/filtro.js"></script>
    </head>
    
    <body>
        
        <div class="menu">
            <ul>
                <li><a href="login.html">Login</a></li>
                <li><a href="descrizione.jsp">Descrizione</a></li>
                <li><a href="venditore.html">Venditore</a></li>
                <li class="currentp"><a href="cliente.html">Cliente</a></li>
            </ul>
        </div> 

        <jsp:include page="header.jsp" />
        
        <div class="page">
                
        <jsp:include page="sidebar.jsp" />  
        
        <!-- contenuto pagina -->
        <div class="content">
        
        <h2 id="product">Prodotti in vendita</h2>
        
        <label for="q">Filtra:</label> <input type="text" id="q">
        
        <p id="messaggio"></p>
        
        <!-- Tabella prodotti -->
             
        <table>
            <tr>
                <th>Nome</th>
                <th>Quantità</th>
                <th>Prezzo</th>
                <th>Acquista</th>
            </tr>
            <c:forEach var="obj" items="${oggetti}">
            <tr id="obj_row">
                <td class="titolo">${obj.titolo}</td>
                <td class="pq">${obj.quantita}</td>
                <td class="pq">${obj.prezzo}</td>
                <td class="add"><a href="cliente.html?titolo=${obj.titolo}">Aggiungi al carrello</a></td>
            </tr>
            </c:forEach>
        </table>
        
        </div>
        
        </div>
        
    </body>
</html>
