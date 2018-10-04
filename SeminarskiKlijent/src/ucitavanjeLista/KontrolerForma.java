/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucitavanjeLista;

import domen.Autor;
import domen.Knjiga;
import domen.PoreskaStopa;
import domen.Racun;
import domen.StavkaRacuna;
import forme.PocetnaForma;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;
import transfer.OdgovorServera;
import transfer.ZahtevKlijenta;

/**
 *
 * @author orlov
 */
public class KontrolerForma {

    private static KontrolerForma instance;
    ArrayList<Autor> listaAutora;
    ArrayList<Knjiga> knjige;
    ArrayList<Racun> racuni;
    ArrayList<StavkaRacuna> stavke;


    private KontrolerForma() {
        listaAutora = new ArrayList<>();
        knjige = new ArrayList<>();
        racuni = new ArrayList<>();
        stavke = new ArrayList<>();
    }

    public static KontrolerForma getInstance() {
        if (instance == null) {
            instance = new KontrolerForma();
        }
        return instance;
    }

    public ArrayList<Autor> popuniListuAutora() {

        //ArrayList<Autor> autori = null;
        try {
            ZahtevKlijenta zahtev = new ZahtevKlijenta();
            zahtev.setOperacija(ZahtevKlijenta.VRATI_SVE_AUTORE);

            OdgovorServera odgovor = (OdgovorServera) Komunikacija.vratiInstancu().requestSynch(zahtev);
            if (odgovor.getSignal() == -1) {
                throw odgovor.getIzuzetak();
            }

            listaAutora = (ArrayList<Autor>) odgovor.getObjekatIzvrsenjaOperacije();
            System.out.println("LISTA FORMA- " + listaAutora);

        } catch (IOException ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        //listaAutora = autori;
        return listaAutora;

    }

    public ArrayList<PoreskaStopa> popuniListuStopa() {

        ArrayList<PoreskaStopa> autori = null;
        try {
            ZahtevKlijenta zahtev = new ZahtevKlijenta();
            zahtev.setOperacija(ZahtevKlijenta.VRATI_SVE_STOPE);

            OdgovorServera odgovor = (OdgovorServera) Komunikacija.vratiInstancu().requestSynch(zahtev);
            if (odgovor.getSignal() == -1) {
                throw odgovor.getIzuzetak();
            }

            autori = (ArrayList<PoreskaStopa>) odgovor.getObjekatIzvrsenjaOperacije();
            System.out.println("LISTA FORMA- " + autori);

        } catch (IOException ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        return autori;
    }

    public ArrayList<Knjiga> popuniListuKnjiga() {

        try {
            ZahtevKlijenta zahtev = new ZahtevKlijenta();
            zahtev.setOperacija(ZahtevKlijenta.VRATI_SVE_KNJIGE);

            OdgovorServera odgovor = (OdgovorServera) Komunikacija.vratiInstancu().requestSynch(zahtev);
            if (odgovor.getSignal() == -1) {
                throw odgovor.getIzuzetak();
            }

            knjige = (ArrayList<Knjiga>) odgovor.getObjekatIzvrsenjaOperacije();
            System.out.println("LISTA FORMA- " + knjige);

        } catch (IOException ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        return knjige;
    }

    public ArrayList<Racun> popuniListuRacuna() {

        try {
            ZahtevKlijenta zahtev = new ZahtevKlijenta();
            zahtev.setOperacija(ZahtevKlijenta.VRATI_SVE_RACUNE);

            OdgovorServera odgovor = (OdgovorServera) Komunikacija.vratiInstancu().requestSynch(zahtev);
            if (odgovor.getSignal() == -1) {
                throw odgovor.getIzuzetak();
            }

            racuni = (ArrayList<Racun>) odgovor.getObjekatIzvrsenjaOperacije();
            System.out.println("LISTA FORMA- " + racuni);

        } catch (IOException ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        return racuni;
    }

    public ArrayList<StavkaRacuna> popuniListuStavki(StavkaRacuna sr) {

        try {
            ZahtevKlijenta zahtev = new ZahtevKlijenta();
            zahtev.setObjekatOperacije(sr);
            zahtev.setOperacija(ZahtevKlijenta.VRATI_SVE_STAVKE);

            OdgovorServera odgovor = (OdgovorServera) Komunikacija.vratiInstancu().requestSynch(zahtev);
            if (odgovor.getSignal() == -1) {
                throw odgovor.getIzuzetak();
            }

            stavke = (ArrayList<StavkaRacuna>) odgovor.getObjekatIzvrsenjaOperacije();
            System.out.println("LISTA FORMA- " + stavke);

        } catch (IOException ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stavke;
    }

    public ArrayList<Racun> popuniListuRacuna(Racun neki) {

        try {
            ZahtevKlijenta zahtev = new ZahtevKlijenta();
            zahtev.setObjekatOperacije(neki);
            zahtev.setOperacija(ZahtevKlijenta.VRATI_NEKE_RACUNE);

            OdgovorServera odgovor = (OdgovorServera) Komunikacija.vratiInstancu().requestSynch(zahtev);
            if (odgovor.getSignal() == -1) {
                throw odgovor.getIzuzetak();
            }

            racuni = (ArrayList<Racun>) odgovor.getObjekatIzvrsenjaOperacije();
            System.out.println("LISTA FORMA- " + racuni);

        } catch (IOException ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PocetnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        return racuni;
    }


}
