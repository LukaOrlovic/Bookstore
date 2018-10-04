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
public class Autor implements Serializable, OpstiDomenskiObjekat{

    private int idAutora;
    private String imePrezime;
    private char pol;

    public Autor() {
    }

    public Autor(int idAutora, String imePrezime, char pol) {
        this.idAutora = idAutora;
        this.imePrezime = imePrezime;
        this.pol = pol;
    }

    public char getPol() {
        return pol;
    }

    public void setPol(char pol) {
        this.pol = pol;
    }

    public int getIdAutora() {
        return idAutora;
    }

    public void setIdAutora(int idAutora) {
        this.idAutora = idAutora;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    @Override
    public String toString() {

        return imePrezime;
    }
    
    public boolean proveri(Autor a){
        if(this.idAutora == a.idAutora){
            return true;
        }else return false;
    }


    @Override
    public String vratiImeTabele() {

        return "autor";
    }

    
    @Override
    public String vratiKoloneZaInsert() {

        return "idAutora,imePrezime,pol";
    }

    @Override
    public String vratiVrednostiInsert() {

        return idAutora + "," + imePrezime + "," + pol;
    }

    @Override
    public String vratiVrednostiUpdate() {

        return imePrezime+","+pol;
    }

    @Override
    public String vratiIdentifikator() {

        return "idAutora="+idAutora;
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

        ArrayList<OpstiDomenskiObjekat> listaAutora = new ArrayList<>();

        Autor autor;
        while (rs.next()) {
            autor= new Autor();
            autor.setIdAutora(rs.getInt("idAutora"));
            autor.setImePrezime(rs.getString("imePrezime"));
            autor.setPol(rs.getString("pol").charAt(0));
           
            listaAutora.add(autor);

        }

        return listaAutora;
    }
    

}
