package org.example.Model;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;  // Add quantity field

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract void showDetails();

    public int getPrice() {
        return (int) price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to decrease quantity
    public void decreaseQuantity(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Quantity to remove must be positive.");
        }
        if (amount > quantity) {
            throw new IllegalArgumentException("Not enough stock to remove that quantity.");
        }
        this.quantity -= amount;
    }
}
