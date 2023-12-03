package org.system;

import java.lang.annotation.Documented;

public class Electronic extends Product {
    private String brand;
    private int warranty; // refers to warranty period in years

    public Electronic(String productId, String productName, int numAvailItems, double price) {
        super(productId, productName, numAvailItems, price);
    }

    public Electronic(String productId, String productName, int numAvailItems, double price, String brand) {
        super(productId, productName, numAvailItems, price);
        this.brand = brand;
    }

    public Electronic(String productId, String productName, int numAvailItems, double price, int warranty) {
        super(productId, productName, numAvailItems, price);
        this.warranty = warranty;
    }

    public Electronic(String productId, String productName, int numAvailItems, double price, String brand, int warranty) {
        super(productId, productName, numAvailItems, price);
        this.brand = brand;
        this.warranty = warranty;
    }

    @Override
    public String getProductType() {
        return "Electronic";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                super.toString() +
                ", brand='" + this.brand + '\'' +
                ", warranty=" + this.warranty +
                '}';
    }
}
