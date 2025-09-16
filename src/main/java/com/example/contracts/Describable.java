package com.example.contracts;

/**
 * Describable interface - Defines a contract for objects that can be described.
 * This interface establishes a formal agreement about what methods implementing classes must provide.
 * 
 * The Describable contract requires implementing classes to provide:
 * - getName(): Returns the name of the object
 * - getDescription(): Returns a description of the object
 * 
 * This interface demonstrates the core principle of programming to interfaces rather than implementations,
 * enabling flexible, decoupled code design.
 * 
 * Modern Java features demonstrated:
 * - Default methods: Provide default implementation that can be overridden
 * - Static methods: Provide utility methods that belong to the interface
 * 
 * @author Student Developer
 * @version 1.0.0
 */
public interface Describable {
    
    /**
     * Returns the name of the object.
     * This method should return a human-readable name that identifies the object.
     * 
     * @return The name of the object
     */
    String getName();
    
    /**
     * Returns a description of the object.
     * This method should return a detailed description that explains what the object is,
     * its purpose, or its key characteristics.
     * 
     * @return A description of the object
     */
    String getDescription();
    
    /**
     * Default method that prints the name and description of the object.
     * This method provides a default implementation that all implementing classes
     * automatically inherit. Classes can override this method if they need
     * different behavior.
     * 
     * Default methods were introduced in Java 8 to allow interfaces to evolve
     * without breaking existing implementations.
     * 
     * @since Java 8
     */
    default void printDescription() {
        System.out.println(getName() + ": " + getDescription());
    }
    
    /**
     * Static method that returns the application name.
     * Static methods in interfaces belong to the interface itself, not to
     * implementing classes. They can be called directly on the interface
     * without needing an instance.
     * 
     * Static methods in interfaces were introduced in Java 8 to provide
     * utility methods that are logically related to the interface.
     * 
     * @return The name of the application
     * @since Java 8
     */
    static String getApplicationName() {
        return "My Awesome Store";
    }
    
    /**
     * Static method that creates a formatted header for describable objects.
     * This demonstrates how static methods can provide utility functionality
     * that's related to the interface but doesn't require an instance.
     * 
     * @return A formatted header string
     * @since Java 8
     */
    static String getHeader() {
        return "=== " + getApplicationName() + " - Describable Objects ===";
    }
    
    /**
     * Default method that provides a short summary of the object.
     * This method combines the name and a truncated description for quick reference.
     * 
     * @param maxLength Maximum length of the description to include
     * @return A short summary of the object
     */
    default String getShortSummary(int maxLength) {
        String description = getDescription();
        if (description.length() <= maxLength) {
            return getName() + " - " + description;
        } else {
            return getName() + " - " + description.substring(0, maxLength) + "...";
        }
    }
}
