package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import lib.selenium.base.SeleniumBase;
import pageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public List<String> cloudWiseMemberNames=new ArrayList<String>();
	public PageObjectManager manager;
	public BrowserInstance browserInstance;
	public SeleniumBase seleniumBase;
	
	public TestContextSetup() throws FileNotFoundException, IOException {
		browserInstance = new BrowserInstance();
		manager = new PageObjectManager(browserInstance.webDriverManager());
		seleniumBase = new SeleniumBase(browserInstance.webDriverManager());
	}
	
}
