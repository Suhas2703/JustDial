package com.tyss.justdial.pages;

import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.touch.offset.PointOption;

public class HomePage extends BasePage {

	long timeinSeconds = 5;

	public HomePage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	// @FindAll({
	// @FindBy(className = "android.widget.MultiAutoCompleteTextView"),
	// @FindBy(id = "com.justdial.search:id/search_layout_child_home")
	// })
	// @FindBy(xpath =
	// "//android.widget.ImageView[@resource-id='com.justdial.search:id/jd_image_home']/following-sibling::android.widget.RelativeLayout/child::android.widget.RelativeLayout/child::android.widget.MultiAutoCompleteTextView")

	@FindBy(className = "android.widget.MultiAutoCompleteTextView")
	private WebElement searchBx;

	@FindBy(id = "com.justdial.search:id/search_edit_text_home")
	private WebElement searchBx1;

	@FindBy(xpath = "//android.widget.MultiAutoCompleteTextView[@text='What? e.g. Restaurant']")
	private WebElement searchBx2;

	@FindBy(id = "com.justdial.search:id/search_edit_text")
	private WebElement searchBx3;

	@FindBy(id = "com.justdial.search:id/jd_detected_area_view")
	private WebElement selectLocationDrpDwn;

	@FindBy(xpath = "(//android.widget.ImageView)[2]/../..//android.widget.TextView")
	private WebElement selectLocationDrpDwn1;

	@FindBy(id = "com.justdial.search:id/widget_near_me_home")
	private WebElement detecteMyLocationOtn;

	@FindBy(className = "(//android.widget.TextView[@resource-id='com.justdial.search:id/displayTxt'])[1])")
	private WebElement tajMahalTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Bannerghatta Road']")
	private WebElement bannerghattaTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Vittal Mallya Road']")
	private WebElement jwMarriotHotelTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Dr. Rudrappa Hospital']")
	private WebElement rudraHospitalTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Bellandur']")
	private WebElement mcDonaldsbellandurTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Nagawara']")
	private WebElement ccdNagawaraTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Taj Hotels - Goa']")
	private WebElement tajHotelsnoTxt;

	@FindBy(id = "com.justdial.search:id/displayTxt")
	private WebElement restaurantsNearMeTxt;

	@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.justdial.search:id/comp_name'])[1]")
	private WebElement resturentNameTxt;

	@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.justdial.search:id/comp_address'])[1]")
	private WebElement resturentAddressTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Packers & Movers']")
	private WebElement packersTxt;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Dominos-Pizza Outlets Near Me')]")
	private WebElement dominosNearMeTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Dominos-Pizza Outlets']")
	private WebElement dominosOutletsTxt;

	@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.justdial.search:id/comp_name'])[1]")
	private WebElement dominosNameTxt;

	@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.justdial.search:id/comp_address'])[1]")
	private WebElement dominosAddressTxt;

	@FindBy(id = "com.justdial.search:id/movie_theatre_name")
	private WebElement theaterName;

	@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.justdial.search:id/displayTxt'])[1] ")
	private WebElement generalisedXpath1;

	@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.justdial.search:id/displayTxt']|//android.widget.TextView[@resource-id='com.justdial.search:id/autoArea'])[2]")
	private WebElement generalisedXpath2;

	@FindBy(xpath = "//android.widget.TextView[@text='Home']")
	private WebElement homeIcon;

	private WebElement getLocation(String value) {
		return mobileActionUtil.getWebElement("xpath", "//android.widget.TextView[@text='" + value + "']");
	}

	private WebElement getGeneralElement(String value) {
		return mobileActionUtil.getWebElement("xpath",
				"(//android.widget.TextView[@resource-id='com.justdial.search:id/displayTxt'])[" + value + "]");
	}

	public void testName(String testName) {
		mobileActionUtil.info("\n");
		mobileActionUtil.info("=======================================================================");
		mobileActionUtil.info(" Test Case Name : " + testName);
		mobileActionUtil.info("=======================================================================");
		mobileActionUtil.info("\n");
	}

	public void clickOnSearchBox() {
		try {
			mobileActionUtil.visibilityWaitOfElement(10, searchBx1);
			mobileActionUtil.clickOnElement(searchBx1, "search Box");
		} catch (Exception e) {
			homeIcon.click();
			mobileActionUtil.clickOnElement(searchBx, "search Box");
		}
		mobileActionUtil.sleep(2);
		}

