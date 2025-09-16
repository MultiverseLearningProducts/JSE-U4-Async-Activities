// TODO: Add package declaration here
// package com.example.main;

// TODO: Add import statements here
// import com.example.model.Product;
// import com.example.model.DigitalProduct;
// import java.util.ArrayList;

/**
 * Store class - Demonstrates package organization and imports.
 * This class shows how to use classes from different packages.
 * 
 * @author Student Developer
 * @version 1.0.0
 */
public class Store {
    
    /**
     * Main method to demonstrate package organization and imports.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Professional Package Organization Demo ===");
        System.out.println("Demonstrating how packages organize code and prevent naming conflicts\n");
        
        // TODO: Uncomment and fix the code below after adding proper imports
        /*
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

        System.out.println("=== Package Organization Benefits ===");
        System.out.println("1. Clear Structure: com.example.model contains all data models");
        System.out.println("2. Separation of Concerns: com.example.main contains application logic");
        System.out.println("3. Import Management: Clear dependencies between packages");
        System.out.println("4. Namespace Protection: Prevents naming conflicts");
        System.out.println("5. Professional Standards: Industry-standard package naming\n");

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

        System.out.println("=== Import Statement Examples ===");
        System.out.println("// Import specific classes:");
        System.out.println("import com.example.model.Product;");
        System.out.println("import com.example.model.DigitalProduct;");
        System.out.println("// Import entire package (not recommended for clarity):");
        System.out.println("// import com.example.model.*;");
        System.out.println("// Import from java.util:");
        System.out.println("import java.util.ArrayList;\n");

        System.out.println("=== Key Learning Points ===");
        System.out.println("1. Packages organize related classes together");
        System.out.println("2. Package names use reverse domain naming (com.example.model)");
        System.out.println("3. Import statements make classes from other packages available");
        System.out.println("4. Package structure reflects the application architecture");
        System.out.println("5. Professional codebases always use packages");
        */
        
        System.out.println("=== TODO: Complete the Package Organization Task ===");
        System.out.println("1. Add package declarations to all Java files");
        System.out.println("2. Add import statements to Store.java");
        System.out.println("3. Uncomment and test the code above");
        System.out.println("4. Ensure the application compiles and runs successfully");
    }
}
