package com.tyss.justdial.flights.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.homepage.travel.TravelPage;
import com.tyss.justdial.pages.homepage.travel.flights.SearchFlightsPage;
/**
 *
 * @author Shobhan
 *
 */
public class Flight_TC001 extends BaseTest {

	@Test(description = "searchFlight")
	public void searchFlight(Method m) {

		/* Fetch the Test Data from Excel File */
//		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "", 76, 1);
		String enterText1 = "Mumbai";
		String enterText2 = "Goa";
		String expectedText1="";
		String expectedText2= "Mumbai BOM";
		String expectedText3= "Goa GOI";
		String expectedText4= "WED, 5th Feb 2020";

		// Enter the Test case name
		TravelPage travelPage = new TravelPage(driver, mobileActionUtil);
		travelPage.testName(m.getName().toString());

		HomePage homePage = new HomePage(driver, mobileActionUtil);
		homePage.clickOnTravelHotSearchKey();

		travelPage.selectFlightFilter();

		SearchFlightsPage searchFlightsPage = new SearchFlightsPage(driver, mobileActionUtil);
		searchFlightsPage.clickOnFrom();

		searchFlightsPage.clickOnAirportSearch();
		searchFlightsPage.enterCityNameInSearch(enterText1);
		searchFlightsPage.selectFirstCity();

		searchFlightsPage.clickOnTo();

		searchFlightsPage.clickOnAirportSearch();
		searchFlightsPage.enterCityNameInSearch(enterText2);
		searchFlightsPage.selectFirstCity();

		searchFlightsPage.clickOnTravellers();
		searchFlightsPage.increseAdultNumber();


		searchFlightsPage.clickOnDone();
		searchFlightsPage.clickOnSearch();

		searchFlightsPage.verifyFirstprompt(expectedText1, expectedText2, expectedText3);
	}
}
