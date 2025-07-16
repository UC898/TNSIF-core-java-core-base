package Project.Service;

import Project.Model.Product;

import java.util.*;

public class ProductService {
    private Map<Integer, Product> productMap = new HashMap<>();

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void removeProduct(int productId) {
        productMap.remove(productId);
    }

    public Product getProductById(int productId) {
        return productMap.get(productId);
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    public void viewProducts() {
        if (productMap.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }
}
