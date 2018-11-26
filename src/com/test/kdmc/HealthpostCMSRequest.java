package com.test.kdmc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.testng.annotations.Test;



public class HealthpostCMSRequest
{

	WebDriver go;
	String Healtpost_Requestnumber,CMORNO;
	String stok_qty_in_cms,Requestedqty,issued,medicine;
	String Stock;
	int a,z=30;
	List<Integer> ok=new ArrayList<Integer>();
	List<Integer> getok=new ArrayList<Integer>();
	
	
	@Test
	public void HealthposttoCms() throws InterruptedException, IOException 
	{
		
		
		System.out.println("TEST CASE : Verify Healthpost To CMS Request Are Working Suceccessfully Or Not");
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\New folder\\chromedriver.exe"); 
		go=new ChromeDriver();
		go.get("http://192.168.137.1/Multihospital_New/");
		go.manage().window().maximize();
		Thread.sleep(3000);
		
		
		
		
		HealthpostLogin();
		Thread.sleep(2000);
		HealthpostRequest();
		Thread.sleep(2000);
		SIGNOUT();
		Thread.sleep(2000);
		CMO();
		Thread.sleep(2000);
		SIGNOUT();
		Thread.sleep(2000);
		CMS_LOGIN();
		Thread.sleep(2000);
		IssueDispensarystoremedicine();
		Thread.sleep(2000);
		Dispatchfromcms();
		Thread.sleep(2000);
		SIGNOUT();
		Thread.sleep(2000);
		HealthpostLogin();
		Thread.sleep(2000);
		Addto_Stock();
		Thread.sleep(2000);
		go.close();

	}
	
	
	public void HealthpostLogin() throws InterruptedException, IOException 
	{
		
		go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		Thread.sleep(500);
		go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		go.findElement(By.xpath("//*[@id='form1']/div[6]/div[2]/div/div[4]/label/a")).click();
		
		go.findElement(By.id("txtusername")).sendKeys("fwhjana");
		ss();
		go.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(3000);
		ss();
		go.findElement(By.id("btnSubmit")).click();
		
	}
	
