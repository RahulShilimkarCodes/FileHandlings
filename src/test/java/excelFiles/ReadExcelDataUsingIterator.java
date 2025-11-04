package excelFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataUsingIterator {
	
	public static void readExcelData(String filePath) throws IOException
	{
		
		FileInputStream fis =  new FileInputStream(filePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Population Data");			//sheet using index..
		//XSSFSheet sheet = workbook.getSheetAt(0);		- this will get the sheet at index 0...
		
		
		Iterator<Row> rowIter = sheet.iterator();		//return all the rows		
		
		while(rowIter.hasNext())
		{
			XSSFRow currentRow = (XSSFRow) rowIter.next();
			
			Iterator<Cell> cellIter = currentRow.cellIterator();		//iterate all the cells in the row.
			
			while(cellIter.hasNext())
			{
				XSSFCell currentCell = (XSSFCell) cellIter.next();
				
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
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String filePath = System.getProperty("user.dir")+File.separator + "excelFolder"+File.separator+"CountryList.xlsx";
		
		readExcelData(filePath);

	}

}
