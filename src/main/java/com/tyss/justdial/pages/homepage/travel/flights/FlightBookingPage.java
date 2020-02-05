package com.tyss.justdial.pages.homepage.travel.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class FlightBookingPage extends BasePage {

	/**
	 * @author Savitha
	 * @description Constructor to initialize FlightsPage mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public FlightBookingPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Savitha Kiran
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

	/** FLIGHT BOOKING SCREEN MOBILE ELEMENTS DECLARATION **/

	long seconds = 10;
	@FindBy(xpath = "(//android.view.View)[8]")
	private WebElement travelInfo;

	@FindBy(xpath = "(//android.view.View)[14]")
	private WebElement fromCity;

	@FindBy(xpath = "(//android.view.View)[16]")
	private WebElement departureTime;

	@FindBy(xpath = "(//android.view.View)[22]")
	private WebElement toCity;

	@FindBy(xpath = "(//android.view.View)[24]")
	private WebElement arrivalTime;

	@FindBy(xpath = "(//android.view.View)[13]")
	private WebElement selectedAirline;

	@FindBy(xpath = "//android.view.View[contains(@text,'Refundable')]")
	private WebElement flghtType;

	@FindBy(id = "toggleInsurance")
	private WebElement insuranceRadiobtn;

	@FindBy(xpath = "//android.view.View[@text='T&C']")
	private WebElement termsAndConditions;

	@FindBy(xpath = "//android.view.View[contains(@text,'more')]")
	private WebElement policyBenifits;

	@FindBy(xpath = "//android.view.View[contains(@text,'Promocode')]")
	private WebElement promoCode;

	@FindBy(id = "promocode")
	private WebElement enterPromocde;

	@FindBy(id = "applyPromo")
	private WebElement applyPromo;

	@FindBy(id = "sumPrice")
	private WebElement totalFare;

	@FindBy(id = "bookFlt")
	private WebElement bookFlight;

	@FindBy(id = "mainHeaderHeading")
	private WebElement backBtn;

	/**
	 * @author Savitha
	 * @description Method to Fetch Travel Information
	 * 
	 **/
	public String getTravlinfo() {
		return mobileActionUtil.getText(travelInfo);
	}

	/**
	 * @author Savitha
	 * @description Method to Fetch From City
	 * 
	 **/
	public String getFromcity() {
		return mobileActionUtil.getText(fromCity);
	}

	/**
	 * @author Savitha
	 * @description Method to Fetch DepartureTime
	 * 
	 **/
	public String getDepartureTime() {
		return mobileActionUtil.getText(departureTime);
	}

	/**
	 * @author Savitha
	 * @description Method to Fetch To City
	 * 
	 **/
	public String getToCity() {
		return mobileActionUtil.getText(toCity);
	}

	/**
	 * @author Savitha
	 * @description Method to Fetch Arrival Time
	 * 
	 **/
	public String getArrivalTime() {
		return mobileActionUtil.getText(arrivalTime);
	}

	/**
	 * @author Savitha
	 * @description Method to Fetch Selected Airline
	 * 
	 **/
	public String getSelectedAirline() {
		return mobileActionUtil.getText(selectedAirline);
	}

	/**
	 * @author Savitha
	 * @description Method to Fetch Flight Type
	 * 
	 **/
	public String getFlightType() {
		return mobileActionUtil.getText(flghtType);
	}

	/**
	 * @author Savitha
	 * @description Method to Click on Insurance Button
	 * 
	 **/
	public void clickonInsuranceradiobtn() {
		mobileActionUtil.clickCheckBox(insuranceRadiobtn, "Insurance Radio Button");
	}

	/**
	 * @author Savitha
	 * @description Method to Click on Terms And Conditions
	 * 
	 **/
	public void clickonTermsAndConditions() {
		mobileActionUtil.tapOnElement(termsAndConditions);
	}

	/**
	 * @author Savitha
	 * @description Method to Fetch Policy Benefits
	 * 
	 **/
	public String getPolicybenifits() {
		return mobileActionUtil.getText(policyBenifits);

	}

	/**
	 * @author Savitha
	 * @description Method to Scroll to FlightType
	 * 
	 **/
	public void scrollTogetFlightType() {
		mobileActionUtil.scrollTillElement(getFlightType());
	}

	/**
	 * @author Savitha
	 * @description Method to Fetch Promocode
	 * 
	 **/
	public String getPromocode() {
		return mobileActionUtil.getText(promoCode);
	}

	/**
	 * @author Savitha
	 * @description Method to Click on Promocode
	 * 
	 **/
	public void click_Promocode() {
		mobileActionUtil.clickOnMobileElement(enterPromocde, "PromoCode");
	}

	/**
	 * @author Savitha
	 * @description Method to Click on Apply Promo
	 * 
	 **/
	public void clickApplyPromo() {
		mobileActionUtil.clickOnMobileElement(applyPromo, "ApplyPromo");
	}

	/**
	 * @author Savitha
	 * @description Method to Fetch Total Fare
	 * 
	 **/
	public String getTotalfare() {
		return mobileActionUtil.getText(totalFare);
	}

	/**
	 * @author Savitha
	 * @description Method to Click on continue
	 * 
	 **/
	public void clickTobookflight() {
		mobileActionUtil.clickOnMobileElement(bookFlight, "Continue to book Flight");
	}

	/**
	 * @author Savitha
	 * @description Method to Click on Back Button
	 * 
	 **/
	public void clickonBackBtn() {
		mobileActionUtil.clickOnMobileElement(backBtn, "Back Button");
	}
}
