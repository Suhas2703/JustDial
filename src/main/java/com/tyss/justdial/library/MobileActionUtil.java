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
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class MobileActionUtil {

	AndroidDriver driver;

	public MobileActionUtil(AndroidDriver driver) {
		this.driver = driver;
	}

	public void pass(String description) {
		ExtentTestManager.getTest().pass(description);
		Reporter.log(description, true);
	}

	public void fail(String description) {
		ExtentTestManager.getTest().fail(description);
		Reporter.log(description, true);

	}

	public void info(String description) {
		ExtentTestManager.getTest().info(description);
		Reporter.log(description, true);
	}

	public void pressBack() {

		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		info("press back navigation");
	}

	/* Get the Web Element */
	/* Send the name Address of the element and name of the locator */
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

	public void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnMobileElement(WebElement element, String elementName) {
		try {
			element.click();
			pass("Clicking on the Element : " + elementName);
		} catch (Exception e1) {
			fail("Unable to click on the Element :" + elementName);
		}
	}
	
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

	public void tapOnSpecifiedLocation(Integer xCoordinate, Integer yCoordinate) {
		info("Tap On Specified Location; x: " + xCoordinate + " y:" + yCoordinate);
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(xCoordinate, yCoordinate)).perform();

	}

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

	public void setText(WebElement element, String enterText, String elementName) {
		try {
			element.sendKeys(enterText);
			pass("Entering the " + enterText + " Text to the " + elementName);
		} catch (Exception e) {
			fail("Unable to enter the " + enterText + " Text to the " + elementName);
		}
	}

	public void setText(List<WebElement> element, String enterText, String elementName) {
		try {
			((WebElement) element).sendKeys(enterText);
			pass("Entering the " + enterText + " Text to the " + elementName);
		} catch (Exception e) {
			fail("Unable to enter the " + enterText + " Text to the " + elementName);
		}
	}

	public void textClear(WebElement element, String elementName) {
		element.clear();
		info("Text Clear Completed" + elementName);
	}

	public void swipe(Integer fromX, Integer fromY, Integer toX, Integer toY) {

		info("swipe coordinates detail");
		/*
		 * info("From X:" + fromX); info("From Y:" + fromY); info("To X:" + toX);
		 * info("To Y:" + toY);
		 */
		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
	}

	public void swipeDown(Integer fromX, Integer fromY, Integer toY) {
		if (fromY < toY) {
			swipe(fromX, fromY, fromX, toY);
		} else {
			info("Coordinate value is wrong");
		}
	}

	public void swipeUp(Integer fromX, Integer fromY, Integer toY) {
		if (fromY > toY) {
			swipe(fromX, fromY, fromX, toY);
		} else {
			info("Coordinate value is wrong ");
		}
	}

	public void swipeLeftToRight(Integer fromX, Integer fromY, Integer toX) {
		if (fromX < toX) {
			swipe(fromX, fromY, toX, fromY);
		} else {
			info("Coordinate value is wrong ");
		}
	}

	public void swipeRightToLeft(Integer fromX, Integer fromY, Integer toX) {
		info("swipeRightToLeft");
		if (fromX > toX) {
			swipe(fromX, fromY, toX, fromY);
		} else {
			info("Coordinate value is wrong ");
		}
	}

	// With Maximum scroll and mobile element
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

	public void hideKeyboard() {
		try {
			info("Keyboard is already displayed");
			driver.hideKeyboard();
			pass("Hiding the Keyboard");

		} catch (Exception e) {
			fail("Unable to Hide the Keyboard");
		}
	}
	
	public void SingleTap(WebElement element) 
	{
		TouchActions action = new TouchActions(driver);
		action.singleTap(element).perform();
	}

	public void switchToView() {
		info("Switch To View");
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			if (contextName.contains("NATIVE_APP")) {
				driver.context(contextName);
			}
		}
	}

	public void openNotification() {
		info("Opening the Notification");
		driver.openNotifications();
	}

	public String getText(WebElement element) {
		String text = element.getText();
		info("Text is " + text);
		return text;
	}

	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public Boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public Boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public void waitForElement(WebElement element, long timeOutInSeconds, String elementName) {
		info("Waiting For Element to Visible : " + elementName);
		/*
		 * Wait<AndroidDriver> wait = new
		 * FluentWait<AndroidDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
		 * .pollingEvery(250,
		 * TimeUnit.MICROSECONDS).ignoring(NoSuchElementException.class);
		 */
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		info(elementName + " is Visible ");

	}

	@SuppressWarnings("deprecation")
	public WebElement visibilityWaitOfElement(int timeoutInSeconds, WebElement element) {
		return new FluentWait<AndroidDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.SECONDS)
				.ignoring(NotFoundException.class).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(element));
		// ignoring(NotFoundException.class).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForElementClickable(WebElement element, long timeOutInSeconds, String elementName) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		info(elementName + " is Clickable ");
	}

	public void clickCheckBox(WebElement element, String elementname) {

		if (element.isSelected()) {
			info("The CheckBox is Clicked ");
		} else {
			info("Click on CheckBox ");
			element.click();
			info("The CheckBox is Clicked ");
		}
	}

	public String getTomorrow() {
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 1);
		return new SimpleDateFormat(" MM/dd/yyyy").format(cal.getTime());
	}

	//////////////////////////////////
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

	/* verify Element Is Not Displayed */
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

	/* Verify the Text */
	public void verifyElementText(WebElement element, long timeOutInSeconds, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		String actualText = element.getText().toString();
		info("Actual Text is " + actualText);
		info("Expected Text is " + expectedText);
		Assert.assertEquals(actualText, expectedText);
		info(actualText + " is matching with " + expectedText);
	}

	/* Verify the Text */
	public void verifyText(String actualText, String expectedText) {
		info("Actual Text is " + actualText);
		info("Expected Text is " + expectedText);
		Assert.assertEquals(actualText, expectedText);
		info(actualText + " is matching with " + expectedText);
	}

	public void scrollTillElement(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(" + "\\" + "\"" + text + "\\" + "\"" + "))");
	}

	public void clickOnElement(WebElement element, String elementName) {
		element.click();

		info("Clicking On Element " + elementName);
	}
}