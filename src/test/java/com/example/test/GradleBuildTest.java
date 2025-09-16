package com.example.test;

/**
 * Test class for 4-5-solution: Gradle Build Tool
 * This test verifies that the learner has completed the Gradle build tool task.
 * 
 * @author Test Framework
 * @version 1.0.0
 */
public class GradleBuildTest {
    
    /**
     * Run all tests for Gradle build tool.
     */
    public static void runTests() {
        System.out.println("=== Testing 4-5-Solution: Gradle Build Tool ===");
        TestFramework.reset();
        
        testGradleProjectStructure();
        testGradleFiles();
        testGradleWrapper();
        testGradleConfiguration();
        
        TestFramework.printSummary();
    }
    
    /**
     * Test that Gradle project structure exists.
     */
    private static void testGradleProjectStructure() {
        System.out.println("\n--- Testing Gradle Project Structure ---");
        
        try {
            // Test that gradle-demo directory exists
            java.io.File gradleDemoDir = new java.io.File("gradle-demo");
            TestFramework.assertTrue(gradleDemoDir.exists(), "gradle-demo directory should exist");
            TestFramework.assertTrue(gradleDemoDir.isDirectory(), "gradle-demo should be a directory");
            
            // Test that src/main/java directory exists
            java.io.File srcMainJava = new java.io.File("gradle-demo/src/main/java");
            TestFramework.assertTrue(srcMainJava.exists(), "gradle-demo/src/main/java should exist");
            TestFramework.assertTrue(srcMainJava.isDirectory(), "gradle-demo/src/main/java should be a directory");
            
            // Test that src/test/java directory exists
            java.io.File srcTestJava = new java.io.File("gradle-demo/src/test/java");
            TestFramework.assertTrue(srcTestJava.exists(), "gradle-demo/src/test/java should exist");
            TestFramework.assertTrue(srcTestJava.isDirectory(), "gradle-demo/src/test/java should be a directory");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Gradle project structure should exist: " + e.getMessage());
        }
    }
    
    /**
     * Test that required Gradle files exist.
     */
    private static void testGradleFiles() {
        System.out.println("\n--- Testing Gradle Files ---");
        
        try {
            // Test that build.gradle.kts exists
            java.io.File buildGradle = new java.io.File("gradle-demo/build.gradle.kts");
            TestFramework.assertTrue(buildGradle.exists(), "build.gradle.kts should exist");
            TestFramework.assertTrue(buildGradle.isFile(), "build.gradle.kts should be a file");
            
            // Test that settings.gradle.kts exists
            java.io.File settingsGradle = new java.io.File("gradle-demo/settings.gradle.kts");
            TestFramework.assertTrue(settingsGradle.exists(), "settings.gradle.kts should exist");
            TestFramework.assertTrue(settingsGradle.isFile(), "settings.gradle.kts should be a file");
            
            // Test that gradlew exists
            java.io.File gradlew = new java.io.File("gradle-demo/gradlew");
            TestFramework.assertTrue(gradlew.exists(), "gradlew should exist");
            TestFramework.assertTrue(gradlew.isFile(), "gradlew should be a file");
            TestFramework.assertTrue(gradlew.canExecute(), "gradlew should be executable");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Gradle files should exist: " + e.getMessage());
        }
    }
    
    /**
     * Test that Gradle wrapper is properly configured.
     */
    private static void testGradleWrapper() {
        System.out.println("\n--- Testing Gradle Wrapper ---");
        
        try {
            // Test that gradle wrapper directory exists
            java.io.File gradleWrapperDir = new java.io.File("gradle-demo/gradle/wrapper");
            TestFramework.assertTrue(gradleWrapperDir.exists(), "gradle/wrapper directory should exist");
            TestFramework.assertTrue(gradleWrapperDir.isDirectory(), "gradle/wrapper should be a directory");
            
            // Test that gradle-wrapper.properties exists
            java.io.File gradleWrapperProps = new java.io.File("gradle-demo/gradle/wrapper/gradle-wrapper.properties");
            TestFramework.assertTrue(gradleWrapperProps.exists(), "gradle-wrapper.properties should exist");
            TestFramework.assertTrue(gradleWrapperProps.isFile(), "gradle-wrapper.properties should be a file");
            
            // Test that gradle-wrapper.jar exists
            java.io.File gradleWrapperJar = new java.io.File("gradle-demo/gradle/wrapper/gradle-wrapper.jar");
            TestFramework.assertTrue(gradleWrapperJar.exists(), "gradle-wrapper.jar should exist");
            TestFramework.assertTrue(gradleWrapperJar.isFile(), "gradle-wrapper.jar should be a file");
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Gradle wrapper should be properly configured: " + e.getMessage());
        }
    }
    
    /**
     * Test that Gradle configuration is correct.
     */
    private static void testGradleConfiguration() {
        System.out.println("\n--- Testing Gradle Configuration ---");
        
        try {
            // Test build.gradle.kts content
            java.io.File buildGradle = new java.io.File("gradle-demo/build.gradle.kts");
            if (buildGradle.exists()) {
                java.util.Scanner scanner = new java.util.Scanner(buildGradle);
                StringBuilder content = new StringBuilder();
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append("\n");
                }
                scanner.close();
                
                String buildContent = content.toString();
                TestFramework.assertTrue(buildContent.contains("plugins"), "build.gradle.kts should contain plugins block");
                TestFramework.assertTrue(buildContent.contains("application"), "build.gradle.kts should contain application plugin");
                TestFramework.assertTrue(buildContent.contains("java"), "build.gradle.kts should contain java plugin");
                TestFramework.assertTrue(buildContent.contains("repositories"), "build.gradle.kts should contain repositories block");
                TestFramework.assertTrue(buildContent.contains("mavenCentral"), "build.gradle.kts should contain mavenCentral repository");
                TestFramework.assertTrue(buildContent.contains("dependencies"), "build.gradle.kts should contain dependencies block");
                TestFramework.assertTrue(buildContent.contains("mainClass"), "build.gradle.kts should contain mainClass configuration");
            }
            
            // Test settings.gradle.kts content
            java.io.File settingsGradle = new java.io.File("gradle-demo/settings.gradle.kts");
            if (settingsGradle.exists()) {
                java.util.Scanner scanner = new java.util.Scanner(settingsGradle);
                StringBuilder content = new StringBuilder();
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append("\n");
                }
                scanner.close();
                
                String settingsContent = content.toString();
                TestFramework.assertTrue(settingsContent.contains("rootProject.name"), "settings.gradle.kts should contain rootProject.name");
            }
            
        } catch (Exception e) {
            TestFramework.assertTrue(false, "Gradle configuration should be correct: " + e.getMessage());
        }
    }
}
