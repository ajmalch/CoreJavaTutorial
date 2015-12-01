package com.xml.sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandlerTest {

	public static void main(String[] args) {
		String fileseparator=System.getProperty("file.separator");
		try(InputStream xmlInput= new FileInputStream(new File("D:"+fileseparator+"Ajmal"+fileseparator+"build.xml"));){
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser= factory.newSAXParser();
			
			DefaultHandler handler= new SaxHandler();
			parser.parse(xmlInput, handler);
		}catch(FileNotFoundException|ParserConfigurationException ex ){
			ex.printStackTrace();
		}catch(SAXException sx){
			sx.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
