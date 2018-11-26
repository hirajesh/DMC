package com.test.kdmc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class PrescriptionEntryExcel
{

	WebDriver driver;
	String NAME;

	@Test
	public void Hospital_Admin() throws InterruptedException, IOException 
	{
		
		System.out.println("TEST CASE : Verify Lab Test Entry Are Working Suceccessfully Or Not Using Excel");
		
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
	int oo=driver.findElements(By.xpath("//*[@id='example1']/tbody/tr/td[2]")).size();
	
	
	File src=new File("C:\\Users\\Document\\Desktop\\pat.xlsx");
	FileInputStream xl=new FileInputStream(src); 
	XSSFWorkbook wb1=new XSSFWorkbook(xl);
    XSSFSheet sheet=wb1.getSheetAt(0);
	int rowcount;
	rowcount=sheet.getLastRowNum();
	System.out.println("The Count is "  +rowcount);
    
	mm:
	for(int k=57;k<=rowcount;k++)
	{
		NAME=sheet.getRow(k).getCell(1).getStringCellValue();

		System.out.println(NAME);
		
	driver.findElement(By.xpath("//*[@id='example1_filter']/label/input")).sendKeys(NAME);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='example1']/tbody/tr[1]/td[6]/a")).click();//*[@id="example1"]/tbody/tr/td[6]/a
	Thread.sleep(3000);
	Select Doc=new Select(driver.findElement(By.id("doctor")));
	//int doctor=Doc.getOptions().size();
	Thread.sleep(2000);
	/*for(int i=1;i<=doctor;i++)
	{*/
		Doc.selectByIndex(1);
	
		Thread.sleep(2000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,800)", "");
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
	driver.navigate().refresh();
	Thread.sleep(3000);
//	}
	driver.findElement(By.xpath("//*[@id='connector']/div[3]/a")).click();


		
	}
	
	driver.close();
	}
}
