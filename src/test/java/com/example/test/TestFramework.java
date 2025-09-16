package com.example.test;

/**
 * Simple test framework for Unit 4 testing.
 * This framework provides basic assertion methods for testing Java concepts.
 * 
 * @author Test Framework
 * @version 1.0.0
 */
public class TestFramework {
    private static int testsRun = 0;
    private static int testsPassed = 0;
    private static int testsFailed = 0;

    /**
     * Assert that two objects are equal.
     * 
     * @param expected The expected value
     * @param actual The actual value
     * @param message The test message
     */
    public static void assertEqual(Object expected, Object actual, String message) {
        testsRun++;
        if (expected == null && actual == null) {
            testsPassed++;
            System.out.println("✅ PASS: " + message);
        } else if (expected != null && expected.equals(actual)) {
            testsPassed++;
            System.out.println("✅ PASS: " + message);
        } else {
            testsFailed++;
            System.out.println("❌ FAIL: " + message);
            System.out.println("   Expected: " + expected);
            System.out.println("   Actual: " + actual);
        }
    }

    /**
     * Assert that two objects are equal (without custom message).
     * 
     * @param expected The expected value
     * @param actual The actual value
     */
    public static void assertEqual(Object expected, Object actual) {
        assertEqual(expected, actual, "Values should be equal");
    }

    /**
     * Assert that a condition is true.
     * 
     * @param condition The condition to test
     * @param message The test message
     */
    public static void assertTrue(boolean condition, String message) {
        testsRun++;
        if (condition) {
            testsPassed++;
            System.out.println("✅ PASS: " + message);
        } else {
            testsFailed++;
            System.out.println("❌ FAIL: " + message);
        }
    }

    /**
     * Assert that a condition is true (without custom message).
     * 
     * @param condition The condition to test
     */
    public static void assertTrue(boolean condition) {
        assertTrue(condition, "Condition should be true");
    }

    /**
     * Assert that a condition is false.
     * 
     * @param condition The condition to test
     * @param message The test message
     */
    public static void assertFalse(boolean condition, String message) {
        testsRun++;
        if (!condition) {
            testsPassed++;
            System.out.println("✅ PASS: " + message);
        } else {
            testsFailed++;
            System.out.println("❌ FAIL: " + message);
        }
    }

    /**
     * Assert that a condition is false (without custom message).
     * 
     * @param condition The condition to test
     */
    public static void assertFalse(boolean condition) {
        assertFalse(condition, "Condition should be false");
    }

    /**
     * Assert that an exception is thrown.
     * 
     * @param runnable The code to run
     * @param expectedException The expected exception type
     * @param message The test message
     */
    public static void assertThrows(Runnable runnable, Class<? extends Exception> expectedException, String message) {
        testsRun++;
        try {
            runnable.run();
            testsFailed++;
            System.out.println("❌ FAIL: " + message);
            System.out.println("   Expected exception: " + expectedException.getSimpleName());
            System.out.println("   But no exception was thrown");
        } catch (Exception e) {
            if (expectedException.isInstance(e)) {
                testsPassed++;
                System.out.println("✅ PASS: " + message);
            } else {
                testsFailed++;
                System.out.println("❌ FAIL: " + message);
                System.out.println("   Expected exception: " + expectedException.getSimpleName());
                System.out.println("   Actual exception: " + e.getClass().getSimpleName());
            }
        }
    }

    /**
     * Assert that an exception is thrown (without custom message).
     * 
     * @param runnable The code to run
     * @param expectedException The expected exception type
     */
    public static void assertThrows(Runnable runnable, Class<? extends Exception> expectedException) {
        assertThrows(runnable, expectedException, "Expected exception should be thrown");
    }

    /**
     * Assert that an object is not null.
     * 
     * @param object The object to test
     * @param message The test message
     */
    public static void assertNotNull(Object object, String message) {
        testsRun++;
        if (object != null) {
            testsPassed++;
            System.out.println("✅ PASS: " + message);
        } else {
            testsFailed++;
            System.out.println("❌ FAIL: " + message);
        }
    }

    /**
     * Assert that an object is not null (without custom message).
     * 
     * @param object The object to test
     */
    public static void assertNotNull(Object object) {
        assertNotNull(object, "Object should not be null");
    }

    /**
     * Print test summary.
     */
    public static void printSummary() {
        System.out.println("\n=== Test Summary ===");
        System.out.println("Tests run: " + testsRun);
        System.out.println("Tests passed: " + testsPassed);
        System.out.println("Tests failed: " + testsFailed);
        
        if (testsFailed == 0) {
            System.out.println("🎉 All tests passed!");
        } else {
            System.out.println("⚠️  Some tests failed. Please review the output above.");
        }
    }

    /**
     * Reset test counters.
     */
    public static void reset() {
        testsRun = 0;
        testsPassed = 0;
        testsFailed = 0;
    }
}
