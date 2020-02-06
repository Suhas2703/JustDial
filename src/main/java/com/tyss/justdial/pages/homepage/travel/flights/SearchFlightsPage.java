

package com.tyss.justdial.pages.homepage.travel.flights;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.justdial.library.BasePage;
import com.tyss.justdial.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class SearchFlightsPage extends BasePage {

	/**
	 * @author Shobhan
	 * @description Constructor to initialize FlightsPage mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public SearchFlightsPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
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
	
	
	/** SEARCH FLIGHTS SCREEN MOBILE ELEMENTS DECLARATION **/
	long seconds = 10;
	@FindBy(id = "com.justdial.search:id/flights_oneway")
	private WebElement oneWayTab;

	@FindBy(id = "com.justdial.search:id/flights_roundtrip")
	private WebElement roundTripTab;

	@FindBy(id = "com.justdial.search:id/flights_status")
	private WebElement flightStatusTab;

	@FindBy(id = "com.justdial.search:id/from_city")
	private WebElement fromTxtBx;

	@FindBy(id = "com.justdial.search:id/to_city")
	private WebElement toTxtBx;

	@FindBy(id = "com.justdial.search:id/round_trip")
	private WebElement roundTripIcon;

	@FindBy(id = "com.justdial.search:id/depature_date")
	private WebElement depatureTxtBx;

	@FindBy(id = "com.justdial.search:id/travler_count")
	private WebElement travellersTxtBx;

	@FindBy(id = "com.justdial.search:id/travler_class")
	private WebElement classLnk;

	@FindBy(id = "com.justdial.search:id/checkbox_nonstop_flights")
	private WebElement nonStopFlightsRadioBtn;

	@FindBy(id = "com.justdial.search:id/search_flights")
	private WebElement searchBtn;

	@FindBy(id = "com.justdial.search:id/adults")
	private WebElement adultsTxt;

	@FindBy(id = "com.justdial.search:id/children")
	private WebElement childrenTxt;

	@FindBy(id = "com.justdial.search:id/infant")
	private WebElement infantsTxt;

	@FindBy(xpath = "//android.widget.TextView[@text='Adults']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_minus']")
	private WebElement adultsMinusBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Adults']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_plus']")
	private WebElement adultsPlusBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Children']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_minus']")
	private WebElement childrenMinusBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Children']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_plus']")
	private WebElement childrenPlusBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Infants']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_minus']")
	private WebElement infantsMinusBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Infants']/..//android.widget.ImageView[@resource-id='com.justdial.search:id/seats_plus']")
	private WebElement infantsPlusBtn;

	@FindBy(id = "com.justdial.search:id/seat_no_done")
	private WebElement doneBtn;

	@FindBy(className = "android.widget.MultiAutoCompleteTextView")
	private WebElement airportSearchBx;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.justdial.search:id/cities_Lay']")
	private WebElement selectFirstCityOtn;

	private WebElement selectDate(String value) {
		return mobileActionUtil.getWebElement("xpath",
				"(//android.widget.TextView[@text='Departure']/../../..//android.widget.TextView[@text=" + value
						+ "])[1]");
	}

	@FindBy(id = "com.justdial.search:id/loaderDate")
	private WebElement loaderDateTxt;

	@FindBy(id = "com.justdial.search:id/searchingfor")
	private WebElement searchingForFlightsTxt;
	
	
	/**
	 * @author Anil
	 * @description Method to verify swap button is dispalyed
	 */	
	public void verifySwapIconIsDisplayed(){
		mobileActionUtil.verifyElementIsDisplayed(roundTripIcon, seconds, "Swap Icon");
		mobileActionUtil.info("Swap icon is displayed");
	}
	
	/**
	 * @author Anil
	 * @description Method to verify swap button is tappable
	 */	
	public void validateSwapIconIsTappable(){
		mobileActionUtil.isClickable(roundTripIcon, seconds);
		mobileActionUtil.info("Swap icon is clickable");
	}
	/**
	 * @author Anil
	 * @description Method to verify Search button is dispalyed
	 */	
	public void verifySearchBtnIsDispalyed(){
		mobileActionUtil.verifyElementIsDisplayed(searchBtn, seconds, "Search Button");
		mobileActionUtil.info("Search button is displayed");
	}

	/**
	 * @author Anil
	 * @description Method to verify search button is tappable
	 */	
	public void validateSerachBtnIsTappable(){
		mobileActionUtil.isClickable(searchBtn, seconds);
		mobileActionUtil.info("Search button is clickable");
	}
	/**
	 * @author Anil
	 * @description Method to verify Class Link is dispalyed
	 */	
	public void verifyClassTextIsDispalyed(String expectedText){
		mobileActionUtil.verifyElementIsDisplayed(classLnk, seconds, "Class Link");
		mobileActionUtil.info("Class Link is displayed");
		String actualText = classLnk.getText();
		if (actualText.equalsIgnoreCase(expectedText))
		{
			mobileActionUtil.info("The Actual text"+actualText+"is matching with Expected text"+expectedText);
		}
		else{
			mobileActionUtil.info("The Actual text"+actualText+"is not matching with Expected text"+expectedText);
		}
		
	}
	
	/**
	 * @author Anil
	 * @description Method to verify class link is tappable
	 */	
	public void validateClassLinkIsTappable(){
		mobileActionUtil.isClickable(classLnk, seconds);
		mobileActionUtil.info("Class Link is clickable");		
	}
	/**
	 * @author Anil
	 * @description Method to verify from text box is tappable
	 */	
	public void validateFromTextBoxIsTappable(){
		mobileActionUtil.isClickable(fromTxtBx, seconds);
		mobileActionUtil.info("From Text Box is clickable");	
	}
	
	/**
	 * @author Anil
	 * @description Method to verify to text box is tappable
	 */	
	public void validateToTextBoxIsTappable(){
		mobileActionUtil.isClickable(toTxtBx, seconds);
		mobileActionUtil.info("From Text Box is clickable");	
	}
	
	/**
	 * @author Shobhan
	 * @description Method to click on From Text Box
	 */
	public void clickOnFrom() {
		mobileActionUtil.clickOnMobileElement(fromTxtBx, "From");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Round Trip Icon
	 */
	public void clickOnRoundTripIcon() {
		mobileActionUtil.clickOnMobileElement(roundTripIcon, "Round Trip Icon");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on To Text Box
	 */
	public void clickOnTo() {
		mobileActionUtil.clickOnMobileElement(toTxtBx, "To");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Departure Text Box
	 */
	public void clickOnDepature() {
		mobileActionUtil.clickOnMobileElement(depatureTxtBx, "Depature Text Box");
	}

	/**
	 * @author Shobhan
	 * @descriptiion Method to click on Travellers Text Box
	 */
	public void clickOnTravellers() {
		mobileActionUtil.clickOnMobileElement(travellersTxtBx, "Travellers Text Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Class link
	 */
	public void clickOnClass() {
		mobileActionUtil.clickOnMobileElement(classLnk, "class Text Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Non Stop Fights Radio Button
	 */
	public void clickOnNonStopFlightsOnly() {
		mobileActionUtil.clickOnMobileElement(nonStopFlightsRadioBtn, "Non Stop Flights Radio Button");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Search Button
	 */
	public void clickOnSearch() {
		mobileActionUtil.clickOnMobileElement(searchBtn, "Search Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Airport Serach Box
	 */
	public void clickOnAirportSearch() {
		mobileActionUtil.clickOnMobileElement(airportSearchBx, "Airport Search Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to send value to Airport Search Box
	 * @param enterText
	 */
	public void enterCityNameInSearch(String enterText) {
		mobileActionUtil.setText(airportSearchBx, enterText, "Search Box");
	}

	/**
	 * @author Shobhan
	 * @description Method to select city
	 */
	public void selectFirstCity() {
		mobileActionUtil.clickOnMobileElement(selectFirstCityOtn, "Select City");
	}

	/**
	 * @author Shobhan
	 * @description Method to select date
	 */
	public void enterDate(String date) {
		mobileActionUtil.clickOnMobileElement(selectDate(date), "Select Date");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Adults Plus Button
	 */
	public void increseAdultNumber() {
		mobileActionUtil.clickOnMobileElement(adultsPlusBtn, "Adults Plus");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Adults Minus Button
	 */
	public void decreseAdultNumber() {
		mobileActionUtil.clickOnMobileElement(adultsMinusBtn, "Adults Minus ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Childern Plus Button
	 */
	public void increseChildrenNumber() {
		mobileActionUtil.clickOnMobileElement(childrenPlusBtn, "Children Plus ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Childern Minus Button
	 */
	public void decreseChildrenNumber() {
		mobileActionUtil.clickOnMobileElement(childrenMinusBtn, " Children Minus");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Infants Plus Button
	 */
	public void increseInfantsNumber() {
		mobileActionUtil.clickOnMobileElement(infantsPlusBtn, "Infants Plus ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Infants Minus Button
	 */
	public void decreseInfantsNumber() {
		mobileActionUtil.clickOnMobileElement(infantsMinusBtn, "Infants Minus ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Done Button
	 */
	public void clickOnDone() {
		mobileActionUtil.clickOnMobileElement(doneBtn, "Infants Minus ");
	}

	/**
	 * @author Shobhan
	 * @description Method to click on Search Button
	 */
	public void clickOnSearch(String date) {
		mobileActionUtil.clickOnMobileElement(searchBtn, "search");
	}

	/**
	 * @author Shobhan
	 * @description Method to verify searched flights 
	 */
	public String getTextSearchingForflights() {
		return mobileActionUtil.getText(searchingForFlightsTxt);
	}

	/**
	 * @author Shobhan
	 * @description Method to verify From City Text
	 */
	public String getFromCityNameOnPrompt() {
		mobileActionUtil.waitForElement(fromTxtBx, seconds, "fromTxtBx");
		return mobileActionUtil.getText(fromTxtBx);
	}

	/**
	 * @author Shobhan
	 * @description Method to verify To City Text
	 */
	public String getToCityNameOnPrompt() {
		mobileActionUtil.waitForElement(toTxtBx, seconds, "fromTxtBx");
		return mobileActionUtil.getText(toTxtBx);
	}

	/**
	 * @author Shobhan
	 * @description Method to verify date
	 */
	public String getDateOnPrompt() {
		return mobileActionUtil.getText(loaderDateTxt);
	}

	/**
	 * @author Shobhan
	 * @description Method to verify City Details
	 */
	public void verifyFirstprompt( String expectedText1, String expectedText2,
			String expectedText3) {
		System.out.println();
		String fromCity = getFromCityNameOnPrompt();
		String toCity = getToCityNameOnPrompt();
		String date = getDateOnPrompt();
		System.out.println(fromCity);
		System.out.println(toCity);
		System.out.println(date);
		mobileActionUtil.verifyText(fromCity, expectedText1);
		mobileActionUtil.verifyText(toCity, expectedText2);
		mobileActionUtil.verifyText(date, expectedText3);

	}

	
	/**
	 * @author Harsha K.B
	 * @description Method to Select the Departure Date 
	 *      Date should be in format yyyy-mm-dd
	 *      Month name is converted into TitleCase as xpath element requirement
	 */
	public void selectDepartureDate(String date) throws InterruptedException
	{
		String[] dtvals=getDateVals(date);
		String mnthyear=dtvals[1]+" " +dtvals[2];
		int day=Integer.parseInt(dtvals[0]);
		scrollToMonthYear(mnthyear);
		mobileActionUtil.tapOnElement(driver.findElement(By.xpath("//android.widget.TextView[@text='"+ mnthyear +"']/following-sibling::android.view.ViewGroup[@resource-id='com.justdial.search:id/calendar_grid']/descendant::android.widget.TextView[@text="+day+"]/ancestor::android.widget.FrameLayout[1]")));
		
	}
	
	
	/**
	 * @author Harsha K.B
	 * @description This method takes date as a String and returns an
	 *  array of String splitting Year,Month & Day 
	 *  Date to be sent in the format 2020-12-03 i.e. Year-Month-Date
	 *      
	 */
	
	//Date to be sent in the format 2020-12-03 i.e. Year-Month-Date
	public static String[] getDateVals(String date)
	{
		
		String[] dateVals=new String[3];
		
		LocalDate dt = LocalDate.parse(date);
		dateVals[0]=Integer.toString(dt.getDayOfMonth());
		dateVals[1]=toTitleCase(dt.getMonth().toString());
		dateVals[2]=Integer.toString(dt.getYear());
        return dateVals;
	}
	
	
	/**
	 * @author Harsha K.B
	 * @description This method takes a String and returns Propercase of the input
	 *      
	 */
	private static String toTitleCase(String str) {

		if (str == null || str.isEmpty())
			return "";

		if (str.length() == 1)
			return str.toUpperCase();

		// split the string by space
		String[] parts = str.split(" ");

		StringBuilder sb = new StringBuilder(str.length());

		for (String part : parts) {

			if (part.length() > 1)
				sb.append(part.substring(0, 1).toUpperCase()).append(part.substring(1).toLowerCase());
			else
				sb.append(part.toUpperCase());

			sb.append(" ");
		}

		return sb.toString().trim();
	}
	
	
	public void scrollToMonthYear(String mnthyear) throws InterruptedException
	{

		mobileActionUtil.scrollToElement(mnthyear);
	}
	
	/**
	 * @author Harsha K.B
	 * @description This method will verify if Flights are sorted by Prices in Ascending order
	 *      
	 */
	public void validateIfFlightsAreSortedByRateAscending() throws ParseException
	{
        List<WebElement> lstflightlist=driver.findElements(By.xpath("//android.widget.ListView[@resource-id='sortResult']/android.view.View/android.view.View"));
		
		ArrayList<Integer> al1=new ArrayList<>();
		
		for(WebElement we:lstflightlist)
		{
			String[] strvals=we.getText().split(" ");
			System.out.println(strvals[strvals.length-1]);
			al1.add(NumberFormat.getNumberInstance(Locale.UK).parse(strvals[strvals.length-1]).intValue());
		}
		
		ArrayList<Integer> al2=new ArrayList(al1);
		Collections.sort(al1);
		if(al1.equals(al2))
			System.out.println("Prices are sorted in ascending order");
		else
			System.out.println("Prices are not sorted in ascending order");
	}
	
	
	/**
	 * @author Harsha K.B
	 * @description This method will verify if Flights are sorted by Prices in Descending order
	 *      
	 */
	
	public void validateIfFlightsAreSortedByRateDescending() throws ParseException
	{
        List<WebElement> lstflightlist=driver.findElements(By.xpath("//android.widget.ListView[@resource-id='sortResult']/android.view.View/android.view.View"));
		
		ArrayList<Integer> al1=new ArrayList<>();
		
		for(WebElement we:lstflightlist)
		{
			String[] strvals=we.getText().split(" ");
			System.out.println(strvals[strvals.length-1]);
			al1.add(NumberFormat.getNumberInstance(Locale.UK).parse(strvals[strvals.length-1]).intValue());
		}
		
		ArrayList<Integer> al2=new ArrayList(al1);
		Collections.sort(al1);
		Collections.reverse(al1);
		
		if(al1.equals(al2))
			System.out.println("Prices are sorted in descending order");
		else
			System.out.println("Prices are not sorted in descending order");
	}
	
	
	/**
	 * @author Harsha K.B
	 * @description This method will verify if Flights are sorted by Duration in Ascending order
	 *      
	 */
	
	public void validateIfFlightsAreSortedByDurationAscending() throws ParseException
	{
        List<WebElement> lstflightlist=driver.findElements(By.xpath("//android.widget.ListView[@resource-id='sortResult']/android.view.View/android.view.View"));
		
		ArrayList<Integer> al1=new ArrayList<>();
		
		for(WebElement we:lstflightlist)
		{
			String[] strvals=we.getText().split(" ");
			String[] filvals=filterValuesInArray(strvals);
			String strhr=filvals[2];
			String strmins=filvals[3];
			int hr=Integer.parseInt(strhr.substring(0, strhr.length()-1));
			int mins=Integer.parseInt(strmins.substring(0, strmins.length()-1));
			al1.add((hr*60) + mins);
		
		}
		
		
		  ArrayList<Integer> al2=new ArrayList(al1); Collections.sort(al1);
		  
		  
		  if(al1.equals(al2))
		    System.out.println("Durations are sorted in Ascending order");
		  else
		     System.out.println("Durations are not sorted in Ascending order");
		  
		  System.out.println(al1);
		  System.out.println(al2);
	}
	
	
	/**
	 * @author Harsha K.B
	 * @description This method will verify if Flights are sorted by Duration in Descending order
	 *      
	 */
	
	public void validateIfFlightsAreSortedByDurationDescending() throws ParseException
	{
        List<WebElement> lstflightlist=driver.findElements(By.xpath("//android.widget.ListView[@resource-id='sortResult']/android.view.View/android.view.View"));
		
		ArrayList<Integer> al1=new ArrayList<>();
		
		for(WebElement we:lstflightlist)
		{
			String[] strvals=we.getText().split(" ");
			String[] filvals=filterValuesInArray(strvals);
			String strhr=filvals[2];
			String strmins=filvals[3];
			int hr=Integer.parseInt(strhr.substring(0, strhr.length()-1));
			int mins=Integer.parseInt(strmins.substring(0, strmins.length()-1));
			al1.add((hr*60) + mins);
		
		}
		
		
		  ArrayList<Integer> al2=new ArrayList(al1); 
		  Collections.sort(al2);
		  Collections.reverse(al2);  
		  
		  if(al1.equals(al2))
		    System.out.println("Durations are sorted in Descending order");
		  else
		     System.out.println("Durations are not sorted in Descending order");
		  System.out.println(al1);
		  System.out.println(al2);
	}
	
	
	
	/**
	 * @author Harsha K.B
	 * @description This method will verify if Flights are sorted by FlightTime in Ascending order
	 *      
	 */
	
	public void validateIfFlightsAreSortedByTimeAscending() throws ParseException
	{
        List<WebElement> lstflightlist=driver.findElements(By.xpath("//android.widget.ListView[@resource-id='sortResult']/android.view.View/android.view.View"));
		
		ArrayList<LocalTime> al1=new ArrayList<>();
		
		for(WebElement we:lstflightlist)
		{
			String[] strvals=we.getText().split(" ");
			String[] filvals=filterValuesInArray(strvals);
			String strtime=filvals[0];
			
			
			al1.add(LocalTime.parse(strtime));
		
		}
		
		
		
		  ArrayList<LocalTime> al2=new ArrayList(al1);
		  Collections.sort(al1);
		
		  
		  
		  if(al1.equals(al2))
		     System.out.println("Flight Timings are sorted in Ascending order");
		  else
		         System.out.println("Flight Timings are not sorted in Ascending order");
		  
		  System.out.println(al1); 
		  System.out.println(al2);
		 
	}
	
	/**
	 * @author Harsha K.B
	 * @description This method will verify if Flights are sorted by FlightTime in Ascending order
	 *      
	 */
	
	public void validateIfFlightsAreSortedByTimeDescending() throws ParseException
	{
        List<WebElement> lstflightlist=driver.findElements(By.xpath("//android.widget.ListView[@resource-id='sortResult']/android.view.View/android.view.View"));
		
		ArrayList<LocalTime> al1=new ArrayList<>();
		
		for(WebElement we:lstflightlist)
		{
			String[] strvals=we.getText().split(" ");
			String[] filvals=filterValuesInArray(strvals);
			String strtime=filvals[0];
			
			
			al1.add(LocalTime.parse(strtime));
		
		}
		System.out.println(al1);
		
		
		  ArrayList<LocalTime> al2=new ArrayList(al1);
		  Collections.sort(al1);
		  Collections.reverse(al1);
		  
		  
		  if(al1.equals(al2))
		     System.out.println("Flight Timings are sorted in Descending order");
		  else
		         System.out.println("Flight Timings are not sorted in Descending order");
		  
		  System.out.println(al1); 
		  System.out.println(al2);
		 
	}
	/**
	 * @author Harsha K.B
	 * @description This method will filter the values required for processing the result to check if
	 * prices are sorted,durations are sorted or Times are sorted
	 *      
	 */
	
	public String[] filterValuesInArray(String[] flightdetails)
	{
		String filteredvalues[]=new String[6];
		
		//we have to fetch 4 values before | symbol in the text available in the results of sorting
		//since it is a single text ,we have process accordingly
		int pipeindex =getIndexOfSymbolInArray(flightdetails);
		filteredvalues[0]=flightdetails[pipeindex-5];//get start time
		filteredvalues[1]=flightdetails[pipeindex-3];//get end time
		filteredvalues[2]=flightdetails[pipeindex-2];//get hrs
		filteredvalues[3]=flightdetails[pipeindex-1];//get mins
		filteredvalues[filteredvalues.length-1]=flightdetails[flightdetails.length-1];
		
		return filteredvalues;
	}
	/**
	 * @author Harsha K.B
	 * @description This method is used in conjunction with filterValuesInArray()
	 *      
	 */
	public int getIndexOfSymbolInArray(String[] flightdetails)
	{
		int index=0;
		for(int i=0;i<flightdetails.length-1;i++)
		{
			if(flightdetails[i].equals("|"))
			{
				index=i;
				break;
			}
		}
		return index;
	}
	
}