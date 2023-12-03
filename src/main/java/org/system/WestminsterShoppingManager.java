package org.system;


import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager {
    private List<Product> productList;
    private final int maxNumProducts = 50;

    private final Scanner sc = new Scanner(System.in);

    public WestminsterShoppingManager() {
        productList = new LinkedList<>();
    }

    public WestminsterShoppingManager(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void addProduct(Product product) {
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
    public void displayProductList() {
        List<Product> orderedListByID = orderList(this.getProductList());
        int index = 1;
        for (Product product: orderedListByID) {
            System.out.println(index + " " + product.toString());
            index++;
        }
    }

    private List<Product> orderList(List<Product> productList) {
        List<Product> sortedProducts = new ArrayList<>(productList);

        sortedProducts.sort(Comparator.comparing(Product::getProductId));

        return sortedProducts;
    }

    public int calcNumProducts() {
        return this.getProductList().size();
    }
}
