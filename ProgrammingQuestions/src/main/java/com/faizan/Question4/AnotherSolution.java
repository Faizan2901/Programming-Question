package com.faizan.Question4;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class AnotherSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum=0;
		try (Reader reader = Files
				.newBufferedReader(Paths.get("/home/faizansopariwala/Downloads/Problem_Input/4/2.csv"));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
						.withFirstRecordAsHeader()
	                    .withIgnoreHeaderCase()
	                    .withTrim());) {
			
			for (CSVRecord csvRecord : csvParser)
			{
				sum=sum+Integer.parseInt(csvRecord.get("Amount"));
			}
			System.out.println("Total Sum of Amount is:- "+sum);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
