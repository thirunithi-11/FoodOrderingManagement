package FoodOrdering;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {

    public Customer getCustomerById(int customerId) {

        Customer customer = null;

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM customers WHERE customer_id = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                customer = new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("customer_name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customer;
    }
}