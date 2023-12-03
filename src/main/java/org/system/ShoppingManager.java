package org.system;

public interface ShoppingManager {
    public abstract void addProduct(Product product);
    public abstract Product deleteProduct(Product product);
    public abstract void displayProductList();
}
