package com.tyss.justdial.flights.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.homepage.travel.TravelPage;
import com.tyss.justdial.pages.homepage.travel.flights.FlightBookingPage;
import com.tyss.justdial.pages.homepage.travel.flights.FlightSearchPageOneWay;
import com.tyss.justdial.pages.homepage.travel.flights.SearchFlightsPage;

public class Flight_TC006 extends BaseTest{
	@Test(description = "searchFlight")
	public void searchFlight(Method m) throws InterruptedException {

		/* Fetch the Test Data from Excel File */
//		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "", 76, 1);
		String enterText1 = "Mumbai";
		String enterText2 = "Goa";
		String expectedText1="Mumbai BOM";
		String expectedText2= "Goa GOI ";
		String expectedText3= "WED, 5th Feb 2020";


		// Enter the Test case name
		TravelPage travelPage = new TravelPage(driver, mobileActionUtil);
		travelPage.testName(m.getName().toString());

		HomePage homePage = new HomePage(driver, mobileActionUtil);
		homePage.clickOnMoreIcon();
		travelPage.verifyFlightsFilterIsDisplayed();
		travelPage.verifyNavigationArrowIsDisplayed();
		travelPage.verifyFlightFilterTapable();
		travelPage.selectFlightFilter();
		SearchFlightsPage searchFlightsPage = new SearchFlightsPage(driver, mobileActionUtil);
		searchFlightsPage.validateFromTextBoxIsTappable();
		searchFlightsPage.clickOnFrom();
		searchFlightsPage.clickOnAirportSearch();
		searchFlightsPage.enterCityNameInSearch(enterText1);
		searchFlightsPage.selectFirstCity();
		searchFlightsPage.validateToTextBoxIsTappable();
		searchFlightsPage.clickOnTo();
		searchFlightsPage.clickOnAirportSearch();
		searchFlightsPage.enterCityNameInSearch(enterText2);
		searchFlightsPage.selectFirstCity();
		searchFlightsPage.clickOnTravellers();
		searchFlightsPage.increseAdultNumber();
		searchFlightsPage.clickOnDone();
		searchFlightsPage.verifySwapIconIsDisplayed();
		searchFlightsPage.validateSwapIconIsTappable();
		searchFlightsPage.verifySearchBtnIsDispalyed();
		searchFlightsPage.validateSerachBtnIsTappable();
		searchFlightsPage.validateClassLinkIsTappable();
		searchFlightsPage.verifyClassTextIsDispalyed("Economy");
		searchFlightsPage.clickOnSearch();
		FlightSearchPageOneWay flightSearchPageOneWay = new FlightSearchPageOneWay(driver, mobileActionUtil);
		flightSearchPageOneWay.verifyAllElementsDisplayedInOneWayRound();
		flightSearchPageOneWay.validateAllElementsIsTappableInOneWayRound();
		flightSearchPageOneWay.validateFirstFlightResultIsTappable();
		flightSearchPageOneWay.clickOnFirstFlightResult();
		FlightBookingPage flightBookingPage = new FlightBookingPage(driver, mobileActionUtil);
		flightBookingPage.verfiyAllElementFlightBookingPage();
		flightBookingPage.validateContinueButtonIsTappable();
		flightBookingPage.clickTobookflight();
		flightBookingPage.verifyPresenceOfRegisterName();
}
}
