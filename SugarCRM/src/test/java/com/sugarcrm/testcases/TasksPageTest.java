package com.sugarcrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sugarcrm.base.TestBase;
import com.sugarcrm.pages.HomePage;
import com.sugarcrm.pages.LoginPage;
import com.sugarcrm.pages.TasksPage;
import com.sugarcrm.util.TestUtil;

public class TasksPageTest extends TestBase{
	LoginPage loginpage;
	TestUtil testutil;
	TasksPage taskspage;
	HomePage homepage;
	String sheetname="tasks";
	
	
	public TasksPageTest() {
	super();
	}
	@BeforeMethod
	public void setUp()
	{
		launchBrowser();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		taskspage=new TasksPage();
		homepage=new HomePage();
		loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] testData()
	{
	Object[][] data=testutil.testData(sheetname);
	 return data;
	}
	
	@Test(priority=1,dataProvider="testdata")
	public void createTasks(String subj,String stat,String date,String name,String prio)
	{
		homepage.clickOnSalesLink();
		taskspage.clickOnCreateLink();
		taskspage.createTasks(subj, stat, date, name, prio);
	}
	
	@AfterMethod
	public void close()
	{
		d.quit();
	}

}
