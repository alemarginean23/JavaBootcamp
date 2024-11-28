package org.example.Model;

public class Shoe extends Product {
    public Shoe(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void showDetails() {
        System.out.println("Shoe Product: " + name + " - Price: " + price + " - Quantity: " + quantity);
    }
}
