/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import forme.ServerForma;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import niti.NitKlijent;
import niti.NitZaZatvaranje;


/**
 *
 * @author orlov
 */
public class PokretanjeServera extends Thread{
    ServerForma sf;
    Properties properties;

    public PokretanjeServera(ServerForma sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        try {
            FileInputStream fis = null;
            fis = new FileInputStream("settings.properties");
            properties = new Properties();
            properties.load(fis);
            ServerSocket ss= new ServerSocket(Integer.parseInt(properties.getProperty("port")));
            sf.serverPokrenut();
            NitZaZatvaranje nit= new NitZaZatvaranje(ss, this); 
            nit.start();
            while (!isInterrupted()) {                
            Socket s= ss.accept(); 
            
            System.out.println("Klijent se zakacio");
                NitKlijent nitKlijent= new NitKlijent(s);
                nitKlijent.start();
            }
            
        } catch (IOException ex) {
            sf.serverNijePokrenut();
        }
    }
    
    
}