	public void HealthpostRequest() throws InterruptedException, IOException 
	{
		try 
		{
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/a")).click();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			Thread.sleep(2000);
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/a")).click();
		}
		
		try 
		{
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/ul/li[1]/a")).click();
		}
		catch (Exception e) 
		{
		
			e.printStackTrace();
			Thread.sleep(2000);
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/ul/li[1]/a")).click();
		}
		
		Thread.sleep(2000);
		Select rtype = new Select(go.findElement(By.id("drpreqtype")));
		rtype.selectByIndex(1);
		ss();
		Thread.sleep(2000);
		Select category = new Select(go.findElement(By.id("optcategory")));
		category.selectByIndex(1);
		ss();
		Thread.sleep(2000);
		Select choosemedicine = new Select(go.findElement(By.id("optmedicine")));
		choosemedicine.selectByIndex(2);
		ss();
		go.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
		ss();
		go.findElement(By.id("btnadd")).click();

    	Thread.sleep(500);
		ss();
		category.selectByIndex(3);
		Thread.sleep(500);
		choosemedicine.selectByIndex(11);
		go.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
	    go.findElement(By.id("btnadd")).click();
	    
	    Thread.sleep(500);
		ss();
		category.selectByIndex(4);
		Thread.sleep(500);
		choosemedicine.selectByIndex(4);
		go.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
	    go.findElement(By.id("btnadd")).click();
		
		
      Thread.sleep(500);
		category.selectByIndex(1);
		choosemedicine.selectByIndex(4);
		Thread.sleep(500);
		go.findElement(By.id("txttreat")).sendKeys("150"); 
		Thread.sleep(500);
     	go.findElement(By.id("btnadd")).click();
		
		
		Thread.sleep(500);
		
		Select category1 = new Select(go.findElement(By.id("optcategory")));
		category1.selectByIndex(1);
		
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
		go.findElement(By.id("txttreat")).sendKeys("15"); 
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
		Thread.sleep(5000);
		
		Thread.sleep(500);
		category.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(8);
		Thread.sleep(500);
		go.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
	    go.findElement(By.id("btnadd")).click();
		Thread.sleep(5000);
		
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
		    ss();
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
					
					String Alerttextcms=go.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
					Thread.sleep(2000);
					ss();
					go.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
					Thread.sleep(2000);
				
				 System.out.println("* Alert Text"+Alerttextcms);
		         System.out.println("* HEALTHPOST CMS REQUEST SEND SUCCESSFULLY ");
				 System.out.println("* HEALTHPOST CMS REQUEST NUMBER IS " +Healtpost_Requestnumber);
		 

		     }
		  catch (Exception e) 
		     {			
			  while(true)
			    {
			    scroll();
			    try 
			    {
			    	ss();
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
				ss();
				String Alerttextcms=go.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
				Thread.sleep(2000);
				go.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
				Thread.sleep(2000);
				
			 System.out.println("* Alert Text"+Alerttextcms);
			 System.out.println("* HEALTHPOST CMS REQUEST SEND SUCCESSFULLY ");
			 System.out.println("* HEALTHPOST CMS REQUEST NUMBER IS " +Healtpost_Requestnumber);
		 
		     }
			
	
	
}
	
	public void scroll()
	{
		JavascriptExecutor scroll = (JavascriptExecutor) go;
		scroll.executeScript("window.scrollBy(0,200)", "");
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
	
	
	public void CMO() throws InterruptedException, IOException {

		Thread.sleep(4000);
		System.out.println("* LOGIN TO CMO ");
		try {
			go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		    } 
		catch (Exception e2)
		 {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			Thread.sleep(2000);
			go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		}
		Thread.sleep(1000);
		try
		{
			go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li/a")).click();
		}
		catch (Exception e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
			Thread.sleep(2000);
			go.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li/a")).click();
		}
		Thread.sleep(4000);
		
		// CMO APPROVAL
		// ==================
		try {
			Thread.sleep(3000);
			go.findElement(By.linkText("CMO")).click();
			go.findElement(By.id("txtusername")).sendKeys("guru");
			ss();
			go.findElement(By.id("txtpassword")).sendKeys("123");
			ss();
			go.findElement(By.id("btnSubmit")).click();
			go.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			go.navigate().refresh();
			Thread.sleep(3000);
			go.findElement(By.linkText("CMO")).click();
			ss();
			go.findElement(By.id("txtusername")).sendKeys("guru");
			ss();
			go.findElement(By.id("txtpassword")).sendKeys("123");
			ss();
			go.findElement(By.id("btnSubmit")).click();
			go.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		}
			try {
				Thread.sleep(2000);
				go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/ul/li[2]/a/span")).click();
				Thread.sleep(2000);
				CMORNO=Healtpost_Requestnumber.toString().split("\\/")[2].trim();
			    Thread.sleep(4000);
			    
			    System.out.println(" ");
	            System.out.println("* SEARCH THE HEALTHPOST REQUEST");
               
	           Select Idept=new Select(go.findElement(By.id("optsta")));
               Idept.selectByIndex(1);
               Thread.sleep(2000);
               go.findElement(By.id("btnsearch")).click();
               Thread.sleep(3000);
               ss();
 				
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
				ss();
				Select Approval = new Select(go.findElement(By.id("optstatus")));
				Approval.selectByIndex(1);
				Thread.sleep(2000);
				ss();
				go.findElement(By.id("btnupdate")).click();
			
				Thread.sleep(2000);
				ss();
				go.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println(" ");
                System.out.println("* CMO UPDATED THE HEALTHPOST REQUEST SUCCESSFULLY");
				
	
	             }
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				go.navigate().refresh();
				go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
				Thread.sleep(200);
				go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/ul/li[2]/a/span")).click();
				CMORNO=Healtpost_Requestnumber.toString().split("\\/")[2].trim();
				Thread.sleep(200);
				System.out.println(CMORNO);
				Thread.sleep(4000);
				
				 System.out.println(" ");
	             System.out.println("* SEARCH THE HEALTHPOST REQUEST");
	             
				  Select Idept=new Select(go.findElement(By.id("optsta")));
	               Thread.sleep(400);
	               Idept.selectByIndex(1);
	               Thread.sleep(200);
	               go.findElement(By.id("btnsearch")).click();
	                Thread.sleep(2000);
	            	ss();
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
				ss();
				Select Approval = new Select(go.findElement(By.id("optstatus")));
				Thread.sleep(200);
				Approval.selectByIndex(1);
				ss();
				Thread.sleep(200);
				go.findElement(By.id("btnupdate")).click();
				
				Thread.sleep(200);
				ss();
				go.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
				System.out.println(" ");
				System.out.println("* CMO UPDATED THE HEALTHPOST REQUEST SUCCESSFULLY");
			}
			
			//signout();
		}
	
	
	
	
	public void CMS_LOGIN() throws InterruptedException, IOException 
	{
		
		try {
			 
			go.findElement(By.linkText("CMS")).click();
			ss();
			go.findElement(By.id("txtusername")).sendKeys("cms");
			ss();
			go.findElement(By.id("txtpassword")).sendKeys("123");
			ss();
			go.findElement(By.id("btnSubmit")).click();
		
			System.out.println("* LOGIN TO CMS");
			go.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} 
		catch (Exception e1) 
		{
			
			e1.printStackTrace();
			go.navigate().refresh();
			Thread.sleep(3000);
			 
			go.findElement(By.linkText("CMS")).click();
			ss();
			go.findElement(By.id("txtusername")).sendKeys("cms");
			ss();
			go.findElement(By.id("txtpassword")).sendKeys("123");
			ss();
			go.findElement(By.id("btnSubmit")).click();
			
			go.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("* LOGIN TO CMS");
		}
		
}
	
	public void IssueDispensarystoremedicine() throws InterruptedException 
	{
	try 
	{
		go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/a")).click();
		Thread.sleep(2000);
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		WebElement exp=go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/a"));
	    Clickaction(exp);	
	    Thread.sleep(2000);
	    
	}	
	
	try {
		
		go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/ul/li[2]/a")).click();
	} 
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		go.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/ul/li[2]/a")).click();
	}
	
	}
	
