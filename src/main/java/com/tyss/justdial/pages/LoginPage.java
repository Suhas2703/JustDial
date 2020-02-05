package com.tyss.justdial.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage {

	/**
	 * @author Shobhan
	 * @description Constructor to initialize Login mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public LoginPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
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

	/** Log In Screen MOBILE ELEMENTS DECLARATION **/
	long seconds = 10;
	@FindBy(id = "com.justdial.search:id/terms_accept_btn")
	private WebElement agreeAndContinueBtn;

	@FindBy(id = "com.google.android.gms:id/cancel")
	private WebElement noneOfTheAboveLnk;

	@FindBy(id = "com.justdial.search:id/button_skip")
	private WebElement mayBeLaterLnk;

	@FindBy(id = "com.android.vending:id/negative_button")
	private WebElement noThanksBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Maybe later']")
	private WebElement languageMaybelaterlnk;

	@FindBy(xpath = "//android.widget.TextView[@text='Namaste']")
	private WebElement namasteTxt;
	
	

	/**
	 * @author Shobhan
	 * @description Click on Agree And Continue Button
	 */
	public void clickOnAgreeAndContinueButton() {

		mobileActionUtil.clickOnMobileElement(agreeAndContinueBtn, "'Agree And Continue' Button");
	}

	/**
	 * @author Shobhan
	 * @description Click on None of the Above Button
	 */
	public void clickOnNoneOfTheAbove() {

		try {

			if (noneOfTheAboveLnk.isDisplayed()) {
				mobileActionUtil.clickOnMobileElement(noneOfTheAboveLnk, "'None Of The Above' Button ");
			}
		} catch (Exception e) {
		}

	}

	/**
	 * @author Shobhan
	 * @description Click on May Be Later Button
	 */
	public void clickOnMayBeLaterLink() {

		mobileActionUtil.clickOnMobileElement(mayBeLaterLnk, "'May Be Later' Link");
	}

	/**
	 * @author Shobhan
	 * @description Click on May Be Later Link in Language Pop Up
	 */
	public void clickOnlanguageMayBeLaterLink() {

		mobileActionUtil.waitForElement(namasteTxt, 5, "Namaste Text");
		mobileActionUtil.pressBack();
		mobileActionUtil.clickOnMobileElement(languageMaybelaterlnk, "Language May be later lnk");
	}

	/**
	 * @author Shobhan
	 * @description Go To Home Screen
	 */
	public void goToHomeScreen() {

		try {
			mobileActionUtil.waitForElement(namasteTxt, 10, "Namaste Text");

			if (namasteTxt.isDisplayed()) {
				mobileActionUtil.pressBack();
			}
		} catch (Exception e) {
			mobileActionUtil.waitForElementToLoad(1);

			if (namasteTxt.isDisplayed()) {
				mobileActionUtil.pressBack();
			}
		}
	}

	/**
	 * @author Shobhan
	 * @description Click On No Thanks Button
	 */
	public void clickOnNoThanksButton() {
		/*try {
			noThanksBtn.click();
			mobileActionUtil.waitForElementToLoad(1);
			mobileActionUtil.info("no thanks Button");
		} catch (Exception e) {
			mobileActionUtil.info("no thanks Button is not clicked");
		}*/

	}
}