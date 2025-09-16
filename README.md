# Unit 4: Package Organization - Starter Template

This is the starter template for learning Java package organization and import management.

## Your Task

**Organizing Your Storefront with Packages**

Refactor the existing classes into a logical package structure to improve project organization and prevent naming conflicts.

### Requirements

1. **Add package declarations** to all Java files:
   - `Product.java` and `DigitalProduct.java` should be in `com.example.model` package
   - `Store.java` should be in `com.example.main` package

2. **Add import statements** to `Store.java`:
   - Import `Product` from `com.example.model`
   - Import `DigitalProduct` from `com.example.model`
   - Import `ArrayList` from `java.util`

3. **Uncomment and test** the code in `Store.java` main method

## Project Structure

```
unit-4-work/
├── src/main/java/
│   └── com/
│       └── example/
│           ├── model/
│           │   ├── Product.java (TODO: add package declaration)
│           │   └── DigitalProduct.java (TODO: add package declaration)
│           └── main/
│               └── Store.java (TODO: add package declaration and imports)
├── README.md
└── .gitignore
```

## Learning Objectives

- Understand Java package organization
- Learn proper package naming conventions
- Master import statements and dependencies
- Organize code for professional development
- Prevent naming conflicts through packages

## How to Complete

1. **Add package declarations** at the top of each Java file:
   ```java
   package com.example.model;  // For Product.java and DigitalProduct.java
   package com.example.main;   // For Store.java
   ```

2. **Add import statements** to Store.java:
   ```java
   import com.example.model.Product;
   import com.example.model.DigitalProduct;
   import java.util.ArrayList;
   ```

3. **Uncomment the code** in the main method of Store.java

4. **Test your solution**:
   ```bash
   javac src/main/java/com/example/model/*.java src/main/java/com/example/main/*.java
   java -cp src/main/java com.example.main.Store
   ```

## Key Concepts

- **Package Declaration**: `package com.example.model;`
- **Import Statements**: `import com.example.model.Product;`
- **Fully Qualified Names**: `com.example.model.Product`
- **Package Organization**: Logical grouping of related classes
- **Namespace Protection**: Preventing naming conflicts

## Success Criteria

✅ All Java files have correct package declarations  
✅ Store.java has proper import statements  
✅ Code compiles without errors  
✅ Application runs successfully  
✅ Demonstrates professional package organization  

## Professional Benefits

1. **Clear Organization**: Related classes grouped together
2. **Namespace Protection**: No naming conflicts between packages
3. **Import Management**: Clear dependencies between packages
4. **Scalability**: Easy to add new packages and classes
5. **Industry Standards**: Professional Java development practices
