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
 * @author orlov
 */
public class StavkaRacuna implements Serializable,OpstiDomenskiObjekat{

    private int idStavkeRacuna;
    private Knjiga knjiga;
    private int kolicina;
    private double cena;
    private int idRacuna;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int idStavkeRacuna, Knjiga knjiga, int kolicina, double cena) {
        this.idStavkeRacuna = idStavkeRacuna;
        this.knjiga = knjiga;
        this.kolicina = kolicina;
        this.cena = cena;
    }

    public int getIdStavkeRacuna() {
        return idStavkeRacuna;
    }

    public void setIdStavkeRacuna(int idStavkeRacuna) {
        this.idStavkeRacuna = idStavkeRacuna;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String vratiImeTabele() {

        return "stavkaRacuna";
    }

    @Override
    public String vratiKoloneZaInsert() {

        return "idRacuna,ukupnaCena,kolicina,sifraKnjige";
    }

    @Override
    public String vratiVrednostiInsert() {

        return this.idRacuna + "," + cena + "," + kolicina + "," + knjiga.getSifraKnjige();
    }

    @Override
    public String vratiVrednostiUpdate() {

        return "ukupnaCena=" + cena + ",kolicina=" + kolicina + ",sifraKnjige=" + knjiga.getSifraKnjige();
    }

    @Override
    public String vratiIdentifikator() {
        return "idStavkeRacuna=" + idStavkeRacuna;
    }

    @Override
    public String vratiAlijas() {

        return "s";
    }

    @Override
    public String vratiJoin() {

        return "join knjiga k on k.sifraKnjige=s.sifraKnjige join autor a on a.idAutora=k.idAutora join poreskaStopa p on p.idStope=k.idStope";
    }

    @Override
    public String vratiWhereZaSelect() {

        return "where idRacuna="+idRacuna;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws SQLException {

        ArrayList<OpstiDomenskiObjekat> listaStavki = new ArrayList<>();

        StavkaRacuna stavkaRacuna;
        while (rs.next()) {
            stavkaRacuna= new StavkaRacuna();
            stavkaRacuna.setIdStavkeRacuna(rs.getInt("idStavkeRacuna"));
            stavkaRacuna.setCena(rs.getDouble("ukupnaCena"));
            stavkaRacuna.setKolicina(rs.getInt("kolicina"));
            
            Knjiga knjiga = new Knjiga();
            knjiga.setNazivKnjige(rs.getString("nazivKnjige"));
            knjiga.setCena(rs.getDouble("cena"));
            knjiga.setSifraKnjige(rs.getInt("sifraKnjige"));
            knjiga.setZanr(rs.getString("zanr"));

            Autor a = new Autor();
            a.setIdAutora(rs.getInt("idAutora"));
            a.setImePrezime(rs.getString("imePrezime"));
            
            knjiga.setAutor(a);
            
            PoreskaStopa ps = new PoreskaStopa();
            ps.setIdStope(rs.getInt("idStope"));
            ps.setProcenat(rs.getInt("procenat"));
            
            knjiga.setPoreskaStopa(ps);
            
            stavkaRacuna.setKnjiga(knjiga);
            
           
            listaStavki.add(stavkaRacuna);

        }

        return listaStavki;
    }

    public int getIdRacuna() {
        return idRacuna;
    }

    public void setIdRacuna(int idRacuna) {
        this.idRacuna = idRacuna;
    }

}
