package com.sugarcrm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.sugarcrm.util.TestUtil;
import com.sugarcrm.util.WebEventListner;

public class TestBase {
	public static WebDriver d;
	public static Properties pro;
	public static EventFiringWebDriver driver;
	public static WebEventListner elistner;

	public TestBase() {
	try{
		FileInputStream fis=new FileInputStream("C:/Users/hp/git/SugarCRMTest/SugarCRM/src/main/java/com/sugarcrm/config/config.property");
	
		pro=new Properties();
		pro.load(fis);
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}
	
	}
	public static void launchBrowser()
	{
	String browsername=pro.getProperty("browser");
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\chromedriver_win32\\chromedriver.exe");
		d=new ChromeDriver();
	}
	else if(browsername.equals("firefox"))
	{
		d=new FirefoxDriver();
	}
	
	driver=new EventFiringWebDriver(d);
	elistner=new WebEventListner();
	driver.register(elistner);
	
	d = driver;
	
	d.manage().window().maximize();
	d.manage().deleteAllCookies();
	d.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	d.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
	d.get(pro.getProperty("url"));

	}
	
	
	

}
