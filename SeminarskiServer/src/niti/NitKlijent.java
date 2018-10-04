/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;


import domen.Autor;
import domen.Knjiga;
import domen.OpstiDomenskiObjekat;
import domen.PoreskaStopa;
import domen.Prodavac;
import domen.Racun;
import domen.StavkaRacuna;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import poslovnaLogika.KontrolerPL;
import transfer.OdgovorServera;
import transfer.ZahtevKlijenta;

/**
 *
 * @author student
 */
public class NitKlijent extends Thread {

    private Socket vezaSaKlijentom;
    private ObjectInputStream inOdKlijenta;
    private ObjectOutputStream outKaKlijentu;

    public NitKlijent(Socket socket) {
        this.vezaSaKlijentom = socket;
    }

    @Override
    public void run() {
        try{
           
            while (true) {
                ZahtevKlijenta zahtevKlijenta = primi();
                obradiZahtevKlijenta(zahtevKlijenta);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void obradiZahtevKlijenta(ZahtevKlijenta zahtevKlijenta) throws IOException, Exception {

        OdgovorServera odgovorServera = new OdgovorServera();

        switch (zahtevKlijenta.getOperacija()) {
            
            case ZahtevKlijenta.SACUVAJ_KNJIGU: 
                try {
                    Knjiga t = (Knjiga) zahtevKlijenta.getObjekatOperacije();
   
                    
                    KontrolerPL.vratiInstancu().sacuvajKnjigu(t);
                    //KontrolerPL.vratiInstancu().sacuvajKnjigu(t);
                    odgovorServera.setSignal(1);
                  
                    
                    
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;

            case ZahtevKlijenta.PROVERI_PRODAVCA: 
                try {
                    Prodavac p = (Prodavac) zahtevKlijenta.getObjekatOperacije();
                    boolean uspesno= false;
                    uspesno = KontrolerPL.vratiInstancu().vratiUspesno(p);
                    p= KontrolerPL.vratiInstancu().getProdavac();
                    odgovorServera.setProfesor(p);
                    odgovorServera.setObjekatIzvrsenjaOperacije(uspesno);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;    
        
                case ZahtevKlijenta.VRATI_SVE_AUTORE: 
                try {
                    Autor t = new Autor();
                    List<OpstiDomenskiObjekat> listaAutora = KontrolerPL.vratiInstancu().vratiSveAutore(t);
                    odgovorServera.setObjekatIzvrsenjaOperacije(listaAutora);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
                
                case ZahtevKlijenta.VRATI_SVE_STOPE: 
                try {
                    PoreskaStopa t = new PoreskaStopa();
                    List<OpstiDomenskiObjekat> listaStopa = KontrolerPL.vratiInstancu().vratiSvePoreskeStope(t);
                    odgovorServera.setObjekatIzvrsenjaOperacije(listaStopa);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
                
                case ZahtevKlijenta.VRATI_SVE_KNJIGE: 
                try {
                    Knjiga k = new Knjiga();
                    List<OpstiDomenskiObjekat> listaKnjiga = KontrolerPL.vratiInstancu().vratiSveKnjige(k);
                    odgovorServera.setObjekatIzvrsenjaOperacije(listaKnjiga);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
                
                case ZahtevKlijenta.OBRISI_KNJIGU: 
                try {
                    Knjiga k = (Knjiga) zahtevKlijenta.getObjekatOperacije();
                    KontrolerPL.vratiInstancu().obrisiKnjigu(k);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
                
                case ZahtevKlijenta.IZMENI_KNJIGU: 
                try {
                    Knjiga k = (Knjiga) zahtevKlijenta.getObjekatOperacije();
                    KontrolerPL.vratiInstancu().izmeniKnjigu(k);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
                
                case ZahtevKlijenta.SACUVAJ_RACUN: 
                try {
                    Racun r = (Racun) zahtevKlijenta.getObjekatOperacije();
                    KontrolerPL.vratiInstancu().sacuvajRacun(r);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
                
                case ZahtevKlijenta.VRATI_SVE_RACUNE: 
                try {
                    Racun r = new Racun();
                    List<OpstiDomenskiObjekat> listaRacuna = KontrolerPL.vratiInstancu().vratiSveRacune(r);                    
                    odgovorServera.setObjekatIzvrsenjaOperacije(listaRacuna);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
                
                case ZahtevKlijenta.VRATI_SVE_STAVKE: 
                try {
                    StavkaRacuna sr = (StavkaRacuna) zahtevKlijenta.getObjekatOperacije();
                    List<OpstiDomenskiObjekat> listaStavki = KontrolerPL.vratiInstancu().vratiSveStavke(sr);                    
                    odgovorServera.setObjekatIzvrsenjaOperacije(listaStavki);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
                
                case ZahtevKlijenta.UPDATE_RACUN: 
                try {
                    Racun r = (Racun) zahtevKlijenta.getObjekatOperacije();
                    KontrolerPL.vratiInstancu().izmeniRacun(r);
                    ArrayList<StavkaRacuna> stavke = r.getStavke();
                    for (StavkaRacuna sr : stavke) {
                        KontrolerPL.vratiInstancu().izmeniStavku(sr);
                    }
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
                
                case ZahtevKlijenta.VRATI_NEKE_RACUNE: 
                try {
                    Racun r = (Racun) zahtevKlijenta.getObjekatOperacije();
                    List<OpstiDomenskiObjekat> listaRacuna = KontrolerPL.vratiInstancu().vratiSveRacune(r);                    
                    odgovorServera.setObjekatIzvrsenjaOperacije(listaRacuna);
                    odgovorServera.setSignal(1);
                } catch (Exception ex) {
                    //Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                    odgovorServera.setIzuzetak(ex);
                    odgovorServera.setSignal(-1);
                }
                break;
        
        }
        
        posalji(odgovorServera);

        

    }

    private ZahtevKlijenta primi() {
        ZahtevKlijenta kz = new ZahtevKlijenta();
        try {
            inOdKlijenta = new ObjectInputStream(vezaSaKlijentom.getInputStream());
            kz = (ZahtevKlijenta) inOdKlijenta.readObject();
        } catch (Exception ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kz;
        
    }

    private void posalji(OdgovorServera odgovorServera) {
        try {
            outKaKlijentu = new ObjectOutputStream(vezaSaKlijentom.getOutputStream());
            outKaKlijentu.writeObject(odgovorServera);
        } catch (IOException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
