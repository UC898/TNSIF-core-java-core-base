package Project.Model;



import java.util.List;

public class Order {
    private static int idCounter = 1;
    private int orderId;
    private Customer customer;
    private List<ProductQuantityPair> products;
    private String status; // e.g. Pending, Completed

    public Order(Customer customer, List<ProductQuantityPair> products) {
        this.orderId = idCounter++;
        this.customer = customer;
        this.products = products;
        this.status = "Pending";
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<ProductQuantityPair> getProducts() { return products; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order ID: " + orderId + ", Customer: " + customer.getUsername() + ", Status: " + status + "\n");
        for (ProductQuantityPair p : products) {
            sb.append("  ").append(p).append("\n");
        }
        return sb.toString();
    }
}
