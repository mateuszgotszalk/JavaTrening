package BazaDanych;

public class BazaWycieczek {

    public static void main(String[] args){
        DBconnection dBconnection = new DBconnection();
        dBconnection.connect();
        

        dBconnection.disconnect();
    }
}
