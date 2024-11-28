package org.example.Model;

public class Clothing extends Product {
    public Clothing(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void showDetails() {
        System.out.println("Clothing Product: " + name + " - Price: " + price + " - Quantity: " + quantity);
    }
}