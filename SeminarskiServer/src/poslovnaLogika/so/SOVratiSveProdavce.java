/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.OpstiDomenskiObjekat;
import domen.Prodavac;
import java.util.ArrayList;

/**
 *
 * @author orlov
 */
public class SOVratiSveProdavce extends OpstaSO{

    private ArrayList<OpstiDomenskiObjekat> prodavci;
    Prodavac prodavac;
    
    public SOVratiSveProdavce(Prodavac stavka) {
        this.prodavac = stavka;
    }
    
    @Override
    protected void proveriPreduslove() throws Exception {
        return;
    }

    @Override
    protected void izvrsi() throws Exception {

        prodavci = prodavac.vratiListuObjekata(dbbr.selektuj(prodavac));
    }
    
    public ArrayList<OpstiDomenskiObjekat> getProdavce(){
        return prodavci;
    }
    
}
