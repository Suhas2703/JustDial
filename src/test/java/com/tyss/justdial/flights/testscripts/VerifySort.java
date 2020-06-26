package com.tyss.justdial.flights.testscripts;

import java.lang.reflect.Method;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.homepage.travel.TravelPage;
import com.tyss.justdial.pages.homepage.travel.flights.SearchFlightsPage;

import io.appium.java_client.android.AndroidKeyCode;

/**
 *
 * @author Shobhan
 * 
 *
 */
public class VerifySort extends BaseTest {

	@Test(description = "searchFlight")
	public void searchFlight(Method m) throws InterruptedException, ParseException {

		/* Fetch the Test Data from Excel File */
//		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "", 76, 1);
		String enterText1 = "Mumbai";
		String enterText2 = "Goa";
		String expectedText1 = "Mumbai BOM";
		String expectedText2 = "Goa GOI ";
		String expectedText3 = "WED, 5th Feb 2020";
		String date = "2020-07-05";

		// Enter the Test case name
		TravelPage travelPage = new TravelPage(driver, mobileActionUtil);
		travelPage.testName(m.getName().toString());

		HomePage homePage = new HomePage(driver, mobileActionUtil);
		homePage.clickOnTravelHotSearchKey();

		travelPage.selectFlightFilter();
		SearchFlightsPage searchFlightsPage = new SearchFlightsPage(driver, mobileActionUtil);

		/*
		 *
		 * 
		 * searchFlightsPage.clickOnFrom();
		 * 
		 * searchFlightsPage.clickOnAirportSearch();
		 * searchFlightsPage.enterCityNameInSearch(enterText1);
		 * searchFlightsPage.selectFirstCity();
		 * 
		 * searchFlightsPage.clickOnTo();
		 * 
		 * searchFlightsPage.clickOnAirportSearch();
		 * searchFlightsPage.enterCityNameInSearch(enterText2);
		 * searchFlightsPage.selectFirstCity();
		 * 
		 * 
		 * searchFlightsPage.clickOnDepature();
		 * searchFlightsPage.selectDepartureDate(date);
		 * 
		 * 
		 * // Call select Date method
		 * 
		 * searchFlightsPage.clickOnTravellers();
		 * searchFlightsPage.increseAdultNumber();
		 * 
		 * 
		 * searchFlightsPage.clickOnDone();
		 * 
		 * searchFlightsPage.verifyFirstprompt(expectedText1, expectedText2,
		 * expectedText3);
		 */

		searchFlightsPage.clickOnSearch();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByRateAscending();
		driver.findElement(By.xpath("//android.view.View[ @resource-id=\"priceSort\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByRateDescending();

		Thread.sleep(4000l);
		driver.findElement(By.xpath("//android.view.View[ @resource-id=\"durationSort\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByDurationAscending();
		driver.findElement(By.xpath("//android.view.View[ @resource-id=\"durationSort\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByDurationDescending();

		driver.findElement(By.xpath("//android.view.View[ @resource-id=\"departSort\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByTimeAscending();

		driver.findElement(By.xpath("//android.view.View[ @resource-id=\"departSort\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByTimeDescending();

		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(3000l);

		searchFlightsPage.clickOnRoundTripIcon();
		Thread.sleep(4000l);
		searchFlightsPage.clickOnSearch();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByRateAscending_RoundTrip_Dep();
		Thread.sleep(4000l);
		driver.findElement(By.xpath("//android.view.View[ @resource-id=\"priceSortL\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByRateDescending_RoundTrip_Dep();

		Thread.sleep(4000l);
		driver.findElement(By.xpath("//android.view.View[@resource-id=\"departSortL\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByTimeAscending_RoundTrip_Dep();
		Thread.sleep(4000l);
		driver.findElement(By.xpath("//android.view.View[@resource-id=\"departSortL\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByTimeDescending_RoundTrip_Dep();

		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByRateAscending_RoundTrip_Return();

		driver.findElement(By.xpath("//android.view.View[ @resource-id=\"priceSortR\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByRateDescending_RoundTrip_Return();

		driver.findElement(By.xpath("//android.view.View[@resource-id=\"departSortR\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByTimeAscending_RoundTrip_Return();

		driver.findElement(By.xpath("//android.view.View[@resource-id=\"departSortR\"]")).click();
		Thread.sleep(4000l);
		searchFlightsPage.validateIfFlightsAreSortedByTimeDescending_RoundTrip_Return();

	}
}
