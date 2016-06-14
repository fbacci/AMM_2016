/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneEcommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Francy
 */
public class OggettiFactory {
    
    private String connectionString;
    
    private static OggettiFactory object;
    public static OggettiFactory getInstance() {
        if (object == null) {
            object = new OggettiFactory();
        }
        return object;
    }
    
    private ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
    private ArrayList<Oggetto> listaObjCategory = new ArrayList<Oggetto>();
    
    private OggettiFactory(){
        
    }
    
    // Inserisce un nuovo oggetto
    public Oggetto creaOggetto(String titolo, String categoria, int quantita, int prezzo){
        
        Oggetto o = new Oggetto();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            PreparedStatement stmt = null;
            
            String query = "INSERT INTO oggetto " + "VALUES (default,?,?,?,?)";            
                  
            stmt = conn.prepareStatement(query);
            
            stmt.setString(1, titolo);
            stmt.setString(2, categoria);
            stmt.setInt(3, quantita);
            stmt.setInt(4, prezzo);
            
            int r = stmt.executeUpdate();
            
            if(r==1){
                System.out.println("Ok!");
                o.setTitolo(titolo);
                o.setCategoria(categoria);
                o.setQuantita(quantita);
                o.setPrezzo(prezzo);
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            
        }
        
        return o;
    }
    
    // Cancella un oggetto dato l'id
    public void cancellaOggetto(int id){
        
        try{
            
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "DELETE FROM oggetto" + "WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1,id);
           
            int r = stmt.executeUpdate();
            
            if(r==1){
                System.out.println("Ok!");
            }            
                       
        } catch(SQLException e){
            
        }
    }
    
    // Modifica un oggetto dato l'id
    public Oggetto modificaOggetto(int id, String titolo, String categoria, int prezzo, int quantita){
        
        Oggetto o = new Oggetto();
        
        try{
            
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "UPDATE oggetto SET titolo = ? categoria = ? prezzo = ? quantita = ? " + "WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1,titolo);
            stmt.setString(2,categoria);
            stmt.setInt(3,prezzo);
            stmt.setInt(4,quantita);
            stmt.setInt(5, id);
           
            int r = stmt.executeUpdate();
            
            if(r==1){
                System.out.println("Ok!");
                o.setTitolo(titolo);
                o.setCategoria(categoria);
                o.setQuantita(quantita);
                o.setPrezzo(prezzo);
            }            
                       
        } catch(SQLException e){
            
        }
        
        return o;
    }    
    
    public ArrayList<Oggetto> getObjectList()
    {
        ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "SELECT * FROM oggetto ";
            
            Statement stmt = conn.createStatement();
            
            ResultSet set = stmt.executeQuery(query);
            
            while(set.next()){
                Oggetto obj = new Oggetto();
                obj.setId(set.getInt("id"));
                obj.setTitolo(set.getString("titolo"));
                obj.setCategoria(set.getString("categoria"));
                obj.setQuantita(set.getInt("quantita"));
                obj.setPrezzo(set.getInt("prezzo"));
                listaOggetti.add(obj);
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return listaOggetti;
    }

public ArrayList<Oggetto> getObjectListbyTitle(String testo){
        ArrayList<Oggetto> listaOggetti = new ArrayList<Oggetto>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "SELECT * FROM oggetto WHERE " + "title = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1,testo);
            
            ResultSet set = stmt.executeQuery();
            
            while(set.next()){
                Oggetto obj = new Oggetto();
                obj.setId(set.getInt("id"));
                obj.setTitolo(set.getString("titolo"));
                obj.setCategoria(set.getString("categoria"));
                obj.setQuantita(set.getInt("quantita"));
                obj.setPrezzo(set.getInt("prezzo"));
                listaOggetti.add(obj);
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return listaOggetti;
    }    
    
    public ArrayList<Oggetto> getOggettoCategoria(String categoria){
        ArrayList<Oggetto> listaObjCategoria = new ArrayList<Oggetto>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "SELECT * FROM oggetto WHERE " + "categoria = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1,categoria);

            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                Oggetto obj = new Oggetto();
                obj.setId(set.getInt("id"));
                obj.setTitolo(set.getString("titolo"));
                obj.setCategoria(set.getString("categoria"));
                obj.setQuantita(set.getInt("quantita"));
                obj.setPrezzo(set.getInt("prezzo"));
                listaObjCategoria.add(obj);
                
                stmt.close();
                conn.close();
            }
            
        } catch(SQLException e){
            
        }
        
        return listaObjCategoria;
    }
    
