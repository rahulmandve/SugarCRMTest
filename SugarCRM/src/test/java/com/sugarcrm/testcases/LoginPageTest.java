package com.sugarcrm.testcases;
/*
 * Author Rahul Mandve
 * 
 */
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sugarcrm.base.TestBase;
import com.sugarcrm.pages.HomePage;
import com.sugarcrm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
@BeforeMethod
public void setUp()
{
	launchBrowser();
	loginpage=new LoginPage();
}

@Test(priority=1)
public void verifyLoginPageTitleTest()
{
	String title=loginpage.verifyPageTitle();
	Assert.assertEquals(title, "SugarCRM");
}

@Test(priority=2)
public void verifyCompanyLogoTest()
{
	Assert.assertTrue(loginpage.verifyCompanyLogo());
}

@Test()
public void loginTest()
{
	homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));	
}
@AfterMethod
public void closeBrwoser()
{
	d.quit();	
}

}
