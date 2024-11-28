package org.example.Controller;

import org.example.Model.Inventory;
import org.example.Model.Product;
import org.example.Model.ProductFactory;

public class StoreController {
    private Inventory inventory;
    private ProductFactory productFactory;

    public StoreController() {
        this.inventory = Inventory.getInstance();
        this.productFactory = new ProductFactory();
    }

    public void addProductToInventory(String type, String name, double price, int quantity) {
        Product product = productFactory.createProduct(type, name, price, quantity);
        inventory.addProduct(product);
    }

    public void showInventory() {
        for (Product product : inventory.getProducts()) {
            product.showDetails();
        }
    }

    public void removeProductFromInventory(String name, int quantity) {
        Product product = findProductByName(name);
        if (product != null) {
            try {
                product.decreaseQuantity(quantity);
                System.out.println(quantity + " of product '" + name + "' has been removed.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    private Product findProductByName(String name) {
        for (Product product : inventory.getProducts()) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;  // If product not found
    }
}
