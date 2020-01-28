package com.tyss.justdial.testscripts.homepage;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class JustDial_HomePageTest_TC0023 extends BaseTest{
	
	@Test(description="Selection from Autosuggest")
	public void S1_CompanySearch_CompleteWord(Method m)  {

		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 67, 1);
		String expText1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 67, 2);
		String expText2 = "Tourist Attraction";	
		LoginPage loginPage = new LoginPage(driver, mobileActionUtil);
		loginPage.clickOnAgreeAndContinueButton();
		loginPage.clickOnNoneOfTheAbove();
		loginPage.clickOnMayBeLaterLink();
		loginPage.clickOnNoThanksButton();
		loginPage.goToHomeScreen();
		
		HomePage homePage = new HomePage(driver, mobileActionUtil);	
		homePage.testName(m.getName().toString()+"- Search Taj Mahal ");
		homePage.clickOnSearchBox();
		homePage.selectCurrentLocation();
		homePage.clickOnSearchBox();
		homePage.searchEnteredText(enterText);
		homePage.clickOnTajMahalText();
		SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
		searchpage.scrollTillTouristAttraction();
		searchpage.verifyTouristAttraction(expText2);
	}
}