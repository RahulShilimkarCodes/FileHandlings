package excelFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcel {
	
	// Workbook -> sheet -> Rows -> cell/columns  - creation of the file..
	public static void writeDataInExcel(String filePath) throws IOException
	{
		
		//Data creation
				Object[][] employeeData = {
						{"EmpName","EmpID","Role"},
						{"John", 28, "Developer"},
					    {"Sara", 32, "Tester"},
					    {"Alex", 25, "Manager"}
				};
				
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet =workbook.createSheet();
		
		//using normal for loop..
		int rows = employeeData.length;
		int columns = employeeData[0].length;
		
//		System.out.println("Number of rows :- " + rows);
//		System.out.println("Number of columns :- " + columns);
		
		for(int i = 0 ; i < rows ; i++)
		{
			XSSFRow row = sheet.createRow(i);
			
			for(int j = 0 ; j < columns ; j++)
			{
				XSSFCell cell = row.createCell(j);
				
				Object cellValue = employeeData[i][j];
				
				if(cellValue instanceof String)
				{
					cell.setCellValue((String)cellValue);
				}
				
				if(cellValue instanceof Integer)
				{
					cell.setCellValue((Integer)cellValue);
				}
				
				if(cellValue instanceof Boolean)
				{
					cell.setCellValue((Boolean)cellValue);
				}
				
			}
		}
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		workbook.write(fos);
		
		fos.close();
		
	}		
				
		public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
			String filePath = System.getProperty("user.dir")+File.separator + "excelFolder"+File.separator+"EmployeeList.xlsx";
			
			writeDataInExcel(filePath);

	}

}
