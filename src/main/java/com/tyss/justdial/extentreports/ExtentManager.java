package com.tyss.justdial.extentreports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	/** Extent Report Variable Declaration **/
	private static ExtentReports extent;
	private static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	private static String reportFileName = "JustDial Test-Automation-Report-" + timeStamp + ".html";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilepath = System.getProperty("user.dir") + fileSeperator + "ExecutionReports";
	private static String reportFileLocation = reportFilepath + fileSeperator + reportFileName;

	
	/**
	 * @author Shobhan
	 * @description Method to get initialized Extent Report object
	 * @return
	 */
	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}


    /**
     * @author Shobhan
     * @description Method to initialize Extent Report object  
     * @return
     */
	public static ExtentReports createInstance() {

		String fileName = getReportPath(reportFilepath);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(reportFileName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		/* Set environment details */
		extent.setSystemInfo("Mobile Application Name", "Just Dial");
		extent.setSystemInfo("Platform", "Android");

		return extent;
	}

    /**
     * @author Shobhan
     * @description Method to fetch the path of report
     * @param path
     * @return
     */
	private static String getReportPath(String path) {

		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
				return reportFileLocation;
			} else {
				System.out.println("Failed to create directory: " + path);
				return System.getProperty("user.dir");
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
		return reportFileLocation;
	}
}