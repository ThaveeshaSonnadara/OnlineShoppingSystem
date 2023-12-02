package org.system;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> productList;

    public ShoppingCart(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public Product removeProduct(Product product) {
        try {
            this.productList.remove(product);
            return product;
        } catch (Exception NoSuchObjectException) {
            System.out.println("The given product doesn't exists in the shopping cart!");
            return null;
        }
    }

    public double totalCostCart() {
        double totalCost = 0;
        for (Product product: this.productList) {
            totalCost += product.getPrice();
        } return totalCost;
    }
}
