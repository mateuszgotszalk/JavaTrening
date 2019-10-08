package BazaDanych;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Osoba {

    private int pesel=0;
    private String imie="";
    private String nazwisko="";
    private Date dataUrodzenia;

    public Osoba(int pesel, String imie, String nazwisko, Date dataUrodzenia){
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
    }

    public void deleteOsoba(DBconnection dBconnection)throws SQLException{
        String polecenie = "DELETE FROM osoba WHERE PESEL="+this.pesel;
        dBconnection.changeDB(polecenie);
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public int getPesel() {
        return pesel;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    @Override
    public String toString() {
        return pesel + "  " + imie + "  " + nazwisko + "  " + dataUrodzenia;
    }

}
