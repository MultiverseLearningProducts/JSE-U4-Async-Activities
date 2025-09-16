package com.example.main;

import com.example.model.Product;
import com.example.model.DigitalProduct;
import com.example.contracts.Describable;
import java.util.ArrayList;

/**
 * Store class - Demonstrates package organization, module system, and interface contracts.
 * This class shows how to use classes from different packages within a module,
 * and demonstrates the power of programming to interfaces.
 * 
 * @author Student Developer
 * @version 1.0.0
 */
public class Store {
    
    /**
     * Main method to demonstrate package organization, module system, and interface contracts.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Interface Contracts and Describable Objects Demo ===");
        System.out.println("Demonstrating how interfaces create formal contracts for behavior\n");
        
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

        System.out.println("=== Interface Contract Demonstration ===");
        System.out.println("All products implement the Describable interface, so we can treat them uniformly:\n");

        // Demonstrate interface contract - all items can be treated as Describable
        int itemNumber = 1;
        for (Product item : shoppingCart) {
            System.out.println("--- Shopping Cart Item " + itemNumber++ + " ---");
            System.out.println("Name: " + item.getName()); // From Describable interface
            System.out.println("Description: " + item.getDescription()); // From Describable interface
            System.out.println("Price: $" + item.getPrice());
            System.out.println("SKU: " + item.getSku());
            System.out.println();
        }

        System.out.println("=== Interface Benefits Demonstration ===");
        System.out.println("Let's create a method that works with any Describable object:\n");

        // Demonstrate programming to interfaces
        demonstrateDescribableContract(laptop);
        demonstrateDescribableContract(advancedJavaEbook);

        System.out.println("=== Processing the Shopping Cart with Interface Contract ===");
        System.out.println("Using the Describable interface to process all items uniformly:\n");

        // Use a for-each loop to iterate through the shoppingCart and call interface methods
        itemNumber = 1;
        for (Product item : shoppingCart) {
            System.out.println("--- Shopping Cart Item " + itemNumber++ + " ---");
            System.out.println("=== Product Information ===");
            System.out.println("Name: " + item.getName());
            System.out.println("Price: $" + item.getPrice());
            System.out.println("SKU: " + item.getSku());
            System.out.println("Type: " + (item instanceof DigitalProduct ? "Digital Product" : "Standard Product"));
            System.out.println("Description: " + item.getDescription());
            System.out.println();
        }

        System.out.println("=== Interface Contract Benefits ===");
        System.out.println("1. Formal Contracts: Interfaces define what methods must be implemented");
        System.out.println("2. Polymorphism: Same interface, different implementations");
        System.out.println("3. Flexibility: Easy to add new types that implement the interface");
        System.out.println("4. Decoupling: Code depends on interface, not specific implementation");
        System.out.println("5. Testability: Easy to create mock objects for testing");
        System.out.println("6. Maintainability: Changes to implementation don't affect interface users\n");

        // Calculate total cart value
        double totalCartValue = 0;
        int physicalProductCount = 0;
        int digitalProductCount = 0;

        for (Product item : shoppingCart) {
            totalCartValue += item.getPrice();
            if (item instanceof DigitalProduct) {
                digitalProductCount++;
            } else {
                physicalProductCount++;
            }
        }

        System.out.println("=== Cart Summary ===");
        System.out.println("Total Cart Value: $" + String.format("%.2f", totalCartValue));
        System.out.println("Physical Products: " + physicalProductCount);
        System.out.println("Digital Products: " + digitalProductCount);
        System.out.println("Total Items: " + shoppingCart.size() + "\n");

        System.out.println("=== Interface vs Class Comparison ===");
        System.out.println("Classes:");
        System.out.println("  - Define both behavior (methods) and state (fields)");
        System.out.println("  - Can be instantiated");
        System.out.println("  - Support inheritance");
        System.out.println();
        System.out.println("Interfaces:");
        System.out.println("  - Define only behavior (method signatures)");
        System.out.println("  - Cannot be instantiated");
        System.out.println("  - Support multiple implementation");
        System.out.println("  - Create contracts for behavior\n");

        System.out.println("=== Key Learning Points ===");
        System.out.println("1. Interfaces define contracts that classes must fulfill");
        System.out.println("2. Classes implement interfaces using the 'implements' keyword");
        System.out.println("3. Interface methods must be implemented by the implementing class");
        System.out.println("4. Programming to interfaces enables flexible, decoupled code");
        System.out.println("5. Interfaces support polymorphism and multiple inheritance");
        System.out.println("6. This is essential for building maintainable, testable applications");
    }

    /**
     * Demonstrates how to program to interfaces.
     * This method accepts any object that implements Describable,
     * showing the power of interface contracts.
     * 
     * @param describable Any object that implements the Describable interface
     */
    private static void demonstrateDescribableContract(Describable describable) {
        System.out.println("=== Describable Contract Demonstration ===");
        System.out.println("Object Name: " + describable.getName());
        System.out.println("Object Description: " + describable.getDescription());
        System.out.println("This method works with ANY object that implements Describable!");
        System.out.println();
    }
}
