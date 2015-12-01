package com.serializaion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {

	public static void main(String[] args)  {
		
		Department hr = new Department("HR", 100001, " HR Department ");
		
		Employee e1= new Employee("Ajmal", 30, 50000, hr);
		String fileseparator=System.getProperty("file.separator");
		String path = fileseparator+"Users"+fileseparator+"AjmalCholassery"+fileseparator+"Google Drive";
		try(FileOutputStream fos= new FileOutputStream(path+"/person.txt");
			ObjectOutputStream os= new ObjectOutputStream(fos);
			FileInputStream fis= new FileInputStream(path+"/person.txt");
			ObjectInputStream is= new ObjectInputStream(fis) 	) {
			
			os.writeObject(e1);
			System.out.println("Serialization completed successfully\nDetails are\n" +
			"Name: "+e1.getName()+"\nAge: "+e1.getAge()+"\nSalary: "+e1.getSalary()+"\nDapartment: "+e1.getDept().getName());
			Employee e2=(Employee)is.readObject();
			
			System.out.println("Deserialization completed succesfully\nDetails are\n" +
			"Name: "+e2.getName()+"\nAge: "+e2.getAge()+"\nSalary: "+e2.getSalary()+"\nDapartment: " + e2.getDept().getName());
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
