package com.tyss.justdial.pages.homepage.travel.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class FlightStatusPage extends BasePage {

	/**
	 * @author Shobhan
	 * @description Constructor to initialize Flight Status Page mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public FlightStatusPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	/** FLIGHT STATUS PAGE MOBILE ELEMENTS DECLARATION **/

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
	private WebElement departureAirportTxtBx;

	@FindBy(xpath = "(//android.widget.EditText)[2]")
	private WebElement arrivalAirportTxtBx;

	@FindBy(xpath = "(//android.widget.EditText)[3]")
	private WebElement airlineOptionalTxtBx;

	@FindBy(xpath = "(//android.widget.EditText)[4]")
	private WebElement byRouteAirportDateLnk;

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement searchForDesiredCityOrAirportSearchTxtBx;

	@FindBy(xpath = "(//android.view.View)[5]")
	private WebElement selectAirportAndCityFirstOtn;
	//

	@FindBy(id = "cityhdr")
	private WebElement placeToPlace;

	@FindBy(xpath = "//android.view.View[@text='ARRIVED']")
	private WebElement arrivedTxt;

	@FindBy(xpath = "//android.view.View[@text='Departed']")
	private WebElement departedTxt;

	@FindBy(xpath = "(//android.view.View[@text='Terminal'])[1]")
	private WebElement terminalTxt;

	@FindBy(xpath = "(//android.view.View[@text='Gate'])[1]")
	private WebElement gateTxt;
	@FindBy(xpath = "(//android.view.View[@text='Terminal'])[2]")
	private WebElement terminalTxt1;

	@FindBy(xpath = "(//android.view.View[@text='Gate'])[2]")
	private WebElement gateTxt1;

	@FindBy(xpath = "//android.view.View[@text='Scheduled Departure']")
	private WebElement scheduledDepartureTxt;

	@FindBy(xpath = "//android.view.View[@text='Scheduled Arrival']")
	private WebElement scheduledArrivalTxt;

	/**
	 * @author Shobhan
	 * @description Method to click On By Flight Radio Button
	 */
	public void clickOnByFlightRadioButton() {
		mobileActionUtil.clickOnMobileElement(byFlightRadioBtn, "By Flight Radio Button");
	}

	/**
	 * @author Shobhan
	 * @description Method to click On By Route Airport Radio Button
	 */
	public void clickOnByRouteAirportRadioButton() {
		mobileActionUtil.clickOnMobileElement(byRouteAirportRadioBtn, "By Route Airport Radio Button");
	}

	/**
	 * @author Shobhan
	 * @description Method to click On Flight No
	 */
	public void clickOnFlightNo() {
		mobileActionUtil.clickOnMobileElement(flightNoTxtbx, "Flight No");
	}

	/**
	 * @author Shobhan
	 * @description Method to enter Flight No
	 * @param enterText
	 */
	public void enterFlightNo(String enterText) {
		mobileActionUtil.setText(flightNoTxtbx, enterText, "Flight No");
	}

	/**
	 * @author Shobhan
	 * @description Method to click On By Flight Date Link
	 */
	public void clickOnByFlightDateLink() {
		mobileActionUtil.clickOnMobileElement(byFlightDateLnk, "Date Link");
	}

	/**
	 * @author Shobhan
	 * @description Method to click On Get Status
	 */
	public void clickOnGetStatus() {
		mobileActionUtil.clickOnMobileElement(getStatusBtn, "Get Status");
	}

	/**
	 * @author Shobhan
	 * @description Method to click On Live Tracking
	 */
	public void clickOnLiveTracking() {
		mobileActionUtil.clickOnMobileElement(liveTrackingBtn, "Live Tracking");
	}

	/**
	 * @author Shobhan
	 * @description Method to click On Departure Airport
	 */
	public void clickOnDepartureAirport() {
		mobileActionUtil.clickOnMobileElement(departureAirportTxtBx, "Departure Airport ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click On Arrival Airport
	 */
	public void clickOnArrivalAirport() {
		mobileActionUtil.clickOnMobileElement(arrivalAirportTxtBx, "Arrival Airport ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click On Airline Optional
	 */
	public void clickOnAirlineOptional() {
		mobileActionUtil.clickOnMobileElement(airlineOptionalTxtBx, "Airline Optional Button");
	}

	/**
	 * @author Shobhan
	 * @description Method to click On By Route Airport Date Link
	 */
	public void clickOnByRouteAirportDateLink() {
		mobileActionUtil.clickOnMobileElement(byRouteAirportDateLnk, "By Route Airport Date Link");
	}

	/**
	 * @author Shobhan
	 * @description Method to click On search For Desired City Or Airport Search
	 *              Text Box
	 */
	public void clickOnsearchForDesiredCityOrAirportSearch() {
		mobileActionUtil.clickOnMobileElement(searchForDesiredCityOrAirportSearchTxtBx,
				"search For Desired City Or Airport Search Text Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to enter and search For Desired City Or Airport Search
	 *              Text Box
	 */
	public void enterSearchForDesiredCityOrAirportSearch(String input) {
		mobileActionUtil.setText(searchForDesiredCityOrAirportSearchTxtBx, input,
				"search For Desired City Or Airport Search Text Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to select Airport And City First Option
	 */
	public void selectAirportAndCityFirstOption() {
		mobileActionUtil.clickOnMobileElement(selectAirportAndCityFirstOtn,
				"search For Desired City Or Airport Search Text Box");
	}

	/**
	 * @author Preety
	 * @description: Method to verify the place to place text
	 */
	public void getPlaceToPlace() {
		String textPresentInPage = placeToPlace.getText();
		System.out.println(textPresentInPage);

	}

	/**
	 * @author Preety
	 * @description: Method to verify the arrival text
	 */
	public void getFlightStatus() {
		String textPresentInPage = arrivedTxt.getText();
		System.out.println(textPresentInPage);

	}

	/**
	 * @author Preety
	 * @description: Method to verify the departed time text
	 */
	public void getDepartedTime() {
		String textPresentInPage = departedTxt.getText();
		System.out.println(textPresentInPage);
	}

	/**
	 * @author Preety
	 * @description: Method to verify the departed terminal text
	 */
	public void getDepartedTerminalText() {
		String textPresentInPage = terminalTxt.getText();
		System.out.println(textPresentInPage);
	}

	/**
	 * @author Preety
	 * @description: Method to verify the Departed gate text
	 */
	public void getDepartedGateText() {
		String textPresentInPage = gateTxt.getText();
		System.out.println(textPresentInPage);
	}

	/**
	 * @author Preety
	 * @description: Method to verify the Scheduled departure text
	 */

	public void getScheduledDepartureText() {
		String textPresentInPage = scheduledDepartureTxt.getText();
		System.out.println(textPresentInPage);

	}

	/**
	 * @author Preety
	 * @description: Method to verify the arrival text
	 */

	public void getArrivalTime() {
		String textPresentInPage = arrivedTxt.getText();
		System.out.println(textPresentInPage);
	}

	/**
	 * @author Preety
	 * @description: Method to verify the arrival text
	 */
	public void getArrivalTerminalText() {
		String textPresentInPage = terminalTxt1.getText();
		System.out.println(textPresentInPage);
	}

	/**
	 * @author Preety
	 * @description: Method to verify the arrival gate text
	 */
	public void getArrivalGateText() {
		String textPresentInPage = gateTxt1.getText();
		System.out.println(textPresentInPage);
	}

	/**
	 * @author Preety
	 * @description: Method to verify the Scheduled arrival text
	 */
	public void getScheduledArrivalText() {
		String textPresentInPage = scheduledArrivalTxt.getText();
		System.out.println(textPresentInPage);

	}

}