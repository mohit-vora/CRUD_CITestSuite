package test.java.applicationMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class LocatorUtil {

	private static Map<String, HashMap<String, By>> locatorMap = new HashMap<String,HashMap<String, By>>();
	
	static {
		try {
			readAllLocators();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String sheetName = null; 
	
	public static void setSheetName(String name){
		sheetName=name;
	}
	
	public static void readAllLocators() throws IOException{
				
		FileInputStream locatorFile = new FileInputStream(new File(System.getProperty("user.dir")+"\\testResources\\ApplicationMap.xlsx"));
	    XSSFWorkbook wb1 = new XSSFWorkbook(locatorFile);
	    int noOfSheets = wb1.getNumberOfSheets();

	    for (int indexOfSheet=0;indexOfSheet<noOfSheets;indexOfSheet++)
	    {
	    
	    	HashMap<String, By> sheetSpecificMap = new HashMap<>();
		    XSSFSheet sheet2 = wb1.getSheetAt(indexOfSheet);
		    int noOfRows = sheet2.getLastRowNum();
		    
		    
		    for (int rowIndex=1;rowIndex<=noOfRows;rowIndex++){
		      	String eName = sheet2.getRow(rowIndex).getCell(0).getStringCellValue().toLowerCase();
		      	String locatorType = sheet2.getRow(rowIndex).getCell(1).getStringCellValue().toLowerCase();
			        
			    By by = null;
			        
			    switch (locatorType){
			        
			      	case "xpath":
			       		by = By.xpath(sheet2.getRow(rowIndex).getCell(2).getStringCellValue());
			       		break;
			        	
			       	case "id":
			       		by = By.id(sheet2.getRow(rowIndex).getCell(2).getStringCellValue());
			       		break;
			        		
			       	case "name":
			       		by = By.name(sheet2.getRow(rowIndex).getCell(2).getStringCellValue());
			       		break;
			        		
			       	case "css":
			       		by = By.cssSelector(sheet2.getRow(rowIndex).getCell(2).getStringCellValue());
			       		break;
			        		
			       	case "linktext":
			       		by = By.linkText(sheet2.getRow(rowIndex).getCell(2).getStringCellValue());
			       		break;
			        		
			       	case "partiallinktext":
			       		by = By.partialLinkText(sheet2.getRow(rowIndex).getCell(2).getStringCellValue());
			       		break;
			        }
			    			    
			    	sheetSpecificMap.put(eName, by);
		        }
		    	locatorMap.put(sheet2.getSheetName().toLowerCase(), sheetSpecificMap);
	    	}
	    wb1.close();
	    locatorFile.close();
	}
	
	
	public static By get(String elementName) throws IOException{
		return locatorMap.get(sheetName.toLowerCase()).get(elementName.toLowerCase());
	}
}
