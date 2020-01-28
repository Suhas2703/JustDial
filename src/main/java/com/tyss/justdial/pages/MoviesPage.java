package com.tyss.justdial.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class MoviesPage extends BasePage {

	/**
	 * MoviesPage Constructor
	 * 
	 * @param driver
	 * @param mobileActionUtil
	 */
	public MoviesPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
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
	@FindBy(xpath = "//android.view.View[@text='Gully Boy (2019)']")
	private WebElement movieNameTxt;

	/**
	 * Utilized Methods
	 */
	public void VerifyGullyBoy(String expectedText) {
		mobileActionUtil.verifyElementText(movieNameTxt, seconds, expectedText);
	}

}
