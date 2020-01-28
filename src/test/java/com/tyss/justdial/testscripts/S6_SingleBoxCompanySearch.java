
package com.tyss.justdial.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

public class S6_SingleBoxCompanySearch extends BaseTest {

@Test
public void s6_SingleBoxCompanySearch(Method m) {

/* Fetch the Test Data from Excel File */
String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 82, 1);
String expText1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 82, 2);
String expText2 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 82, 3);
String expText3 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 82, 4);

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
homePage.testName(m.getName().toString() + "- Search Taj Hotel Goa");
homePage.clickOnSearchBox();

/* Select Current Location */
homePage.selectCurrentLocation();

/* Click On Search Box */
homePage.clickOnSearchBox();

/* Search Entered Text */
homePage.searchEnteredText(enterText);

/* Verify Searched Keyword With First Search */
homePage.verifySearchedKeywordWithfirstSearch(expText1);

/* Verify Searched Keyword With Sub Search */
homePage.verifySearchedKeywordWithSubSearch(expText2);

/* Click On TajHotel Goa Text */
homePage.clickOnTajHotelGoaText();

/* Verify Search Result Page */
SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
searchpage.verifySearchResultPage(expText3);
}
}