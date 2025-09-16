# Unit 4: Package Organization and Module System

This project demonstrates professional Java package organization and the Java Platform Module System (JPMS).

## Project Structure

```
unit-4-work/
├── src/main/java/
│   ├── module-info.java (Module definition)
│   └── com/
│       └── example/
│           ├── model/ (Exported package)
│           │   ├── Product.java
│           │   └── DigitalProduct.java
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
- Organize code for professional development

## Module System

### Module Definition (module-info.java)
```java
module com.example.store {
    exports com.example.model;
}
```

### Key Concepts
- **Module Name**: `com.example.store` (unique identifier)
- **Exported Packages**: `com.example.model` (public API)
- **Internal Packages**: `com.example.main` (private implementation)
- **Encapsulation**: Stronger than packages alone

## How to Run

### Compile with Module System
```bash
# Compile the module
javac --module-source-path src/main/java -d out src/main/java/module-info.java src/main/java/com/example/model/*.java src/main/java/com/example/main/*.java

# Run the module
java --module-path out --module com.example.store/com.example.main.Store
```

### Traditional Compilation (without modules)
```bash
# Compile all Java files
javac src/main/java/com/example/model/*.java src/main/java/com/example/main/*.java

# Run the Store application
java -cp src/main/java com.example.main.Store
```

## Package Structure

### com.example.model (Exported)
Contains all data model classes that are part of the public API:
- **Product**: Base product class with encapsulation
- **DigitalProduct**: Extended product class with inheritance

### com.example.main (Internal)
Contains application entry point (not exported):
- **Store**: Main class demonstrating package usage and imports

## Key Concepts

### Package Organization
- **Package Declaration**: `package com.example.model;`
- **Import Statements**: `import com.example.model.Product;`
- **Fully Qualified Names**: `com.example.model.Product`
- **Package Organization**: Logical grouping of related classes
- **Namespace Protection**: Preventing naming conflicts

### Module System (JPMS)
- **Module Definition**: `module com.example.store { ... }`
- **Exports**: `exports com.example.model;`
- **Module Boundaries**: Control package-level access
- **Stronger Encapsulation**: Beyond package-level privacy
- **Dependency Management**: Explicit module dependencies

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

## Module vs Package Comparison

| Aspect | Packages | Modules |
|--------|----------|---------|
| **Scope** | Organize classes | Organize packages |
| **Encapsulation** | Class-level (public/private) | Package-level (exports) |
| **Dependencies** | Import statements | Module dependencies |
| **Namespace** | Package names | Module names |
| **Access Control** | Member-level | Package-level |
| **Use Case** | Small to medium projects | Large-scale applications |

## Learning Progression

### 4-1-Solution: Package Organization
- Package declarations and imports
- Basic code organization
- Professional structure

### 4-2-Solution: Module System
- Module definition (module-info.java)
- Package exports and encapsulation
- Advanced organization concepts

## Success Criteria

✅ All Java files have correct package declarations  
✅ Store.java has proper import statements  
✅ module-info.java defines module boundaries  
✅ Exported packages are clearly defined  
✅ Code compiles and runs with module system  
✅ Demonstrates professional organization at both package and module levels  

## Next Steps

After mastering package and module organization, you'll be ready for:
- Exception handling and error management
- File I/O operations
- Advanced OOP concepts (interfaces, abstract classes)
- Design patterns
- Enterprise application development
