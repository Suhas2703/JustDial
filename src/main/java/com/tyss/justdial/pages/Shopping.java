package com.tyss.justdial.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class Shopping extends BasePage {
	long timeinSeconds = 5;

	public Shopping(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Shopping']")
	private WebElement ShoppingTab;

	public void verifySearchResultPage(String enterText) {
		mobileActionUtil.waitForElement(ShoppingTab, timeinSeconds, "Shopping Navigation Bar");
		mobileActionUtil.verifyElementText(ShoppingTab, timeinSeconds, enterText);
	}

}
