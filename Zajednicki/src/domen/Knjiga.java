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
public class Knjiga implements Serializable, OpstiDomenskiObjekat {

    private int sifraKnjige;
    private String nazivKnjige;
    private String zanr;
    private double cena;
    private Autor autor = new Autor();
    private PoreskaStopa poreskaStopa = new PoreskaStopa();

    public Knjiga() {
    }

    public Knjiga(int sifraKnjige, String nazivKnjige, String zanr, double cena, Autor autor, PoreskaStopa poreskaStopa) {
        this.sifraKnjige = sifraKnjige;
        this.nazivKnjige = nazivKnjige;
        this.zanr = zanr;
        this.cena = cena;
        this.autor = autor;
        this.poreskaStopa = poreskaStopa;
    }

    public PoreskaStopa getPoreskaStopa() {
        return poreskaStopa;
    }

    public void setPoreskaStopa(PoreskaStopa poreskaStopa) {
        this.poreskaStopa = poreskaStopa;
    }

    public int getSifraKnjige() {
        return sifraKnjige;
    }

    public void setSifraKnjige(int sifraKnjige) {
        this.sifraKnjige = sifraKnjige;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    @Override
    public String toString() {

        return nazivKnjige;
    }

    @Override
    public String vratiImeTabele() {

        return "knjiga";
    }

    @Override
    public String vratiKoloneZaInsert() {

        return "nazivKnjige,zanr,cena,idStope,idAutora";

    }

    @Override
    public String vratiVrednostiInsert() {
        return "'" + nazivKnjige + "','" + zanr + "'," + cena + "," + getPoreskaStopa().getIdStope() + "," + getAutor().getIdAutora();

    }

    @Override
    public String vratiVrednostiUpdate() {

        return "nazivKnjige='" + nazivKnjige + "',zanr='" + zanr + "',cena=" + cena + ",idStope=" + poreskaStopa.getIdStope() + ",idAutora=" + autor.getIdAutora();

    }

    @Override
    public String vratiIdentifikator() {

        return "sifraKnjige=" + sifraKnjige;
    }

    @Override
    public String vratiAlijas() {

        return "a";
    }

    @Override
    public String vratiJoin() {

        return "join autor p on a.idAutora=p.idAutora join poreskaStopa t on a.idStope= t.idStope";
    }

    @Override
    public String vratiWhereZaSelect() {

        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws SQLException {

        ArrayList<OpstiDomenskiObjekat> listaKnjiga = new ArrayList<>();

        Knjiga knjiga;
        while (rs.next()) {
            knjiga = new Knjiga();
            knjiga.setSifraKnjige(rs.getInt("sifraKnjige"));
            knjiga.setNazivKnjige(rs.getString("nazivKnjige"));
            knjiga.setCena(rs.getDouble("cena"));
            knjiga.setZanr(rs.getString("zanr"));

            Autor a = new Autor();
            a.setIdAutora(rs.getInt("idAutora"));
            a.setImePrezime(rs.getString("imePrezime"));

            knjiga.setAutor(a);

            PoreskaStopa ps = new PoreskaStopa();
            ps.setIdStope(rs.getInt("idStope"));
            ps.setProcenat(rs.getInt("procenat"));

            knjiga.setPoreskaStopa(ps);

            listaKnjiga.add(knjiga);

        }

        return listaKnjiga;
    }

}
