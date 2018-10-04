/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika;

import db.DBBroker;
import domen.Autor;
import domen.Knjiga;
import domen.OpstiDomenskiObjekat;
import domen.PoreskaStopa;
import domen.Prodavac;
import domen.Racun;
import domen.StavkaRacuna;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poslovnaLogika.so.SODajID;
import poslovnaLogika.so.SOIzmeniKnjigu;
import poslovnaLogika.so.SOIzmeniRacun;
import poslovnaLogika.so.SOIzmeniStavku;
import poslovnaLogika.so.SOObrisiKnjigu;
import poslovnaLogika.so.SOSacuvajKnjigu;
import poslovnaLogika.so.SOSacuvajRacun;
import poslovnaLogika.so.SOSacuvajStavku;
import poslovnaLogika.so.SOVratiKnjige;
import poslovnaLogika.so.SOVratiNekeRacune;
import poslovnaLogika.so.SOVratiSveAutore;
import poslovnaLogika.so.SOVratiSvePoreskeStope;
import poslovnaLogika.so.SOVratiSveStavkeRacuna;
import poslovnaLogika.so.SOVratiRacune;
import poslovnaLogika.so.SOVratiSveProdavce;

/**
 *
 * @author orlov
 */
public class KontrolerPL {

    DBBroker dbbr;

    static ArrayList<OpstiDomenskiObjekat> listaSvihProdavaca;
    ArrayList<OpstiDomenskiObjekat> listaUlogovanih;
    private Prodavac prodavac;

    private static KontrolerPL instanca;

    public static KontrolerPL vratiInstancu() {

        if (instanca == null) {
            instanca = new KontrolerPL();
        }

        return instanca;
    }

    private KontrolerPL() {

        dbbr = DBBroker.getInstance();
        listaSvihProdavaca = new ArrayList<>();
        listaUlogovanih = new ArrayList<>();

    }

    public ArrayList<OpstiDomenskiObjekat> vratiSveStavke(StavkaRacuna p) throws Exception {
        SOVratiSveStavkeRacuna so = new SOVratiSveStavkeRacuna(p);
        so.opsteIzvrsenje();
        return so.getStavke();

    }
//

    public void sacuvajMesto(Racun r) throws Exception {
        SOSacuvajRacun so = new SOSacuvajRacun(r);
        so.opsteIzvrsenje();

    }
    
    public void vratiID(Racun r) throws SQLException, Exception{
        SODajID so = new SODajID(r);
        so.opsteIzvrsenje();
    }
//

    public List<OpstiDomenskiObjekat> vratiSveAutore(Autor m) throws Exception {
        SOVratiSveAutore so = new SOVratiSveAutore(m);
        so.opsteIzvrsenje();
        return so.getListaAutora();
    }
//

    public List<OpstiDomenskiObjekat> vratiSveRacune(Racun t) throws Exception {
        SOVratiRacune so = new SOVratiRacune(t);
        so.opsteIzvrsenje();
        return so.getListaRacuna();
    }
//

//
//    public int dajID(Knjiga k){
//        SODajID so = new SODajID();
//        
//        
//    }
    public void sacuvajKnjigu(Knjiga a) throws Exception {
        System.out.println("Kontroler sacuvaj knjigu.");
        SOSacuvajKnjigu so = new SOSacuvajKnjigu(a);
        so.opsteIzvrsenje();
    }

//
    public List<OpstiDomenskiObjekat> vratiSvePoreskeStope(PoreskaStopa pk) throws Exception {
        SOVratiSvePoreskeStope so = new SOVratiSvePoreskeStope(pk);
        so.opsteIzvrsenje();
        return so.getListaPoreskihStopa();
    }

    public void izmeniRacun(Racun t) throws Exception {
        SOIzmeniRacun so = new SOIzmeniRacun(t);
        so.opsteIzvrsenje();
    }
//

    public ArrayList<OpstiDomenskiObjekat> getListaUlogovanih() {
        return listaUlogovanih;
    }
//    
//    
//

    public ArrayList<OpstiDomenskiObjekat> vratiSveProdavce(Prodavac p) throws Exception {
        SOVratiSveProdavce so = new SOVratiSveProdavce(p);
        so.opsteIzvrsenje();
        return so.getProdavce();
    }

    public boolean vratiUspesno(Prodavac p) throws Exception {

        listaSvihProdavaca = vratiSveProdavce(p);

        for (int i = 0; i < listaSvihProdavaca.size(); i++) {
            Prodavac p1 = (Prodavac) listaSvihProdavaca.get(i);
            if (p.getIdProdavca() == p1.getIdProdavca()) {
                System.out.println("P " + p.getIme() + "P1 " + p1.getIme());
                if (daLiJeUlogovan(p)) {
                    return false;
                } else {
                    //u slucaju da postoji i nije ulogovan radi dalje
                    if (p.getLozinka().equals(p1.getLozinka())) {
                        listaUlogovanih.add(p1);

                        prodavac = p1;
                        return true;
                    }
                    return false;

                }
            }

        }
        return false;

    }

    private boolean daLiJeUlogovan(Prodavac p) {
        for (int i = 0; i < listaUlogovanih.size(); i++) {
            Prodavac p1 = (Prodavac) listaUlogovanih.get(i);
            if (p.getIdProdavca() == p1.getIdProdavca()) {
                return true; //ovde vraca da JESTE ulogovan
            }
        }
        return false;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }
//

    public List<OpstiDomenskiObjekat> vratiSveKnjige(Knjiga a) throws Exception {
        SOVratiKnjige so = new SOVratiKnjige(a);
        so.opsteIzvrsenje();
        return so.getListaKnjiga();
    }
//

    public void izmeniKnjigu(Knjiga k) throws Exception {
        SOIzmeniKnjigu so = new SOIzmeniKnjigu(k);
        so.opsteIzvrsenje();
    }

    public void obrisiKnjigu(Knjiga k) throws Exception {

        SOObrisiKnjigu so = new SOObrisiKnjigu(k);
        so.opsteIzvrsenje();
    }

    public void sacuvajRacun(Racun r) throws Exception {

        SOSacuvajRacun so = new SOSacuvajRacun(r);
        so.opsteIzvrsenje();
    }

    public void sacuvajStavku(StavkaRacuna sr) throws SQLException, Exception {

        SOSacuvajStavku so = new SOSacuvajStavku(sr);
        so.opsteIzvrsenje();
    }

    public void izmeniStavku(StavkaRacuna sr) throws Exception {

        SOIzmeniStavku so = new SOIzmeniStavku(sr);
        so.opsteIzvrsenje();
    }

    public List<OpstiDomenskiObjekat> vratiNekeRacune(Racun r) throws Exception {

        SOVratiNekeRacune so = new SOVratiNekeRacune(r);
        so.opsteIzvrsenje();
        return so.getListaRacuna();
    }
}
