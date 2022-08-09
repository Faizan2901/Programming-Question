package com.faizan.Question2;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question2 {

	public static void main(String[] args) {
		
		File files = new File("/home/faizansopariwala/Downloads/Problem_Input/2/");
		
		File[] file = files.listFiles();
		int count=0;
		int fcount=0;
		
		String str="^[tT][h][e]\\b";
		Pattern pat=Pattern.compile(str);
		
		for(int i=0;i<file.length;i++)
		{
			
			try(BufferedReader br=new BufferedReader(new FileReader(file[i])))
			{
				String str1;
				while((str1=br.readLine())!=null)
				{
					Matcher mat=pat.matcher(str1);
					if(mat.find())
					{
						count++;
						fcount++;
					}
					
				}
			}catch(Exception e)
			{
				System.out.println(e);
			}
			System.out.println("\'The\' word occurs in the Resource No:- "+(i+1)+" is "+fcount);
			fcount=0;
		}
		
		System.out.println("\nTotal \'The\' Word in the Resources are "+count);
		
		

	}

}
