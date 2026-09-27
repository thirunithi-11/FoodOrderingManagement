package FoodOrdering;

public class Review {

    private int customerId;
    private int restaurantId;
    private int orderId;
    private int rating;
    private String reviewText;

    public Review(int customerId, int restaurantId, int orderId,
                  int rating, String reviewText) {

        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.orderId = orderId;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewText() {
        return reviewText;
    }
}