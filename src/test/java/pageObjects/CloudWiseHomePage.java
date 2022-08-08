package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudWiseHomePage {

	public WebDriver driver;
	
	public CloudWiseHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public	By acceptCookie = By.linkText("Allow all cookies");
	public	By ditIsCloudwise = By.xpath("(//a[@class='sf-with-ul'])[2]");
	public By alleCloudwisers = By.xpath("//li[@id='menu-item-6380']/a[1]");

}
