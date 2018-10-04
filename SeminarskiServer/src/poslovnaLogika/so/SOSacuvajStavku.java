/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.StavkaRacuna;

/**
 *
 * @author orlov
 */
public class SOSacuvajStavku extends OpstaSO {

    private StavkaRacuna stavka;

    public SOSacuvajStavku(StavkaRacuna stavka) {
        this.stavka = stavka;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void izvrsi() throws Exception {
        dbbr.sacuvaj(stavka);
    }
}
