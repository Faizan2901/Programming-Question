package com.faizan.Question10;

import java.io.BufferedReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;

public class Ques10 {
	
	static public ArrayList<String> splitText(String splittext)
	{
		
		ArrayList<String> al=new ArrayList<>();
		String split[]=splittext.split("\\s");
		for(int i=0;i<split.length;i++)
		{
			if(split[i].contains(".*"))
			{
				al.add(split[i]);
			}
		}
		return al;
	}

	public static void checkPattern(Set<String> fileTextList, ArrayList<String> split,String text) {

		
		/*for(int i=0;i<split.length;i++)
		{
			for(int j=0;j<fileTextList.size();j++)
			{
				if(split[i].substring(0,3).equals(fileTextList.get(j).substring(0, 3)))
				{
					//System.out.println(text.replace(split[i], fileTextList.get(j)));
					String temp= text.replace(split[i], fileTextList.get(j));
                    ArrayList<String> tempPattern =new ArrayList<>();
                    
					
                    if(tempPattern.isEmpty()) {
                        System.out.println(temp);
                    }else {
                        printChanges(tempPattern, list, temp);
                    }
					
				}
			}
		}*/
		for(String p:fileTextList) {
            for(String c:split) {
                if(c.substring(0,3).equals(p.substring(0,3))) {
                    String temp= text.replace(p, c);
                    ArrayList<String> tempPattern = splitText(temp);
                    if(tempPattern.isEmpty()) {
                        System.out.println(temp);
                    }else {
                        //printChanges(tempPattern, list, temp);
                    }
                }
            }
        }
	}

	public static void main(String[] args) {
		

		String str = "Z68.* + I10 = I11.2 + Z68.*";

		//String split[]=str.split("\\s");
		
		ArrayList<String> fileTextList=splitText(str);
		ArrayList<String> as =new ArrayList<>();
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/faizansopariwala/Downloads/Problem_Input/10/LatestIcd10Codes"));
			String read;
			while((read=br.readLine())!=null)
			{
				as.add(read);
			}
			//checkPattern(fileTextList,as,str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
