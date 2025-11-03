package textFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFileActions {
	
	//creating a file...
	public static void createFile(String filePath) throws IOException
	{
		File file = new File(filePath);			//creates a new File Object
		
		 boolean isFileCreated = file.createNewFile();		//create's new file if not exists..
		
		if(isFileCreated)
		{
			System.out.println("File is created");
			System.out.println("File name is :- "+file.getName());
		}
		else
		{
			System.out.println("File already exists,cannot be created");
		}
	}
	
	//write data into the file..
	public static void writeDataInFile(String filePath) throws IOException
	{
		FileWriter mywriter = new FileWriter(filePath);			//this always overwrite the file, will delete all inner content and start fresh
		
		mywriter.write("welcome to file....");
		
		mywriter.close();		// always close writer to flush data
	}
	
	//enter new data into the file...
	public static void insertNewDataInFile(String filePath,String data) throws IOException
	{
		FileWriter existingFile = new FileWriter(filePath,true);	//updates the existing file...
	
		existingFile.write(System.lineSeparator());		//adds new line
		
		existingFile.write(data);
		
		existingFile.close();
	}
	
	
	
	//reading the data from file
	public static void readFileData(String filePath) throws FileNotFoundException
	{
		File file = new File(filePath);
		
		if(file.exists())
		{
			Scanner fileReader = new Scanner(file);
			
			while(fileReader.hasNext())
			{
				String data = fileReader.nextLine();
				System.out.println(data);
			}
			fileReader.close();
		}else
		{
			System.out.println("No file present to read the data from");
		}
	}
	
	//rename the file...
		public static void renameFile(String olderFilePath , String newFilePath)
		{
			File olderFile = new File(olderFilePath);
			
			File updatedFile = new File(newFilePath);
			
			if(olderFile.exists())
			{
				boolean fileUpdated = olderFile.renameTo(updatedFile);
				
				if(fileUpdated)
				{
					System.out.println("File name is updated to :- " + updatedFile.getName());
				}
				else
				{
					System.out.println("File name is not updated..");
				}
			}
			else
			{
				System.out.println("No such file exists...please check the path");
			}
			
		}
		
		//delete the file
		public static void deleteFile(String filePath)
		{
			File file = new File(filePath);
			
			if(file.exists())
			{
				boolean fileDeleted = file.delete();
				
				if(fileDeleted)
				{
					System.out.println("File is deleted " + file.getName());
				}
				else
				{
					System.out.println("File not deleted....");
				}
			}
			else
			{
				System.out.println("No such file exists...please check the path");
			}
		
		}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String filePath = System.getProperty("user.dir")+File.separator+"folders"+File.separator+"demoFile.txt";
		
		createFile(filePath);
		
		writeDataInFile(filePath);
		
		insertNewDataInFile(filePath,"adding the data in the file after new line 123");
		
		readFileData(filePath);
		
		String updateFilePath = System.getProperty("user.dir")+File.separator+"folders"+File.separator+"updatedDemoFile.txt";
		
		renameFile(filePath,updateFilePath);
		
		deleteFile(updateFilePath);
	}

}
