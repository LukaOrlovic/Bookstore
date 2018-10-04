/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import java.util.ArrayList;
import domen.OpstiDomenskiObjekat;
import domen.PoreskaStopa;


/**
 *
 * @author marija
 */
public class SOVratiSvePoreskeStope extends OpstaSO{
    
   private ArrayList<OpstiDomenskiObjekat> listaPoreskihStopa;
    PoreskaStopa poreskaStopa;

    public SOVratiSvePoreskeStope(PoreskaStopa poreskaStopa) {
        this.poreskaStopa = poreskaStopa;
    }

//    public SOVratiSvePoreskeStope() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    

    @Override
    protected void proveriPreduslove() throws Exception {
           }

    @Override
    protected void izvrsi() throws Exception {
      listaPoreskihStopa= poreskaStopa.vratiListuObjekata(dbbr.selektuj(poreskaStopa));
    }

    public ArrayList<OpstiDomenskiObjekat> getListaPoreskihStopa() {
        return listaPoreskihStopa;
    }
   
    
   
           
    
    
}
