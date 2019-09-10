package BazaDanych;

import java.sql.*;

public class DBconnection {
    private  String url = "jdbc:mysql://localhost:3306/mydb";
    private  String user = "root";
    private  String pw = "root";
    Connection conn = null;

    public void connect(){

        try {
            conn = DriverManager.getConnection(url, user, pw);
            System.out.println();
            System.out.println("polaczylo sie w chuj ziomeczku sztywniotko jest");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            conn.close();
            System.out.println();
            System.out.println("baza do banku disconnect");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void changeDB(String polecenie) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(polecenie);
        ps.executeUpdate();
        System.out.println("*-------Zaktualizowano baze-------*");
        ps.close();
    }

    public ResultSet getDataFromDB(String polecenie){
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

}
