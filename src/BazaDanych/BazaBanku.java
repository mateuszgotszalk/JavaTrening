package BazaDanych;

import java.sql.*;

public class BazaBanku {

    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/trening";
        String user = "root";
        String pw = "root";
        try{
            Connection con = DriverManager.getConnection(url,user,pw);
            System.out.println();
            System.out.println("polaczylo sie w chuj ziomeczku sztywniotko jest");

            Statement statement = con.createStatement();

            ResultSet rs;

            rs = statement.executeQuery("select * from heroes");
            System.out.println("id \t   name \t     rodzenstwo");
            while (rs.next()){

                System.out.println(rs.getString(1) + "\t  " + rs.getString(2) + "\t  "  + rs.getString(3));
            }

            rs.close();

            /*PreparedStatement ps = con.prepareStatement("INSERT INTO heroes (id, name,rodzeństwo) VALUES (8,'Przemek',4)");
            ps.executeUpdate();
            System.out.println("Zrobilo sie ......................");

            ps.close();*/

            System.out.println("*--------------------------------*");

            rs = statement.executeQuery("select id, name from heroes");

            System.out.println();
            System.out.println("id \t   name \t     ");
            while (rs.next()){

                System.out.println(rs.getString(1) + "\t  " + rs.getString(2));
            }

            rs.close();

            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
