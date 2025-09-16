/**
 * Module definition for the com.example.store application.
 * This module demonstrates the Java Platform Module System (JPMS) introduced in Java 9.
 * 
 * The module-info.java file defines:
 * - Module name: com.example.store
 * - Exported packages: com.example.model (public API)
 * - Dependencies: None (this is a simple standalone module)
 * 
 * @author Student Developer
 * @version 1.0.0
 */
module com.example.store {
    // Export the model package to make it available to other modules
    // This makes Product and DigitalProduct classes accessible from outside this module
    exports com.example.model;
    
    // Note: com.example.main is not exported, which means Store class
    // is only accessible within this module (internal implementation)
}
