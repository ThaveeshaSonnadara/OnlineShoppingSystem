package org.system;


public class Main {
    public static void main(String[] args) {
        WestminsterShoppingManager sys = new WestminsterShoppingManager();
        boolean exit = false;
        while (!exit){
            try {
                exit = sys.runMenu();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}