package FoodOrdering;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReviewDAO {

    public void addReview(Review review) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO reviews "
                    + "(customer_id, restaurant_id, order_id, rating, review_text) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, review.getCustomerId());
            ps.setInt(2, review.getRestaurantId());
            ps.setInt(3, review.getOrderId());
            ps.setInt(4, review.getRating());
            ps.setString(5, review.getReviewText());

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}