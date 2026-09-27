package FoodOrdering;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/food_ordering_management",
                "root",
                "Your_Password"
                
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}