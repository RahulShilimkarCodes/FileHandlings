package csvFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVFile {
	
	//creating a csv file(comma seperated file)
	public static void createCSVFile(String filePath) throws IOException
	{
		FileWriter writer = new FileWriter(filePath); 		//creating a CSV file..
		
		
		
		writer.append("Name,Age,Email	\n");		//adding header in the file..
		
		writer.append("John,26,john@doe.com	\n");		//entering the data in the file..\n -> new line
		writer.append("Mark,32,mark@doe.com	\n");
		
		writer.close();
		
		System.out.println("File created and added the data");
	}
	
	//reading using Scanner class
	public static void readCSVFileData(String filePath) throws FileNotFoundException 
	{
		File file = new File(filePath);
		
		Scanner sc = new Scanner(file); 		//read data from file..
		
		sc.useDelimiter(",");					//since, csv has delimiter as ,...
		
		while(sc.hasNext())
		{
			System.out.println(sc.nextLine());
			
			//System.out.print(sc.next()+"\t");			//to get data in linear and correct format..
		}
		
		sc.close();
	}
	
	public static void readCSVFileUsingJavaSplit(String filePath) throws IOException
	{
		FileReader fileReader = new FileReader(filePath);
		
		BufferedReader reader = new BufferedReader(fileReader);
		
		String line;
		
		while((line=reader.readLine())!=null)
		{
			String rowData[] = line.split(",");
			
			for(String data : rowData)
			{
				System.out.print(data+"\t");
			}
			System.out.println();
		}
		
		reader.close();
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String filePath = System.getProperty("user.dir")+File.separator+"csvFolder"+File.separator+"demoFile.csv";
		
		createCSVFile(filePath);
		
		readCSVFileData(filePath);
		
		readCSVFileUsingJavaSplit(filePath);

	}

}
