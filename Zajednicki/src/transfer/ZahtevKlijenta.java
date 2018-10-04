/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author student
 */
public class ZahtevKlijenta implements Serializable{
    
    public static final int PROVERI_PRODAVCA= 1;
    public static final int VRATI_SVE_AUTORE = 2;
    public static final int VRATI_SVE_STOPE = 3;
    public static final int SACUVAJ_KNJIGU = 4;
    public static final int VRATI_SVE_KNJIGE = 5;
    public static final int OBRISI_KNJIGU = 6;
    public static final int IZMENI_KNJIGU = 7;
    public static final int SACUVAJ_RACUN = 8;
    public static final int VRATI_SVE_RACUNE = 9;
    public static final int VRATI_SVE_STAVKE = 10;
    public static final int UPDATE_RACUN = 11;
    public static final int VRATI_NEKE_RACUNE = 12;
    
    
    int operacija;
    Object objekatOperacije;

    public ZahtevKlijenta() {
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getObjekatOperacije() {
        return objekatOperacije;
    }

    public void setObjekatOperacije(Object objekatOperacije) {
        this.objekatOperacije = objekatOperacije;
    }
    
    
    
    
}
