package org.example.Service;

import org.example.Model.Product;
import org.example.Repository.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    // Add product to the repository with price validation
    public void addProduct(Product product) {
        if (product.getPrice() <= 0) {
            System.out.println("Error: Product price must be positive.");
        } else {
            productRepository.addProduct(product);
            System.out.println("Product added to inventory.");
        }
    }

    // Show all products in the inventory
    public void showInventory() {
        List<Product> products = productRepository.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product product : products) {
                product.showDetails();
            }
        }
    }

    // Remove product from the repository by its name
    public void removeProduct(String name) {
        List<Product> products = productRepository.getAllProducts();
        Product productToRemove = null;

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Product '" + name + "' has been removed from the inventory.");
        } else {
            System.out.println("Product not found.");
        }
    }
}
