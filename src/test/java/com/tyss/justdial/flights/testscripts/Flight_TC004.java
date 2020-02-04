package com.tyss.justdial.flights.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.homepage.travel.TravelPage;

public class Flight_TC004  extends BaseTest {
	@Test
	public void testcase4(Method m) {

		/* Fetch the Test Data from Excel File */
		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "", 76, 1);
		
		TravelPage travelPage = new TravelPage(driver, mobileActionUtil);
		travelPage.testName(m.getName().toString());		

	}
}
