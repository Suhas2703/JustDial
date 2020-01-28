package com.tyss.justdial.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class Shopping extends BasePage {
	
	/**
	 * Shopping Constructor
	 * @param driver
	 * @param mobileActionUtil
	 */
	public Shopping(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
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
	long timeinSeconds = 5;
	@FindBy(xpath = "//android.widget.TextView[@text='Shopping']")
	private WebElement ShoppingTab;

	/**
	 * Utilized Methods
	 */
	public void verifySearchResultPage(String enterText) {
		mobileActionUtil.waitForElement(ShoppingTab, timeinSeconds, "Shopping Navigation Bar");
		mobileActionUtil.verifyElementText(ShoppingTab, timeinSeconds, enterText);
	}
}
