package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {

	public static WebDriver driver;
	static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("usr.dir") + "/src/main/java/com/crm/qa/config/configuration.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.chrome.driver", "");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.chrome.driver", "");
			driver = new InternetExplorerDriver();
			break;
		case "opera":
			System.setProperty("webdriver.chrome.driver", "");
			driver = new OperaDriver();
			break;
		case "safari":
			System.setProperty("webdriver.chrome.driver", "");
			driver = new SafariDriver();
			break;
		}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("baseurl"));
	}
}
