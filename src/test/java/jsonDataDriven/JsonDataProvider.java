package jsonDataDriven;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public class JsonDataProvider {
	
	@DataProvider(name="jsonDataProvider")
	public static Object[][] jsonLoginData() throws StreamReadException, DatabindException, IOException
	{
		String filePath = System.getProperty("user.dir")+File.separator+"jsonFolder"+File.separator+"logindata.json";
		
		return JsonDataReader.readJson(filePath);
	}
	
	@DataProvider(name="jsonIterDataProvider")
	public static Iterator<Object[]> jsonLoginIteratorData() throws StreamReadException, DatabindException, IOException
	{
		String filePath = System.getProperty("user.dir")+File.separator+"jsonFolder"+File.separator+"logindata.json";
		
		return JsonDataReaderUsingIterator.readJsonData(filePath);
	}

}
