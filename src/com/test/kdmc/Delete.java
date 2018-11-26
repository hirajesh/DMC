package com.test.kdmc;

import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Delete {

	Statement  Stme;
	String Hospital = "delete from Mstr_MultipleHospital where Hospital_Name='BMRHOSPITAL'";
	String Healthpost = "delete from Mstr_MultipleHospital where Hospital_Name='BMRHEALTHPOST'";
	String Dispensary = "delete from Mstr_MultipleHospital where Hospital_Name='BMRDISPENSARY'";
	String Hospitaladmin = "delete from mstr_Employee where Name='BINNUKUMAR'";
	String Healthpostadmin = "delete from mstr_Employee where Name='VICKY'";
	String Dispensaryadmin = "delete from mstr_Employee where Name='BHUVANESH'";
	String Delhealthpostname = "delete from Mstr_HealthpostReg where HealthpostName='BMRHEALTHPOST'";
	String Deldispensaryname = "delete from Mstr_DispensaryReg where Dispensaryname='BMRDISPENSARY'";
    WebDriver	driver;   
  @Test
public void deletehospital() throws SQLException
	{
	  
		System.out.println("Verify Hospital/Healthpost/Dispensary Are Deleted Suceccessfully Or Not");
	 // driver=new FirefoxDriver();
		SQLServerDataSource del=new SQLServerDataSource();
		del.setUser("sa");
		del.setPassword("Disp123");
		del.setServerName("192.168.137.1");
		del.setDatabaseName("Multihospital_Testing2017");
		del.getConnection();
		Stme=del.getConnection().createStatement();
	
		try {
			Stme.executeQuery(Hospital+Healthpost+Dispensary+Hospitaladmin+Healthpostadmin+Dispensaryadmin+Delhealthpostname+Deldispensaryname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		  //driver.close();
	}

	   
}



