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
public class UtentiFactory {
 
    private static UtentiFactory user;
    public static UtentiFactory getInstance() {
        if (user == null) {
            user = new UtentiFactory();
        }
        return user;
    }
    
    //Liste
    private ArrayList<Utenti> listaClienti = new ArrayList<Utenti>();
    private ArrayList<Utenti> listaVenditori = new ArrayList<Utenti>();
    
    
    private UtentiFactory() {
        //CLIENTI
        
        Cliente cliente_1 = new Cliente();
        cliente_1.setCodice(1);
        cliente_1.setNome("Francesca");
        cliente_1.setCognome("Bacci");
        cliente_1.setUsername("FBacci");
        cliente_1.setPassword("uno");
        listaClienti.add(cliente_1);
        
        Cliente cliente_2 = new Cliente();
        cliente_2.setCodice(2);
        cliente_2.setNome("Mario");
        cliente_2.setCognome("Rossi");
        cliente_2.setUsername("MRossi");
        cliente_2.setPassword("due");
        listaClienti.add(cliente_2);
        
        Cliente cliente_3 = new Cliente();
        cliente_3.setCodice(3);
        cliente_3.setNome("Paolo");
        cliente_3.setCognome("Casula");
        cliente_3.setUsername("PCasula");
        cliente_3.setPassword("tre");
        listaClienti.add(cliente_3);
        
        //VENDITORI
        Venditore venditore_1 = new Venditore();
        venditore_1.setCodice(4);
        venditore_1.setNome("Marina");
        venditore_1.setCognome("Floris");
        venditore_1.setUsername("MFloris");
        venditore_1.setPassword("quattro");
        listaVenditori.add(venditore_1);
        
        Venditore venditore_2 = new Venditore();
        venditore_2.setCodice(5);
        venditore_2.setNome("Andrea");
        venditore_2.setCognome("Loi");
        venditore_2.setUsername("ALoi");
        venditore_2.setPassword("cinque");
        listaVenditori.add(venditore_2);
        
        Venditore venditore_3 = new Venditore();
        venditore_3.setCodice(6);
        venditore_3.setNome("Valerio");
        venditore_3.setCognome("Carta");
        venditore_3.setUsername("VCarta");
        venditore_3.setPassword("sei");
        listaVenditori.add(venditore_3);        
        
    }
    
    public ArrayList<Utenti> getBuyerList()
    {
        return listaClienti;
    }
    
    public ArrayList<Utenti> getSellerList()
    {
        return listaVenditori;
    }

    public ArrayList<Utenti> getUserList()
    {
        ArrayList<Utenti> listaUtenti = new ArrayList<Utenti>();
        
        listaUtenti.addAll(listaClienti);
        listaUtenti.addAll(listaVenditori);
        
        return listaUtenti;
    }
    
}
