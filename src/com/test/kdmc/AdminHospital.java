package com.test.kdmc;

import java.io.File;
import java.util.Arrays;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;




public class AdminHospital 
{

	WebDriver driver;
	String date1,dat;
	String Hospitalname = "BMRHOSPITAL"; // Giva a name without space because
											// empty space not allowed
	String Healthpostname = "BMRHEALTHPOST";
	String Dispensaryname = "BMRDISPENSARY";
	String ademail;
	

	String Hospital_adminname = "BINNUKUMAR", HOS_ADMIN_MNUMBER = "7781277774";
	String Healthpost_adminname = "VICKY", HEL_ADMIN_MNUMBER = "7787777789";
	String Dispensary_adminname = "BHUVANESH", DIS_ADMIN_MNUMBER = "7787777770";
	
     // ALERT MSG
	//=============
	String Hospital_Alert_msg,Hospital_Admin_Alert_msg,Healthpost_Reg_Alert_msg,Dispensary_Reg_Alert_msg;
	String block,ward,ward_category,floor,bed,room,icu,room_list,dat1;
	

	// DELETE FUNCTION
	Statement St;
	String Hospital = "delete from Mstr_MultipleHospital where Hospital_Name='BMRHOSPITAL'";
	String Healthpost = "delete from Mstr_MultipleHospital where Hospital_Name='BMRHEALTHPOST'";
	String Dispensary = "delete from Mstr_MultipleHospital where Hospital_Name='BMRDISPENSARY'";
	String Hospitaladmin = "delete from mstr_Employee where Name='BINNUKUMAR'";
	String Healthpostadmin = "delete from mstr_Employee where Name='VICKY'";
	String Dispensaryadmin = "delete from mstr_Employee where Name='BHUVANESH'";
	String Delhealthpostname = "delete from Mstr_HealthpostReg where HealthpostName='BMRHEALTHPOST'";
	String Deldispensaryname = "delete from Mstr_DispensaryReg where Dispensaryname='BMRDISPENSARY'";
	

	@Test
	public void HOSHELDIS_REG() throws InterruptedException, IOException, SQLException {
		
		//driver = new FirefoxDriver();     //chrome is not run this script because of selenium 3.7.1 jar use 2.48

		System.out.println("Verify Hospital/Healthpost/Dispensary Are Inserted Suceccessfully Or Not");
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\add jar files\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Admin Master")).click();
		driver.findElement(By.id("txtusername")).sendKeys("admin");
		driver.findElement(By.id("txtpassword")).sendKeys("admin123");
		Thread.sleep(4000);
		
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
        
	    scrollthewindow();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		Date date = new Date();
		 date1 = dateFormat.format(date);
		 dat = date1.substring(0, 2);
		 
		 if(dat.startsWith(String.valueOf(0)))
		 {
			 dat1=dat.substring(1).trim();
			 System.out.println(dat1);
		 }
		 else
		 {
			 dat1 = date1.substring(0, 2).trim();
			 System.out.println(dat1);
		 }
	
		try {

			Hospital();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			driver.navigate().refresh();
			Hospital();
		}
		try {

			Healthpost();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			driver.navigate().refresh();
			Healthpost();
		}

		try {
			Dispensary();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Dispensary();
		}

		try {
			Hospital_Admin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Hospital_Admin();
		}
		try {
			Healthpost_Admin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Healthpost_Admin();
		}
		try {
			Dispensary_Admin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Dispensary_Admin();
		}

		Thread.sleep(3000);
		try {
			Healthpost_Reg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Healthpost_Reg();
		}
		
		Thread.sleep(3000);
		try {
			Dispensary_Reg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Dispensary_Reg();
			Thread.sleep(5000);
		}
		
		try {
			Hospital_Block_Room_Ward_Bed();
		} catch (Exception e) {
			e.printStackTrace();
		}

	/*	// DELETE METHODS
		// =======================
		try {
			deletehospital();
			deletehealthpost();
			deletedispensary();
			deletehospitaladmin();
			deletehealthpostadmin();
			deletedispensaryadmin();
			deletedispensaryreg();
			deletehealthpostreg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			deletehospital();
			deletehealthpost();
			deletedispensary();
			deletehospitaladmin();
			deletehealthpostadmin();
			deletedispensaryadmin();
			deletedispensaryreg();
			deletehealthpostreg();}*/
		

		driver.close();

		System.out.println("* Hospital,Healthpost,Dispensary,And All Admin are inserted sucessfully");
		System.out.println("* Hospital_Block_Room_Ward_Bed are inserted sucessfully");
	}

	public void Hospital() throws InterruptedException, IOException {

		try {
			System.out.println("HOSPITAL REGISTRATION");
			System.out.println("=====================");

			try 
			{
				driver.findElement(By.xpath("//*[text()='Hospital Registration']")).click();
				Thread.sleep(2000);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				WebElement hreg=driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[7]/a"));
				Actions action = new Actions(driver);
				action.moveToElement(hreg).click().perform();
				Thread.sleep(2000);
			}
			

			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("opttype")));
			select.selectByIndex(1);

