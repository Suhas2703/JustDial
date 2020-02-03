package com.tyss.justdial.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;

public class ParallelExecution extends BaseTest {
	@Test(testName = "Parallel Execution", description = "", alwaysRun = true)
	public void parallelExecutionDemo(Method m) {
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
		homePage.testName(m.getName().toString() + "- Paralle Execution ");
		
		homePage.clickOnShoppingIcon();
		
		homePage.clickOnOffersIcon();
		
		homePage.clickOnKnowMore();
		
		homePage.clickOnFirstProduct();
	}

}
