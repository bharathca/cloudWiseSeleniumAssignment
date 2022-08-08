package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {



	public WebDriver driver;
	public CloudWiseHomePage cloudWiseHomePage;
	public AlleCloudWisersPage alleCloudWisersPage;



	public PageObjectManager(WebDriver driver) {
		this.driver = driver;

	}

	public CloudWiseHomePage getCloudWiseHomePage() {
		cloudWiseHomePage = new CloudWiseHomePage(driver);
		return cloudWiseHomePage;
	}
	
	public AlleCloudWisersPage getAlleCloudWisersPage() {
		alleCloudWisersPage = new AlleCloudWisersPage(driver);
		return alleCloudWisersPage;
	}
	
}
