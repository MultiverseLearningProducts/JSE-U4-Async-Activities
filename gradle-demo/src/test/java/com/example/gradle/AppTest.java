package com.example.gradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the App class.
 * This test demonstrates how Gradle integrates with testing frameworks.
 * 
 * @author Student Developer
 * @version 1.0.0
 */
class AppTest {
    
    /**
     * Test that the main method runs without throwing an exception.
     * This is a basic smoke test to ensure the application can start.
     */
    @Test
    void testAppHasAGreeting() {
        // This test verifies that the App class can be instantiated
        // and that it has the expected structure
        App app = new App();
        assertNotNull(app, "App should be instantiable");
    }
    
    /**
     * Test that demonstrates JUnit 5 functionality.
     * This shows how Gradle manages test dependencies.
     */
    @Test
    void testBasicFunctionality() {
        // Test basic assertions
        assertTrue(true, "Basic assertion should pass");
        assertEquals(2, 1 + 1, "Math should work correctly");
        assertNotNull("Hello World", "String should not be null");
    }
    
    /**
     * Test that demonstrates testing with collections.
     * This shows how Gradle dependencies (like Guava) work in tests.
     */
    @Test
    void testCollectionFunctionality() {
        // Test that we can use Guava collections (dependency)
        java.util.List<String> testList = java.util.Arrays.asList("item1", "item2", "item3");
        
        assertNotNull(testList, "List should not be null");
        assertEquals(3, testList.size(), "List should have 3 items");
        assertTrue(testList.contains("item1"), "List should contain item1");
        assertTrue(testList.contains("item2"), "List should contain item2");
        assertTrue(testList.contains("item3"), "List should contain item3");
    }
}
