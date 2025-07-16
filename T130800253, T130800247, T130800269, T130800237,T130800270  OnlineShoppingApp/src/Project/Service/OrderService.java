package Project.Service;

import Project.Model.Customer;
import Project.Model.Order;
import Project.Model.Product;
import Project.Model.ProductQuantityPair;

import java.util.*;

public class OrderService {
    private List<Order> allOrders = new ArrayList<>();

    public Order placeOrder(Customer customer) {
        Map<Product, Integer> items = customer.getShoppingCart().getItems();
        if (items.isEmpty()) {
            System.out.println("Shopping cart is empty.");
            return null;
        }

        List<ProductQuantityPair> orderItems = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int quantity = entry.getValue();

            if (p.getStockQuantity() < quantity) {
                System.out.println("Insufficient stock for: " + p.getName());
                return null;
            }

            p.setStockQuantity(p.getStockQuantity() - quantity);
            orderItems.add(new ProductQuantityPair(p, quantity));
        }

        Order order = new Order(customer, orderItems);
        allOrders.add(order);
        customer.addOrder(order);
        customer.getShoppingCart().clearCart();

        System.out.println("Order placed successfully!");
        return order;
    }

    public void viewOrdersForCustomer(Customer customer) {
        List<Order> orders = customer.getOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders placed.");
        } else {
            for (Order o : orders) {
                System.out.println(o);
            }
        }
    }

    public void viewAllOrders() {
        if (allOrders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (Order o : allOrders) {
                System.out.println(o);
            }
        }
    }

    public void updateOrderStatus(int orderId, String newStatus) {
        for (Order order : allOrders) {
            if (order.getOrderId() == orderId) {
                order.setStatus(newStatus);
                System.out.println("Order status updated.");
                return;
            }
        }
        System.out.println("Order ID not found.");
    }
}
