<%-- 
    Document   : descrizione
    Created on : 14-apr-2016, 16.18.32
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
        <title>Descrizione</title>
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
                <li class="currentp"><a href="descrizione.jsp">Descrizione</a></li>
                <li><a href="venditore.html">Venditore</a></li>
                <li><a href="cliente.html">Cliente</a></li>
            </ul>
        </div>        
        
        <jsp:include page="header.jsp" />
        
        <div class="page">
        
        <jsp:include page="sidebar.jsp" />  
        
        <!-- contenuto pagina -->
        <div class="content">
            
            <h1>Benvenuto sul sito!</h1>
        
        <!-- Indice -->
        <h2>Indice della pagina:</h2>
        <ol>
            <li><a href="#prod">Prodotti in vendita</a></li>
            <li><a href="#seller">Venditori</a></li>
            <li><a href="#buyer">Compratori</a></li>
        </ol>
        
        <!-- Paragrafi di descrizione -->

        <h2>Descrizione della pagina</h2>
        <h3 id="prod">Prodotti in vendita</h3>
        <p>
            I prodotti in vendita in questo sito sono principalmente DVD di film e serie TV, sia in versione normale che Blu-Ray. La scelta verrà fatta dall'utente compratore al momento dell'acquisto.<br />
            Per ogni prodotto verrà inserita un'immagine descrittiva, il prezzo e la quantità di pezzi disponibili, con la possibilità del cliente di aggiungere l'oggetto nel carrello.<br />
            Tutti i prodotti saranno divisi per genere e verrà fornita la trama di ogni singola serie/film.
        </p>

        <h3 id="seller">Venditori</h3>
        <p>
            Il venditore può inserire nuovi prodotti.<br />
            Ogni utente che si registrerà con l'intenzione di svolgere la funzione di venditore potrà mettere in vendita i propri prodotti o rimuoverli dal catalogo.<br />
            L'aggiunta di un nuovo prodotto sarà possibile mediante il form apposito, che richiede l'indicazione delle principali informazioni.<br />
            Saranno disponibili le funzioni necessarie al controllo degli ordini ricevuti e la possibilità di contattare i propri clienti in caso di problemi.<br>Sarà inoltre possibile controllare i pagamenti ricevuti ed inserire una propria descrizione.<br />
            Inoltre il venditore ha la possibilità di controllare il proprio saldo della moneta virtuale.
        </p>

        <h3 id="buyer">Compratori</h3>
        <p>
            Il compratore può acquistare prodotti sul sito.<br />
            Ogni utente che si registrerà con l'intenzione di svolgere la funzione di compratore avrà la possibilità di navigare nel catalogo, aggiungere uno o più prodotti d'interesse nel proprio carrello, effettuare degli ordini, e controllare gli ordini effettuati e il loro stato.<br />
            Potrà aggiornare le proprie informazioni personali e inserire le informazioni necessarie al pagamento degli ordini effettuati.<br />
            Il cliente potrà aggiornare il proprio saldo della moneta virtuale.
        </p>
        
        </div>
        
        </div>
        
    </body>

</html>

