/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.OpstiDomenskiObjekat;
import domen.Racun;
import java.util.ArrayList;

/**
 *
 * @author orlov
 */
public class SOVratiNekeRacune extends OpstaSO{

    private Racun racun;
    private ArrayList<OpstiDomenskiObjekat> listaRacuna;

    public SOVratiNekeRacune(Racun r) {
        this.racun = r;
    }
    
    @Override
    protected void proveriPreduslove() throws Exception {
    }

    @Override
    protected void izvrsi() throws Exception {

        listaRacuna = racun.vratiListuObjekata(dbbr.selektuj(racun));
    }

    public ArrayList<OpstiDomenskiObjekat> getListaRacuna() {
        return listaRacuna;
    }

    
}
