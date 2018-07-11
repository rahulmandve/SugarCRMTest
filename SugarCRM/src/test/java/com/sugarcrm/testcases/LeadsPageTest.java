package com.sugarcrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sugarcrm.base.TestBase;
import com.sugarcrm.pages.HomePage;
import com.sugarcrm.pages.LeadsPage;
import com.sugarcrm.pages.LoginPage;
import com.sugarcrm.util.TestUtil;

public class LeadsPageTest extends TestBase{
	
	LoginPage loginpage;
	LeadsPage leadspage;
	HomePage homepage;
	TestUtil testutil;
	String sheetname="leads";
	public LeadsPageTest() {
	super();	
	}
	
	@BeforeMethod
	public void setUp()
	{
		launchBrowser();
		loginpage=new LoginPage();
		leadspage=new LeadsPage();
		homepage=new HomePage();
		testutil=new TestUtil();
		
		loginpage.login(pro.getProperty("username"),pro.getProperty("password"));
	}
	@DataProvider
	public Object[][] testData()
	{
		Object [][]data=TestUtil.testData(sheetname);
		return data;
	}
	@Test(priority=1,dataProvider="testData")
	public void createLeadsTest(String title,String ftname,String ltname,String mobileno)
	{	homepage.clickOnLeadsLink();
		leadspage.clickOnCreateLink();
		leadspage.createLeads(title, ftname, ltname, mobileno);
	}
	
	@AfterMethod
	public void close()
	{
		d.quit();
	}
}
