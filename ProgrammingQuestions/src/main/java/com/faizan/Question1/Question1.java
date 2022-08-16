package com.faizan.Question1;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Question1 {

	static public void checkFile(File[] file,ArrayList<String> al )
	{
		for(int i=0;i<al.size();i++)
		{
			for(int j=0;j<file.length;j++)
			{
				
				if(file[j].isDirectory())
				{
					File[] fl1=file[j].listFiles();
					checkFile(fl1, al);
				}else {
					if(file[j].getName().equals(al.get(i)))
					{
						if(file[j].delete())
						{
							System.out.println(file[j].getName()+" deleted!");
						}
					}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File files = new File("/home/faizansopariwala/Downloads/Problem_Input/1/InputFolder");

		ArrayList<String> al=new ArrayList<>();
		
		try(BufferedReader br=new BufferedReader(new FileReader("/home/faizansopariwala/Downloads/Problem_Input/1/DeleteFiles.txt")))
		{
			String str;
			while((str=br.readLine())!=null)
			{
				al.add(str);
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		File[] fl=files.listFiles();
		checkFile(fl,al);

	}

}
