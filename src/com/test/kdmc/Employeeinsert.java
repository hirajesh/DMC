package com.test.kdmc;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Employeeinsert {

	WebDriver driver;
	String Hospitalname="TIMM HOSPITAL"; 
	String Employeename,Gender,Role,Address,data9;
	long EmployeeId,Mobile;
	int Department,pw=123;
	String EmailID,Eid,Username,Email,Hname,Password,CPassword;
	public static String Ename=null;
	
	
@Test
	public void OPEN() throws IOException, InterruptedException 
	{

	
	System.out.println("TEST CASE : Verify Employee Details Are Inserted Suceccessfully Or Not Using Excel File");

	
	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("http:\\192.168.137.1/Multihospital_new");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Admin Master")).click();
		driver.findElement(By.id("txtusername")).sendKeys("mukil");
		driver.findElement(By.id("txtpassword")).sendKeys("123");
        Thread.sleep(4000);
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
	
		Thread.sleep(5000);
		driver.findElement(By.linkText("Employee")).click();
		Thread.sleep(3000);
		
		try {
			employeeinsert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
driver.close();
	}

	public void employeeinsert() throws InterruptedException, IOException 
	{
	
		File source=new File("C:\\Users\\Quality Analyst\\Desktop\\Staff1.xlsx");
		FileInputStream EmployeeExcel=new FileInputStream(source);
		XSSFWorkbook Employeebook=new XSSFWorkbook(EmployeeExcel);
		XSSFSheet sheet=Employeebook.getSheetAt(0);
		int Rowcount=sheet.getLastRowNum();
		
		for(int o=1;o<=Rowcount;o++)
		{

		 EmployeeId=(long) sheet.getRow(o).getCell(0).getNumericCellValue();
		 Employeename=sheet.getRow(o).getCell(1).getStringCellValue();
		 Gender=sheet.getRow(o).getCell(2).getStringCellValue();
		 Department=(int) sheet.getRow(o).getCell(3).getNumericCellValue();
		 Role=sheet.getRow(o).getCell(4).getStringCellValue();
		 Address=sheet.getRow(o).getCell(5).getStringCellValue().trim();
		 Mobile = (long) sheet.getRow(o).getCell(6).getNumericCellValue();
		
		Thread.sleep(3000);
		
	/*	if((Role.toString().equals("Receptionist"))||(Role.toString().equals("Billing"))||(Role.toString().equals("Transactions"))||(Role.toString().equals("Laboratorist"))||(Role.toString().equals("Pharmacy In Charge"))||(Role.toString().equals("Pharmacist"))||(Role.toString().equals("Inpatient In Charge"))||(Role.toString().equals("CMO"))||(Role.toString().equals("Emergency")))
		{
			 data8 = sheet.getRow(o).getCell(8).getStringCellValue();
			 data9 = sheet.getRow(o).getCell(9).getStringCellValue();
	    	 Password = (long) sheet.getRow(o).getCell(10).getNumericCellValue();
			 CPassword = (long) sheet.getRow(o).getCell(11).getNumericCellValue(); 
		}
		else 
		{
			Mobile=sheet.getRow(o).getCell(6).getStringCellValue();
			data7=(long) sheet.getRow(o).getCell(7).getNumericCellValue();
			data8=sheet.getRow(o).getCell(8).getStringCellValue();
			
		}
		*/
		
		System.out.println(EmployeeId);
		System.out.println(Employeename);
		System.out.println(Gender);
		System.out.println(Department);
		System.out.println(Role);
		System.out.println(Address);
		System.out.println(Mobile);
		
		
		
		
		Hname=Hospitalname.substring(0,3).trim();
		Eid=Hname.concat(String.valueOf(EmployeeId));
		System.out.println("EMPLOYEE ID " +Eid);
		
		Email="@gmail.com";
		EmailID=Employeename.concat(Email).trim();
		System.out.println("EMPLOYEE EMAIL "+EmailID);
		
		Username=Hname.concat(Employeename).toLowerCase();
		Thread.sleep(2000);
		Ename=Username.trim();
		
		Password=Employeename.concat(String.valueOf(pw)).toLowerCase().trim();
		CPassword=Password;
		
		System.out.println(Password);
		System.out.println(CPassword);
		
		try 
		{
			WebElement element=driver.findElement(By.id("btnadd"));
			clickactions(element);
			Thread.sleep(3000);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			WebElement element=driver.findElement(By.id("btnadd"));
			clickactions(element);
			Thread.sleep(3000);
			
		}
		
		try 
		{
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("txtempid")));
			driver.findElement(By.id("txtempid")).sendKeys(Eid);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Thread.sleep(2000);
			while(true)
			{
			try {
				driver.findElement(By.xpath("//*[@id='txtempid']")).sendKeys(Eid);
				break;
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
				continue;
			}
			}
		}
		driver.findElement(By.id("txtfirstname")).sendKeys(Employeename);
		Select gen = new Select(driver.findElement(By.id("gen")));
		gen.selectByVisibleText(Gender);

		/*Select hospital = new Select(driver.findElement(By.id("opthos")));
		hospital.selectByVisibleText(Department);*/

		Select department = new Select(driver.findElement(By.id("optdepat")));
		department.selectByIndex(Department);

		Select role = new Select(driver.findElement(By.id("optrole")));
		role.selectByVisibleText(Role);

		
		
		driver.findElement(By.id("txtdoj")).click();
		Thread.sleep(2000);
		
		Select Year=new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")));
		Year.selectByIndex(10);
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-prev.ui-corner-all")).click();
		driver.findElement(By.linkText("27")).click();
		// driver.findElement(By.id("imgphoto")).sendKeys("image path");

		driver.findElement(By.id("txtadd1")).sendKeys(Address);
		driver.findElement(By.id("txtphone1")).sendKeys(String.valueOf(Mobile));
		driver.findElement(By.id("txtemail")).sendKeys(EmailID);
		
		
		if((Role.toString().equals("Receptionist"))||(Role.toString().equals("Billing"))||(Role.toString().equals("Transactions"))||(Role.toString().equals("Laboratorist"))||(Role.toString().equals("Pharmacy In Charge"))||(Role.toString().equals("Pharmacist"))||(Role.toString().equals("Inpatient In Charge"))||(Role.toString().equals("CMO"))||(Role.toString().equals("Emergency")))			 
		 {
			    driver.findElement(By.id("txtuser")).sendKeys(Username);
				driver.findElement(By.id("txtpwd")).sendKeys(String.valueOf(Password));
				driver.findElement(By.id("txtconfirmpwd")).sendKeys(String.valueOf(CPassword));
				Thread.sleep(2000);
				WebElement save=driver.findElement(By.id("btnsave"));
				
				clickactions(save);
				Thread.sleep(4000);
				try 
				{
					
					driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				}
				catch (Exception e)
				{
					Thread.sleep(500);
					e.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);	
	
		}
		 else
		 {
				Thread.sleep(2000);
				
				WebElement save=driver.findElement(By.id("btnsave"));
				
				clickactions(save);
				Thread.sleep(4000);
				try
				{
					
					driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				}
				catch (Exception e)
				{
					Thread.sleep(500);
					e.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);
		 }
		 
		 
	}	
}
	public void clickactions(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}	
	
public void screen(ITestResult result) throws IOException
{
if(result.getStatus()==ITestResult.FAILURE)
{
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("E:\\KDMC\\Employee Insert\\" +System.currentTimeMillis()+ ".png"));

}
	
}
}
