package com.sugarcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sugarcrm.base.TestBase;

public class ProjectsPage extends TestBase{
	
	
	@FindBy(xpath="//a[@id='create_link']")
	WebElement createlink;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='estimated_start_date']")
	WebElement startdate;
	
	@FindBy(xpath="//input[@id='estimated_end_date']")
	WebElement enddate;
	
	@FindBy(xpath="//input[@id='SAVE_HEADER']")
	WebElement savebtn;
	
	public ProjectsPage() {
		PageFactory.initElements(d,this);
	}
	public ProjectsPage clickOnCreateLink()
	{
		createlink.click();
		return new ProjectsPage();
	}
	public void createProjects(String pname,String status,String priority,String start,String end)
	{
		name.sendKeys(pname);
		
		Select s=new Select(d.findElement(By.xpath("//select[@id='status']")));
		s.selectByValue(status);
	
		Select s1=new Select(d.findElement(By.xpath("//select[@id='priority']")));
		s1.selectByValue(priority);
		
		startdate.sendKeys(start);
		enddate.sendKeys(end);
		savebtn.click();

	}
	

}
