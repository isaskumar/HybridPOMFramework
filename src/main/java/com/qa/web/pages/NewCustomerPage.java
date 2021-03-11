package com.qa.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver driver;

	public NewCustomerPage(WebDriver rdriver){
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement lnkAddCustomer;
	
	@FindBy(name="name")
	WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	WebElement rGender;
	
	@FindBy(id="dob")
	WebElement txtdob;
	
	@FindBy(name="addr")
	WebElement txtaddress;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="pinno")
	WebElement txtpinnumber;
	
	@FindBy(name="telephoneno")
	WebElement txtphonenumber;
	
	@FindBy(name="emailid")
	WebElement txtemail;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="sub")
	WebElement btnsubmit;
	
	public void clickAddCustomer() {
		lnkAddCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void cusGender(String cgender) {
		rGender.click();
	}
	
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);	
	}
	
	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}
	
	public void custpinno(String cpinno) {
		txtpinnumber.sendKeys(String.valueOf(cpinno));
	}
	
	public void custtelephoneno(String ctelephoneno) {
		txtphonenumber.sendKeys(ctelephoneno);
	}
	
	public void custemailid(String cemailid) {
		txtemail.sendKeys(cemailid);
	}
	
	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custsubmit() {
		btnsubmit.click();
	}
}
