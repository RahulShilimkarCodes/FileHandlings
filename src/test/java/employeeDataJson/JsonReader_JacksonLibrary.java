package employeeDataJson;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader_JacksonLibrary {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		// TODO Auto-generated method stub
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String filePath= System.getProperty("user.dir")+File.separator+"jsonFolder"+File.separator+"employeeData.json";				
		File jsonFile = new File(filePath);
		
		//Reading json data from the file and mapping it to employeeData class..
		EmployeeDataJson employeeMapper = objectMapper.readValue(jsonFile, EmployeeDataJson.class);
		
		//Accessing the data..
		
		System.out.println("First Name "+employeeMapper.getFirstName());
		System.out.println("Last Name "+employeeMapper.getLastName());

		//for address array...
		List<Address> addresses = employeeMapper.getAddress();
		
		for(Address address : addresses)
		{
			System.out.println("Street "+address.getStreet());
			System.out.println("City "+address.getCity());
			System.out.println("State "+address.getState());

		}

	}

}
