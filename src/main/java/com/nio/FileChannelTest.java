package com.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

	public static void main(String[] args) {
		String pathSeparator= System.getProperty("file.separator");
		try(RandomAccessFile f= new RandomAccessFile(pathSeparator+"Users"+pathSeparator+"Ajmal"+pathSeparator+"Samples"+pathSeparator+"input.txt", "rw")){
			FileChannel fchannel=f.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(24);

		    int bytesRead = fchannel.read(buf);
		    while (bytesRead != -1) {

		      System.out.println("Read " + bytesRead);
		      buf.flip();

		      while(buf.hasRemaining()){
		          System.out.print((char) buf.get());
		      }

		      buf.clear();
		      bytesRead = fchannel.read(buf);
		    }   
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
