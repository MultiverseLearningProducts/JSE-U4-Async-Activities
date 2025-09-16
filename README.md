# Unit 4: Package Organization, Module System, and Interface Contracts

This project demonstrates professional Java package organization, the Java Platform Module System (JPMS), and interface contracts for flexible, decoupled code design.

## Project Structure

```
unit-4-work/
├── src/main/java/
│   ├── module-info.java (Module definition)
│   └── com/
│       └── example/
│           ├── contracts/ (Interface contracts)
│           │   └── Describable.java
│           ├── model/ (Exported package)
│           │   ├── Product.java (implements Describable)
│           │   └── DigitalProduct.java (implements Describable)
│           └── main/ (Internal package)
│               └── Store.java
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
- Understand polymorphism and decoupled code design
- Organize code for professional development

## Interface Contracts

### Describable Interface
```java
public interface Describable {
    String getName();
    String getDescription();
}
```

### Implementation
- **Product class**: Implements Describable with basic product description
- **DigitalProduct class**: Overrides getDescription() with digital-specific details
- **Store class**: Demonstrates programming to interfaces

### Key Concepts
- **Interface Definition**: `public interface Describable { ... }`
- **Implementation**: `public class Product implements Describable { ... }`
- **Method Override**: `@Override public String getDescription() { ... }`
- **Polymorphism**: Same interface, different implementations

## Module System

### Module Definition (module-info.java)
```java
module com.example.store {
    exports com.example.model;
    exports com.example.contracts;
}
```

### Key Concepts
- **Module Name**: `com.example.store` (unique identifier)
- **Exported Packages**: `com.example.model`, `com.example.contracts` (public API)
- **Internal Packages**: `com.example.main` (private implementation)
- **Encapsulation**: Stronger than packages alone

## How to Run

### Compile and Run
```bash
# Compile all Java files
javac src/main/java/com/example/contracts/*.java src/main/java/com/example/model/*.java src/main/java/com/example/main/*.java

# Run the Store application
java -cp src/main/java com.example.main.Store
```

### Module System (Alternative)
```bash
# Compile with module system
javac --module-source-path src/main/java -d out src/main/java/com.example.store/module-info.java src/main/java/com.example.store/com/example/contracts/*.java src/main/java/com.example.store/com/example/model/*.java src/main/java/com.example.store/com/example/main/*.java

# Run with module system
java --module-path out --module com.example.store/com.example.main.Store
```

## Package Structure

### com.example.contracts (Exported)
Contains interface definitions that define contracts:
- **Describable**: Interface for objects that can be described

### com.example.model (Exported)
Contains all data model classes that are part of the public API:
- **Product**: Base product class implementing Describable
- **DigitalProduct**: Extended product class with custom description

### com.example.main (Internal)
Contains application entry point (not exported):
- **Store**: Main class demonstrating interface contracts

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

## Interface vs Class Comparison

| Aspect | Classes | Interfaces |
|--------|---------|------------|
| **Definition** | Both behavior and state | Behavior only (method signatures) |
| **Instantiation** | Can be instantiated | Cannot be instantiated |
| **Inheritance** | Single inheritance | Multiple implementation |
| **Fields** | Can have instance variables | Only constants (public static final) |
| **Methods** | Concrete implementations | Abstract method signatures |
| **Access Modifiers** | public, private, protected | public (implicit) |
| **Use Case** | Object blueprints | Behavior contracts |

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

## Success Criteria

✅ All Java files have correct package declarations  
✅ Store.java has proper import statements  
✅ module-info.java defines module boundaries  
✅ Exported packages are clearly defined  
✅ Describable interface is properly defined  
✅ Product and DigitalProduct implement Describable  
✅ Interface methods are properly implemented  
✅ Code compiles and runs with interface contracts  
✅ Demonstrates professional organization at package, module, and interface levels  

## Next Steps

After mastering package organization, module system, and interface contracts, you'll be ready for:
- Abstract classes and advanced OOP concepts
- Exception handling and error management
- File I/O operations
- Design patterns (Strategy, Factory, Observer)
- Enterprise application development
- Spring Framework and dependency injection
