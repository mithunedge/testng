package com.abc.magento;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class hybriddrivenexcel 
{

	static WebDriver driver; 
	static XSSFSheet sheet;
	public static String getcellvalue(int rown,int coln)
	{
		XSSFRow row=sheet.getRow(rown);
		XSSFCell cell=row.getCell(coln);
		String cellvalue=cell.getStringCellValue();
		return cellvalue;
		
	}
	
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\mithu\\eclipse-workspace\\hybriddriven\\src\\com\\abc\\utiliries\\hybrid.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(fis);
		//sheet=book.getSheetAt(0);
		sheet=book.getSheet("Sheet1");
		int noofrows=sheet.getPhysicalNumberOfRows();
		System.out.println(noofrows);
		for(int i=0;i<noofrows;i++)
		{
			String action=getcellvalue(i,2);
			System.out.println(action);
			switch(action)
				{
					case "open":
						driver=new ChromeDriver();
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						break;
					case "navigate":
						driver.get(getcellvalue(i,4));
						break;
					case "click":
						driver.findElement(By.xpath(getcellvalue(i,3))).click();
						break;
					case "type":
						driver.findElement(By.xpath(getcellvalue(i,3))).sendKeys(getcellvalue(i,4));
						break;
						
				}
		}
	}
}	
