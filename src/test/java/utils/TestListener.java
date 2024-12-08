package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Starting Test: " + result.getName());
        ExtentTestManager.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("Test Failed: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
    }
}
