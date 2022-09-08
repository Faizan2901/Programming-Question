package com.faizan.Question7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Tabular {

	static ArrayList<String> tlist = new ArrayList<>(100000);

	public static int isTabPresent(String str) {
		int tcount = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '\t') {
				++tcount;
			}
		}

		return tcount;

	}

	static String str;

	public static void printList(List<String> list, String strlist, int tabc) {
		String[] split = strlist.split("~");
		list.set(tabc, split[0]);
		System.out.print(split[1] + " ");
		for (String str : list) {
			System.out.print(str + " ");
		}
	}

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(
				new FileReader("/home/faizansopariwala/Downloads/Problem_Input/7/InputFile"))) {
			while ((str = br.readLine()) != null) {
				str = str.split("@@")[0];
				
				int tc = isTabPresent(str);

				if (tc == 0) {

					tlist.clear();
					tlist.add(str.trim());
				} else {
					
					if(tlist.size()<=tc)
					{
						tlist.add(str.trim());
					}
					else
					{
						tlist.set(tc,str.trim());
					}
				}

				String string = tlist.get(tc);
				if (string.contains("~")) {
					printList(tlist, string, tc);
					System.out.println();
				}

			}
			br.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
