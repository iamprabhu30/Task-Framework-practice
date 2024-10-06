package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/GreenKartSearchProduct.feature",
		glue="stepdefinition",dryRun = false,monochrome = true,tags="@TC01",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
//Extent report plug in office page-https://www.extentreports.com/docs/versions/4/java/cucumber4.html
//com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter

public class GreenKartHomeRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider()
	public Object[] [] scenarios()
	{
		return super.scenarios();
	}

}
