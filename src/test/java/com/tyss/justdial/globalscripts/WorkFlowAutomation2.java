package com.tyss.justdial.globalscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.library.ExcelLibrary;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class WorkFlowAutomation extends BaseTest {

	ExcelLibrary excelLibrary = new ExcelLibrary();

	@DataProvider
	public Integer[][] getData() {

		int row = new ExcelLibrary().getExcelRowCount(XL_TESTPATH, "Scenarios");

		Integer[][] data = new Integer[row][1];
		for (int i = 1; i <= row; i++) {
			data[i - 1][0] = i;
		}
		return data;
	}

	/**
	 * @description Method to fetch the testData from the Excel File  
	 * @param index
	 */
	@Test(dataProvider = "getData")
	public void runTest(int index) {

		navigateToSearchPage();
		ExcelLibrary excelLibrary = new ExcelLibrary();
		System.out.println("Index :" + index);
		int column = excelLibrary.getExcelCellCount(XL_TESTPATH, "Scenarios", index);
		for (int j = 1; j < column; j++) {
			String xlData = excelLibrary.getExcelData(XL_TESTPATH, "Scenarios", index, j);
			System.out.println("XLData:" + xlData);

			System.out.println(xlData.split(":")[0].toString().trim());
			String functionName = xlData.split(":")[0].toString().trim();

			System.out.println(xlData.split(":")[1].toString().trim());
			String functionArg = xlData.split(":")[1].toString().trim();

			callFunction(functionName, functionArg);
		}

	}

	/**
	 * @description Selecting the required method
	 * @param functionName
	 * @param functionArg
	 */
	public void callFunction(String functionName, String functionArg) {

		switch (functionName) {

		case "Search":
			System.out.println("Calling search function");
			search(driver, functionArg);
			break;

		case "SelectOption":
			System.out.println("Calling SelectOption function");
			selectOption(driver, functionArg);
			break;

		case "VerifyAlsoListedIn":
			System.out.println("Calling VerifyAlsoListedIn function");
			verifyAlsoListedIn(driver, functionArg);
			break;

		case "VerifyPhoneNumber":
			System.out.println("Calling VerifyPhoneNumber function");
			verifyPhoneNumber(driver, functionArg);
			break;
		case "VerifySearchPageIsDisplayed":
			System.out.println("Calling VerifySearchPageIsDisplayed function");
			verifySearchPageIsDisplayed(driver, functionArg);
			break;

		}
	}

	/**
	 * @description Method to Navigate to the Search Page 
	 */
	public void navigateToSearchPage() {

		WebElement agreeAndContinue = driver.findElement(By.id("com.justdial.search:id/terms_accept_btn"));
		isElementDisplayed(agreeAndContinue);
		agreeAndContinue.click();
		System.out.println("click on agree And Continue ");

		WebElement noneOfTheAbove = driver.findElement(By.id("com.google.android.gms:id/cancel"));
		try {
			if (isElementDisplayed(noneOfTheAbove)) {
				noneOfTheAbove.click();
				System.out.println("click on none Of The Above ");
			}
		} catch (Exception e) {
			System.out.println("None Of The Above : ELEMENT NOT FOUND");
		}

		WebElement maybeLater = driver.findElement(By.id("com.justdial.search:id/button_skip"));
		isElementDisplayed(maybeLater);
		maybeLater.click();
		System.out.println("click on may be Later");

		WebElement namasteElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Namaste']"));
		waitforElement(driver, namasteElement);
		if (isElementDisplayed(namasteElement)) {
			namasteElement.click();
			driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		} else {

		}

	}

	/**
	 * @description Method to Search 
	 * @param driver
	 * @param optionToSearh
	 */
	public void search(AndroidDriver driver, String optionToSearh) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		swipe(500, 600, 500, 800);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.MultiAutoCompleteTextView")));
			WebElement searchElement1 = driver.findElement(By.className("android.widget.MultiAutoCompleteTextView"));
			searchElement1.click();
			
		} catch (Exception e) {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("com.justdial.search:id/search_edit_text_home")));
			WebElement searchElement2 = driver.findElement(By.id("com.justdial.search:id/search_edit_text_home"));
			searchElement2.click();
			
		}
		WebElement selectLocationDrpDwn = driver.findElement(By.xpath("(//android.widget.ImageView)[2]/../..//android.widget.TextView"));
		selectLocationDrpDwn.click();
		WebElement selectLocation = driver.findElement(By.id("com.justdial.search:id/widget_near_me_home"));
		selectLocation.click();

		driver.findElement(By.className("android.widget.MultiAutoCompleteTextView")).click();
		driver.findElement(By.className("android.widget.MultiAutoCompleteTextView")).sendKeys(optionToSearh);
		driver.hideKeyboard();
	}

	/**
	 * @description Method to select the Option
	 * 				from the Xpath
	 * @param driver
	 * @param optionToSelect
	 */
	public void selectOption(AndroidDriver driver, String optionToSelect) {
		String xp = "//android.widget.TextView[@text='" + optionToSelect + "']";
		driver.findElement(By.xpath(xp)).click();
	}

	/**
	 * @description Method to  verify Also Listed In
	 * @param driver
	 * @param expectedText
	 */
	public void verifyAlsoListedIn(AndroidDriver driver, String expectedText) {
		WebElement touristAttractionElement = driver.findElement(By.id("com.justdial.search:id/quick_text_leftColumnChild"));
		swipe(578, 1475, 578, 550);
		swipe(578, 1475, 578, 550);
		swipe(578, 1475, 578, 550);
		swipe(578, 1475, 578, 550);
		swipe(578, 1475, 578, 550);
		checkElementScroll(touristAttractionElement);	
		verifyElementText(touristAttractionElement, 5, expectedText);
	}

	/**
	 * @description Method to verify the Phone Number
	 * @param driver
	 * @param expectedText
	 */
	public void verifyPhoneNumber(AndroidDriver driver, String expectedText) {
		System.out.println("//android.widget.TextView[contains(@text,'" + expectedText + "')]");
		WebElement ph = driver
				.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + expectedText + "')]"));
		swipe(578, 1475, 578, 550);
		swipe(578, 1475, 578, 550);
		swipe(578, 1475, 578, 550);
		checkElementScroll(ph);
		verifyElementTextContains(ph, 5, expectedText);
	}

	/**
	 * @description Method to Verify the Search Page Is Displayed
	 * @param driver
	 * @param expectedText
	 */
	public void verifySearchPageIsDisplayed(AndroidDriver driver, String expectedText) {

		try {
			WebElement search = driver.findElement(By.xpath("//android.widget.TextView[@text='Search']"));
			waitforElement(driver, search);

			if (search.isDisplayed()) {
				System.out.println("Search Page Is Displayed");
			} else {

			}
		} catch (Exception e) {
			System.out.println("Search Page Is Not  Displayed");
		}

	}
	// ----------------------------------------------------------------------------------------------

	/**
	 * @description Method for wait for an element
	 * @param driver
	 * @param element
	 */
	public void waitforElement(AndroidDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		System.out.println("Waitinf for the element :" + element);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println(" element visible  " + element);
		} catch (Exception e) {
			System.out.println(" element not visible  " + element);
		}

	}

	/**
	 * @description Method the Swipe -Action
	 * @param fromX
	 * @param fromY
	 * @param toX
	 * @param toY
	 */
	public void swipe(Integer fromX, Integer fromY, Integer toX, Integer toY) {
		TouchAction action = new TouchAction(driver);
		System.out.println("swipe");
		action.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
	}

	/**
	 * @description Check Element and Scroll
	 * @param element
	 */
	public void checkElementScroll(WebElement element) {
		try {
			if (element.isDisplayed()) {
			}
		} catch (Exception e) {
			swipe(578, 1475, 578, 550);
		}
		try {
			if (element.isDisplayed()) {
			}
		} catch (Exception e) {
			checkElementScroll(element);
		}
	}

	/**
	 * @description Method Verify the Element Text
	 * @param element
	 * @param timeOutInSeconds
	 * @param expectedText
	 */
	public void verifyElementText(WebElement element, long timeOutInSeconds, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		String actualText = element.getText().toString();
		System.out.println("Actual Text is " + actualText);
		System.out.println("Expected Text is " + expectedText);
		Assert.assertEquals(actualText, expectedText);
		System.out.println(actualText + " is Matching with " + expectedText);

	}

	/**
	 * @description Method Verify the Element Contains Text
	 * @param element
	 * @param timeOutInSeconds
	 * @param expectedText
	 */
	public void verifyElementTextContains(WebElement element, long timeOutInSeconds, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		String actualText = element.getText().toString();
		System.out.println("Actual Text is " + actualText);
		System.out.println("Expected Text is " + expectedText);
		if (actualText.contains(expectedText)) {
			System.out.println(actualText + " Contains " + expectedText);
		} else {
			System.out.println(actualText + " DO NOT contains " + expectedText);
			Assert.fail();
		}
	}

	/**
	 * @description Method to Check element is displayed
	 * @param element
	 * @return
	 */
	public Boolean isElementDisplayed(WebElement element) {

		boolean flag = false;
		if (element.isDisplayed()) {
			System.out.println("Element Displayed " + element);
			flag = true;
		} else {
			System.out.println("Element is Not Displayed " + element);
		}
		return flag;
	}

}
