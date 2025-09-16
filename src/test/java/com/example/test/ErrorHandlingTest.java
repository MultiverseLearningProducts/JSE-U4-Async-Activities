package com.example.test;

import com.example.model.Product;
import com.example.model.DigitalProduct;

/**
 * Test class for 4-6-solution: Error Handling
 * This test verifies that the learner has completed the error handling task.
 * 
 * @author Test Framework
 * @version 1.0.0
 */
public class ErrorHandlingTest {
    
    /**
     * Run all tests for error handling.
     */
    public static void runTests() {
        System.out.println("=== Testing 4-6-Solution: Error Handling ===");
        TestFramework.reset();
        
        testExceptionThrowing();
        testTryCatchBlocks();
        testInputValidation();
        testGracefulDegradation();
        
        TestFramework.printSummary();
    }
    
    /**
     * Test that exceptions are thrown for invalid input.
     */
    private static void testExceptionThrowing() {
        System.out.println("\n--- Testing Exception Throwing ---");
        
        try {
            // Test that Product throws exception for negative price
            TestFramework.assertThrows(() -> {
                Product product = new Product("Test Product", -50.00, "TEST-001");
            }, IllegalArgumentException.class, "Product should throw IllegalArgumentException for negative price");
            
            // Test that Product setPrice throws exception for negative price
            Product validProduct = new Product("Valid Product", 100.00, "VALID-001");
            TestFramework.assertThrows(() -> {
                validProduct.setPrice(-25.00);
            }, IllegalArgumentException.class, "Product.setPrice should throw IllegalArgumentException for negative price");
            
            // Test that DigitalProduct throws exception for negative file size
            TestFramework.assertThrows(() -> {
                DigitalProduct digitalProduct = new DigitalProduct("Test Digital", 50.00, "DIGITAL-001", 
                                                                 "https://example.com", "PDF", -10.0);
            }, IllegalArgumentException.class, "DigitalProduct should throw IllegalArgumentException for negative file size");
            
            // Test that DigitalProduct setFileSizeMB throws exception for negative file size
            DigitalProduct validDigital = new DigitalProduct("Valid Digital", 75.00, "VALID-DIGITAL-001", 
                                                           "https://example.com", "PDF", 15.0);
            TestFramework.assertThrows(() -> {
                validDigital.setFileSizeMB(-5.0);
            }, IllegalArgumentException.class, "DigitalProduct.setFileSizeMB should throw IllegalArgumentException for negative file size");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Exception throwing should work correctly: " + e.getMessage());
        }
    }
    
    /**
     * Test that try-catch blocks handle exceptions gracefully.
     */
    private static void testTryCatchBlocks() {
        System.out.println("\n--- Testing Try-Catch Blocks ---");
        
        try {
            // Test try-catch with Product
            Product product = new Product("Try-Catch Product", 200.00, "TRY-001");
            boolean exceptionCaught = false;
            
            try {
                product.setPrice(-100.00);
            } catch (IllegalArgumentException e) {
                exceptionCaught = true;
                TestFramework.assertTrue(e.getMessage().contains("Price cannot be negative"), 
                                       "Exception message should be descriptive");
            }
            
            TestFramework.assertTrue(exceptionCaught, "Exception should be caught in try-catch block");
            
            // Test try-catch with DigitalProduct
            DigitalProduct digitalProduct = new DigitalProduct("Try-Catch Digital", 150.00, "TRY-DIGITAL-001", 
                                                             "https://example.com", "PDF", 20.0);
            boolean digitalExceptionCaught = false;
            
            try {
                digitalProduct.setFileSizeMB(-15.0);
            } catch (IllegalArgumentException e) {
                digitalExceptionCaught = true;
                TestFramework.assertTrue(e.getMessage().contains("File size cannot be negative"), 
                                       "Exception message should be descriptive");
            }
            
            TestFramework.assertTrue(digitalExceptionCaught, "DigitalProduct exception should be caught in try-catch block");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Try-catch blocks should work correctly: " + e.getMessage());
        }
    }
    
    /**
     * Test that input validation prevents invalid data.
     */
    private static void testInputValidation() {
        System.out.println("\n--- Testing Input Validation ---");
        
        try {
            // Test that valid input works
            Product validProduct = new Product("Valid Product", 300.00, "VALID-001");
            TestFramework.assertEqual(300.00, validProduct.getPrice(), "Valid price should be set correctly");
            
            // Test that invalid input is rejected
            Product invalidProduct = new Product("Invalid Product", 400.00, "INVALID-001");
            try {
                invalidProduct.setPrice(-200.00);
                TestFramework.assertTrue(false, "Invalid price should be rejected");
            } catch (IllegalArgumentException e) {
                TestFramework.assertEqual(400.00, invalidProduct.getPrice(), "Price should remain unchanged after invalid input");
            }
            
            // Test that valid file size works
            DigitalProduct validDigital = new DigitalProduct("Valid Digital", 250.00, "VALID-DIGITAL-001", 
                                                           "https://example.com", "PDF", 25.0);
            TestFramework.assertEqual(25.0, validDigital.getFileSizeMB(), "Valid file size should be set correctly");
            
            // Test that invalid file size is rejected
            DigitalProduct invalidDigital = new DigitalProduct("Invalid Digital", 350.00, "INVALID-DIGITAL-001", 
                                                             "https://example.com", "PDF", 30.0);
            try {
                invalidDigital.setFileSizeMB(-20.0);
                TestFramework.assertTrue(false, "Invalid file size should be rejected");
            } catch (IllegalArgumentException e) {
                TestFramework.assertEqual(30.0, invalidDigital.getFileSizeMB(), "File size should remain unchanged after invalid input");
            }
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Input validation should work correctly: " + e.getMessage());
        }
    }
    
    /**
     * Test that applications fail gracefully instead of crashing.
     */
    private static void testGracefulDegradation() {
        System.out.println("\n--- Testing Graceful Degradation ---");
        
        try {
            // Test that application continues running after exceptions
            Product product1 = new Product("Graceful Product 1", 500.00, "GRACEFUL-001");
            Product product2 = new Product("Graceful Product 2", 600.00, "GRACEFUL-002");
            
            // Simulate processing multiple products with potential errors
            Product[] products = {product1, product2};
            int successCount = 0;
            int errorCount = 0;
            
            for (Product product : products) {
                try {
                    // Simulate some processing
                    product.getName();
                    product.getPrice();
                    successCount++;
                } catch (Exception e) {
                    errorCount++;
                }
            }
            
            TestFramework.assertEqual(2, successCount, "Valid products should be processed successfully");
            TestFramework.assertEqual(0, errorCount, "No errors should occur with valid products");
            
            // Test that exceptions don't crash the application
            try {
                product1.setPrice(-100.00);
            } catch (IllegalArgumentException e) {
                // Exception caught, application continues
                TestFramework.assertTrue(true, "Exception should be caught and handled gracefully");
            }
            
            // Test that application state is preserved after exceptions
            TestFramework.assertEqual("Graceful Product 1", product1.getName(), "Product name should be preserved after exception");
            TestFramework.assertEqual(500.00, product1.getPrice(), "Product price should be preserved after exception");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Graceful degradation should work correctly: " + e.getMessage());
        }
    }
}
