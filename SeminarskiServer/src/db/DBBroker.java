/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Knjiga;
import domen.OpstiDomenskiObjekat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 *
 * @author orlov
 */
public class DBBroker {

    private static DBBroker instance;
    Connection connection;
    Properties properties;

    private DBBroker() {
    }

//    getInstance():DBBroker
//    uspostaviKonekciju():void
//    commitTransakciju():void
//    rollbackTransakciju():void
//    zatvoriKonekciju():void
//    sacuvajAktivnost(Aktivnost a):void
//    vratiID(String maticni):int
//    sacuvaj(OpstiDomenskiObjekat odo):void
//    izmeni(OpstiDomenskiObjekat odo):void
//    obrisi(OpstiDomenskiObjekat odo):void
//    selektuj(OpstiDomenskiObjekat odo):ResultSet
    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void uspostaviKonekciju() throws FileNotFoundException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileInputStream fis = null;
        fis = new FileInputStream("settings.properties");
        properties = new Properties();
        properties.load(fis);
        String url = "jdbc:mysql://localhost:3306/1baza";
        String user = properties.getProperty("user");
        String pass = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Konektovao se");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void commitTransakciju() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollbackTransakciju() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zatvoriKonekciju() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int vratiID(OpstiDomenskiObjekat odo) throws SQLException {

        int id = 0;

        Statement naredba = connection.createStatement();
        String upit = "select idRacuna as nesto from " + odo.vratiImeTabele() + " " + odo.vratiWhereZaSelect();

        System.out.println("stiglo posle ovoga ");
        System.out.println(upit);
        ResultSet rs = naredba.executeQuery(upit);
        while (rs.next()) {
            id = rs.getInt("nesto");
        }
        System.out.println("iiiiiiiiiiddddd " + id);
        return id;
    }

    public void sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiImeTabele() + " (" + odo.vratiKoloneZaInsert() + ") VALUES (" + odo.vratiVrednostiInsert() + ")";
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "UPDATE  " + odo.vratiImeTabele() + " SET " + odo.vratiVrednostiUpdate() + " WHERE " + odo.vratiIdentifikator();
        System.out.println("UPDATEEEEEEEEEEEEE " + upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.vratiImeTabele() + " WHERE " + odo.vratiIdentifikator();
        System.out.println("OBRISI TEMU " + upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public ResultSet selektuj(OpstiDomenskiObjekat odo) throws SQLException {

        String upit = "SELECT * FROM " + odo.vratiImeTabele() + " " + odo.vratiAlijas() + " " + odo.vratiJoin() + " " + odo.vratiWhereZaSelect();
        System.out.println(upit);
        Statement s = connection.createStatement();
        return s.executeQuery(upit);
    }

}
