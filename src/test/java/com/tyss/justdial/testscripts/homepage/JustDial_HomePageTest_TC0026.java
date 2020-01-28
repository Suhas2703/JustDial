package com.tyss.justdial.testscripts.homepage;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class JustDial_HomePageTest_TC0026 extends BaseTest {
	
	@Test(description = "Grouping company search")
	public void S4_GroupingCompanySearch(Method m) {

		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 76, 1);
		String expText1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 76, 2);
		String expText2 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 76, 3);
		String expText3 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 76, 4);

		LoginPage loginPage = new LoginPage(driver, mobileActionUtil);
		loginPage.clickOnAgreeAndContinueButton();
		loginPage.clickOnNoneOfTheAbove();
		loginPage.clickOnMayBeLaterLink();
		loginPage.clickOnNoThanksButton();
		loginPage.goToHomeScreen();

		HomePage homePage = new HomePage(driver, mobileActionUtil);
		homePage.testName(m.getName().toString() + "- Search McDonalds bellandur");
		homePage.clickOnSearchBox();
		homePage.selectCurrentLocation();
		homePage.clickOnSearchBox();
		homePage.searchEnteredText(enterText);
		homePage.verifySearchedKeywordWithfirstSearch(expText1);
		homePage.verifySearchedKeywordWithSubSearch(expText2);
		homePage.clickOnMacdonaldBellundurText();
		SearchPage searchPage = new SearchPage(driver, mobileActionUtil);
		searchPage.verifySearchResultPage(expText3);
	}
}