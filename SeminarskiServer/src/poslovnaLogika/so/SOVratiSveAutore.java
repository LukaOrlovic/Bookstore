/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import domen.Autor;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;

/**
 *
 * @author marija
 */
public class SOVratiSveAutore extends OpstaSO {

    private ArrayList<OpstiDomenskiObjekat> listaAutora;
    Autor autor;

    public SOVratiSveAutore(Autor autor) {
        this.autor = autor;
    }

    @Override
    protected void proveriPreduslove() throws Exception {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void izvrsi() throws Exception {
        
        listaAutora = autor.vratiListuObjekata(dbbr.selektuj(autor));

    }

    public ArrayList<OpstiDomenskiObjekat> getListaAutora() {
        return listaAutora;
    }

}
