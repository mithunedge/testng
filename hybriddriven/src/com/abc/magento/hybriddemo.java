package com.abc.magento;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hybriddemo 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\mithu\\eclipse-workspace\\hybriddriven\\src\\com\\abc\\utiliries\\hybrid.properties");
		Properties p=new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		String myacclocator=p.getProperty("myacct");
		String emaillocator=p.getProperty("emailkeyword");
		String emaildata=p.getProperty("email");
		String passlocator=p.getProperty("passkeyword");
		String passdata=p.getProperty("password"); 
		String loginlocator=p.getProperty("login");
		String logoutlocator=p.getProperty("logout");
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath(myacclocator)).click();
		driver.findElement(By.xpath(emaillocator)).sendKeys(emaildata);
		driver.findElement(By.xpath(passlocator)).sendKeys(passdata);
		driver.findElement(By.xpath(loginlocator)).click();
		driver.findElement(By.xpath(logoutlocator)).click();
		
	}

}
