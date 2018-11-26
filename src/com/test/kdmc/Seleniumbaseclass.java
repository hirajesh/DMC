package com.test.kdmc;



import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;






public class Seleniumbaseclass {
/*
	String Classname;*/
	public Seleniumbaseclass(WebDriver driver) {
		super();
		this.driver = driver;
	}
	WebDriver driver;

	public void xpathclick(String element)
	{
		driver.findElement(By.xpath(element)).click();
	}

	public void xpathsend(String element,String sendkeys)
	{
		driver.findElement(By.xpath(element)).sendKeys(sendkeys);
	}

	public void IDclick(String element)
	{
		driver.findElement(By.id(element)).click();
	}

	public void IDsend(String element,String sendkeys)
	{
		driver.findElement(By.id(element)).sendKeys(sendkeys);
	}
	public void LinkText(String element)
	{
		driver.findElement(By.linkText(element)).click();
	}
	public void Scroll()
	{
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,300)","");
	}
	
	public void Screenschot() throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyDirectory(source, new File("E:\\baseclassoutput\\screen" +System.currentTimeMillis() +".png"));
	}
	public void clickaction(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	
	@AfterTest
	public void FailureScreenschot(ITestResult Classname) throws IOException
	{
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyDirectory(source, new File("E:\baseclassoutput" +Classname.getName()+Arrays.toString(Classname.getParameters())+".png"));
		
	}
	
}
	
	

