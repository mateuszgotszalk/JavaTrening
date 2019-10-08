package BazaDanych;

import java.sql.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DBconnection {
    private static String url = "jdbc:mysql://localhost:3306/mydb";
    private static String user = "root";
    private static String pw = "root";
    private static Connection conn = null;

    public Connection connect(){

        try {
            conn = DriverManager.getConnection(url, user, pw);
            System.out.println();
            System.out.println("polaczylo sie w chuj ziomeczku sztywniotko jest");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public void disconnect(){
        try {
            conn.close();
            System.out.println();
            System.out.println("baza biura disconnect");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void changeDB(String polecenie) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(polecenie);
        ps.executeUpdate();
        System.out.println("*-------Zaktualizowano baze-------*");
        ps.close();
    }

    public static ResultSet getDataFromDB(String polecenie){
        Statement statement;
        ResultSet rs=null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(polecenie);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            return rs;
        }
    }

    public static void wprowadzPrzewodnika(String imie, String nazwisko, int telefon) throws SQLException {
        String polecenie = "INSERT INTO przewodnik" +
                "(idPrzewodnik, Imie, Nazwisko, telefon)" +
                "VALUES (" +
                "NULL" + ", " +
                "'" + imie+ "'" + ", " +
                "'" + nazwisko+ "'" + ", " +
                "'" + telefon + "'" +
                ")";

        System.out.println("Wprowadzono przewodnika xD");

        changeDB(polecenie);
    }

    public static void wprowadzMiejsce(String kraj, String miasto, String  hotel) throws SQLException{
        String polecenie = "INSERT INTO miejsce" +
                "(idMiejsce, kraj, miasto, hotel)" +
                "VALUES (" +
                "NULL" + ", " +
                "'" + kraj+ "'" + ", " +
                "'" + miasto+ "'" + ", " +
                "'" + hotel + "'" +
                ")";

                changeDB(polecenie);
    }

    public static void wprowadzOsobe(int pesel, String imie, String nazwisko, Date dataUrodzenia) throws SQLException{
        String polecenie = "INSERT INTO osoba" +
                "(PESEL, Imie, Nazwisko, DataUrodzenia)" +
                "VALUES (" +
                pesel +", " +
                "'" + imie+ "'" +", " +
                "'" + nazwisko+ "'" +", " +
                "'" + dataUrodzenia + "'" +
                ")";

        changeDB(polecenie);
    }

    public static void wprowadzOferte(int cena, String miejsceWylotuPrzylotu, String rodzajStandardu, Date dataWylotu, Date dataPrzylotu, int Miejsce_idMiejsce) throws SQLException{
        String polecenie = "INSERT INTO oferta" +
                "(idOferta, cena, rodzajStandardu, dataWylotu, dataPrzylotu, miejsceWylotuPrzylotu, Miejsce_idMiejsce)" +
                "VALUES (" +
                "NULL" + ", " +
                "" + cena+ "" + ", " +
                "'" + rodzajStandardu+ "'" + ", " +
                "'" + dataWylotu+ "'" + ", " +
                "'" + dataPrzylotu+ "'" + ", " +
                "'" + miejsceWylotuPrzylotu + "'" + ", " +
                "" + Miejsce_idMiejsce+ "" +
                ")";

        changeDB(polecenie);
    }

    public static void wprowadzWycieczke(int koszt, int liczbaOsob, int osoba_PESEL,
                                  int oferta_idOferta, int Przewodnik_idPrzewodnik, int Status_idStatus) throws SQLException{
        String polecenie = "INSERT INTO wycieczka" +
                "(idWycieczka, liczbaOsob, koszt, osoba_PESEL," +
                " oferta_idOferta, Przewodnik_idPrzewodnik, Status_idStatus)" +
                "VALUES (" +
                "NULL" + ", " +
                "'" + liczbaOsob+ "'" + ", " +
                "'" + koszt+ "'" + ", " +
                "'" + osoba_PESEL+ "'" + ", " +
                "'" + oferta_idOferta+ "'" + ", " +
                "'" + Przewodnik_idPrzewodnik+ "'" + ", " +
                "'" + Status_idStatus + "'" +
                ")";

        changeDB(polecenie);
    }

    public static void wprowadzStatus(String nazwaStatus) throws SQLException{
        String polecenie = "INSERT INTO status" +
                "(idStatus, nazwaStatus)" +
                "VALUES (" +
                "NULL" + ", " +
                "'" + nazwaStatus+ "'" +
                ")";

        changeDB(polecenie);
    }

    public static LinkedList<Przewodnik> showPrzewodnicy() throws SQLException {
        String polecenie = "SELECT * FROM przewodnik";

        LinkedList<Przewodnik> lista = new LinkedList<>();

        int id, telefon;
        String imie, nazwisko;

        ResultSet rs = getDataFromDB(polecenie);

        while (rs.next()){
            id = rs.getInt("idPrzewodnik");
            telefon = rs.getInt("telefon");
            imie = rs.getString("Imie");
            nazwisko = rs.getString("Nazwisko");
            lista.add(new Przewodnik(id, imie,nazwisko,telefon));
        }
        rs.close();
        return lista;
    }

    public static LinkedList<Osoba> showOsoba() throws SQLException{
        LinkedList<Osoba> lista = new LinkedList<>();
        int pesel;
        String imie , nazwisko;
        Date dataUrodzenia;
        String polecenie = "SELECT * FROM osoba";

        ResultSet rs =  getDataFromDB(polecenie);

        while(rs.next()){
            pesel = rs.getInt("pesel");
            imie = rs.getString("imie");
            nazwisko = rs.getString("nazwisko");
            dataUrodzenia = rs.getDate("dataUrodzenia");
            lista.add(new Osoba(pesel,imie,nazwisko,dataUrodzenia));
        }

        rs.close();
        return lista;
    }

    public static LinkedList<?> showWycieczki() throws SQLException {

        LinkedList lista = new LinkedList<>();

        int idWycieczka, koszt, liczbaOsob, osoba_PESEL, miejsce_idMiejsce,
            oferta_idOferta, Przewodnik_idPrzewodnik,  Status_idStatus;

        String polecenie = "SELECT * FROM wycieczka";

        ResultSet rs = getDataFromDB(polecenie);

        while (rs.next()){
            idWycieczka = rs.getInt("idWycieczka");
            liczbaOsob = rs.getInt("liczbaOsob");
            koszt  = rs.getInt("koszt");
            osoba_PESEL= rs.getInt("osoba_PESEL");
            oferta_idOferta = rs.getInt("oferta_idOferta");
            Przewodnik_idPrzewodnik = rs.getInt("Przewodnik_idPrzewodnik");
            Status_idStatus = rs.getInt("Status_idStatus");
            lista.add(new Wycieczka(idWycieczka, koszt, liczbaOsob, osoba_PESEL,
                          oferta_idOferta, Przewodnik_idPrzewodnik,  Status_idStatus));
        }
        rs.close();
        return lista;
    }

    public static LinkedList<?> showOferty() throws SQLException {

        LinkedList lista = new LinkedList<>();

        int idOferta, cena, Miejsce_idMiejsce;
        String miejsceWylotuPrzylotu, rodzajStandardu;
        Date dataWylotu, dataPrzylotu;

        String polecenie = "SELECT * FROM oferta";

        ResultSet rs = getDataFromDB(polecenie);

        while (rs.next()){
            idOferta = rs.getInt("idOferta");
            cena = rs.getInt("cena");
            dataWylotu = rs.getDate("dataWylotu");
            dataPrzylotu = rs.getDate("dataPrzylotu");
            miejsceWylotuPrzylotu = rs.getString("miejsceWylotuPrzylotu");
            rodzajStandardu = rs.getString("rodzajStandardu");
            Miejsce_idMiejsce = rs.getInt("Miejsce_idMiejsce");
            lista.add(new Oferta(idOferta, cena, miejsceWylotuPrzylotu, rodzajStandardu, dataWylotu, dataPrzylotu, Miejsce_idMiejsce));
        }
        rs.close();
        return lista;
    }

    public static LinkedList<?> showMiejsca() throws SQLException {
        LinkedList lista = new LinkedList<>();

        int idMiejsce;
        String kraj, miasto, hotel;

        String polecenie = "SELECT * FROM miejsce";

        ResultSet rs = getDataFromDB(polecenie);

        while (rs.next()){
            idMiejsce = rs.getInt("idMiejsce");
            kraj = rs.getString("kraj");
            miasto = rs.getString("miasto");
            hotel = rs.getString("hotel");
            lista.add(new Miejsce(idMiejsce, kraj, miasto, hotel));
        }
        rs.close();
        return lista;
    }

    public static LinkedList<?> showStatusy() throws SQLException {
        LinkedList lista = new LinkedList<>();

        int idStatus;
        String nazwaStatus;

        String polecenie = "SELECT * FROM status";

        ResultSet rs = getDataFromDB(polecenie);

        while (rs.next()){
            idStatus = rs.getInt("idStatus");
            nazwaStatus = rs.getString("nazwaStatus");
            lista.add(new Status(idStatus, nazwaStatus));
        }
        rs.close();
        return lista;
    }

    public static void updatePrzewodnik(int idPrzewodnik, String imie, String nazwisko, int telefon) throws SQLException {
        String polecenie = "UPDATE przewodnik SET " +
                "imie = '" + imie + "' , " +
                "nazwisko=  '"+ nazwisko+ "' , " +
                "telefon = " + telefon +  " " +
                "WHERE idPrzewodnik = " + idPrzewodnik;

        changeDB(polecenie);
    }
    public static void updateOferta(int idOferta, int cena, String miejscePrzylotuWylotu, String rodzajStandardu, Date dataWylotu, Date dataPrzylotu, int Miejsce_idMiejsce) throws SQLException {
        String polecenie = "UPDATE oferta SET " +
                "cena = '" + cena + "' , " +
                "miejscePrzylotuWylotu =  '"+ miejscePrzylotuWylotu+ "' , " +
                "rodzajStandardu = '" + rodzajStandardu +  "' , " +
                "dataWylotu = '" + dataWylotu +  "' , " +
                "dataPrzylotu = '" + dataPrzylotu +  "' , " +
                "Miejsce_idMiejsce = '" + Miejsce_idMiejsce +  "' " +
                "WHERE idOferta = " + idOferta;
        changeDB(polecenie);
    }
    public static void updateMiejsce(int idMiejsce, String kraj, String miasto, String  hotel) throws SQLException {
        String polecenie = "UPDATE miejsce SET " +
                "kraj = '" + kraj + "' , " +
                "miasto=  '"+ miasto+ "' , " +
                "hotel = '" + hotel +  "' " +
                "WHERE idMiejsce = " + idMiejsce;
        changeDB(polecenie);
    }
    public static void updateWycieczka(int idWycieczka, int koszt, int liczbaOsob, int osoba_PESEL, int miejsce_idMiejsce,
                                       int oferta_idOferta, int Przewodnik_idPrzewodnik, int Status_idStatus) throws SQLException {
        String polecenie = "UPDATE wycieczka SET " +
                "koszt = '" + koszt + "' , " +
                "liczbaOsob=  '"+ liczbaOsob+ "' , " +
                "osoba_PESEL = " + osoba_PESEL +  "' , " +
                "miejsce_idMiejsce = " + miejsce_idMiejsce +  "' , " +
                "oferta_idOferta = " + oferta_idOferta +  "' , " +
                "Przewodnik_idPrzewodnik = " + Przewodnik_idPrzewodnik +  "' , " +
                "Status_idStatus = " + Status_idStatus +  "' " +
                "WHERE idWycieczka = " + idWycieczka;
        changeDB(polecenie);
    }
    public static void updateStatus(int idStatus, String nazwaStatus) throws SQLException {
        String polecenie = "UPDATE status SET " +
                "nazwaStatus = '" + nazwaStatus + "' " +
                "WHERE idStatus = " + idStatus;
        changeDB(polecenie);
    }
    public static void updateOsoba(int pesel, String imie, String nazwisko, Date dataUrodzenia) throws SQLException {
        String polecenie = "UPDATE oferta SET " +
                "imie = '" + imie + "' , " +
                "nazwisko =  '"+ nazwisko+ "' , " +
                "dataUrodzenia = '" + dataUrodzenia +  "' " +
                "WHERE pesel = " + pesel;
        changeDB(polecenie);
    }
    public static void wycieczkiOsoby(int pesel) throws SQLException {
        String polecenie = "SELECT osoba.pesel , osoba.imie, osoba.nazwisko, wycieczka.idWycieczka, " +
                "wycieczka.koszt, oferta.dataWylotu, oferta.dataPrzylotu, oferta.miejsceWylotuPrzylotu, " +
                "miejsce.miasto, miejsce.hotel FROM osoba, wycieczka, miejsce, oferta WHERE osoba.PESEL = wycieczka.osoba_PESEL " +
                "AND osoba.pesel= " + pesel + " AND miejsce.idMiejsce=oferta.Miejsce_idMiejsce" +
                " AND wycieczka.oferta_idOferta=oferta.idOferta ";
        ResultSet rs = getDataFromDB(polecenie);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^");
        while(rs.next()){
            System.out.println(rs.getInt(1) + "  " +
                                rs.getString(2) + "  " +
                                rs.getString(3) + "  " +
                                rs.getInt(4) + "  " +
                                rs.getInt(5) + "  " +
                                rs.getDate(6) + "  " +
                                rs.getDate(7) + "  " +
                                rs.getString(8) + "  " +
                                rs.getString(9) + "  " +
                                rs.getString(10) + "  ");
        }
        rs.close();
    }
    public static void zrealizowane() throws SQLException{
        String polecenie ="SELECT wycieczka.idWycieczka, wycieczka.koszt, wycieczka.osoba_PESEL, status.nazwaStatus" +
                " FROM wycieczka, status WHERE Status_idStatus = 1 AND wycieczka.Status_idStatus= status.idStatus";

        ResultSet rs = getDataFromDB(polecenie);

        while (rs.next()){
            System.out.println(rs.getInt("idWycieczka") + "  " +
            rs.getInt("koszt")+ "  " +
            rs.getInt("osoba_PESEL")+ "  " +
            rs.getString("nazwaStatus"));
        }
        rs.close();
    }

}

/*wycieczka.idWycieczka, wycieczka.liczbaOsob, wycieczka.koszt, wycieczka.osoba_PESEL, " +
                "oferta.*/
