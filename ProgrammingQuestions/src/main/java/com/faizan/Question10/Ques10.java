package com.faizan.Question10;

import java.io.BufferedReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ques10 {

	public static void checkPattern(List<String> fileTextList, String[] split,String text) {

		Set<String> s=new HashSet<>();
		for(int i=0;i<split.length;i++)
		{
			if(split[i].contains(".*"))
			{
				s.add(split[i]);
			}
		}
		
		for(int i=0;i<split.length;i++)
		{
			for(int j=0;j<fileTextList.size();j++)
			{
				if(split[i].substring(0,3).equals(fileTextList.get(j).substring(0, 3)))
				{
					System.out.println(text.replace(split[i], fileTextList.get(j)));
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Z68.* + I10 = I11.2 + Z68.*";

		String split[]=str.split("\\s");
		
		List<String> fileTextList=new ArrayList<>();
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/faizansopariwala/Downloads/Problem_Input/10/LatestIcd10Codes"));
			String read;
			while((read=br.readLine())!=null)
			{
				fileTextList.add(read);
			}
			checkPattern(fileTextList,split,str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
