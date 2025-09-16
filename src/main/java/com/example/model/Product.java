// TODO: Add package declaration here
// package com.example.model;

/**
 * Product class - Represents a basic product in the store.
 * This class demonstrates encapsulation with private fields and public getter/setter methods.
 * 
 * @author Student Developer
 * @version 1.0.0
 */
public class Product {
    private String name;
    private double price;
    private String sku;

    /**
     * Default constructor for Product.
     */
    public Product() {
        // Default constructor
    }

    /**
     * Constructor for Product with all fields.
     *
     * @param name The name of the product.
     * @param price The price of the product.
     * @param sku The SKU (Stock Keeping Unit) of the product.
     */
    public Product(String name, double price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Method to display product information.
     * This method prints the product details to the console.
     */
    public void displayInfo() {
        System.out.println("=== Product Information ===");
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("SKU: " + getSku());
        System.out.println("Type: Standard Product");
    }

    /**
     * Utility method for formatted product information.
     *
     * @return A formatted string containing product information.
     */
    public String getProductInfo() {
        return "Product: " + getName() + ", Price: $" + getPrice() + ", SKU: " + getSku();
    }
}
