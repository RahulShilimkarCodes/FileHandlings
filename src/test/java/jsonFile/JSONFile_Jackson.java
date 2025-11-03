package jsonFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONFile_Jackson {
	
	public static void readDataFromJSON(String filePath) throws StreamReadException, DatabindException, IOException 
	{
		File file = new File(filePath);
		
		 // Step 1: Create ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		
		// Step 2: Read JSON file into EmployeesList POJO
		EmployeesListPOJO employeeList = objectMapper.readValue(file, EmployeesListPOJO.class);
		
		//String firstName = employeeList.getEmployeeList().get(0).getFirstName();
		
		 // Step 3: Get the list of employees
		List<EmployeePOJO> employees = employeeList.getEmployees();
		
		 // Step 4: Use for-each loop to print employee details
		for(EmployeePOJO employee : employees)
		{
			System.out.println("First Name :- "+employee.getFirst_name());
			System.out.println("Last Name :- "+employee.getLastName());
			System.out.println("Email :- "+employee.getEmail());
			System.out.println("Gender :- "+employee.getGender());
			System.out.println("Employee :- "+employee.getId());	
			System.out.println("-------------------------------");
		}
		
	}

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		// TODO Auto-generated method stub
		
		
		String filePath = System.getProperty("user.dir")+File.separator+"jsonFolder"+File.separator+"employees.json";
		//Using jackson library..
		readDataFromJSON(filePath);

	}

}
