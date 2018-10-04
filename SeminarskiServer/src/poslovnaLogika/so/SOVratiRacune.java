/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import java.util.ArrayList;
import domen.OpstiDomenskiObjekat;
import domen.Racun;

/**
 *
 * @author marija
 */
public class SOVratiRacune extends OpstaSO {

    private ArrayList<OpstiDomenskiObjekat> listaRacuna;
    Racun racun;

    public SOVratiRacune(Racun t) {
        this.racun = t;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void izvrsi() throws Exception {
        listaRacuna = racun.vratiListuObjekata(dbbr.selektuj(racun));
    }

    public ArrayList<OpstiDomenskiObjekat> getListaRacuna() {
        return listaRacuna;
    }

}
