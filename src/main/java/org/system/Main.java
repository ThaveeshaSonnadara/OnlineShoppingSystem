package org.system;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        WestminsterShoppingManager sys = new WestminsterShoppingManager();
        if (sys.saveFile.exists()) {
            try {
                sys.loadData();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        boolean exit = false;
        while (!exit) {
            try {
                exit = sys.runMenu();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}