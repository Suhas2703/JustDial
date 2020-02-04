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

	@FindBy(className = "android.widget.MultiAutoCompleteTextView")
	private WebElement airportSearchBx;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.justdial.search:id/cities_Lay']")
	private WebElement selectFirstCityOtn;
	
	private WebElement selectDate(String value) {
		return mobileActionUtil.getWebElement("xpath", "(//android.widget.TextView[@text='Departure']/../../..//android.widget.TextView[@text="+value+"])[1]");
	}

	public void clickOnFrom() {
	mobileActionUtil.clickOnMobileElement(fromTxtBx, "From");
	}

	public void clickOnTo() {
		mobileActionUtil.clickOnMobileElement(toTxtBx, "To");		
	}

	public void clickOnDepature() {
		mobileActionUtil.clickOnMobileElement(depatureTxtBx, "Depature Text Box");
	}

	public void clickOnTravellers() {
		mobileActionUtil.clickOnMobileElement(travellersTxtBx, "Travellers Text Box");			
	}
	

	public void clickOnClass() {
		mobileActionUtil.clickOnMobileElement(classLnk, "class Text Box");
	}

	public void clickOnNonStopFlightsOnly() {
		mobileActionUtil.clickOnMobileElement(nonStopFlightsRadioBtn, "Non Stop Flights Radio Button");
	}

	public void clickOnSearch() {
		mobileActionUtil.clickOnMobileElement(searchBtn, "Search Box");
	}	

	public void clickOnAirportSearch() {
		mobileActionUtil.clickOnMobileElement(airportSearchBx, "Airport Search Box");
		}

	public void enterCityNameInSearch(String enterText) {
		mobileActionUtil.setText(airportSearchBx, enterText, "Search Box");
		}
	
	public void selectCity() {
		mobileActionUtil.clickOnMobileElement(selectFirstCityOtn, "Select City");
	}
}
