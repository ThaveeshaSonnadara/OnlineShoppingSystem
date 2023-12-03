package org.system;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager {
    private final Scanner sc = new Scanner(System.in);
    public File saveFile =
            new File("src/main/resources/previousSessionData.txt");
    private List<Product> productList;

    public WestminsterShoppingManager() {
        productList = new LinkedList<>();
    }

    public WestminsterShoppingManager(List<Product> productList) {
        this.productList = productList;
    }

    private static void printWelcomeMessage() {
        System.out.println();
        System.out.println("*********************************************");
        System.out.println("* Welcome to the Shopping Management System *");
    }

    private static void printMenu() {
        System.out.println("\n****************  Main Menu  ****************");
        System.out.println("*          1. Add       Product             *");
        System.out.println("*          2. Update    Product             *");
        System.out.println("*          3. Show Product List             *");
        System.out.println("*          4. Delete    Product             *");
        System.out.println("*          5. Exit                          *");
        System.out.println("****************  Main Menu  ****************");

        System.out.println("Enter the option: ");
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void addProduct(Product product) {
        int maxNumProducts = 50;
        if (this.getProductList().size() < maxNumProducts) {
            this.getProductList().add(product);
            System.out.println("Given Product added to the system.");
        } else {
            System.out.println("No more space in the system.");
        }
    }

    @Override
    public Product deleteProduct(Product product) {
        if (this.getProductList().contains(product)) {
            productList.remove(product);
            System.out.println("The product removed from the system.");
            return product;
        } else {
            System.out.println("There is no such item in the system.");
            return null;
        }
    }

    @Override
    public boolean displayProductList() {
        List<Product> orderedListByID = orderTheList(this.getProductList());
        int index = 1;
        if (orderedListByID.isEmpty()) {
            System.out.println("\n<System has zero products for now.>");
            return false;
        } else {
            for (Product product : orderedListByID) {
                System.out.println(index + "." + " " + product.toString());
                index++;
            }
            return true;
        }
    }

    private @NotNull List<Product> orderTheList(List<Product> productList) {
        List<Product> sortedProducts = new ArrayList<>(productList);

        sortedProducts.sort(Comparator.comparing(Product::getProductId));

        return sortedProducts;
    }

    private int calcNumProducts() {
        return this.getProductList().size();
    }

    private double takeNumber() {
        Scanner sc = new Scanner(System.in);

        double userInput;

        // This will continue looping until an integer is entered
        while (true) {
            try {
                /* Attempt to read in an integer. If anything else
                 * is entered, it will throw an error.*/
                userInput = sc.nextDouble();
                break;
            } catch (Exception e) {
                sc.nextLine(); // clear buffer
                System.out.println("Not a number, try again.");
            }
        }
        return userInput;
    }

    @Override
    public boolean runMenu() {
        boolean exit = false;

        printWelcomeMessage();
        printMenu();

        double choice = takeNumber();

        switch ((int) choice) {
            case 1:
                Product newProduct = selectProductTypeToAdd();
                if (newProduct != null) {
                    addProduct(newProduct);
                } else {
                    System.out.println("Product addition was failed!");
                }
                break;
            case 2:
                System.out.println("Select a product to update.");
                break;
            case 3:
                System.out.println("Displaying the product list - Ordered by ProductID");
                displayProductList();
                break;
            case 4:
                System.out.println("Select a product to delete.");
                boolean isListEmpty = displayProductList();

                if (isListEmpty) { // managing some spaces in the console
                    System.out.println("Enter the Product Id: ");
                    String productId = sc.nextLine();

                    Product productToDelete = selectProductToDelete(productId);
                    if (productToDelete != null) {
                        this.productList.remove(productToDelete);
                        System.out.println(productToDelete.getProductType() + "Product with id of " + productId +
                                " has been deleted from the system!");
                        System.out.println("There are total number of " + this.calcNumProducts() +
                                " products left in the system.");
                    } else {
                        System.out.println("There is no such product with the id of " + productId + " in the system.");
                        System.out.println("There are total number of " + this.calcNumProducts() +
                                " products left in the system.");
                    }
                }
                break;
            case 5:
                exit = true;
                break;
            default:
                throw new IllegalStateException("Invalid Option!");
        }
        return exit;
    }

    private @Nullable Product selectProductTypeToAdd() {
        System.out.println("Select a product to add");
        System.out.println("1. Electronic");
        System.out.println("2. Clothing");

        double choice = takeNumber();

        System.out.println("Enter the product Id: ");
        String productId = sc.nextLine();
        System.out.println("Enter the product Name: ");
        String productName = sc.nextLine();
        System.out.println("Enter the number of available items: ");
        int numAvailItems = (int) takeNumber();
        System.out.println("Enter the price: ");
        double price = takeNumber();

        switch ((int) choice) {
            case 1:
                System.out.println("Enter the brand of the electronic product: ");
                String brand = sc.nextLine();
                System.out.println("Enter the warranty period for the electronic: ");
                int warranty = (int) takeNumber();

                // creating the electronic product with all the relevant details
                return new Electronic(productId, productName, numAvailItems, price,
                        brand, warranty);
            case 2:
                System.out.println("Enter the size of the cloth: ");
                String size = sc.nextLine();
                System.out.println("Enter the color of the cloth: ");
                String color = sc.nextLine().toLowerCase();

                return new Clothing(productId, productName, numAvailItems, price,
                        size, color);
            default:
                System.out.println("Invalid option!");
                break;
        }
        return null;
    }

    private @Nullable Product selectProductToDelete(String productId) {
        List<Product> sortedList = orderTheList(this.getProductList());
        for (Product product : sortedList) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void saveData() throws IOException {

        FileOutputStream fos1 = new FileOutputStream(saveFile);
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);

        for (Product product : this.productList) {
            oos1.writeObject(product);
        }

        oos1.flush();
        fos1.close();
        oos1.close();

        // clearing the array list after saving the data to the array.
        // In this way files are the only data source for the application.
        productList.clear();
    }

    @Override
    public void loadData() throws IOException {

        // checking if the files are exist, and they have data inside them
        if ((saveFile.exists() && saveFile.length() != 0)) {

            FileInputStream fis1 = new FileInputStream(saveFile);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);

            for (; ; ) {
                try {
                    Product product = (Product) ois1.readObject();
                    this.productList.add(product);
                } catch (Exception e) {
                    break;
                }
            }

            fis1.close();
            ois1.close();
        }
    }
}
