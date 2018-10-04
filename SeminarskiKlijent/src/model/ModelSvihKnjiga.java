/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Knjiga;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author orlov
 */
public class ModelSvihKnjiga extends AbstractTableModel {

    private ArrayList<Knjiga> knjige;
    String[] kolone = new String[]{"Sifra", "Naziv", "Zanr", "Cena", "Autor", "Poreska stopa"};

    public ModelSvihKnjiga() {
        knjige = new ArrayList<>();
    }

    public ModelSvihKnjiga(ArrayList<Knjiga> knjige) {
        this.knjige = knjige;
    }

    @Override
    public int getRowCount() {

        return knjige.size();
    }

    @Override
    public int getColumnCount() {

        return kolone.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {

        Knjiga k = knjige.get(i);

        switch (i1) {
            case 0:
                return k.getSifraKnjige();

            case 1:
                return k.getNazivKnjige();

            case 2:
                return k.getZanr();

            case 3:
                return k.getCena();
                
            case 4:
                return k.getAutor();

            case 5:
                return k.getPoreskaStopa();

            default:
                return "Nista";

        }
    }
    
    @Override
    public String getColumnName(int i) {
        
        return kolone[i]; 
    }
    
    public Knjiga vratiKnjigu(int red){
        
        Knjiga knjiga= knjige.get(red);
        
        return knjiga;
    }

    public void postavi() {

        fireTableDataChanged();
    }

    public ArrayList<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(ArrayList<Knjiga> knjige) {
        this.knjige = knjige;
    }

}
