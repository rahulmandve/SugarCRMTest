package com.sugarcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sugarcrm.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//*[@id='companyLogo']/a/img")
	WebElement companyLogo;
	
	@FindBy(xpath="//input[@id='user_name']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='button primary' and @id='login_button']")
	WebElement loginbutton;
	
	public LoginPage() {
	PageFactory.initElements(d,this);
	}
	public String verifyPageTitle()
	{
		return d.getTitle();
	}
	
	public boolean verifyCompanyLogo()
	{
		return companyLogo.isDisplayed();
	}
	public HomePage login(String un,String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass);
		loginbutton.click();
		return new HomePage();	
	}

}
