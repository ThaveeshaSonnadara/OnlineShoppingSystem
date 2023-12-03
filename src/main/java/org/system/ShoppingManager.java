package org.system;

import java.io.IOException;

public interface ShoppingManager {
    public abstract void addProduct(Product product);
    public abstract Product deleteProduct(Product product);
    public abstract boolean displayProductList();
    public abstract boolean runMenu();
    public abstract void saveData() throws IOException;

    public abstract void loadData() throws IOException, ClassNotFoundException;
}
