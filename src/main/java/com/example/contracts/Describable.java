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
}
