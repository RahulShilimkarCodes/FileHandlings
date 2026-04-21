package excelFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData_ArrayList {
	
	public static void writeDataFromArrayList(String filePath) throws IOException
	{
		
		List<Object[]> employeeList = new ArrayList<Object[]>();
		employeeList.add(new Object[] {"empID","empName","Salary"});
		employeeList.add(new Object[] {"S-125","Rahul",3201});
		employeeList.add(new Object[] {"A-568","Virat",3658});
		employeeList.add(new Object[] {"F-989","Rohit",2301});
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Employees");
		
		int rowNumber=0;
		
		for(Object[] employee : employeeList)
		{
			XSSFRow row = sheet.createRow(rowNumber++);
			int column=0;
			for(Object emp : employee)
			{
				XSSFCell cell = row.createCell(column++);
				
				if(emp instanceof String)
				{
					cell.setCellValue((String)emp);
				}
				else if(emp instanceof Boolean)
				{
					cell.setCellValue((Boolean)emp);
				}
				else if(emp instanceof Integer)
				{
					cell.setCellValue((Integer)emp);
				}
				else if(emp instanceof Double)
				{
				    cell.setCellValue((Double) emp);
				}
			}
		}
		
		FileOutputStream fileOutputStream = new FileOutputStream(filePath);
		workbook.write(fileOutputStream);
		fileOutputStream.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String filePath = System.getProperty("user.dir")+File.separator+"excelFolder"+File.separator+"Employee_arrayList.xlsx";
		writeDataFromArrayList(filePath);
	}
}