	public void Dispatchfromcms() throws InterruptedException, IOException {

	
		go.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMORNO);
		Thread.sleep(2000);
		//ss();
		go.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[7]")).click();
		Thread.sleep(3000);
		//ss();
	/*	for (int y = 30; y >= 9; y--) 
		{
			
			while (true)
			{

				try
				{
					go.findElement(By.xpath("/html/body/div[" + y + "]/div/div/div[2]/button")).click();
					continue;
				} 
				catch (Exception e) 
				{
					//e.printStackTrace();
					break;
				}

			}

		}*/
		
		ok=new ArrayList<>();
		for(int m=1;m<=30;m++)
		{	
		int f=m%2;
		if(f!=0)
		{
			ok.add(m);
			System.out.println(m);  
			
			
		}
		}

		
	
		int col = go.findElements(By.xpath("/html/body/div[2]/div/div/aside[2]/form/div[5]/section[2]/div/div[3]/div/div/div[2]/div/div/table/tbody/tr/td[1]")).size();
		System.out.println(col);           
		
		int Stockqtynum=go.findElements(By.xpath("/html/body/div[2]/div/div/aside[2]/form/div[5]/section[2]/div/div[3]/div/div/div[2]/div/div/table/tbody/tr/td[2]")).size();
		/* getok=new ArrayList<>();
		for(int t=1;t<=Stockqtynum;t++)
		{
			 Stock=go.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr["+t+"]/td[2]")).getText();
			 
				if(Integer.parseInt(Stock)==0)
				{
                 getok.add(t);
             	
				}
		}*/
		
			for (int y =ok.size(); y>0 ; y--) 
			{
				
				while (true)
				{

					try
					{
						go.findElement(By.xpath("/html/body/div[" + ok.get(y) + "]/div/div/div[2]/button")).click();
						continue;

					} 
					catch (Exception e) 
					{
						//e.printStackTrace();
						break;
					}

				}

			}

		
		
		a = 0;

