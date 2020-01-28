package com.tyss.justdial.testscripts.homepage;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class JustDial_HomePageTest_TC0025 extends BaseTest {
	
	@Test(description = "Company Search(Without space")
	public void S5_SynoynmCompanysearch(Method m) {

		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 73, 1);
		String Text1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 73, 2);
		String phoneNumber = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 73, 3);
		
		LoginPage loginPage = new LoginPage(driver, mobileActionUtil);
		loginPage.clickOnAgreeAndContinueButton();
		loginPage.clickOnNoneOfTheAbove();
		loginPage.clickOnMayBeLaterLink();
		loginPage.clickOnNoThanksButton();
//		loginPage.clickOnlanguageMayBeLaterLink();
		loginPage.goToHomeScreen();
		
		HomePage homePage = new HomePage(driver, mobileActionUtil);	
		homePage.testName(m.getName().toString()+"- Search Rudra");
		homePage.clickOnSearchBox();
		homePage.selectCurrentLocation();
		homePage.clickOnSearchBox();
		homePage.searchEnteredText(enterText);
		homePage.verifySearchedKeywordWithfirstSearch(Text1);
		homePage.clickOnRudrappaHospitalText();
		SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
		searchpage.scrollTillRudrappaHospitalPhoneNumber();
		searchpage.verifyRudrappaHospitalPhoneNumber(phoneNumber);
	}
}