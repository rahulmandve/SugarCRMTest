package com.sugarcrm.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.sugarcrm.base.TestBase;

public class WebEventListner extends TestBase implements WebDriverEventListener {

	public void afterChangeValueOf(WebElement e, WebDriver d) {
	
		System.err.println("Element value change to :"+e.toString());
	}

	public void afterClickOn(WebElement e, WebDriver d) {
		System.out.println("Clicked on:"+e.toString());
		
	}

	public void afterFindBy(By by, WebElement e, WebDriver d) {
		System.out.println("Found element by:"+by.toString());
		
	}

	public void afterNavigateBack(WebDriver d) {

		System.out.println("Navigate back to previous page");
	}

	public void afterNavigateForward(WebDriver d) {
		System.out.println("Navigate forward to next page");
		
	}

	public void afterNavigateRefresh(WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String url, WebDriver d) {
	
		System.out.println("Navigate to: '"+url+"'");
	}

	public void afterScript(String url, WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement e, WebDriver d) {
		
		System.out.println("value of the"+e.toString()+"befor any change made");
	}

	public void beforeClickOn(WebElement e, WebDriver d) {
		
		System.out.println("Trying to clicking on:"+e.toString());
	}

	public void beforeFindBy(By by, WebElement e, WebDriver d) {
	System.out.println("Trying to find element by:"+by.toString());
		
	}

	public void beforeNavigateBack(WebDriver d) {
		
		System.out.println("Navigate back to previous page");
	}

	public void beforeNavigateForward(WebDriver d) {
	System.out.println("Navigate forwad to next page");
		
	}

	public void beforeNavigateRefresh(WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver d) {
		System.out.println("Befor Navigate to: '"+url+"'");
		
	}

	public void beforeScript(String url, WebDriver d) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable error, WebDriver d) {
		System.out.println("Exception Occured"+error);
		try{
			TestUtil.takeScreenShot();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
