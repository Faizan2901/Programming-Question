package com.faizan.Question9;

import java.io.File;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CompareFiles {

	public static Set<String> codeValue(File file) {
		Set<String> str = new HashSet<>();

		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = fac.newDocumentBuilder();
			Document doc = (Document) builder.parse(file);
			NodeList codevalue = doc.getElementsByTagName("Icd10CmCode");

			for (int i = 0; i < codevalue.getLength(); i++) {

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

							if (Name.getNodeName() == "code") {
								str.add(Name.getAttribute("value"));
							}

						}

					}

				}
			}

		} catch (Exception e) {

		}

		return str;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> str = new HashSet<>();
		Set<String> str1 = new HashSet<>();
		File dir1 = new File("/home/faizansopariwala/Downloads/Problem_Input/9/CM1");
		File dir2 = new File("/home/faizansopariwala/Downloads/Problem_Input/9/CM2");

		File[] files1 = dir1.listFiles();
		File[] files2 = dir2.listFiles();
		for (int i = 0; i < files1.length; i++) {
			for (int j = 0; j < files2.length; j++) {
				if (files1[i].getName().equals(files2[j].getName())) {

					str = codeValue(files1[i]);
					str1 = codeValue(files2[j]);

					System.out.println(files1[i].getName());
					System.out.println("Common");
					comparisonValue(str, str1);
					System.out.println("Extra");
					extraValue(str, str1);
					System.out.println("Missing");
					missingValue(str, str1);
					System.out.println();
				}

			}
		}

	}

	static public void comparisonValue(Set<String> s1, Set<String> s2) {

		Set<String> match = new HashSet<>(s1);
		match.retainAll(s2);
		System.out.println(match);
		System.out.println(match.size());
	}

	static public void extraValue(Set<String> s1, Set<String> s2) {

		Set<String> extra = new HashSet<>(s1);
		extra.removeAll(s2);
		System.out.println(extra);
		System.out.println(extra.size());

	}

	static public void missingValue(Set<String> s1, Set<String> s2) {

		Set<String> missing = new HashSet<>(s2);
		missing.removeAll(s1);
		System.out.println(missing);
		System.out.println(missing.size());

	}

}
