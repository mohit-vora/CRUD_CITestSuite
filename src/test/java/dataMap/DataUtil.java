package test.java.dataMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtil {

	private static HashMap<String,ArrayList<String>> testDataMap = new HashMap<String, ArrayList<String>>();
	
	static {
		try {
			readAllData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getData(String dataSetID, String columnName){
		ArrayList<String> columnNames = testDataMap.get("DataID");
		int index=0;
		for(;index<columnNames.size();index++){
			if (columnNames.get(index).equalsIgnoreCase(columnName))
				break;
		}
		return testDataMap.get(dataSetID).get(index);
	}
	
	
	public static void readAllData() throws IOException{
		 FileInputStream dataRead = new FileInputStream(new File(System.getProperty("user.dir")+"\\testResources\\testData.xlsx"));
	        XSSFWorkbook wb = new XSSFWorkbook(dataRead);
	        XSSFSheet sheet = wb.getSheetAt(0);
	        
	        int noOfTestData = sheet.getLastRowNum();	
	     
	        
	        
	        for (int indexOfRows=0;indexOfRows<=noOfTestData;indexOfRows++){
	        	String keyDataId = sheet.getRow(indexOfRows).getCell(0).getStringCellValue();
	        	
	        	ArrayList<String> dataValues = new ArrayList<String>();
	        	
	        	int noOfColumns = sheet.getRow(0).getLastCellNum();
	        	
	        	for (int indexOfCell=1;indexOfCell<noOfColumns;indexOfCell++){
	        		CellType typeOfCell = sheet.getRow(indexOfRows).getCell(indexOfCell).getCellTypeEnum();
	        		
	        		if (typeOfCell==CellType.STRING)
	        			dataValues.add(sheet.getRow(indexOfRows).getCell(indexOfCell).getStringCellValue());
	        		else
	        			dataValues.add(String.valueOf((int)sheet.getRow(indexOfRows).getCell(indexOfCell).getNumericCellValue()));
	        	}
	        	
	        	testDataMap.put(keyDataId, dataValues);
	        		        	
	        }
	        	        
	        wb.close();
	        dataRead.close();
	}
	
	
}