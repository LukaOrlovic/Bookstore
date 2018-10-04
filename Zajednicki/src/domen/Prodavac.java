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
public class Prodavac implements Serializable, OpstiDomenskiObjekat{

    private int idProdavca;
    private String ime;
    private String prezime;
    private String lozinka;

    public Prodavac() {
    }

    public Prodavac(int idProdavca, String ime, String prezime, String lozinka) {
        this.idProdavca = idProdavca;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
    }

    public int getIdProdavca() {
        return idProdavca;
    }

    public void setIdProdavca(int idProdavca) {
        this.idProdavca = idProdavca;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    

    @Override
    public String vratiImeTabele() {

        return "prodavac";
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

        return "idProdavca="+idProdavca;
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

        ArrayList<OpstiDomenskiObjekat>  listaProdavaca = new ArrayList<>();
        
        Prodavac prodavac;
        while (rs.next()) {
            prodavac = new Prodavac();
            prodavac.setIdProdavca(rs.getInt("idProdavca"));
            prodavac.setIme(rs.getString("ime"));
            prodavac.setPrezime(rs.getString("prezime"));
            prodavac.setLozinka(rs.getString("lozinka"));

            listaProdavaca.add(prodavac);
        }
        return listaProdavaca;
    }

}
