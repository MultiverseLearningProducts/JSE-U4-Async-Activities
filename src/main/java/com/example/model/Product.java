package com.example.model;

import com.example.contracts.Describable;

/**
 * Product class - Represents a basic product in the store.
 * This class demonstrates encapsulation with private fields and public getter/setter methods.
 * It also implements the Describable interface, showing how interfaces create contracts.
 * 
 * This version includes robust error handling with exception throwing and validation.
 * 
 * @author Student Developer
 * @version 1.0.0
 */
public class Product implements Describable {
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
     * @throws IllegalArgumentException if price is negative
     */
    public Product(String name, double price, String sku) {
        this.name = name;
        setPrice(price); // Use setter to ensure validation
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

    /**
     * Sets the price of the product with validation.
     * This method demonstrates proper error handling by throwing exceptions
     * for invalid input rather than silently accepting bad data.
     * 
     * @param price The new price for the product
     * @throws IllegalArgumentException if the price is negative
     */
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Implementation of the Describable interface contract.
     * Returns a detailed description of the product.
     * 
     * @return A formatted description of the product
     */
    @Override
    public String getDescription() {
        return String.format("A %s product with SKU %s, priced at $%.2f. " +
                           "This is a standard physical product that can be shipped and delivered.",
                           getName(), getSku(), getPrice());
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
        System.out.println("Description: " + getDescription());
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
