package Project.Service;

import Project.Model.Admin;
import Project.Model.Product;

import java.util.*;

public class AdminService {
    private List<Admin> admins = new ArrayList<>();
    private ProductService productService = new ProductService();
    private OrderService orderService = new OrderService();
    private Scanner sc;

    public void adminMenu(Scanner scanner) {
        this.sc = scanner;
        int option;
        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Create Admin");
            System.out.println("5. View Admins");
            System.out.println("6. Update Order Status");
            System.out.println("7. View Orders");
            System.out.println("8. Return");
            System.out.println(" Choose an Option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    productService.viewProducts();
                    break;
                case 4:
                    createAdmin();
                    break;
                case 5:
                    viewAdmins();
                    break;
                case 6:
                    updateOrderStatus();
                    break;
                case 7:
                    orderService.viewAllOrders();
                    break;
                case 8:
                    System.out.println("Exiting Admin...");
                    break;
          
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (option != 8);
    }

    private void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Stock Quantity: ");
        int stock = sc.nextInt();

        productService.addProduct(new Product(id, name, price, stock));
        System.out.println("Product added successfully!");
    }

    private void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        int id = sc.nextInt();
        productService.removeProduct(id);
        System.out.println("Product removed.");
    }

    private void createAdmin() {
        System.out.print("Enter Admin ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Admin Username: ");
        String name = sc.nextLine();
        System.out.print("Enter Admin Email: ");
        String email = sc.nextLine();

        admins.add(new Admin(id, name, email));
        System.out.println("Admin created successfully!");
    }

    private void viewAdmins() {
        if (admins.isEmpty()) {
            System.out.println("No admins found.");
        } else {
            for (Admin a : admins) {
                System.out.println(a);
            }
        }
    }

    private void updateOrderStatus() {
        System.out.print("Enter Order ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter new status (Completed/Delivered/Cancelled): ");
        String status = sc.nextLine();

        orderService.updateOrderStatus(id, status);
    }

    public ProductService getProductService() {
        return productService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
