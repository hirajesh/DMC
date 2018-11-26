package com.test.kdmc;



	import org.testng.annotations.Test;
	import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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


	public class Labrequest {

		WebDriver driver;
		int i, j, k, p, q, receveditem, a,g,h,column,row;
		String Lab_Rno, Ritem, xp, CMORNO, Stock_qty, Required_qty,PRNO,date1,Product_name,stock_list;
		public static List<StockData> stockDatas=new ArrayList<>();
		int Seconds=0;
		
		@Test
		public void nn() throws InterruptedException, IOException {
			
		DateFormat format=new SimpleDateFormat("dd/mm//yy");
		Date d=new Date();
		date1=format.format(d);
		
		System.out.println("TEST CASE : Verify Lab Request Are Working Suceccessfully Or Not");
		   
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		   driver = new ChromeDriver();
		
//		System.setProperty("webdriver.ie.driver","E:\\Others\\IEXPLORER\\IEDriverServer_x64_3.8.0 (1)\\IEDriverServer.exe");
		
			 
	  	//    driver = new InternetExplorerDriver();
			//driver.get("http://182.18.161.229/Multihospital_new");
			 driver.get("http://192.168.137.1/Multihospital_New/");
		
			 driver.manage().window().maximize();
			
			driver.findElement(By.linkText("Investigation")).click();
			driver.findElement(By.id("txtusername")).sendKeys("manu");
			driver.findElement(By.id("txtpassword")).sendKeys("manu123");
			Thread.sleep(4000);
			
			WebElement submit=driver.findElement(By.id("btnSubmit"));
			Actions action=new Actions(driver);
			action.moveToElement(submit).click().perform();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		

		

			System.out.println(" ");
			System.out.println("LAB REQUEST");
			System.out.println("================= ");
			System.out.println(" ");
			
			Lab_storerequest();
			Thread.sleep(2000);
			signout();
			Thread.sleep(2000);
			CMO();
			Thread.sleep(2000);
			signout();
			Thread.sleep(2000);
			DMS();
			Thread.sleep(2000);
			signout();
			Thread.sleep(2000);
			//ack_lab();
			Thread.sleep(2000);
			
			driver.close();
			

		}

		public void Lab_storerequest() throws InterruptedException, IOException {

			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/ul/li[1]/a")).click();
			Thread.sleep(3000);
			
			 column=driver.findElements(By.xpath("//*[@id='tblstockdetails']/thead/tr/th")).size();
			 row=driver.findElements(By.xpath("//*[@id='tblstockdetails']/tbody/tr/td[1]")).size();
			
			 System.out.println("* OLD STOCK LIST");
		
			 //
			 for( g=1;g<row;g++)
			{
				
				System.out.println("\n===================================================\n");
				for( h=1;h<column;h++)
					{
					 stock_list=driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr["+g+"]/td["+h+"]")).getText();
					 System.out.println(stock_list);
					}
			
				StockData sotockdata=new StockData();
				sotockdata.setProduct_Name(driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr["+g+"]/td[1]")).getText());
				sotockdata.setRece_qty(driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr["+g+"]/td[2]")).getText());
				sotockdata.setStock_qty(driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr["+g+"]/td[3]")).getText());
				
				stockDatas.add(sotockdata);
				
			}
		/*	for(int y=1;y<stockDatas.size();y++)
			{
			String gh=stockDatas.get(y).getProduct_Name();
			System.out.println("Product name :"+gh);
			}*/
			
				try {
					driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a/span")).click();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a/span")).click();
				}
				Thread.sleep(2000);
				driver.findElement(By.linkText("Medicine Request")).click();
				Thread.sleep(2000);
				
				Select category = new Select(driver.findElement(By.id("optcategory")));
				category.selectByIndex(1);
				Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
				choosemedicine.selectByIndex(5);
				driver.findElement(By.id("txttreat")).sendKeys("5");
				driver.findElement(By.id("btnadd")).click();

				Thread.sleep(5000);
				category.selectByIndex(2);
				Thread.sleep(2000);
				choosemedicine.selectByIndex(2);
				Thread.sleep(2000);
				driver.findElement(By.id("txttreat")).sendKeys("8");
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				
				Thread.sleep(5000);
				category.selectByIndex(2);
				Thread.sleep(2000);
				choosemedicine.selectByIndex(11);
				Thread.sleep(2000);
				driver.findElement(By.id("txttreat")).sendKeys("6");
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				
				Thread.sleep(5000);
				category.selectByIndex(6);
				Thread.sleep(2000);
				choosemedicine.selectByIndex(1);
				Thread.sleep(2000);
				driver.findElement(By.id("txttreat")).sendKeys("3");
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
			
				
				Thread.sleep(5000);
				category.selectByIndex(5);
				Thread.sleep(2000);
				choosemedicine.selectByIndex(6);
				Thread.sleep(2000);
				driver.findElement(By.id("txttreat")).sendKeys("5");
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				
				Thread.sleep(5000);
				category.selectByIndex(5);
				Thread.sleep(2000);
				choosemedicine.selectByIndex(7);
				Thread.sleep(2000);
				driver.findElement(By.id("txttreat")).sendKeys("8");
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				
				Thread.sleep(5000);
				category.selectByIndex(5);
				Thread.sleep(2000);
				choosemedicine.selectByIndex(9);
				Thread.sleep(2000);
				driver.findElement(By.id("txttreat")).sendKeys("6");
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				
				Thread.sleep(5000);
				category.selectByIndex(5);
				Thread.sleep(2000);
				choosemedicine.selectByIndex(11);
				Thread.sleep(2000);
				driver.findElement(By.id("txttreat")).sendKeys("8");
				Thread.sleep(2000);
				driver.findElement(By.id("btnadd")).click();
				Thread.sleep(5000);
				
			Lab_Rno = driver.findElement(By.id("txtno")).getAttribute("value").trim();
		    	 
		
				try {
				
					while(true)
					{
					JavascriptExecutor scroll = (JavascriptExecutor) driver;
					scroll.executeScript("window.scrollBy(0,100)", "");
					
					try {
						driver.findElement(By.id("btnsave")).click();
						break;
					} catch (Exception e) {
						//e.printStackTrace();
						continue;
					}
					
					}
					
					Thread.sleep(3000);
				
					 String labrequestalert=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText().trim();
					 System.out.println("* LAB REQUEST ALERT "+labrequestalert);
					 
					 String alertmsgis="Already Exist this Request No !";
						if(labrequestalert.contains(alertmsgis))
						{
							driver.navigate().refresh();
							Thread.sleep(2000);
							Lab_storerequest();
						}
						else
						{
							ss();
					 driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
					 System.out.println("* LAB REQUEST SEND SUCCESSFULLY ");
					 System.out.println("* LAB REQUEST NUMBER IS :"+Lab_Rno);
						}
						}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					while(true)
					{
					JavascriptExecutor scroll = (JavascriptExecutor) driver;
					scroll.executeScript("window.scrollBy(0,100)", "");
					
					try {
						driver.findElement(By.id("btnsave")).click();
						break;
					} catch (Exception e1) {
						//e.printStackTrace();
						continue;
					}
					
					}
					Thread.sleep(3000);
					
					String labrequestalert=driver.findElement(By.xpath("/html/body/div[8]/div/div/div[1]/div")).getText();
					System.out.println("* LAB REQUEST ALERT "+labrequestalert);
					
					 String alertmsgis="Already Exist this Request No !";
						if(labrequestalert.contains(alertmsgis))
						{
							driver.navigate().refresh();
							Thread.sleep(2000);
							Lab_storerequest();
						}
					
						else
						{
					try 
					{
						driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
					} 
					catch (Exception e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
						driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button")).click();
					}
					System.out.println(" ");
					System.out.println("* LAB REQUEST SEND SUCCESSFULLY ");
					System.out.println("* LAB REQUEST NUMBER IS :"+Lab_Rno);
						}
						}
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a/span")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/ul/li[3]/a")).click();// pending request
			
		
			
		}
			

		// RETURN EXPIRED MEDICINE
		// =========================
		public void return_medicine() throws InterruptedException 
		{
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[5]/a")).click();
			if (driver.findElement(By.id("btnreturn")).isDisplayed()) {
				driver.findElement(By.id("seldes")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("btnreturn")).click();
			} else {
				System.out.println("* There is no Expired Medicine");
			}
		
		}
	@AfterMethod
		public void screen(ITestResult labrequestresult) throws IOException 
		{
	if(labrequestresult.getStatus()==ITestResult.FAILURE)
	{
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("E:\\Jenkins output\\Lab\\"+date1+"" + labrequestresult.getName() + "-" + Arrays.toString(labrequestresult.getParameters()) +".png"));
		//	FileUtils.copyFile(src, new File("E:\\Jenkins output\\Lab\\" + System.currentTimeMillis() + ".png"));
		}}

		public void CMO() throws InterruptedException, IOException {

			
			System.out.println("* LOGIN TO CMO ");
			// CMO APPROVAL
			// ==================
			try {
				Thread.sleep(3000);
				driver.findElement(By.linkText("CMO")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("txtusername")).sendKeys("jana");
				driver.findElement(By.id("txtpassword")).sendKeys("jana123");
				Thread.sleep(3000);
				WebElement submit=driver.findElement(By.id("btnSubmit"));
				Actions action=new Actions(driver);
				action.moveToElement(submit).click().perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				try {
					driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
				}  
				catch (Exception e)
 {
					e.printStackTrace();
					Thread.sleep(3000);
					driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
				}
			} 
			catch (Exception e) 
			{
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				driver.navigate().refresh();
				Thread.sleep(3000);
			//	driver.findElement(By.linkText("CMO")).click();
				driver.findElement(By.id("txtusername")).sendKeys("jana");
				driver.findElement(By.id("txtpassword")).sendKeys("jana123");
				Thread.sleep(3000);
				WebElement submit=driver.findElement(By.id("btnSubmit"));
				Actions action=new Actions(driver);
				action.moveToElement(submit).click().perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a/span")).click();
			}
				try {
					Thread.sleep(2000);
				//	driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
					
					CMORNO=Lab_Rno.toString().split("\\/")[2].trim();
				//	CMORNO = Rno.substring(14, 16);
					 System.out.println(" ");
		             System.out.println("* SEARCH THE LAB REQUEST");
	                Thread.sleep(4000);
	                Select Ldept=new Select(driver.findElement(By.id("optdept")));
	                Thread.sleep(4000);
	                Ldept.selectByIndex(4);
	                Thread.sleep(2000);
	                Select Status=new Select(driver.findElement(By.id("optsta")));
	                Thread.sleep(500);
	                Status.selectByIndex(1);
	                Thread.sleep(500);
	                driver.findElement(By.id("btnsearch")).click();
	                Thread.sleep(2000);
	              
	                while(true)
		            {
					JavascriptExecutor cmo = (JavascriptExecutor) driver;
					cmo.executeScript("window.scrollBy(0,100)", "");
					try {
						driver.findElement(By.id(CMORNO)).click();
						break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
						if(Seconds==50)
						{
							System.out.println("* Request is not received to CMO due to Hospital Id Is Mismatching");
							break;
							
						}
						Seconds++;
						continue;
						
					}
		            }
	                
	                if(Seconds==50)
					{
						driver.close();
						Thread.sleep(3000);
						nn();
						
					}
					Thread.sleep(2000);
					Select Approval = new Select(driver.findElement(By.id("optstatus")));
					Thread.sleep(2000);
					Approval.selectByIndex(1);
					Thread.sleep(2000);
					driver.findElement(By.id("btnupdate")).click();
					
					 
					Thread.sleep(2000);
					driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
					System.out.println(" ");
	                System.out.println("* CMO UPDATED THE LAB REQUEST SUCCESSFULLY");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					driver.navigate().refresh();
					driver.findElement(By.xpath("//*[text()='Department Wise Request']")).click();
					Thread.sleep(2000);
					CMORNO=Lab_Rno.toString().split("\\/")[2].trim();
					Thread.sleep(2000);
					System.out.println(CMORNO);
				    System.out.println(" ");
		            System.out.println("* SEARCH THE LAB REQUEST");
					Thread.sleep(4000);
		                Select Ldept=new Select(driver.findElement(By.id("optdept")));
		                Thread.sleep(4000);
		                Ldept.selectByIndex(4);
		                Thread.sleep(2000);
		                
		                Select Status=new Select(driver.findElement(By.id("optsta")));
		                Thread.sleep(500);
		                Status.selectByIndex(1);
		                Thread.sleep(500);
		                
		                driver.findElement(By.id("btnsearch")).click();
		                Thread.sleep(2000);
					
		                while(true)
			            {
						JavascriptExecutor cmo = (JavascriptExecutor) driver;
						cmo.executeScript("window.scrollBy(0,100)", "");
						try {
							driver.findElement(By.id(CMORNO)).click();
							break;
						} catch (Exception e) {
							// TODO Auto-generated catch block
						//	e.printStackTrace();
							if(Seconds==50)
							{
								System.out.println("* Request is not received to CMO due to Hospital Id Is Mismatching");
								break;
								
							}
							Seconds++;
							continue;
							
						}
			            }
		                
		                if(Seconds==50)
						{
							driver.close();
							Thread.sleep(3000);
							nn();
							
						}
		                
					Select Approval = new Select(driver.findElement(By.id("optstatus")));
					Thread.sleep(2000);
					Approval.selectByIndex(1);
					Thread.sleep(2000);
					driver.findElement(By.id("btnupdate")).click();
					 
					Thread.sleep(2000);
					driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
					System.out.println(" ");
	                System.out.println("* CMO UPDATED THE LAB REQUEST SUCCESSFULLY");
				}
				//signout();
			}
		

		public void signout() throws InterruptedException {
			try {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[text()='Sign out']")).click();
				Thread.sleep(3000);
				System.out.println(" ");
	            System.out.println("* SIGN OUT SUCCESSFULLY");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				driver.navigate().refresh();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[text()='Sign out']")).click();
				Thread.sleep(3000);
				System.out.println(" ");
	            System.out.println("* SIGN OUT SUCCESSFULLY");
			}
			
		}

	public void DMS() throws InterruptedException, IOException {
		
		System.out.println(" ");
	    System.out.println("* LOGIN TO DIVISIONAL STORE");
			
			try {
				 Thread.sleep(3000);
				try {
					driver.findElement(By.linkText("Divisional Store")).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 Thread.sleep(3000);
					driver.findElement(By.linkText("Divisional Store")).click();
				}
				driver.findElement(By.id("txtusername")).sendKeys("navas");
				driver.findElement(By.id("txtpassword")).sendKeys("navas123");
				 Thread.sleep(3000);
				WebElement submit=driver.findElement(By.id("btnSubmit"));
				Actions action=new Actions(driver);
				action.moveToElement(submit).click().perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				driver.navigate().refresh();
				 Thread.sleep(3000);
				 driver.findElement(By.id("txtusername")).sendKeys("navas");
				driver.findElement(By.id("txtpassword")).sendKeys("navas123");
				 Thread.sleep(3000);
				WebElement submit=driver.findElement(By.id("btnSubmit"));
				Actions action=new Actions(driver);
				action.moveToElement(submit).click().perform();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			
			Thread.sleep(2000);
			try {
				
				
				WebElement LabRequest=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[8]/a")); //Lab Request
				clickactions(LabRequest);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				WebElement LabRequest=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[8]/a")); //Lab Request
				clickactions(LabRequest);
			} 
			Thread.sleep(2000);
			try {
				WebElement Requested_ItemLab=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[8]/ul/li[1]/a")); //Requested Item Lab
			    clickactions(Requested_ItemLab);
			} 
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Thread.sleep(2000);
				WebElement Requested_ItemLab=driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[8]/ul/li[1]/a")); //Requested Item Lab
			    clickactions(Requested_ItemLab);
			}
			Thread.sleep(2000);
			driver.findElement(By.id(CMORNO)).click();
			Thread.sleep(3000);
			System.out.println(" ");
		    System.out.println("* LAB REQUESTED ITEMS ARE ISSUE IN PROCESS");
			WebElement med = driver.findElement(By.id("fldproduct"));
			Select product = new Select(med);
			List product_list = product.getOptions();
			
			
			for (a = 1; a <product_list.size();a++) 
			{
				Thread.sleep(2000);
				product.selectByIndex(a);
			//	String test_name=list.get(i).getText().toString();
			    Product_name=product.getOptions().get(a).getText().toString();
				Thread.sleep(2000);		
				Boolean isPresent = driver.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/button")).size() > 0;
				if(isPresent)
				{
					System.out.println(Product_name  +"* Medicine stock qty is not avilable or expired");
					Thread.sleep(3000);
					driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
					continue;
				}
				WebElement batch =(driver.findElement(By.id("fldbatch")));
				Select batchnumber = new Select(batch);
				List batchnumber_list = batchnumber.getOptions();
				//Thread.sleep(2000);
				
					for(int q=1;q<batchnumber_list.size();q++)
					{
						batchnumber.selectByIndex(q);
						
						Thread.sleep(2000);
						
						 Stock_qty = driver.findElement(By.id("txtprice")).getAttribute("value");
						 Required_qty = driver.findElement(By.id("txttotal")).getAttribute("value");
						 
						 System.out.println(Product_name +"=== Stockqty :" +Stock_qty+ " Required Qty :"+Required_qty);
						 
						 if (Integer.parseInt(Stock_qty) >= Integer.parseInt(Required_qty))
							{
								Thread.sleep(2000);
								driver.findElement(By.id("txtqty")).sendKeys(String.valueOf(Required_qty));
								driver.findElement(By.id("btnadd")).click();
								
								break;
							}
						 else
						 {
							 System.out.println(Product_name +"=== Stockqty is less than required qty");
							 System.out.println(Product_name +"=== Stock qty available is : " +Stock_qty+ " Required Qty Is:"+Required_qty);
						 }
					}
				
				
				Thread.sleep(2000);
			}
			
			try 
			{
				Thread.sleep(3000);
				JavascriptExecutor scrollsub=(JavascriptExecutor)driver;
				scrollsub.executeScript("window.scrollBy(0,500)","");
				Thread.sleep(2000);
				PRNO=driver.findElement(By.id("lblpono")).getAttribute("value");
				System.out.println(PRNO);
				 
				driver.findElement(By.id("btnSubmit")).click();
	            Thread.sleep(3000);
	                       
	            String Labissued=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
	            System.out.println("Lab Issued Alert " +Labissued);
	            
				driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				System.out.println(" ");
			    System.out.println("* LAB REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");
				
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				JavascriptExecutor scrollsub=(JavascriptExecutor)driver;
				scrollsub.executeScript("window.scrollBy(0,300)","");
				Thread.sleep(2000);
				WebElement submit=driver.findElement(By.id("btnSubmit"));
				Actions action=new Actions(driver);
				action.moveToElement(submit).click().perform();
				Thread.sleep(3000);
				
				String Labissued=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
	            System.out.println("Lab Issued Alert " +Labissued);
				
		        driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
		        Thread.sleep(3000);  
		        System.out.println(" ");
			    System.out.println("* LAB REQUESTED ITEMS ARE ISSUED SUCCESSFULLY");
			}

		}
	public void ack_lab() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.linkText("Investigation")).click();
		driver.findElement(By.id("txtusername")).sendKeys("vishnu");
		driver.findElement(By.id("txtpassword")).sendKeys("vishnu123");
		WebElement submit=driver.findElement(By.id("btnSubmit"));
		Actions action=new Actions(driver);
		action.moveToElement(submit).click().perform();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		
		System.out.println("* NEW STOCK LIST");
		System.out.println(" ");
		for( g=1;g<row;g++)
		{
			
			System.out.println("\n==============================================================================\n");
			for( h=1;h<column;h++)
				{
				 stock_list=driver.findElement(By.xpath("//*[@id='tblstockdetails']/tbody/tr["+g+"]/td["+h+"]")).getText();
				 System.out.println(stock_list);
				}
		
			
		
		/*
		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/ul/li[4]/a")).click();
			Thread.sleep(2000);
//		String Issuedno=PRNO.toString().split("\\/")[2].trim();
			driver.findElement(By.id(Lab_Rno)).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtackremarks")).sendKeys("* Medicine Received-LAB");
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/ul/li[4]/a")).click();
			Thread.sleep(2000);
//		String Issuedno=PRNO.toString().split("\\/")[2].trim();
			driver.findElement(By.id(Lab_Rno)).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtackremarks")).sendKeys("* Medicine Received-LAB");
			Thread.sleep(2000);
			driver.findElement(By.id("btnadd")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).click();
		}*/
	}
		System.out.println(" ");
		
	}

	public void clickactions(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void ss() throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Jenkins output\\Labrequest\\"+date1+"" +System.currentTimeMillis()  +".png"));
		
	}
	
	class StockData
	{
		public String product_Name,rece_qty,stock_qty;
		

		public String getProduct_Name()
		{
			return product_Name;
		}

		public void setProduct_Name(String product_Name) {
			this.product_Name = product_Name;
		}

		public String getRece_qty() {
			return rece_qty;
		}

		public void setRece_qty(String rece_qty) {
			this.rece_qty = rece_qty;
		}

		public String getStock_qty() {
			return stock_qty;
		}

		public void setStock_qty(String stock_qty) {
			this.stock_qty = stock_qty;
		}
		
		
		
	}
	}



