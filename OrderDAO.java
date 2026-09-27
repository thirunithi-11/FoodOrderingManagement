package FoodOrdering;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAO {

    public int createOrder(Order order) {

        int orderId = 0;

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO orders "
                    + "(customer_id, restaurant_id, status, subtotal, gst, "
                    + "delivery_charge, total_amount) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(
                    query,
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, order.getCustomerId());
            ps.setInt(2, order.getRestaurantId());
            ps.setString(3, order.getStatus());
            ps.setDouble(4, order.getSubtotal());
            ps.setDouble(5, order.getGst());
            ps.setDouble(6, order.getDeliveryCharge());
            ps.setDouble(7, order.getTotalAmount());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderId;
    }

    public void updateStatus(int orderId, String status) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE orders SET status = ? WHERE order_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, orderId);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}