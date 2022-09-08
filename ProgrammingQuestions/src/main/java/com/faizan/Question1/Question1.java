package com.faizan.Question1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Question1 {

	static public void checkFile(File[] file,String str )
	{
		
			for(int j=0;j<file.length;j++)
			{
				
				if(file[j].isDirectory())
				{
					File[] fl1=file[j].listFiles();
					checkFile(fl1, str);
				}else {
					if(file[j].getName().equals(str))
					{
						if(file[j].delete())
						{
							System.out.println(file[j].getName()+" deleted!");
						}
					}
				}
			}
			
		
		
	}
	
	public static void main(String[] args) {
		
		
		File files = new File("/home/faizansopariwala/Downloads/Problem_Input/1/InputFolder");

		
		File[] fl=files.listFiles();
		
		try(BufferedReader br=new BufferedReader(new FileReader("/home/faizansopariwala/Downloads/Problem_Input/1/DeleteFiles.txt")))
		{
			String str;
			while((str=br.readLine())!=null)
			{
				checkFile(fl,str);
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		

	}

}
