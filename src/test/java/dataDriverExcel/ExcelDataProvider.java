package dataDriverExcel;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider(name="excelDataProvider")
	public Object[][] excelDataProvider() throws IOException
	{
		String filePath = System.getProperty("user.dir")+ File.separator + "excelFolder"+File.separator+"LoginData.xlsx";
		String sheetName = "LoginData";
		
		return ExcelUtils.readExcel(filePath, sheetName);
	}

}
