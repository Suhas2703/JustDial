package com.tyss.justdial.pages.homepage.travel.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class PassengerSelectionAndDetailsPage extends BasePage {

	public PassengerSelectionAndDetailsPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	/**
	 * @author Shreya Ugavekar
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

	/** PASSENGER SELECTION AND DETAILS SCREEN MOBILE ELEMENTS DECLARATION **/
	long seconds = 10;
	@FindBy(id = "namespan")
	private WebElement loggedInUserNameTxt;

	@FindBy(id = "log_edit")
	private WebElement loggedInUserEditIcn;

	@FindBy(id = "insrtLoginPrf")
	private WebElement loggedInUserChkBx;

	@FindBy(xpath = "//android.view.View[@text='Add new Passenger']")
	private WebElement addNewPassengerLnk;

	@FindBy(id = "sumPrice")
	private WebElement fareTxt;

	@FindBy(xpath = "//androd.view.Vew[@text='Total Fare']/preceding-sibling::android.view.View")
	private WebElement iIcn;

	@FindBy(id = "bookFlt")
	private WebElement saveAndContinueBtn;

	/* EDIT PASSENGER ELEMENTS */
	@FindBy(id = "headerHeading")
	private WebElement editPassengerTitle;

	@FindBy(id = "edtLnFname")
	private WebElement firstNameTxtBx;

	@FindBy(id = "edtLnLname")
	private WebElement lastNameTxtBx;

	@FindBy(id = "edtLnDob")
	private WebElement dobTxtBx;

	@FindBy(xpath = "//android.view.View[@text='First name']")
	private WebElement firstNameTxt;

	@FindBy(xpath = "//android.view.View[@text='Last name']")
	private WebElement lastNameTxt;

	@FindBy(xpath = "//android.view.View[@text='DOB']")
	private WebElement dobTxt;

	@FindBy(xpath = "//android.view.View[@text='Save & Continue']")
	private WebElement editPassengerSaveAndContinueBtn;

	@FindBy(id = "mainHeaderHeading")
	private WebElement backBtn;

	/* ADD NEW PASSENGER ELEMENTS */

	@FindBy(id = "headerHeading")
	private WebElement addPassengerTitle;

	@FindBy(id = "IbradA")
	private WebElement adultChkBx;

	@FindBy(id = "IbradC")
	private WebElement childChkBx;

	@FindBy(id = "IbradI")
	private WebElement infantChkBx;

	@FindBy(id = "Fname")
	private WebElement addPassengerfirstNameTxtBx;

	@FindBy(id = "Lname")
	private WebElement addPassengerlastNameTxtBx;

	@FindBy(id = "addDob")
	private WebElement addPassengerdobTxtBx;

	/**
	 * @author Shreya
	 * @description Method to verify loggedInUserName is displayed and verify the
	 *              UserName
	 * @param loggedInUserNameText
	 */

	public void verifyLoggedInUserName(String loggedInUserNameText) {

		mobileActionUtil.verifyElementIsDisplayed(loggedInUserNameTxt, 2, "Logged In UserName Text");
		mobileActionUtil.verifyElementText(loggedInUserNameTxt, 2, loggedInUserNameText);
	}

	/**
	 * @author Shreya
	 * @description Method to verify loggedInUserEditIcn is displayed and click on
	 *              the same.
	 *
	 */

	public void clickOnloggedInUserEditIcon() {

		mobileActionUtil.verifyElementIsDisplayed(loggedInUserEditIcn, 2, "Logged In UserName Edit Icon");
		mobileActionUtil.clickOnMobileElement(loggedInUserEditIcn, "Logged in UserName Edit Icon");

	}

	/**
	 * @author Shreya
	 * @description Method to verify loggedIn User Check Box is displayed and select
	 *              the same.
	 *
	 */

	public void selectloggedInUserCheckBox() {

		mobileActionUtil.verifyElementIsDisplayed(loggedInUserChkBx, 2, "Logged In UserName Check Box");
		mobileActionUtil.clickCheckBox(loggedInUserChkBx, "Logged In UserName Check Box");

	}

	/**
	 * @author Shreya
	 * @description Method to verify loggedInUserEditIcn is displayed and click on
	 *              the same.
	 */

	public void clickOnAddNewPassengerLink() {

		mobileActionUtil.verifyElementIsDisplayed(addNewPassengerLnk, 2, "Add New Passenger Link");
		mobileActionUtil.clickOnMobileElement(addNewPassengerLnk, "Add New Passenger Link");

	}

	/**
	 * @author Shreya
	 * @description Method to verify i Icon is displayed and click on the same.
	 */
	public void clickOniIcon() {

		mobileActionUtil.verifyElementIsDisplayed(iIcn, 2, "i Icon");
		mobileActionUtil.clickOnMobileElement(iIcn, "i Icon");

	}

	/**
	 * @author Shreya
	 * @description Method to verify fare is displayed and verify the Total fare
	 * @param fare
	 */

	public void verifyFareText(String fare) {

		mobileActionUtil.verifyElementIsDisplayed(fareTxt, 2, "Total Fare");
		mobileActionUtil.verifyElementText(fareTxt, 2, fare);
	}

	/**
	 * @author Shreya
	 * @description Method to verify Save And Continue is displayed and click on the
	 *              same.
	 */
	public void clickOnSaveAndContinueButton() {

		mobileActionUtil.verifyElementIsDisplayed(saveAndContinueBtn, 2, "Save And Continue Button");
		mobileActionUtil.clickOnMobileElement(saveAndContinueBtn, "Save And Contiinue Button");

	}

	/* EDIT PASSENGER */
}
