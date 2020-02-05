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
	private WebElement iIcon;

	@FindBy(id = "bookFlt")
	private WebElement passengerSaveAndContinueBtn;

	/* EDIT PASSENGER ELEMENTS */
	@FindBy(id = "headerHeading")
	private WebElement editPassengerTitle;

	@FindBy(id = "edtLnFname")
	private WebElement editPassengerfirstNameTxtBx;

	@FindBy(id = "edtLnLname")
	private WebElement editPassengerlastNameTxtBx;

	@FindBy(id = "edtLnDob")
	private WebElement editPassengerdobTxtBx;

	@FindBy(xpath = "//android.view.View[@text='First name']")
	private WebElement editPassengerfirstNameTxt;

	@FindBy(xpath = "//android.view.View[@text='Last name']")
	private WebElement editPassengerlastNameTxt;

	@FindBy(xpath = "//android.view.View[@text='DOB']")
	private WebElement editPassengerdobTxt;

	@FindBy(xpath = "//android.view.View[@text='Save & Continue']")
	private WebElement editPassengerSaveAndContinueBtn;

	@FindBy(id = "mainHeaderHeading")
	private WebElement editBackBtn;

	@FindBy(xpath = "//android.view.View[@text='Mr']")
	private WebElement mrChkBx;

	@FindBy(xpath = "//android.view.View[@text='Mrs']")
	private WebElement mrsChkBx;

	@FindBy(xpath = "//android.view.View[@text='Ms']")
	private WebElement msChkBx;

	/* ADD NEW PASSENGER ELEMENTS */

	@FindBy(id = "headerHeading")
	private WebElement addPassengerTitle;

	@FindBy(id = "lbradA")
	private WebElement adultChkBx;

	@FindBy(id = "lbradC")
	private WebElement childChkBx;

	@FindBy(id = "lbradI")
	private WebElement infantChkBx;

	@FindBy(id = "Fname")
	private WebElement addPassengerfirstNameTxtBx;

	@FindBy(id = "Lname")
	private WebElement addPassengerlastNameTxtBx;

	@FindBy(id = "addDob")
	private WebElement addPassengerdobTxtBx;

	@FindBy(xpath = "//android.view.View[@text='Mr']")
	private WebElement addPassengermrChkBx;

	@FindBy(xpath = "//android.view.View[@text='Mrs']")
	private WebElement addPassengermrsChkBx;

	@FindBy(xpath = "//android.view.View[@text='Ms']")
	private WebElement addPassengermsChkBx;

	@FindBy(id = "btnDoneCan_login")
	private WebElement addPassengerSaveAndContinueBtn;

	/**
	 * @author Shreya
	 * @description Method to verify loggedInUserName is displayed
	 * @param loggedInUserNameText
	 */

	public void verifyLoggedInUserNameisdisplayed() {

		mobileActionUtil.verifyElementIsDisplayed(loggedInUserNameTxt, 2, "Logged In UserName Text");

	}

	/**
	 * @author Shreya
	 * @description Method to verify the UserName
	 * @param loggedInUserNameText
	 */
	public void verifyLoggedInUserName(String loggedInUserNameText) {

		mobileActionUtil.verifyElementText(loggedInUserNameTxt, 2, loggedInUserNameText);
	}

	/**
	 * @author Shreya
	 * @description Method to get Looged in UserName
	 * @param loggedInUserNameText
	 */
	public String getLoggeInUserName() {

		return mobileActionUtil.getText(loggedInUserNameTxt);
	}

	/**
	 * @author Shreya
	 * @description Method to verify loggedInUserEditIcn is displayed
	 *
	 */

	public void verifyLoggedInUserEditIconisDisplayed() {

		mobileActionUtil.verifyElementIsDisplayed(loggedInUserEditIcn, 2, "Logged In UserName Edit Icon");

	}

	/**
	 * @author Shreya
	 * @description click on the loggedInUserEditIcn.
	 * 
	 */

	public void clickOnloggedInUserEditIcon() {

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
	 * @description Method to verify loggedIn User Check Box is displayed and select
	 *              the same.
	 *
	 */
	public void verifyloggedInUserCheckBoxIsdisplayed() {

		mobileActionUtil.verifyElementIsDisplayed(loggedInUserChkBx, 2, "Logged In UserName Check Box");
	}

	/**
	 * @author Shreya
	 * @description click on the loggedInUserEditIcn.
	 */

	public void clickOnAddNewPassengerLink() {

		mobileActionUtil.clickOnMobileElement(addNewPassengerLnk, "Add New Passenger Link");

	}

	/**
	 * @author Shreya
	 * @description click on the loggedInUserEditIcn.
	 */
	public void verifyAddNewPassengerLinkIsDisplayed() {

		mobileActionUtil.verifyElementIsDisplayed(addNewPassengerLnk, 2, "Add New Passenger Link");

	}

	/**
	 * @author Shreya
	 * @description Method to verify i Icon is displayed and click on the same.
	 */
	public void clickOniIcon() {

		mobileActionUtil.clickOnMobileElement(iIcon, "i Icon");

	}

	/**
	 * @author Shreya
	 * @description Method to verify i Icon is displayed and click on the same.
	 */
	public void verifyiIconIsDisplayed() {

		mobileActionUtil.verifyElementIsDisplayed(iIcon, 2, "i Icon");
	}

	/**
	 * @author Shreya
	 * @description verify the Total fare
	 * @param fare
	 */

	public void verifyFareText(String fare) {

		mobileActionUtil.verifyElementText(fareTxt, 2, fare);
	}

	/**
	 * @author Shreya
	 * @description Method to verify fare is displayed and verify the Total fare
	 * @param fare
	 */

	public String getFare() {

		return mobileActionUtil.getText(fareTxt);
	}

	/**
	 * @author Shreya
	 * @description Method to verify fare is displayed and verify the Total fare
	 * @param fare
	 */

	public void verifyFareisDisplayed() {

		mobileActionUtil.verifyElementIsDisplayed(fareTxt, 2, "Total Fare");
	}

	/**
	 * @author Shreya
	 * @description Method to verify Save And Continue is displayed and click on the
	 *              same.
	 */
	public void clickOnPassengerSaveAndContinueButton() {

		mobileActionUtil.verifyElementIsDisplayed(passengerSaveAndContinueBtn, 2, "Passenger Save And Continue Button");
		mobileActionUtil.clickOnMobileElement(passengerSaveAndContinueBtn, "Passenger Save And Contiinue Button");

	}

	/**
	 * @author Shreya
	 * @description Save And Continue is displayed in Passenger Detail Screen
	 */

	public void verifySaveAndContinueButtonIsDisplayed() {

		mobileActionUtil.verifyElementIsDisplayed(passengerSaveAndContinueBtn, 2, "Save And Continue Button");

	}

	/* EDIT PASSENGER SCREEN METHODS */
	/**
	 * @author Shreya
	 * @description Method to verify Passenger Title is Displayed
	 */
	public void verifyEditPassengerTitleIsDisplayed() {

		mobileActionUtil.verifyElementIsDisplayed(editPassengerTitle, 2, "Edit Passenger Title");

	}

	/**
	 * @author Shreya
	 * @description Method to get Edit Passenger Page Title
	 */
	public String getEditPassengerTitle() {

		return mobileActionUtil.getText(editPassengerTitle);
	}

	/**
	 * @author Shreya
	 * @description Method to Click on First Name Text Box
	 */
	public void clickOnFirstNameInEditPassenger() {

		mobileActionUtil.clickOnMobileElement(editPassengerfirstNameTxtBx, "edit Passenger firstName Text Box");

	}

	/**
	 * @author Shreya
	 * @description Method to Click on Last Name Text Box
	 */
	public void clickOnLastNameInEditPassenger() {

		mobileActionUtil.clickOnMobileElement(editPassengerlastNameTxtBx, "edit Passenger LastName Text Box");

	}

	/**
	 * @author Shreya
	 * @description Method to Click on Last Name Text Box
	 */
	public void clickOnDOBInEditPassenger() {

		mobileActionUtil.clickOnMobileElement(editPassengerdobTxtBx, "edit Passenger LastName Text Box");

	}
	/**
	 * @author Shreya
	 * @description Method to Click on Save and Continue Button
	 */
	public void clickOnSaveAndContinueInEditPassenger() {

		mobileActionUtil.clickOnMobileElement(editPassengerSaveAndContinueBtn, "edit Passenger SaveAndContinue Button");

	}
	
	/**
	 * @author Shreya
	 * @description Method to Click on Back Button
	 */
	public void clickOnBackInEditPassenger() {

		mobileActionUtil.clickOnMobileElement(editBackBtn, "edit Back Button");

	}
	
	/**
	 * @author Shreya
	 * @description Method to Click on Mr CheckBox
	 */
	public void selectMrCheckBox() {

		mobileActionUtil.clickOnMobileElement(mrChkBx, "Mr Check Box");

	}
	
}
