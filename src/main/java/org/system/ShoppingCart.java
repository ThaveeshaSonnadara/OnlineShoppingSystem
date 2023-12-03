package org.system;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> cart = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public void addProduct(Product product) {
        this.cart.add(product);
    }

    public Product removeProduct(Product product) {
        try {
            this.cart.remove(product);
            return product;
        } catch (Exception NoSuchObjectException) {
            System.out.println("The given product doesn't exists in the shopping cart!");
            return null;
        }
    }

    public double totalCostCart() {
        double totalCost = 0;
        for (Product product: this.cart) {
            totalCost += product.getPrice();
        } return totalCost;
    }
}
