package lt.bta.java2.db;

import java.sql.*;

public class ReadCheck {

    public static void main(String[] args) {

        final String URL = "jdbc:mysql://localhost:3306/java2";
        final String USER = "java2";
        final String PASSWD = "123";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWD)) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name from employee order by name");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }


            System.out.println("prepared statement:");

            PreparedStatement ps = con.prepareStatement("select * from employee where id = ?");
            ps.setInt(1, 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