	public void clickOnHomeSearchBox() {
		try {
			/*
			 * mobileActionUtil.visibilityWaitOfElement(10, homeIcon); homeIcon.click();
			 */
			/*Dimension screenSize = driver.manage().window().getSize();
			new TouchAction(driver)
					.press(PointOption.point((int) screenSize.getWidth() / 2, (int) (screenSize.height * 0.2)))
					.waitAction()
					.press(PointOption.point((int) screenSize.getWidth() / 2, (int) (screenSize.height * 0.8)))
					.release().perform();*/
			mobileActionUtil.visibilityWaitOfElement(10, searchBx1);
			mobileActionUtil.clickOnElement(searchBx1, "search Box");
		} catch (Exception e) {
			homeIcon.click();
			mobileActionUtil.clickOnElement(searchBx, "search Box");
		}

	}

	public void selectCurrentLocation() {
		mobileActionUtil.hideKeyboard();
		mobileActionUtil.sleep(3);
		try {
			mobileActionUtil.clickOnElement(selectLocationDrpDwn1, "Select Location Drop Down");
			mobileActionUtil.clickOnMobileElement(detecteMyLocationOtn, "Detect My Location ");
		} catch (Exception e) {
		
		}
		
		// mobileActionUtil.SingleTap(selectLocationDrpDwn);
		//mobileActionUtil.waitForElementClickable(selectLocationDrpDwn1, 10, "select Location Drop Down");
	
		/*
		 * try { mobileActionUtil.sleep(5);
		 * mobileActionUtil.waitForElementClickable(selectLocationDrpDwn, 10,
		 * "Select Location Drop Down");
		 * mobileActionUtil.clickOnMobileElement(selectLocationDrpDwn,
		 * "Select Location Drop Down"); mobileActionUtil.sleep(2);
		 * mobileActionUtil.clickOnMobileElement(detecteMyLocationOtn,
		 * "Detect My Location "); } catch (Exception e) {
		 * mobileActionUtil.clickOnMobileElement(selectLocationDrpDwn1,
		 * "Select Location Drop Down");
		 * mobileActionUtil.clickOnMobileElement(detecteMyLocationOtn,
		 * "Detect My Location "); }
		 */
	}

	public void selectRequiredLocation(String location) {

//		TouchActions action = new TouchActions(driver);
//		action.singleTap(selectLocationDrpDwn).perform();
		mobileActionUtil.clickOnMobileElement(selectLocationDrpDwn, "select Location Drop Down");
		mobileActionUtil.setText(searchBx, location, location + "location");
		mobileActionUtil.waitForElement(getLocation(location), timeinSeconds, location + "location");
		mobileActionUtil.clickOnMobileElement(getLocation(location), location + "location");

	}

	public void searchEnteredText(String enterText) {
		// mobileActionUtil.waitForElement(searchBx, timeinSeconds, "Search
		// Box");
		mobileActionUtil.hideKeyboard();
		mobileActionUtil.setText(searchBx, enterText, "Search Box");
		mobileActionUtil.sleep(2);
	}

