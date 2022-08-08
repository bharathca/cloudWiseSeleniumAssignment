package cucumber.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup contextSetup;
	public Hooks(TestContextSetup contextSetup) {
		this.contextSetup = contextSetup;
	}
	@After
	public void AfterScenario() throws IOException {
		contextSetup.browserInstance.webDriverManager().quit();

	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		WebDriver driver =contextSetup.browserInstance.webDriverManager();
		if(scenario.isFailed()) {
			File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
			System.out.println(scenario.getLine());
		}
	}
}
