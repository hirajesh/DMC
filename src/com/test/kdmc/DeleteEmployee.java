package com.test.kdmc;

import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DeleteEmployee {

	Statement  Stme;
	
	        String Employee1 = "delete from  dbo.mstr_Employee where EmpId='TIM1'";
			String Employee2 = "delete from  dbo.mstr_Employee where EmpId='TIM2'";
			String Employee3 = "delete from  dbo.mstr_Employee where EmpId='TIM3'";
			String Employee4 = "delete from  dbo.mstr_Employee where EmpId='TIM4'";
			String Employee5 = "delete from  dbo.mstr_Employee where EmpId='TIM5'";
			String Employee6 = "delete from  dbo.mstr_Employee where EmpId='TIM6'";
			String Employee7 = "delete from  dbo.mstr_Employee where EmpId='TIM7'";
			String Employee8 = "delete from  dbo.mstr_Employee where EmpId='TIM8'";
			String Employee9 = "delete from  dbo.mstr_Employee where EmpId='TIM9'";
			String Employee10 = "delete from  dbo.mstr_Employee where EmpId='TIM10'";
			String Employee11 = "delete from  dbo.mstr_Employee where EmpId='TIM11'";
			String Employee12 = "delete from  dbo.mstr_Employee where EmpId='TIM12'";
			String Employee13 = "delete from  dbo.mstr_Employee where EmpId='TIM13'";
			String Employee14 = "delete from  dbo.mstr_Employee where EmpId='TIM14'";
			String Employee15 = "delete from  dbo.mstr_Employee where EmpId='TIM15'";

	
	
    WebDriver	driver;   
  @Test
public void deletehospital() throws SQLException
	{
	  
		System.out.println("Verify Employee Are Deleted Suceccessfully Or Not");
	 // driver=new FirefoxDriver();
		SQLServerDataSource del=new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		Stme=del.getConnection().createStatement();
	
		try {
			Stme.executeQuery(Employee1+Employee2+Employee3+Employee4+Employee5+Employee6+Employee7+Employee8+Employee9+Employee10+Employee11+Employee12+Employee13+Employee14+Employee15);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		  //driver.close();
	}

	   
}