		row: 
			for (int r = 1; r <= col; r++) 
			{
			try {
				stok_qty_in_cms = go.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[2]")).getText();
				Requestedqty = go.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]")).getText();
				System.out.println("* Requested Qty :" + Requestedqty);
				System.out.println("* Stock Qty in CMS:" + stok_qty_in_cms);
				System.out.println("=========================================");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				while(true)
				{
				Thread.sleep(2000);
				JavascriptExecutor scroll = (JavascriptExecutor) go;
	 			scroll.executeScript("window.scrollBy(0,200)", "");
	 			Thread.sleep(2000);
				 try {
					stok_qty_in_cms = go.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[2]")).getText();
					 Requestedqty = go.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]")).getText();
					 break;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					continue;
				}
				}
				System.out.println("* Requested Qty :" + Requestedqty);
				System.out.println("* Stock Qty in CMS:" + stok_qty_in_cms);
				System.out.println("=========================================");
			}

			if (Integer.parseInt(stok_qty_in_cms) < Integer.parseInt(Requestedqty)) 
			{
				a++;
				System.out.println("* Stock Qty in less Than requested qty");
				continue row;

			}

			Select batch = new Select(go.findElement(By.id("fldvendor" + a)));

			int bat = batch.getOptions().size();

			//System.out.println(bat);

			for (int y = 1; y <= bat - 1; y++) {
				batch.selectByIndex(y);
				String Batchqty = go.findElement(By.id("txtbthqty" + a)).getAttribute("value");

			//	Thread.sleep(500);
				System.out.println("* Stockqty for this batch number:" + Batchqty);

				if (Integer.parseInt(Batchqty) >= Integer.parseInt(Requestedqty))
				{
					 issued = go.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]")).getText();
					 medicine = go.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[1]")).getText();
						ss();
					break;

				}
				System.out.println("Stock Qty in less Than requested qty for this batch number");

			}
			a++;
		}
		while (true) {
			JavascriptExecutor cmo = (JavascriptExecutor) go;
			cmo.executeScript("window.scrollBy(0,200)", "");
			try {
				go.findElement(By.id("btndispatch")).click();
				break;
			} catch (Exception e) {

				e.printStackTrace();
				continue;
			}
		}
		Thread.sleep(3000);
		ss();
	go.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();

	}
	
	public void Addto_Stock() throws InterruptedException, IOException 
	{
		
		try {
			WebElement open = go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/a"));
			Clickaction(open);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			WebElement open = go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/a"));
			Clickaction(open);
		}
		Thread.sleep(2000);
		try {
			WebElement click = go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/ul/li[5]/a"));
			Clickaction(click);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			WebElement click = go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/ul/li[5]/a"));
			Clickaction(click);
		}
		ss();
		go.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(Healtpost_Requestnumber);
		
		go.findElement(By.xpath("/html/body/form/div[3]/aside[2]/section/div/div[2]/div/table/tbody/tr/td[6]")).click();
		Thread.sleep(3000);
		ss();
		int add=go.findElements(By.xpath("//*[@id='itemdetails1']/tbody/tr/td[5]")).size();
		System.out.print(add);
		Thread.sleep(3000);
		go.findElement(By.xpath("/html/body/form/div[3]/aside[2]/section/div/div[4]/div/div/div[3]/div/button")).click();
		
		for(int q=1;q<=add;q++)
		{
			Thread.sleep(3000);
			go.findElement(By.xpath("/html/body/form/div[3]/aside[2]/section/div/div[2]/div/table/tbody/tr/td[6]")).click();
			Thread.sleep(2000);
		    go.findElement(By.xpath("/html/body/form/div[3]/aside[2]/section/div/div[4]/div/div/div[2]/div/div/table/tbody/tr[1]/td[5]/input")).click();
			Thread.sleep(3000);
			ss();
			go.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			Thread.sleep(2000);
	
			go.findElement(By.xpath("//*[@id='myModal1']/div/div/div[3]/div/button")).click();
			Thread.sleep(2000);
		}
			
	}

	public void odd()
	{
		for(int m=1;m<z;m++)
		{	
		int f=z%2;
		if(f!=0)
		{
			ok.add(m);
			System.out.println(	"ODD VALUES" +ok.add(m));
			
		}
		}
	}
	
	/*public void Ack() throws InterruptedException
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
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[2]/a")).click();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			go.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[2]/a")).click();
		}
		
	      	go.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMORNO);
	      	Thread.sleep(500);
	      	go.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[1]")).click();
	      	go.findElement(By.id("txtackremarks")).sendKeys("Medicine Received Rno Is: "+Healtpost_Requestnumber);
	      	Thread.sleep(500);
	      	go.findElement(By.id("btnadd")).click();
	      	Thread.sleep(3000);
	      	go.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).click();
	}*/
	
	public void Clickaction(WebElement Element)
	{
		Actions action=new Actions(go);
		action.moveToElement(Element).click().build().perform();
	}
	
	public void ss() throws IOException
	{
		File src = ((TakesScreenshot) go).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Jenkins output\\Healthpoststorecms\\" +System.currentTimeMillis()  +".png"));
		
	}		
}