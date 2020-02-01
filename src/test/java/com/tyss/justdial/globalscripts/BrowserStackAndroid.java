package com.tyss.justdial.globalscripts;


	import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;
	 
	public class BrowserStackAndroid extends BaseTest {
	  
	  public static String userName = "shreyau1";
	  public static String accessKey = "oEUhApyGPx6ss5XVrLKJ";

	  @Test
	  public  void browserStackTest(Method m) throws InterruptedException  {

			/* Fetch the Test Data from Excel File */
			String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 1);
			String expText1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 2);
			String expText2 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 3);
			String expText3 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 4);

			/* Click On Agree and Continue Button */
			LoginPage loginPage = new LoginPage(driver, mobileActionUtil);
			loginPage.clickOnAgreeAndContinueButton();

			/* Click On None Of The Above Link */
			//loginPage.clickOnNoneOfTheAbove();

			/* Click On May Be Later Link */
			loginPage.clickOnMayBeLaterLink();

			/* Click On No Thanks Button */
			//loginPage.clickOnNoThanksButton();

			/* Go To Home Screen */
			//loginPage.goToHomeScreen();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.Button[@text='ALLOW']")).click();

			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.Button[@text='ALLOW']")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.Button[@text='ALLOW']")).click();
			
			
			driver.findElement(By.id("com.justdial.search:id/jd_image_home")).click();
		
			//driver.findElement(By.xpath("com.justdial.search:id/search_edit_text_home")).click();
			/* Click On Search Box */
			HomePage homePage = new HomePage(driver, mobileActionUtil);
			homePage.testName(m.getName().toString() + "- Search CCD Nagawara");
			homePage.clickOnSearchBox();

			/* Select Current Location */
			//homePage.selectCurrentLocation();

			/* Click On Search Box */
			//homePage.clickOnSearchBox();

			Thread.sleep(3000);
			/* Search Entered Text */
			homePage.searchEnteredText(enterText);

			/* Verify Searched Keyword With firstSearch */
			homePage.verifySearchedKeywordWithfirstSearch(expText1);

			/* Verify Searched Keyword With SubSearch */
			homePage.verifySearchedKeywordWithSubSearch(expText2);

			/* Click On CCD Nagawara Text */
			homePage.clickOnCCDNagawaraText();

			/* Scroll Till CCD Phone Number */
			SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
			searchpage.scrollTillCCDPhoneNumber();

			/* Verify CCD Phone Number */
			searchpage.verifySearchResultPage(expText3);

	    driver.quit();
	  }
	}