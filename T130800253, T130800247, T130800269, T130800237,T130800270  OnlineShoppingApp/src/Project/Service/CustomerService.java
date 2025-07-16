package Project.Service;

import Project.Model.Customer;
import Project.Model.Product;

import java.util.*;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();
    private AdminService adminService = new AdminService(); // Access to product and order services
    private Scanner sc;

    public void customerMenu(Scanner scanner) {
        this.sc = scanner;
        int option;
        do {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Create Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. View Products");
            System.out.println("6. Return");
            System.out.println("Choose an Option: ");


            option = sc.nextInt();

            switch (option) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    placeOrder();
                    break;
                case 4:
                    viewCustomerOrders();
                    break;
                case 5:
                    adminService.getProductService().viewProducts();
                    break;
                case 6:
                    System.out.println("Exiting Customer Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (option != 6);
    }

    private void createCustomer() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Username: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        customers.add(new Customer(id, name, email, address));
        System.out.println("Customer created successfully!");
    }

    private void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found...");
        } else {
            for (Customer c : customers) {
                System.out.println(c);
            }
        }
    }

    private void placeOrder() {
        System.out.print("Enter Customer ID: ");
        int custId = sc.nextInt();
        Customer customer = findCustomerById(custId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        ProductService productService = adminService.getProductService();

        while (true) {
            System.out.print("Enter Product ID to add to order (or -1 to complete): ");
            int productId = sc.nextInt();
            if (productId == -1) break;

            Product product = productService.getProductById(productId);
            if (product == null) {
                System.out.println("Product not found.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            customer.getShoppingCart().addProduct(product, quantity);
        }

        OrderService orderService = adminService.getOrderService();
        orderService.placeOrder(customer);
    }

    private void viewCustomerOrders() {
        System.out.print("Enter Customer ID: ");
        int custId = sc.nextInt();
        Customer customer = findCustomerById(custId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        adminService.getOrderService().viewOrdersForCustomer(customer);
    }

    private Customer findCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getUsername() == id) {
                return c;
            }
        }
        return null;
    }
}
