package com.tyss.justdial.library;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.tyss.justdial.extentreports.ExtentTestManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class MobileActionUtil {

	AndroidDriver driver;
	ITestResult result;

	/**
	 * @description Initializing The MobileActionUtil Constructor With Driver
	 *              Instance
	 * @description
	 * @author Shobhan
	 * @param driver
	 */
	public MobileActionUtil(AndroidDriver driver) {
		this.driver = driver;
	}

	public String getScreenShot() {
		
		String screenShotName = "screenshot";
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		String destFile = System.getProperty("user.dir") + "/ScreenShots/" + screenShotName + dateName + ".png";
		File finalDestFile = new File(destFile);

		// Copy file at destination
		try {
			FileUtils.copyFile(srcFile, finalDestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}

	/**
	 * @author Shobhan
	 * @description Log Status : Info
	 * @param description
	 */
	public void info(String description) {
		ExtentTestManager.getTest().info(description);
		Reporter.log(description, true);
	}

	/**
	 * @author Shobhan
	 * @description Method to log results
	 * @param description
	 */
	public void pass(String description) {
		ExtentTestManager.getTest().pass(description);
		Reporter.log(description, true);
	}

	/**
	 * @author Shobhan
	 * @description Log Status : Fail
	 * @param description
	 */
	public void fail(String description) {

		try {
			String screenShotpath = getScreenShot();
			Reporter.log(description, true);
			ExtentTestManager.getTest().fail(description);
			ExtentTestManager.getTest().addScreenCaptureFromPath(screenShotpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Shobhan
	 * @description Log Status : Pass
	 * @param description
	 */

	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Step Failed" + result.getName());
			ExtentTestManager.getTest().log(Status.FAIL, "Test Step Failed" + result.getThrowable());
			String screenShotpath = getScreenShot();
			try {
				ExtentTestManager.getTest().addScreenCaptureFromPath(screenShotpath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

		}
	}

	/**
	 * @author Shobhan
	 * @description Getting Screenshot And Add To Report
	 * @param description
	 */
	public void getScreenshotAndAddToReport() {

		String screenShotpath = getScreenShot();
		try {
			ExtentTestManager.getTest().addScreenCaptureFromPath(screenShotpath);
			waitForElementToLoad(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Shobhan
	 * @description Get the Web Element Send the name Address of the element and
	 *              name of the locator
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */
	public WebElement getWebElement(String locatorType, String locatorValue) {

		try {
			By by = (By) By.class.getDeclaredMethod(locatorType, String.class).invoke(null, locatorValue);
			WebElement element = driver.findElement(by);
			return element;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author Shobhan
	 * @description Checking for Element Displayed
	 * @param element
	 * @return
	 */
	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * @author Shobhan
	 * @description Checking for Element Enabled
	 * @param element
	 * @return
	 */
	public Boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * @author Shobhan
	 * @description Checking for Element Enabled
	 * @param element
	 * @return
	 */
	public Boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	/**
	 * @author Shobhan
	 * @description Click On Mobile Element
	 * @param element
	 * @param elementName
	 */
	public void clickOnMobileElement(WebElement element, String elementName) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element)).click();

			pass("Clicking on the Element : " + elementName);
		} catch (Exception e1) {
			fail("Unable to click on the Element :" + elementName);
		}
	}

	/**
	 * @author Shobhan
	 * @description Enter the Text for WebElement
	 * @param element
	 * @param enterText
	 * @param elementName
	 */
	public void setText(WebElement element, String enterText, String elementName) {

		try {
			element.sendKeys(enterText);
			pass("Entering the " + enterText + " Text to the " + elementName);
		} catch (Exception e) {
			fail("Unable to enter the " + enterText + " Text to the " + elementName);
		}
	}

	/**
	 * @author Shobhan
	 * @description Enter the Text for List<WebElement>
	 * @param element
	 * @param enterText
	 * @param elementName
	 */
	public void setText(List<WebElement> element, String enterText, String elementName) {

		try {
			((WebElement) element).sendKeys(enterText);
			pass("Entering the " + enterText + " Text to the " + elementName);
		} catch (Exception e) {
			fail("Unable to enter the " + enterText + " Text to the " + elementName);
		}
	}

	/**
	 * @author Shobhan
	 * @description Clearing the Text in the Element
	 * @param element
	 * @param elementName
	 */
	public void textClear(WebElement element, String elementName) {

		element.clear();
		info("Text Clear Completed" + elementName);
	}

	/**
	 * @author Shobhan
	 * @description Press Back Navigation
	 */
	public void pressBack() {

		driver.pressKeyCode(AndroidKeyCode.BACK);
		info("press back navigation");
	}

	/**
	 * @author Shobhan
	 * @description Hide The Keyboard
	 */
	public void hideKeyboard() {

		try {
			info("Keyboard is already displayed");
			driver.hideKeyboard();
			pass("Hiding the Keyboard");

		} catch (Exception e) {
			fail("Unable to Hide the Keyboard");
		}
	}

	/**
	 * @author Shobhan
	 * @description open Notification
	 */
	public void openNotification() {

		info("Opening the Notification");
		try {
			driver.openNotifications();
			pass("Notification Opened");
		} catch (Exception e) {
			fail("unable to open the Notification");
		}

	}

	/**
	 * @author Shobhan
	 * @description Tap On Specified Location
	 * @param xCoordinate
	 * @param yCoordinate
	 */
	public void tapOnSpecifiedLocation(Integer xCoordinate, Integer yCoordinate) {

		info("Tap On Specified Location; x: " + xCoordinate + " y:" + yCoordinate);
		/*
		 * TouchAction action = new TouchAction(driver);
		 * action.tap(PointOption.point(xCoordinate, yCoordinate)).perform();
		 */
		driver.tap(1, xCoordinate, yCoordinate, 1000);

	}

	/**
	 * @author Shobhan
	 * @description Tap With Element
	 * @param element
	 * @param elementName
	 */
	public void tapWithElement(WebElement element, String elementName) {

		TouchActions action = new TouchActions(driver);
		try {
			action.singleTap(element).perform();
			pass("Clicking on the Element " + elementName);
		} catch (Exception e1) {
			fail("Unable to click on the Element " + elementName);
		}

	}

	/**
	 * @author Shobhan
	 * @description Swipe Action
	 * @param fromX
	 * @param fromY
	 * @param toX
	 * @param toY
	 */
	public void swipe(Integer fromX, Integer fromY, Integer toX, Integer toY) {

		info("swipe coordinates detail");
		/*
		 * TouchAction action = new TouchAction(driver);
		 * action.longPress(PointOption.point(fromX,
		 * fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
		 */
	}

	/**
	 * @author Shobhan
	 * @description Swipe Down
	 * @param fromX
	 * @param fromY
	 * @param toY
	 */
	public void swipeDown(Integer fromX, Integer fromY, Integer toY) {

		if (fromY < toY) {
			swipe(fromX, fromY, fromX, toY);
		} else {
			info("Coordinate value is wrong");
		}
	}

	/**
	 * @author Shobhan
	 * @description Swipe Up
	 * @param fromX
	 * @param fromY
	 * @param toY
	 */
	public void swipeUp(Integer fromX, Integer fromY, Integer toY) {

		if (fromY > toY) {
			swipe(fromX, fromY, fromX, toY);
		} else {
			info("Coordinate value is wrong ");
		}
	}

	/**
	 * @author Shobhan
	 * @description swipe Left To Right
	 * @param fromX
	 * @param fromY
	 * @param toX
	 */
	public void swipeLeftToRight(Integer fromX, Integer fromY, Integer toX) {

		if (fromX < toX) {
			swipe(fromX, fromY, toX, fromY);
		} else {
			info("Coordinate value is wrong ");
		}
	}

	/**
	 * @author Shobhan
	 * @description swipe Right To Left
	 * @param fromX
	 * @param fromY
	 * @param toX
	 */
	public void swipeRightToLeft(Integer fromX, Integer fromY, Integer toX) {

		info("swipeRightToLeft");
		if (fromX > toX) {
			swipe(fromX, fromY, toX, fromY);
		} else {
			info("Coordinate value is wrong ");
		}
	}

	/**
	 * @author Shobhan
	 * @description With Maximum scroll and mobile element
	 * @param fromX
	 * @param fromY
	 * @param toX
	 * @param toY
	 * @param mobElement
	 * @param maxScroll
	 *//*
		 * public void swipeToElement(int fromX, int fromY, int toX, int toY,
		 * WebElement mobElement, int maxScroll) {
		 * 
		 * { info("Swiping to element"); if (mobElement.isDisplayed()) {
		 * maxScroll = 0; } while (maxScroll != 0) { try { TouchAction action =
		 * new TouchAction(driver); action.longPress(PointOption.point(fromX,
		 * fromY)).moveTo(PointOption.point(toX, toY)).release() .perform();
		 * 
		 * } catch (Exception e) { info("Failed to swipe"); } maxScroll--;
		 * 
		 * if (mobElement.isDisplayed()) { break; } } } }
		 */

	/**
	 * @author Shobhan
	 * @description SingleTap
	 * @param element
	 */
	public void SingleTap(WebElement element) {

		TouchActions action = new TouchActions(driver);
		action.singleTap(element).perform();
		action.doubleTap(element).perform();
	}

	/**
	 * @author Shobhan
	 * @description doubleTap
	 * @param element
	 */
	public void doubleTap(WebElement element, String elementName) {

		TouchActions action = new TouchActions(driver);
		try {
			action.doubleTap(element).perform();
			pass("Clicking on the Element : " + elementName);
		} catch (Exception e) {
			pass("unable to click on the Element : " + elementName);
		}

	}

	/**
	 * @author Shobhan
	 * @description switchToView
	 */
	public void switchToView() {

		info("Switch To View");
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			if (contextName.contains("NATIVE_APP")) {
				driver.context(contextName);
			}
		}
	}

	/**
	 * @author Shobhan
	 * @description Wait Function
	 * @param sec
	 */
	public void waitForElementToLoad(int sec) {

		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Shobhan
	 * @description Wait For the Element
	 * @param element
	 * @param timeOutInSeconds
	 * @param elementName
	 */
	public void waitForElement(WebElement element, long timeOutInSeconds, String elementName) {

		info("Waiting For Element to Visible : " + elementName);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		info(elementName + " is Visible ");

	}

	@SuppressWarnings("deprecation")
	public WebElement visibilityWaitOfElement(long timeoutInSeconds, WebElement element) {
		return new FluentWait<AndroidDriver>(driver).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.SECONDS).ignoring(NotFoundException.class)
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * @author Shobhan
	 * @description Wait For Element to be Click-able
	 * @param element
	 * @param timeOutInSeconds
	 * @param elementName
	 */
	public void waitForElementClickable(WebElement element, long timeOutInSeconds, String elementName) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		info(elementName + " is Clickable ");
	}

	/**
	 * @author Shobhan
	 * @description Wait For Element to be Staleness
	 * @param element
	 * @param timeOutInSeconds
	 * @param elementName
	 */
	public void waitForElementStaleness(WebElement element, long timeOutInSeconds, String elementName) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	/**
	 * @author Shobhan
	 * @description UiScrollable Scroll Till Element
	 * @param text
	 */
	public void scrollTillElement(String text) {

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(" + "\\" + "\"" + text + "\\" + "\"" + "))");
	}

	/**
	 * @author Shobhan
	 * @description Check for The Element and Scroll
	 * @param element
	 */
	public void checkElementScroll(WebElement element) {

		try {
			if (element.isDisplayed()) {
			}
		} catch (Exception e) {
			swipeUp(578, 1475, 550);
		}
		try {
			if (element.isDisplayed()) {
			}
		} catch (Exception e) {
			checkElementScroll(element);
		}
	}

	/**
	 * @author Shobhan
	 * @description Get The Text From Element
	 * @param element
	 * @return
	 */
	public String getText(WebElement element) {

		String text = element.getText();
		info("Text is " + text);
		return text;
	}

	/**
	 * @author Shobhan
	 * @description Verify The Text
	 * @param element
	 * @param timeOutInSeconds
	 * @param expectedText
	 */
	public void verifyElementText(WebElement element, long timeOutInSeconds, String expectedText) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		String actualText = element.getText().toString();
		info("Actual Text is " + actualText);
		info("Expected Text is " + expectedText);
		Assert.assertEquals(actualText, expectedText);
		info(actualText + " is matching with " + expectedText);

	}

	/**
	 * @author Shobhan
	 * @description Verify The Text Contains
	 * @param element
	 * @param timeOutInSeconds
	 * @param expectedText
	 */
	public void verifyElementTextContains(WebElement element, long timeOutInSeconds, String expectedText) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		String actualText = element.getText().toString();
		info("Actual Text is " + actualText);
		info("Expected Text is " + expectedText);
		if (actualText.contains(expectedText)) {
			info(actualText + " contains " + expectedText);
		} else {
			info(actualText + " DO NOT contains " + expectedText);
			Assert.fail();
		}

	}

	/**
	 * @author Shobhan
	 * @description Verify The Text
	 * @param actualText
	 * @param expectedText
	 */
	public void verifyText(String actualText, String expectedText) {

		info("Actual Text is " + actualText);
		info("Expected Text is " + expectedText);
		Assert.assertEquals(actualText, expectedText);
		info(actualText + " is matching with " + expectedText);
	}

	/**
	 * @author Shobhan
	 * @description Verify Element Is Displayed
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param elementName
	 */
	public void verifyElementIsDisplayed(WebElement element, long timeOutInSeconds, String elementName) {

		info("Verifying whether the element: " + elementName + " isDisplayed");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			info("Specified Element is Displayed ");
		} catch (Exception e) {
			info("Specified Element is NOT Displayed ");
		}
	}

	/**
	 * @author Shobhan
	 * @description Verify Element Is Not Displayed
	 * @param element
	 * @param timeOutInSeconds
	 * @param elementName
	 */
	public void verifyElementIsNotDisplayed(WebElement element, Integer timeOutInSeconds, String elementName) {

		info("Verifying whether the element: " + elementName + " is NOT Displayed");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try {
		
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));
			info("Specified Element is NOT Displayed ");
		} catch (Exception e) {
			info("Specified Element is Displayed ");
		}
	}

	/**
	 * @author Shobhan
	 * @description Click Check Box
	 * @param element
	 * @param elementname
	 */
	public void clickCheckBox(WebElement element, String elementname) {

		if (element.isSelected()) {
			info("The CheckBox is Clicked ");
		} else {
			info("Click on CheckBox ");
			element.click();
			info("The CheckBox is Clicked ");
		}
	}

	/**
	 * @author Shobhan
	 * @description Get the Next Day date
	 * @return
	 */
	public String getTomorrowDate() {
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 1);
		return new SimpleDateFormat(" MM/dd/yyyy").format(cal.getTime());
	}

	/**
	 * @author Shobhan
	 * @description Get the Today's date
	 * @return
	 */
	public String getTodayDate() {
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 0);
		return new SimpleDateFormat(" MM/dd/yyyy").format(cal.getTime());
	}

	/**
	 * @author Shreya
	 * @description Tap on Element Using the coordinates
	 * @return
	 */
	public void tapOnElementUsingCoordinate(int xOffset, int yOffset) {
		driver.tap(1, xOffset, yOffset, 1000);
	}

	/**
	 * @author Sunil.S
	 * @description Method to tap on element using touch action class based on
	 *              co-ordinates
	 * @param ele
	 */
	public void tapOnElement(WebElement ele) {
		driver.tap(1, ele, 1000);
	}

	
	public void isClickable(WebElement element, long timeOutInSeconds)      
	{
	    try
	    {
	        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        pass("Element is clickable"+element);
	        
	    }
	    catch (Exception e)
	    {
	        fail("Element is not clickable");
	       
	    }
	}
	

	/**
	 * Description: This method to scroll Up side based on device height and
	 * width
	 * 
	 * @param value
	 * @param driver
	 * @param starty1
	 * @param endy1
	 * @throws Exception
	 */

	public static void swipeBottomToTop(int value, AppiumDriver driver, double starty1, double endy1) throws Exception {
		try {
			Thread.sleep(1000);
			System.out.println("inside swipe");
			for (int i = 1; i <= value; i++) {
				Dimension dSize = driver.manage().window().getSize();
				int starty = (int) (dSize.height * starty1);
				int endy = ((int) (dSize.height * endy1));
				int startx = dSize.width / 2;
				driver.swipe(startx, starty, startx, endy, 1000);
			}
		} catch (Exception e) {

			throw e;
		}
	}

	/**
	 * Description: This method to scroll Bottom side based on device height and
	 * width
	 * 
	 * @param value
	 * @param driver
	 * @param starty1
	 * @param endy1
	 * @throws Exception
	 */
	public static void swipeTopToBottom(int value, AppiumDriver driver, double starty1, double endy1) throws Exception {
		try {
			Thread.sleep(1000);

			System.out.println("inside swipe");
			for (int i = 1; i <= value; i++) {
				Dimension dSize = driver.manage().window().getSize();
				int starty = (int) (dSize.height * starty1);
				int endy = (int) (dSize.height * endy1);
				int startx = dSize.width / 2;
				driver.swipe(startx, starty, startx, endy, 1000);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * Description: Method for Scrolling to particular element based on
	 * direction and device size
	 * 
	 * @param maxScroll
	 * @param start
	 * @param end
	 * @param scrollType
	 * @param element
	 * @param driver
	 * @throws Exception
	 */
	public static void scrollToElement(int maxScroll, double start, double end, String scrollType, WebElement element,
			AppiumDriver driver) throws Exception {

		while (maxScroll != 0) {
			try {
				if (element.isDisplayed()) {
					maxScroll++;
					break;
				}
			} catch (Exception e) {
				switch (scrollType.toUpperCase()) {
				case ("DOWN"):
					swipeTopToBottom(1, driver, start, end);
					break;

				case ("UP"):
					swipeBottomToTop(1, driver, start, end);
					break;

				case ("LEFT"):
					swipeRightToLeft(1, start, end, driver);
					break;

				case ("RIGHT"):
					swipeLefToRight(1, start, end, driver);
					break;

				default:
					System.out.println("Invalid Swipe type");

					break;

				}

			}
			maxScroll--;
		}
	}

	/**
	 * 
	 * Description: This method to scroll left side based on device height and
	 * width
	 * 
	 * @param value
	 * @param startX
	 * @param endX
	 * @param driver
	 * @throws Exception
	 */

	public static void swipeRightToLeft(int value, double startX, double endX, AppiumDriver driver) throws Exception {
		try {
			Thread.sleep(1000);
			System.out.println("inside swipe");
			for (int i = 1; i <= value; i++) {
				Dimension dSize = driver.manage().window().getSize();
				int startx = (int) (dSize.width * startX);
				int endx = (int) (dSize.width * endX);
				int starty = dSize.height / 2;
				driver.swipe(startx, starty, endx, starty, 1000);

			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Description: This method to scroll Right side based on device height and
	 * width
	 * 
	 * @param value
	 * @param startx
	 * @param endx
	 * @param driver
	 * @throws Exception
	 */
	public static void swipeLefToRight(int value, double startx, double endx, AppiumDriver driver) throws Exception {
		try {
			Thread.sleep(1000);
			System.out.println("inside swipe");
			for (int i = 1; i <= value; i++) {
				Dimension dSize = driver.manage().window().getSize();
				int startX = (int) (dSize.width * startx);
				int endX = (int) (dSize.width * endx);
				int starty = dSize.height / 2;
				driver.swipe(startX, starty, endX, starty, 1000);
			}
		} catch (Exception e) {
			throw e;

		}
	}

}