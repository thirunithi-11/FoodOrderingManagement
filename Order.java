package FoodOrdering;

public class Order {

    private int orderId;
    private int customerId;
    private int restaurantId;
    private String status;
    private double subtotal;
    private double gst;
    private double deliveryCharge;
    private double totalAmount;

    public Order(int orderId, int customerId, int restaurantId,
                 String status, double subtotal, double gst,
                 double deliveryCharge, double totalAmount) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.status = status;
        this.subtotal = subtotal;
        this.gst = gst;
        this.deliveryCharge = deliveryCharge;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getStatus() {
        return status;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getGst() {
        return gst;
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}