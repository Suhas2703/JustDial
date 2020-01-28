package com.tyss.justdial.testscripts.homepage;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class JustDial_HomePageTest_TC0028 extends BaseTest {

	@Test(description = "Single Box Company Search")
	public void S6_SingleBoxCompanySearch(Method m) {

		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 82, 1);
		String expText1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 82, 2);
		String expText2 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 82, 3);
		String expText3 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 82, 4);

		LoginPage loginPage = new LoginPage(driver, mobileActionUtil);
		loginPage.clickOnAgreeAndContinueButton();
		loginPage.clickOnNoneOfTheAbove();
		loginPage.clickOnMayBeLaterLink();
		loginPage.clickOnNoThanksButton();
		loginPage.goToHomeScreen();

		HomePage homePage = new HomePage(driver, mobileActionUtil);
		homePage.testName(m.getName().toString() + "- Search Taj Hotel Goa");
		homePage.clickOnSearchBox();
		homePage.selectCurrentLocation();
		homePage.clickOnSearchBox();
		homePage.searchEnteredText(enterText);
		homePage.verifySearchedKeywordWithfirstSearch(expText1);
		homePage.verifySearchedKeywordWithSubSearch(expText2);
		homePage.clickOnTajHotelGoaText();
		SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
		searchpage.verifySearchResultPage(expText3);
	}
}