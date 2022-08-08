package cucumber.stepDefinitions;

import static org.testng.Assert.assertTrue;
import io.cucumber.java.en.When;
import lib.selenium.base.SeleniumBase;
import pageObjects.CloudWiseHomePage;
import utils.TestContextSetup;

public class CloudWiseHomeStepDefinition {
	public TestContextSetup contextSetup;
	CloudWiseHomePage cloudWiseHomePage;
	SeleniumBase seleniumBase;
	
	public CloudWiseHomeStepDefinition(TestContextSetup contextSetup) {
		this.contextSetup = contextSetup;
		this.cloudWiseHomePage  = contextSetup.manager.getCloudWiseHomePage();
		this.seleniumBase= contextSetup.seleniumBase;
	}

	@When("^User is now on \"([^\"]*)\" page$")
	public void user_is_now_on_something_page(String strArg1) throws Throwable {
		assertTrue(contextSetup.seleniumBase.verifyTitle(strArg1));
	}

	@When("^User accepts the cookie$")
	public void user_accepts_the_cookie() throws Throwable {
		seleniumBase.click(seleniumBase.locateElement(cloudWiseHomePage.acceptCookie));
	}

	@When("^User hovers on Dit is Cloudwise from the main navigation of the page$")
	public void user_hovers_on_dit_is_cloudwise_from_the_main_navigation_of_the_page() throws Throwable {
		seleniumBase.moveToElement(seleniumBase.locateElement(cloudWiseHomePage.ditIsCloudwise));
	}

	@When("^User clicks on Alle Cloudwisers$")
	public void user_clicks_on_alle_cloudwisers() throws Throwable {
		seleniumBase.click(seleniumBase.locateElement(cloudWiseHomePage.alleCloudwisers));
	}

}
