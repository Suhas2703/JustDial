package com.tyss.justdial.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class S3_Companysearch_WithoutSpace extends BaseTest {

	@Test
	public void s3_Companysearch_WithoutSpace(Method m) {

		/* Fetch the Test Data from Excel File */
		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 73, 1);
		String Text1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 73, 2);
		String phoneNumber = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 73, 3);

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
		homePage.testName(m.getName().toString() + "- Search Rudra");
		homePage.clickOnSearchBox();

		/* Select Current Location */
		homePage.selectCurrentLocation();

		/* Click On Search Box */
		homePage.clickOnSearchBox();

		/* Search Entered Text */
		homePage.searchEnteredText(enterText);

		/* Verify Searched Keyword With FirstSearch */
		homePage.verifySearchedKeywordWithfirstSearch(Text1);

		/* Click On Rudrappa Hospital Text */
		homePage.clickOnRudrappaHospitalText();

		/* Scroll Till Rudrappa Hospital Phone Number */
		SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
		searchpage.scrollTillRudrappaHospitalPhoneNumber();

		/* Verify Rudrappa Hospital Phone Number */
		searchpage.verifyRudrappaHospitalPhoneNumber(phoneNumber);
	}
}
