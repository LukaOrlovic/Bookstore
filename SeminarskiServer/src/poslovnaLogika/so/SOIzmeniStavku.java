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
public class SOIzmeniStavku extends OpstaSO{

    StavkaRacuna sr;

    public SOIzmeniStavku(StavkaRacuna sr){
        this.sr = sr;
    }
    
    
    
    @Override
    protected void proveriPreduslove() throws Exception {
    }

    @Override
    protected void izvrsi() throws Exception {
        dbbr.izmeni(sr);
    }
    
}
