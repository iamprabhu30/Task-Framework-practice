package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class TestContextSetup {
	
	public WebDriver driver;
	public String landingpageproductname;
	public TestBase testBase;
	public Hooks hooks;
	/*
	 * public TestContextSetup(TestBase testBase) { this.testBase=testBase;
	 * //this.hooks=hooks; }
	 */
	public TestContextSetup() throws IOException
	{
		testBase=new TestBase();
		
		
		
	}

}
