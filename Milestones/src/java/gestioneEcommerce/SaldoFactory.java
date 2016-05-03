/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneEcommerce;

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
    
    private ArrayList<Saldo> listaSaldiV = new ArrayList<Saldo>();
    private ArrayList<Saldo> listaSaldiC = new ArrayList<Saldo>();
    
    private SaldoFactory(){
        // SALDO CLIENTI
        SaldoC saldoc_1 = new SaldoC();
        saldoc_1.setId(1);
        saldoc_1.setSaldo(15);
        listaSaldiC.add(saldoc_1);
        
        SaldoC saldoc_2 = new SaldoC();
        saldoc_2.setId(2);
        saldoc_2.setSaldo(80);
        listaSaldiC.add(saldoc_2);
        
        SaldoC saldoc_3 = new SaldoC();
        saldoc_3.setId(3);
        saldoc_3.setSaldo(50);
        listaSaldiC.add(saldoc_3);
        
        // SALDO VENDITORI
        SaldoV saldov_1 = new SaldoV();
        saldov_1.setId(4);
        saldov_1.setSaldo(1500);
        listaSaldiV.add(saldov_1);
        
        SaldoV saldov_2 = new SaldoV();
        saldov_2.setId(5);
        saldov_2.setSaldo(500);
        listaSaldiV.add(saldov_2);
        
        SaldoV saldov_3 = new SaldoV();
        saldov_3.setId(4);
        saldov_3.setSaldo(1000);
        listaSaldiV.add(saldov_3);
    }
    
    public ArrayList<Saldo> getSaldoClList()
    {
        return listaSaldiC;
    }
    
    public ArrayList<Saldo> getSaldoVList()
    {
        return listaSaldiV;
    }

    public ArrayList<Saldo> getSaldiList()
    {
        ArrayList<Saldo> listaSaldi = new ArrayList<Saldo>();
        
        listaSaldi.addAll(listaSaldiC);
        listaSaldi.addAll(listaSaldiV);
        
        return listaSaldi;
    }
        
}
