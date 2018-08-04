package com.sugarcrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sugarcrm.base.TestBase;
import com.sugarcrm.pages.HomePage;
import com.sugarcrm.pages.LoginPage;
import com.sugarcrm.pages.MarketingPage;
import com.sugarcrm.pages.SalesPage;
import com.sugarcrm.pages.SupportPage;

public class HomepageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	MarketingPage marketingpage;
	SalesPage salespage;
	SupportPage supportpage;
	
	public HomepageTest() {
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		launchBrowser();
		loginpage=new LoginPage();
		homepage=new HomePage();
		marketingpage=new MarketingPage();
		salespage=new SalesPage();
		supportpage=new SupportPage();
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		
	}
	@Test(priority=1)
	public void verifyPageTitleTest()
	{
		String title=homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "SugarCRM","Homepage Title not matched");
		System.out.println(title);
	}
	@Test(priority=2)
	public void verifyUserName()
	{
		Assert.assertTrue(homepage.verifyUserName());
		System.out.println("user name is valid");
	}
	@Test(priority=3)
	public void verifyMarketingLinkTest()
	{
		marketingpage=homepage.clickOnMarketingLink();
		System.out.println("Marketing linke is present");
	}
	@Test(priority=4)
	public void verifySalesLinkTest()
	{
		salespage=homepage.clickOnSalesLinke();
		System.out.println("Sales link is present");
	}
	@Test(priority=5)
	public void verifySupportLinkTest()
	{
		supportpage=homepage.clickOnSupportLink();
		System.out.println("Support link is present");
	}
	
	@AfterMethod
	public void close()
	{
		d.quit();
	}

}


