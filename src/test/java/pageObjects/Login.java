package test.java.pageObjects;

import java.io.IOException;
import test.java.applicationMap.LocatorUtil;
import test.java.dataMap.DataUtil;
import test.java.utilities.CommonObjects;

public class Login extends CommonObjects{

	public static String populateValues(String dataId) throws IOException{
		LocatorUtil.setSheetName("Login");
		
		String message = null;
		
		driver.findElement(LocatorUtil.get("MailId_TB")).sendKeys(DataUtil.getData(dataId, "username"));
		driver.findElement(LocatorUtil.get("Password_TB")).sendKeys(DataUtil.getData(dataId, "password"));
		driver.findElement(LocatorUtil.get("login_BT")).click();

		message = driver.findElement(LocatorUtil.get("message_tx")).getText();
		
		return message;
	}
}
