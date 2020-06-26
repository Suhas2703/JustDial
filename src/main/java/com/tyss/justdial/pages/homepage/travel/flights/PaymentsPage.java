package com.tyss.justdial.pages.homepage.travel.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class PaymentsPage extends BasePage {

	/**
	 * @author Shreya U
	 * @description Constructor to initialize home page mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public PaymentsPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);

	}

	/**
	 * @author Shreya U
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

	/** PAYMENTS SCREEN MOBILE ELEMENTS DECLARATION **/
	@FindBy(id = "TitlHdTx")
	private WebElement paymentsTitle;

	@FindBy(xpath = "//android.view.View[@text='Net Banking']")
	private WebElement netBankingTxt;

	/**
	 * @author Shreya
	 * @description Method to verify Payements Page Title is Displayed.
	 */

	public void verifyPaymentsPageTitleIsDisplayed() {

		mobileActionUtil.verifyElementIsDisplayed(paymentsTitle, 2, "PayMents Title");

	}

	/**
	 * @author Shreya
	 * @description Method to get Payments Page Title
	 */
	public String getPaymentsTitle() {

		return mobileActionUtil.getText(paymentsTitle);

	}

	/**
	 * @author Shreya
	 * @description Method to verify Net Banking Text is Displayed.
	 */

	public void verifyNetBankingTextIsDisplayed() {

		mobileActionUtil.verifyElementIsDisplayed(netBankingTxt, 2, "Net Banking ");

	}

	/**
	 * @author Shreya
	 * @description Method to get Net Banking Text
	 */
	public String getNetBankingText() {

		return mobileActionUtil.getText(netBankingTxt);

	}

}