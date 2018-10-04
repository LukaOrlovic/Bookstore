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
public class SOIzmeniRacun extends OpstaSO {

    Racun racun;

    public SOIzmeniRacun(Racun r) {
        this.racun = r;
    }

    @Override
    protected void proveriPreduslove() throws Exception {

    }

    @Override
    protected void izvrsi() throws Exception {
        dbbr.izmeni(racun);
        for(StavkaRacuna s : racun.getStavke()){
            dbbr.izmeni(s);
        }
    }

}
