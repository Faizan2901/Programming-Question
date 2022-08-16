package com.faizan.Question1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDeletedQuestion {
	
	static int count=0;

	public static void main(String[] args) {
	
		
		
		try(BufferedReader br=new BufferedReader(new FileReader("/home/faizansopariwala/Downloads/Problem_Input/1/DeleteFiles.txt")))
		{
			String str;
			
			while((str=br.readLine())!=null)
			{
				
				if(Files.deleteIfExists(Paths.get("/home/faizansopariwala/Downloads/Problem_Input/1/InputFolder/1/"+str)))
				{
					System.out.println("Files Deleted");
					count++;
				}
				else if(Files.deleteIfExists(Paths.get("/home/faizansopariwala/Downloads/Problem_Input/1/InputFolder/2/"+str)))
				{
					System.out.println("Files Deleted");
					count++;
				}
				else if(Files.deleteIfExists(Paths.get("/home/faizansopariwala/Downloads/Problem_Input/1/InputFolder/"+str)))
				{
					System.out.println("Files Deleted");
					count++;
				}
				else
				{
					System.out.println("File is not Found at Particular path");
				}
				
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("\n\nTotal "+count+" Deleted");
		
		
	
		


	}

}
