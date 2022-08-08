package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlleCloudWisersPage {

	public WebDriver driver;
	private String departments = "(//div[@class='nectar-flip-box'])";
	private String departmentLinks = "(//span[contains(text(),'Wie zijn wij')])";
	private By employees = By.xpath("//div[@class = 'nectar-flip-box']//h3");
	private List<String> employeeList = new ArrayList<String>();

	JavascriptExecutor js;

	public AlleCloudWisersPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	public void clickOnAllDepartmentsAndGetAllEmployees() throws InterruptedException {
		List<WebElement> allDepartments = driver.findElements(By.xpath(departments));
		for(int i =1; i<=allDepartments.size();i++) {
			WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(departments+"["+i+"]")));
			hoverOnCard(driver.findElement(By.xpath(departments+"["+i+"]")));
			Thread.sleep(1000);
			driver.findElement(By.xpath(departmentLinks+"["+i+"]")).click();
			Thread.sleep(2000);
			scrollToSpecificSection(0,300);
			List<WebElement> allEmployees = driver.findElements(employees);
			for (WebElement eachEmployee : allEmployees) {
				employeeList.add(eachEmployee.getText());
			}
			driver.navigate().back();		

			Thread.sleep(2000);
		}
	}

	public void scrollToElementSection(WebElement department) {
		js.executeScript("arguments[0].scrollIntoView();", department);		
	}

	public void hoverOnCard(WebElement department) {
		Actions actions = new Actions(driver);
		actions.moveToElement(department).perform();
	}

	public void scrollToSpecificSection(int x, int y) {
		js.executeScript("window.scrollBy("+x+","+y+")");
	}

	public Set<String> findDuplicateEmployeeNames() {
		Set<String> duplicates = new HashSet<String>();
		final Set<String> set = new HashSet<String>();

		for (String employee : employeeList) {
			if (!set.add(employee)) {
				duplicates.add(employee);
			}
		}
		System.out.println("Total Employees names:");
		for (String string : employeeList) {
			System.out.println(string);
		}

		System.out.println("Duplicate names occuring two or more times: ");
		for (String string : duplicates) {
			System.out.println(string);
		}
		return duplicates;
	}
}
