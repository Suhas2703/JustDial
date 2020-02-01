package com.tyss.justdial.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.extentreports.ExtentTestManager;
import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class SearchPage extends BasePage {
	/**
	 * @author Shobhan
	 * @description Constructor to initialize Login mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public SearchPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
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

	/** Search Screen MOBILE ELEMENTS DECLARATION **/
	long timeinSeconds = 5;
	@FindBy(xpath = "//android.widget.TextView[@text='Search']")
	private WebElement searchTab;

	@FindBy(xpath = "//android.widget.TextView[@text='Taj Mahal']")
	private WebElement tajMahalTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Jw Marriott Hotel']")
	private WebElement jwMarriottHotelTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Taj Holiday Village Resort & Spa']")
	private WebElement tajHotelGoa;

	@FindBy(xpath = "//android.widget.TextView[@text='Vidyarthi Bhavan Restaurant']")
	private WebElement vidyarthiBhavan;

	@FindBy(id = "com.justdial.search:id/comp_name")
	private WebElement dominos;

	@FindBy(id = "com.justdial.search:id/quick_text_leftColumnChild")
	private WebElement touristAttractionTxt;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,\"080-67189999\")]")
	private WebElement jwMarriotHotelPhoneNoTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Dr. Rudrappa Hospital']")
	private WebElement rudrappaHospitalTxt;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,\"+(91)-9152385750\")]")
	private WebElement rudrappaHospitalPhoneNoTxt;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Cafe Coffee Day')]  ") // android.widget.TextView[contains(@text,"080-67189999")]
	private WebElement ccdNagwaraTxt;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'08431958')]  ") // android.widget.TextView[contains(@text,"080-67189999")]
	private WebElement ccdNagwaraPhoneNoTxt;

	@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.justdial.search:id/filtername'])[2]")
	private WebElement dateTab;

	private WebElement getPagelabelElement(String value) {
		return mobileActionUtil.getWebElement("xpath", "//android.widget.TextView[@text=" + value + "]");
	}

	private WebElement getPhoneNumberElement(String value) {
		String e = "\"" + value + "\"";
		return mobileActionUtil.getWebElement("xpath", "//android.widget.TextView[contains(@text," + e + ")]");
	}

	/**
	 * @author Shobhan
	 * @description Scroll Till Tourist Attraction
	 */

	public void scrollTillTouristAttraction() {

		mobileActionUtil.waitForElementToLoad(2);
		mobileActionUtil.waitForElement(tajMahalTxt, 2, "'Taj Mahal' Text");
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.checkElementScroll(touristAttractionTxt);
	}

	/**
	 * @author Shobhan
	 * @description Click On Tourist Attraction
	 */
	public void clickOnTouristAttractionText() {

		mobileActionUtil.clickOnMobileElement(touristAttractionTxt, "'Tourist Attraction' Button");
	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void verifyTouristAttraction(String expected) {

		mobileActionUtil.verifyElementText(touristAttractionTxt, 5, expected);
		mobileActionUtil.getScreenshotAndAddToReport();

	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void verifyTajMahalText(String enterText) {

		mobileActionUtil.waitForElement(tajMahalTxt, timeinSeconds, enterText);
		mobileActionUtil.verifyElementText(tajMahalTxt, timeinSeconds, enterText);
	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void scrollTillJWMarriotHotelPhoneNumber() {

		mobileActionUtil.waitForElementToLoad(2);
		mobileActionUtil.waitForElement(jwMarriottHotelTxt, 2, "'J W Marriott Hotel Label'");
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.checkElementScroll(jwMarriotHotelPhoneNoTxt);
		mobileActionUtil.waitForElementToLoad(1);

	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void verifyJWMarriotHotelPhoneNumber(String expected) {

		mobileActionUtil.verifyElementText(jwMarriotHotelPhoneNoTxt, 5, expected);
		mobileActionUtil.getScreenshotAndAddToReport();
	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void scrollTillRudrappaHospitalPhoneNumber() {

		mobileActionUtil.waitForElementToLoad(2);
		mobileActionUtil.waitForElement(rudrappaHospitalTxt, 6, "'Rudrappa Hospital Label'");
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.checkElementScroll(rudrappaHospitalPhoneNoTxt);
		mobileActionUtil.waitForElementToLoad(1);
	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void verifyRudrappaHospitalPhoneNumber(String expected) {

		mobileActionUtil.verifyElementText(rudrappaHospitalPhoneNoTxt, 5, expected);
		mobileActionUtil.getScreenshotAndAddToReport();
	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void scrollTillCCDPhoneNumber() {

		mobileActionUtil.waitForElementToLoad(2);
		mobileActionUtil.waitForElement(ccdNagwaraTxt, 6, "'CCD NagaWara Label'");
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.checkElementScroll(ccdNagwaraPhoneNoTxt);
		mobileActionUtil.waitForElementToLoad(1);

	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void verifyCCDPhoneNumber(String expText3) {

		String numText = ccdNagwaraPhoneNoTxt.getText().split(",")[1].trim().toString();
		System.out.println(numText);
		mobileActionUtil.verifyText(numText, expText3);
		mobileActionUtil.getScreenshotAndAddToReport();
	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void verifyPhoneNumber(String enterText) {
		mobileActionUtil.verifyElementText(getPhoneNumberElement(enterText), timeinSeconds, enterText);
	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void verifySearchResultPage(String enterText) {

		mobileActionUtil.waitForElement(searchTab, timeinSeconds, "Search Navigation Bar");
		mobileActionUtil.verifyElementText(searchTab, timeinSeconds, enterText);
		mobileActionUtil.getScreenshotAndAddToReport();
	}

	/**
	 * @author Shobhan
	 * @description Verify Tourist Attraction
	 */
	public void verifyDateTab() {

		mobileActionUtil.info(dateTab.getText());
		mobileActionUtil.verifyElementIsDisplayed(dateTab, timeinSeconds, "Date Tab");
	}	
}