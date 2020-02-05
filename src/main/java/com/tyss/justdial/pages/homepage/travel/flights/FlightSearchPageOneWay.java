package com.tyss.justdial.pages.homepage.travel.flights;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class FlightSearchPageOneWay extends BasePage {

	/**
	 * @author Anil Kumar
	 * @description Constructor to initialize FlightSearchPageOneWay elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public FlightSearchPageOneWay(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	/** FLIGHTS SCREEN ONE WAY TRIP MOBILE ELEMENTS DECLARATION **/

	@FindBy(xpath = "//android.view.View[@text = 'Duration']")
	private WebElement durationOneWayTripBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='priceSort']")
	private WebElement priceOneWayTripBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='departSort']")
	private WebElement timeOneWayTripBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='departSort']")
	private WebElement filterIconOneWayTrip;

	@FindBy(xpath = "//android.view.View[@resource-id='headerHeading']/android.view.View")
	private WebElement headerEditOneWayTripBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='mainHeaderHeading']")
	private WebElement headerBackOneWayTripBtn;

	@FindBy(xpath = "//android.view.View[@resource-id='resultO']//android.widget.ListView/android.view.View")
	private List<WebElement> dateOneWayTripBtn;

	/**
	 * @author Anil Kumar
	 * @description Clicking on Duration Button One Way Trip
	 */
	public void clickOnDurationOneWayTrip() {
		mobileActionUtil.clickOnMobileElement(durationOneWayTripBtn, "Duration Button");
	}
	
	/**
	 * @author Anil Kumar
	 * @description Clicking on Price Button One Way Trip
	 */
	public void clickOnPriceOneWayTrip() {
		mobileActionUtil.clickOnMobileElement(priceOneWayTripBtn, "Price Button");
	}
	
	/**
	 * @author Anil Kumar
	 * @description Clicking on Time Button One Way Trip
	 */
	public void clickOnTimeOneWayTrip() {
		mobileActionUtil.clickOnMobileElement(timeOneWayTripBtn, "Time Button");
	}
	
	/**
	 * @author Anil Kumar
	 * @description Clicking on Filter Icon Button One Way Trip
	 */

	public void clickOnFilterIconOneWayTrip() {
		mobileActionUtil.clickOnMobileElement(filterIconOneWayTrip, "Filter Icon");
	}
	
	
	/**
	 * @author Anil Kumar
	 * @description Clicking on Header Edit Button One Way Trip
	 */
	public void clickOnHeaderEditBtnOneWayTrip() {
		mobileActionUtil.clickOnMobileElement(headerEditOneWayTripBtn, "Header Edit Button");
	}

	/**
	 * @author Anil Kumar
	 * @description Clicking on Header Back Button One Way Trip
	 */
	public void clickOnHeaderBackBtnOneWayTrip() {
		mobileActionUtil.clickOnMobileElement(headerBackOneWayTripBtn, "Header Back Button");
	}

	/**
	 * @author Anil Kumar
	 * @description Returning List of WebElements for Travel Date Button
	 */
	public List<WebElement> travelDates() {
		return dateOneWayTripBtn;
	}

	public void getTravelDates() {
		int dateSize = travelDates().size();
		System.out.println(dateSize);

	}

}