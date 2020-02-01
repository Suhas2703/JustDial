package com.tyss.justdial.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class S1_CompanySearch_CompleteWord extends BaseTest {

	@Test(testName="s1_CompanySearch_CompleteWord", description="", alwaysRun=true)
	public void s1_CompanySearch_CompleteWord(Method m) {

		/* Fetch the Test Data from Excel File */
		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 67, 1);
		String expText2 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 67, 4);

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
		homePage.testName(m.getName().toString() + "- Search Taj Mahal ");
		homePage.clickOnSearchBox();

		/* Select Current Location */
		homePage.selectCurrentLocation();

		/* Click On Search Box */
		homePage.clickOnSearchBox();

		/* Search Entered Text */
		homePage.searchEnteredText(enterText);

		/* Click On TajMahal Text */
		homePage.clickOnTajMahalText();

		/* Scroll Till Tourist Attraction Text */
		SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
		searchpage.scrollTillTouristAttraction();

		/* Verify Tourist Attraction Text */
		searchpage.verifyTouristAttraction(expText2);

	}
}