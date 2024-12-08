package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
    private static ExtentReports extent = ExtentManager.getExtent();

    public static ExtentTest startTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        testThread.set(test);
        return test;
    }

    public static void endTest() {
        extent.flush();
    }

    public static ExtentTest getTest() {
        return testThread.get();
    }
}
