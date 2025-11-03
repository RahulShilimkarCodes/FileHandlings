package propertiesFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class PropertiesFile {
	
	//writing data into the properties file..
	public static void enteringDataInPropertiesFile(String propertyFilePath) throws IOException
	{
		Properties prop = new Properties();
		//Properties file contains data in key-value pair..
		
		prop.setProperty("name", "doraemon");
		prop.setProperty("location", "Japan");
		prop.setProperty("food", "Dora Cakes");
		
		FileOutputStream fos = new FileOutputStream(propertyFilePath);
		//FileOutputStream - write data in the file..
		
		prop.store(fos, "adding the initial data about doraemon");
		
		fos.close();
		
		System.out.println("Properties value's have been added in the file "+propertyFilePath);
	
	}
	
	//Reading data from the properties file..
	public static void readingDataFromPropertiesFile(String propertyFilePath, String keyToFind) throws IOException
	{
		Properties prop = new Properties();
		
		File file = new File(propertyFilePath);
		
		FileInputStream fis = new FileInputStream(file);
		//FileInputStream - read data from the file..
		
		prop.load(fis);
		
		String value = prop.getProperty(keyToFind);
		
		System.out.println("Value for Key "+keyToFind+" is :- "+value);
		
		fis.close();
		
	}
	
	// Reading all the keys present in the properties file..
	public static void readingKeysFromPropertiesFile(String propertyFilePath) throws IOException {
		Properties prop = new Properties();

		File file = new File(propertyFilePath);

		FileInputStream fis = new FileInputStream(file);
		// FileInputStream - read data from the file..

		prop.load(fis);

		Set<String> keysPresent = prop.stringPropertyNames();		//gives back all the keys in the file
		
		for(String key : keysPresent)
		{
			System.out.println(key);
		}
		
//		//Method-2:-
//		
//		Set<Object> keysPresent = prop.keySet();		//gives back all the keys in the file
//		
//		for(Object key : keysPresent)
//		{
//			System.out.println(key);
//		}
		
		fis.close();

	}
	
	// Reading all the values present in the properties file..
	public static void readingValuesFromPropertiesFile(String propertyFilePath) throws IOException {
		Properties prop = new Properties();

		File file = new File(propertyFilePath);

		FileInputStream fis = new FileInputStream(file);
		// FileInputStream - read data from the file..

		prop.load(fis);

		Collection<Object> keysPresent = prop.values(); // gives back all the keys in the file

		for (Object key : keysPresent) {
			System.out.println(key);
		}
		
		fis.close();

	}
	
	//getting both key and value from the properties file..
	public static void gettingKeyAndValue(String filePath) throws IOException
	{
		Properties prop = new Properties();
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		
		Set<String> keys = prop.stringPropertyNames();
		
		for(String key : keys)
		{
			System.out.println(key+"    :-  "+prop.getProperty(key));
			
		}
		
		fis.close();
		
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String propertyFilePath = System.getProperty("user.dir")+File.separator+"propertiesFolder"+File.separator+"doraemon.prop";
		
		enteringDataInPropertiesFile(propertyFilePath);
		
		readingDataFromPropertiesFile(propertyFilePath , "name");
		
		readingKeysFromPropertiesFile(propertyFilePath);
		
		readingValuesFromPropertiesFile(propertyFilePath);
		
		gettingKeyAndValue(propertyFilePath);
	}

}
