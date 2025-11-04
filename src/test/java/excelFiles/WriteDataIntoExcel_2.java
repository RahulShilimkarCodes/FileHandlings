package excelFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcel_2 {
	
	// Workbook -> sheet -> Rows -> cell/columns  - creation of the file..
	public static void writeDataInExcel(String filePath) throws IOException
	{
		
		//Data creation
				Object[][] employeesData = {
						{"EmpName","EmpID","Role"},
						{"John", 28, "Developer"},
					    {"Sara", 32, "Tester"},
					    {"Alex", 25, "Manager"}
				};
				
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet =workbook.createSheet();
		
		int rowCount = 0;
		
		
		for(Object[] employee : employeesData)
		{
			XSSFRow row = sheet.createRow(rowCount++);
			
			int columCount = 0;
			for(Object emp : employee)
			{
				XSSFCell cell = row.createCell(columCount++);
				
				if(emp instanceof String)
				{
					cell.setCellValue((String)emp);
				}
				if(emp instanceof Integer)
				{
					cell.setCellValue((Integer)emp);
				}
				if(emp instanceof Boolean)
				{
					cell.setCellValue((Boolean)emp);
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
