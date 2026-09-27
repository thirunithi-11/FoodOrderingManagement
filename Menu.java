package FoodOrdering;

public class Menu {

    private int itemId;
    private int restaurantId;
    private String itemName;
    private String category;
    private String foodType;
    private double price;
    private boolean available;

    public Menu(int itemId, int restaurantId, String itemName,
                String category, String foodType,
                double price, boolean available) {

        this.itemId = itemId;
        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.category = category;
        this.foodType = foodType;
        this.price = price;
        this.available = available;
    }

    public int getItemId() {
        return itemId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public String getFoodType() {
        return foodType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }
}