/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.Knjiga;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;

/**
 *
 * @author marija
 */
public class SOVratiKnjige extends OpstaSO {

    private ArrayList<OpstiDomenskiObjekat> listaKnjiga;
    Knjiga knjiga;

    public SOVratiKnjige(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
    }

    @Override
    protected void izvrsi() throws Exception {
        listaKnjiga = knjiga.vratiListuObjekata(dbbr.selektuj(knjiga));
    }

    public ArrayList<OpstiDomenskiObjekat> getListaKnjiga() {
        return listaKnjiga;
    }

}
