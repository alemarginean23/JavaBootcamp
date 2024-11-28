package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static Inventory instance;
    private List<Product> products;

    private Inventory() {
        products = new ArrayList<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    // Add product to inventory
    public void addProduct(Product product) {
        products.add(product);
    }

    // Get all products
    public List<Product> getProducts() {
        return products;
    }

    // Remove product from inventory by name
    public boolean removeProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                products.remove(product);
                return true; // Product removed
            }
        }
        return false; // Product not found
    }
}
