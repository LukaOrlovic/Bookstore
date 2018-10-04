/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika.so;

import db.DBBroker;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlov
 */
abstract public class OpstaSO {
    protected DBBroker dbbr;
    
    public OpstaSO(){
        dbbr=DBBroker.getInstance();
    }
    
    public void uspostaviKonekciju() throws Exception{
        dbbr.uspostaviKonekciju();
    }
    
    protected abstract void proveriPreduslove() throws Exception;
    
    protected abstract void izvrsi() throws Exception;
    
    private void potvrdiTransakciju() throws SQLException{
        dbbr.commitTransakciju();
    }
    
    private void ponistiTransakciju() throws SQLException{
        dbbr.rollbackTransakciju();
    }
    
    private void raskiniKonekciju() throws SQLException{
        dbbr.zatvoriKonekciju();
    }
    
    public void opsteIzvrsenje() throws Exception{
        try {
            uspostaviKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        
        try{
            proveriPreduslove();
            izvrsi();
            potvrdiTransakciju();
        }catch(Exception e){
            e.printStackTrace();
            ponistiTransakciju();
            throw e;
        }finally{
            raskiniKonekciju();
        }
    }
}