    public int getObjIdbyTitolo(String titolo){
        
    int id = 0;
            
    try {
        Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
        String query = "SELECT id FROM oggetto WHERE titolo = ?";
            
        PreparedStatement stmt = conn.prepareStatement(query);
            
        stmt.setString(1, titolo);
            
        ResultSet set = stmt.executeQuery();
            
        if(set.next()){
            id = set.getInt("id");
        }
            
        stmt.close();
        conn.close();
    } catch(SQLException e){
            
    }
        
        return id;
    }
    
    public Oggetto getOggettoId(int id){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "SELECT * FROM oggetto " + "WHERE id = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1,id);

            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                Oggetto obj = new Oggetto();
                obj.setId(set.getInt("id"));
                obj.setTitolo(set.getString("titolo"));
                obj.setCategoria(set.getString("categoria"));
                obj.setQuantita(set.getInt("quantita"));
                obj.setPrezzo(set.getInt("prezzo"));
                
                stmt.close();
                conn.close();
                
                return obj;
            }
        } catch(SQLException e){
            
        }
        
        return null;
    }  
    
    public boolean compraVendita (String titolo, int prezzo, int idcl, int idv) throws SQLException{
        Boolean result = false;
        
        Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
        
        PreparedStatement rimuoviObj = null;
        PreparedStatement decrementaCl = null;
        PreparedStatement incrementaV = null;
        
        String cancella = "UPDATE FROM oggetto SET quantita = quantita - 1 WHERE " + "titolo = ? AND idvenditore = ?";
        String decrementa = "UPDATE saldo SET " + "saldo = saldo - ?" + "JOIN cliente ON saldo.id = cliente.idsaldo "+ 
                            "WHERE cliente.codice = ?";
        String incrementa = "UPDATE saldo SET " + "saldo = saldo - ?" + "JOIN venditore ON saldo.id = venditore.idsaldo "+ 
                            "WHERE venditore.codice = ?";
        
        try {
            conn.setAutoCommit(false);
            
            rimuoviObj = conn.prepareStatement(cancella);
            decrementaCl = conn.prepareStatement(decrementa);
            incrementaV = conn.prepareStatement(incrementa);
            
            rimuoviObj.setString(1,titolo);
            rimuoviObj.setInt(2, idv);
            
            decrementaCl.setInt(1,prezzo);
            decrementaCl.setInt(2,idcl);
            
            incrementaV.setInt(1,prezzo);
            incrementaV.setInt(2,idv);
            
            int q1 = rimuoviObj.executeUpdate();
            int q2 = decrementaCl.executeUpdate();
            int q3 = incrementaV.executeUpdate();
            
            if( q1 != 1 || q2 != 1 || q3 != 1){
                conn.rollback();
            } else {result = true;}
            
            conn.commit();
            
        } catch(SQLException e){
            try{
                conn.rollback();
            }catch(SQLException e2){
                
            }            
        } finally {
            if(rimuoviObj != null){
                rimuoviObj.close();
            }
            
            if(decrementaCl != null){
                decrementaCl.close();
            }
            
            if(incrementaV != null){
                incrementaV.close();
            }
            
            conn.setAutoCommit(true);
            conn.close();     
        }
        
        return result;
    }      
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }
}
