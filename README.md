# Unit 4: Package Organization, Module System, Interface Contracts, and Build Tools

This project demonstrates professional Java package organization, the Java Platform Module System (JPMS), interface contracts, modern interface features, and Gradle build tool usage.

## Project Structure

```
unit-4-work/
├── src/main/java/
│   ├── module-info.java (Module definition)
│   └── com/
│       └── example/
│           ├── contracts/ (Interface contracts with modern features)
│           │   └── Describable.java (Default & static methods)
│           ├── model/ (Exported package)
│           │   ├── Product.java (implements Describable)
│           │   └── DigitalProduct.java (implements Describable)
│           └── main/ (Internal package)
│               └── Store.java (Demonstrates modern interface usage)
├── gradle-demo/ (Gradle build tool demonstration)
│   ├── build.gradle.kts
│   ├── settings.gradle.kts
│   ├── gradlew
│   ├── gradle/wrapper/
│   └── src/main/java/com/example/gradle/
│       └── App.java
├── README.md
└── .gitignore
```

## Learning Objectives

- Understand Java package organization
- Learn proper package naming conventions
- Master import statements and dependencies
- Understand the Java Platform Module System (JPMS)
- Learn module boundaries and encapsulation
- Master interface contracts and programming to interfaces
- Understand modern Java interface features (Java 8+)
- Learn default methods and static methods in interfaces
- Understand interface evolution and backward compatibility
- Master Gradle build tool for professional Java development
- Learn dependency management and automated builds
- Organize code for professional development

## Gradle Build Tool

### What is Gradle?
Gradle is a modern build automation tool that:
- **Automates** the build process (compile, test, package)
- **Manages** dependencies and external libraries
- **Integrates** with testing frameworks
- **Provides** consistent builds across environments
- **Scales** from simple projects to enterprise applications

### Key Gradle Files

#### build.gradle.kts
The main build script that defines:
```kotlin
plugins {
    application  // For CLI applications
    java         // For Java support
}

repositories {
    mavenCentral()  // Dependency repository
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    implementation("com.google.guava:guava:32.1.3-jre")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

application {
    mainClass.set("com.example.gradle.App")
}
```

#### settings.gradle.kts
Project configuration:
```kotlin
rootProject.name = "gradle-demo"
```

#### gradlew
Gradle wrapper script that:
- Downloads the correct Gradle version
- Ensures consistent builds across environments
- No need to install Gradle globally

### Common Gradle Commands

```bash
# Build the project (compile + test)
./gradlew build

# Run the application
./gradlew run

# Run tests only
./gradlew test

# Clean build artifacts
./gradlew clean

# List available tasks
./gradlew tasks
```

## Modern Interface Features (Java 8+)

### Describable Interface with Modern Features
```java
public interface Describable {
    // Abstract methods (must be implemented)
    String getName();
    String getDescription();
    
    // Default method (optional implementation)
    default void printDescription() {
        System.out.println(getName() + ": " + getDescription());
    }
    
    // Static method (belongs to interface)
    static String getApplicationName() {
        return "My Awesome Store";
    }
}
```

### Key Modern Concepts
- **Default Methods**: `default void printDescription() { ... }`
- **Static Methods**: `static String getApplicationName() { ... }`
- **Interface Evolution**: Add functionality without breaking existing code
- **Backward Compatibility**: Existing implementations automatically get new features

## How to Run

### Traditional Java Compilation
```bash
# Compile all Java files
javac src/main/java/com/example/contracts/*.java src/main/java/com/example/model/*.java src/main/java/com/example/main/*.java

# Run the Store application
java -cp src/main/java com.example.main.Store
```

### Gradle Build Tool
```bash
# Navigate to Gradle project
cd gradle-demo

# Build the project
./gradlew build

# Run the application
./gradlew run

# Run tests
./gradlew test
```

## Package Structure

### com.example.contracts (Exported)
Contains interface definitions with modern Java features:
- **Describable**: Interface with default and static methods

### com.example.model (Exported)
Contains all data model classes that are part of the public API:
- **Product**: Base product class implementing Describable
- **DigitalProduct**: Extended product class with custom description

### com.example.main (Internal)
Contains application entry point (not exported):
- **Store**: Main class demonstrating modern interface features

### com.example.gradle (Gradle Demo)
Contains Gradle demonstration application:
- **App**: Main class showing Gradle functionality

## Key Concepts

### Package Organization
- **Package Declaration**: `package com.example.contracts;`
- **Import Statements**: `import com.example.contracts.Describable;`
- **Fully Qualified Names**: `com.example.contracts.Describable`
- **Package Organization**: Logical grouping of related classes
- **Namespace Protection**: Preventing naming conflicts

