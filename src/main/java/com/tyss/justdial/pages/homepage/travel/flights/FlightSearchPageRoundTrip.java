package com.tyss.justdial.pages.homepage.travel.flights;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.tyss.justdial.extentreports.ExtentTestManager;
import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;
import io.appium.java_client.android.AndroidDriver;

public class FlightSearchPageRoundTrip extends BasePage {

	/**
	 * @author Pawan Kumar
	 * @description Constructor to initialize Flight Search Round Trip page
	 * @param driver
	 * @param mobileActionUtil
	 */
	public FlightSearchPageRoundTrip(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	/** Round Trip Page ELEMENTS DECLARATION **/
	long seconds = 10;
	@FindBy(xpath = "//android.view.View[@resource-id='departSortL']")
	private WebElement fromDepartureTimeSortBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='priceSortL']")
	private WebElement fromDeparturePriceSortBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='departSortR']")
	private WebElement toArrivalTimeSortBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='priceSortR']")
	private WebElement toArrivalPriceSortBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='headerHeading']/android.view.View")
	private WebElement headerEditBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='filterClick']")
	private WebElement filterBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='topPrice']")
	private WebElement totalRoundTripFareTxt;

	@FindBy(xpath = "//android.view.View[@resource-id='bookFlt']")
	private WebElement bookFlightBtn;

	/**
	 * @author Pawan Kumar
	 * @description Click On From Departure Time Sort Btn
	 */
	public void clickOnFromDepartureTimeSortBtn() {

		mobileActionUtil.clickOnMobileElement(fromDepartureTimeSortBtn, "'From Departure Time Sort' Button");
	}

	/**
	 * @author Pawan Kumar
	 * @description Click On From Departure Price Sort Btn
	 */
	public void clickOnFromDeparturePriceSortBtn() {

		mobileActionUtil.clickOnMobileElement(fromDeparturePriceSortBtn, "'From Price Sort' Button");
	}

	/**
	 * @author Pawan Kumar
	 * @description Click On To Arrival Time Sort Btn
	 */
	public void clickOnToArrivalTimeSortBtn() {

		mobileActionUtil.clickOnMobileElement(toArrivalTimeSortBtn, "'To Arrival Time Sort' Button");
	}

	/**
	 * @author Pawan Kumar
	 * @description Click On To Arrival Price Sort Btn
	 */
	public void clickOnToArrivalPriceSortBtn() {

		mobileActionUtil.clickOnMobileElement(toArrivalPriceSortBtn, "'To Arrival Price Sort' Button");
	}

	/**
	 * @author Pawan Kumar
	 * @description Click On Edit Header Heading Btn
	 */
	public void clickOnEditHeaderHeadingBtn() {

		mobileActionUtil.clickOnMobileElement(headerEditBtn, "'Header Edit' Button");
	}

	/**
	 * @author Pawan Kumar
	 * @description Click On Filter Btn
	 */
	public void clickOnFilterBtn() {

		mobileActionUtil.clickOnMobileElement(filterBtn, "'Filter' Button");
	}

	/**
	 * @author Pawan Kumar
	 * @description Fetch Total Round Trip Fare
	 */
	public String getTotalRoundTripFare() {

		String totlRoundTripFare = mobileActionUtil.getText(totalRoundTripFareTxt);
		return totlRoundTripFare;
	}

	/**
	 * @author Pawan Kumar
	 * @description Click On Book Btn
	 */
	public void clickOnBookBtn() {

		mobileActionUtil.clickOnMobileElement(bookFlightBtn, "'Book Flight' Button");
	}

}
