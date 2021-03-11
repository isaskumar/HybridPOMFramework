package com.qa.web.test;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.web.pages.LoginPage;
import com.qa.web.pages.NewCustomerPage;

public class NewCustomerTest extends BaseTest{

	@Test
	public void addCustomer() throws InterruptedException, IOException {
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickLogin();
		Thread.sleep(3000);
		NewCustomerPage nc = new NewCustomerPage(driver);
		nc.clickAddCustomer();
		nc.custName("Sasikumar");
		logger.info("customer name is provided");
		nc.cusGender("male");
		logger.info("customer gender is provided");
		nc.custdob("24", "10", "1990");
		logger.info("customer date of birth is provided");
		Thread.sleep(2000);
		nc.custaddress("INDIA");
		logger.info("customer address is provided");
		nc.custcity("Salem");
		logger.info("customer city is provided");
		nc.custstate("TN");
		logger.info("customer state is provided");
		nc.custpinno("636201");
		logger.info("customer pin code is provided");
		nc.custtelephoneno("3486321518");
		logger.info("customer phone is provided");
		String email = randomString()+"@yahoo.com";
		nc.custemailid(email);
		logger.info("customer email is provided");
		nc.custpassword("sksksk");
		logger.info("customer password is provided");
		nc.custsubmit();
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("customer registered successfully");
		} else {
			logger.info("customer not registered is provided");
			takeScreenshot(driver,"addCustomer");
			Assert.assertTrue(false);
		}
	}
}
