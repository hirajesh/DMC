package com.test.kdmc;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
import org.testng.annotations.Test;

public class HealthpostStoreRequest {

	WebDriver go;
	String Healtpost_Requestnumber,CMORNO;
	boolean sscallow=false;
	
	@Test
	public void Healthpost() throws InterruptedException, IOException 
	{
		System.out.println("TEST CASE : Verify Healthpost To Store Request Are Working Suceccessfully Or Not");
		
		HealthpostLogin();
		HealthpostRequest();
		SIGNOUT();
		CMO();
		SIGNOUT();
		DMS_LOGIN();
		IssueHealthpoststoremedicine();
		SIGNOUT();
		/*Ack();
		SIGNOUT();*/
		go.close();
	}
	
	
	
	public void HealthpostLogin() throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		go=new ChromeDriver();
		//go.get("http:\\192.168.137.1/Multihospital_new/");
		go.get("http://192.168.137.1/Multihospital_New/HDSplashscreen.aspx");
		go.manage().window().maximize();
		
		/*Thread.sleep(3000);
		go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		Thread.sleep(500);
		go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li[1]/a")).click();
		Thread.sleep(2000);*/
		
		go.findElement(By.xpath("//*[@id='form1']/div[6]/div[2]/div/div[4]/label/a")).click();
		if(sscallow)
		ssc();
		go.findElement(By.id("txtusername")).sendKeys("fwhjana");
		if(sscallow)
		ssc();
		go.findElement(By.id("txtpassword")).sendKeys("123");
		if(sscallow)
		ssc();
		go.findElement(By.id("btnSubmit")).click();
	
		
	}
	
	public void HealthpostRequest() throws InterruptedException, IOException 
	{
		Thread.sleep(5000);
		try 
		{
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/a")).click();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			Thread.sleep(2000);
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/a")).click();
		}
		
		try 
		{
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/ul/li[1]/a")).click();
		}
		catch (Exception e) 
		{
		
			e.printStackTrace();
			Thread.sleep(2000);
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[5]/ul/li[1]/a")).click();
		}
		
		
		Thread.sleep(2000);
		if(sscallow)
		ssc();
		/*Select rtype = new Select(go.findElement(By.id("drpreqtype")));
		rtype.selectByIndex(1);*/
	
		Select category = new Select(go.findElement(By.id("optcategory")));
		category.selectByIndex(2);
		if(sscallow)
		ssc();
		Thread.sleep(2000);
		Select choosemedicine = new Select(go.findElement(By.id("optmedicine")));
		choosemedicine.selectByIndex(5);
		if(sscallow)
		ssc();

		go.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
		if(sscallow)
	     ssc();
		go.findElement(By.id("btnadd")).click();
		if(sscallow) ssc();
		
/*		Thread.sleep(500);
		category.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(2);
		go.findElement(By.id("txttreat")).sendKeys("50"); 
		Thread.sleep(500);
	    go.findElement(By.id("btnadd")).click();
		Thread.sleep(1000);
	    if(sscallow) 
	    	ssc();
		

		Thread.sleep(500);
		category.selectByIndex(1);
		Thread.sleep(500);
		choosemedicine.selectByIndex(4);
		Thread.sleep(500);
		go.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
     	go.findElement(By.id("btnadd")).click();
		
		
		Thread.sleep(500);
		
		Select category1 = new Select(go.findElement(By.id("optcategory")));
		category1.selectByIndex(1);
		Thread.sleep(500);
		Select choosemedicine1 = new Select(go.findElement(By.id("optmedicine")));
		choosemedicine1.selectByIndex(2);
		
		go.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
     	go.findElement(By.id("btnadd")).click();

		Thread.sleep(500);
		category.selectByIndex(12);
		Thread.sleep(500);
		choosemedicine.selectByIndex(2);
		
		go.findElement(By.id("txttreat")).sendKeys("200"); 
		Thread.sleep(500);
     	go.findElement(By.id("btnadd")).click();
		
		Thread.sleep(500);
		category.selectByIndex(3);
		Thread.sleep(500);
		choosemedicine.selectByIndex(2);
		Thread.sleep(500);
		go.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
	    go.findElement(By.id("btnadd")).click();
		
		Thread.sleep(500);
		category.selectByIndex(3);
		Thread.sleep(500);
		choosemedicine.selectByIndex(16);
		Thread.sleep(500);
		go.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
	    go.findElement(By.id("btnadd")).click();
		
		Thread.sleep(500);
		category.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(7);
		Thread.sleep(500);
		go.findElement(By.id("txttreat")).sendKeys("250"); 
		Thread.sleep(500);
	    go.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);
		
		Thread.sleep(500);
		category.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(8);
		Thread.sleep(500);
		go.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
	    go.findElement(By.id("btnadd")).click();
		Thread.sleep(2000);*/
		
		Thread.sleep(500);
		category.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(9);
		Thread.sleep(500);
		go.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
	    go.findElement(By.id("btnadd")).click();
		Thread.sleep(5000);
		
		 Healtpost_Requestnumber = go.findElement(By.id("txtno")).getAttribute("value").trim();
		 CMORNO = Healtpost_Requestnumber.toString().split("\\/")[2].trim();
		 
		  try
		     {
		    		
		    while(true)
		    {
		    scroll();
		    try 
		    {
		     go.findElement(By.id("btnsave")).click();
		     
		     break;
		    } 
		    catch (Exception e) 
		     {			
		      e.printStackTrace();
		      continue;
		      }
		    		
		      }
					
		   
					Thread.sleep(4000);
					 if(sscallow)
						 ssc();
					String Alerttextcms=go.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText().trim();
					Thread.sleep(2000);
					 String alertmsgis="Already Exist this Request No !";
						if(Alerttextcms.contains(alertmsgis))
						{
							go.navigate().refresh();
							Thread.sleep(2000);
							
						}
						else
						{
					try {
						go.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
					} catch (Exception e) 
					{
						Thread.sleep(2000);
						go.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
						e.printStackTrace();
					}
					Thread.sleep(2000);
				
				 System.out.println("* Alert Text"+Alerttextcms);
		         System.out.println("* HEALTHPOST REQUEST SEND SUCCESSFULLY ");
				 System.out.println("* HEALTHPOST REQUEST NUMBER IS " +Healtpost_Requestnumber);
		 
						}
		     }
		  catch (Exception e) 
		     {			
			  while(true)
			    {
			    scroll();
			    try 
			    {
			     go.findElement(By.id("btnsave")).click();
			     break;
			    } 
			    catch (Exception e1) 
			     {			
			      e1.printStackTrace();
			      continue;
			     }
			    		
			     }
			 
			Thread.sleep(4000);
			 if(sscallow) 
		     ssc();
			String Alerttextcms=go.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
			Thread.sleep(2000);
			
			 String alertmsgis="Already Exist this Request No !";
			if(Alerttextcms.contains(alertmsgis))
			{
				go.navigate().refresh();
				Thread.sleep(2000);
				
			}
			else
			{
		try {
			go.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
		} catch (Exception e1) 
		{
			Thread.sleep(2000);
			go.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			e1.printStackTrace();
		}
		Thread.sleep(2000);
	
	 System.out.println("* Alert Text"+Alerttextcms);
     System.out.println("* HEALTHPOST REQUEST SEND SUCCESSFULLY ");
	 System.out.println("* HEALTHPOST REQUEST NUMBER IS " +Healtpost_Requestnumber);

			}
		    }
	}
	
	
	public void DMS_LOGIN() throws InterruptedException, IOException 
	{
		
		try {
			 
			go.findElement(By.linkText("Divisional Store")).click();
			if(sscallow) 
				ssc();
			go.findElement(By.id("txtusername")).sendKeys("fwanwar");
			if(sscallow) 
				ssc();
			go.findElement(By.id("txtpassword")).sendKeys("123");
			if(sscallow)
				ssc();
			go.findElement(By.id("btnSubmit")).click();
		
			System.out.println("* LOGIN TO DMS");
			go.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} 
		catch (Exception e1) 
		{
			
			e1.printStackTrace();
			go.navigate().refresh();
			Thread.sleep(3000);
			 
			WebElement div=go.findElement(By.linkText("Divisional Store"));
			Clickaction(div);
			if(sscallow) 
				ssc();
			go.findElement(By.id("txtusername")).sendKeys("fwanwar");
			if(sscallow)
				ssc();
			go.findElement(By.id("txtpassword")).sendKeys("123");
			if(sscallow) 
				ssc();
			go.findElement(By.id("btnSubmit")).click();
			
			go.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("* LOGIN TO CMS");
		}
		
}
	public void IssueHealthpoststoremedicine() throws InterruptedException, IOException 
	{
		Thread.sleep(5000);
	try 
	{
		go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[10]/a")).click();
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		WebElement exp=go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[10]/a"));
	    Clickaction(exp);	
	}	
	
	try 
	{
		go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[10]/ul/li[1]/a")).click();
	} catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		Thread.sleep(2000);
		go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[10]/ul/li[1]/a")).click();
	}
	
	   go.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMORNO);
	   Thread.sleep(2000);
	   if(sscallow) 
		   ssc();
	   go.findElement(By.id(CMORNO)).click();
	   if(sscallow) 
		   ssc();
	   Select product=new Select(go.findElement(By.id("fldproduct")));
	   int opt=product.getOptions().size();
	 
	   for(int r=1;r<opt;r++)
	   {
		   product.selectByIndex(r);
		   if(sscallow) 
			   ssc();
		   String productname = product.getOptions().toString();
		   
		   Boolean pharmacyispresent=go.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/button")).size() > 0;
		
		   if(pharmacyispresent)
			{
				System.out.println(productname  +"* Medicine stock qty is not avilable or expired");
				Thread.sleep(300);
				go.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				continue;
			}
		   
		   
		   
		   WebElement batch =(go.findElement(By.id("fldbatch")));
			Select batchnumber = new Select(batch);
			List batchnumber_list = batchnumber.getOptions();
	
			for(int q=1;q<batchnumber_list.size();q++)
			{
				batchnumber.selectByIndex(q);
				
				Thread.sleep(2000);
				
				 String Stock_qty = go.findElement(By.id("txtprice")).getAttribute("value");
				 String Required_qty = go.findElement(By.id("txttotal")).getAttribute("value");
				 
				
				 
				 if (Integer.parseInt(Stock_qty) > Integer.parseInt(Required_qty))
					{
					 if(sscallow)
						 ssc();
						go.findElement(By.id("txtqty")).sendKeys(String.valueOf(Required_qty));
						Thread.sleep(2000);
						if(sscallow)
							ssc();
						go.findElement(By.id("btnadd")).click();
						Thread.sleep(2000);
						 if(sscallow)
							 ssc();
						break;
						
					}
				 else
				 {
					 System.out.println(productname +"=== Stockqty is less than required qty");
					 System.out.println(productname +"=== Stock qty available is : " +Stock_qty+ " Required Qty Is:"+Required_qty);
				
				 }
				
			}
	   }
	   
	   try 
	   {
		scroll();
		   go.findElement(By.id("btnSubmit")).click();
	     } 
	   catch (Exception e) 
	   {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 scroll();
		   go.findElement(By.id("btnSubmit")).click();
	}
	   Thread.sleep(4000);
	   if(sscallow)
		   ssc();
	   go.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
	   

	}
	
	public void CMO() throws InterruptedException, IOException {

		System.out.println("* LOGIN TO CMO ");
	   Thread.sleep(3000);
	   
	   go.get("http:\\192.168.137.1/Multihospital_new/");
	/*	try 
		{
			go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		} 
		catch (Exception e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
			Thread.sleep(2000);
			go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		}
		Thread.sleep(2000);
		try {
			go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li/a")).click();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			Thread.sleep(2000);
			go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li/a")).click();
		}*/
		Thread.sleep(4000);
		
		// CMO APPROVAL
		// ==================
		try {
			Thread.sleep(3000);
			try {
				go.findElement(By.linkText("CMO")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				go.findElement(By.linkText("CMO")).click();
			}
			if(sscallow)
				ssc();
			Thread.sleep(2000);
			go.findElement(By.id("txtusername")).sendKeys("fwmuthu");
			if(sscallow) 
			ssc();
			go.findElement(By.id("txtpassword")).sendKeys("123");
			if(sscallow)
				ssc();
			go.findElement(By.id("btnSubmit")).click();
		
			go.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			  go.get("http:\\192.168.137.1/Multihospital_new/");
			//go.navigate().refresh();
			Thread.sleep(3000);
			go.findElement(By.linkText("CMO")).click();
			if(sscallow)
				ssc();
			go.findElement(By.id("txtusername")).sendKeys("fwmuthu");
			if(sscallow) 
				ssc();
			go.findElement(By.id("txtpassword")).sendKeys("123");
			if(sscallow)
				ssc();
			go.findElement(By.id("btnSubmit")).click();

			go.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[4]/a/span")).click();
	 	}
			
		try {
				
			
				Thread.sleep(2000);
			//	go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[2]/a")).click();
				Thread.sleep(2000);
				CMORNO=Healtpost_Requestnumber.toString().split("\\/")[2].trim();
			    Thread.sleep(4000);
			    if(sscallow) 
			    	ssc();
			    System.out.println(" ");
	             System.out.println("* SEARCH THE HEALTHPOST REQUEST");
               Select Idept=new Select(go.findElement(By.id("optdept")));
               Thread.sleep(4000);
               Idept.selectByIndex(5);
               Thread.sleep(2000);
               Select Status=new Select(go.findElement(By.id("optsta")));
               Thread.sleep(500);
               Status.selectByIndex(1);
               Thread.sleep(500);
               go.findElement(By.id("btnsearch")).click();
               Thread.sleep(3000);
               
               if(sscallow) 
            	   ssc();
				for(int Seconds=0;;Seconds++)
				{
				boolean flag=false;  
               
        	  while(true)
	            {
				JavascriptExecutor cmo = (JavascriptExecutor) go;
				cmo.executeScript("window.scrollBy(0,200)", "");
				try 
				{
			
				go.findElement(By.id(CMORNO)).click();
				flag=true;
				
				break;
					
				} 
				catch (Exception e) 
				{
				 e.printStackTrace();
				if(Seconds<=60)
				{
				break;
				}
				continue;
				
				}
	            }
        	  if(flag)
		       {
				break;
		       }
			   }
       
				Thread.sleep(2000);
				if(sscallow)
					ssc();
				Select Approval = new Select(go.findElement(By.id("optstatus")));
				Thread.sleep(2000);
				Approval.selectByIndex(1);
				Thread.sleep(2000);
				if(sscallow) 
					ssc();
				go.findElement(By.id("btnupdate")).click();
				
				Thread.sleep(2000);
				if(sscallow) 
					ssc();
				go.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println(" ");
                System.out.println("* CMO UPDATED THE HEALTHPOST REQUEST SUCCESSFULLY");
                if(sscallow) 
                	ssc();
	
                
	             }
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				go.navigate().refresh();
				go.findElement(By.xpath("//*[text()='Department Wise Request']")).click();
				Thread.sleep(200);
				CMORNO=Healtpost_Requestnumber.toString().split("\\/")[2].trim();
				Thread.sleep(200);
				System.out.println(CMORNO);
				Thread.sleep(4000);
				if(sscallow)
					ssc();
				 System.out.println(" ");
	             System.out.println("* SEARCH THE HEALTHPOST REQUEST");
	              Select Idept=new Select(go.findElement(By.id("optdept")));
				    Thread.sleep(400);
	               Idept.selectByIndex(5);
	               Thread.sleep(200);
	               Select Status=new Select(go.findElement(By.id("optsta")));
	                Thread.sleep(500);
	                Status.selectByIndex(1);
	                Thread.sleep(500);
	               go.findElement(By.id("btnsearch")).click();
	                Thread.sleep(2000);
	            	for(int Seconds=0;;Seconds++)
					{
					boolean flag=false;  
	               
	        	  while(true)
		            {
					JavascriptExecutor cmo = (JavascriptExecutor) go;
					cmo.executeScript("window.scrollBy(0,200)", "");
					try 
					{
					go.findElement(By.id(CMORNO)).click();
					if(sscallow)
						ssc();
					flag=true;
				    break;
						
					} 
					catch (Exception e) 
					{
					
					if(Seconds<=120)
					{
					break;
					}
					continue;
					
					}
		            }
	        	  if(flag)
			       {
					break;
			       }
				   }
				Thread.sleep(2000);
				Select Approval = new Select(go.findElement(By.id("optstatus")));
				Thread.sleep(200);
				Approval.selectByIndex(1);
				if(sscallow) 
					ssc();
				Thread.sleep(200);
				go.findElement(By.id("btnupdate")).click();
				
				Thread.sleep(200);
				if(sscallow)
					ssc();
				go.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println(" ");
				System.out.println("* CMO UPDATED THE HEALTHPOST REQUEST SUCCESSFULLY");
			}
			
			//signout();
		}
	
	public void SIGNOUT() throws InterruptedException {
		try {
			Thread.sleep(2000);
			go.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			go.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println(" ");
            System.out.println("* SIGN OUT SUCCESSFULLY");
		} catch (Exception e) {
		
		//	e.printStackTrace();
			go.navigate().refresh();
			Thread.sleep(6000);
			go.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			go.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println(" ");
            System.out.println("* SIGN OUT SUCCESSFULLY");
		}
		
	}

	public void scroll()
	{
		JavascriptExecutor scroll = (JavascriptExecutor) go;
		scroll.executeScript("window.scrollBy(0,200)", "");
	}
	
	
	public void Clickaction(WebElement Element)
	{
		Actions action=new Actions(go);
		action.moveToElement(Element).click().build().perform();
	}
	public void ssc() throws IOException
	{
		File src = ((TakesScreenshot) go).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Jenkins output\\Healthpoststore\\" +System.currentTimeMillis()  +".png"));
		
	}		
	public void faliedscreen(ITestResult HealthpostTestResult) throws IOException
	{
		File src=((TakesScreenshot)go).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("E:\\Jenkins output\\Healthpoststore\\"+HealthpostTestResult.getName()+"-" +Arrays.toString(HealthpostTestResult.getParameters()) +".png"));
	}
	public void Ack() throws InterruptedException
	{
		try 
		{
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/a")).click();
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/a")).click();
		}
		try 
		{
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[1]/a")).click();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[1]/a")).click();
		}
		
	      	go.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMORNO);
	      	Thread.sleep(500);
	      	go.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[1]")).click();
	      	go.findElement(By.id("txtackremarks")).sendKeys("Medicine Received Rno Is: "+Healtpost_Requestnumber);
	      	Thread.sleep(500);
	      	go.findElement(By.id("btnadd")).click();
	      	Thread.sleep(3000);
	      	go.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).click();
	}
}
