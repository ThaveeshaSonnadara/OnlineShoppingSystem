package org.system;

import java.io.Serializable;

public class Clothing extends Product implements Serializable {
    private String size;
    private String color;

    public Clothing(String productId, String productName, int numAvailItems, double price) {
        super(productId, productName, numAvailItems, price);
    }

    public Clothing(String productId, String productName, int numAvailItems, double price, String size) {
        super(productId, productName, numAvailItems, price);
        this.size = size;
    }

    public Clothing(String productId, String productName, int numAvailItems, double price, String size, String color) {
        super(productId, productName, numAvailItems, price);
        this.size = size;
        this.color = color;
    }

    @Override
    public String getProductType() {
        return "Clothing";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothing {" +
                super.toString() +
                ", size='" + size + '\'' +
                ", color=" + color +
                " }";
    }
}
