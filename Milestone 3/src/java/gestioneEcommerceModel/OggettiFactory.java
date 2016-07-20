/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneEcommerceModel;

import java.util.ArrayList;

/**
 *
 * @author Francy
 */
public class OggettiFactory {
    
    private static OggettiFactory object;
    public static OggettiFactory getInstance() {
        if (object == null) {
            object = new OggettiFactory();
        }
        return object;
    }
    
    private ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
    
    private OggettiFactory(){
        Oggetto oggetto_1 = new Oggetto();
        oggetto_1.setId(1);
        oggetto_1.setTitolo("The Imitation Game");
        oggetto_1.setCategoria("Drammatico","Storico");
        oggetto_1.setQuantita(50);
        oggetto_1.setPrezzo(20);
        listaOggetti.add(oggetto_1); 
        
        Oggetto oggetto_2 = new Oggetto();
        oggetto_2.setId(2);
        oggetto_2.setTitolo("Frozen");
        oggetto_2.setCategoria("Animazione","Commedia");
        oggetto_2.setQuantita(50);
        oggetto_2.setPrezzo(16);
        listaOggetti.add(oggetto_2); 
        
        Oggetto oggetto_3 = new Oggetto();
        oggetto_3.setId(3);
        oggetto_3.setTitolo("Sherlock - Prime 3 stagioni");
        oggetto_3.setCategoria("Drammatico","Giallo");
        oggetto_3.setQuantita(30);
        oggetto_3.setPrezzo(25);
        listaOggetti.add(oggetto_3);  
        
        Oggetto oggetto_4 = new Oggetto();
        oggetto_4.setId(4);
        oggetto_4.setTitolo("Pirati dei Caraibi: La maledizione della prima luna");
        oggetto_4.setCategoria("Commedia","Avventura");
        oggetto_4.setQuantita(25);
        oggetto_4.setPrezzo(10);
        listaOggetti.add(oggetto_4); 
        
        Oggetto oggetto_5 = new Oggetto();
        oggetto_5.setId(5);
        oggetto_5.setTitolo("Il discorso del Re");
        oggetto_5.setCategoria("Storico","Drammatico");
        oggetto_5.setQuantita(55);
        oggetto_5.setPrezzo(14);
        listaOggetti.add(oggetto_5);        
    }
    
    public ArrayList<Oggetto> getObjectList()
    {
        return listaOggetti;
    }
    
    public Oggetto getOggetto(String categoria1, String categoria2){ 
        for (Oggetto o : listaOggetti){
            if(o.categoria.equals(categoria1) || o.categoria.equals(categoria2)){
                return o;
            }
        }
    
        return null;
    }
    
    public Oggetto getOggettoId(int id){
        for (Oggetto o : listaOggetti){
            if(o.id == id){
                return o;
            }
        }
        
        return null;
    }
    
}
