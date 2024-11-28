package org.example.View;

import org.example.Controller.StoreController;

import java.util.Scanner;

public class StoreView {
    private StoreController storeController;

    public StoreView() {
        this.storeController = new StoreController();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Store!");
            System.out.println("1. Add Product to Inventory");
            System.out.println("2. Show Inventory");
            System.out.println("3. Remove Product from Inventory");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product type (electronics/clothing/shoe): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    // Input validation for price
                    double price = -1;
                    while (price <= 0) {
                        System.out.print("Enter product price: ");
                        try {
                            price = scanner.nextDouble();
                            if (price <= 0) {
                                System.out.println("Error: Product price must be positive.");
                            }
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Error: Please enter a valid number for price.");
                            scanner.next();  // Clear the invalid input
                        }
                    }

                    // Input validation for quantity
                    int quantity = 0;
                    while (quantity <= 0) {
                        System.out.print("Enter product quantity: ");
                        try {
                            quantity = scanner.nextInt();
                            if (quantity <= 0) {
                                System.out.println("Error: Quantity must be a positive number.");
                            }
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Error: Please enter a valid number for quantity.");
                            scanner.next();  // Clear the invalid input
                        }
                    }

                    storeController.addProductToInventory(type, name, price, quantity);
                    System.out.println("Product added to inventory.");
                    break;

                case 2:
                    storeController.showInventory();
                    break;

                case 3:
                    System.out.print("Enter product name to remove: ");
                    String productNameToRemove = scanner.nextLine();
                    // Input validation for quantity to remove
                    int removeQuantity = 0;
                    while (removeQuantity <= 0) {
                        System.out.print("Enter quantity to remove: ");
                        try {
                            removeQuantity = scanner.nextInt();
                            if (removeQuantity <= 0) {
                                System.out.println("Error: Quantity to remove must be positive.");
                            }
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Error: Please enter a valid number for quantity.");
                            scanner.next();  // Clear the invalid input
                        }
                    }

                    storeController.removeProductFromInventory(productNameToRemove, removeQuantity);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
