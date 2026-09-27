package FoodOrdering;

public class Restaurant {
	private int restaurantId;
    private String restaurantName;
    private String city;
    private double rating;

    public Restaurant(int restaurantId, String restaurantName,
                      String city, double rating) {

        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.city = city;
        this.rating = rating;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getCity() {
        return city;
    }

    public double getRating() {
        return rating;
    }

}
