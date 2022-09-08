package com.faizan.Question8;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;

public class Index {

	public static void main(String[] args) {
	

		TreeMap<Integer,String> tm=new TreeMap<>();
		
		//TreeMap<Integer,String> tmclone=new TreeMap<>();
		String str1=null;
		
		String[] str= {"0051T	implantation	heart, artificial	cardiectomy","102AT	implantation	heart, artificial	cardiectomy	replacement"};
		try(BufferedReader br=new BufferedReader(new FileReader("/home/faizansopariwala/Downloads/Problem_Input/8/InputFile")))
		{
			while((str1=br.readLine())!=null)
			{
				for(int z=0;z<str.length;z++)
				{
					
					String[] split=str1.split("\\t", 2);
					String[] splitText=split[1].split("\\t");
					
					
					for(int i=0;i<splitText.length;i++)
					{
						//System.out.println(splitText[i]);
						tm.put(i, splitText[i]);
					}
					//tmclone.putAll(tm);
					for(int i=0;i<tm.size();i++)
					{
						if(tm.containsKey(i))
						{
							for(int j=0;j<i;j++)
							{
								System.out.print("\t");
							}
							
						}
						if(i== tm.lastKey())
						{
							System.out.println(tm.get(i)+" ~ "+ split[0]);
							
						}
						else
						{
							System.out.println(tm.get(i));
						}
						
						
						
					}
					
				}
				
				//System.out.println(tmclone);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

		

		

	}

}
