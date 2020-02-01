package com.tyss.justdial.globalscripts;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BrowserStackAndroid extends BaseTest {

	public static String userName = "shreyau1";
	public static String accessKey = "oEUhApyGPx6ss5XVrLKJ";

	@Test
	public void browserStackTest(Method m) throws InterruptedException {

		/* Fetch the Test Data from Excel File */
		String enterText = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 1);
		String expText1 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 2);
		String expText2 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 3);
		String expText3 = ExcelLibrary.getExcelData(XL_TESTPATH, "Sheet1", 79, 4);

		/* Click On Agree and Continue Button */
		LoginPage loginPage = new LoginPage(driver, mobileActionUtil);
		loginPage.clickOnAgreeAndContinueButton();

		/* Click On May Be Later Link */
		loginPage.clickOnMayBeLaterLink();

		/*
		 * Click On Allow Button clickOnAllowButton();
		 */

		List<WebElement> hotkeyImgIcon = driver.findElements(By.id("com.justdial.search:id/hotkeyimage"));

		Thread.sleep(8000);
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(hotkeyImgIcon.get(1).getLocation().x, hotkeyImgIcon.get(1).getLocation().y))
				.waitAction().release();

		// mobileActionUtil.swipe(500, 600, 500, 700);
	//	driver.findElement(By.xpath("//android.widget.TextView[@text='Travel']")).click();
		action.tap(PointOption.point(hotkeyImgIcon.get(1).getLocation().x, hotkeyImgIcon.get(1).getLocation().y))
		.waitAction().release();

		Thread.sleep(6000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Flights']")).click();

		Thread.sleep(6000);

		driver.findElement(By.id("com.justdial.search:id/from_city")).click();

		Thread.sleep(6000);

		driver.findElement(By.className("android.widget.MultiAutoCompleteTextView")).click();

		Thread.sleep(6000);
		driver.findElement(By.className("android.widget.MultiAutoCompleteTextView")).sendKeys("bangalore");

		driver.findElement(By.xpath("//android.widget.TextView[@text='BLR']")).click();

		driver.findElement(By.id("com.justdial.search:id/to_city")).click();

		Thread.sleep(6000);

		driver.findElement(By.className("android.widget.MultiAutoCompleteTextView")).click();

		Thread.sleep(6000);
		driver.findElement(By.className("android.widget.MultiAutoCompleteTextView")).sendKeys("Delhi");

		driver.findElement(By.xpath("//android.widget.TextView[@text='DEL']")).click();

		driver.quit();
	}

	public void clickOnAllowButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text='ALLOW']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='ALLOW']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='ALLOW']")).click();
	}
}