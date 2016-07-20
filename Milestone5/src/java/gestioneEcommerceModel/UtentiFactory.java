/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneEcommerceModel;

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
public class UtentiFactory {
    
    private String connectionString;
 
    private static UtentiFactory user;
    public static UtentiFactory getInstance() {
        if (user == null) {
            user = new UtentiFactory();
        }
        return user;
    }

    private UtentiFactory() {     
        
    }
    
    public Utenti getBuyer(String username, String password){
        try {
            
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "SELECT * FROM cliente WHERE username = ? AND password = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1,username);
            stmt.setString(2,password);
            
            ResultSet set = stmt.executeQuery();
            
            Cliente buyer = new Cliente();
            
            if(set.next()){
                buyer.codice = set.getInt("codice");
                buyer.nome = set.getString("nome");
                buyer.cognome = set.getString("cognome");
                buyer.username = set.getString("username");
                buyer.password = set.getString("password");
                
                stmt.close();
                conn.close();
            }
            
            return buyer;

        } catch(SQLException e){
         return null;   
        }   
    }
    
    public Utenti getSeller (String username, String password){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");

            String query = "SELECT * FROM venditore WHERE " + "username = ? AND password = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,username);
            stmt.setString(2,password);

            ResultSet set = stmt.executeQuery();

            if(set.next()){
                Venditore seller = new Venditore();
                seller.codice = set.getInt("codice");
                seller.nome = set.getString("nome");
                seller.cognome = set.getString("cognome");
                seller.username = set.getString("username");
                seller.password = set.getString("password");
                
                stmt.close();
                conn.close();
                
                return seller;                
            }
        } catch(SQLException e){
            
        }
        
        return null;
    }
    
    public Utenti getUser(String username, String password){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
                        
            String query = "select * from venditore where " + "username = ? and password = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                Venditore venditore = new Venditore();
                venditore.codice = set.getInt("codice");
                venditore.nome = set.getString("nome");
                venditore.cognome = set.getString("cognome");
                venditore.username = set.getString("username");
                venditore.password = set.getString("password");
                    
                stmt.close();
                conn.close();
                
                return venditore;       
            }
            
            query = "select * from cliente where " + "username = ? and password = ?";
            
            stmt = conn.prepareStatement(query);
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            set = stmt.executeQuery();
            
            if(set.next())
            {
                Cliente cliente = new Cliente();
                cliente.codice = set.getInt("codice");
                cliente.nome = set.getString("nome");
                cliente.cognome = set.getString("cognome");
                cliente.username = set.getString("username");
                cliente.password = set.getString("password");
                    
                stmt.close();
                conn.close();
                
                return cliente;
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }    
    
    public ArrayList<Cliente> getBuyerList()
    {
        ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "SELECT * FROM cliente ";
            
            Statement stmt = conn.createStatement();
            
            ResultSet set = stmt.executeQuery(query);
            
            while(set.next()){
                Cliente buyer = new Cliente();
                buyer.codice = set.getInt("codice");
                buyer.nome = set.getString("nome");
                buyer.cognome = set.getString("cognome");
                buyer.username = set.getString("username");
                buyer.password = set.getString("password");
                listaClienti.add(buyer);
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return listaClienti;
    }
    
    public ArrayList<Venditore> getSellerList()
    {
        ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
        
        try {
                      
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM " + "venditore";
            
            ResultSet set = stmt.executeQuery(query);
            
            while(set.next()){
                Venditore seller = new Venditore();
                seller.codice = set.getInt("codice");
                seller.nome = set.getString("nome");
                seller.cognome = set.getString("cognome");
                seller.username = set.getString("username");
                seller.password = set.getString("password");
                listaVenditori.add(seller);
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return listaVenditori;
    }    
    
    public ArrayList<Utenti> getUserList()
    {
        ArrayList<Utenti> listaUtenti = new ArrayList<Utenti>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM venditore";
            
            ResultSet set = stmt.executeQuery(query);
            
            while(set.next()){
                Utenti current = new Utenti();
                current.codice = set.getInt("codice");
                current.nome = set.getString("nome");
                current.cognome = set.getString("cognome");
                current.username = set.getString("username");
                current.password = set.getString("password");
                listaUtenti.add(current);
            }
            
            query = "SELECT * FROM cliente";
            set = stmt.executeQuery(query);
            
            while(set.next()){
                Utenti current = new Utenti();
                current.codice = set.getInt("codice");
                current.nome = set.getString("nome");
                current.cognome = set.getString("cognome");
                current.username = set.getString("username");
                current.password = set.getString("password");
                listaUtenti.add(current);
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return listaUtenti;
    }
    
    public int getSaldoCliente(int idcl){
        int saldo = 0;
        
        try{    
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "SELECT saldo FROM saldo JOIN cliente ON cliente.idsaldo = saldo.id " + "WHERE cliente.codice = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1,idcl);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                saldo = set.getInt("saldo");
            }
            
            stmt.close();
            conn.close();            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return saldo;
    }
    
    public int getIdVbyObj (int idobj){
        int idv = 0;
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");

            String query = "SELECT idvenditore FROM oggetto WHERE " + "id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, idobj);

            ResultSet set = stmt.executeQuery();

            if(set.next()){
                idv = set.getInt("idvenditore");
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        } 
        
        return idv;
    }

    public int getIdSaldoCl (int idcl) throws SQLException{
        int idsc = 0;
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");

            String query = "select idsaldo from cliente where " + "codice = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,idcl);

            ResultSet set = stmt.executeQuery();

            if(set.next()){
                idsc = set.getInt("idsaldo");
            }
            
            stmt.close();
            conn.close();
        
        } catch(SQLException e){
            e.printStackTrace();
        }
        return idsc;
    }
    
    public int getIdSaldoV (int idv) throws SQLException{
        int idsv = 0;
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");

            String query = "select idsaldo from venditore where " + "codice = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,idv);

            ResultSet set = stmt.executeQuery();

            if(set.next()){
                idsv = set.getInt("idsaldo");
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return idsv;
    }    
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }
    
}
