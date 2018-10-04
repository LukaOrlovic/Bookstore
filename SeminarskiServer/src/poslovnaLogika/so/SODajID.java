/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.Knjiga;
import domen.Racun;

/**
 *
 * @author orlov
 */
public class SODajID extends OpstaSO{

    Racun racun;

    public SODajID(Racun r) {

        racun = r;
    }
    
    @Override
    protected void proveriPreduslove() throws Exception {

        return;
    }


    @Override
    protected void izvrsi() throws Exception {
        int id = dbbr.vratiID(racun);
        racun.setIdRacuna(id);
    }
    
}
