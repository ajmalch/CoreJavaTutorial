package com.xml.dom;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLParsing {
	
	
	public Document parse(File input){
		
		SAXReader reader = new SAXReader();
		try{
			Document document=reader.read(input);
			return document;
		}
		catch(DocumentException ex){
			System.out.println("Input is not parsable ");
			ex.printStackTrace();
			return  null;
		}
	}
	
	public void documentIterator(Document document){
		Element root=document.getRootElement();
		for(@SuppressWarnings("unchecked")
		Iterator<Element> i=root.elementIterator();i.hasNext();){
		   System.out.println(i.next().getName());
		}
	}
	public static void main(String[] args) {
		XMLParsing test=new XMLParsing();
		String fileseparator=System.getProperty("file.separator");
		Document document=test.parse(new File("D:"+fileseparator+"Ajmal"+fileseparator+"build.xml"));
		System.out.println(document.asXML());
		test.documentIterator(document);
	}
	
}
