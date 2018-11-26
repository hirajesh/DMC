package com.test.kdmc;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Prescriptionentry {

	WebDriver driver;
	String PATIENT_NAME="";
	
	public void pentry() throws InterruptedException
	{
		
		
		System.out.println("TEST CASE : Verify Prescription Entry Are Working Suceccessfully Or Not");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Pharmacy")).click();
		driver.findElement(By.id("txtusername")).sendKeys("fwmano");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		driver.findElement(By.id("btnSubmit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	 driver.findElement(By.id("today")).click();
	//driver.findElement(By.id("prev")).click();
	 
		driver.findElement(By.xpath("//*[@id='example1_filter']/label/input")).sendKeys(PATIENT_NAME);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='example1']/tbody/tr[1]/td[6]/a")).click();//*[@id="example1"]/tbody/tr/td[6]/a
		Thread.sleep(2000);
		Select Doc=new Select(driver.findElement(By.id("doctor")));
		Doc.selectByIndex(1);
		Thread.sleep(2000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("chk")).isDisplayed())
		{
	    driver.findElement(By.xpath("chk")).click();
		}
		else
		{
			System.out.println("Tihs is Second Visite For Patient");
		}
	Thread.sleep(3000);
	driver.findElement(By.id("btnSubmit")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
	driver.navigate().refresh();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='connector']/div[3]/a")).click();
	}
}

