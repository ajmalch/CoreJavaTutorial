package com.executearound;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by AjmalCholassery on 6/17/15.
 */
public class FileWriterEAM  {

    private final FileWriter writer;

    private FileWriterEAM(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    private void close() throws IOException {
        System.out.println("close called automatically...");
        writer.close();
    }

    public void writeStuff(final String message ) throws IOException {
        writer.write(message);
    }

    public static void use(String filename, UseInstance<FileWriterEAM,IOException> block) throws  IOException{
        final FileWriterEAM writerEAM=new FileWriterEAM(filename);
        try{
            block.accept(writerEAM);
        }finally {
            writerEAM.close();
        }
    }

    public static void main(String[] args) throws  IOException{
        System.out.println("//" + "START:EAM_USE_OUTPUT");
        FileWriterEAM.use("eam.txt", writerEAM -> writerEAM.writeStuff("sweet"));
        System.out.println("//" + "END:EAM_USE_OUTPUT");

        FileWriterEAM.use("eam2.txt", writerEAM -> {
            writerEAM.writeStuff("how");
            writerEAM.writeStuff("sweet");
        });
    }
}
