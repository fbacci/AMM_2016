/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneEcommerceModel;

/**
 *
 * @author Francy
 */
public class Saldo {
    public int id;
    public double saldo;
    
    public Saldo(){
        id = 0;
        saldo = 0;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    } 
}
