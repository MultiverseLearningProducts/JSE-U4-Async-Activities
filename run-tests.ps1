# PowerShell script to run Java tests and return structured results
# This script compiles and runs the Java test suite, then parses the output

param(
    [string]$TestClass = "com.example.test.TestRunner",
    [string]$BranchName = "4-1-solution",
    [string]$TestArgs = "InterfaceContractTest"
)

# Function to create a PowerShell custom object with test results
function New-TestResult {
    param(
        [bool]$AllTestsPassed,
        [int]$TotalTests,
        [int]$PassedTests,
        [int]$FailedTests,
        [array]$FailedTestNames = @(),
        [string]$BranchName,
        [string]$ErrorMessage = ""
    )
    
    return [PSCustomObject]@{
        BranchName = $BranchName
        AllTestsPassed = $AllTestsPassed
        TotalTests = $TotalTests
        PassedTests = $PassedTests
        FailedTests = $FailedTests
        FailedTestNames = $FailedTestNames
        ErrorMessage = $ErrorMessage
        Timestamp = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
    }
}

# Function to run Java tests and parse output
function Invoke-JavaTests {
    param(
        [string]$TestClass,
        [string]$BranchName,
        [string]$TestArgs
    )
    
    try {
        Write-Host "Running tests for branch: $BranchName" -ForegroundColor Cyan
        Write-Host "Test class: $TestClass" -ForegroundColor Cyan
        Write-Host "Test arguments: $TestArgs" -ForegroundColor Cyan
        Write-Host "=" * 50 -ForegroundColor Cyan
        
        # Check if main source files exist
        $mainFiles = Get-ChildItem -Path "src/main/java" -Filter "*.java" -Recurse -ErrorAction SilentlyContinue
        $testFiles = Get-ChildItem -Path "src/test/java" -Filter "*.java" -Recurse -ErrorAction SilentlyContinue
        
        if ($testFiles.Count -eq 0) {
            return New-TestResult -AllTestsPassed $false -TotalTests 0 -PassedTests 0 -FailedTests 0 -BranchName $BranchName -ErrorMessage "No test files found"
        }
        
        # Compile Java files
        Write-Host "Compiling Java files..." -ForegroundColor Yellow
        
        # Build classpath
        $classpath = "src/main/java:src/test/java"
        
        # Compile main source files
        if ($mainFiles.Count -gt 0) {
            $mainCompileResult = javac -cp $classpath $mainFiles.FullName 2>&1
            if ($LASTEXITCODE -ne 0) {
                return New-TestResult -AllTestsPassed $false -TotalTests 0 -PassedTests 0 -FailedTests 0 -BranchName $BranchName -ErrorMessage "Main compilation failed: $mainCompileResult"
            }
        }
        
        # Compile test files
        $testCompileResult = javac -cp $classpath $testFiles.FullName 2>&1
        if ($LASTEXITCODE -ne 0) {
            return New-TestResult -AllTestsPassed $false -TotalTests 0 -PassedTests 0 -FailedTests 0 -BranchName $BranchName -ErrorMessage "Test compilation failed: $testCompileResult"
        }
        
        # Run the test class
        Write-Host "Running tests..." -ForegroundColor Yellow
        $testOutput = java -cp $classpath $TestClass $TestArgs 2>&1
        
        # Parse the test output
        $totalTests = 0
        $passedTests = 0
        $failedTests = 0
        $failedTestNames = @()
        
        # Look for test summary
        if ($testOutput -match "Total Tests: (\d+)") {
            $totalTests = [int]$matches[1]
        }
        
        if ($testOutput -match "Passed: (\d+)") {
            $passedTests = [int]$matches[1]
        }
        
        if ($testOutput -match "Failed: (\d+)") {
            $failedTests = [int]$matches[1]
        }
        
        # Also check for "Tests run" pattern
        if ($totalTests -eq 0 -and $testOutput -match "Tests run: (\d+)") {
            $totalTests = [int]$matches[1]
        }
        
        # Special handling for celebration tests
        if ($totalTests -eq 0 -and $passedTests -eq 0 -and $failedTests -eq 0) {
            # Check if this is a celebration test
            if ($testOutput -match "(CONGRATULATIONS|🎉|✅|Successfully completed|All tests passed)") {
                $totalTests = 1
                $passedTests = 1
                $failedTests = 0
                $allTestsPassed = $true
            } else {
                $allTestsPassed = $false
            }
        } else {
            # Extract failed test names
            $failedTestNames = ($testOutput | Select-String "❌ FAIL: (.+)" | ForEach-Object { $_.Matches[0].Groups[1].Value })
            
            # Determine if all tests passed
            $allTestsPassed = $failedTests -eq 0 -and $totalTests -gt 0
        }
        
        # Display results
        Write-Host "`nTest Results:" -ForegroundColor Green
        Write-Host "Total Tests: $totalTests" -ForegroundColor White
        Write-Host "Passed: $passedTests" -ForegroundColor Green
        Write-Host "Failed: $failedTests" -ForegroundColor Red
        
        if ($allTestsPassed) {
            Write-Host "🎉 ALL TESTS PASSED!" -ForegroundColor Green
        } else {
            Write-Host "❌ Some tests failed" -ForegroundColor Red
            if ($failedTestNames.Count -gt 0) {
                Write-Host "Failed tests:" -ForegroundColor Red
                $failedTestNames | ForEach-Object { Write-Host "  - $_" -ForegroundColor Red }
            }
        }
        
        return New-TestResult -AllTestsPassed $allTestsPassed -TotalTests $totalTests -PassedTests $passedTests -FailedTests $failedTests -FailedTestNames $failedTestNames -BranchName $BranchName
        
    } catch {
        return New-TestResult -AllTestsPassed $false -TotalTests 0 -PassedTests 0 -FailedTests 0 -BranchName $BranchName -ErrorMessage $_.Exception.Message
    }
}

# Main execution
$result = Invoke-JavaTests -TestClass $TestClass -BranchName $BranchName -TestArgs $TestArgs

# Return the result object
return $result
