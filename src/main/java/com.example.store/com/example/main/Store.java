package com.example.main;

import com.example.model.Product;
import com.example.model.DigitalProduct;
import java.util.ArrayList;

/**
 * Store class - Demonstrates package organization and module system.
 * This class shows how to use classes from different packages within a module.
 * 
 * @author Student Developer
 * @version 1.0.0
 */
public class Store {
    
    /**
     * Main method to demonstrate package organization and module system.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Java Platform Module System (JPMS) Demo ===");
        System.out.println("Demonstrating how modules provide stronger encapsulation than packages\n");
        
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

        System.out.println("=== Processing the Shopping Cart ===");
        System.out.println("Using a for-each loop to process all items uniformly:\n");

        // Use a for-each loop to iterate through the shoppingCart and call displayInfo()
        int itemNumber = 1;
        for (Product item : shoppingCart) {
            System.out.println("--- Shopping Cart Item " + itemNumber++ + " ---");
            item.displayInfo(); // Polymorphism in action!
            System.out.println();
        }

        System.out.println("=== Module System Benefits ===");
        System.out.println("1. Stronger Encapsulation: Modules control what is public vs internal");
        System.out.println("2. Explicit Dependencies: Clear declaration of what modules depend on");
        System.out.println("3. Namespace Protection: Prevents naming conflicts at module level");
        System.out.println("4. Security: Internal packages cannot be accessed from outside");
        System.out.println("5. Maintainability: Clear boundaries between different parts of application\n");

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

        System.out.println("=== Module Information ===");
        System.out.println("Module Name: com.example.store");
        System.out.println("Exported Packages: com.example.model");
        System.out.println("Internal Packages: com.example.main");
        System.out.println("Dependencies: None (standalone module)\n");

        System.out.println("=== Module vs Package Comparison ===");
        System.out.println("Packages:");
        System.out.println("  - Organize related classes");
        System.out.println("  - Provide namespace protection");
        System.out.println("  - Control access with public/private");
        System.out.println();
        System.out.println("Modules:");
        System.out.println("  - Organize related packages");
        System.out.println("  - Control package-level access");
        System.out.println("  - Explicit dependency management");
        System.out.println("  - Stronger encapsulation boundaries\n");

        System.out.println("=== Key Learning Points ===");
        System.out.println("1. Modules are the top-level organizational unit in Java");
        System.out.println("2. module-info.java defines module boundaries and exports");
        System.out.println("3. Exported packages are public API of the module");
        System.out.println("4. Non-exported packages are internal implementation");
        System.out.println("5. Modules provide stronger encapsulation than packages alone");
        System.out.println("6. This is essential for building large-scale, maintainable applications");
    }
}
