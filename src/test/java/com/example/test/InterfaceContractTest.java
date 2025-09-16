package com.example.test;

import com.example.model.Product;
import com.example.model.DigitalProduct;
import com.example.contracts.Describable;

/**
 * Test class for 4-3-solution: Interface Contracts
 * This test verifies that the learner has completed the interface contract task.
 * 
 * @author Test Framework
 * @version 1.0.0
 */
public class InterfaceContractTest {
    
    /**
     * Run all tests for interface contracts.
     */
    public static void runTests() {
        System.out.println("=== Testing 4-3-Solution: Interface Contracts ===");
        TestFramework.reset();
        
        testDescribableInterfaceExists();
        testProductImplementsDescribable();
        testDigitalProductImplementsDescribable();
        testInterfaceMethods();
        testPolymorphism();
        
        TestFramework.printSummary();
    }
    
    /**
     * Test that Describable interface exists and is properly defined.
     */
    private static void testDescribableInterfaceExists() {
        System.out.println("\n--- Testing Describable Interface ---");
        
        try {
            Class<?> describableClass = Class.forName("com.example.contracts.Describable");
            TestFramework.assertTrue(describableClass.isInterface(), "Describable should be an interface");
            
            // Test that interface has required methods
            java.lang.reflect.Method[] methods = describableClass.getMethods();
            boolean hasGetName = false;
            boolean hasGetDescription = false;
            
            for (java.lang.reflect.Method method : methods) {
                if (method.getName().equals("getName") && method.getParameterCount() == 0) {
                    hasGetName = true;
                }
                if (method.getName().equals("getDescription") && method.getParameterCount() == 0) {
                    hasGetDescription = true;
                }
            }
            
            TestFramework.assertTrue(hasGetName, "Describable interface should have getName() method");
            TestFramework.assertTrue(hasGetDescription, "Describable interface should have getDescription() method");
            
        } catch (ClassNotFoundException e) {
            TestFramework.assertTrue(false, "Describable interface should exist in com.example.contracts package");
        }
    }
    
    /**
     * Test that Product class implements Describable interface.
     */
    private static void testProductImplementsDescribable() {
        System.out.println("\n--- Testing Product Implements Describable ---");
        
        try {
            Product product = new Product("Test Product", 99.99, "TEST-001");
            TestFramework.assertTrue(product instanceof Describable, "Product should implement Describable interface");
            
            // Test that Product can be cast to Describable
            Describable describable = (Describable) product;
            TestFramework.assertNotNull(describable, "Product should be castable to Describable");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Product should implement Describable: " + e.getMessage());
        }
    }
    
    /**
     * Test that DigitalProduct class implements Describable interface.
     */
    private static void testDigitalProductImplementsDescribable() {
        System.out.println("\n--- Testing DigitalProduct Implements Describable ---");
        
        try {
            DigitalProduct digitalProduct = new DigitalProduct("Test Digital", 49.99, "DIGITAL-001", 
                                                             "https://example.com", "PDF", 10.0);
            TestFramework.assertTrue(digitalProduct instanceof Describable, "DigitalProduct should implement Describable interface");
            
            // Test that DigitalProduct can be cast to Describable
            Describable describable = (Describable) digitalProduct;
            TestFramework.assertNotNull(describable, "DigitalProduct should be castable to Describable");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "DigitalProduct should implement Describable: " + e.getMessage());
        }
    }
    
    /**
     * Test that interface methods are properly implemented.
     */
    private static void testInterfaceMethods() {
        System.out.println("\n--- Testing Interface Methods ---");
        
        try {
            // Test Product interface methods
            Product product = new Product("Interface Test Product", 199.99, "INTERFACE-001");
            Describable productDescribable = (Describable) product;
            
            String productName = productDescribable.getName();
            TestFramework.assertNotNull(productName, "Product getName() should return non-null value");
            TestFramework.assertEqual("Interface Test Product", productName, "Product getName() should return correct name");
            
            String productDescription = productDescribable.getDescription();
            TestFramework.assertNotNull(productDescription, "Product getDescription() should return non-null value");
            TestFramework.assertTrue(productDescription.contains("Interface Test Product"), "Product description should contain product name");
            TestFramework.assertTrue(productDescription.contains("INTERFACE-001"), "Product description should contain SKU");
            TestFramework.assertTrue(productDescription.contains("199.99"), "Product description should contain price");
            
            // Test DigitalProduct interface methods
            DigitalProduct digitalProduct = new DigitalProduct("Interface Test Digital", 99.99, "INTERFACE-DIGITAL-001", 
                                                             "https://interface.example.com", "PDF", 15.0);
            Describable digitalDescribable = (Describable) digitalProduct;
            
            String digitalName = digitalDescribable.getName();
            TestFramework.assertNotNull(digitalName, "DigitalProduct getName() should return non-null value");
            TestFramework.assertEqual("Interface Test Digital", digitalName, "DigitalProduct getName() should return correct name");
            
            String digitalDescription = digitalDescribable.getDescription();
            TestFramework.assertNotNull(digitalDescription, "DigitalProduct getDescription() should return non-null value");
            TestFramework.assertTrue(digitalDescription.contains("Interface Test Digital"), "DigitalProduct description should contain product name");
            TestFramework.assertTrue(digitalDescription.contains("INTERFACE-DIGITAL-001"), "DigitalProduct description should contain SKU");
            TestFramework.assertTrue(digitalDescription.contains("99.99"), "DigitalProduct description should contain price");
            TestFramework.assertTrue(digitalDescription.contains("PDF"), "DigitalProduct description should contain file type");
            TestFramework.assertTrue(digitalDescription.contains("15.0"), "DigitalProduct description should contain file size");
            TestFramework.assertTrue(digitalDescription.contains("https://interface.example.com"), "DigitalProduct description should contain download URL");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Interface methods should work correctly: " + e.getMessage());
        }
    }
    
    /**
     * Test polymorphism with Describable interface.
     */
    private static void testPolymorphism() {
        System.out.println("\n--- Testing Polymorphism ---");
        
        try {
            // Create array of Describable objects
            Describable[] describables = new Describable[2];
            describables[0] = new Product("Polymorphism Product", 299.99, "POLY-001");
            describables[1] = new DigitalProduct("Polymorphism Digital", 149.99, "POLY-DIGITAL-001", 
                                               "https://poly.example.com", "MP4", 25.0);
            
            // Test polymorphism - same interface, different implementations
            for (int i = 0; i < describables.length; i++) {
                Describable describable = describables[i];
                TestFramework.assertNotNull(describable.getName(), "Describable " + i + " should have name");
                TestFramework.assertNotNull(describable.getDescription(), "Describable " + i + " should have description");
                
                // Test that we can call methods without knowing the specific type
                String name = describable.getName();
                String description = describable.getDescription();
                
                TestFramework.assertTrue(name.length() > 0, "Name should not be empty");
                TestFramework.assertTrue(description.length() > 0, "Description should not be empty");
            }
            
            // Test that different types produce different descriptions
            String productDescription = describables[0].getDescription();
            String digitalDescription = describables[1].getDescription();
            
            TestFramework.assertFalse(productDescription.equals(digitalDescription), "Product and DigitalProduct should have different descriptions");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Polymorphism should work correctly: " + e.getMessage());
        }
    }
}
