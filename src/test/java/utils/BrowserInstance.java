package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInstance {

	private WebDriver driver;

	public WebDriver webDriverManager() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//propertiesFiles//config.properties"));
		if(driver == null) {
			switch (prop.getProperty("browser").toLowerCase()) {
			case "chrome": WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); break;
			case "firefox": WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); break;
			case "edge":WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); break;
			case "safari":WebDriverManager.safaridriver().setup(); driver = new SafariDriver(); break;
			default: System.err.println("Browser is not set in the config property");
			break;
			}
			driver.manage().window().maximize();
			driver.get(prop.getProperty("cloudWiseUrl"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
		return driver;

	}
}
