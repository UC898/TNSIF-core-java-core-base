package Project;

import Project.Service.AdminService;
import Project.Service.CustomerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminService adminService = new AdminService();
        CustomerService customerService = new CustomerService();

        int choice;

        System.out.println("=== Welcome to the Online Shopping Application ===");

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminService.adminMenu(scanner);
                    break;
                case 2:
                    customerService.customerMenu(scanner);
                    break;
                case 3:
                    System.out.println("ThankYou visiting....!");

                    System.out.println("            Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}
