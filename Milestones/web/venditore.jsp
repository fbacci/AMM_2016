<%-- 
    Document   : venditore
    Created on : 14-apr-2016, 16.18.15
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
        
        <h2>Inserimento di un nuovo prodotto</h2>
        
        <!-- Form nuovo prodotto -->
        
        <form method="post" action="venditore.html">
            <div>
                <label for="nomep" id="prname">Nome del prodotto</label>
                <input type="text" name="nomep" id="nomep">
                <label for="imm" id="primm">URL immagine</label>
                <input type="url" id="imm" name="imm">
                <label for="desc" id="prdesc">Descrizione</label>
                <textarea name="desc" id="desc" cols="40" rows="5">Descrizione dell'oggetto</textarea>
                <label for="prezzo" id="pr_prezzo">Prezzo (in €)</label>
                <input type="number" name="prezzo" id="prezzo">
                <label for="quant" id="prquant">Pezzi disponibili</label>
                <input type="number" name="quant" id="quant">
            </div>
            <br />
            <button type="submit" name="Invia">Inserisci</button> <button type="reset">Cancella</button>
        </form>
        </div>
        
        </div>
    </body>
</html>
