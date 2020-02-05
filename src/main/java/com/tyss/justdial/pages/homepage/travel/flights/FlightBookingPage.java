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
	
	@FindBy(xpath="(//android.view.View)[13]")
	private WebElement selAirline;
	
	@FindBy(xpath="//android.view.View[contains(@text,'Refundable')]")
	private WebElement flghtType;
	
	@FindBy(id="toggleInsurance")
	private WebElement insRdbtn;
	
	@FindBy(xpath="//android.view.View[@text='T&C']")
	private WebElement terms_Cndtns;
	
	@FindBy(xpath="//android.view.View[contains(@text,'more')]")
	private WebElement plcyBnfts;
	
	@FindBy(xpath="//android.view.View[contains(@text,'Promocode')]")
	private WebElement promoCode;
	
	@FindBy(id="promocode")
	private WebElement enter_Promocde;
	
	@FindBy(id="applyPromo")
	private WebElement apply_Promo;
	
	@FindBy(id="sumPrice")
	private WebElement totFare;
	
	@FindBy(id="bookFlt")
	private WebElement bookFlght;
	
	@FindBy(id="mainHeaderHeading")
	private WebElement backBtn;
	
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
	
	public String getSel_airline()
	{
		return mobileActionUtil.getText(selAirline);
	}
	
	public String getFlghttype()
	{
		return mobileActionUtil.getText(flghtType);
	}
	
	public void clickonIns_rdbtn()
	{
		mobileActionUtil.clickCheckBox(insRdbtn, "Insurance Radio Button");
	}
	
	public void clickonTerms_cndtns()
	{
		mobileActionUtil.tapOnElement(terms_Cndtns);
	}
	
	public String getPlcybnfts()
	{
		return mobileActionUtil.getText(plcyBnfts);
		
	}
	public void scrollTo_Plcybnfts()
	{
		mobileActionUtil.scrollTillElement(getFlghttype());
	}
	
	public String verify_Promocode()
	{
		return mobileActionUtil.getText(promoCode);
	}
	
	public void click_Promocode()
	{
		mobileActionUtil.clickOnMobileElement(enter_Promocde, "PromoCode");
	}
	
	public void click_applyPromo()
	{
		mobileActionUtil.clickOnMobileElement(apply_Promo, "ApplyPromo");
	}
	
	public String getTotalfare()
	{
		return mobileActionUtil.getText(totFare);
	}
	
	public void click_Tobookflght()
	{
		mobileActionUtil.clickOnMobileElement(bookFlght, "Continue to book Flight");
	}
	
	public void click_BackBtn()
	{
		mobileActionUtil.clickOnMobileElement(backBtn, "Back Button");
	}
}
