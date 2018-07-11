package com.sugarcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sugarcrm.base.TestBase;

public class LeadsPage extends TestBase{
	@FindBy(xpath="//*[@id='moduleTab_0_Leads']")
	WebElement leadslink;
	
	@FindBy(xpath="//a[contains(text(),'Create') and @class='utilsLink']")
	WebElement createlink;
	
	@FindBy(xpath="//*[@id='SAVE_HEADER']")
	WebElement savebtn;
	
	@FindBy(xpath="//*[@id='CANCEL_HEADER']")
	WebElement cancelbtn;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement fname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lname;
	
	@FindBy(xpath="//input[@name='phone_mobile']")
	WebElement mobile;
	@FindBy(xpath="//input[@id='SAVE_HEADER' and @title='Save']")
	WebElement btn;
	
	public LeadsPage() {
	PageFactory.initElements(d,this);
	}
	public LeadsPage clickOnCreateLink()
	{
		createlink.click();
		return new LeadsPage();
	}
	public boolean verifySaveButton()
	{
		return savebtn.isDisplayed();
	}
	public boolean verifyCancelButton()
	{
		return cancelbtn.isDisplayed();
	}
	public void createLeads(String title,String ftname,String ltname,String mobileno)
	{
		Select s=new Select(d.findElement(By.xpath("//*[@id='salutation']")));
		s.selectByValue(title);
		fname.sendKeys(ftname);
		lname.sendKeys(ltname);
		mobile.sendKeys(mobileno);
		btn.click();
		
	}

}
