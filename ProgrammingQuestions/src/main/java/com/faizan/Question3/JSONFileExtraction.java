package com.faizan.Question3;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFileExtraction {

	public static void main(String[] args) {

		File files = new File("/home/faizansopariwala/Downloads/Problem_Input/3/AmazonMed_Json");

		File[] file = files.listFiles();

		JSONParser jsonparser = new JSONParser();

		for (int i = 0; i < file.length; i++) {

			try (FileReader file1 = new FileReader(file[i])) {

				if (file[i] == null) {
					System.out.println("File is Empty");
				}
				Object obj = jsonparser.parse(file1);
				JSONObject jsonobj = (JSONObject) obj;

				JSONArray arr = (JSONArray) jsonobj.get("Entities");

				for (int j = 0; j < arr.size(); j++) {
					JSONObject entities = (JSONObject) arr.get(j);

					if ((double) (entities.get("Score")) < 0.9) {
						System.out.println(entities.get("Text"));
					}
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
