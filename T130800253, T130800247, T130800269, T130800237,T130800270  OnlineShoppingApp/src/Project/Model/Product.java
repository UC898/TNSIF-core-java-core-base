package Project.Model;

public class Product {
    private int productId;
    private String name;
    private double price;
    private int stockQuantity;

    // Constructor
    public Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // Setters
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // toString method
    @Override
    public String toString() {
        return "Product [productId=" + productId + 
               ", name=" + name + 
               ", price=" + price + 
               ", stockQuantity=" + stockQuantity + "]";
    }
}
