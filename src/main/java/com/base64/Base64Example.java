package com.base64;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Example {

	public static void main(String[] args) {
		Encoder encoder= Base64.getEncoder();
		String myName="Ajmal Cholassery";
		String encodedString=encoder.encodeToString(myName.getBytes(StandardCharsets.UTF_8));
		System.out.println("My Name encoded :" + encodedString );
		Decoder decoder= Base64.getDecoder();
		byte[] decodedBytes=decoder.decode(encodedString);
		System.out.println("My Name decoded back : " + new String(decodedBytes));
		
		Path originalPath = Paths.get("D:/Ajmal", "sample.txt");
		Path targetPath = Paths.get("D:/Ajmal", "encoded.txt");
		Encoder mimeEncoder = Base64.getMimeEncoder();
		try(OutputStream output = Files.newOutputStream(targetPath)){
		    //Copy the encoded file content to target file
		    Files.copy(originalPath, mimeEncoder.wrap(output));
		    //Or simply use the encoded output stream
		    //OutputStream encodedStrem = mimeEncoder.wrap(output);
		}catch(FileNotFoundException fe){
			System.out.println("File not found");
			
		}catch(IOException ie){
			System.out.println("IO exception");
			ie.printStackTrace();
		}
		
		Path decodedPath = Paths.get("D:/Ajmal", "sample_decoded.txt");
		Decoder mimeDecoder = Base64.getMimeDecoder();
		try(InputStream input = Files.newInputStream(targetPath)){
		    //Copy the encoded file content to target file
		    Files.copy(mimeDecoder.wrap(input), decodedPath );
		   
		}catch(FileNotFoundException fe){
			System.out.println("File not found");
			
		}catch(IOException ie){
			System.out.println("IO exception");
			ie.printStackTrace();
		}
	}

}
