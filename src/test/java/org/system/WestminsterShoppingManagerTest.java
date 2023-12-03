package org.system;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterShoppingManagerTest {

    Electronic e1 = new Electronic("eOW2138", "Owen", 10, 12000.00,
            "Singer", 2);
    Electronic e2 = new Electronic("eTV2005", "TV", 5, 45000.00,
            "Abans", 1);
    Electronic e3 = new Electronic("eHD2501", "Hair Dryer", 15, 5000.00,
            "Panasonic", 1);
    Electronic e4 = new Electronic("eLP2010", "Laptop", 20, 195000.00,
            "Lenovo");
    Product c1 = new Clothing("cTS1001", "T-Shirt", 25, 4500.00,
            "L", "Cyan");
    private final int maxNumProducts = 50;

    @Test
    void addProduct() {
        WestminsterShoppingManager wsm1 = new WestminsterShoppingManager();
        wsm1.addProduct(e1);
        assertTrue(wsm1.getProductList().contains(e1));
    }

    @Test
    void deleteProduct() {
        WestminsterShoppingManager wsm2 = new WestminsterShoppingManager();
        LinkedList<Product> pl1 = new LinkedList<>();
        pl1.add(e2);
        pl1.add(e3);
        pl1.add(e4);
        pl1.add(c1);
        wsm2.setProductList(pl1);
        assertEquals(c1, wsm2.deleteProduct(c1));
    }

    @Test
    void deleteProduct_If_ProductNotExists() {
        WestminsterShoppingManager wsm3 = new WestminsterShoppingManager();
        LinkedList<Product> pl2 = new LinkedList<>();
        pl2.add(e2);
        pl2.add(e3);
        pl2.add(e4);
        pl2.add(c1);
        wsm3.setProductList(pl2);
        assertNull(wsm3.deleteProduct(e1));
    }

    @Test
    void display_ProductList_OrderedBy_ProductID_In_Alphabetical_Order() {
        WestminsterShoppingManager wsm4 = new WestminsterShoppingManager();
        LinkedList<Product> pl3 = new LinkedList<>();
        pl3.add(e2);
        pl3.add(e3);
        pl3.add(c1);
        wsm4.setProductList(pl3);

        wsm4.displayProductList();

        System.out.println();
        // order should be like c1, e3, e2
        String outputString = "1. " + c1.toString() +
                "\n2. " + e3.toString() +
                "\n3. " + e2.toString();
        System.out.println(outputString);
    }
}