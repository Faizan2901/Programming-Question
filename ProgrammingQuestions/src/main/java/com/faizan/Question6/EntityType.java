package com.faizan.Question6;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EntityType {

	public static void main(String[] args) {

		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		
		//int tcount = 0;
		//int count = 0;
		try {

			File files = new File("/home/faizansopariwala/Downloads/Problem_Input/6/");

			File[] file = files.listFiles();
			DocumentBuilder builder = fac.newDocumentBuilder();

			for(int z=0;z<file.length;z++)
			{
				
			HashMap<String, Integer> hm = new HashMap<>();
			Document doc = (Document) builder.parse(file[z]);
			NodeList relation = doc.getElementsByTagName("RelationSet");
			// ArrayList<Integer> al=new ArrayList<>(count);

			for (int i = 0; i < relation.getLength(); i++) {

				Node c = relation.item(i);
				if (c.getNodeType() == Node.ELEMENT_NODE) {

					Element rel = (Element) c;
					NodeList n = rel.getChildNodes();
					// System.out.println(n.getLength());

					for (int j = 0; j < n.getLength(); j++) {

						Node nc = n.item(j);

						if (hm.containsKey(nc.getNodeName())) {
							hm.put(nc.getNodeName(), hm.get(nc.getNodeName()) + 1);
						} else {
							hm.put(nc.getNodeName(), 1);
						}
//						if(nc.getNodeName()=="med")
//						{
//							
//							//System.out.println(nc.getNodeName());
//							count++;
//							
//							
//						}
//						else if(nc.getNodeName()=="lab")
//						{
//							count++;
//						}
//						else
//						{
//							
//						}

					}

					// System.out.println(tcount);
					// System.exit(0);
					//

				}
				//System.out.println(count);

			}
			System.out.println(hm);
			}

			// count=0;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
