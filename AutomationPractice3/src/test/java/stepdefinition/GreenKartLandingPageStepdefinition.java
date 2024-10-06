package stepdefinition;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageClasses.LandingPage;
import PageClasses.OfferPage;
import Utils.GenericHelper;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartLandingPageStepdefinition {
	public WebDriver driver;
	String landingpageproductname;
	String offerpageproductname;
	TestContextSetup testContextSetup;
	public GreenKartLandingPageStepdefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Given("user land on green kart page")
	public void user_land_on_green_kart_page() throws IOException 
	{
		/*
		 * testContextSetup.driver =new ChromeDriver();
		 * testContextSetup.driver.manage().window().maximize();
		 * testContextSetup.driver.get(
		 * "https://rahulshettyacademy.com/seleniumPractise/#/");
		 */
		
		testContextSetup.testBase.WebDriverManager();
		
	}
	@When("^user searched the product name (.+) and extracted the actual name$")
	public void user_searched_the_product_name_and_extracted_the_actual_name(String shortname) throws InterruptedException, IOException 
	{
		
		LandingPage landingPage= new LandingPage(testContextSetup.testBase.WebDriverManager());
		landingPage.SearchText(shortname);
	    Thread.sleep(2000);
	    testContextSetup.landingpageproductname =landingPage.getProductName().split("-")[0].trim();
	    System.out.println("The located product is "+testContextSetup.landingpageproductname);
	}
	@Then("^user searched the same name (.+) in offers page$")
	public void user_searched_the_same_name_in_offers_page(String shortname) throws InterruptedException, IOException {
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		LandingPage landingPage=new LandingPage(testContextSetup.testBase.WebDriverManager());
		landingPage.TopDealsLink();
		Thread.sleep(2000);
		GenericHelper genericHelper=new GenericHelper(testContextSetup.testBase.WebDriverManager());
		genericHelper.SwitchToHandle();
		Thread.sleep(1000);
		OfferPage offerPage= new OfferPage(testContextSetup.testBase.WebDriverManager());
		offerPage.SearchText(shortname);		
		offerpageproductname=offerPage.getProductName();

	}
	
	
	@Then("user validate product name in offer page with landing page")
	public void user_validate_product_name_in_offer_page_with_landing_page() throws IOException 
	{
	
		Assert.assertEquals(testContextSetup.landingpageproductname, offerpageproductname);
//		testContextSetup.testBase.WebDriverManager().quit();
		
	}
	

}
