package textFiles;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FolderActions {
	
	//creating a folder
	public static void creatingNewFolder(String folderPath)
	{
		File folder = new File(folderPath);		//folder location
		
		if(!folder.exists())		//goes inside if folder does not exists..
		{
			folder.mkdirs();		//if no parent folder exist,use this
			
			//folder.mkdir();		- if parent folder exist use this
			System.out.println("Folder is created at path :- "+folderPath);
		}
	}
	
	//check if folder exists
	public static void isFolderExists(String folderPath)
	{
		File folder = new File(folderPath);
		
		if(folder.exists())
		{
			System.out.println("Folder already exists");
		}else
		{
			System.out.println("Folder does not exists");
		}
		
	}
	
	//Rename a folder
	public static void renameFolder(String oldFolderPath,String newFolderPath)
	{
		File folder = new File(oldFolderPath);
		
		File newFolder = new File(newFolderPath);
		
		if(folder.exists())
		{
			boolean folderUpdated = folder.renameTo(newFolder);
			
			if(folderUpdated)
			{
				System.out.println("Folder name is updated, new Name :- "+newFolderPath);
			}else
			{
				System.out.println("Folder name is not updated at given path:- "+newFolderPath);
			}			
		}
		else
		{
			System.out.println("Folder does not exists at old path :- "+oldFolderPath);
		}
	}
	
	//Delete folder
	public static void deleteFolder(String folderPath)
	{
		File folderToBeDeleted = new File(folderPath);
		
		if(folderToBeDeleted.exists())
		{
			//folderToBeDeleted.delete();
			//this deletes folder, only if folder is empty..
			//hence, we need to delete all files first in folder..
			
			File[] allFiles = folderToBeDeleted.listFiles();
			for(File file : allFiles)
			{
				file.delete();
			}
			
			//All the files are deleted, now we can delete folder..
			
			boolean folderDeleted = folderToBeDeleted.delete();;
			//gives true/false
			
			if(folderDeleted)		
			{
				System.out.println("Folder deleted");
			}
			else
			{
				System.out.println("Unable to delete Folder");
			}
		}
		else
		{
			System.out.println("Folder does not exist to be deleted");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String folderPath = System.getProperty("user.dir")+"\\folders\\demoFolder";
		
		//String folderPath = System.getProperty("user.dir")+File.separator + "folders"+File.separator+"demoFolder";
		//Note:- above works well on all machines..
		
		
		//updated folder path which can be give
		
//		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//		String timeFolderPath = System.getProperty("user.dir")+File.separator+"folders"+File.separator+timeStamp;
//		System.out.println("TimeStampFilePath :- "+timeFolderPath);

        
		isFolderExists(folderPath);
		
		creatingNewFolder(folderPath);
		
		String updatedFolderPath = System.getProperty("user.dir")+File.separator+"folders"+File.separator+"demoUpdatedFolder";
		renameFolder(folderPath, updatedFolderPath);
		
		deleteFolder(updatedFolderPath);
		

	}

}
