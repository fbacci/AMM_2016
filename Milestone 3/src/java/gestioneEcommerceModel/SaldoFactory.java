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
public class SaldoFactory {
    
    private static SaldoFactory saldo;
    public static SaldoFactory getInstance() {
        if (saldo == null) {
            saldo = new SaldoFactory();
        }
        return saldo;
    }
    
    private ArrayList<Saldo> listaSaldi = new ArrayList<Saldo>();
    
    private SaldoFactory(){
        // SALDO CLIENTI
        Saldo saldoc_1 = new Saldo();
        saldoc_1.setId(1);
        saldoc_1.setSaldo(15);
        listaSaldi.add(saldoc_1);
        
        Saldo saldoc_2 = new Saldo();
        saldoc_2.setId(2);
        saldoc_2.setSaldo(80);
        listaSaldi.add(saldoc_2);
        
        Saldo saldoc_3 = new Saldo();
        saldoc_3.setId(3);
        saldoc_3.setSaldo(50);
        listaSaldi.add(saldoc_3);
        
        // SALDO VENDITORI
        Saldo saldov_1 = new Saldo();
        saldov_1.setId(4);
        saldov_1.setSaldo(1500);
        listaSaldi.add(saldov_1);
        
        Saldo saldov_2 = new Saldo();
        saldov_2.setId(5);
        saldov_2.setSaldo(500);
        listaSaldi.add(saldov_2);
        
        Saldo saldov_3 = new Saldo();
        saldov_3.setId(4);
        saldov_3.setSaldo(1000);
        listaSaldi.add(saldov_3);
    }
    
    public ArrayList<Saldo> getSaldiList()
    {
       return listaSaldi;
    }
        
}
