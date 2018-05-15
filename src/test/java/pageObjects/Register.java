package test.java.pageObjects;

import java.io.IOException;
import test.java.applicationMap.LocatorUtil;
import test.java.dataMap.DataUtil;
import test.java.utilities.CommonObjects;

public class Register extends CommonObjects{

	public static String populateValues(String dataId) throws IOException{
		LocatorUtil.setSheetName("Register");
		
		String message = null;
		
		driver.findElement(LocatorUtil.get("Username_TB")).sendKeys(DataUtil.getData(dataId, "username"));
		driver.findElement(LocatorUtil.get("Password_TB")).sendKeys(DataUtil.getData(dataId, "password"));
		driver.findElement(LocatorUtil.get("Email_TB")).sendKeys(DataUtil.getData(dataId, "email"));
		driver.findElement(LocatorUtil.get("Phone_TB")).sendKeys(DataUtil.getData(dataId, "phone"));
		driver.findElement(LocatorUtil.get("PermanentAddress_TB")).sendKeys(DataUtil.getData(dataId, "permanentaddress"));
		driver.findElement(LocatorUtil.get("DepositAmount_TB")).sendKeys(DataUtil.getData(dataId, "depositamount"));
		driver.findElement(LocatorUtil.get("Register_BT")).click();

		message = driver.findElement(LocatorUtil.get("message_tx")).getText();
		
		return message;
	}
}
