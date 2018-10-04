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

/**
 *
 * @author hp
 */
public interface OpstiDomenskiObjekat extends Serializable{

    public String vratiImeTabele();

    public String vratiKoloneZaInsert();

    public String vratiVrednostiInsert();

    public String vratiVrednostiUpdate();

    public String vratiIdentifikator();

    public String vratiAlijas();

    public String vratiJoin();

    public String vratiWhereZaSelect();
    
    public ArrayList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws SQLException; 
}
