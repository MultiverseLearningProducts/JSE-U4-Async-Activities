package com.example.test;

import com.example.model.Product;
import com.example.model.DigitalProduct;
import com.example.main.Store;

/**
 * Test class for 4-1-solution: Package Organization
 * This test verifies that the learner has completed the package organization task.
 * 
 * @author Test Framework
 * @version 1.0.0
 */
public class PackageOrganizationTest {
    
    /**
     * Run all tests for package organization.
     */
    public static void runTests() {
        System.out.println("=== Testing 4-1-Solution: Package Organization ===");
        TestFramework.reset();
        
        testPackageStructure();
        testImportStatements();
        testClassCompilation();
        testBasicFunctionality();
        
        TestFramework.printSummary();
    }
    
    /**
     * Test that the package structure is correct.
     */
    private static void testPackageStructure() {
        System.out.println("\n--- Testing Package Structure ---");
        
        // Test that Product class is in com.example.model package
        try {
            Class<?> productClass = Class.forName("com.example.model.Product");
            TestFramework.assertNotNull(productClass, "Product class should be in com.example.model package");
        } catch (ClassNotFoundException e) {
            TestFramework.assertTrue(false, "Product class should be in com.example.model package");
        }
        
        // Test that DigitalProduct class is in com.example.model package
        try {
            Class<?> digitalProductClass = Class.forName("com.example.model.DigitalProduct");
            TestFramework.assertNotNull(digitalProductClass, "DigitalProduct class should be in com.example.model package");
        } catch (ClassNotFoundException e) {
            TestFramework.assertTrue(false, "DigitalProduct class should be in com.example.model package");
        }
        
        // Test that Store class is in com.example.main package
        try {
            Class<?> storeClass = Class.forName("com.example.main.Store");
            TestFramework.assertNotNull(storeClass, "Store class should be in com.example.main package");
        } catch (ClassNotFoundException e) {
            TestFramework.assertTrue(false, "Store class should be in com.example.main package");
        }
    }
    
    /**
     * Test that import statements are working correctly.
     */
    private static void testImportStatements() {
        System.out.println("\n--- Testing Import Statements ---");
        
        try {
            // Test that Store can access Product and DigitalProduct
            Store store = new Store();
            TestFramework.assertNotNull(store, "Store should be instantiable");
            
            // Test that Product can be instantiated
            Product product = new Product("Test Product", 99.99, "TEST-001");
            TestFramework.assertNotNull(product, "Product should be instantiable");
            
            // Test that DigitalProduct can be instantiated
            DigitalProduct digitalProduct = new DigitalProduct("Test Digital", 49.99, "DIGITAL-001", 
                                                             "https://example.com", "PDF", 10.0);
            TestFramework.assertNotNull(digitalProduct, "DigitalProduct should be instantiable");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Import statements should work correctly: " + e.getMessage());
        }
    }
    
    /**
     * Test that all classes compile correctly.
     */
    private static void testClassCompilation() {
        System.out.println("\n--- Testing Class Compilation ---");
        
        try {
            // Test Product class compilation
            Class<?> productClass = Class.forName("com.example.model.Product");
            TestFramework.assertTrue(productClass != null, "Product class should compile");
            
            // Test DigitalProduct class compilation
            Class<?> digitalProductClass = Class.forName("com.example.model.DigitalProduct");
            TestFramework.assertTrue(digitalProductClass != null, "DigitalProduct class should compile");
            
            // Test Store class compilation
            Class<?> storeClass = Class.forName("com.example.main.Store");
            TestFramework.assertTrue(storeClass != null, "Store class should compile");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "All classes should compile: " + e.getMessage());
        }
    }
    
    /**
     * Test basic functionality after package organization.
     */
    private static void testBasicFunctionality() {
        System.out.println("\n--- Testing Basic Functionality ---");
        
        try {
            // Test Product functionality
            Product product = new Product("Test Product", 99.99, "TEST-001");
            TestFramework.assertEqual("Test Product", product.getName(), "Product name should work");
            TestFramework.assertEqual(99.99, product.getPrice(), "Product price should work");
            TestFramework.assertEqual("TEST-001", product.getSku(), "Product SKU should work");
            
            // Test DigitalProduct functionality
            DigitalProduct digitalProduct = new DigitalProduct("Test Digital", 49.99, "DIGITAL-001", 
                                                             "https://example.com", "PDF", 10.0);
            TestFramework.assertEqual("Test Digital", digitalProduct.getName(), "DigitalProduct name should work");
            TestFramework.assertEqual(49.99, digitalProduct.getPrice(), "DigitalProduct price should work");
            TestFramework.assertEqual("DIGITAL-001", digitalProduct.getSku(), "DigitalProduct SKU should work");
            TestFramework.assertEqual("https://example.com", digitalProduct.getDownloadUrl(), "DigitalProduct download URL should work");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Basic functionality should work: " + e.getMessage());
        }
    }
}
