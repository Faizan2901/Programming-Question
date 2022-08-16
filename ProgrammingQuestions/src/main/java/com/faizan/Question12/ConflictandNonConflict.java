package com.faizan.Question12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConflictandNonConflict {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> hm=new HashMap<>();
		SortedSet<String> set=new TreeSet<>();
		int count=0;
		ArrayList<String> al=new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(
					new FileReader("/home/faizansopariwala/Downloads/Problem_Input/12/Inputfile"));
			String str;
			while((str=br.readLine())!=null)
			{
				al.add(str);
				//str=str.replaceAll("\\s+", "");
				//str=str.toLowerCase();
				String[] split=str.split("\\t+");
				hm.put(split[0], split[1]+split[2]);
				set.add(str);
			}
			/*Iterator<Map.Entry<String, String>> itr = hm.entrySet().iterator();
			while(itr.hasNext())
			{
				 Entry<String, String> entry = itr.next();
	             System.out.println("Key = " + entry.getKey() + 
	                                 "\tValue = " + entry.getValue());
	             
			}*/
			String[] key = hm.keySet().toArray(new String[hm.size()]);
			String[] values = hm.values().toArray(new String[hm.size()]);
			for (int i = 0; i < values.length; i++) {
			  for (int j = i+1; j<values.length; j++) {
			    if (key[i].equals(key[j])) {
			      System.out.println(values[i]);
			    }
			  }
			}
			
			
			
//			for(String s:set)
//			{
//	
//				System.out.println(s);
//			}
			System.out.println(set.size());
			System.out.println(al.size());
			System.out.println("Duplicate records are:- "+(al.size()-set.size()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
