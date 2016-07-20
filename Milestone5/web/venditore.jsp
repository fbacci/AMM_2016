<%-- 
    Document   : venditore
    Created on : 14-apr-2016, 16.18.15
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
        <title>Venditore</title>
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
                <li><a href="login.html">Login</a></li>
                <li><a href="descrizione.jsp">Descrizione</a></li>
                <li class="currentp"><a href="venditore.html">Venditore</a></li>
                <li><a href="cliente.html">Cliente</a></li>
            </ul>
        </div> 
        
        <jsp:include page="header.jsp" />
        
        <div class="page">
                    
        <jsp:include page="sidebar.jsp" />  
        
        <!-- contenuto pagina -->
        <div class="content">
        
        <c:choose>
        <c:when test="${accesso.equals('No')}">
            <h2 id="product">Accesso negato!</h2>
            <div>Non hai i diritti per visualizzare questa pagina.</div>
        </c:when>    
        
        <c:otherwise>    
            <h2>Operazioni</h2>
            
            <h3>Inserisci</h3>
            <form method="post" action="venditore.html">
                <div>
                    <label for="nomep" id="prname">Nome del prodotto</label>
                    <input type="text" name="titolo" id="nomep" />
                    <label for="categoria" id="cat">Categoria</label>
                    <input type="text" id="categoria" name="categoria" />
                    <label for="prezzo" id="prezzo">Prezzo (in €)</label>
                    <input type="number" name="prezzo" id="prezzo" />
                    <label for="quantita" id="quant">Pezzi disponibili</label>
                    <input type="number" name="quantita" id="quantita" />
                </div>
                <br />
                <button type="submit" name="Invia">Inserisci</button> <button type="reset">Cancella</button>
            </form><br />
            
            <h3>Modifica</h3>
            <form method="post" action="venditore.html">
                <div>
                    <label for="id" id="id">Codice del prodotto</label>
                    <input type="number" name="id" id="id" />              
                    <label for="nomep" id="prname2">Nome del prodotto</label>
                    <input type="text" name="titolo" id="nomep" />
                    <label for="categoria" id="cat">Categoria</label>
                    <input type="text" id="categoria" name="categoria" />
                    <label for="prezzo" id="prezzo">Prezzo (in €)</label>
                    <input type="number" name="prezzo" id="prezzo" />
                    <label for="quantita" id="quant">Pezzi disponibili</label>
                    <input type="number" name="quantita" id="quantita" />
                </div>
                <br />
                <button type="submit" name="Edit">Modifica</button> <button type="reset">Cancella</button>
            </form>
        
            <h3>Cancella</h3>
            <form method="post" action="venditore.html">
                <div>
                    <label for="id" id="id">Codice del prodotto</label>
                    <input type="number" name="id" id="id" />
                </div>
                <br />
                <button type="submit" name="Elimina">Elimina</button> <button type="reset">Cancella</button>
            </form>            
        </c:otherwise>    
        </c:choose>    
        </div>
        
        </div>
    </body>
</html>
