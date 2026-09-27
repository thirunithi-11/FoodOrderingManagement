package FoodOrdering;

public class OrderItem {

    private int orderId;
    private int itemId;
    private int quantity;
    private double itemPrice;

    public OrderItem(int orderId, int itemId, int quantity, double itemPrice) {

        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}