	/*
	 * public void verifySearchedKeyword1(String enterText) {
	 * mobileActionUtil.waitForElement(bannerghattaTxt, timeinSeconds,
	 * "bannerghatta Road"); mobileActionUtil.hideKeyboard();
	 * System.out.println(bannerghattaTxt.getText());
	 * mobileActionUtil.verifyElementText(bannerghattaTxt, timeinSeconds,
	 * enterText); }
	 * 
	 * public void verifySearchedKeyword2(String enterText) {
	 * mobileActionUtil.waitForElement(jwMarriotHotelTxt, timeinSeconds,
	 * "jwMarriotHotelTxt"); mobileActionUtil.hideKeyboard();
	 * System.out.println(jwMarriotHotelTxt.getText());
	 * mobileActionUtil.verifyElementText(jwMarriotHotelTxt, timeinSeconds,
	 * enterText); }
	 * 
	 * public void verifySearchedKeyword3(String enterText) {
	 * mobileActionUtil.waitForElement(rudraHospitalTxt, timeinSeconds, "rudraTxt");
	 * mobileActionUtil.hideKeyboard();
	 * System.out.println(rudraHospitalTxt.getText());
	 * mobileActionUtil.verifyElementText(rudraHospitalTxt, timeinSeconds,
	 * enterText); }
	 * 
	 * public void verifySearchedKeyword4(String enterText) {
	 * mobileActionUtil.waitForElement(mcDonaldsbellandurTxt, timeinSeconds,
	 * "mcDonaldsbellandurTxt"); mobileActionUtil.hideKeyboard();
	 * System.out.println(mcDonaldsbellandurTxt.getText());
	 * mobileActionUtil.verifyElementText(mcDonaldsbellandurTxt, timeinSeconds,
	 * enterText); }
	 * 
	 * public void verifySearchedKeyword5(String enterText) {
	 * mobileActionUtil.waitForElement(ccdNagawaraTxt, timeinSeconds,
	 * "ccdNagawaraTxt"); mobileActionUtil.hideKeyboard();
	 * System.out.println(ccdNagawaraTxt.getText());
	 * mobileActionUtil.verifyElementText(ccdNagawaraTxt, timeinSeconds, enterText);
	 * }
	 * 
	 * public void verifySearchedKeyword6(String enterText) {
	 * mobileActionUtil.waitForElement(tajHotelsnoTxt, timeinSeconds,
	 * "tajHotelsnoTxt"); mobileActionUtil.hideKeyboard();
	 * System.out.println(tajHotelsnoTxt.getText());
	 * mobileActionUtil.verifyElementText(tajHotelsnoTxt, timeinSeconds, enterText);
	 * }
	 * 
	 * public void verifySearchedKeyword7(String enterText) {
	 * mobileActionUtil.waitForElement(restaurantsNearMeTxt, timeinSeconds,
	 * "restaurantsNearMeTxt"); mobileActionUtil.hideKeyboard();
	 * System.out.println(restaurantsNearMeTxt.getText());
	 * mobileActionUtil.verifyElementText(restaurantsNearMeTxt, timeinSeconds,
	 * enterText); }
	 * 
	 * public void verifySearchedKeyword8(String enterText) {
	 * mobileActionUtil.waitForElement(packersTxt, timeinSeconds, "packersTxt");
	 * mobileActionUtil.hideKeyboard(); System.out.println(packersTxt.getText());
	 * mobileActionUtil.verifyElementText(packersTxt, timeinSeconds, enterText); }
	 */

