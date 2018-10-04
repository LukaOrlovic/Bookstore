/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.StavkaRacuna;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author orlov
 */
public class ModelStavki extends AbstractTableModel{

    private ArrayList<StavkaRacuna> stavke;
    private ArrayList<StavkaRacuna> izmenjene = new ArrayList<>();

    public ModelStavki() {
        stavke = new ArrayList<>();
        izmenjene = new ArrayList<>();
        izmenjene.add(new StavkaRacuna());
    }

    public ModelStavki(ArrayList<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }
    
    @Override
    public int getRowCount() {

        return stavke.size();
    }

    @Override
    public int getColumnCount() {

        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {

        StavkaRacuna sr = stavke.get(i);
        
        switch(i1){
            case 0:
                return sr.getKnjiga();
            case 1:
                return sr.getKolicina();
            case 2:
                return sr.getCena();
            default: 
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:
                return "Knjiga";
            case 1:
                return "Kolicina";
            case 2:
                return "Cena";
            default:
                return "";
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        switch(i1){
            case 1: return true;
            default: return false;
        }
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        
        if((int)o < 0){
            return;
        }
        
        if(i1 == 1){
            stavke.get(i).setKolicina(Integer.parseInt((String) o));
            izmenjene.add(stavke.get(i));
        }
    } 

    public ArrayList<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }


    public void dodaj(StavkaRacuna stavka) {

        stavke.add(stavka);
        for (StavkaRacuna sr : stavke) {
            System.out.println(sr.getKnjiga().getNazivKnjige());
        }
        fireTableDataChanged();
    }

    public void izbaci(int izabrana) {

        stavke.remove(izabrana);
        fireTableDataChanged();
    }

    public ArrayList<StavkaRacuna> getIzmenjene() {
        return izmenjene;
    }

    public void setIzmenjene(ArrayList<StavkaRacuna> izmenjene) {
        this.izmenjene = izmenjene;
    }
    
}
