package org.example.Model;

public class Electronics extends Product {
    public Electronics(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void showDetails() {
        System.out.println("Electronics Product: " + name + " - Price: " + price + " - Quantity: " + quantity);
    }
}
