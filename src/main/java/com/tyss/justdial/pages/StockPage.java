package com.tyss.justdial.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class StockPage  extends BasePage{
	long timeinSeconds = 2;

	public StockPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
		
	}
	@FindBy(xpath="//android.view.View[@text='MANPASAND.NS']")
	private WebElement manPasandNS;
	
	@FindBy(xpath="//android.view.View[@text='Manpasand Beverages Limited']")
	private WebElement manPasandBL;
	
	
	public void verifySearchedKeywordWithfirstSearch(String enterText) {
		mobileActionUtil.waitForElement(manPasandNS, timeinSeconds, enterText);
		System.out.println(manPasandNS.getText()); 
		mobileActionUtil.verifyElementText(manPasandNS, timeinSeconds, enterText);
	}

}
