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
public class SOSacuvajKnjigu extends OpstaSO {

    Knjiga knjiga;

    public SOSacuvajKnjigu(Knjiga a) {
        this.knjiga = a;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
    }

    @Override
    protected void izvrsi() throws Exception {
        System.out.println("uslo u so sacuvaj aktivnost");
        dbbr.sacuvaj(knjiga);
        System.out.println("zavrsilo sa dbbr akrivnost");
    }

}
