package lib.selenium.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.selenium.design.LocatorTypes;


public class SeleniumBase {
	public WebDriver driver;
	public Actions act;
	public WebDriverWait wait;
	public JavascriptExecutor js;

	public SeleniumBase(WebDriver driver) {
		this.driver = driver;
		this.act  = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor)driver;
	}


	public void moveToElement(WebElement ele) {
		act.moveToElement(ele).perform();
	}

	public void waitForApperance(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.err.println("Element did not appear after 20 seconds");

		}

	}
	public void click(WebElement ele) {
		try {	
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			if (ele.isEnabled()) {
				ele.click();
			} else {
				js.executeScript("arguments[0].click()", ele);
			}
		} catch (StaleElementReferenceException e) {
			System.err.println("The Element could not be clicked " + e.getMessage());
		} catch (WebDriverException e) {
			System.err.println("The Element could not be clicked " + e.getMessage());
		} catch (Exception e) {
			System.err.println("The Element could not be clicked " + e.getMessage());
		}
	}
	
	public boolean verifyTitle(String title) {
		if(driver.getTitle().equals(title)) {
			return true;
		} else {
			return false;
		}
	}
	
	public WebElement locateElement(By by) {
		try {
			return driver.findElement(by);
		} catch(NoSuchElementException e) {
			System.err.println("No such element is found" + e.getMessage());
		} catch (WebDriverException e) {
			System.err.println("WebDriver Exception: " + e.getMessage());
		}
		return null;
		
	}
	
	public List<WebElement> locateElements(By by) {
		try {
			return driver.findElements(by);
		} catch(NoSuchElementException e) {
			System.err.println("No such element is found" + e.getMessage());
		} catch (WebDriverException e) {
			System.err.println("WebDriver Exception: " + e.getMessage());
		}
		return null;
		
	}
	
	public WebElement locateElement(LocatorTypes locatorType, String value) {
		try {
			switch (locatorType) {
			case CLASS_NAME:
				return driver.findElement(By.className(value));
			case CSS:
				return driver.findElement(By.cssSelector(value));
			case ID:
				return driver.findElement(By.id(value));
			case LINK_TEXT:
				return driver.findElement(By.linkText(value));
			case NAME:
				return driver.findElement(By.name(value));
			case PARTIAL_LINKTEXT:
				return driver.findElement(By.partialLinkText(value));
			case TAGNAME:
				return driver.findElement(By.tagName(value));
			case XPATH:
				return driver.findElement(By.xpath(value));
			default:
				System.err.println("Locator is not Valid");
				break;
			}
		} catch(NoSuchElementException e) {
			System.err.println("No such element is found" + e.getMessage());
		} catch (WebDriverException e) {
			System.err.println("WebDriver Exception: " + e.getMessage());
		}
		return null;
		
	}
	
	public List<WebElement> locateElements(LocatorTypes locatorType, String value) {
		try {
			switch (locatorType) {
			case CLASS_NAME:
				return driver.findElements(By.className(value));
			case CSS:
				return driver.findElements(By.cssSelector(value));
			case ID:
				return driver.findElements(By.id(value));
			case LINK_TEXT:
				return driver.findElements(By.linkText(value));
			case NAME:
				return driver.findElements(By.name(value));
			case PARTIAL_LINKTEXT:
				return driver.findElements(By.partialLinkText(value));
			case TAGNAME:
				return driver.findElements(By.tagName(value));
			case XPATH:
				return driver.findElements(By.xpath(value));
			default:
				System.err.println("Locator is not Valid");
				break;
			}
		} catch(NoSuchElementException e) {
			System.err.println("No such element is found" + e.getMessage());
		} catch (WebDriverException e) {
			System.err.println("WebDriver Exception: " + e.getMessage());
		}
		return null;
		
	}

}
