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
        
        <!-- CONTROLLI -->
        <c:choose>
            <c:when test="${accesso.equals('No')}">
                <h2 id="product">Accesso negato!</h2>
                <div>Non hai i diritti per visualizzare questa pagina.</div>
            </c:when>    
                
            <c:when test="${accesso.equals('Ok')}">
                <h2 id="product">Prodotti in vendita</h2>
                
                <label for="q">Filtra:</label> <input type="text" id="q" />
                <p id="messaggio"></p>

                <table>
                    <tr>
                        <th>Codice</th>
                        <th>Nome</th>
                        <th>Quantità</th>
                        <th>Prezzo</th>
                        <th>Acquista</th>
                    </tr>
                    <c:forEach var="obj" items="${oggetti}">
                    <tr id="obj_row">
                        <td>${obj.id}</td>
                        <td class="titolo">${obj.titolo}</td>
                        <td class="pq">${obj.quantita}</td>
                        <td class="pq">${obj.prezzo}</td>
                        <td class="add"><form action="cliente.html">
                                        <input type="hidden" name="obj" value="${obj.titolo}" />
                                        <button type="submit" name="compra"><span class="add2cart"></span></button>
                                        </form></td>
                    </tr>
                    </c:forEach>
                </table>
            </c:when>
                
            <c:when test="${accesso.equals('buying')}">
                <h2>Riepilogo oggetto</h2>
        
                <ul>
                    <li>Nome prodotto: ${titolo}</li>
                    <li>Prezzo: ${prezzo}</li>
                    <li>Quantita: ${quantita}</li>
                </ul>

                <form action="cliente.html">
                    <input type="hidden" name="objprice" value="${prezzo}" />  
                    <input type="hidden" name="objtitle" value="${titolo}" />
                    <button type="submit" name="conferma">Conferma</button>
                </form>
            </c:when>
                
            <c:when test="${esito.equals('good')}">
                <h2>Esito acquisto</h2>
                <div>Acquisto effettuato con successo!</div>               
            </c:when>

            <c:when test="${esito.equals('notgood')}">
                <h2>Esito acquisto</h2>
                <div>Acquisto non effettuato, saldo insufficiente!</div>               
            </c:when>                
        </c:choose>
                     
        </div>
        
        </div>
        
    </body>
</html>
