package com.faizan.Question4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TSVorCSVFIle {

	public static void main(String[] args) {

		String str = "";
		
		File files = new File("/home/faizansopariwala/Downloads/Problem_Input/4/");
		BufferedReader br = null;
		File[] file = files.listFiles();
		try {
			for (int k = 0; k < file.length; k++) {
				int index = 0;
				boolean coun = true;
				double sum = 0;
				br = new BufferedReader(new FileReader(file[k]));

				while ((str = br.readLine()) != null) {

					String[] amount;

					if (file[k].getName().endsWith(".csv")) {
						amount = str.split(",");
					} else {
						amount = str.split("\t");
					}

					for (int i = 0; i < amount.length; i++) {
						if ("Amount".equals(amount[i])) {
							index = i;
						}
					}

					if (coun) {
						coun=false;
						continue;
					}

					for (int j = 0; j < amount.length; j++) {
						if (j == index) {

							sum = sum + Double.parseDouble(amount[index]);

						}
					}

				}
				System.out.println("The Sum of Amount:- " + sum);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

		

	}

}
