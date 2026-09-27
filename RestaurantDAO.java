package FoodOrdering;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RestaurantDAO {

    public ArrayList<Restaurant> getAllRestaurants() {

        ArrayList<Restaurant> restaurants = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM restaurants";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Restaurant restaurant = new Restaurant(
                    rs.getInt("restaurant_id"),
                    rs.getString("restaurant_name"),
                    rs.getString("city"),
                    rs.getDouble("rating")
                );

                restaurants.add(restaurant);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return restaurants;
    }
}