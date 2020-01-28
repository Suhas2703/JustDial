package com.tyss.justdial.testscripts.homepage;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class JustDial_HomePageTest_TC0027 extends BaseTest {
	
	@Test(description = "Synoynm Company search")
	public void testS5(Method m) {

		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 1);
		String expText1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 2);
		String expText2 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 3);
		String expText3 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 4);

		LoginPage loginPage = new LoginPage(driver, mobileActionUtil);
		loginPage.clickOnAgreeAndContinueButton();
		loginPage.clickOnNoneOfTheAbove();
		loginPage.clickOnMayBeLaterLink();
		loginPage.clickOnNoThanksButton();
		loginPage.goToHomeScreen();

		HomePage homePage = new HomePage(driver, mobileActionUtil);
		homePage.testName(m.getName().toString() + "- Search CCD Nagawara");
		homePage.clickOnSearchBox();
		homePage.selectCurrentLocation();
		homePage.clickOnSearchBox();
		homePage.searchEnteredText(enterText);
		homePage.verifySearchedKeywordWithfirstSearch(expText1);
		homePage.verifySearchedKeywordWithSubSearch(expText2);
		homePage.clickOnCCDNagawaraText();
		SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
		searchpage.scrollTillCCDPhoneNumber();
		searchpage.verifyCCDPhoneNumber(expText3);
	}
}