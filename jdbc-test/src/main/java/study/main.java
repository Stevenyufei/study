package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mysql80";

    private static final String USER = "sma";
    private static final String PASSWORD = "***";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {

            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            String sql = " SELECT * FROM test";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                String line = rs.getString("LINE");
                System.out.println(line);
            }
            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
