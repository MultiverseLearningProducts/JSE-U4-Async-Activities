package com.example.main;

import com.example.model.Product;
import com.example.model.DigitalProduct;
import com.example.contracts.Describable;
import java.util.ArrayList;

/**
 * Store class - Demonstrates package organization, module system, and interface contracts.
 * This class shows how to use classes from different packages within a module,
 * and demonstrates the power of programming to interfaces with modern Java features.
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
        System.out.println("=== Modern Java Interface Features Demo ===");
        System.out.println("Demonstrating default methods and static methods in interfaces\n");
        
        // Demonstrate static method call on interface
        System.out.println("=== Static Method Demonstration ===");
        System.out.println("Application Name: " + Describable.getApplicationName());
        System.out.println("Header: " + Describable.getHeader());
        System.out.println();
        
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

        System.out.println("=== Default Method Demonstration ===");
        System.out.println("Using the default printDescription() method from the Describable interface:\n");

        // Demonstrate default method - all products automatically have this method
        int itemNumber = 1;
        for (Product item : shoppingCart) {
            System.out.println("--- Shopping Cart Item " + itemNumber++ + " ---");
            item.printDescription(); // Default method from interface
            System.out.println();
        }

        System.out.println("=== Enhanced Interface Features ===");
        System.out.println("Demonstrating additional default methods:\n");

        // Demonstrate additional default methods
        for (Product item : shoppingCart) {
            System.out.println("Short Summary (50 chars): " + item.getShortSummary(50));
            System.out.println("Short Summary (100 chars): " + item.getShortSummary(100));
            System.out.println();
        }

        System.out.println("=== Interface Evolution Benefits ===");
        System.out.println("1. Default Methods: Add new functionality without breaking existing code");
        System.out.println("2. Static Methods: Provide utility methods that belong to the interface");
        System.out.println("3. Backward Compatibility: Existing implementations automatically get new features");
        System.out.println("4. Optional Override: Classes can override default methods if needed");
        System.out.println("5. Interface Utility: Static methods provide interface-level functionality");
        System.out.println("6. Code Reuse: Default methods reduce code duplication\n");

        System.out.println("=== Processing the Shopping Cart with Enhanced Interface ===");
        System.out.println("Using both abstract and default methods from the Describable interface:\n");

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
            System.out.println("Default Method Output:");
            item.printDescription(); // Using the default method
            System.out.println();
        }

        System.out.println("=== Modern Java Features Comparison ===");
        System.out.println("Traditional Interface Methods:");
        System.out.println("  - Abstract methods: Must be implemented by all classes");
        System.out.println("  - No default implementation provided");
        System.out.println("  - Breaking changes when adding new methods");
        System.out.println();
        System.out.println("Modern Interface Methods (Java 8+):");
        System.out.println("  - Abstract methods: Must be implemented by all classes");
        System.out.println("  - Default methods: Optional implementation, can be overridden");
        System.out.println("  - Static methods: Belong to interface, not instances");
        System.out.println("  - Non-breaking evolution of interfaces");
        System.out.println("  - Utility methods at interface level\n");

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

        System.out.println("=== Key Learning Points ===");
        System.out.println("1. Default methods allow interfaces to evolve without breaking existing code");
        System.out.println("2. Static methods provide utility functionality at the interface level");
        System.out.println("3. Classes automatically inherit default methods but can override them");
        System.out.println("4. Static methods are called directly on the interface, not on instances");
        System.out.println("5. This enables powerful interface evolution and code reuse");
        System.out.println("6. Essential for building maintainable, evolvable software systems");
    }

    /**
     * Demonstrates how to program to interfaces with modern Java features.
     * This method accepts any object that implements Describable,
     * showing the power of interface contracts with default methods.
     * 
     * @param describable Any object that implements the Describable interface
     */
    private static void demonstrateDescribableContract(Describable describable) {
        System.out.println("=== Describable Contract Demonstration ===");
        System.out.println("Object Name: " + describable.getName());
        System.out.println("Object Description: " + describable.getDescription());
        System.out.println("Default Method Output:");
        describable.printDescription(); // Using the default method
        System.out.println("This method works with ANY object that implements Describable!");
        System.out.println();
    }
}
