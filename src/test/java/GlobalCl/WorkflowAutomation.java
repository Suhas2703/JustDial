package GlobalCl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tyss.justdial.library.BaseTest;
import com.tyss.justdial.library.ExcelLibrary;
import com.tyss.justdial.pages.HomePage;
import com.tyss.justdial.pages.LoginPage;
import com.tyss.justdial.pages.SearchPage;

import io.appium.java_client.android.AndroidDriver;

public class WorkflowAutomation extends BaseTest {

	ExcelLibrary excelLibrary = new ExcelLibrary();
	
	@DataProvider
	public Integer[][] getData(){
		
		int row =  new ExcelLibrary().getExcelRowCount(XL_TESTPATH, "Scenarios");
		
		Integer[][] data=new Integer[row][1];
		for(int i=1;i<=row;i++) {
			data[i-1][0]=i;
		}
		return data;
	}
	
	@Test(dataProvider="getData")
	public void runTest(int index) {
		
		navigateToSearchPage();
		ExcelLibrary excelLibrary = new ExcelLibrary();
		System.out.println("Index :"+index);
			int column = excelLibrary.getExcelCellCount(XL_TESTPATH, "Scenarios",index);
			for (int j = 1; j <column; j++) {
				String xlData = excelLibrary.getExcelData(XL_TESTPATH, "Scenarios", index, j);
				System.out.println("XLData:"+xlData);
				
				System.out.println(xlData.split(":")[0].toString().trim());
				String functionName=xlData.split(":")[0].toString().trim();
				
				System.out.println(xlData.split(":")[1].toString().trim());
				String functionArg=xlData.split(":")[1].toString().trim();
				
				callFunction(functionName,functionArg);
				}			
		
	}
	
	
	public void callFunction(String functionName,String functionArg) {
		
		switch (functionName) {

		case "Search":
			System.out.println("Calling search function");
			search(driver,functionArg);
			break;

		case "SelectOption":
			System.out.println("Calling SelectOption function");
			selectOption(driver,functionArg);
			break;
			
		case "VerifyAlsoListedIn":
			System.out.println("Calling VerifyAlsoListedIn function");
			VerifyAlsoListedIn(driver,functionArg);
			break;
			
		case "VerifyPhoneNumber":
			System.out.println("Calling VerifyPhoneNumber function");
			verifyPhoneNumber(driver,functionArg);
			break;
		case "VerifySearchPageIsDisplayed":
			System.out.println("Calling VerifySearchPageIsDisplayed function");
			verifySearchPageIsDisplayed(driver,functionArg);
			break;
			
		}
	}
	
	public void navigateToSearchPage() {
		
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

		
	}
	public void search(AndroidDriver driver,String optionToSearh) {
		
		HomePage homePage = new HomePage(driver, mobileActionUtil);
		homePage.clickOnHomeSearchBox();

		homePage.selectCurrentLocation();
		driver.findElement(By.className("android.widget.MultiAutoCompleteTextView")).click();
		driver.findElement(By.className("android.widget.MultiAutoCompleteTextView")).sendKeys(optionToSearh);
		driver.hideKeyboard();
	}
	public void selectOption(AndroidDriver driver,String optionToSelect) {
		
		String xp="//android.widget.TextView[@text='"+optionToSelect+"']";
		driver.findElement(By.xpath(xp)).click();
	}
	
	public void VerifyAlsoListedIn(AndroidDriver driver,String expectedText) {
		
		/* Scroll Till Tourist Attraction Text */
		SearchPage searchpage = new SearchPage(driver, mobileActionUtil);
		searchpage.scrollTillTouristAttraction();

		/* Verify Tourist Attraction Text */
		searchpage.verifyTouristAttraction(expectedText);
	}
	
	public void verifyPhoneNumber(AndroidDriver driver,String expectedText) {
		
		mobileActionUtil.waitForElementToLoad(5);
		mobileActionUtil.swipeUp(578, 1475, 580);
		mobileActionUtil.swipeUp(578, 1475, 580);
		mobileActionUtil.swipeUp(578, 1475, 550);
		mobileActionUtil.waitForElementToLoad(1);
		System.out.println("//android.widget.TextView[contains(@text,'"+expectedText+"')]");
		WebElement ph = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+expectedText+"')]"));
		mobileActionUtil.checkElementScroll(ph);
		mobileActionUtil.verifyElementTextContains(ph,5,expectedText);
	}
	
	public void verifySearchPageIsDisplayed(AndroidDriver driver,String expectedText) {
		
		SearchPage searchPage = new SearchPage(driver, mobileActionUtil);
		searchPage.verifySearchResultPage(expectedText);
	}


	
	
}
