package com.example.main;

import com.example.model.Product;
import com.example.model.DigitalProduct;
import com.example.contracts.Describable;
import java.util.ArrayList;

/**
 * Store class - Demonstrates package organization, module system, interface contracts, and error handling.
 * This class shows how to use classes from different packages within a module,
 * and demonstrates the power of programming to interfaces with robust error handling.
 * 
 * @author Student Developer
 * @version 1.0.0
 */
public class Store {
    
    /**
     * Main method to demonstrate package organization, module system, interface contracts, and error handling.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Graceful Error Handling Demo ===");
        System.out.println("Demonstrating try-catch blocks and exception handling for robust applications\n");
        
        // Create various Product and DigitalProduct objects
        Product laptop = new Product("Gaming Laptop", 1299.99, "LAP-001");
        Product javaBook = new Product("Java Programming Guide", 49.99, "BOOK-001");
        Product tShirt = new Product("Developer T-Shirt", 24.99, "SHIRT-001");

        DigitalProduct advancedJavaEbook = new DigitalProduct("E-Book: Advanced Java", 29.99, "EBOOK-001",
                                                            "https://store.example.com/download/ebook-001", "PDF", 25.5);
        DigitalProduct oopCourse = new DigitalProduct("Online Course: OOP Mastery", 99.99, "COURSE-001",
                                                    "https://learn.example.com/course-oop-mastery", "Video Files", 2100.0);
        DigitalProduct ideLicense = new DigitalProduct("IDE Software License", 199.99, "SOFT-001",
                                                    "https://download.example.com/ide-license", "License Key", 0.1);

        // Create an ArrayList declared to hold Product objects
        ArrayList<Product> shoppingCart = new ArrayList<>();

        System.out.println("=== Building the Shopping Cart ===");
        System.out.println("Adding various Product and DigitalProduct objects to the cart...\n");

        // Add both Product and DigitalProduct objects to the list
        shoppingCart.add(laptop);
        shoppingCart.add(javaBook);
        shoppingCart.add(tShirt);
        shoppingCart.add(advancedJavaEbook);
        shoppingCart.add(oopCourse);
        shoppingCart.add(ideLicense);

        System.out.println("Shopping cart now contains " + shoppingCart.size() + " items\n");

        System.out.println("=== Error Handling Demonstration ===");
        System.out.println("Testing exception handling with invalid input:\n");

        // Demonstrate error handling with try-catch blocks
        demonstrateErrorHandling();

        System.out.println("=== Processing the Shopping Cart with Error Handling ===");
        System.out.println("Using try-catch blocks to handle potential errors gracefully:\n");

        // Use a for-each loop to iterate through the shoppingCart and call interface methods
        int itemNumber = 1;
        for (Product item : shoppingCart) {
            System.out.println("--- Shopping Cart Item " + itemNumber++ + " ---");
            try {
                // This could potentially throw an exception if price is negative
                item.displayInfo();
                System.out.println("✅ Product processed successfully");
            } catch (Exception e) {
                System.out.println("❌ Error processing product: " + e.getMessage());
            }
            System.out.println();
        }

        System.out.println("=== Exception Handling Benefits ===");
        System.out.println("1. Graceful Degradation: Application continues running even with errors");
        System.out.println("2. User-Friendly Messages: Clear error messages instead of crashes");
        System.out.println("3. Debugging Information: Exceptions provide detailed error information");
        System.out.println("4. Input Validation: Prevents invalid data from corrupting the application");
        System.out.println("5. Professional Quality: Robust applications handle errors gracefully");
        System.out.println("6. Better User Experience: Users get helpful feedback instead of crashes\n");

        // Calculate total cart value with error handling
        double totalCartValue = 0;
        int physicalProductCount = 0;
        int digitalProductCount = 0;

        for (Product item : shoppingCart) {
            try {
                totalCartValue += item.getPrice();
                if (item instanceof DigitalProduct) {
                    digitalProductCount++;
                } else {
                    physicalProductCount++;
                }
            } catch (Exception e) {
                System.out.println("⚠️  Warning: Could not process item for total calculation: " + e.getMessage());
            }
        }

        System.out.println("=== Cart Summary ===");
        System.out.println("Total Cart Value: $" + String.format("%.2f", totalCartValue));
        System.out.println("Physical Products: " + physicalProductCount);
        System.out.println("Digital Products: " + digitalProductCount);
        System.out.println("Total Items: " + shoppingCart.size() + "\n");

        System.out.println("=== Key Learning Points ===");
        System.out.println("1. Always validate input data before processing");
        System.out.println("2. Use try-catch blocks to handle potential exceptions");
        System.out.println("3. Throw meaningful exceptions with descriptive messages");
        System.out.println("4. Provide user-friendly error messages in catch blocks");
        System.out.println("5. Design applications to fail gracefully, not crash");
        System.out.println("6. Exception handling is essential for professional applications");
    }

    /**
     * Demonstrates error handling with try-catch blocks.
     * This method shows how to handle exceptions gracefully.
     */
    private static void demonstrateErrorHandling() {
        System.out.println("--- Testing Valid Input ---");
        try {
            Product validProduct = new Product("Test Product", 99.99, "TEST-001");
            System.out.println("✅ Valid product created successfully: " + validProduct.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Unexpected error: " + e.getMessage());
        }

        System.out.println("\n--- Testing Invalid Price Input ---");
        try {
            Product invalidProduct = new Product("Invalid Product", -50.00, "INVALID-001");
            System.out.println("❌ This should not print - product should not be created");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Caught expected exception: " + e.getMessage());
            System.out.println("✅ Error: The price you entered is invalid.");
        }

        System.out.println("\n--- Testing Invalid File Size Input ---");
        try {
            DigitalProduct invalidDigital = new DigitalProduct("Invalid Digital", 29.99, "DIGITAL-001",
                                                            "https://example.com", "PDF", -10.0);
            System.out.println("❌ This should not print - digital product should not be created");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Caught expected exception: " + e.getMessage());
            System.out.println("✅ Error: The file size you entered is invalid.");
        }

        System.out.println("\n--- Testing Price Update with Error Handling ---");
        Product testProduct = new Product("Test Product", 50.00, "TEST-002");
        System.out.println("Original price: $" + testProduct.getPrice());
        
        try {
            testProduct.setPrice(-25.00);
            System.out.println("❌ This should not print - price should not be updated");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Caught expected exception: " + e.getMessage());
            System.out.println("✅ Error: The price you entered is invalid.");
            System.out.println("Price remains unchanged: $" + testProduct.getPrice());
        }

        System.out.println("\n--- Testing File Size Update with Error Handling ---");
        DigitalProduct testDigital = new DigitalProduct("Test Digital", 19.99, "DIGITAL-002",
                                                      "https://example.com", "PDF", 5.0);
        System.out.println("Original file size: " + testDigital.getFileSizeMB() + " MB");
        
        try {
            testDigital.setFileSizeMB(-2.0);
            System.out.println("❌ This should not print - file size should not be updated");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Caught expected exception: " + e.getMessage());
            System.out.println("✅ Error: The file size you entered is invalid.");
            System.out.println("File size remains unchanged: " + testDigital.getFileSizeMB() + " MB");
        }

        System.out.println();
    }

    /**
     * Demonstrates how to program to interfaces with modern Java features and error handling.
     * This method accepts any object that implements Describable,
     * showing the power of interface contracts with robust error handling.
     * 
     * @param describable Any object that implements the Describable interface
     */
    private static void demonstrateDescribableContract(Describable describable) {
        System.out.println("=== Describable Contract Demonstration ===");
        try {
            System.out.println("Object Name: " + describable.getName());
            System.out.println("Object Description: " + describable.getDescription());
            System.out.println("Default Method Output:");
            describable.printDescription(); // Using the default method
            System.out.println("This method works with ANY object that implements Describable!");
        } catch (Exception e) {
            System.out.println("❌ Error processing describable object: " + e.getMessage());
        }
        System.out.println();
    }
}
