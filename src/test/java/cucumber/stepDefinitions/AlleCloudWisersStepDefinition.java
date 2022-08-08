package cucumber.stepDefinitions;


import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AlleCloudWisersPage;
import utils.TestContextSetup;


public class AlleCloudWisersStepDefinition {
	public WebDriver driver;
	public TestContextSetup contextSetup;
	public AlleCloudWisersPage alleCloudWisersPage;
	public Set<String> duplicateNames = new HashSet<String>();
	

	public AlleCloudWisersStepDefinition(TestContextSetup contextSetup) {
		this.contextSetup = contextSetup;
		this.alleCloudWisersPage = contextSetup.manager.getAlleCloudWisersPage();
	}


	@When("^User clicks on all the departments and get all the employees$")
    public void user_clicks_on_all_the_departments_and_get_all_the_employees() throws Throwable {
        alleCloudWisersPage.clickOnAllDepartmentsAndGetAllEmployees();
    }

	@Then("^Print all the members names as per the department$")
    public void print_all_the_members_names_as_per_the_department() throws Throwable {
		duplicateNames.add("Marco"); duplicateNames.add("Wesley"); duplicateNames.add("Martijn"); duplicateNames.add("Mats");
		duplicateNames.add("Mark");duplicateNames.add("Anouk"); duplicateNames.add("Jeffrey");
		Assert.assertEquals(alleCloudWisersPage.findDuplicateEmployeeNames(), duplicateNames); 
    }

}
