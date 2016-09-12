package com.thoughtworks.trains.Utility.InputHandler;

import mockit.Deencapsulation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ProblemFileReaderTest {

    private String filePath;

    @Before
    public void setUp() throws Exception {

        String text = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        OutputStreamWriter output;

        File file = File.createTempFile("problemStatement", ".txt");

        //noinspection ResultOfMethodCallIgnored
        file.setWritable(true);
        //noinspection ResultOfMethodCallIgnored
        file.setReadable(true);

        output = new OutputStreamWriter(new FileOutputStream(file));
        Writer w = new BufferedWriter(output);
        w.write(text);
        w.close();

        this.filePath = file.getAbsolutePath();
    }

    @After
    public void tearDown() throws Exception {

        Path path = Paths.get(this.filePath);

        Files.delete(path);
    }

    @Test
    public void testParseFile(){

        System.out.println("Reading temp file from path : " + this.filePath);

        ProblemFileReader problemFileReader = new ProblemFileReader();

        String fileContent = Deencapsulation.invoke(problemFileReader, "parseFile",  this.filePath);

        System.out.println("File content : "+fileContent);

        assertEquals("Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7", fileContent.trim());

    }

}