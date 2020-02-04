package com.tyss.justdial.pages.homepage.travel.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class FlightBookingPage extends BasePage {

	/**
	 * @author Savitha
	 * @description Constructor to initialize FlightsPage mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public FlightBookingPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @author Savitha Kiran
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
	/** FLIGHT BOOKING SCREEN MOBILE ELEMENTS DECLARATION **/
	
	long seconds = 10;
	@FindBy(xpath="(//android.view.View)[8]")
	private WebElement travelInfo;
	
	@FindBy(xpath="(//android.view.View)[14]")
	private WebElement fromCity;
	
	@FindBy(xpath="(//android.view.View)[16]")
	private WebElement depTime;
	
	@FindBy(xpath="(//android.view.View)[22]")
	private WebElement toCity;
	
	@FindBy(xpath="(//android.view.View)[24]")
	private WebElement arrvTime;
	
	public String getTravlinfo()
	{
		return mobileActionUtil.getText(travelInfo);
	}
	
	public String getFrmcity()
	{
		return mobileActionUtil.getText(fromCity);
	}
	
	public String getDeptime()
	{
		return mobileActionUtil.getText(depTime);
	}
	
	public String getTocity()
	{
		return mobileActionUtil.getText(toCity);
	}
	
	public String getArrvtime()
	{
		return mobileActionUtil.getText(arrvTime);
	}
}
