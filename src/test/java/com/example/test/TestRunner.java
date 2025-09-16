package com.example.test;

/**
 * Test runner for Unit 4 tests.
 * This class provides a simple way to run specific test classes.
 * 
 * @author Test Framework
 * @version 1.0.0
 */
public class TestRunner {
    
    /**
     * Main method to run tests.
     * 
     * @param args command line arguments (test class names)
     */
    public static void main(String[] args) {
        System.out.println("=== Unit 4 Test Runner ===");
        System.out.println("Running tests for: " + String.join(", ", args));
        System.out.println();
        
        if (args.length == 0) {
            System.out.println("Usage: java TestRunner <TestClass1> [TestClass2] ...");
            System.out.println("Example: java TestRunner ModuleSystemTest");
            return;
        }
        
        for (String testClass : args) {
            try {
                System.out.println("Running " + testClass + "...");
                Class<?> clazz = Class.forName("com.example.test." + testClass);
                clazz.getMethod("runTests").invoke(null);
                System.out.println();
            } catch (Exception e) {
                System.out.println("❌ Error running " + testClass + ": " + e.getMessage());
                System.out.println();
            }
        }
        
        TestFramework.printSummary();
    }
}
