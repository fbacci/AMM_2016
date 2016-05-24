/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneEcommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Francy
 */
public class SaldoFactory {
    
    private String connectionString;
    
    private static SaldoFactory saldo;
    public static SaldoFactory getInstance() {
        if (saldo == null) {
            saldo = new SaldoFactory();
        }
        return saldo;
    }
    
    private ArrayList<Saldo> listaSaldiV = new ArrayList<Saldo>();
    private ArrayList<Saldo> listaSaldiC = new ArrayList<Saldo>();
    private ArrayList<Saldo> listaS = new ArrayList<Saldo>();
    
    private SaldoFactory(){

    }
    
    public ArrayList<Saldo> getSaldoCList()
    {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "SELECT * FROM cliente JOIN saldo ON cliente.idsaldo = saldo.id";
            
            Statement stmt = conn.createStatement();
            
            ResultSet set = stmt.executeQuery(query);
            
            while(set.next()){
                Saldo s = new Saldo();
                s.setId(set.getInt("id"));
                s.setSaldo(set.getInt("saldo"));
                listaSaldiC.add(s);
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            
        }
        
        return listaSaldiC;
    }
    
    public ArrayList<Saldo> getSaldoVList()
    {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "SELECT * FROM venditore JOIN saldo ON cliente.idsaldo = saldo.id";
            
            Statement stmt = conn.createStatement();
            
            ResultSet set = stmt.executeQuery(query);
            
            while(set.next()){
                Saldo s = new Saldo();
                s.setId(set.getInt("id"));
                s.setSaldo(set.getInt("saldo"));
                listaSaldiV.add(s);
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            
        }
        
        return listaSaldiV;
    }

    public ArrayList<Saldo> getSaldiList()
    {
        try{
            Connection conn = DriverManager.getConnection(connectionString, "fbacci", "0000");
            
            String query = "SELECT * FROM saldo";
            
            Statement stmt = conn.createStatement();
            
            ResultSet set = stmt.executeQuery(query);
            
            while(set.next()){
                Saldo s = new Saldo();
                s.setId(set.getInt("id"));
                s.setSaldo(set.getInt("saldo"));
                listaS.add(s);                
            }
            
            stmt.close();
            conn.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return listaS;
    }
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }
        
}
