/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author orlov
 */
public class PoreskaStopa implements Serializable, OpstiDomenskiObjekat{
    
    private int idStope;
    private int procenat;

    public PoreskaStopa() {
    }

    public PoreskaStopa(int idStope, int procenat) {
        this.idStope = idStope;
        this.procenat = procenat;
    }

    public int getProcenat() {
        return procenat;
    }

    public void setProcenat(int procenat) {
        this.procenat = procenat;
    }

    public int getIdStope() {
        return idStope;
    }

    public void setIdStope(int idStope) {
        this.idStope = idStope;
    }

    @Override
    public String toString() {
        return ""+procenat;
    }
    
    public boolean proveri(PoreskaStopa ps){
        if(this.idStope == ps.idStope){
            return true;
        }else return false;
    }
    
    

  

    @Override
    public String vratiImeTabele() {

        return "poreskaStopa";
    }

    @Override
    public String vratiKoloneZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiIdentifikator() {

        return "idStope="+idStope;
    }

    @Override
    public String vratiAlijas() {

        return "";
    }

    @Override
    public String vratiJoin() {

        return "";
    }

    @Override
    public String vratiWhereZaSelect() {

        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws SQLException {

        ArrayList<OpstiDomenskiObjekat>  listaStopa= new ArrayList<>();
        
        PoreskaStopa poreskeStope;
        while (rs.next()) {
            poreskeStope = new PoreskaStopa();
            poreskeStope.setIdStope(rs.getInt("idStope"));
            poreskeStope.setProcenat(rs.getInt("procenat"));

            listaStopa.add(poreskeStope);
        }
        return listaStopa;
    }
    
}
