/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.Knjiga;

/**
 *
 * @author orlov
 */
public class SOObrisiKnjigu extends OpstaSO{

    Knjiga k;

    public SOObrisiKnjigu(Knjiga k) {
        this.k = k;
    }
    
    @Override
    protected void proveriPreduslove() throws Exception {

    }

    @Override
    protected void izvrsi() throws Exception {

        dbbr.obrisi(k);
    }
    
}
