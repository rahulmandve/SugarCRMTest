package com.sugarcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sugarcrm.base.TestBase;

public class TasksPage extends TestBase{
	@FindBy(xpath="//a[@id='create_link']")
	WebElement createlink;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement subject;
	
	@FindBy(xpath="//input[@id='date_due_date']")
	WebElement duedate;
	
	@FindBy(xpath="//input[@id='contact_name']")
	WebElement contactname;
	
	@FindBy(xpath="//input[@id='SAVE_HEADER']")
	WebElement savebtn;
	
	public TasksPage() {
		PageFactory.initElements(d,this);
	}
	public TasksPage clickOnCreateLink()	
	{
		createlink.click();
		return new TasksPage();
	}
	public void createTasks(String sub,String stat,String duedat,String contname,String pri)
	{
		subject.sendKeys(sub);
		Select s=new Select(d.findElement(By.xpath("//select[@id='status']")));
		s.selectByValue(stat);
		duedate.sendKeys(duedat);
		contactname.sendKeys(contname);
		Select s1=new Select(d.findElement(By.xpath("//select[@id='priority']")));
		s1.selectByValue(pri);
		savebtn.click();	
	}

}

