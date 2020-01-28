package com.tyss.justdial.library;

public interface IAutoConstant {

	String DIR_PATH = System.getProperty("user.dir");
	String XL_MAINPATH = DIR_PATH + "/src/main/resources/mainResources/DataDrivenTestingMain.xlsx";
	String XL_TESTPATH = DIR_PATH + "/src/test/resources/testResources/DataDrivenTestingTest.xlsx";
	String REPORT_PATH = DIR_PATH + "/Reports/ExtentReports";
	String RUN_ENV = "local";
	String SIM_STATUS="withSim";
	String DEVICENAME ="DEVICENAME";
	String PLATFORM_NAME ="PLATFORM_NAME";
	String PLATFORM_VERSION ="PLATFORM_VERSION";
	String AUTOMATION_NAME ="AUTOMATION_NAME";
	String APP_PACKAGE ="APP_PACKAGE"; 
	String APP_ACTIVITY ="APP_ACTIVITY"; 
	String PORT ="PORT"; 
	String UDID ="UDID"; 
	String IP ="IP";
}