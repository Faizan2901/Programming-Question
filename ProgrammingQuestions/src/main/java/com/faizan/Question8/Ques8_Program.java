package com.faizan.Question8;

import java.io.*;
import java.util.*;

public class Ques8_Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader rd = new BufferedReader(new FileReader("/home/faizansopariwala/Downloads/Problem_Input/8/InputFile"));
			String s;
			node root = new node();
			List<String> check = new ArrayList<String>();
			String l="";
			while((s=rd.readLine())!=null) {
				node n = root;
				String[] d = s.split("\t");
				
				for(int i = 1; i < d.length-1; i++) {
					if(n.containsKey(d[i])) {
						n = n.get(d[i]);
					}
					else {
						n.put(d[i], n = new node());
						check.clear();
					}
				}
				
				//l = d[d.length-1] + "~" + d[0];
				if(check.isEmpty()) {
					if(l.length()>1) {
						if(!n.containsKey(l)) {
							n.put(l, new node());
						}
					}
					check.add(d[d.length-1]);
					l = d[d.length-1] + "~" + d[0];
				}
				else if(!check.get(check.size()-1).equals(d[d.length-1])) {
					if(!n.containsKey(l)) {
						n.put(l, new node());
					}
					check.add(d[d.length-1]);
					l = d[d.length-1]+"~"+d[0];
				}
				else if(check.get(check.size()-1).equals(d[d.length-1])){
					l = l + "," + d[0];
				}
			
				//if(!n.containsKey(l)) {
					//n.put(l, new node());
				//}
				
			}
			rd.close();
			show(root,"");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	private static void show(node root, String t) {
		// TODO Auto-generated method stub
		for(Map.Entry<String, node> entry:root.entrySet()) {
			String k = entry.getKey();
			System.out.println(t + k);
			show(entry.getValue(),t+"\t");
		}
		
	}
	@SuppressWarnings("serial")
	static class node extends LinkedHashMap<String, node>{
		
	}


}

