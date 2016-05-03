/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneEcommerce;

/**
 *
 * @author Francy
 */
public class Utenti {
    
protected int codice;
protected String nome;
protected String cognome;
protected String username;
protected String password;
protected int saldo;
    
    public Utenti(){
        codice = 0;
        nome = "";
        cognome = "";
        username="";
        password="";
        saldo = 0;
    }
    
    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }

}
