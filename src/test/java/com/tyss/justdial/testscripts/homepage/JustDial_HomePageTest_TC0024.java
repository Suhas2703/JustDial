package com.tyss.justdial.testscripts.homepage;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class JustDial_HomePageTest_TC0024 extends BaseTest {
	@Test(description = "Comapany Search (Partial-word)")
	public void S2_CompanySearch_PartialWord(Method m) {

		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 70, 1);
		String expText1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 70, 2);
		String expText2 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 70, 3);
		String phoneNumber = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 70, 4);

		LoginPage loginPage = new LoginPage(driver, mobileActionUtil);
		loginPage.clickOnAgreeAndContinueButton();
		loginPage.clickOnNoneOfTheAbove();
		loginPage.clickOnMayBeLaterLink();
		loginPage.clickOnNoThanksButton();
		loginPage.goToHomeScreen();

		HomePage homePage = new HomePage(driver, mobileActionUtil);
		homePage.testName(m.getName().toString() + "- Search J W");
		homePage.clickOnSearchBox();
		homePage.selectCurrentLocation();
		homePage.clickOnSearchBox();
		homePage.searchEnteredText(enterText);
		homePage.verifySearchedKeywordWithfirstSearch(expText1);
		homePage.verifySearchedKeywordWithSubSearch(expText2);
		homePage.clickOnJwMarriotText();
		SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
		searchpage.scrollTillJWMarriotHotelPhoneNumber();
		searchpage.verifyJWMarriotHotelPhoneNumber(phoneNumber);
	}
}