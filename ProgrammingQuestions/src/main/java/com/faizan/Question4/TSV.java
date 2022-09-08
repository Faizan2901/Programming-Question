package com.faizan.Question4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

public class TSV {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		TsvParserSettings settings = new TsvParserSettings();
		TsvParser parser = new TsvParser(settings);

		double sum=0;
		int index=0;
		
		List<String[]> allRows = parser.parseAll(new FileReader("/home/faizansopariwala/Downloads/Problem_Input/4/1.tsv"));
		String[] amount=null;
		
		
		for(int i=0;i<amount.length;i++)
		{
			if("Amount".equals(amount[i]))
			{
				index=i;
			}
		}
		
		for (int i = 0; i < amount.length; i++) {
			if (i == index) 
			{

				sum = sum + Double.parseDouble(amount[index]);

			}
		}

	}

}
