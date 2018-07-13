package com.sugarcrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sugarcrm.base.TestBase;
import com.sugarcrm.pages.HomePage;
import com.sugarcrm.pages.LoginPage;
import com.sugarcrm.pages.ProjectsPage;
import com.sugarcrm.util.TestUtil;

public class ProjectsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ProjectsPage projectspage;
	String sheetname="project";
	
	
	public ProjectsPageTest() {
	super();
	}
	@BeforeMethod
	public void setUp()
	{
		launchBrowser();
		loginpage=new LoginPage();
		homepage=new HomePage();
		projectspage=new ProjectsPage();
		loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] testdata()
	{
		Object [][] data=TestUtil.testData(sheetname);
		return data;
	}
	@Test(priority=1,dataProvider="testdata")
	public void createProjectsTest(String name,String status,String prio,String sdate,String edate)
	{
		homepage.clickOnProjectsLink();
		projectspage.clickOnCreateLink();
		projectspage.createProjects(name, status, prio, sdate, edate);
		
	}
	
	 @AfterMethod
	 public void close()
	{
		d.quit();
	}

}
