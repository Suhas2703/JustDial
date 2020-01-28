package com.tyss.justdial.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class MoviesPage extends BasePage {

	long timeOutInSeconds = 5;

	public MoviesPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	

	@FindBy(xpath = "//android.view.View[@text='Gully Boy (2019)']")
	private WebElement movieNameTxt;

	public void VerifyGullyBoy(String expectedText) {
		mobileActionUtil.verifyElementText(movieNameTxt, timeOutInSeconds, expectedText);
	}

}
