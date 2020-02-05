
package com.tyss.justdial.pages.homepage.travel.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class SearchFlightsPage extends BasePage {

	/**
	 * @author Shobhan
	 * @description Constructor to initialize FlightsPage mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public SearchFlightsPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
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

	/** SEARCH FLIGHTS SCREEN MOBILE ELEMENTS DECLARATION **/

	long seconds = 10;
	@FindBy(id = "com.justdial.search:id/flights_oneway")
	private WebElement oneWayTab;

	@FindBy(id = "com.justdial.search:id/flights_roundtrip")
	private WebElement roundTripTab;

	@FindBy(id = "com.justdial.search:id/flights_status")
	private WebElement flightStatusTab;

	@FindBy(id = "com.justdial.search:id/from_city")
	private WebElement fromTxtBx;

	@FindBy(id = "com.justdial.search:id/to_city")
	private WebElement toTxtBx;

	@FindBy(id = "com.justdial.search:id/round_trip")
	private WebElement roundTripIcon;

	@FindBy(id = "com.justdial.search:id/depature_date")
	private WebElement depatureTxtBx;

	@FindBy(id = "com.justdial.search:id/travler_count")
	private WebElement travellersTxtBx;

	@FindBy(id = "com.justdial.search:id/travler_class")
	private WebElement classLnk;

	@FindBy(id = "com.justdial.search:id/checkbox_nonstop_flights")
	private WebElement nonStopFlightsRadioBtn;

	@FindBy(id = "com.justdial.search:id/search_flights")
	private WebElement searchBtn;

	@FindBy(id = "com.justdial.search:id/adults")
	private WebElement adultsTxt;

	@FindBy(id = "com.justdial.search:id/children")
	private WebElement childrenTxt;

	@FindBy(id = "com.justdial.search:id/infant")
	private WebElement infantsTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Adults']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_minus']")
	private WebElement adultsMinusBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Adults']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_plus']")
	private WebElement adultsPlusBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Children']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_minus']")
	private WebElement childrenMinusBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Children']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_plus']")
	private WebElement childrenPlusBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Infants']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_minus']")
	private WebElement infantsMinusBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Infants']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_plus']")
	private WebElement infantsPlusBtn;

	@FindBy(id = "com.justdial.search:id/seat_no_done")
	private WebElement doneBtn;

	@FindBy(className = "android.widget.MultiAutoCompleteTextView")
	private WebElement airportSearchBx;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.justdial.search:id/cities_Lay']")
	private WebElement selectFirstCityOtn;

	private WebElement selectDate(String value) {
		return mobileActionUtil.getWebElement("xpath",
				"(//android.widget.TextView[@text='Departure']/../../..//android.widget.TextView[@text=" + value
						+ "])[1]");
	}

	@FindBy(id = "com.justdial.search:id/loaderDate")
	private WebElement loaderDateTxt;

	@FindBy(id = "com.justdial.search:id/searchingfor")
	private WebElement searchingForFlightsTxt;


	/**
	 * @author Shobhan
	 * @description Method to click on From Text Box
	 */
	public void clickOnFrom() {
		mobileActionUtil.clickOnMobileElement(fromTxtBx, "From");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Round Trip Icon
	 */
	public void clickOnRoundTripIcon() {
		mobileActionUtil.clickOnMobileElement(roundTripIcon, "Round Trip Icon");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on To Text Box
	 */
	public void clickOnTo() {
		mobileActionUtil.clickOnMobileElement(toTxtBx, "To");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Departure Text Box
	 */
	public void clickOnDepature() {
		mobileActionUtil.clickOnMobileElement(depatureTxtBx, "Depature Text Box");
	}

	/**
	 * @author Shobhan
	 * @descriptiion Method to click on Travellers Text Box
	 */
	public void clickOnTravellers() {
		mobileActionUtil.clickOnMobileElement(travellersTxtBx, "Travellers Text Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Class link
	 */
	public void clickOnClass() {
		mobileActionUtil.clickOnMobileElement(classLnk, "class Text Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Non Stop Fights Radio Button
	 */
	public void clickOnNonStopFlightsOnly() {
		mobileActionUtil.clickOnMobileElement(nonStopFlightsRadioBtn, "Non Stop Flights Radio Button");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Search Button
	 */
	public void clickOnSearch() {
		mobileActionUtil.clickOnMobileElement(searchBtn, "Search Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Airport Serach Box
	 */
	public void clickOnAirportSearch() {
		mobileActionUtil.clickOnMobileElement(airportSearchBx, "Airport Search Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to send value to Airport Search Box
	 * @param enterText
	 */
	public void enterCityNameInSearch(String enterText) {
		mobileActionUtil.setText(airportSearchBx, enterText, "Search Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to select city
	 */
	public void selectFirstCity() {
		mobileActionUtil.clickOnMobileElement(selectFirstCityOtn, "Select City");
	}

	/**
	 * @author Shobhan
	 * @description Method to select date
	 */
	public void enterDate(String date) {
		mobileActionUtil.clickOnMobileElement(selectDate(date), "Select Date");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Adults Plus Button
	 */
	public void increseAdultNumber() {
		mobileActionUtil.clickOnMobileElement(adultsPlusBtn, "Adults Plus");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Adults Minus Button
	 */
	public void decreseAdultNumber() {
		mobileActionUtil.clickOnMobileElement(adultsMinusBtn, "Adults Minus ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Childern Plus Button
	 */
	public void increseChildrenNumber() {
		mobileActionUtil.clickOnMobileElement(childrenPlusBtn, "Children Plus ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Childern Minus Button
	 */
	public void decreseChildrenNumber() {
		mobileActionUtil.clickOnMobileElement(childrenMinusBtn, " Children Minus");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Infants Plus Button
	 */
	public void increseInfantsNumber() {
		mobileActionUtil.clickOnMobileElement(infantsPlusBtn, "Infants Plus ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Infants Minus Button
	 */
	public void decreseInfantsNumber() {
		mobileActionUtil.clickOnMobileElement(infantsMinusBtn, "Infants Minus ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Done Button
	 */
	public void clickOnDone() {
		mobileActionUtil.clickOnMobileElement(doneBtn, "Infants Minus ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Search Button
	 */
	public void clickOnSearch(String date) {
		mobileActionUtil.clickOnMobileElement(searchBtn, "search");
	}

	/**
	 * @author Shobhan
	 * @description Method to verify searched flights 
	 */
	public String getTextSearchingForflights() {
		return mobileActionUtil.getText(searchingForFlightsTxt);
	}

	/**
	 * @author Shobhan
	 * @description Method to verify From City Text
	 */
	public String getFromCityNameOnPrompt() {
		mobileActionUtil.waitForElement(fromTxtBx, seconds, "fromTxtBx");
		return mobileActionUtil.getText(fromTxtBx);
	}

	/**
	 * @author Shobhan
	 * @description Method to verify To City Text
	 */
	public String getToCityNameOnPrompt() {
		mobileActionUtil.waitForElement(toTxtBx, seconds, "fromTxtBx");
		return mobileActionUtil.getText(toTxtBx);
	}

	/**
	 * @author Shobhan
	 * @description Method to verify date
	 */
	public String getDateOnPrompt() {
		return mobileActionUtil.getText(loaderDateTxt);
	}

	/**
	 * @author Shobhan
	 * @description Method to verify City Details
	 */
	public void verifyFirstprompt( String expectedText1, String expectedText2,
			String expectedText3) {
		System.out.println();
		String fromCity = getFromCityNameOnPrompt();
		String toCity = getToCityNameOnPrompt();
		String date = getDateOnPrompt();
		System.out.println(fromCity);
		System.out.println(toCity);
		System.out.println(date);
		mobileActionUtil.verifyText(fromCity, expectedText1);
		mobileActionUtil.verifyText(toCity, expectedText2);
		mobileActionUtil.verifyText(date, expectedText3);

	}


}