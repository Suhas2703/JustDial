package com.tyss.justdial.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage {

	/**
	 * LoginPage Constructor
	 * 
	 * @param driver
	 * @param mobileActionUtil
	 */
	public LoginPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	public void testName(String testName) {
		mobileActionUtil.info("\n");
		mobileActionUtil.info("=======================================================================");
		mobileActionUtil.info(" Test Case Name : " + testName);
		mobileActionUtil.info("=======================================================================");
		mobileActionUtil.info("\n");
	}

	/**
	 * Adding the Elements
	 */
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

	public void clickOnAgreeAndContinueButton() {
		mobileActionUtil.clickOnMobileElement(agreeAndContinueBtn, "'Agree And Continue' Button");
	}

	public void clickOnNoneOfTheAbove() {

		try {

			if (noneOfTheAboveLnk.isDisplayed()) {
				mobileActionUtil.clickOnMobileElement(noneOfTheAboveLnk, "'None Of The Above' Button ");
			}
		} catch (Exception e) {
		}

	}

	public void clickOnMayBeLaterLink() {

		mobileActionUtil.clickOnMobileElement(mayBeLaterLnk, "'May Be Later' Link");
	}

	public void clickOnlanguageMayBeLaterLink() {

		mobileActionUtil.waitForElement(namasteTxt, 5, "Namaste Text");
		mobileActionUtil.pressBack();
		mobileActionUtil.clickOnMobileElement(languageMaybelaterlnk, "Language May be later lnk");
	}

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

	public void clickOnNoThanksButton() {
		 mobileActionUtil.clickOnMobileElement(noThanksBtn, "No Thanks Button");
		 mobileActionUtil.waitForElementToLoad(1);
	}
}