			driver.findElement(By.id("txthname")).sendKeys(Hospitalname);
			Thread.sleep(1000);
			System.out.println(Hospitalname);

			Thread.sleep(3000);
			driver.findElement(By.id("txtphn")).sendKeys("04322220444");
			driver.findElement(By.id("txtmbl")).sendKeys("9898588787");
			driver.findElement(By.id("cname")).sendKeys("ROHIT");
			driver.findElement(By.id("fax")).sendKeys("4568796");
			driver.findElement(By.id("sno")).sendKeys("789878");
			driver.findElement(By.id("txtctry")).clear();
			driver.findElement(By.id("txtctry")).sendKeys("INDIA");
			driver.findElement(By.id("txtstate")).clear();
			driver.findElement(By.id("txtstate")).sendKeys("TAMILNADU");
			driver.findElement(By.id("txtcity")).clear();
			driver.findElement(By.id("txtcity")).sendKeys("TRICHY");
			driver.findElement(By.id("txtpin")).sendKeys("6565555");
			// driver.findElement(By.id("filUpload")).sendKeys(data0);
			driver.findElement(By.id("add")).sendKeys("KMS STREET,TRICHY");

			String Hname = Hospitalname.substring(0, 3).toLowerCase();
			String mail = "@gmail.com";
			String HOS = Hname.concat(mail);
			driver.findElement(By.id("txtemail")).sendKeys(HOS);

			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(3000);
			   
