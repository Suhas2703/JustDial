package com.tyss.justdial.extentreports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.tyss.justdial.library.BaseTest;

import io.appium.java_client.android.AndroidDriver;

public class TestListener implements ITestListener {

	/**
	 * @author Shobhan
	 * @description Method to print logs on start of TC execution
	 */
	public void onStart(ITestContext context) {
		Reporter.log("*************** Test Suite " + context.getName() + " Started *************", true);
	}

	/**
	 * @author Shobhan
	 * @description Method to print logs on finish of TC execution
	 */
	public void onFinish(ITestContext context) {
		Reporter.log(("*************** Test Suite " + context.getName() + " Ending *************"), true);
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	/**
	 * @author Shobhan
	 * @description Method to print logs on start of TC execution
	 */
	public void onTestStart(ITestResult result) {
		Reporter.log(("*************** Running test method " + result.getMethod().getMethodName() + "..."), true);
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	/**
	 * @author Shobhan
	 * @description Method to print logs on success of TC execution
	 */
	public void onTestSuccess(ITestResult result) {
		Reporter.log("*************** Executed " + result.getMethod().getMethodName() + " Test Successfully...", true);
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
	}

	/**
	 * @author Shobhan
	 * @description Method to print logs on failure of TC execution
	 */
	public void onTestFailure(ITestResult result) {
		Reporter.log("*************** Test Execution " + result.getMethod().getMethodName() + " Failed...", true);
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		Object obj = result.getInstance();
		BaseTest baseTest = (BaseTest) obj;
		getScreenshotAndAddToReport(baseTest.driver);
	}

	/**
	 * @author Shobhan
	 * @description Method to print logs on skip of TC execution
	 */
	public void onTestSkipped(ITestResult result) {
		Reporter.log("************* Test " + result.getMethod().getMethodName() + " skipped...", true);
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	/**
	 * @author Shobhan
	 * @description Method to print logs with success percentage on fail of TC
	 *              execution
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*************** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	/**
	 * @author Shobhan
	 * @description Method to print logs and take screenshot on failure of TC
	 *              execution
	 */
	public void getScreenshotAndAddToReport(AndroidDriver driver) {

		String screenShotpath = getScreenShot(driver);
		try {
			ExtentTestManager.getTest().addScreenCaptureFromPath(screenShotpath);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Shobhan
	 * @description Method to print logs and take screenshot on failure of TC
	 *              execution
	 */
	public String getScreenShot(AndroidDriver driver) {

		String screenShotName = "screenshot";
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		String DestFile = System.getProperty("user.dir") + "/ScreenShots/" + screenShotName + dateName + ".png";

		File finalDestFile = new File(DestFile);

		// Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, finalDestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return DestFile;
	}
}