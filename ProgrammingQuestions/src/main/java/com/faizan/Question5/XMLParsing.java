package com.faizan.Question5;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 0;
		String syr = "";

		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder builder = fac.newDocumentBuilder();
			Document doc = (Document) builder.parse(new File(
					"/home/faizansopariwala/Downloads/Problem_Input/5/Thomas S Bellows Jr_399166_9.17.19_Las Cruces.txt.xml"));
			NodeList codevalue = doc.getElementsByTagName("Icd10CmCode");

			for (int i = 0; i < codevalue.getLength(); i++) {
				int count = 0;
				Node c = codevalue.item(i);
				if (c.getNodeType() == Node.ELEMENT_NODE) {
					Element person = (Element) c;
					// String codevl=person.getAttribute("code");
					// System.out.println(codevl);
					NodeList n = person.getChildNodes();

					for (int j = 0; j < n.getLength(); j++) {

						Node nc = n.item(j);
						if (nc.getNodeType() == Node.ELEMENT_NODE) {
							Element Name = (Element) nc;
							// System.out.print(" Rank :- "+Name.getAttribute("rank"));
							count++;
							/*
							 * NodeList rn=(NodeList) Name.getAttributes();
							 * 
							 * for(int k=0;k<rn.getLength();k++) { System.out.println(rn.item(k)); }
							 */
							if (Name.getNodeName() == "code") {
								if (max < Integer.parseInt(Name.getAttribute("rank"))) {
									max = Integer.parseInt(Name.getAttribute("rank"));
									syr = Name.getAttribute("value");
								}

							}
							
							/*
							 * if(count>1) {
							 * 
							 * 
							 * if(max<=Integer.parseInt(Name.getAttribute("rank"))) {
							 * max=Integer.parseInt(Name.getAttribute("rank"));
							 * System.out.println("Maximum Rank:- "+max+" and it's Value:- "+Name.
							 * getAttribute("value"));
							 * 
							 * }
							 * 
							 * }
							 */

						}

					}
					System.out.println("Maximum Rank:- " + max + " and it's Value:- " + syr);
						max=0;
						syr="";
						System.out.println("<Icd10CmCode>");
					// System.out.println();
					// System.out.println(count);

				}
				// System.out.println();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
