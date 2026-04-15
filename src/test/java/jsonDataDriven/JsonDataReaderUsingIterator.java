package jsonDataDriven;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReaderUsingIterator {
	
	public static Iterator<Object[]> readJsonData(String filePath) throws StreamReadException, DatabindException, IOException
	{
		
		File file = new File(filePath);
		
		ObjectMapper om = new ObjectMapper();
		
		UsersPojo users = om.readValue(file, UsersPojo.class);
		
		List<Object[]> userList = new ArrayList<>();
		
		for(UserPojo user : users.getUsers())
		{
			userList.add(new Object[] {user});
		}
		
		return userList.iterator();
		
	}

}
