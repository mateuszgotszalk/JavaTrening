package BazaDanych;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Status {

    private int idStatus;
    private String nazwaStatus="";

    public Status(int idStatus, String nazwaStatus) {

        this.idStatus = idStatus;
        this.nazwaStatus = nazwaStatus;
    }

    public void deleteStatus(DBconnection dBconnection)throws SQLException{
        String polecenie = "DELETE FROM status WHERE idStatus="+this.idStatus;
        dBconnection.changeDB(polecenie);
    }


    public String getNazwaStatus() {
        return nazwaStatus;
    }

    public void setNazwaStatus(String nazwaStatus) {
        this.nazwaStatus = nazwaStatus;
    }

    @Override
    public String toString() {
        return idStatus + "  " + nazwaStatus;
    }
}
