package com.example.test;

import com.example.model.Product;
import com.example.model.DigitalProduct;
import com.example.main.Store;

/**
 * Test class for 4-2-solution: Module System (JPMS)
 * This test verifies that the learner has completed the module system task.
 * 
 * @author Test Framework
 * @version 1.0.0
 */
public class ModuleSystemTest {
    
    /**
     * Run all tests for module system.
     */
    public static void runTests() {
        System.out.println("=== Testing 4-2-Solution: Module System (JPMS) ===");
        TestFramework.reset();
        
        testModuleInfoExists();
        testModuleCompilation();
        testModuleExports();
        testModuleFunctionality();
        
        TestFramework.printSummary();
    }
    
    /**
     * Test that module-info.java exists and is properly formatted.
     */
    private static void testModuleInfoExists() {
        System.out.println("\n--- Testing Module Info File ---");
        
        try {
            // Try to read the module-info.java file
            java.io.File moduleInfoFile = new java.io.File("src/main/java/module-info.java");
            TestFramework.assertTrue(moduleInfoFile.exists(), "module-info.java file should exist");
            
            // Read the file content
            java.util.Scanner scanner = new java.util.Scanner(moduleInfoFile);
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            
            String moduleContent = content.toString();
            TestFramework.assertTrue(moduleContent.contains("module"), "module-info.java should contain 'module' keyword");
            TestFramework.assertTrue(moduleContent.contains("com.example.store"), "module-info.java should contain module name 'com.example.store'");
            TestFramework.assertTrue(moduleContent.contains("exports"), "module-info.java should contain 'exports' keyword");
            TestFramework.assertTrue(moduleContent.contains("com.example.model"), "module-info.java should export com.example.model package");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "module-info.java should be readable: " + e.getMessage());
        }
    }
    
    /**
     * Test that the module compiles correctly.
     */
    private static void testModuleCompilation() {
        System.out.println("\n--- Testing Module Compilation ---");
        
        try {
            // Test that all classes can be loaded
            Class<?> productClass = Class.forName("com.example.model.Product");
            TestFramework.assertNotNull(productClass, "Product class should be loadable");
            
            Class<?> digitalProductClass = Class.forName("com.example.model.DigitalProduct");
            TestFramework.assertNotNull(digitalProductClass, "DigitalProduct class should be loadable");
            
            Class<?> storeClass = Class.forName("com.example.main.Store");
            TestFramework.assertNotNull(storeClass, "Store class should be loadable");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Module should compile correctly: " + e.getMessage());
        }
    }
    
    /**
     * Test that module exports are working correctly.
     */
    private static void testModuleExports() {
        System.out.println("\n--- Testing Module Exports ---");
        
        try {
            // Test that exported classes are accessible
            Product product = new Product("Test Product", 99.99, "TEST-001");
            TestFramework.assertNotNull(product, "Exported Product class should be accessible");
            
            DigitalProduct digitalProduct = new DigitalProduct("Test Digital", 49.99, "DIGITAL-001", 
                                                             "https://example.com", "PDF", 10.0);
            TestFramework.assertNotNull(digitalProduct, "Exported DigitalProduct class should be accessible");
            
            // Test that internal classes are accessible within the module
            Store store = new Store();
            TestFramework.assertNotNull(store, "Internal Store class should be accessible within module");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Module exports should work correctly: " + e.getMessage());
        }
    }
    
    /**
     * Test that module functionality works as expected.
     */
    private static void testModuleFunctionality() {
        System.out.println("\n--- Testing Module Functionality ---");
        
        try {
            // Test Product functionality within module
            Product product = new Product("Module Test Product", 199.99, "MODULE-001");
            TestFramework.assertEqual("Module Test Product", product.getName(), "Product name should work in module");
            TestFramework.assertEqual(199.99, product.getPrice(), "Product price should work in module");
            TestFramework.assertEqual("MODULE-001", product.getSku(), "Product SKU should work in module");
            
            // Test DigitalProduct functionality within module
            DigitalProduct digitalProduct = new DigitalProduct("Module Test Digital", 99.99, "MODULE-DIGITAL-001", 
                                                             "https://module.example.com", "PDF", 15.0);
            TestFramework.assertEqual("Module Test Digital", digitalProduct.getName(), "DigitalProduct name should work in module");
            TestFramework.assertEqual(99.99, digitalProduct.getPrice(), "DigitalProduct price should work in module");
            TestFramework.assertEqual("MODULE-DIGITAL-001", digitalProduct.getSku(), "DigitalProduct SKU should work in module");
            TestFramework.assertEqual("https://module.example.com", digitalProduct.getDownloadUrl(), "DigitalProduct download URL should work in module");
            
            // Test inheritance within module
            TestFramework.assertTrue(digitalProduct instanceof Product, "DigitalProduct should be instanceof Product in module");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Module functionality should work: " + e.getMessage());
        }
    }
}
