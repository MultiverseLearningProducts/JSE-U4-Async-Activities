package com.example.test;

import com.example.model.Product;
import com.example.model.DigitalProduct;
import com.example.contracts.Describable;

/**
 * Test class for 4-4-solution: Modern Interface Features
 * This test verifies that the learner has completed the modern interface features task.
 * 
 * @author Test Framework
 * @version 1.0.0
 */
public class ModernInterfaceTest {
    
    /**
     * Run all tests for modern interface features.
     */
    public static void runTests() {
        System.out.println("=== Testing 4-4-Solution: Modern Interface Features ===");
        TestFramework.reset();
        
        testDefaultMethods();
        testStaticMethods();
        testInterfaceEvolution();
        testBackwardCompatibility();
        
        TestFramework.printSummary();
    }
    
    /**
     * Test that default methods are working correctly.
     */
    private static void testDefaultMethods() {
        System.out.println("\n--- Testing Default Methods ---");
        
        try {
            // Test Product default method
            Product product = new Product("Default Test Product", 199.99, "DEFAULT-001");
            Describable productDescribable = (Describable) product;
            
            // Test that default method exists and can be called
            TestFramework.assertTrue(hasMethod(productDescribable.getClass(), "printDescription"), 
                                   "Describable should have printDescription default method");
            
            // Test that default method works (we can't easily test output, but we can test it doesn't throw)
            try {
                productDescribable.printDescription();
                TestFramework.assertTrue(true, "printDescription default method should execute without error");
            } catch (Exception e) {
                TestFramework.assertTrue(false, "printDescription default method should work: " + e.getMessage());
            }
            
            // Test DigitalProduct default method
            DigitalProduct digitalProduct = new DigitalProduct("Default Test Digital", 99.99, "DEFAULT-DIGITAL-001", 
                                                             "https://default.example.com", "PDF", 15.0);
            Describable digitalDescribable = (Describable) digitalProduct;
            
            try {
                digitalDescribable.printDescription();
                TestFramework.assertTrue(true, "DigitalProduct printDescription default method should execute without error");
            } catch (Exception e) {
                TestFramework.assertTrue(false, "DigitalProduct printDescription default method should work: " + e.getMessage());
            }
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Default methods should work correctly: " + e.getMessage());
        }
    }
    
    /**
     * Test that static methods are working correctly.
     */
    private static void testStaticMethods() {
        System.out.println("\n--- Testing Static Methods ---");
        
        try {
            // Test that static method exists
            TestFramework.assertTrue(hasStaticMethod(Describable.class, "getApplicationName"), 
                                   "Describable should have getApplicationName static method");
            
            // Test that static method can be called
            String appName = Describable.getApplicationName();
            TestFramework.assertNotNull(appName, "getApplicationName static method should return non-null value");
            TestFramework.assertTrue(appName.length() > 0, "getApplicationName should return non-empty string");
            
            // Test that static method returns expected value
            TestFramework.assertEqual("My Awesome Store", appName, "getApplicationName should return 'My Awesome Store'");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Static methods should work correctly: " + e.getMessage());
        }
    }
    
    /**
     * Test that interface evolution works correctly.
     */
    private static void testInterfaceEvolution() {
        System.out.println("\n--- Testing Interface Evolution ---");
        
        try {
            // Test that existing implementations still work with new interface features
            Product product = new Product("Evolution Test Product", 299.99, "EVOLUTION-001");
            DigitalProduct digitalProduct = new DigitalProduct("Evolution Test Digital", 149.99, "EVOLUTION-DIGITAL-001", 
                                                             "https://evolution.example.com", "MP4", 20.0);
            
            // Test that both classes can use default methods
            Describable productDescribable = (Describable) product;
            Describable digitalDescribable = (Describable) digitalProduct;
            
            // Test that default methods work on both types
            try {
                productDescribable.printDescription();
                digitalDescribable.printDescription();
                TestFramework.assertTrue(true, "Default methods should work on all implementations");
            } catch (Exception e) {
                TestFramework.assertTrue(false, "Default methods should work on all implementations: " + e.getMessage());
            }
            
            // Test that static methods work
            String appName = Describable.getApplicationName();
            TestFramework.assertNotNull(appName, "Static methods should work with interface evolution");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Interface evolution should work correctly: " + e.getMessage());
        }
    }
    
    /**
     * Test that backward compatibility is maintained.
     */
    private static void testBackwardCompatibility() {
        System.out.println("\n--- Testing Backward Compatibility ---");
        
        try {
            // Test that existing code still works
            Product product = new Product("Backward Test Product", 399.99, "BACKWARD-001");
            DigitalProduct digitalProduct = new DigitalProduct("Backward Test Digital", 199.99, "BACKWARD-DIGITAL-001", 
                                                             "https://backward.example.com", "PDF", 30.0);
            
            // Test that original interface methods still work
            Describable productDescribable = (Describable) product;
            Describable digitalDescribable = (Describable) digitalProduct;
            
            String productName = productDescribable.getName();
            String productDescription = productDescribable.getDescription();
            
            String digitalName = digitalDescribable.getName();
            String digitalDescription = digitalDescribable.getDescription();
            
            TestFramework.assertNotNull(productName, "Original getName() method should still work");
            TestFramework.assertNotNull(productDescription, "Original getDescription() method should still work");
            TestFramework.assertNotNull(digitalName, "Original getName() method should still work on DigitalProduct");
            TestFramework.assertNotNull(digitalDescription, "Original getDescription() method should still work on DigitalProduct");
            
            // Test that new methods work alongside old methods
            try {
                productDescribable.printDescription();
                digitalDescribable.printDescription();
                String appName = Describable.getApplicationName();
                
                TestFramework.assertTrue(true, "New methods should work alongside old methods");
                TestFramework.assertNotNull(appName, "Static methods should work with backward compatibility");
                
            } catch (Exception e) {
                TestFramework.assertTrue(false, "New methods should work with backward compatibility: " + e.getMessage());
            }
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Backward compatibility should be maintained: " + e.getMessage());
        }
    }
    
    /**
     * Helper method to check if a class has a specific method.
     */
    private static boolean hasMethod(Class<?> clazz, String methodName) {
        try {
            clazz.getMethod(methodName);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
    
    /**
     * Helper method to check if a class has a specific static method.
     */
    private static boolean hasStaticMethod(Class<?> clazz, String methodName) {
        try {
            clazz.getMethod(methodName);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}
