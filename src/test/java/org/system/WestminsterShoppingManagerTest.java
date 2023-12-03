package org.system;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterShoppingManagerTest {

    Electronic e2 = new Electronic("eTV2005", "TV", 5, 45000.00,
            "Abans", 1);
    Electronic e3 = new Electronic("eHD2501", "Hair Dryer", 15, 5000.00,
            "Panasonic", 1);
    Electronic e4 = new Electronic("eLP2010", "Laptop", 20, 195000.00,
            "Lenovo");
    Product c1 = new Clothing("cTS1001", "T-Shirt", 25, 4500.00,
            "L", Color.CYAN);
    private final int maxNumProducts = 50;


    @Test
    void getProductList() {
    }

    @Test
    void addProduct() {
        WestminsterShoppingManager wsm1 = new WestminsterShoppingManager();
        Electronic e1 = new Electronic("eOW2138", "Owen", 10, 12000.00,
                "Singer", 2);
        wsm1.addProduct(e1);
        assertTrue(wsm1.getProductList().contains(e1));
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void displayProductList() {
    }

    @Test
    void calcNumProducts() {
    }
}