			Hospital_Alert_msg=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
			System.out.println("* Hospital Alert Msg :" +Hospital_Alert_msg+ " *");
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			Thread.sleep(3000);
			System.out.println("* HOSPITAL WAS GENERATES SUCCESSFULLY");
			
		
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			Hospital_Alert_msg=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
			System.out.println("* Hospital Alert Msg :" +Hospital_Alert_msg+ " *");
		}

	}

	public void Healthpost() throws InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			System.out.println(" HEALTHPOST");
			System.out.println("==============");
			Thread.sleep(3000);
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[text()='Hospital Registration']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("opttype")));
			select.selectByIndex(2);
			Thread.sleep(1000);
			driver.findElement(By.id("txthname")).sendKeys(Healthpostname);
			Thread.sleep(1000);

			String Hpostname = Healthpostname.substring(0, 4).toLowerCase();
			String mail = "@gmail.com";
			String HP = Hpostname.concat(mail);

			driver.findElement(By.id("txtemail")).sendKeys(HP);
			driver.findElement(By.id("txtphn")).sendKeys("043222204012");
			driver.findElement(By.id("txtmbl")).sendKeys("9898588755");
			driver.findElement(By.id("cname")).sendKeys("BALA");
			driver.findElement(By.id("fax")).sendKeys("8568696");
			driver.findElement(By.id("sno")).sendKeys("6523000");
			driver.findElement(By.id("txtctry")).clear();
			driver.findElement(By.id("txtctry")).sendKeys("INDIA");
			driver.findElement(By.id("txtstate")).clear();
			driver.findElement(By.id("txtstate")).sendKeys("TAMILNADU");
			driver.findElement(By.id("txtcity")).clear();
			driver.findElement(By.id("txtcity")).sendKeys("TRICHY");
			driver.findElement(By.id("txtpin")).sendKeys("6562545");
			// driver.findElement(By.id("filUpload")).sendKeys(data0);
			driver.findElement(By.id("add")).sendKeys("SS STREET,TRICHY");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(3000);
			Hospital_Alert_msg=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
			System.out.println("* Healthpost Alert Msg :" +Hospital_Alert_msg+ " *");
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			Thread.sleep(3000);
			   
			System.out.println("* HEALTHPOST WAS GENERATED SUCCESSFULLY");
			Thread.sleep(3000);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Hospital_Alert_msg=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
			System.out.println("* Healthpost Alert Msg :" +Hospital_Alert_msg+ " *");
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			
		
		}

	}

	public void Dispensary() throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			System.out.println("DISPENSARY REGISTRATION");
			System.out.println("========================");
			driver.findElement(By.xpath("//*[text()='Hospital Registration']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("opttype")));
			select.selectByIndex(3);
			Thread.sleep(1000);
			driver.findElement(By.id("txthname")).sendKeys(Dispensaryname);
			Thread.sleep(1000);

			String Disname = Dispensaryname.substring(0, 4).toLowerCase();
			String mail = "@gmail.com";
			String DM = Disname.concat(mail);

			driver.findElement(By.id("txtemail")).sendKeys(DM);
			driver.findElement(By.id("txtphn")).sendKeys("04322220443");
			driver.findElement(By.id("txtmbl")).sendKeys("9898588784");
			driver.findElement(By.id("cname")).sendKeys("KUMAR");
			driver.findElement(By.id("fax")).sendKeys("6578712");
			driver.findElement(By.id("sno")).sendKeys("784512");
			driver.findElement(By.id("txtctry")).clear();
			driver.findElement(By.id("txtctry")).sendKeys("INDIA");
			driver.findElement(By.id("txtstate")).clear();
			driver.findElement(By.id("txtstate")).sendKeys("TAMILNADU");
			driver.findElement(By.id("txtcity")).clear();
			driver.findElement(By.id("txtcity")).sendKeys("TRICHY");
			driver.findElement(By.id("txtpin")).sendKeys("6562553");
			// driver.findElement(By.id("filUpload")).sendKeys(data0);
			driver.findElement(By.id("add")).sendKeys("KK STREET,TRICHY");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(3000);
			Hospital_Alert_msg=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
			System.out.println("* Dispensary Alert Msg :" +Hospital_Alert_msg+ " *");
			
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			Thread.sleep(3000);
			System.out.println("* DISPENSARY WAS GENERATED SUCCESSFULLY");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			Hospital_Alert_msg=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
			System.out.println("* Dispensary Alert Msg :" +Hospital_Alert_msg+ " *");
		}

	}

	public void Hospital_Admin() throws InterruptedException, IOException {
		
			
			try {
				Thread.sleep(2000);
				System.out.println("HOSPITAL ADMIN REGISTRATION");
				System.out.println("============================");
				driver.findElement(By.xpath("//*[text()='Admin Registration']")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				Thread.sleep(3000);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[text()='Admin Registration']")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				Thread.sleep(3000);
			}
			
			try {
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
			int k = 1;
			String A = "EMP";
			String E = Hospitalname.substring(0, 3);
			String Employeeid = E.concat(A + String.valueOf(k));

			driver.findElement(By.id("txtempid")).sendKeys(Employeeid);
			driver.findElement(By.id("txtfirstname")).sendKeys(Hospital_adminname);
			Select gen = new Select(driver.findElement(By.id("gen")));
			gen.selectByIndex(1);
			Select hospital = new Select(driver.findElement(By.id("opthos")));
			Thread.sleep(2000);
			hospital.selectByVisibleText(Hospitalname);

			Select department = new Select(driver.findElement(By.id("optdepat")));
			department.selectByIndex(12);

			Select role = new Select(driver.findElement(By.id("optrole")));
			role.selectByIndex(1);

			try {
				
				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y=new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
		//		driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-prev.ui-corner-all")).click();
				driver.findElement(By.linkText("15")).click();
				
			} catch (Exception e) {
	
				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y=new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				//	driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-prev.ui-corner-all")).click();
				driver.findElement(By.linkText("15")).click();
			}
			// driver.findElement(By.id("imgphoto")).sendKeys("image path");

			driver.findElement(By.id("txtadd1")).sendKeys("KK NAGR TRICHY");
			driver.findElement(By.id("txtphone1")).sendKeys(HOS_ADMIN_MNUMBER);

			ademail = Hospital_adminname.trim().toLowerCase();
			String str = "@gmail.com";
			String Adminemail = ademail.concat(str);
			driver.findElement(By.id("txtemail")).sendKeys(Adminemail);
			driver.findElement(By.id("txtuser")).sendKeys(ademail);

			driver.findElement(By.id("txtpwd")).sendKeys("123");
			driver.findElement(By.id("txtconfirmpwd")).sendKeys("123");
			Thread.sleep(2000);
			JavascriptExecutor jse2 = (JavascriptExecutor) driver;
			jse2.executeScript("window.scrollBy(0,800)", "");
			Thread.sleep(2000);
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(4000);
			   
			try {
				
				try {
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				} catch (Exception e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
					Thread.sleep(3000);
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				}
				System.out.println("* Hosptial Admin Alert Msg :" +Hospital_Admin_Alert_msg+ " *");
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				System.out.println("* HOSPITAL ADMIN ARE REGISTERED SUCCESSFULLY");
				
			} catch (Exception e) {
			
				e.printStackTrace();
				Thread.sleep(2000);
				try {
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				} catch (Exception e1) {
		
					Thread.sleep(3000);
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				}
				Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				System.out.println("* Hosptial Admin Alert Msg :" +Hospital_Admin_Alert_msg+ " *");
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				System.out.println("* HOSPITAL ADMIN ARE REGISTERED SUCCESSFULLY");
			
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Thread.sleep(3000);
			Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
			System.out.println("* Hosptial Admin Alert Msg :" +Hospital_Admin_Alert_msg+ " *");
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			Thread.sleep(3000);
			System.out.println("* HOSPITAL ADMIN ARE REGISTERED SUCCESSFULLY");
			
			
		//	driver.navigate().refresh();
			/*WebElement save=driver.findElement(By.id("btnsave"));
			Actions action=new Actions(driver);
			action.moveToElement(save).click().perform();*/
		}
	}

	public void Healthpost_Admin() throws InterruptedException, IOException {
		// driver.findElement(By.xpath("//*[text()='Admin
		// Registration']")).click();
		System.out.println("HEALTHPOST ADMIN REGISTRATION");
		System.out.println("==============================");
	
			try {
				Thread.sleep(3000);
				WebElement add=driver.findElement(By.id("btnadd"));
				Actions action=new Actions(driver);
				action.moveToElement(add).click().perform();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				Thread.sleep(3000);
				WebElement add=driver.findElement(By.id("btnadd"));
				Actions action=new Actions(driver);
				action.moveToElement(add).click().perform();
				
			}
			
			//driver.findElement(By.id("btnadd")).click();
			Thread.sleep(3000);
			try {
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			int k = 1;
			String HA = "H";
			String EHA = Hospitalname.substring(0, 3);
			String Employeeid = EHA.concat(HA + String.valueOf(k));

			driver.findElement(By.id("txtempid")).sendKeys(Employeeid);
			driver.findElement(By.id("txtfirstname")).sendKeys(Healthpost_adminname);

			Select gen = new Select(driver.findElement(By.id("gen")));
			gen.selectByIndex(1);

			Select hospital = new Select(driver.findElement(By.id("opthos")));
			Thread.sleep(2000);
			hospital.selectByVisibleText(Healthpostname);

			Select department = new Select(driver.findElement(By.id("optdepat")));
			department.selectByIndex(12);

			Select role = new Select(driver.findElement(By.id("optrole")));
			role.selectByIndex(1);

			try {
			
				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y=new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				driver.findElement(By.linkText("15")).click();
			} catch (Exception e) {
			
				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y=new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				driver.findElement(By.linkText("15")).click();
			}
			// driver.findElement(By.id("imgphoto")).sendKeys("image path");

			driver.findElement(By.id("txtadd1")).sendKeys("DMS 2ND STREET TRICHY");
			driver.findElement(By.id("txtphone1")).sendKeys(HEL_ADMIN_MNUMBER);
			String ademail = Healthpost_adminname.trim().toLowerCase();
			String str = "@gmail.com";
			String Adminemail = ademail.concat(str);

			driver.findElement(By.id("txtemail")).sendKeys(Adminemail);
			driver.findElement(By.id("txtuser")).sendKeys(ademail);

			driver.findElement(By.id("txtpwd")).sendKeys("123");
			driver.findElement(By.id("txtconfirmpwd")).sendKeys("123");
			Thread.sleep(2000);
			JavascriptExecutor jse3 = (JavascriptExecutor) driver;
			jse3.executeScript("window.scrollBy(0,800)", "");

			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(4000);
			   
			try {
				try {
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				} catch (Exception e) {
					Thread.sleep(2000);
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				}
				System.out.println("Healthpost Alert msg : * " +Hospital_Admin_Alert_msg+ " *");
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				System.out.println("* HEALTHPOST ADMIN ARE REGISTERED SUCCESSFULLY");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				try {
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				} catch (Exception e1) {
					Thread.sleep(2000);
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				}
				System.out.println("Healthpost Alert msg : * " +Hospital_Admin_Alert_msg+ " *");
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				System.out.println("* HEALTHPOST ADMIN ARE REGISTERED SUCCESSFULLY");
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//	driver.navigate().refresh();
			Thread.sleep(2000);
			/*WebElement save=driver.findElement(By.id("btnsave"));
			Actions action=new Actions(driver);
			action.moveToElement(save).click().perform();
			Thread.sleep(2000);*/
			Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
			System.out.println("Healthpost Alert msg : * " +Hospital_Admin_Alert_msg+ " *");
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
			System.out.println("* HEALTHPOST ADMIN ARE REGISTERED SUCCESSFULLY");
		}
	}

	public void Dispensary_Admin() throws InterruptedException, IOException {

		System.out.println("DISPENSARY  ADMIN REGISTRATION ");
		System.out.println("===============================");
			try {
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				Thread.sleep(3000);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				Thread.sleep(3000);
			}
			try 
			{
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			int k = 1;
			String HD = "D";
			String HDE = Hospitalname.substring(0, 3);
			String Employeeid = HDE.concat(HD + String.valueOf(k));

			driver.findElement(By.id("txtempid")).sendKeys(Employeeid);
			driver.findElement(By.id("txtfirstname")).sendKeys(Dispensary_adminname);
			Select gen = new Select(driver.findElement(By.id("gen")));
			gen.selectByIndex(1);// selectByVisibleText("Male");

			Select hospital = new Select(driver.findElement(By.id("opthos")));
			Thread.sleep(2000);
			hospital.selectByVisibleText(Dispensaryname);

			Select department = new Select(driver.findElement(By.id("optdepat")));
			department.selectByIndex(12);

			Select role = new Select(driver.findElement(By.id("optrole")));
			role.selectByIndex(1);
			Thread.sleep(2000);

			try
			{
				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y=new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				driver.findElement(By.linkText("15")).click();
			} catch (Exception e) {
				
				Thread.sleep(2000);
				driver.findElement(By.id("txtdoj")).click();
				Thread.sleep(2000);
				Select y=new Select(driver.findElement(By.className("ui-datepicker-year")));
				y.selectByIndex(9);
				driver.findElement(By.linkText("15")).click();
			}
			// driver.findElement(By.id("imgphoto")).sendKeys("image path");

			driver.findElement(By.id("txtadd1")).sendKeys("RAM STREET TRICHY");
			driver.findElement(By.id("txtphone1")).sendKeys(DIS_ADMIN_MNUMBER);

			String ademail = Dispensary_adminname.trim().toLowerCase();
			String str = "@gmail.com";
			String Adminemail = ademail.concat(str);
			driver.findElement(By.id("txtemail")).sendKeys(Adminemail);
			driver.findElement(By.id("txtuser")).sendKeys(ademail);

			driver.findElement(By.id("txtpwd")).sendKeys("123");
			driver.findElement(By.id("txtconfirmpwd")).sendKeys("123");
			Thread.sleep(2000);
			JavascriptExecutor jse4 = (JavascriptExecutor) driver;
			jse4.executeScript("window.scrollBy(0,500)", "");

			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(4000);
			   
			try {
				try {
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				} catch (Exception e) {
					Thread.sleep(2000);
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				}
				System.out.println("Dispensary Alert msg : * " +Hospital_Admin_Alert_msg+ " *");
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				System.out.println("* DISPENSARY ADMIN ARE REGISTERED SUCCESSFULLY");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				} catch (Exception e1) {
					Thread.sleep(2000);
					Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
				}
				System.out.println("Dispensary Alert msg : * " +Hospital_Admin_Alert_msg+ " *");
				driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
				System.out.println("* DISPENSARY ADMIN ARE REGISTERED SUCCESSFULLY");
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			/*Thread.sleep(2000);
			driver.navigate().refresh();
			WebElement save=driver.findElement(By.id("btnsave"));
			Actions action=new Actions(driver);
			action.moveToElement(save).click().perform();*/
			Thread.sleep(2000);
			Hospital_Admin_Alert_msg=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().toString();
			System.out.println("Dispensary Alert msg : * " +Hospital_Admin_Alert_msg+ " *");
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
		}
	}

	public void Healthpost_Reg() throws IOException, InterruptedException {
		try {
			System.out.println("HEALTHPOST  REGISTRATION UNDER "+Hospitalname+"");
			System.out.println("================================================");
			driver.findElement(By.linkText("Healthpost Registration")).click();
		
			Thread.sleep(3000);
			Select Hselect = new Select(driver.findElement(By.id("opthealth")));
			Hselect.selectByVisibleText(Healthpostname);
			
			Select Hosselect = new Select(driver.findElement(By.id("opthos")));
			Hosselect.selectByVisibleText(Hospitalname);
			
			scrollthewindow();
			ss();
			Thread.sleep(2000);
			WebElement submit=driver.findElement(By.id("btnsave"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			Thread.sleep(4000);
			try {
				Healthpost_Reg_Alert_msg=driver.findElement(By.xpath("/html/body/div[6]/div/div/div[1]/div")).getText().toString();
				System.out.println("Healthpost Registration under hospital Alert msg : * " +Healthpost_Reg_Alert_msg+ " *");
				driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).click();
				System.out.println("* HEALTHPOST ARE REGISTERED SUCCESSFULLY UNDER "+Hospitalname+"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				Healthpost_Reg_Alert_msg=driver.findElement(By.xpath("/html/body/div[6]/div/div/div[1]/div")).getText().toString();
				System.out.println("Healthpost Registration under hospital Alert msg : * " +Healthpost_Reg_Alert_msg+ " *");
				driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).click();
				System.out.println("* HEALTHPOST ARE REGISTERED SUCCESSFULLY UNDER "+Hospitalname+"");
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Dispensary_Reg() throws IOException, InterruptedException {

		try {
			System.out.println("DISPENSARY  REGISTRATION UNDER "+Hospitalname+"");
			System.out.println("================================================");
			driver.findElement(By.linkText("Dispensary Registration")).click();
			
			Thread.sleep(3000);
			Select Hselect = new Select(driver.findElement(By.id("opthealth")));
			Hselect.selectByVisibleText(Dispensaryname);
			
			Thread.sleep(3000);
			Select Hosselect = new Select(driver.findElement(By.id("opthos")));
			Hosselect.selectByVisibleText(Hospitalname);
			

			scrollthewindow();
			ss();
			Thread.sleep(2000);
			WebElement submit=driver.findElement(By.id("btnsave"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			Thread.sleep(4000);
			try {
				Dispensary_Reg_Alert_msg=driver.findElement(By.xpath("/html/body/div[6]/div/div/div[1]/div")).getText().toString();
				System.out.println("Dispensary Registration under hospital Alert msg : * " +Dispensary_Reg_Alert_msg+ " *");
				driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).click();
				System.out.println("* DISPENSARY ARE REGISTERED SUCCESSFULLY UNDER "+Hospitalname+"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				Dispensary_Reg_Alert_msg=driver.findElement(By.xpath("/html/body/div[6]/div/div/div[1]/div")).getText().toString();
				System.out.println("Dispensary Registration under hospital Alert msg : * " +Dispensary_Reg_Alert_msg+ " *");
				driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).click();
				System.out.println("* DISPENSARY ARE REGISTERED SUCCESSFULLY UNDER "+Hospitalname+"");
			}
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[text()='Sign out']")).click();
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                driver.navigate().refresh();
				driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[text()='Sign out']")).click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Hospital_Block_Room_Ward_Bed() throws InterruptedException, IOException 
	{
     
		
		try {
			Thread.sleep(3000);
			driver.findElement(By.linkText("Admin Master")).click();
			driver.findElement(By.id("txtusername")).sendKeys(ademail);
			driver.findElement(By.id("txtpassword")).sendKeys("123");
            Thread.sleep(3000);
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("\\*[text()='Employee']")).click();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
			Thread.sleep(2000);	
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		}

		// BLOCK
		// =============

			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Block")).click();
			Thread.sleep(2000);
			WebElement Blo = driver.findElement(By.id("txtblock"));
			Blo.sendKeys("BLOCK1");
			Blo.getText();
			driver.findElement(By.id("btnsave")).click();		
			Thread.sleep(3000);
			block=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
			System.out.println("Block Alert msg : * " +block+ " *");
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			
			driver.navigate().refresh();
			Thread.sleep(2000);
			WebElement Blo1 = driver.findElement(By.id("txtblock"));
			Blo1.sendKeys("BLOCK2");
			Thread.sleep(2000);
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(3000);
			block=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
			System.out.println("Block Alert msg : * " +block+ " *");
			driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
		

		// FLOOR
		// =============

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospital']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Floor")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("optblock")));
			select.selectByVisibleText("BLOCK1");
			driver.findElement(By.id("txtfloor")).sendKeys("FIRSTFLOOR");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);
			   
			try {
				floor=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Floor Alert msg : * " +floor+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				floor=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Floor Alert msg : * " +floor+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospital']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Floor")).click();
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("optblock")));
			select.selectByVisibleText("BLOCK1");
			driver.findElement(By.id("txtfloor")).sendKeys("FIRSTFLOOR");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);
			   
			try {
				floor=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Floor Alert msg : * " +floor+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				floor=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Floor Alert msg : * " +floor+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		}

		// WARD CATEGORY
		// ====================
		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Ward Category")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtwardcat")).sendKeys("GENERAL");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);
			   
			try {
				ward_category=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward category Alert msg : * " +ward_category+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				ward_category=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward category Alert msg : * " +ward_category+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Ward Category")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtwardcat")).sendKeys("GENERAL");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);
			   
			try {
				ward_category=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward category Alert msg : * " +ward_category+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				ward_category=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward category Alert msg : * " +ward_category+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		}

		// WARD LIST
		// =================

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Ward List")).click();
			Thread.sleep(2000);
			Select wardlist = new Select(driver.findElement(By.id("optwardcate")));
			wardlist.selectByVisibleText("GENERAL");
			driver.findElement(By.id("txtwardname")).sendKeys("GEN1");
			driver.findElement(By.id("txtbed")).sendKeys("10");
			Select Department = new Select(driver.findElement(By.id("optdept")));
			Department.selectByVisibleText("GENERAL MEDICINE");
			Select Block = new Select(driver.findElement(By.id("optblock")));
			Block.selectByVisibleText("BLOCK1");
			Select Floor = new Select(driver.findElement(By.id("optFloor")));
			Floor.selectByVisibleText("FIRSTFLOOR");

			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);
			   
			try {
				ward=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward list Alert msg : * " +ward+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				ward=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward list Alert msg : * " +ward+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Ward List")).click();
			Thread.sleep(2000);
			Select wardlist = new Select(driver.findElement(By.id("optwardcate")));
			wardlist.selectByVisibleText("GENERAL");
			driver.findElement(By.id("txtwardname")).sendKeys("GEN1");
			driver.findElement(By.id("txtbed")).sendKeys("10");
			Select Department = new Select(driver.findElement(By.id("optdept")));
			Department.selectByVisibleText("GENERAL MEDICINE");
			Select Block = new Select(driver.findElement(By.id("optblock")));
			Block.selectByVisibleText("BLOCK1");
			Select Floor = new Select(driver.findElement(By.id("optFloor")));
			Floor.selectByVisibleText("FIRSTFLOOR");

			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);
			   
			try {
				ward=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward list Alert msg : * " +ward+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				ward=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Ward list Alert msg : * " +ward+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		}

		// ROOM TYPE
		// =============

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Room Type")).click();
			Thread.sleep(2000);
			WebElement ROOM = driver.findElement(By.id("txtroomtype"));
			ROOM.sendKeys("SINGLE");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);
			   
			try {
				room=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room Type Alert msg : * " +room+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				room=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room Type Alert msg : * " +room+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Room Type")).click();
			Thread.sleep(2000);
			WebElement ROOM = driver.findElement(By.id("txtroomtype"));
			ROOM.sendKeys("SINGLE");
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);
			   
			try {
				room=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room Type Alert msg : * " +room+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				room=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room Type Alert msg : * " +room+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		}

		// ROOM LIST
		// =================

		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Room List")).click();
			Thread.sleep(2000);
			Select wardcat = new Select(driver.findElement(By.id("optcat")));
			wardcat.selectByVisibleText("GENERAL");
			Thread.sleep(2000);
			Select wardcatnum = new Select(driver.findElement(By.id("optwardcate")));
			wardcatnum.selectByVisibleText("GEN1");
			Thread.sleep(2000);
			Select Rtype = new Select(driver.findElement(By.id("optroomtype")));
			Rtype.selectByVisibleText("SINGLE");
			Thread.sleep(2000);
			driver.findElement(By.id("txtroom")).sendKeys("1");
			driver.findElement(By.id("txtactrate")).sendKeys("150");
			Thread.sleep(2000);
			Select TAX = new Select(driver.findElement(By.id("tx")));
			TAX.selectByVisibleText("No Tax 0%");
			Thread.sleep(2000);
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);
			   
			try {
				room_list=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room List Alert msg : * " +room_list+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(2000);
				room_list=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room List Alert msg : * " +room_list+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Room List")).click();
			Thread.sleep(2000);
			Select wardcat = new Select(driver.findElement(By.id("optcat")));
			wardcat.selectByVisibleText("GENERAL");
			Thread.sleep(2000);
			Select wardcatnum = new Select(driver.findElement(By.id("optwardcate")));
			wardcatnum.selectByVisibleText("GEN1");
			Thread.sleep(2000);
			Select Rtype = new Select(driver.findElement(By.id("optroomtype")));
			Rtype.selectByVisibleText("SINGLE");
			Thread.sleep(2000);
			driver.findElement(By.id("txtroom")).sendKeys("1");
			driver.findElement(By.id("txtactrate")).sendKeys("150");
			Thread.sleep(2000);
			Select TAX = new Select(driver.findElement(By.id("tx")));
			TAX.selectByVisibleText("No Tax 0%");
			Thread.sleep(2000);
			driver.findElement(By.id("btnsave")).click();
			Thread.sleep(2000);
			   
			try {
				room_list=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room List Alert msg : * " +room_list+ " *");
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			} catch (Exception e1) {
				room_list=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
				System.out.println("Room List Alert msg : * " +room_list+ " *");
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			}
			Thread.sleep(2000);
		}

		// BED LIST
		// =================

		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Bed List")).click();
		Thread.sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				Select Bedwc = new Select(driver.findElement(By.id("optcat")));
				Bedwc.selectByVisibleText("GENERAL");
				Thread.sleep(2000);
				Select wardnum = new Select(driver.findElement(By.id("optwardcate")));
				wardnum.selectByVisibleText("GEN1");
				Thread.sleep(2000);
				Select Bedrtype = new Select(driver.findElement(By.id("optrtype")));
				Bedrtype.selectByVisibleText("SINGLE");
				Select Bedrnum = new Select(driver.findElement(By.id("optroomno")));
				Bedrnum.selectByVisibleText("1");
				Thread.sleep(2000);
				driver.findElement(By.id("txtbed")).sendKeys(String.valueOf(i));
				Thread.sleep(2000);
				driver.findElement(By.id("btnsave")).click();
				Thread.sleep(2000);
				   
				try {
					bed=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println(+i + " Bed Alert msg : * " +bed+ " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Thread.sleep(2000);
					bed=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println(+i + " Bed Alert msg : * " +bed+ " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
							
						Select Bedwc = new Select(driver.findElement(By.id("optcat")));
						Bedwc.selectByVisibleText("GENERAL");
						Thread.sleep(2000);
						Select wardnum = new Select(driver.findElement(By.id("optwardcate")));
						wardnum.selectByVisibleText("GEN1");
						Thread.sleep(2000);
						Select Bedrtype = new Select(driver.findElement(By.id("optrtype")));
						Bedrtype.selectByVisibleText("SINGLE");
						Select Bedrnum = new Select(driver.findElement(By.id("optroomno")));
						Bedrnum.selectByVisibleText("1");
						Thread.sleep(2000);
						driver.findElement(By.id("txtbed")).sendKeys(String.valueOf(i));
						Thread.sleep(2000);
						driver.findElement(By.id("btnsave")).click();
						Thread.sleep(2000);
						   
						try {
							bed=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
							System.out.println(" Bed Alert msg : * " +bed+ " *");
							driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							Thread.sleep(2000);
							bed=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
							System.out.println(" Bed Alert msg : * " +bed+ " *");
							driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
						}
						Thread.sleep(2000);
			}
		}
		
		// ICU
		//=======
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		// driver.findElement(By.xpath("//*[@id='hospitals']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("ICU")).click();
		Thread.sleep(2000);
		
		for (int j = 1; j <= 5; j++) {
			try {
				Select selblock = new Select(driver.findElement(By.id("optblock")));
				selblock.selectByIndex(2);
				Thread.sleep(2000);
				driver.findElement(By.id("txtroom")).sendKeys(String.valueOf(j));
				Thread.sleep(2000);
				driver.findElement(By.id("txtbed")).sendKeys(String.valueOf(j));
				Thread.sleep(2000);
				Thread.sleep(2000);
				driver.findElement(By.id("txtactrate")).sendKeys("250");
				Thread.sleep(2000);
				Select tax = new Select(driver.findElement(By.id("tx")));
				tax.selectByIndex(1);
				driver.findElement(By.id("btnsave")).click();
				Thread.sleep(2000);
				   
				try {
					icu=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println(+j + " ICU Alert msg : * " +icu+ " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
			     	} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					Thread.sleep(2000);
					icu=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
					System.out.println(+j + " ICU Alert msg : * " +icu+ " *");
					driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
				}
				Thread.sleep(2000);
			    } 
		    	catch (Exception e)
			     
			    {
				// TODO Auto-generated catch block
				e.printStackTrace();
							
				Select selblock = new Select(driver.findElement(By.id("optblock")));
				selblock.selectByIndex(2);
				Thread.sleep(2000);
				driver.findElement(By.id("txtroom")).sendKeys(String.valueOf(j));
				Thread.sleep(2000);
				driver.findElement(By.id("txtbed")).sendKeys(String.valueOf(j));
				Thread.sleep(2000);
				Thread.sleep(2000);
				driver.findElement(By.id("txtactrate")).sendKeys("250");
				Thread.sleep(2000);
				Select tax = new Select(driver.findElement(By.id("tx")));
				tax.selectByIndex(1);
				driver.findElement(By.id("btnsave")).click();
				Thread.sleep(2000);
						   
						try {
							icu=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
							System.out.println("+j+" +" ICU Alert msg : * " +icu+ " *");
							driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							Thread.sleep(2000);
							icu=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div")).getText().toString();
							System.out.println("+j+" +" ICU Alert msg : * " +icu+ " *");
							driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
						}
						Thread.sleep(2000);
			}
		}
			
	}
	
	public void scrollthewindow() {

		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,200)", "");

	}
	
	
