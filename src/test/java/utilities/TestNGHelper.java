package test.java.utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class TestNGHelper extends CommonObjects{
	
	@DataProvider
	public Object[][] dp(Method method) throws IOException{
		Object[][] returnObject = new Object[][]{};
		if (method.getName().equals("registerCustomer"))
			{
				returnObject = new Object[3][1];
				returnObject[0][0] = "U001";
				returnObject[1][0] = "U002";
				returnObject[2][0] = "U003";
			}
		else if (method.getName().equals("updatePhoneNumber"))
		{
			returnObject = new Object[1][1];
			returnObject[0][0] = "U001";
		}
		
		else if (method.getName().equals("performLogin"))
		{
			returnObject = new Object[1][1];
			returnObject[0][0] = "U001";
		}
		
		return returnObject;
	}
	
	@BeforeClass
	public void setup(){
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\testResources\\chromedriver.exe");

        driver = new ChromeDriver();   // webdriver is a interface.      
        driver.manage().window().maximize();  // to maximize the window
        
        driver.get("http://localhost:8765/CRUD_App-0.0.1-SNAPSHOT/register.html");
        // i am a change
        
	}
	
	
	@AfterClass
	public void tearDown() throws IOException{
		 driver.quit(); 
		 Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
	}
}
