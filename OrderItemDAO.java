package FoodOrdering;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderItemDAO {

    public void addOrderItem(OrderItem orderItem) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO order_item "
                    + "(order_id, item_id, quantity, item_price) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, orderItem.getOrderId());
            ps.setInt(2, orderItem.getItemId());
            ps.setInt(3, orderItem.getQuantity());
            ps.setDouble(4, orderItem.getItemPrice());

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
