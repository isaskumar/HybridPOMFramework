package com.qa.web.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.web.utils.ReadConfig;

public class BaseTest {

	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicaionURL();
	public String username = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;


	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		logger = Logger.getLogger("Web Application");
		PropertyConfigurator.configure("Log4j.properties");

		if(browser.equals("chrome")) {
			System.getProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static void takeScreenshot(WebDriver driver, String name) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + name + ".png"));
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(9);
		return(generatedString);
	}

	public static String randomNumber() {
		String generateNumeber = RandomStringUtils.randomNumeric(6);
		return(generateNumeber);
	}

}
