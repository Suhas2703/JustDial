package com.tyss.justdial.library;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	
	public AndroidDriver<?> driver;
	public MobileActionUtil mobileActionUtil;

	public BasePage(AndroidDriver<?> driver,MobileActionUtil mobileActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.mobileActionUtil = mobileActionUtil;
	}
}