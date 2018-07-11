package com.sugarcrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sugarcrm.base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath="//a[contains(text(),'rahul mandve')]")
	WebElement username;
	
	@FindBy(xpath="//a[contains(text(),'Marketing')]")
	WebElement marketinglink;
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	WebElement saleslink;
	
	@FindBy(xpath="//a[contains(text(),'Support')]")
	WebElement supportlink;
	
	@FindBy(xpath="//a[contains(text(),'Leads') ]")
	WebElement leadslink;
	
	
	public HomePage() {
	PageFactory.initElements(d, this);	
	}
	public String verifyHomePageTitle()
	{
		return d.getTitle();
	}
	public boolean verifyUserName()
	{
		return username.isDisplayed();
	}
	public MarketingPage clickOnMarketingLink()
	{	marketinglink.click();
		return new MarketingPage();
	}
	public SalesPage clickOnSalesLinke()
	{
		saleslink.click();
		return new SalesPage();
	}
	public SupportPage clickOnSupportLink()
	{
		supportlink.click();
		return new SupportPage();
	}
	public void clickOnLeadsLink()
	{
		Actions a=new Actions(d);
		a.moveToElement(marketinglink).build().perform();
		a.moveToElement(leadslink).build().perform();
		leadslink.click();
	}

}
