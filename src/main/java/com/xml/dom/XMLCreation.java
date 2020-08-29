package com.xml.dom;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XMLCreation {

	public Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement( "root" );

        Element author1 = root.addElement( "author" )
            .addAttribute( "name", "James" )
            .addAttribute( "location", "UK" )
            .addText( "James Strachan" );
        
        Element author2 = root.addElement( "author" )
            .addAttribute( "name", "Bob" )
            .addAttribute( "location", "US" )
            .addText( "Bob McWhirter" );
        Element author2_book1= author2.addElement("book").addAttribute("name", "Book1").addText("BookSample");
        
        return document;
    }
	
	public static void main(String[] args) {
		XMLCreation sample= new XMLCreation();
		Document document=sample.createDocument();
		String fileseparator=System.getProperty("file.separator");
		try(FileWriter fw= new FileWriter("/Users"+fileseparator+"Ajmal"+fileseparator+"sample.xml", true);){
			document.write(fw);
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}
