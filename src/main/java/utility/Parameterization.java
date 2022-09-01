package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization {

	public static String getData (String sheetname,int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream ("C:\\Users\\dhakn\\eclipse-workspace\\KiteZerodha\\src\\test\\resources\\TestData.xlsx");

	
		String data = WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	
	
		return data;
	
	}
	
	public static double getNumericdata(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("C:\\\\Users\\\\dhakn\\\\eclipse-workspace\\\\KiteZerodha\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
		
		double d =WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
		
		return d;
	}


}















