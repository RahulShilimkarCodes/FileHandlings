package excelFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public static void readExcelData(String filePath) throws IOException
	{
		
		//If working with .xlsx file - we use XSSFWorkbook,etc. classes...
		//If working with .xls files - we use HSSFWorkbook,etc. classes..		(Older format of excel file..)
		//Workbook -> Sheet -> Row -> Cell..
		
		FileInputStream fis =  new FileInputStream(filePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Population Data");			//sheet using name..
		//XSSFSheet sheet = workbook.getSheetAt(0);		- this will get the sheet at index 0...
		
		
		//getting total rows and columns..
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(0).getLastCellNum();
		
		for(int row = 0 ; row < totalRows ; row++)
		{
			XSSFRow currentRow = sheet.getRow(row);			//getting the rows..0,1,...
			
			for(int cells = 0 ; cells < totalCells ; cells++)
			{
				XSSFCell currentCell = currentRow.getCell(cells);
				
				CellType cellType = currentCell.getCellType();
				
				switch(cellType)
				{
				case STRING : 
					System.out.print(currentCell.getStringCellValue()+"\t");
					break;
				case NUMERIC : 
					System.out.print(currentCell.getNumericCellValue()+"\t");
					break;
				case BOOLEAN : 
					System.out.print(currentCell.getBooleanCellValue()+"\t");
					break;
				default : 
					System.out.print("\t");
					break;
				}
			}
			
			System.out.println();
		}
		
		workbook.close();
        fis.close();
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String filePath = System.getProperty("user.dir")+File.separator + "excelFolder"+File.separator+"CountryList.xlsx";
		
		readExcelData(filePath);

	}

}
