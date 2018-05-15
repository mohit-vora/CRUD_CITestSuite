package test.java.testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import test.java.pageObjects.HyperLinks;
import test.java.pageObjects.Login;
import test.java.pageObjects.Register;
import test.java.pageObjects.Update;
import test.java.utilities.TestNGHelper;

public class newTestCase extends TestNGHelper{
	
	@Test(dataProvider="dp",priority=0)
	public void registerCustomer(String dataSetId) throws InterruptedException, IOException{
		HyperLinks.clickSignUpLink();
		Register.populateValues(dataSetId);
	}
	
	@Test(dataProvider="dp",priority=2)
	public void updatePhoneNumber(String dataSetId) throws InterruptedException, IOException{
		HyperLinks.clickUpdateLink();
		Update.populateValues(dataSetId);
	}
	
	@Test(dataProvider="dp",priority=1)
	public void performLogin(String dataSetId) throws InterruptedException, IOException{
		HyperLinks.clickLoginLink();
		Login.populateValues(dataSetId);
	}
}