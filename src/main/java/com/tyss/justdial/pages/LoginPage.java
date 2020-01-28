package com.tyss.justdial.pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage {

	public LoginPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

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
		// mobileActionUtil.sleep(5);
		try {
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 10);
			 * wait.until(ExpectedConditions.stalenessOf(agreeAndContinueBtn));
			 */
			mobileActionUtil.clickOnMobileElement(agreeAndContinueBtn, "'Agree And Continue' Button");
		} catch (Exception e) {
			mobileActionUtil.clickOnElement(agreeAndContinueBtn, "'Agree And Continue' Button");
		}

	}

	public void clickOnNoneOfTheAbove() {
		try {
			if (noneOfTheAboveLnk.isDisplayed()) {
				mobileActionUtil.clickOnElement(noneOfTheAboveLnk, "'None Of The Above' Button ");
			}
		} catch (Exception e) {
		}

	}

	public void clickOnMayBeLaterLink() {
		mobileActionUtil.clickOnElement(mayBeLaterLnk, "'May Be Later' Link");

		// mobileActionUtil.sleep(2);
	}

	public void clickOnlanguageMayBeLaterLink() {

		mobileActionUtil.waitForElement(namasteTxt, 5, "Namaste Text");
		mobileActionUtil.pressBack();
		mobileActionUtil.clickOnElement(languageMaybelaterlnk, "Language May be later lnk");
	}

	public void goToHomeScreen() {

		try {
			mobileActionUtil.waitForElement(namasteTxt, 10, "Namaste Text");

			if (namasteTxt.isDisplayed()) {
				mobileActionUtil.pressBack();
			}
		} catch (Exception e) {
			mobileActionUtil.sleep(1);
			if (namasteTxt.isDisplayed()) {
				mobileActionUtil.pressBack();

			}
		}
		/* driver.execute("client:client.hybridWaitForPageLoad(10000)"); */
		/* mobileActionUtil.clickOnElement(homeIcon, "home Icon"); */
	}

	public void clickOnNoThanksButton() {
		// mobileActionUtil.clickOnMobileElement(noThanksBtn, "No Thanks Button");
		/* mobileActionUtil.sleep(1); */
	}
}