	// genaralised
	public void verifySearchedKeywordWithfirstSearch(String enterText) {
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, enterText);
		mobileActionUtil.hideKeyboard();
		System.out.println(generalisedXpath1.getText());
		mobileActionUtil.verifyElementText(generalisedXpath1, timeinSeconds, enterText);
	}

	public void verifySearchedKeywordWithSubSearch(String enterText) {
		mobileActionUtil.waitForElement(generalisedXpath2, timeinSeconds, enterText);
		System.out.println(generalisedXpath2.getText());
		mobileActionUtil.verifyElementText(generalisedXpath2, timeinSeconds, enterText);
	}

	public void verifySearchedKeywordWithIndex(String Index, String enterText) {
		mobileActionUtil.hideKeyboard();
		mobileActionUtil.waitForElement(getGeneralElement(Index), timeinSeconds, enterText);
		System.out.println(getGeneralElement(Index).getText());
		mobileActionUtil.verifyElementText(getGeneralElement(Index), timeinSeconds, enterText);

	}

	public void clickOnTajMahalText() {
		mobileActionUtil.waitForElement(getGeneralElement("2"), timeinSeconds, "'Taj Mahal' From List");
		mobileActionUtil.clickOnMobileElement(getGeneralElement("2"), "'Taj Mahal' From List");
		mobileActionUtil.sleep(2);
	}

	public void clickOnJwMarriotText() {
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "JW Marriot Hotel From List");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "JW Marriot Hotel From List");
	}

	public void clickOnRudrappaHospitalText() {

		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, " Dr. Rudrappa Hospital");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, " Dr. Rudrappa Hospital");
		mobileActionUtil.sleep(2);
	}

	public void clickOnMacdonaldBellundurText() {
		mobileActionUtil.info("Click On Macdonald autosuggestion");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Macdonald bellandur ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Macdonald bellandur");
	}

	public void clickOnCCDNagawaraText() {
		mobileActionUtil.info("Click On Macdonald autosuggestion");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Nagawara Text ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Nagawara Text");
	}

	public void clickOnTajHotelGoaText() {
		mobileActionUtil.info("Click On TajHotel Goa autosuggestion");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "TajHotel Goa Text ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "TajHotel Goa Text");
	}

	public void clickOn5StarhotelsinGoa() {
		mobileActionUtil.info("Click On 5 Star hotels in Goa ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "5 Star hotels in Goa ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "5 Star hotels in Goa");
	}

	public void clickOnResturentsNearMe() {
		mobileActionUtil.info("Click On Resturents Near Me ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Resturents Near Me ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Resturents Near Me");
	}

	public void clickOnPackersAndMoverText() {
		mobileActionUtil.info("Click On Packers And Movers Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Packers And Movers ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Packers And Movers");
	}

	public void clickOnDominozPizzaText() {
		mobileActionUtil.info("Click On Dominozz pizza Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Dominozz Pizza ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Dominozz Pizza ");
	}

	public void clickOnGullyBoyMovieText() {
		mobileActionUtil.info("Click On Gully Boy Movie  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Gully Boy ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Gully Boy ");
	}

	public void clickOnIphoneXText() {
		mobileActionUtil.info("Click On Gully Boy Movie  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "IphoneX ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "IphoneX ");
	}

	public void clickOnIphoneXGreyText() {
		mobileActionUtil.info("Click On Gully Boy Movie  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "IphoneXGrey 64 Gb ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "IphoneXGrey 64 Gb");
	}

	public void clickOnDalkhichadiText() {
		mobileActionUtil.info("Click On Gully Boy Movie  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Dal khichadi ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Dalkhichadi");
	}

	public void clickOnViratKohliText() {
		mobileActionUtil.info("Click On Virat Kohli  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Virat Kohli  ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Virat Kohli");
	}

	public void clickOnNarendraModinewsText() {
		mobileActionUtil.info("Click On narendra Modi news   Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Narendra Modi News  ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Narendra Modi News");
	}

	public void clickOnTeraGhataSongText() {
		mobileActionUtil.info("Click On Tera Ghata Song   Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Tera Ghata Song");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Tera Ghata Song");
	}

	public void clickOnMumbaiBangloreFlightText() {
		mobileActionUtil.info("Click On Mumbai Banglore Flight  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Mumbai Banglore Flight");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Mumbai Banglore Flight");
	}

	public void clickOnMumbaiBangloreTrainText() {
		mobileActionUtil.info("Click On Mumbai Bnaglore train   Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Mumbai Banglore Train");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Mumbai Banglore Train");
	}

	public void clickOnMumbaiBangloreBusText() {
		mobileActionUtil.info("Click On Mumbai Banglore bus Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Mumbai Banglore Train");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Mumbai Banglore Train");
	}

	public void clickOnKarnavatiExpressText() {
		mobileActionUtil.info("Click On KarnavatiExpress Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Karnavati Express  Train");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Karnavati Express Train");
	}

	public void clickOnplumbrsText() {
		mobileActionUtil.info("Click On plumbur Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Plumbur");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Plumbur");
	}

	public void clickOnIphoneDealerText() {
		mobileActionUtil.info("Click On IphoneDealer Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "IPhone Dealer");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "IPhone dealer");
	}

	public void clickOnPlumberJayaNagarText() {
		mobileActionUtil.info("Click On Plumber Jayanagar Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "Plumber Jayanagar");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Plumber jayanagar");
	}

	public void clickOnManPasandPriceText() {
		mobileActionUtil.info("Click On ManPasand Share price ");
		mobileActionUtil.waitForElement(generalisedXpath1, timeinSeconds, "ManPasand share price");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "ManPasand share price");
	}

	public void displayFirstResturents() {
		mobileActionUtil.verifyElementIsDisplayed(resturentNameTxt, timeinSeconds, "Resturent Name");
		mobileActionUtil.info(resturentNameTxt.getText());
		mobileActionUtil.verifyElementIsDisplayed(resturentAddressTxt, timeinSeconds, "Resturent Address");
		mobileActionUtil.info(resturentAddressTxt.getText());
	}

	public void selectDominosPizzaOutlets() {
		mobileActionUtil.clickOnElement(dominosOutletsTxt, "Dominos-Pizza Outlets");
	}

	public void displayFirstDominosPizza() {
		mobileActionUtil.verifyElementIsDisplayed(dominosNameTxt, timeinSeconds, "Dominos Name");
		mobileActionUtil.info(dominosNameTxt.getText());
		mobileActionUtil.verifyElementIsDisplayed(dominosAddressTxt, timeinSeconds, "Dominos Address Name");
		mobileActionUtil.info(dominosAddressTxt.getText());
	}

	public void verifyDominosSearchResult(String name, String address) {
		mobileActionUtil.verifyText(dominosNameTxt.getText(), name);
		mobileActionUtil.verifyText(dominosAddressTxt.getText(), address);
	}

	public void selectDilwaleDulhaniaLeJayengeHindiMovie() {
		mobileActionUtil.clickOnElement(getGeneralElement("2"), "Dilwale Dulhania Le Jayenge Hindi Movie");
	}

	public void verifyDDLJSearchResult(String expText1) {
		mobileActionUtil.sleep(5);
		mobileActionUtil.verifyElementText(theaterName, timeinSeconds, expText1);
	}
}