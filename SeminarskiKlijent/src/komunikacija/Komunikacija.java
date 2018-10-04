/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import domen.Prodavac;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.OdgovorServera;
import transfer.ZahtevKlijenta;

/**
 *
 * @author orlov
 */
public class Komunikacija {
    
    
    Socket vezaSaServerom;
    ObjectOutputStream outKaServeru;
    ObjectInputStream inOdServera;
    
    
    private static Komunikacija instanca;
    Prodavac prodavac;
    
    public synchronized Object requestSynch(ZahtevKlijenta zahtev) throws Exception{
        vratiInstancu().posaljiZahtev(zahtev);
        return vratiInstancu().procitajOdgovor();
    }
    
    private Komunikacija() throws IOException {
        vezaSaServerom = new Socket("localhost",9000);
    }
    
    
    public static Komunikacija vratiInstancu() throws IOException{
        if (instanca==null){
            instanca = new Komunikacija();
        }
        return instanca;
    }
    
    
    private void posaljiZahtev(ZahtevKlijenta zahtev) throws IOException{
        outKaServeru = new ObjectOutputStream(vezaSaServerom.getOutputStream());

        outKaServeru.writeObject(zahtev);
    }
    
    
    private OdgovorServera procitajOdgovor() throws IOException, ClassNotFoundException, InterruptedException{
        inOdServera = new ObjectInputStream(vezaSaServerom.getInputStream());

        Object odgovor =  inOdServera.readObject(); 
        
        if (odgovor instanceof OdgovorServera){
            return (OdgovorServera) odgovor; 
        }
        else{
            return null; 
        }
        
        
        
    } 

    public void setProdavac(Prodavac prodavac) {
        this.prodavac= prodavac;
     }

    public Prodavac getProdavac() {
        return prodavac;
    }
    
    
    
    
}
