package BazaDanych;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Miejsce {

    private int idMiejsce;
    private String kraj="";
    private String miasto="";
    private String hotel="";

    public Miejsce(int idPrzewodnik, String kraj, String miasto, String  hotel){
        this.idMiejsce = idPrzewodnik;
        this.kraj = kraj;
        this.miasto = miasto;
        this.hotel = hotel;
    }

    public static void showMiejsca(DBconnection dBconnection) throws SQLException {
        String polecenie = "SELECT * FROM miejsce";

        ResultSet rs = dBconnection.getDataFromDB(polecenie);

        System.out.println("id Miejsca  \t     kraj     \t miasto    \t hotel");
        while (rs.next()){
            System.out.println(
                    rs.getString("idMiejsce") + "\t  " +
                            rs.getString("kraj") + "\t  " +
                            rs.getString("miasto") + "\t  " +
                            rs.getString("hotel"));
        }
        rs.close();
    }

    public void wprowadzMiejsce(DBconnection dBconnection) throws SQLException{
        String polecenie = "INSERT INTO miejsce" +
                "(idMiejsce, kraj, miasto, hotel)" +
                "VALUES (" +
                this.idMiejsce +
                "'" + this.kraj+ "'" +
                "'" + this.miasto+ "'" +
                "'" + this.hotel + "'" +
                ")";

        dBconnection.changeDB(polecenie);
    }

    public void setMiejsce(DBconnection dBconnection,int idMiejsce1,String kraj1, String miasto1, String hotel1) throws SQLException{
        String polecenie = "UPDATE miejsce SET" +
                "idMiejsce="+ idMiejsce1 + ", " +
                "kraj=" + "'"+ kraj1 +"'"+ ", " +
                "miasto=" + "'"+ miasto1 +"'"+ ", " +
                "hotel=" + "'"+ hotel1 +"' " + ", " +
                "WHERE " + "idMiejsce = "+ this.idMiejsce;

        dBconnection.changeDB(polecenie);

        this.hotel = hotel1;
        this.miasto = miasto1;
        this.kraj = kraj1;
        this.idMiejsce = idMiejsce1;
    }

    public void setKraj(DBconnection dBconnection, String kraj) throws SQLException {
        String polecenie = "UPDATE miejsce SET " +
                "kraj=" + "'"+ kraj +"' "+
                "WHERE idMiejsce = '"+ this.idMiejsce+"'";
        dBconnection.changeDB(polecenie);
        this.kraj = kraj;
    }

    public void setMiasto(DBconnection dBconnection, String miasto) throws SQLException {
        String polecenie = "UPDATE miejsce SET " +
                "miasto=" + "'"+ miasto +"' "+
                "WHERE idMiejsce = '"+ this.idMiejsce+"'";
        dBconnection.changeDB(polecenie);
        this.miasto = miasto;
    }

    public void setHotel(DBconnection dBconnection, String hotel) throws SQLException {
        String polecenie = "UPDATE miejsce SET " +
                "hotel=" + "'"+ hotel +"' "+
                "WHERE idMiejsce ="+ this.idMiejsce;
        dBconnection.changeDB(polecenie);
        this.hotel = hotel;
    }

    public void deleteMiejsce(DBconnection dBconnection)throws SQLException{
        String polecenie = "DELETE FROM miejsce WHERE idMiejsce="+this.idMiejsce;
        dBconnection.changeDB(polecenie);
    }

}
