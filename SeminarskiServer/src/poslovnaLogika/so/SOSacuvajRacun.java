/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.Racun;
import domen.StavkaRacuna;

/**
 *
 * @author marija
 */
public class SOSacuvajRacun extends OpstaSO {

    private Racun racun;

    public SOSacuvajRacun(Racun racun) {
        this.racun = racun;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void izvrsi() throws Exception {
        dbbr.sacuvaj(racun);
        racun.setIdRacuna(dbbr.vratiID(racun));
        for(StavkaRacuna s : racun.getStavke()){
            s.setIdRacuna(racun.getIdRacuna());
            dbbr.sacuvaj(s);
        }
    }

}
