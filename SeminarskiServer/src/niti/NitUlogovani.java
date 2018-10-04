/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import org.omg.SendingContext.RunTime;
import poslovnaLogika.KontrolerPL;

/**
 *
 * @author orlov
 */
public class NitUlogovani extends Thread{
    JLabel txtUlogovani;
    ArrayList<OpstiDomenskiObjekat> listaUlogovanih= new ArrayList<>();

    public NitUlogovani(JLabel txtUlogovani) {
        this.txtUlogovani = txtUlogovani;

    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                listaUlogovanih= KontrolerPL.vratiInstancu().getListaUlogovanih();
                if(listaUlogovanih.size()==0){
                    txtUlogovani.setText("Trenutno nema ulogovanih korisnika");
                }
                else{
                    txtUlogovani.setText(listaUlogovanih.toString());
                }
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitUlogovani.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    
}
