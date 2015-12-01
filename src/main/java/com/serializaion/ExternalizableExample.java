package com.serializaion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableExample {

	public static void main(String[] args) {
		
		Book b1= new Book("Java",100234,"Brian");

		try(FileOutputStream fos= new FileOutputStream("/Users/AjmalCholassery/book.txt");
			ObjectOutputStream os= new ObjectOutputStream(fos);
			FileInputStream fis= new FileInputStream("/Users/AjmalCholassery/book.txt");
			ObjectInputStream is= new ObjectInputStream(fis)){
			
			os.writeObject(b1);
			Book b2= (Book)is.readObject();
			
			System.out.println("Externalization completed successfully\nDetails are"+
					"BookName :"+ b2.getName()+"\n"+
					"Book Id  :"+b2.getId()+"\n"+
					"Author   :"+b2.getAuthor()
					);
			
			
			
		}

		catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
