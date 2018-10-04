/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author orlov
 */
public class Racun implements Serializable, OpstiDomenskiObjekat {

    private int idRacuna;
    private double ukupanIznos;
    private Date datum;
    private ArrayList<StavkaRacuna> stavke;
    private Prodavac prodavac;

    public Racun() {
    }

    public Racun(int idRacuna, double ukupanIznos, Date datum, ArrayList<StavkaRacuna> stavke, Prodavac prodavac) {
        this.idRacuna = idRacuna;
        this.ukupanIznos = ukupanIznos;
        this.datum = datum;
        this.stavke = stavke;
        this.prodavac = prodavac;
    }

    public ArrayList<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    public int getIdRacuna() {
        return idRacuna;
    }

    public void setIdRacuna(int idRacuna) {
        this.idRacuna = idRacuna;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    @Override
    public String vratiImeTabele() {

        return "racun";
    }

    @Override
    public String vratiKoloneZaInsert() {

        return "ukupanIznos,datum,idProdavca";
    }

    @Override
    public String vratiVrednostiInsert() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        //String datumString = sdf.format(datum);
        java.sql.Date dateDB = new java.sql.Date(datum.getTime());
        return ukupanIznos + ",'" + dateDB + "'," + getProdavac().getIdProdavca();
    }

    @Override
    public String vratiVrednostiUpdate() {

        java.sql.Date dateDB = new java.sql.Date(datum.getTime());
        return "idRacuna=" + idRacuna + ",ukupanIznos=" + ukupanIznos + ",datum='" + dateDB + "',idProdavca=" + getProdavac().getIdProdavca();
    }

    @Override
    public String vratiIdentifikator() {

        return "idRacuna=" + idRacuna;
    }

    @Override
    public String vratiAlijas() {

        return "p";
    }

    @Override
    public String vratiJoin() {

        return "JOIN prodavac prod on p.idProdavca=prod.idProdavca";
    }

    @Override
    public String vratiWhereZaSelect() {

//        java.sql.Date dateDB = new java.sql.Date(datum.getTime());
//        return "ukupanIznos="+ukupanIznos+"and datum='"+dateDB+"' and idProdavca="+prodavac.getIdProdavca();
       return " where ukupanIznos="+ukupanIznos;
       //return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws SQLException {

        ArrayList<OpstiDomenskiObjekat> listaRacuna = new ArrayList<>();

        Racun racun;
        while (rs.next()) {
            //ArrayList<StavkaRacuna> listaStavki = new ArrayList<>();
            racun = new Racun();
            racun.setIdRacuna(rs.getInt("idRacuna"));
            racun.setUkupanIznos(rs.getDouble("ukupanIznos"));
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            java.sql.Date datumcic = rs.getDate("datum");
            Date datum = new Date(datumcic.getTime());
            racun.setDatum(datum);

            Prodavac p = new Prodavac();
            p.setIdProdavca(rs.getInt("idProdavca"));
            p.setIme(rs.getString("ime"));
            p.setPrezime(rs.getString("prezime"));
            racun.setProdavac(p);
            

            listaRacuna.add(racun);

        }
        System.out.println("sada se pozvala listavrati listu");

        System.out.println(listaRacuna.get(0));
        return listaRacuna;

    }

}
