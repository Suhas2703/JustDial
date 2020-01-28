package com.tyss.justdial.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.yaml.snakeyaml.constructor.Constructor;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class StockPage extends BasePage {

	/**
	 * StockPage Constructor
	 * 
	 * @param driver
	 * @param mobileActionUtil
	 */
	public StockPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}
	
	public void testName(String testName) {
		mobileActionUtil.info("\n");
		mobileActionUtil.info("=======================================================================");
		mobileActionUtil.info(" Test Case Name : " + testName);
		mobileActionUtil.info("=======================================================================");
		mobileActionUtil.info("\n");
	}

	/**
	 * Adding the Elements
	 */
	long seconds = 10;
	@FindBy(xpath = "//android.view.View[@text='MANPASAND.NS']")
	private WebElement manPasandNS;

	@FindBy(xpath = "//android.view.View[@text='Manpasand Beverages Limited']")
	private WebElement manPasandBL;

	/**
	 * Utilized Methods
	 */
	public void verifySearchedKeywordWithfirstSearch(String enterText) {
		mobileActionUtil.waitForElement(manPasandNS, seconds, enterText);
		System.out.println(manPasandNS.getText());
		mobileActionUtil.verifyElementText(manPasandNS, seconds, enterText);
	}
}
