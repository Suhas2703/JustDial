package com.tyss.justdial.extentreports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class ExtentTestManager {

	/** Extent Test Manager Variable Declaration **/
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();

	/** 
	 * @author Shobhan
	 * @description Method to synchronize the test results
	 * @return
	 */
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	/** 
	 * @author Shobhan
	 * @description Method to flush the results to the report
	 * @return
	 */
	public static synchronized void endTest() {
		extent.flush();
	}

	/** 
	 * @author Shobhan
	 * @description Method to synchronize the test results
	 * @return
	 */
	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
}