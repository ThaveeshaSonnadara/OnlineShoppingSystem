package org.system;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String productId;
    private String productName;
    private int numAvailItems;
    private double price;

    public Product() {
    }

    public Product(String productId, String productName, int numAvailItems, double price) {
        this.productId = productId;
        this.productName = productName;
        this.numAvailItems = numAvailItems;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumAvailItems() {
        return numAvailItems;
    }

    public void setNumAvailItems(int numAvailItems) {
        this.numAvailItems = numAvailItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getProductType();

    @Override
    public String toString() {
        return "productId='" + this.productId + '\'' +
                ", productName='" + this.productName + '\'' +
                ", numAvailItems=" + this.numAvailItems +
                ", price=" + this.price;
    }
}
