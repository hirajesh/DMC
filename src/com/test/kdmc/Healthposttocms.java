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



public class Healthposttocms {

	WebDriver driver;
	String Healtpost_Requestnumber, CMORNO;
	String stok_qty_in_cms, Requestedqty, issued, medicine;
	String Stock;
	int a, z = 30;
	List<Integer> ok = new ArrayList<Integer>();
	List<Integer> getok = new ArrayList<Integer>();
	boolean sc = false;

	@Test
	public void HealthposttoCms() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.137.1/Multihospital_New/");
		driver.manage().window().maximize();
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
		SIGNOUT();
		Thread.sleep(2000);
		driver.close();

	}

	
	/**
	 * @author Quality Analyst
	 * Health-post Login And Raise Request
	 */	
 public void HealthpostLogin() throws InterruptedException, IOException {

		/*
		 * driver.findElement(By.xpath(
		 * "//*[@id='header-top']/div/div/div[4]/button")).click();
		 * Thread.sleep(500); driver.findElement(By.xpath(
		 * "//*[@id='header-top']/div/div/div[4]/ul/li[1]/a")).click();
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * "//*[@id='form1']/div[6]/div[2]/div/div[4]/label/a")).click();
		 */
		driver.get("http://192.168.137.1/Multihospital_New/HDSplashscreen.aspx");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='form1']/div[6]/div[2]/div/div[4]/label/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("txtusername")).sendKeys("ganesh");
		if (sc) {
			//ss();
		}
		driver.findElement(By.id("txtpassword")).sendKeys("123");
		Thread.sleep(4000);
		//ss();

		WebElement submit = driver.findElement(By.id("btnSubmit"));
		Actions action = new Actions(driver);
		action.moveToElement(submit).click().perform();

	}

	public void HealthpostRequest() throws InterruptedException, IOException {
		try {
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/a")).click();
		} catch (Exception e) {
			e.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/a")).click();
		}

		try {
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/ul/li[1]/a")).click();
		} catch (Exception e) {

			e.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/ul/li[1]/a")).click();
		}

		Thread.sleep(2000);
		Select rtype = new Select(driver.findElement(By.id("drpreqtype")));
		rtype.selectByIndex(1);
		//ss();
		Thread.sleep(2000);
		Select catedriverry = new Select(driver.findElement(By.id("optcategory")));
		catedriverry.selectByIndex(1);
		//ss();
		Thread.sleep(2000);
		Select choosemedicine = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine.selectByIndex(2);
		//ss();
		driver.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
		//ss();
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(500);
		//ss();
		catedriverry.selectByIndex(3);
		Thread.sleep(500);
		choosemedicine.selectByIndex(11);
		driver.findElement(By.id("txttreat")).sendKeys("150");
		Thread.sleep(500);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(500);
		//ss();
		catedriverry.selectByIndex(4);
		Thread.sleep(500);
		choosemedicine.selectByIndex(4);
		driver.findElement(By.id("txttreat")).sendKeys("150");
		Thread.sleep(500);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(500);
		catedriverry.selectByIndex(1);
		Thread.sleep(500);
		choosemedicine.selectByIndex(4);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("150");
		Thread.sleep(500);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(500);

		Select catedriverry1 = new Select(driver.findElement(By.id("optcategory")));
		catedriverry1.selectByIndex(1);
		Thread.sleep(500);
		Select choosemedicine1 = new Select(driver.findElement(By.id("optmedicine")));
		choosemedicine1.selectByIndex(2);

		driver.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(500);
		catedriverry.selectByIndex(12);
		Thread.sleep(500);
		choosemedicine.selectByIndex(2);

		driver.findElement(By.id("txttreat")).sendKeys("200");
		Thread.sleep(500);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(500);
		catedriverry.selectByIndex(3);
		Thread.sleep(500);
		choosemedicine.selectByIndex(2);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("15");
		Thread.sleep(500);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(500);
		catedriverry.selectByIndex(3);
		Thread.sleep(500);
		choosemedicine.selectByIndex(16);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("150");
		Thread.sleep(500);
		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(500);
		catedriverry.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(7);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("250");
		Thread.sleep(500);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(5000);

		Thread.sleep(500);
		catedriverry.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(8);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("100");
		Thread.sleep(500);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(5000);

		Thread.sleep(500);
		catedriverry.selectByIndex(5);
		Thread.sleep(500);
		choosemedicine.selectByIndex(9);
		Thread.sleep(500);
		driver.findElement(By.id("txttreat")).sendKeys("150");
		Thread.sleep(500);
		driver.findElement(By.id("btnadd")).click();
		Thread.sleep(5000);

		Healtpost_Requestnumber = driver.findElement(By.id("txtno")).getAttribute("value").trim();
		CMORNO = Healtpost_Requestnumber.toString().split("\\/")[2].trim();

		try {

			while (true) {
				scroll();
				try {
					//ss();
					driver.findElement(By.id("btnsave")).click();
					break;
				} catch (Exception e) {
					// e.printStackTrace();
					continue;
				}

			}

			Thread.sleep(4000);

			String Alerttextcms = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
			Thread.sleep(2000);
			//ss();
			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			Thread.sleep(2000);

			System.out.println("* Alert Text" + Alerttextcms);
			System.out.println("* HEALTHPOST CMS REQUEST SEND SUCCESSFULLY ");
			System.out.println("* HEALTHPOST CMS REQUEST NUMBER IS " + Healtpost_Requestnumber);

		} catch (Exception e) {
			while (true) {
				scroll();
				try {
					//ss();
					driver.findElement(By.id("btnsave")).click();
					break;
				} catch (Exception e1) {
					e1.printStackTrace();
					continue;
				}

			}
			Thread.sleep(4000);
			//ss();
			String Alerttextcms = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div")).getText();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button")).click();
			Thread.sleep(2000);

			System.out.println("* Alert Text" + Alerttextcms);
			System.out.println("* HEALTHPOST CMS REQUEST SEND SUCCESSFULLY ");
			System.out.println("* HEALTHPOST CMS REQUEST NUMBER IS " + Healtpost_Requestnumber);

		}

	}

	public void scroll() {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,200)", "");
	}

	public void SIGNOUT() throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println(" ");
			System.out.println("* SIGN OUT SUCCESSFULLY");
		} catch (Exception e) {

			// e.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id='pfnamer']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Sign out']")).click();
			Thread.sleep(3000);
			System.out.println(" ");
			System.out.println("* SIGN OUT SUCCESSFULLY");
		}

	}

	public void CMO() throws InterruptedException, IOException {

		Thread.sleep(4000);
		System.out.println("* LOGIN TO CMO ");
		try {
			driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/button")).click();
		}
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li/a")).click();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='header-top']/div/div/div[4]/ul/li/a")).click();
		}
		Thread.sleep(4000);

		// CMO APPROVAL
		// ==================
		try {
			Thread.sleep(3000);
			driver.findElement(By.linkText("CMO")).click();
			driver.findElement(By.id("txtusername")).sendKeys("jana");
			//ss();
			driver.findElement(By.id("txtpassword")).sendKeys("jana123");
			//ss();
			Thread.sleep(4000);
			WebElement submitcmo = driver.findElement(By.id("btnSubmit"));
			Actions Action = new Actions(driver);
			Action.moveToElement(submitcmo).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.sleep(3000);
			driver.get("http://192.168.137.1/Multihospital_New/");
			Thread.sleep(3000);
			driver.findElement(By.linkText("CMO")).click();
			//ss();
			driver.findElement(By.id("txtusername")).sendKeys("jana");
			//ss();
			driver.findElement(By.id("txtpassword")).sendKeys("jana123");
			//ss();
			Thread.sleep(3000);
			WebElement submitcmo = driver.findElement(By.id("btnSubmit"));
			Actions Action = new Actions(driver);
			Action.moveToElement(submitcmo).click().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
		}
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/ul/li[2]/a/span")).click();
			Thread.sleep(2000);
			CMORNO = Healtpost_Requestnumber.toString().split("\\/")[2].trim();
			Thread.sleep(4000);

			System.out.println(" ");
			System.out.println("* SEARCH THE HEALTHPOST REQUEST");

			Select Idept = new Select(driver.findElement(By.id("optsta")));
			Idept.selectByIndex(1);
			Thread.sleep(2000);
			driver.findElement(By.id("btnsearch")).click();
			Thread.sleep(3000);
			//ss();

			for (int Seconds = 0;; Seconds++) {
				boolean flag = false;

				while (true) {
					JavascriptExecutor cmo = (JavascriptExecutor) driver;
					cmo.executeScript("window.scrollBy(0,200)", "");
					try {

						driver.findElement(By.id(CMORNO)).click();
						flag = true;
						break;

					} catch (Exception e) {
						e.printStackTrace();
						if (Seconds <= 60) {
							break;
						}
						continue;

					}
				}
				if (flag) {
					break;
				}
			}

			Thread.sleep(2000);
			//ss();
			Select Approval = new Select(driver.findElement(By.id("optstatus")));
			Approval.selectByIndex(1);
			Thread.sleep(2000);
			//ss();
			driver.findElement(By.id("btnupdate")).click();

			Thread.sleep(2000);
			//ss();
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
			System.out.println(" ");
			System.out.println("* CMO UPDATED THE HEALTHPOST REQUEST SUCCESSFULLY");

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			driver.navigate().refresh();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/a")).click();
			Thread.sleep(200);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[3]/ul/li[2]/a/span")).click();
			CMORNO = Healtpost_Requestnumber.toString().split("\\/")[2].trim();
			Thread.sleep(200);
			System.out.println(CMORNO);
			Thread.sleep(4000);

			System.out.println(" ");
			System.out.println("* SEARCH THE HEALTHPOST REQUEST");

			Select Idept = new Select(driver.findElement(By.id("optsta")));
			Thread.sleep(400);
			Idept.selectByIndex(1);
			Thread.sleep(200);
			driver.findElement(By.id("btnsearch")).click();
			Thread.sleep(2000);
			//ss();
			for (int Seconds = 0;; Seconds++) {
				boolean flag = false;

				while (true) {
					JavascriptExecutor cmo = (JavascriptExecutor) driver;
					cmo.executeScript("window.scrollBy(0,200)", "");
					try {
						driver.findElement(By.id(CMORNO)).click();
						flag = true;
						break;

					} catch (Exception e) {

						if (Seconds <= 120) {
							break;
						}
						continue;

					}
				}
				if (flag) {
					break;
				}
			}

			Thread.sleep(2000);
			//ss();
			Select Approval = new Select(driver.findElement(By.id("optstatus")));
			Thread.sleep(200);
			Approval.selectByIndex(1);
			//ss();
			Thread.sleep(200);
			driver.findElement(By.id("btnupdate")).click();

			Thread.sleep(200);
			//ss();
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();
			System.out.println(" ");
			System.out.println("* CMO UPDATED THE HEALTHPOST REQUEST SUCCESSFULLY");
		}

		// signout();
	}

	public void CMS_LOGIN() throws InterruptedException, IOException {

		try {

			driver.findElement(By.linkText("CMS")).click();
			//ss();
			driver.findElement(By.id("txtusername")).sendKeys("bala");
			//ss();
			driver.findElement(By.id("txtpassword")).sendKeys("123");
			//ss();
			Thread.sleep(4000);

			WebElement submit = driver.findElement(By.id("btnSubmit"));

			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			System.out.println("* LOGIN TO CMS");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e1) {

			e1.printStackTrace();
			driver.navigate().refresh();
			Thread.sleep(3000);

			driver.findElement(By.linkText("CMS")).click();
			//ss();
			driver.findElement(By.id("txtusername")).sendKeys("bala");
			//ss();
			driver.findElement(By.id("txtpassword")).sendKeys("123");
			//ss();
			WebElement submit = driver.findElement(By.id("btnSubmit"));

			Actions action = new Actions(driver);
			action.moveToElement(submit).click().perform();
			System.out.println("* LOGIN TO CMS");

		}

	}

	public void IssueDispensarystoremedicine() throws InterruptedException {
		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/a")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			WebElement exp = driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/a"));
			Clickaction(exp);
			Thread.sleep(2000);

		}

		try {

			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/ul/li[2]/a")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/aside[1]/section/ul/li[1]/ul/li[2]/a")).click();
		}

	}
	



	public void Dispatchfromcms() throws InterruptedException, IOException {

		driver.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(CMORNO);
		Thread.sleep(2000);
		// //ss();
		driver.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[8]")).click();
		Thread.sleep(3000);
		// //ss();
		/*
		 * for (int y = 30; y >= 9; y--) {
		 * 
		 * while (true) {
		 * 
		 * try { driver.findElement(By.xpath("/html/body/div[" + y +
		 * "]/div/div/div[2]/button")).click(); continue; } catch (Exception e)
		 * { //e.printStackTrace(); break; }
		 * 
		 * }
		 * 
		 * }
		 */
		ok = new ArrayList<>();
		for (int m = 1; m <= 30; m++) {
			int f = m % 2;
			if (f != 0) {
				ok.add(m);
				System.out.println(m);

			}
		}

		int col = driver
				.findElements(By
						.xpath("/html/body/div[2]/div/div/aside[2]/form/div[5]/section[2]/div/div[3]/div/div/div[2]/div/div/table/tbody/tr/td[1]"))
				.size();
		System.out.println(col);

		int Stockqtynum = driver
				.findElements(By
						.xpath("/html/body/div[2]/div/div/aside[2]/form/div[5]/section[2]/div/div[3]/div/div/div[2]/div/div/table/tbody/tr/td[2]"))
				.size();

		/*
		 * getok=new ArrayList<>(); for(int t=1;t<=Stockqtynum;t++) {
		 * Stock=driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr["
		 * +t+"]/td[2]")).getText();
		 * 
		 * if(Integer.parseInt(Stock)==0) { getok.add(t);
		 * 
		 * } }
		 */

		for (int y = ok.size(); y > 0; y--) {

			while (true) {

				try {
					driver.findElement(By.xpath("/html/body/div[" + ok.get(y) + "]/div/div/div[2]/button")).click();
					continue;

				} catch (Exception e) {
					// e.printStackTrace();
					break;
				}

			}

		}

		a = 0;

		row: for (int r = 1; r <= col; r++) {
			try {
				stok_qty_in_cms = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]"))
						.getText();
				Requestedqty = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[4]"))
						.getText();
				System.out.println("* Requested Qty :" + Requestedqty);
				System.out.println("* Stock Qty in CMS:" + stok_qty_in_cms);
				System.out.println("=========================================");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				while (true) {
					Thread.sleep(2000);
					JavascriptExecutor scroll = (JavascriptExecutor) driver;
					scroll.executeScript("window.scrollBy(0,200)", "");
					Thread.sleep(2000);
					try {
						stok_qty_in_cms = driver
								.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]")).getText();
						Requestedqty = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[4]"))
								.getText();
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

			
			
			try {
				if (Integer.parseInt(stok_qty_in_cms) < Integer.parseInt(Requestedqty)) {
					a++;
					System.out.println("* Stock Qty in less Than requested qty");
					continue row;

				} 
			} catch (NumberFormatException e)
			{
				stok_qty_in_cms = driver
						.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[3]")).getText();
				Requestedqty = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[4]"))
						.getText();
				Thread.sleep(2000);
				if (Integer.parseInt(stok_qty_in_cms) < Integer.parseInt(Requestedqty)) {
					a++;
					System.out.println("* Stock Qty in less Than requested qty");
					continue row;
			}}
			Select batch = new Select(driver.findElement(By.id("fldvendor" + a)));

			int bat = batch.getOptions().size();

			// System.out.println(bat);

			for (int y = 1; y <= bat - 1; y++) {
				batch.selectByIndex(y);
				String Batchqty = driver.findElement(By.id("txtbthqty" + a)).getAttribute("value");

				// Thread.sleep(500);
				System.out.println("* Stockqty for this batch number:" + Batchqty);

				if (Integer.parseInt(Batchqty) >= Integer.parseInt(Requestedqty)) {
					issued = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[4]"))
							.getText();
					medicine = driver.findElement(By.xpath("//*[@id='itemdetails1']/tbody/tr[" + r + "]/td[2]"))
							.getText();
					//ss();
					break;

				}
				System.out.println("Stock Qty in less Than requested qty for this batch number");

			}
			a++;
		}
		while (true) {
			JavascriptExecutor cmo = (JavascriptExecutor) driver;
			cmo.executeScript("window.scrollBy(0,100)", "");
			try {
				driver.findElement(By.id("btndispatch")).click();
				break;
			} catch (Exception e) {

				e.printStackTrace();
				continue;
			}
		}
		Thread.sleep(3000);
		//ss();
		driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/button")).click();

	}

	/**
	 * @author Quality Analyst
	 * Add to Stock In Health-post
	 */	
 public void Addto_Stock() throws InterruptedException, IOException {

		try {
			WebElement open = driver.findElement(By.xpath("//*[@id='connector]/div[3]/aside[1]/section/ul/li[4]/a"));
			Clickaction(open);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			WebElement open = driver.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/a"));
			Clickaction(open);
		}
		Thread.sleep(2000);
		try {
			WebElement click = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/ul/li[5]/a"));
			Clickaction(click);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			WebElement click = driver
					.findElement(By.xpath("//*[@id='connector']/div[3]/aside[1]/section/ul/li[4]/ul/li[5]/a"));
			Clickaction(click);
		}
		//ss();
		driver.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).sendKeys(Healtpost_Requestnumber);

		driver.findElement(By.xpath("//*[@id='grndetails']/tbody/tr[1]/td[7]")).click();
		Thread.sleep(3000);
		//ss();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='myModal1']/div/div/div[3]/div/button")).click();

		driver.findElement(By.id("seldes")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btchkroqadd")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button")).click();
		Thread.sleep(2000);

	}

	public void odd() {
		for (int m = 1; m < z; m++) {
			int f = z % 2;
			if (f != 0) {
				ok.add(m);
				System.out.println("ODD VALUES" + ok.add(m));

			}
		}
	}

	/*
	 * public void Ack() throws InterruptedException { try {
	 * driver.findElement(By.xpath(
	 * "//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/a")).click(); }
	 * catch (Exception e) {
	 * 
	 * e.printStackTrace(); driver.findElement(By.xpath(
	 * "//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/a")).click(); }
	 * try { driver.findElement(By.xpath(
	 * "//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[2]/a")).
	 * click(); } catch (Exception e) { e.printStackTrace();
	 * driver.findElement(By.xpath(
	 * "//*[@id='connector']/div[3]/aside[1]/section/ul/li[6]/ul/li[2]/a")).
	 * click(); }
	 * 
	 * driver.findElement(By.xpath("//*[@id='grndetails_filter']/label/input")).
	 * sendKeys(CMORNO); Thread.sleep(500);
	 * driver.findElement(By.xpath("//*[@id='grndetails']/tbody/tr/td[1]")).
	 * click(); driver.findElement(By.id("txtackremarks")).
	 * sendKeys("Medicine Received Rno Is: "+Healtpost_Requestnumber);
	 * Thread.sleep(500); driver.findElement(By.id("btnadd")).click();
	 * Thread.sleep(3000);
	 * driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/button")).
	 * click(); }
	 */

	public void Clickaction(WebElement Element) {
		Actions action = new Actions(driver);
		action.moveToElement(Element).click().build().perform();
	}

	public void ss() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("E:\\Jenkins output\\Healthpoststorecms\\" + System.currentTimeMillis() + ".png"));

	}
}