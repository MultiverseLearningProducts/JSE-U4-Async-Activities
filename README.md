# Unit 4: Package Organization

This project demonstrates professional Java package organization and import management.

## Project Structure

```
unit-4-work/
├── src/main/java/
│   └── com/
│       └── example/
│           ├── model/
│           │   ├── Product.java
│           │   └── DigitalProduct.java
│           └── main/
│               └── Store.java
├── README.md
└── .gitignore
```

## Learning Objectives

- Understand Java package organization
- Learn proper package naming conventions
- Master import statements and dependencies
- Organize code for professional development
- Prevent naming conflicts through packages

## How to Run

1. Compile all Java files:
   ```bash
   javac src/main/java/com/example/model/*.java src/main/java/com/example/main/*.java
   ```

2. Run the Store application:
   ```bash
   java -cp src/main/java com.example.main.Store
   ```

## Package Structure

### com.example.model
Contains all data model classes:
- **Product**: Base product class with encapsulation
- **DigitalProduct**: Extended product class with inheritance

### com.example.main
Contains application entry point:
- **Store**: Main class demonstrating package usage and imports

## Key Concepts

- **Package Declaration**: `package com.example.model;`
- **Import Statements**: `import com.example.model.Product;`
- **Fully Qualified Names**: `com.example.model.Product`
- **Package Organization**: Logical grouping of related classes
- **Namespace Protection**: Preventing naming conflicts

## Professional Benefits

1. **Clear Organization**: Related classes grouped together
2. **Namespace Protection**: No naming conflicts between packages
3. **Import Management**: Clear dependencies between packages
4. **Scalability**: Easy to add new packages and classes
5. **Industry Standards**: Professional Java development practices
