package BazaDanych;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Przewodnik {

    private int idPrzewodnik;
    private String imie="";
    private String nazwisko="";
    private int telefon;

    public Przewodnik(int idPrzewodnik, String imie, String nazwisko, int telefon){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.idPrzewodnik = idPrzewodnik;
    }

    public void deletePrzewodnik(DBconnection dBconnection)throws SQLException{
        String polecenie = "DELETE FROM przewodnik WHERE idPrzewodnik="+this.idPrzewodnik;
        dBconnection.changeDB(polecenie);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return idPrzewodnik + "  " + imie + "  " + nazwisko + "  " + telefon;
    }
}
