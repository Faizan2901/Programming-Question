package com.faizan.Question10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class test {

	public static ArrayList<String> Pattern(String s) {

		ArrayList<String> str = new ArrayList<String>();

		String[] arr = s.split(" ");
		for (String s1 : arr) {

			if (s1.endsWith(".*") && !str.contains(s1)) {
				str.add(s1);
			}
		}
		return str;
	}

	public static void printChanges(ArrayList<String> patterns, ArrayList<String> list, String que) {
		for (String p : patterns) {
			for (String c : list) {
				if (c.substring(0, 3).equals(p.substring(0, 3))) {
					String temp = que.replace(p, c);
					ArrayList<String> tempPattern = Pattern(temp);
					if (tempPattern.isEmpty()) {
						System.out.println(temp);
					} else {
						printChanges(tempPattern, list, temp);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		final String que = "Z68.* + I10 = I11.2 + Z68.*";

		ArrayList<String> patterns = Pattern(que);

		ArrayList<String> list = new ArrayList<String>();
		BufferedReader bf = new BufferedReader(
				new FileReader("/home/faizansopariwala/Downloads/Problem_Input/10/LatestIcd10Codes"));
		String line = bf.readLine();

		while (line != null) {
			list.add(line);
			line = bf.readLine();
		}
		printChanges(patterns, list, que);
	}

}
