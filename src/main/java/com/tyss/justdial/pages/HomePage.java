package com.tyss.justdial.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {

	/**
	 * @author Shobhan
	 * @description Constructor to initialize home page mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public HomePage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	/**
	 * @author Shobhan
	 * @description Method to log test name info
	 * @param testName
	 */
	public void testName(String testName) {

		mobileActionUtil.info("\n");
		mobileActionUtil.info("=======================================================================");
		mobileActionUtil.info(" Test Case Name : " + testName);
		mobileActionUtil.info("=======================================================================");
		mobileActionUtil.info("\n");
	}

	/** HOME SCREEN MOBILE ELEMENTS DECLARATION **/
	long seconds = 10;
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

	private WebElement getLocation(String value) {
		return mobileActionUtil.getWebElement("xpath", "//android.widget.TextView[@text='" + value + "']");
	}

	private WebElement getGeneralElement(String value) {
		return mobileActionUtil.getWebElement("xpath",
				"(//android.widget.TextView[@resource-id='com.justdial.search:id/displayTxt'])[" + value + "]");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Search box
	 */
	public void clickOnSearchBox() {

		mobileActionUtil.waitForElementToLoad(5);
		mobileActionUtil.clickOnMobileElement(searchBx, "search Box");
		mobileActionUtil.waitForElementToLoad(2);
	}

	/**
	 * @author Shobhan
	 * @descrpition Method to click on Home search box
	 */
	public void clickOnHomeSearchBox() {

		try {
			mobileActionUtil.swipeDown(500, 600, 700);
			mobileActionUtil.visibilityWaitOfElement(seconds, searchBx1);
			mobileActionUtil.clickOnMobileElement(searchBx1, "search Box");
		} catch (Exception e) {
			mobileActionUtil.clickOnMobileElement(searchBx, "search Box");
		}
	}

	/**
	 * @author Shobhan
	 * @description Method to select Current location
	 */
	public void selectCurrentLocation() {

		mobileActionUtil.hideKeyboard();
		mobileActionUtil.waitForElementToLoad(3);
		try {
			mobileActionUtil.clickOnMobileElement(selectLocationDrpDwn1, "Select Location Drop Down");
			mobileActionUtil.clickOnMobileElement(detecteMyLocationOtn, "Detect My Location ");
		} catch (Exception e) {
		}
	}

	/**
	 * @author Shobhan
	 * @description Method to select required location
	 * @param location
	 */
	public void selectRequiredLocation(String location) {

		mobileActionUtil.clickOnMobileElement(selectLocationDrpDwn, "select Location Drop Down");
		mobileActionUtil.setText(searchBx, location, location + "location");
		mobileActionUtil.waitForElement(getLocation(location), seconds, location + "location");
		mobileActionUtil.clickOnMobileElement(getLocation(location), location + "location");
	}

	/**
	 * @author Shobhan
	 * @description Method to enter text to search
	 * @param enterText
	 */
	public void searchEnteredText(String enterText) {

		mobileActionUtil.hideKeyboard();
		mobileActionUtil.setText(searchBx, enterText, "Search Box");
		mobileActionUtil.waitForElementToLoad(2);
	}

	/**
	 * @author Shobhan
	 * @description Verify the Searched Keyword for First Search
	 * @param enterText
	 */
	public void verifySearchedKeywordWithfirstSearch(String enterText) {

		mobileActionUtil.waitForElement(generalisedXpath1, seconds, enterText);
		mobileActionUtil.hideKeyboard();
		System.out.println(generalisedXpath1.getText());
		mobileActionUtil.verifyElementText(generalisedXpath1, seconds, enterText);
	}

	/**
	 * @author Shobhan
	 * @description Method to verify Searched Keyword with first Sub Search
	 * @param enterText
	 */

	public void verifySearchedKeywordWithSubSearch(String enterText) {

		mobileActionUtil.waitForElement(generalisedXpath2, seconds, enterText);
		System.out.println(generalisedXpath2.getText());
		mobileActionUtil.verifyElementText(generalisedXpath2, seconds, enterText);
	}

	/**
	 * @author Shobhan
	 * @description Method to verify Searched Keyword with Index
	 * @param enterText
	 * @param index
	 */
	public void verifySearchedKeywordWithIndex(String index, String enterText) {

		mobileActionUtil.hideKeyboard();
		mobileActionUtil.waitForElement(getGeneralElement(index), seconds, enterText);
		System.out.println(getGeneralElement(index).getText());
		mobileActionUtil.verifyElementText(getGeneralElement(index), seconds, enterText);
	}

	/**
	 * @author Shobhan
	 * @description Click on the Taj Mahal displayed in the Autosuggestion
	 */
	public void clickOnTajMahalText() {

		mobileActionUtil.waitForElement(getGeneralElement("2"), seconds, "'Taj Mahal' From List");
		mobileActionUtil.clickOnMobileElement(getGeneralElement("2"), "'Taj Mahal' From List");
		mobileActionUtil.waitForElementToLoad(2);
	}

	/**
	 * @author Shobhan
	 * @description Click on the J W Marriot displayed in the Auto suggestion
	 */
	public void clickOnJwMarriotText() {

		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "JW Marriot Hotel From List");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "JW Marriot Hotel From List");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Rudrappa Hospital displayed in the Auto suggestion
	 */
	public void clickOnRudrappaHospitalText() {

		mobileActionUtil.waitForElement(generalisedXpath1, seconds, " Dr. Rudrappa Hospital");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, " Dr. Rudrappa Hospital");
		mobileActionUtil.waitForElementToLoad(2);
	}

	/**
	 * @author Shobhan
	 * @description Click on the Macdonald Bellandur displayed in the Auto
	 *              suggestion
	 */
	public void clickOnMacdonaldBellundurText() {

		mobileActionUtil.info("Click On Macdonald autosuggestion");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Macdonald bellandur ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Macdonald bellandur");
	}

	/**
	 * @author Shobhan
	 * @description Click on the CCD Nagawara displayed in the Auto suggestion
	 */

	public void clickOnCCDNagawaraText() {

		mobileActionUtil.info("Click On Macdonald autosuggestion");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Nagawara Text ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Nagawara Text");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Taj Hotel Goa displayed in the Auto suggestion
	 */
	public void clickOnTajHotelGoaText() {

		mobileActionUtil.info("Click On TajHotel Goa autosuggestion");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "TajHotel Goa Text ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "TajHotel Goa Text");
	}

	/**
	 * @author Shobhan
	 * @description Click on the 5 Star Hotel displayed in the Auto suggestion
	 */
	public void clickOn5StarhotelsinGoa() {

		mobileActionUtil.info("Click On 5 Star hotels in Goa ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "5 Star hotels in Goa ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "5 Star hotels in Goa");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Resturants Near Me in the Auto suggestion
	 */
	public void clickOnResturentsNearMe() {

		mobileActionUtil.info("Click On Resturents Near Me ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Resturents Near Me ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Resturents Near Me");
	}

	/**
	 * @author Shobhan
	 * @description Click on the PackersAndMover in the Auto suggestion
	 */
	public void clickOnPackersAndMoverText() {

		mobileActionUtil.info("Click On Packers And Movers Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Packers And Movers ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Packers And Movers");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Dominoz Pizza in the Auto suggestion
	 */
	public void clickOnDominozPizzaText() {

		mobileActionUtil.info("Click On Dominozz pizza Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Dominozz Pizza ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Dominozz Pizza ");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Gully Boy Movie in the Auto suggestion
	 */
	public void clickOnGullyBoyMovieText() {

		mobileActionUtil.info("Click On Gully Boy Movie  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Gully Boy ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Gully Boy ");
	}

	/**
	 * @author Shobhan
	 * @description Click on the IphoneX in the Auto suggestion
	 */
	public void clickOnIphoneXText() {

		mobileActionUtil.info("Click On IphoneX  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "IphoneX ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "IphoneX ");
	}

	/**
	 * @author Shobhan
	 * @description Click on the IphoneX Grey in the Auto suggestion
	 */
	public void clickOnIphoneXGreyText() {

		mobileActionUtil.info("Click On Gully Boy Movie  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "IphoneXGrey 64 Gb ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "IphoneXGrey 64 Gb");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Dal Khichadi in the Auto suggestion
	 */
	public void clickOnDalkhichadiText() {

		mobileActionUtil.info("Click On Gully Boy Movie  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Dal khichadi ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Dalkhichadi");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Virat Kohli in the Auto suggestion
	 */
	public void clickOnViratKohliText() {

		mobileActionUtil.info("Click On Virat Kohli  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Virat Kohli  ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Virat Kohli");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Narendra Modi News in the Auto suggestion
	 */
	public void clickOnNarendraModinewsText() {

		mobileActionUtil.info("Click On narendra Modi news   Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Narendra Modi News  ");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Narendra Modi News");
	}

	/**
	 * @author Shobhan
	 * @description Click on theTera Ghata Song News in the Auto suggestion
	 */
	public void clickOnTeraGhataSongText() {

		mobileActionUtil.info("Click On Tera Ghata Song   Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Tera Ghata Song");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Tera Ghata Song");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Mumbai Benglore Flight in the Auto suggestion
	 */
	public void clickOnMumbaiBangloreFlightText() {

		mobileActionUtil.info("Click On Mumbai Banglore Flight  Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Mumbai Banglore Flight");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Mumbai Banglore Flight");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Mumbai Benglore Train in the Auto suggestion
	 */
	public void clickOnMumbaiBangloreTrainText() {

		mobileActionUtil.info("Click On Mumbai Bnaglore train   Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Mumbai Banglore Train");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Mumbai Banglore Train");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Mumbai Benglore Bus in the Auto suggestion
	 */
	public void clickOnMumbaiBangloreBusText() {

		mobileActionUtil.info("Click On Mumbai Banglore bus Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Mumbai Banglore Train");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Mumbai Banglore Train");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Karnavati Express in the Auto suggestion
	 */
	public void clickOnKarnavatiExpressText() {

		mobileActionUtil.info("Click On KarnavatiExpress Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Karnavati Express  Train");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Karnavati Express Train");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Plumbers Express in the Auto suggestion
	 */
	public void clickOnplumbrsText() {

		mobileActionUtil.info("Click On plumbur Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Plumbur");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Plumbur");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Iphone Dealers in the Auto suggestion
	 */
	public void clickOnIphoneDealerText() {

		mobileActionUtil.info("Click On IphoneDealer Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "IPhone Dealer");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "IPhone dealer");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Jayanagar in the Auto suggestion
	 */
	public void clickOnPlumberJayaNagarText() {

		mobileActionUtil.info("Click On Plumber Jayanagar Autosuggestion ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "Plumber Jayanagar");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "Plumber jayanagar");
	}

	/**
	 * @author Shobhan
	 * @description Click on the Manpasand Price in the Auto suggestion
	 */
	public void clickOnManPasandPriceText() {

		mobileActionUtil.info("Click On ManPasand Share price ");
		mobileActionUtil.waitForElement(generalisedXpath1, seconds, "ManPasand share price");
		mobileActionUtil.clickOnMobileElement(generalisedXpath1, "ManPasand share price");
	}

	/**
	 * @author Shobhan
	 * @description Verify First Restaurants Name
	 */
	public void displayFirstResturents() {

		mobileActionUtil.verifyElementIsDisplayed(resturentNameTxt, seconds, "Resturent Name");
		mobileActionUtil.info(resturentNameTxt.getText());
		mobileActionUtil.verifyElementIsDisplayed(resturentAddressTxt, seconds, "Resturent Address");
		mobileActionUtil.info(resturentAddressTxt.getText());
	}

	/**
	 * @author Shobhan
	 * @description Select Dominos Pizza Outlets
	 */
	public void selectDominosPizzaOutlets() {

		mobileActionUtil.clickOnMobileElement(dominosOutletsTxt, "Dominos-Pizza Outlets");
	}

	/**
	 * @author Shobhan
	 * @description Verify Dominoz Pizza Text Displayed
	 */
	public void displayFirstDominosPizza() {

		mobileActionUtil.verifyElementIsDisplayed(dominosNameTxt, seconds, "Dominos Name");
		mobileActionUtil.info(dominosNameTxt.getText());
		mobileActionUtil.verifyElementIsDisplayed(dominosAddressTxt, seconds, "Dominos Address Name");
		mobileActionUtil.info(dominosAddressTxt.getText());
	}

	/**
	 * @author Shobhan
	 * @description Verify Dominoz Search Results Text Displayed
	 * @param name
	 * @param address
	 */
	public void verifyDominosSearchResult(String name, String address) {

		mobileActionUtil.verifyText(dominosNameTxt.getText(), name);
		mobileActionUtil.verifyText(dominosAddressTxt.getText(), address);
	}

	/**
	 * @author Shobhan
	 * @description Select Dil Wale Dulhania Le Jayenge Movie
	 */
	public void selectDilwaleDulhaniaLeJayengeHindiMovie() {

		mobileActionUtil.clickOnMobileElement(getGeneralElement("2"), "Dilwale Dulhania Le Jayenge Hindi Movie");
	}

	/**
	 * @author Shobhan
	 * @description Verify DDLJ Search Results
	 * @param expText
	 */
	public void verifyDDLJSearchResult(String expText) {

		mobileActionUtil.waitForElementToLoad(5);
		mobileActionUtil.verifyElementText(theaterName, seconds, expText);
	}
}