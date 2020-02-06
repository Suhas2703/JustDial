package com.tyss.justdial.pages.homepage.travel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class TravelPage extends BasePage {

	/**
	 * @author Shobhan
	 * @description Constructor to initialize TravelPage mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public TravelPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	/**
	 * @author Shobhan
	 * @description Method to log test name info
	 * @param testName
	 */
	public void testName(String testName) {

		mobileActionUtil.info("\n");
		mobileActionUtil.info("=======================================================================");
		mobileActionUtil.info(" Test Case Name : " + testName);
		mobileActionUtil.info("=======================================================================");
		mobileActionUtil.info("\n");
	}

	/** TRAVEL SCREEN MOBILE ELEMENTS DECLARATION **/
	
	long seconds = 10;
	@FindBy(xpath = "//android.widget.TextView[@text='Flights']")
	private WebElement flightsFilters;

	public void selectFlightFilter() {
		mobileActionUtil.clickOnMobileElement(flightsFilters, "Select Flight Filter");
	}
	
	public void verifyFlightsFilterIsDisplayed() {
		mobileActionUtil.verifyElementIsDisplayed(flightsFilters, seconds, "'Flights' Filters");
	}
	
	@FindBy(xpath = "resource-id='com.justdial.search:id/filter_img_root'")
	private WebElement navigationArrow;
	/**
	 * @author Pawan Kumar
	 * @description Method to verify navigation arrow is displayed
	 */
	public void verifyNavigationArrowIsDisplayed() {
		mobileActionUtil.verifyElementIsDisplayed(navigationArrow, seconds, "Navigation Arrow");
	}
	
	/**
	 * @author Pawan Kumar
	 * @description Method verify the flight btn is Tapable
	 */
	public void verifyFlightFilterTapable() {
		mobileActionUtil.isClickable(flightsFilters, seconds);
	}
}
