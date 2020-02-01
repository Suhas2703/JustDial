package com.tyss.justdial.library;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tyss.justdial.pages.LoginPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest implements IAutoConstant {

	/** Variable Declaration for Base Test Configuration**/
	public ExcelLibrary ExcelLibrary = new ExcelLibrary();
	public AndroidDriver driver;
	public MobileActionUtil mobileActionUtil;
	public LoginPage loginPage;

	
	/**
	 * @author Shobhan
	 * @description Getting parameters from the TestNG
	 * @param deviceName
	 * @param platformName
	 * @param platformVersion
	 * @param automationName
	 * @param appPackage
	 * @param appActivity
	 * @param port
	 * @param udid
	 * @param ip
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	@Parameters({ "deviceName",
				  "platformName",
				  "platformVersion", 
				  "automationName", 
				  "appPackage", 
				  "appActivity",
				  "port",
				  "udid",
				  "ip" })
	@BeforeMethod
	public void beforeConfig(@Optional String deviceName, 
							 @Optional String platformName, 
							 @Optional String platformVersion,
							 @Optional String automationName, 
							 @Optional String appPackage, 
							 @Optional String appActivity,
							 @Optional String port, 
							 @Optional String udid, 
							 @Optional String ip) throws MalformedURLException, InterruptedException {

		
		/*To Run Scripts Locally*/
		if (RUN_ENV.equals("local")){
			
			Reporter.log("Running Scripts in Local Device",true);
			launchApp(deviceName, 
					  platformName,
					  platformVersion,
					  automationName,
					  appPackage,
					  appActivity,
					  port,
					  udid,
					  ip);
		} 

		/*To Run Scripts in BrowserStack*/
		else if (RUN_ENV.equals("external")) {
		
			Reporter.log("Running Scripts in browserstack Device", true);
			String userName = "shreyau1";
			String accessKey = "oEUhApyGPx6ss5XVrLKJ";
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("device", "Samsung Galaxy S8");
			caps.setCapability("os_version", "7.0");
			caps.setCapability("project", "My First Project");
			caps.setCapability("build", "My First Build");
			caps.setCapability("name", "Bstack-[Java] Sample Test");
			caps.setCapability("app", "bs://aadd20dcc0c64df74ce06b05da09b790d30ef811");
			caps.setCapability("browserstack.debug", "true");
			caps.setCapability("browserstack.video", "true");
			caps.setCapability("automationName", "appium");
			caps.setCapability("appPackage", "com.justdial.search");
			caps.setCapability("appActivity", ".SplashScreenNewActivity");
	
			URL url = new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");
			driver = new AndroidDriver<MobileElement>(url, caps);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			mobileActionUtil = new MobileActionUtil(driver);
		}
	}

	/**
	 * Closing the Session in the Device
	 */
	@AfterSuite
	public void afterClass() {
		closeApp();
	}


	/**
	 * @author Shobhan
	 * @description Launching the Application
	 * @param deviceName
	 * @param platformName
	 * @param platformVersion
	 * @param automationName
	 * @param appPackage
	 * @param appActivity
	 * @param port
	 * @param udid
	 * @param ip
	 */
	public void launchApp(String deviceName,
								  String platformName, 
								  String platformVersion, 
								  String automationName,
								  String appPackage, 
								  String appActivity, 
								  String port, 
								  String udid, 
								  String ip){
				
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		capabilities.setCapability(MobileCapabilityType.VERSION, platformVersion);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1200);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
	//	capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, 180000);
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capabilities.setCapability(MobileCapabilityType.UDID, udid);
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("uiautomator2ServerInstallTimeout", 50000);
		capabilities.setCapability("adbExecTimeout", 50000);
		capabilities.setCapability("gpsEnabled", true);
	
		try {
			if (driver != null) {
			}
			URL url = new URL("http://" + ip + ":" + port + "/wd/hub");
			driver = new AndroidDriver<MobileElement>(url, capabilities);
		} catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
			mobileActionUtil = new MobileActionUtil(driver);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	/**
	 * @author Shobhan
	 * @description Closing The Driver Session
	 */
	public void closeApp() {
		try {
			if (driver != null) {
				System.out.println("Closing the Application");
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}