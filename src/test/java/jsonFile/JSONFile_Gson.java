package jsonFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;

public class JSONFile_Gson {
	
	public static void readJSONDataUsingGSON(String filePath) throws FileNotFoundException
	{
		FileReader fileReader = new FileReader(filePath);
		
		Gson gson = new Gson();
		
		EmployeesListPOJO employeesList = gson.fromJson(fileReader,EmployeesListPOJO.class);
		
		List<EmployeePOJO> employees = employeesList.getEmployees();
		
		//accessing the data.
		
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

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String filePath = System.getProperty("user.dir")+File.separator+"jsonFolder"+File.separator+"employees.json";
		
		//Using gson library..
		readJSONDataUsingGSON(filePath);

	}

}
