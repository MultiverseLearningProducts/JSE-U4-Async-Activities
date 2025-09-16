package com.example.gradle;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * A simple Java application that demonstrates Gradle build tool usage.
 * This application shows how Gradle manages dependencies and builds projects.
 * 
 * @author Student Developer
 * @version 1.0.0
 */
public class App {
    
    /**
     * Main method that demonstrates Gradle functionality.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Gradle Build Tool Demonstration ===");
        System.out.println("This application was built and run using Gradle!\n");
        
        // Demonstrate using a dependency (Google Guava)
        List<String> products = Lists.newArrayList(
            "Gaming Laptop",
            "Java Programming Guide", 
            "Developer T-Shirt",
            "E-Book: Advanced Java",
            "Online Course: OOP Mastery",
            "IDE Software License"
        );
        
        System.out.println("=== Product Catalog ===");
        System.out.println("Products managed by Gradle dependencies:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        
        System.out.println("\n=== Gradle Benefits ===");
        System.out.println("1. Automated Build Process: No manual compilation needed");
        System.out.println("2. Dependency Management: External libraries handled automatically");
        System.out.println("3. Testing Integration: Built-in support for testing frameworks");
        System.out.println("4. Cross-Platform: Works on Windows, macOS, and Linux");
        System.out.println("5. Incremental Builds: Only rebuilds what changed");
        System.out.println("6. Plugin Ecosystem: Extensible with plugins");
        
        System.out.println("\n=== Build Information ===");
        System.out.println("Project: gradle-demo");
        System.out.println("Package: com.example.gradle");
        System.out.println("Main Class: App");
        System.out.println("Java Version: 17");
        System.out.println("Build Tool: Gradle 8.5");
        
        System.out.println("\n=== Key Gradle Files ===");
        System.out.println("build.gradle.kts: Main build script with plugins and dependencies");
        System.out.println("settings.gradle.kts: Project settings and configuration");
        System.out.println("gradlew: Gradle wrapper script for running builds");
        System.out.println("gradle/wrapper/: Contains wrapper JAR and properties");
        
        System.out.println("\n=== Common Gradle Commands ===");
        System.out.println("./gradlew build    - Compile and test the project");
        System.out.println("./gradlew run      - Run the application");
        System.out.println("./gradlew clean    - Clean build artifacts");
        System.out.println("./gradlew test     - Run tests only");
        System.out.println("./gradlew tasks    - List available tasks");
        
        System.out.println("\n=== Professional Development ===");
        System.out.println("Gradle is essential for modern Java development because:");
        System.out.println("- It automates repetitive build tasks");
        System.out.println("- It manages complex dependency relationships");
        System.out.println("- It provides consistent builds across environments");
        System.out.println("- It integrates with IDEs and CI/CD pipelines");
        System.out.println("- It scales from simple projects to enterprise applications");
        
        System.out.println("\n🎉 Congratulations! You've successfully used Gradle to build and run a Java application!");
    }
}
