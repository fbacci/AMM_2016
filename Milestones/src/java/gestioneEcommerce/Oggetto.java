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
public class Oggetto {
    
    protected int id;
    protected String titolo;
    protected String categoria;
    protected int quantita;
    protected int prezzo;
        
    public Oggetto()
    {
        titolo = "";
        categoria = "";
        quantita = 0;
        prezzo = 0;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitolo() {
    return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    public String getCategoria() {
    return categoria;
    }

    public void setCategoria(String categoria1, String categoria2) {
        this.categoria = categoria1;
        this.categoria = categoria2;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

}
