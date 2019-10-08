package BazaDanych;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Miejsce {

    private int idMiejsce;
    private String kraj="";
    private String miasto="";
    private String hotel="";

    public Miejsce(int idMiejsce, String kraj, String miasto, String  hotel){
        this.kraj = kraj;
        this.miasto = miasto;
        this.hotel = hotel;
        this.idMiejsce = idMiejsce;
    }

    public void deleteMiejsce(DBconnection dBconnection)throws SQLException{
        String polecenie = "DELETE FROM miejsce WHERE idMiejsce="+this.idMiejsce;
        dBconnection.changeDB(polecenie);
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return idMiejsce + "  " + kraj + "  " + miasto + "  " + hotel;
    }
}
