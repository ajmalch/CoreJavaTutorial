package com.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

	private static void readStreamofLinesUsingFile(){
		String pathSeparator= System.getProperty("file.separator");
		try(Stream<String> filteredLines=Files.lines(Paths.get("D:"+pathSeparator+"Ajmal"+pathSeparator+"Samples", "input.txt")).onClose(()->{System.out.println("File colsed");
		}).filter(s->s.contains("Maliha")))	{
			System.out.println(filteredLines.reduce("",(a,b)->a+b));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		readStreamofLinesUsingFile();
	}
}
