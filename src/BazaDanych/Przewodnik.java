package BazaDanych;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Przewodnik {

    private int idPrzewodnik;
    private String imie="";
    private String nazwisko="";
    private int telefon;

    public Przewodnik(int idPrzewodnik, String imie, String nazwisko, int telefon){
        this.idPrzewodnik = idPrzewodnik;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
    }

    public static void showPrzewodnicy(DBconnection dBconnection) throws SQLException {
        String polecenie = "SELECT * FROM przewodnik";

        ResultSet rs = dBconnection.getDataFromDB(polecenie);

        System.out.println("id Przewodnika        \t     Imie     \t Nazwisko    \t telefon");
        while (rs.next()){
            System.out.println(
                    rs.getString("idPrzewodnik") + "\t  " +
                            rs.getString("Imie") + "\t  " +
                            rs.getString("Nazwisko") + "\t  " +
                            rs.getString("telefon"));
        }
        rs.close();
    }

    public void wprowadzPrzewodnika(DBconnection dBconnection) throws SQLException{
        String polecenie = "INSERT INTO przewodnik" +
                "(idPrzewodnik, Imie, Nazwisko, telefon)" +
                "VALUES (" +
                this.idPrzewodnik +
                "'" + this.imie+ "'" +
                "'" + this.nazwisko+ "'" +
                "'" + this.telefon + "'" +
                ")";

        dBconnection.changeDB(polecenie);
    }

    public void setPrzewodnik(DBconnection dBconnection,int idPrzewodnik1,String imie1, String nazwisko1, int telefon1) throws SQLException{
        String polecenie = "UPDATE przewodnik SET" +
                "idPrzewodnik="+ idPrzewodnik1 + ", " +
                "telefon=" + "'"+ telefon1 +"'"+ ", " +
                "Imie=" + "'"+ imie1 +"'"+ ", " +
                "Nazwisko=" + "'"+ nazwisko1 +"' " + ", " +
                "WHERE " + "idPrzewodnik = "+ this.idPrzewodnik;

        dBconnection.changeDB(polecenie);

        this.telefon = telefon1;
        this.imie = imie1;
        this.nazwisko = nazwisko1;
        this.idPrzewodnik = idPrzewodnik1;
    }

    public void setTelefon(DBconnection dBconnection, int telefon) throws SQLException {
        String polecenie = "UPDATE przewodnik SET " +
                "telefon=" + "'"+ telefon +"' "+
                "WHERE idPrzewodnik = '"+ this.idPrzewodnik+"'";
        dBconnection.changeDB(polecenie);
        this.telefon = telefon;
    }


    public void setImie(DBconnection dBconnection, String imie) throws SQLException {
        String polecenie = "UPDATE przewodnik SET " +
                "Imie=" + "'"+ imie +"' "+
                "WHERE idPrzewodnik = '"+ this.idPrzewodnik+"'";
        dBconnection.changeDB(polecenie);
        this.imie = imie;
    }

    public void setNazwisko(DBconnection dBconnection, String nazwisko) throws SQLException {
        String polecenie = "UPDATE przewodnik SET " +
                "Nazwisko=" + "'"+ nazwisko +"' "+
                "WHERE idPrzewodnik ="+ this.idPrzewodnik;
        dBconnection.changeDB(polecenie);
        this.nazwisko = nazwisko;
    }

    public void deletePrzewodnik(DBconnection dBconnection)throws SQLException{
        String polecenie = "DELETE FROM przewodnik WHERE idPrzewodnik="+this.idPrzewodnik;
        dBconnection.changeDB(polecenie);
    }

    /*public void setPesel(DBconnection dBconnection, int pesel1) throws SQLException {
        String polecenie = "UPDATE Osoba SET " +
                "PESEL=" + pesel1 +
                "WHERE PESEL = '"+ this.pesel+"'";
        dBconnection.changeDB(polecenie);
        this.pesel = pesel1;
    }


    public String getDataUrodzenia() {
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
    }*/
}
