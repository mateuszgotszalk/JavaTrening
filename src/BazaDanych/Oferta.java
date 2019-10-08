package BazaDanych;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Oferta {
    private int idOferta;
    private int cena;
    private int Miejsce_idMiejsce;
    private Date dataWylotu;
    private Date dataPrzylotu;
    private String miejsceWylotuPrzylotu = "";
    private String rodzajStandardu = "";

    public Oferta(int idOferta, int cena, String miejsceWylotuPrzylotu, String rodzajStandardu, Date dataWylotu, Date dataPrzylotu, int Miejsce_idMiejsce) {
        this.cena = cena;
        this.miejsceWylotuPrzylotu = miejsceWylotuPrzylotu;
        this.rodzajStandardu = rodzajStandardu;
        this.idOferta = idOferta;
        this.dataWylotu = dataWylotu;
        this.dataPrzylotu = dataPrzylotu;
        this.Miejsce_idMiejsce = Miejsce_idMiejsce;
    }

    public int getIdOferta() {
        return idOferta;
    }


    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Date getDataWylotu() {
        return dataWylotu;
    }

    public void setDataWylotu(Date dataWylotu) {
        this.dataWylotu = dataWylotu;
    }

    public Date getDataPrzylotu() {
        return dataPrzylotu;
    }

    public void setDataPrzylotu(Date dataPrzylotu) {
        this.dataPrzylotu = dataPrzylotu;
    }

    public String getMiejscePrzylotuWylotu() {
        return miejsceWylotuPrzylotu;
    }

    public void setMiejscePrzylotuWylotu(String miejscePrzylotuWylotu) {
        this.miejsceWylotuPrzylotu = miejscePrzylotuWylotu;
    }

    public String getRodzajStandardu() {
        return rodzajStandardu;
    }

    public void setRodzajStandardu(String rodzajStandardu) {
        this.rodzajStandardu = rodzajStandardu;
    }

    public void deleteOferta(DBconnection dBconnection)throws SQLException{
        String polecenie = "DELETE FROM oferta WHERE idOferta="+this.idOferta;
        dBconnection.changeDB(polecenie);
    }

    public int getMiejsce_idMiejsce() {
        return Miejsce_idMiejsce;
    }

    public void setMiejsce_idMiejsce(int miejsce_idMiejsce) {
        Miejsce_idMiejsce = miejsce_idMiejsce;
    }

    @Override
    public String toString() {
        return idOferta + "  " + cena +"  "+ Miejsce_idMiejsce+"  " + dataWylotu+"  " + dataPrzylotu+
                "  " + miejsceWylotuPrzylotu+"  " + rodzajStandardu;
    }
}
