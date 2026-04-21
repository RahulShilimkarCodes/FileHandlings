package employeeDataJson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;

public class JsonReader_GsonLibrary {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String filePath= System.getProperty("user.dir")+File.separator+"jsonFolder"+File.separator+"employeeData.json";				
		FileReader jsonFile = new FileReader(filePath);
		
		Gson gson = new Gson();
		
		EmployeeDataJson employeeData = gson.fromJson(jsonFile, EmployeeDataJson.class);

		System.out.println("First Name "+employeeData.getFirstName());
		System.out.println("Last Name "+employeeData.getLastName());

		//for address array...
		List<Address> addresses = employeeData.getAddress();
		
		for(Address address : addresses)
		{
			System.out.println("Street "+address.getStreet());
			System.out.println("City "+address.getCity());
			System.out.println("State "+address.getState());

		}

	}

}
