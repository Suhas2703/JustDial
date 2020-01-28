package com.tyss.justdial.library;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.tyss.justdial.extentreports.ExtentTestManager;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class MobileActionUtil {

	AndroidDriver driver;

	/**
	 * Initializing The MobileActionUtil Constructor With Driver Instance
	 * 
	 * @param driver
	 */
	public MobileActionUtil(AndroidDriver driver) {
		this.driver = driver;
	}

	/**
	 * Log Status : Pass
	 * 
	 * @param description
	 */

	public void pass(String description) {
		ExtentTestManager.getTest().pass(description);
		Reporter.log(description, true);
	}

	/**
	 * Log Status : Fail
	 * 
	 * @param description
	 */
	public void fail(String description) {
		ExtentTestManager.getTest().fail(description);
		Reporter.log(description, true);
	}

	/**
	 * Log Status : Info
	 * 
	 * @param description
	 */
	public void info(String description) {
		ExtentTestManager.getTest().info(description);
		Reporter.log(description, true);
	}

	/**
	 * Get the Web Element Send the name Address of the element and name of the
	 * locator
	 * 
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
	 * Checking for Element Displayed
	 * 
	 * @param element
	 * @return
	 */
	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * Checking for Element Enabled
	 * 
	 * @param element
	 * @return
	 */
	public Boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * Checking for Element Selected
	 * 
	 * @param element
	 * @return
	 */
	public Boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	/**
	 * Click On Mobile Element
	 * 
	 * @param element
	 * @param elementName
	 */
	public void clickOnMobileElement(WebElement element, String elementName) {
		try {
			element.click();
			pass("Clicking on the Element : " + elementName);
		} catch (Exception e1) {
			fail("Unable to click on the Element :" + elementName);
		}
	}

	/**
	 * Click On Element
	 * 
	 * @param element
	 * @param elementName
	 */
	public void clickOnElement(WebElement element, String elementName) {
		element.click();
		info("Clicking On Element " + elementName);
	}

	/**
	 * Enter the Text for WebElement
	 * 
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
	 * Enter the Text for List<WebElement>
	 * 
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
	 * Clearing the Text in the Element
	 * 
	 * @param element
	 * @param elementName
	 */
	public void textClear(WebElement element, String elementName) {
		element.clear();
		info("Text Clear Completed" + elementName);
	}

	/**
	 * Press Back Navigation
	 */
	public void pressBack() {
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		info("press back navigation");
	}

	/**
	 * Hide The Keyboard
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
	 * open Notification
	 */
	public void openNotification() {
		info("Opening the Notification");
		driver.openNotifications();
	}

	/**
	 * Tap On Specified Location
	 * 
	 * @param xCoordinate
	 * @param yCoordinate
	 */
	public void tapOnSpecifiedLocation(Integer xCoordinate, Integer yCoordinate) {
		info("Tap On Specified Location; x: " + xCoordinate + " y:" + yCoordinate);
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(xCoordinate, yCoordinate)).perform();

	}

	/**
	 * Tap With Element
	 * 
	 * @param element
	 * @param elementName
	 */
	public void tapWithElement(WebElement element, String elementName) {

		TouchActions action = new TouchActions(driver);
		try {

			action.singleTap(element).perform();
			pass("Clicking on the Element " + elementName);
		} catch (Exception e1) {
			/*
			 * try { element.click(); } catch (Exception e2) {
			 */
			fail("Unable to click on the Element " + elementName);
			// }
		}

	}

	/**
	 * swipe
	 * 
	 * @param fromX
	 * @param fromY
	 * @param toX
	 * @param toY
	 */
	public void swipe(Integer fromX, Integer fromY, Integer toX, Integer toY) {

		info("swipe coordinates detail");
		/*
		 * info("From X:" + fromX); info("From Y:" + fromY); info("To X:" +
		 * toX); info("To Y:" + toY);
		 */
		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
	}

	/**
	 * swipeDown
	 * 
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
	 * swipeUp
	 * 
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
	 * swipe Left To Right
	 * 
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
	 * swipe Right To Left
	 * 
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
	 * With Maximum scroll and mobile element
	 * 
	 * @param fromX
	 * @param fromY
	 * @param toX
	 * @param toY
	 * @param mobElement
	 * @param maxScroll
	 */
	public void swipeToElement(int fromX, int fromY, int toX, int toY, WebElement mobElement, int maxScroll) {
		{
			info("Swiping to element");
			if (mobElement.isDisplayed()) {
				maxScroll = 0;
			}
			while (maxScroll != 0) {
				try {
					TouchAction action = new TouchAction(driver);
					action.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release()
							.perform();

				} catch (Exception e) {
					info("Failed to swipe");
				}
				maxScroll--;

				if (mobElement.isDisplayed()) {
					break;
				}
			}
		}
	}

	/**
	 * SingleTap
	 * 
	 * @param element
	 */
	public void SingleTap(WebElement element) {
		TouchActions action = new TouchActions(driver);
		action.singleTap(element).perform();
	}

	/**
	 * switchToView
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
	 * Wait Function
	 * 
	 * @param sec
	 */
	public void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wait For the Element
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param elementName
	 */
	public void waitForElement(WebElement element, long timeOutInSeconds, String elementName) {
		info("Waiting For Element to Visible : " + elementName);
		/*
		 * Wait<AndroidDriver> wait = new
		 * FluentWait<AndroidDriver>(driver).withTimeout(seconds,
		 * TimeUnit.SECONDS) .pollingEvery(250,
		 * TimeUnit.MICROSECONDS).ignoring(NoSuchElementException.class);
		 */
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		info(elementName + " is Visible ");

	}

	@SuppressWarnings("deprecation")
	public WebElement visibilityWaitOfElement(long timeoutInSeconds, WebElement element) {
		return new FluentWait<AndroidDriver>(driver).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.SECONDS).ignoring(NotFoundException.class)
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));
		// ignoring(NotFoundException.class).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * Wait For Element to be Click-able
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param elementName
	 */
	public void waitForElementClickable(WebElement element, long timeOutInSeconds, String elementName) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		info(elementName + " is Clickable ");
	}

	/*
	 *
	 */
	/**
	 * Wait For Element to be Staleness
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param elementName
	 */
	public void waitForElementStaleness(WebElement element, long timeOutInSeconds, String elementName) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	/**
	 * UiScrollable Scroll Till Element
	 * 
	 * @param text
	 */
	public void scrollTillElement(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(" + "\\" + "\"" + text + "\\" + "\"" + "))");
	}

	/**
	 * Check for The Element and Scroll
	 * 
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
	 * Get The Text From Element
	 * 
	 * @param element
	 * @return
	 */
	public String getText(WebElement element) {
		String text = element.getText();
		info("Text is " + text);
		return text;
	}

	/**
	 * Verify The Text
	 * 
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
	 * Verify The Text
	 * 
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
	 * Verify Element Is Displayed
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
	 * Verify Element Is Not Displayed
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param elementName
	 */
	public void verifyElementIsNotDisplayed(WebElement element, Integer timeOutInSeconds, String elementName) {
		info("Verifying whether the element: " + elementName + " is NOT Displayed");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			info("Specified Element is NOT Displayed ");
		} catch (Exception e) {
			info("Specified Element is Displayed ");
		}
	}

	/**
	 * Click Check Box
	 * 
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
	 * Get the Next Day date
	 * 
	 * @return
	 */
	public String getTomorrowDate() {
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 1);
		return new SimpleDateFormat(" MM/dd/yyyy").format(cal.getTime());
	}

	/**
	 * Get the Today's date
	 * 
	 * @return
	 */
	public String getTodayDate() {
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 0);
		return new SimpleDateFormat(" MM/dd/yyyy").format(cal.getTime());
	}

}