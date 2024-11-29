package org.example.Model;

public class ProductFactory {
    public static Product createProduct(String type, String name, double price, int quantity) {
        switch (type.toLowerCase()) {
            case "electronics":
                return new Electronics(name, price, quantity);
            case "clothing":
                return new Clothing(name, price, quantity);
            case "shoe":
                return new Shoe(name, price, quantity); 
            default:
                throw new IllegalArgumentException("Invalid product type");
        }
    }
}
