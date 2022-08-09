package com.faizan.Question5;


import java.awt.List;
import java.io.File;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;
import org.w3c.dom.NodeList;

public class SAXExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SAXBuilder builder=new SAXBuilder();
		
		Document xml=null;
		
		try
		{
			xml=builder.build(new File("/home/faizansopariwala/Downloads/Problem_Input/5/Bobby J Baca_394099_9.3.19_Las Cruces.txt.xml"));
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		Element root=xml.getRootElement();
		
		System.out.println("Root element of XML Document is : "+root.getName());
		System.out.println("Number of \"Icd10CmCode\" in the XML are: "+root.getChildren().size());
		
		
		java.util.List<Element> nl=root.getChildren();
				
		
		
		java.util.List<Element> nodecode=root.getChildren();
		
		Iterator<Element> itr=nodecode.iterator();
		
		while(itr.hasNext())
		{
			Element nodes=(Element)itr.next();
			System.out.println("Rank : "+nodes.getName());
			NodeList cnode=(NodeList) nodes.getChildren();
			
			for(int i=0;i<cnode.getLength();i++)
			{
				java.util.List<Element> nodecode1=root.getChildren();
				
				//Iterator<Element> itr=nodecode.iterator();
			}
			
		}
		

	}

}
