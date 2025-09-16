# Gradle Demo Project

This project demonstrates the Gradle build tool for Java applications.

## Project Structure

```
gradle-demo/
├── build.gradle.kts          # Main build script
├── settings.gradle.kts       # Project settings
├── gradlew                   # Gradle wrapper script
├── gradle/wrapper/           # Gradle wrapper files
│   ├── gradle-wrapper.jar
│   └── gradle-wrapper.properties
├── src/
│   ├── main/java/com/example/gradle/
│   │   └── App.java          # Main application
│   └── test/java/com/example/gradle/
│       └── AppTest.java      # Unit tests
└── README.md
```

## Key Gradle Files

### build.gradle.kts
The main build script that defines:
- **Plugins**: `application` and `java` plugins
- **Repositories**: Maven Central for dependencies
- **Dependencies**: JUnit Jupiter for testing, Google Guava for utilities
- **Java Toolchain**: Java 17
- **Application**: Main class configuration

### settings.gradle.kts
Project settings including:
- Project name: `gradle-demo`
- Root project configuration

### gradlew
Gradle wrapper script that:
- Downloads and uses the correct Gradle version
- Ensures consistent builds across environments
- No need to install Gradle globally

## Dependencies

### Test Dependencies
- **JUnit Jupiter 5.10.1**: Modern testing framework
- **JUnit Platform**: Test execution engine

### Application Dependencies
- **Google Guava 32.1.3-jre**: Utility library for collections and more

## How to Use

### Build the Project
```bash
./gradlew build
```
This command:
- Compiles the Java source code
- Runs all tests
- Creates a JAR file
- Generates build reports

### Run the Application
```bash
./gradlew run
```
This command:
- Compiles the code (if needed)
- Runs the main application
- Shows output in the terminal

### Run Tests Only
```bash
./gradlew test
```
This command:
- Compiles test code
- Runs all unit tests
- Generates test reports

### Clean Build Artifacts
```bash
./gradlew clean
```
This command:
- Removes all build outputs
- Starts fresh for next build

### List Available Tasks
```bash
./gradlew tasks
```
This command:
- Shows all available Gradle tasks
- Displays task descriptions

## Gradle Benefits

### 1. Automated Build Process
- No manual compilation needed
- Handles complex build sequences
- Incremental builds (only rebuilds what changed)

### 2. Dependency Management
- Downloads external libraries automatically
- Resolves version conflicts
- Manages transitive dependencies

### 3. Testing Integration
- Built-in support for testing frameworks
- Generates test reports
- Runs tests as part of build process

### 4. Cross-Platform
- Works on Windows, macOS, and Linux
- Consistent behavior across environments
- No platform-specific build scripts

### 5. Plugin Ecosystem
- Extensible with plugins
- Rich ecosystem of community plugins
- Easy to add new functionality

### 6. IDE Integration
- Works with IntelliJ IDEA, Eclipse, VS Code
- Automatic project import
- Integrated debugging and testing

## Professional Development

Gradle is essential for modern Java development because:

- **Automation**: Eliminates manual build steps
- **Consistency**: Same build process everywhere
- **Scalability**: Works for simple and complex projects
- **Integration**: Connects with IDEs and CI/CD pipelines
- **Maintainability**: Easy to understand and modify build logic

## Learning Objectives

After working with this project, you should understand:

1. **Build Scripts**: How to configure plugins and dependencies
2. **Dependency Management**: How external libraries are handled
3. **Testing Integration**: How tests are run automatically
4. **Gradle Wrapper**: How to ensure consistent builds
5. **Common Commands**: Essential Gradle tasks for daily development
6. **Professional Workflow**: How build tools fit into modern development

## Next Steps

- Explore more Gradle plugins
- Learn about multi-project builds
- Integrate with CI/CD pipelines
- Study advanced dependency management
- Explore Gradle's Kotlin DSL features
