package FoodOrdering;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MenuDAO {

    public ArrayList<Menu> getMenuByRestaurantAndType(
            int restaurantId, String foodType) {

        ArrayList<Menu> menuList = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM menu "
                    + "WHERE restaurant_id = ? "
                    + "AND food_type = ? ";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, restaurantId);
            ps.setString(2, foodType);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Menu menu = new Menu(
                    rs.getInt("item_id"),
                    rs.getInt("restaurant_id"),
                    rs.getString("item_name"),
                    rs.getString("category"),
                    rs.getString("food_type"),
                    rs.getDouble("price"),
                    rs.getBoolean("available")
                );

                menuList.add(menu);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuList;
    }
}
