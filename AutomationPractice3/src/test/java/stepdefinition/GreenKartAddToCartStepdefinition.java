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
import PageClasses.PlaceOrderPage;
import Utils.GenericHelper;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartAddToCartStepdefinition {
	public WebDriver driver;
	String landingpageproductname;
	String offerpageproductname;
	TestContextSetup testContextSetup;
	public GreenKartAddToCartStepdefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	@Then("user click on add to cart")
	public void user_click_on_add_to_cart() throws IOException, InterruptedException {
		LandingPage landingpage = new LandingPage(testContextSetup.testBase.WebDriverManager());
		landingpage.clickonAddToCart();	
		Thread.sleep(1000);
		System.out.println("click on the add to cart page and navigate to place order page");
		}
	@Then("user click on Place order")
	public void user_click_on_place_order() throws IOException {
		
		PlaceOrderPage placeorderpage = new PlaceOrderPage(testContextSetup.testBase.WebDriverManager());
		placeorderpage.clickOnPlaceOrder();
		System.out.println("click on the place order");
	}
	@Then("user select the {string} and click on proceed")
	public void user_select_the_and_click_on_proceed(String country) throws IOException, InterruptedException {
		PlaceOrderPage placeorderpage = new PlaceOrderPage(testContextSetup.testBase.WebDriverManager());
		String c= placeorderpage.selectDDCountry(country);
		System.out.println("selected the country "+ c);
		Thread.sleep(1000);
		placeorderpage.clickTermsandCondition();
		System.out.println("check box selected");
		Thread.sleep(1000);
		placeorderpage.clickOnproceed();
		Thread.sleep(1000);
		testContextSetup.testBase.WebDriverManager().quit();
		
	}

	

}
