package BazaDanych;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wycieczka {

    private int idWycieczka;
    private int koszt;
    private int liczbaOsob;
    private int osoba_PESEL;
    private int oferta_idOferta;
    private int Przewodnik_idPrzewodnik;
    private int Status_idStatus;

    public Wycieczka(int idWycieczka, int koszt, int liczbaOsob, int osoba_PESEL,
                     int oferta_idOferta, int Przewodnik_idPrzewodnik, int Status_idStatus){

        this.liczbaOsob = liczbaOsob;
        this.koszt = koszt;
        this.osoba_PESEL = osoba_PESEL;
        this.idWycieczka = idWycieczka;
        this.oferta_idOferta = oferta_idOferta;
        this.Przewodnik_idPrzewodnik = Przewodnik_idPrzewodnik;
        this.Status_idStatus = Status_idStatus;
    }

    public void deleteWycieczka(DBconnection dBconnection)throws SQLException{
        String polecenie = "DELETE FROM wycieczka WHERE idWycieczka="+this.idWycieczka;
        dBconnection.changeDB(polecenie);
    }

    public int getKoszt() {
        return koszt;
    }

    public void setKoszt(int koszt) {
        this.koszt = koszt;
    }

    public int getLiczbaOsob() {
        return liczbaOsob;
    }

    public void setLiczbaOsob(int liczbaOsob) {
        this.liczbaOsob = liczbaOsob;
    }

    public int getOsoba_PESEL() {
        return osoba_PESEL;
    }

    public void setOsoba_PESEL(int osoba_PESEL) {
        this.osoba_PESEL = osoba_PESEL;
    }

    public int getOferta_idOferta() {
        return oferta_idOferta;
    }

    public int getPrzewodnik_idPrzewodnik() {
        return Przewodnik_idPrzewodnik;
    }

    public void setPrzewodnik_idPrzewodnik(int przewodnik_idPrzewodnik) {
        this.Przewodnik_idPrzewodnik = przewodnik_idPrzewodnik;
    }

    public int getStatus_idStatus() {
        return Status_idStatus;
    }

    public void setStatus_idStatus(int status_idStatus) {
        this.Status_idStatus = status_idStatus;
    }

    @Override
    public String toString() {
        return idWycieczka + "  " + koszt + "  " + liczbaOsob + "  " + osoba_PESEL+ "  " + oferta_idOferta
                + "  " + Przewodnik_idPrzewodnik + "  " + Status_idStatus;
    }
}
