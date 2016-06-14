/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function ()
{
   $("#q").keyup(function()
    {  
        // Preleva il valore
        var q = $("#q").val();
       
        $.ajax(
        {
            url: "filter.json",
            data:{
              cmd: "cerca",
              text: q
            },
            dataType: 'json',
            success : function(data, state){
                updateList(data);
            },
            error : function(data, state){
            }
        });
    });
});

function updateList(listaOggetti){
    
    if(listaOggetti.isEmpty()){
        var msg = document.createTextNode("L'oggetto non disponibile nel catalogo.");
        $("messaggio").append(msg);
    } else {
            $("#obj_row").empty();

            for(var obj in listaOggetti){
                var newtd1 = document.createElement("td");
                var newtd2 = document.createElement("td");
                var newtd3 = document.createElement("td");
                var newtd4 = document.createElement("td");
                var addcart = document.createElement("a");

                newtd1.setAttribute("titolo", obj.titolo);
                newtd2.setAttribute("quantita", obj.quantita);
                newtd3.setAttribute("prezzo", obj.prezzo);
                addcart.setAttribute("href","cliente.html?titolo=" + listaOggetti[obj].titolo);

                var title = document.createTextNode(listaOggetti[obj].titolo);
                var quantity = document.createTextNode(listaOggetti[obj].quantita);
                var price = document.createTextNode(listaOggetti[obj].prezzo);
                var add = document.createTextNode("Aggiungi al carrello");

                addcart.appendChild(add);

                newtd1.appendChild(title);
                newtd2.appendChild(quantity);
                newtd3.appendChild(price);
                newtd4.appendChild(addcart);

                $("#obj_row").append(newtd1);
                $("#obj_row").append(newtd2);
                $("#obj_row").append(newtd3);
                $("#obj_row").append(newtd4);
            }
            }
}