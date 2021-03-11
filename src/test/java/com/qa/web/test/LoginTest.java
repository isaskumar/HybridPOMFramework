package com.qa.web.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.web.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void loginTest() throws IOException {
		logger.info("URL is opened");
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("UserName Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickLogin();
		logger.info("Login Button Clicked");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage12")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			takeScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}
