package com.tyss.justdial.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class S2_CompanySearch_PartialWord extends BaseTest {

	@Test
	public void s2_CompanySearch_PartialWord(Method m) {

		/* Fetch the Test Data from Excel File */
		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 70, 1);
		String expText1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 70, 2);
		String expText2 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 70, 3);
		String phoneNumber = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 70, 4);

		/* Click On Agree and Continue Button */
		LoginPage loginPage = new LoginPage(driver, mobileActionUtil);
		loginPage.clickOnAgreeAndContinueButton();

		/* Click On None Of The Above Link */
		loginPage.clickOnNoneOfTheAbove();

		/* Click On May Be Later Link */
		loginPage.clickOnMayBeLaterLink();

		/* Click On No Thanks Button */
		loginPage.clickOnNoThanksButton();

		/* Go To Home Screen */
		loginPage.goToHomeScreen();

		/* Click On Search Box */
		HomePage homePage = new HomePage(driver, mobileActionUtil);
		homePage.testName(m.getName().toString() + "- Search J W");
		homePage.clickOnSearchBox();

		/* Select Current Location */
		homePage.selectCurrentLocation();

		/* Click On Search Box */
		homePage.clickOnSearchBox();

		/* Search Entered Text */
		homePage.searchEnteredText(enterText);

		/* Verify Searched Keyword With FirstSearch */
		homePage.verifySearchedKeywordWithfirstSearch(expText1);

		/* Verify Searched Keyword With Sub Search */
		homePage.verifySearchedKeywordWithSubSearch(expText2);

		/* Click On JW Marriot Text */
		homePage.clickOnJwMarriotText();

		/* Scroll Till JW Marriot Hotel Phone Number */
		SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
		searchpage.scrollTillJWMarriotHotelPhoneNumber();

		/* Verify JWMarriotHotel Phone Number */
		searchpage.verifyJWMarriotHotelPhoneNumber(phoneNumber);
	}
}
