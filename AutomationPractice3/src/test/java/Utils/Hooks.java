package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends TestBase{
	TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
		@After
		public void AfterScenario() throws IOException
		{
			System.out.println("Hi");
			System.out.println(testContextSetup.testBase.WebDriverManager());
			testContextSetup.testBase.WebDriverManager().quit();
			//WebDriver driver= new ChromeDriver();
			//driver.quit();
		}
		@AfterStep
		public void TakeScreenShot(Scenario scenario) throws IOException
		{
			WebDriver driver=testContextSetup.testBase.driver;
			if(scenario.isFailed())
			{
					File Sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					byte[] contentType=FileUtils.readFileToByteArray(Sourcepath);
					scenario.attach(contentType, "image/png", "image");
			}
		}
		
		
}
//In the context of Java system properties, the -D flag is used to set a system property when running a Java application or a test.
//It allows you to pass key-value pairs as arguments to the Java Virtual Machine (JVM) when starting your application or tests.