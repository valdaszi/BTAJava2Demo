package lt.bta.java2.db;

import java.sql.*;

public class ReadCheck {

    public static void main(String[] args) {

        //final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/employees";
        final String USER = "java2";
        final String PASSWD = "123";

        //Class.forName(JDBC_DRIVER);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWD)) {

            //System.out.println(DriverManager.getDriver(URL).getClass().getName());

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select emp_no, first_name, last_name from employees order by last_name, first_name limit 10");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3));
            }

            System.out.println("prepared statement:");

            PreparedStatement ps = con.prepareStatement("select * from employees where emp_no = ?");
            ps.setInt(1, 12345);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("emp_no") + "  " +
                        rs.getString("first_name") + " " +
                        rs.getString("last_name") + " " +
                        rs.getString("gender") + " " +
                        rs.getDate("birth_date") + " " +
                        rs.getDate("hire_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
