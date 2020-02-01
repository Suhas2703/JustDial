package com.tyss.justdial.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class S5_SynoynmCompanyearch extends BaseTest {

	@Test
	public void s5_SynoynmCompanyearch(Method m) {

		/* Fetch the Test Data from Excel File */
		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 1);
		String expText1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 2);
		String expText2 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 3);
		String expText3 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 4);

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
		homePage.testName(m.getName().toString() + "- Search CCD Nagawara");
		homePage.clickOnSearchBox();

		/* Select Current Location */
		homePage.selectCurrentLocation();

		/* Click On Search Box */
		homePage.clickOnSearchBox();

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
		searchpage.verifyCCDPhoneNumber(expText3);
	}
}