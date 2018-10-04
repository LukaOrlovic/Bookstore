/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;


import java.util.ArrayList;
import java.util.List;
import domen.OpstiDomenskiObjekat;
import domen.StavkaRacuna;


/**
 *
 * @author Korisnik
 */
public class SOVratiSveStavkeRacuna extends OpstaSO{
    private ArrayList<OpstiDomenskiObjekat> stavke;
    StavkaRacuna stavkaRacuna;

    public SOVratiSveStavkeRacuna(StavkaRacuna stavka) {
        this.stavkaRacuna = stavka;
    }

    
    @Override
    protected void proveriPreduslove() throws Exception {
        //nema preduslova
    }

    @Override
    protected void izvrsi() throws Exception {
        
        stavke= stavkaRacuna.vratiListuObjekata(dbbr.selektuj(stavkaRacuna));
    }
    
    public ArrayList<OpstiDomenskiObjekat> getStavke(){
        return stavke;
    }
    
}
