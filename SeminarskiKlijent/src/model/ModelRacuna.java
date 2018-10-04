/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Racun;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author orlov
 */
public class ModelRacuna extends AbstractTableModel {

    private ArrayList<Racun> racuni;

    public ModelRacuna() {
        racuni = new ArrayList<>();
    }

    public ModelRacuna(ArrayList<Racun> racuni) {
        this.racuni = racuni;
    }

    @Override
    public int getRowCount() {

        return racuni.size();
    }

    @Override
    public int getColumnCount() {

        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {

        Racun r = racuni.get(i);

        switch (i1) {
            case 0:
                return r.getIdRacuna();
            case 1:
                return r.getUkupanIznos();
            case 2:
                return r.getDatum();
            case 3:
                return r.getProdavac();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {

        switch (i) {
            case 0:
                return "ID racuna";
            case 1:
                return "Ukupan iznos";
            case 2:
                return "Datum";
            case 3:
                return "Prodavac";
            default:
                return "";
        }
    }

    public void dodaj(Racun r) {

        racuni.add(r);
        fireTableDataChanged();
    }

    public ArrayList<Racun> getRacuni() {
        return racuni;
    }

    public void setRacuni(ArrayList<Racun> racuni) {
        this.racuni = racuni;
    }

    public Racun dajIzabrani(int izabrani) {

        return racuni.get(izabrani);
    }

    
}
