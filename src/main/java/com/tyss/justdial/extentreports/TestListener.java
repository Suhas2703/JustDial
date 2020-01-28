package com.tyss.justdial.extentreports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

public void onStart(ITestContext context) {
		Reporter.log("************* Test Suite " + context.getName() + " started *************", true);
	}

	public void onFinish(ITestContext context) {
		Reporter.log(("************* Test Suite " + context.getName() + " ending *************"), true);
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		Reporter.log(("************* Running test method " + result.getMethod().getMethodName() + "..."), true);
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("************* Executed " + result.getMethod().getMethodName() + " test successfully...", true);
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("************* Test Execution " + result.getMethod().getMethodName() + " failed...", true);
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("************* Test " + result.getMethod().getMethodName() + " skipped...", true);
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("************* Test failed but within percentage % " + result.getMethod().getMethodName());
	}
}