### Module System (JPMS)
- **Module Definition**: `module com.example.store { ... }`
- **Exports**: `exports com.example.contracts;`
- **Module Boundaries**: Control package-level access
- **Stronger Encapsulation**: Beyond package-level privacy
- **Dependency Management**: Explicit module dependencies

### Interface Contracts
- **Interface Definition**: `public interface Describable { ... }`
- **Implementation**: `public class Product implements Describable { ... }`
- **Method Override**: `@Override public String getDescription() { ... }`
- **Polymorphism**: Same interface, different implementations
- **Programming to Interfaces**: Code depends on interface, not implementation

### Modern Interface Features
- **Default Methods**: `default void printDescription() { ... }`
- **Static Methods**: `static String getApplicationName() { ... }`
- **Interface Evolution**: Add functionality without breaking existing code
- **Backward Compatibility**: Existing implementations automatically inherit new features
- **Optional Override**: Classes can override default methods if needed

### Gradle Build Tool
- **Build Automation**: Compile, test, and package automatically
- **Dependency Management**: Download and manage external libraries
- **Testing Integration**: Run tests as part of build process
- **Cross-Platform**: Works on Windows, macOS, and Linux
- **Plugin Ecosystem**: Extensible with plugins
- **IDE Integration**: Works with IntelliJ IDEA, Eclipse, VS Code

## Professional Benefits

### Package Organization
1. **Clear Organization**: Related classes grouped together
2. **Namespace Protection**: No naming conflicts between packages
3. **Import Management**: Clear dependencies between packages
4. **Scalability**: Easy to add new packages and classes
5. **Industry Standards**: Professional Java development practices

### Module System
1. **Stronger Encapsulation**: Package-level access control
2. **Explicit Dependencies**: Clear module relationships
3. **Security**: Internal packages cannot be accessed externally
4. **Maintainability**: Clear boundaries between modules
5. **Large-Scale Applications**: Essential for enterprise development

### Interface Contracts
1. **Formal Contracts**: Define what methods must be implemented
2. **Polymorphism**: Same interface, different implementations
3. **Flexibility**: Easy to add new types that implement the interface
4. **Decoupling**: Code depends on interface, not specific implementation
5. **Testability**: Easy to create mock objects for testing
6. **Maintainability**: Changes to implementation don't affect interface users

### Modern Interface Features
1. **Interface Evolution**: Add new functionality without breaking existing code
2. **Backward Compatibility**: Existing implementations automatically get new features
3. **Code Reuse**: Default methods reduce code duplication
4. **Utility Methods**: Static methods provide interface-level functionality
5. **Optional Override**: Classes can override default methods if needed
6. **Non-Breaking Changes**: Essential for maintaining large codebases

### Gradle Build Tool
1. **Automation**: Eliminates manual build steps
2. **Consistency**: Same build process everywhere
3. **Scalability**: Works for simple and complex projects
4. **Integration**: Connects with IDEs and CI/CD pipelines
5. **Maintainability**: Easy to understand and modify build logic
6. **Professional Development**: Industry standard for Java projects

## Learning Progression

### 4-1-Solution: Package Organization
- Package declarations and imports
- Basic code organization
- Professional structure

### 4-2-Solution: Module System
- Module definition (module-info.java)
- Package exports and encapsulation
- Advanced organization concepts

### 4-3-Solution: Interface Contracts
- Interface definition and implementation
- Programming to interfaces
- Polymorphism and decoupled design

### 4-4-Solution: Modern Interface Features
- Default methods and static methods
- Interface evolution and backward compatibility
- Modern Java development practices

### 4-5-Solution: Gradle Build Tool
- Build automation and dependency management
- Professional development workflow
- Industry-standard build practices

## Success Criteria

✅ All Java files have correct package declarations  
✅ Store.java has proper import statements  
✅ module-info.java defines module boundaries  
✅ Exported packages are clearly defined  
✅ Describable interface is properly defined  
✅ Product and DigitalProduct implement Describable  
✅ Interface methods are properly implemented  
✅ Default methods are defined and working  
✅ Static methods are defined and working  
✅ Gradle project is properly configured  
✅ Gradle build and run commands work  
✅ Dependencies are managed automatically  
✅ Tests are integrated with build process  
✅ Demonstrates professional organization at all levels  

## Next Steps

After mastering package organization, module system, interface contracts, modern interface features, and Gradle build tools, you'll be ready for:
- Abstract classes and advanced OOP concepts
- Exception handling and error management
- File I/O operations
- Design patterns (Strategy, Factory, Observer)
- Lambda expressions and functional programming
- Stream API and modern Java collections
- Spring Framework and dependency injection
- Enterprise application development
- CI/CD pipeline integration
