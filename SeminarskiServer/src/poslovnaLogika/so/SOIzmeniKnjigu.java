/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.Knjiga;

/**
 *
 * @author marija
 */
public class SOIzmeniKnjigu extends OpstaSO {

    Knjiga knjiga;

    public SOIzmeniKnjigu(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    protected void proveriPreduslove() throws Exception {

    }

    @Override
    protected void izvrsi() throws Exception {
        dbbr.izmeni(knjiga);
    }

}
