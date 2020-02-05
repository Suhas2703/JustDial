package com.tyss.justdial.pages.homepage.travel.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class FlightStatusPage extends BasePage {

	public FlightStatusPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}



	@FindBy(xpath = "//android.view.View[@text='By Flight']")
	private WebElement byFlightRadioBtn;

	@FindBy(xpath = "//android.view.View[@text='By Route/Airport']")
	private WebElement byRouteAirportRadioBtn;

	@FindBy(xpath = "(//android.widget.EditText)[1]")
	private WebElement flightNoTxtbx;

	@FindBy(xpath = "(//android.widget.EditText)[2]")
	private WebElement byFlightDateLnk;

	@FindBy(xpath = "//android.widget.Button[@text='Get Status']")
	private WebElement getStatusBtn;

	@FindBy(xpath = "//android.widget.Button[@text='Live Tracking']")
	private WebElement liveTrackingBtn;

	@FindBy(xpath = "(//android.widget.EditText)[1]")
	private WebElement departureAirportBtn;

	@FindBy(xpath = "(//android.widget.EditText)[2]")
	private WebElement arrivalAirportBtn;

	@FindBy(xpath = "(//android.widget.EditText)[3]")
	private WebElement airlineOptionalBtn;

	@FindBy(xpath = "(//android.widget.EditText)[4]")
	private WebElement byRouteAirportDateLnk;

	public void clickOnByFlightRadioButton() {
		mobileActionUtil.clickOnMobileElement(byFlightRadioBtn, "By Flight Radio Button");
	}

	public void clickOnByRouteAirportRadioButton() {
		mobileActionUtil.clickOnMobileElement(byRouteAirportRadioBtn, "By Route Airport Radio Button");
	}

	public void clickOnFlightNo() {
		mobileActionUtil.clickOnMobileElement(flightNoTxtbx, "Flight No");
	}

	public void enterFlightNo(String enterText) {
		mobileActionUtil.setText(flightNoTxtbx, enterText, "Flight No");
	}

	public void clickOnByFlightDateLink() {
		mobileActionUtil.clickOnMobileElement(byFlightDateLnk, "Date Link");
	}

	public void clickOnGetStatus() {
		mobileActionUtil.clickOnMobileElement(getStatusBtn, "Get Status");
	}

	public void clickOnLiveTracking() {
		mobileActionUtil.clickOnMobileElement(liveTrackingBtn, "Live Tracking");
	}

	public void clickOnDepartureAirportBtn() {
		mobileActionUtil.clickOnMobileElement(departureAirportBtn, "Departure Airport  Button");
	}

	public void clickOnArrivalAirportBtn() {
		mobileActionUtil.clickOnMobileElement(arrivalAirportBtn, "Arrival Airport Button");
	}

	public void clickOnAirlineOptional() {
		mobileActionUtil.clickOnMobileElement(airlineOptionalBtn, "Airline Optional Button");
	}

	public void clickOnByRouteAirportDateLink() {
		mobileActionUtil.clickOnMobileElement(byRouteAirportDateLnk, "By Route Airport Date Link");
	}
}