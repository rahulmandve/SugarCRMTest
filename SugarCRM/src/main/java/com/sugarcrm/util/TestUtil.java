package com.sugarcrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sugarcrm.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITWAIT=10;
	public static Workbook  book;
	public static Sheet sheet;
	public static String excelpath="C:\\Users\\hp\\Desktop\\SugarCRM_testData.xlsx";
	

	public void switchToFrame()
	{
		d.switchTo().frame(0);
	}
	public static Object[][]testData(String sheetname)
	{
		FileInputStream fis=null;
		try{
			
			fis=new FileInputStream(excelpath);
			
			book=WorkbookFactory.create(fis);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
						
			}
		}
		return data;
	}
	
	public static void takeScreenShot() throws Exception
	{
		SimpleDateFormat s=new SimpleDateFormat("dd_MM_YYYY hh_mm_ss");
		Date date=new Date();
		String str=s.format(date);
		
		File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		String currentdir=System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(currentdir+"/Screenshot/"+str+".png"));
	}
	
}
