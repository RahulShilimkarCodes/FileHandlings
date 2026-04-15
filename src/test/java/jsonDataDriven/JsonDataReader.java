package jsonDataDriven;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {
	
	public static Object[][] readJson(String filePath) throws StreamReadException, DatabindException, IOException
	{
		File file = new File(filePath);
		
		// Create ObjectMapper instance
		ObjectMapper om = new ObjectMapper();
		
		 // Read the JSON file
		UsersPojo userList = om.readValue(file, UsersPojo.class);
		
		List<UserPojo> users = userList.getUsers();
		
		int totalUsers = users.size();
		
		Object[][] userData = new Object[totalUsers][2];
		
		int rowIndex = 0;
		
		for(UserPojo user : users)
		{
			userData[rowIndex][0] = user.getUserName();
			userData[rowIndex][1] = user.getPassword();
			
			rowIndex++;
		}
		
		return userData;
	}

}
