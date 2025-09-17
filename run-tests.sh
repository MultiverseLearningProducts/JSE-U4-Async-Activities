#!/bin/bash

# Bash script to run Java tests and return structured results
# This script compiles and runs the Java test suite, then parses the output

TEST_CLASS=${1:-"com.example.test.TestRunner"}
BRANCH_NAME=${2:-"4-1-solution"}
TEST_ARGS=${3:-"InterfaceContractTest"}

echo "Running tests for branch: $BRANCH_NAME"
echo "Test class: $TEST_CLASS"
echo "Test arguments: $TEST_ARGS"
echo "=================================================="

# Function to create JSON-like output
create_test_result() {
    local all_tests_passed=$1
    local total_tests=$2
    local passed_tests=$3
    local failed_tests=$4
    local failed_test_names=$5
    local error_message=$6
    
    echo "{"
    echo "  \"BranchName\": \"$BRANCH_NAME\","
    echo "  \"AllTestsPassed\": $all_tests_passed,"
    echo "  \"TotalTests\": $total_tests,"
    echo "  \"PassedTests\": $passed_tests,"
    echo "  \"FailedTests\": $failed_tests,"
    echo "  \"FailedTestNames\": [$failed_test_names],"
    echo "  \"ErrorMessage\": \"$error_message\","
    echo "  \"Timestamp\": \"$(date '+%Y-%m-%d %H:%M:%S')\""
    echo "}"
}

# Check if test files exist
if [ ! -d "src/test/java" ] || [ -z "$(find src/test/java -name '*.java' -type f)" ]; then
    create_test_result false 0 0 0 "[]" "No test files found"
    exit 1
fi

# Compile Java files
echo "Compiling Java files..."

# Find all Java files
MAIN_FILES=$(find src/main/java -name "*.java" -type f 2>/dev/null | tr '\n' ' ')
TEST_FILES=$(find src/test/java -name "*.java" -type f 2>/dev/null | tr '\n' ' ')

# Build classpath
CLASSPATH="src/main/java:src/test/java"

# Compile main source files if they exist
if [ -n "$MAIN_FILES" ]; then
    javac -cp "$CLASSPATH" $MAIN_FILES 2>&1
    if [ $? -ne 0 ]; then
        create_test_result false 0 0 0 "[]" "Main compilation failed"
        exit 1
    fi
fi

# Compile test files
javac -cp "$CLASSPATH" $TEST_FILES 2>&1
if [ $? -ne 0 ]; then
    create_test_result false 0 0 0 "[]" "Test compilation failed"
    exit 1
fi

# Run the test class
echo "Running tests..."
TEST_OUTPUT=$(java -cp "$CLASSPATH" "$TEST_CLASS" $TEST_ARGS 2>&1)

# Parse the test output
TOTAL_TESTS=0
PASSED_TESTS=0
FAILED_TESTS=0
FAILED_TEST_NAMES=""

# Extract numbers from test summary using grep -o
TOTAL_TESTS=$(echo "$TEST_OUTPUT" | grep "Total Tests:" | grep -o '[0-9]\+' | head -1)
PASSED_TESTS=$(echo "$TEST_OUTPUT" | grep "Passed:" | grep -o '[0-9]\+' | head -1)
FAILED_TESTS=$(echo "$TEST_OUTPUT" | grep "Failed:" | grep -o '[0-9]\+' | head -1)

# Also check for "Tests run" pattern
if [ -z "$TOTAL_TESTS" ] || [ "$TOTAL_TESTS" -eq 0 ]; then
    TOTAL_TESTS=$(echo "$TEST_OUTPUT" | grep "Tests run:" | grep -o '[0-9]\+' | head -1)
fi

# Handle cases where parsing might fail
if [ -z "$TOTAL_TESTS" ] || ! [[ "$TOTAL_TESTS" =~ ^[0-9]+$ ]]; then
    TOTAL_TESTS=0
fi
if [ -z "$PASSED_TESTS" ] || ! [[ "$PASSED_TESTS" =~ ^[0-9]+$ ]]; then
    PASSED_TESTS=0
fi
if [ -z "$FAILED_TESTS" ] || ! [[ "$FAILED_TESTS" =~ ^[0-9]+$ ]]; then
    FAILED_TESTS=0
fi

# Special handling for celebration tests
if [ "$TOTAL_TESTS" -eq 0 ] && [ "$PASSED_TESTS" -eq 0 ] && [ "$FAILED_TESTS" -eq 0 ]; then
    # Check if this is a celebration test
    if echo "$TEST_OUTPUT" | grep -q -E "(CONGRATULATIONS|🎉|✅|Successfully completed|All tests passed)"; then
        TOTAL_TESTS=1
        PASSED_TESTS=1
        FAILED_TESTS=0
        ALL_TESTS_PASSED=true
    else
        ALL_TESTS_PASSED=false
    fi
else
    # Extract failed test names
    FAILED_TEST_NAMES=$(echo "$TEST_OUTPUT" | grep "❌ FAIL:" | sed 's/.*❌ FAIL: \(.*\)/\1/' | sed 's/^/"/' | sed 's/$/"/' | tr '\n' ',' | sed 's/,$//')
    if [ -z "$FAILED_TEST_NAMES" ]; then
        FAILED_TEST_NAMES=""
    else
        FAILED_TEST_NAMES="[$FAILED_TEST_NAMES]"
    fi
    
    # Determine if all tests passed
    if [ "$FAILED_TESTS" -eq 0 ] && [ "$TOTAL_TESTS" -gt 0 ]; then
        ALL_TESTS_PASSED=true
    else
        ALL_TESTS_PASSED=false
    fi
fi

# Display results
echo ""
echo "Test Results:"
echo "Total Tests: $TOTAL_TESTS"
echo "Passed: $PASSED_TESTS"
echo "Failed: $FAILED_TESTS"

if [ "$ALL_TESTS_PASSED" = true ]; then
    echo "🎉 ALL TESTS PASSED!"
else
    echo "❌ Some tests failed"
    if [ -n "$FAILED_TEST_NAMES" ] && [ "$FAILED_TEST_NAMES" != "[]" ]; then
        echo "Failed tests:"
        echo "$TEST_OUTPUT" | grep "❌ FAIL:" | sed 's/.*❌ FAIL: /  - /'
    fi
fi

# Return the result
create_test_result "$ALL_TESTS_PASSED" "$TOTAL_TESTS" "$PASSED_TESTS" "$FAILED_TESTS" "$FAILED_TEST_NAMES" ""