@AfterMethod
	public void screen(ITestResult testresult1) throws IOException 
	{
if(testresult1.getStatus()==ITestResult.FAILURE)
{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Jenkins output\\KDMC\\"+date1+"" + testresult1.getName()+ "-" + Arrays.toString(testresult1.getParameters())+ ".png"));
		
	}}

	/*public void deletehospital() throws SQLException

	{
		SQLServerDataSource del = new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		St = del.getConnection().createStatement();
		St.executeQuery(Hospital);

	}

	
	public void deletehealthpost() throws SQLException

	{
		SQLServerDataSource del = new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		St = del.getConnection().createStatement();
		St.executeQuery(Healthpost);

	}

	
	public void deletedispensary() throws SQLException

	{
		SQLServerDataSource del = new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		St = del.getConnection().createStatement();
		St.executeQuery(Dispensary);

	}


	public void deletehospitaladmin() throws SQLException

	{
		SQLServerDataSource del = new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		St = del.getConnection().createStatement();
		St.executeQuery(Hospitaladmin);

	}

	
	public void deletehealthpostadmin() throws SQLException

	{
		SQLServerDataSource del = new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		St = del.getConnection().createStatement();
		St.executeQuery(Healthpostadmin);

	}

	
	public void deletedispensaryadmin() throws SQLException

	{
		SQLServerDataSource del = new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		St = del.getConnection().createStatement();
		St.executeQuery(Dispensaryadmin);

	}
	
	public void deletedispensaryreg() throws SQLException

	{
		SQLServerDataSource del = new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		St = del.getConnection().createStatement();
		St.executeQuery(Deldispensaryname);

	}
	
	public void deletehealthpostreg() throws SQLException

	{
		SQLServerDataSource del = new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		St = del.getConnection().createStatement();
		St.executeQuery(Delhealthpostname);

	}
*/

public void ss() throws IOException
{
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("E:\\Jenkins output\\Admin\\"+date1+"" +System.currentTimeMillis()  +".png"));
	
}


}
