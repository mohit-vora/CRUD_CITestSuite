package test.java.pageObjects;

import java.io.IOException;
import test.java.applicationMap.LocatorUtil;
import test.java.utilities.CommonObjects;

public class HyperLinks extends CommonObjects{
	
	public static void clickSignUpLink() throws IOException{
		LocatorUtil.setSheetName("HyperLinks");
		driver.findElement(LocatorUtil.get("SignUp_LK")).click();
	}
	
	public static void clickLoginLink() throws IOException{
		LocatorUtil.setSheetName("HyperLinks");
		driver.findElement(LocatorUtil.get("Login_LK")).click();
	}
	
	public static void clickUpdateLink() throws IOException{
		LocatorUtil.setSheetName("HyperLinks");
		driver.findElement(LocatorUtil.get("UpdatePhone_LK")).click();
	}
}
