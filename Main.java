package FoodOrdering;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerDAO customerDAO = new CustomerDAO();

        System.out.println("================================================");
        System.out.println("             FOOD ORDERING SYSTEM");
        System.out.println("================================================");

        System.out.print("\nEnter Customer ID: ");
        int customerId = sc.nextInt();

        Customer customer = customerDAO.getCustomerById(customerId);

        if (customer == null) {
            System.out.println("Customer not found!");
            sc.close();
            return;
        }

        System.out.println("\nWelcome " + customer.getCustomerName() + "!");

        // Restaurant
        RestaurantDAO restaurantDAO = new RestaurantDAO();

        ArrayList<Restaurant> restaurants =
                restaurantDAO.getAllRestaurants();

        System.out.println("\n--------------- RESTAURANTS -------------------");

        for (Restaurant restaurant : restaurants) {

            System.out.println(
                restaurant.getRestaurantId() + ". " +
                restaurant.getRestaurantName() +
                "       Rating: " +
                restaurant.getRating()
            );
        }

        System.out.print("\nSelect Restaurant: ");
        int restaurantId = sc.nextInt();

        // Food Type
        System.out.println("\n--------------- FOOD TYPE --------------------");

        System.out.println("1. Veg");
        System.out.println("2. Non-Veg");

        System.out.print("\nSelect: ");
        int foodChoice = sc.nextInt();

        String foodType = "";

        if (foodChoice == 1) {
            foodType = "Veg";
        }
        else if (foodChoice == 2) {
            foodType = "Non-Veg";
        }
        else {
            System.out.println("Invalid food type!");
            sc.close();
            return;
        }

        // Menu
        MenuDAO menuDAO = new MenuDAO();

        ArrayList<Menu> menuList =
                menuDAO.getMenuByRestaurantAndType(
                    restaurantId, foodType
                );

        System.out.println("\n--------------- MENU --------------------------");

        for (int i = 0; i < menuList.size(); i++) {

            Menu menu = menuList.get(i);

            System.out.println(
                (i + 1) + ". " +
                menu.getItemName() +
                "       ₹" +
                menu.getPrice()
            );
        }

        // Food Selection
        System.out.print("\nSelect Food: ");
        int foodNumber = sc.nextInt();

        if (foodNumber < 1 || foodNumber > menuList.size()) {
            System.out.println("Invalid food selection!");
            sc.close();
            return;
        }

        Menu selectedMenu = menuList.get(foodNumber - 1);

        int itemId = selectedMenu.getItemId();
        String foodName = selectedMenu.getItemName();
        double foodPrice = selectedMenu.getPrice();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        // Delivery Address
        System.out.println(
            "\n--------------- DELIVERY ADDRESS --------------"
        );

        System.out.println(customer.getAddress());

        // Bill Calculation
        double subtotal = foodPrice * quantity;
        double gst = subtotal * 0.05;
        double deliveryCharge = 40;
        double totalAmount = subtotal + gst + deliveryCharge;

        // Bill
        System.out.println("\n--------------- BILL --------------------------");

        System.out.println("Food: " + foodName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Subtotal: ₹" + subtotal);
        System.out.println("GST: ₹" + gst);
        System.out.println("Delivery Charge: ₹" + deliveryCharge);
        System.out.println("Total: ₹" + totalAmount);

        // Confirm Order
        System.out.print("\nConfirm Order? ");
        String confirm = sc.next();

        if (confirm.equalsIgnoreCase("Y")) {

            // Create Order
            Order order = new Order(
                0,
                customerId,
                restaurantId,
                "Placed",
                subtotal,
                gst,
                deliveryCharge,
                totalAmount
            );

            OrderDAO orderDAO = new OrderDAO();

            int orderId = orderDAO.createOrder(order);

            // Save Order Item
            OrderItem orderItem = new OrderItem(
                orderId,
                itemId,
                quantity,
                foodPrice
            );

            OrderItemDAO orderItemDAO = new OrderItemDAO();

            orderItemDAO.addOrderItem(orderItem);

            // Order Confirmation
            System.out.println(
                "\n ORDER PLACED SUCCESSFULLY!"
            );

            System.out.println("\nOrder ID: " + orderId);
            System.out.println("Status: Placed");

            // Delivery Status
            orderDAO.updateStatus(
                orderId,
                "Out for Delivery"
            );

            System.out.println(
                "\n--------------- DELIVERY ----------------------"
            );

            System.out.println(
                "\nOrder Status: Out for Delivery"
            );

            // Review
            System.out.println(
                "\n--------------- REVIEW ------------------------"
            );

            System.out.print(
                "\nRate your experience (1-5): "
            );

            int rating = sc.nextInt();

            if (rating < 1 || rating > 5) {

                System.out.println(
                    "Invalid rating! Please enter between 1 and 5."
                );

                sc.close();
                return;
            }

            sc.nextLine();

            System.out.print("Enter Review: ");
            String reviewText = sc.nextLine();

            Review review = new Review(
                customerId,
                restaurantId,
                orderId,
                rating,
                reviewText
            );

            ReviewDAO reviewDAO = new ReviewDAO();

            reviewDAO.addReview(review);

            System.out.println(
                "\n * Review submitted successfully!"
            );
        }
        else {

            System.out.println("\nOrder Cancelled.");
        }

        sc.close();
    }
}