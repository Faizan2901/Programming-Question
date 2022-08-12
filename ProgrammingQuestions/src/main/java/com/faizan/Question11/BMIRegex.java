package com.faizan.Question11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BMIRegex {

	static public ArrayList<String> valueOfBmi(ArrayList<String> bmiText, String regex) {
		ArrayList<String> bmiList = new ArrayList<>();

		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher matcher;
		for (int i = 0; i < bmiText.size(); i++) {
			matcher = pattern.matcher(bmiText.get(i));
			while (matcher.find()) {

				bmiList.add(matcher.group(3));

			}
		}
		return bmiList;
	}

	public static void main(String[] args) {

		try {
			String regex = "(BMI[a-z\\s]*|[b|B]o[ds]y mass index [a-z\\s]*|BMI\\s*\\(?[b|B]ody mass index\\)?|[b|B]ody [m|M]ass [i|I]ndex\\s*\\(?BMI\\)?)(\\s*:*\\s*|\\s?-\\s?|\\s*|\\s*-*>\\s*|\\s?=\\s?|\\W*)(\\d+\\s?\\w*\\s?\\d*\\.\\d*|\\d+\\.\\d+|\\d+\\s?-?\\s?\\d+\\.\\d+|\\d+)";
			ArrayList<String> bmiList = new ArrayList<>();
			BufferedReader br = new BufferedReader(
					new FileReader("/home/faizansopariwala/Downloads/Problem_Input/11/TextDocument"));
			String bmiText;
			while ((bmiText = br.readLine()) != null) {
				bmiList.add(bmiText);
			}
			br.close();
			bmiList = valueOfBmi(bmiList, regex);
			for (String bmiVal : bmiList) {
				System.out.println("Value Of BMI is:- " + bmiVal);
			}
			System.out.println("\nTotal BMI value in the List are:- " + bmiList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
