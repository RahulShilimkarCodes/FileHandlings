package dataDriverExcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static Object[][] readExcel(String filePath,String sheetName) throws IOException
	{
		
		FileInputStream fis = new FileInputStream(filePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(0).getLastCellNum();
		
		Object[][] userData = new Object[rows-1][columns];
		//since, we need to skip header row..
		
		for(int row = 1 ; row < rows ; row++)
		{
			XSSFRow currentRow = sheet.getRow(row);
			
			for(int column = 0 ; column < columns ; column++)
			{
				XSSFCell currentColumn = currentRow.getCell(column);
				
				CellType celltype = currentColumn.getCellType();
				
				switch(celltype) {
				case STRING : userData[row-1][column] = currentColumn.getStringCellValue();
								break;
				case NUMERIC : userData[row-1][column] = currentColumn.getNumericCellValue();
								break;
				case BOOLEAN : userData[row-1][column] = currentColumn.getBooleanCellValue();
								break;
				default: break;
				}
			}
		}
		
		workbook.close();
        fis.close();

        return userData;

	}

}
