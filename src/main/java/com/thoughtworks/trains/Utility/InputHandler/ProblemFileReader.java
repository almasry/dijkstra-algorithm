package com.thoughtworks.trains.Utility.InputHandler;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.InvalidPathException;
import java.util.Scanner;

public class ProblemFileReader implements IProblemStatementReader {

    /**
     * {@inheritDoc}
     */
    public String getProblemStatement() throws Exception {

        String fileContent = this.getFileContent();

        if ( (fileContent.trim().length() == 0) || !(this.isFileContentPureASCII(fileContent)) )
        {
            throw new Exception("File is empty or has invalid (non ASCII) characters ..");
        }

        return fileContent;
    }

    /**
     * Reads user input through a prompt, if input is invalid, show the prompt reader over and over again
     * @return path of the file to be parsed
     */
    private String getFileContent() throws IOException {

        String fileContent;

        do {
            String filePath = this.getFilePath();
            try {
                fileContent = this.parseFile(filePath);
                break;
            } catch (Exception e) {
                System.out.println("Invalid path or corrupted file .. \n" + e.getMessage() + "\n");
            }

        } while (true);

        return fileContent;
    }

    /**
     * @return file path as filled in by the user
     */
    private String getFilePath() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the full path of the input file :");
        System.out.flush();

        return scanner.nextLine().trim();
    }

    /**
     * @param filePath path of the file to be parsed
     * @return String
     * @throws Exception if file is not found or can't be parsed
     */
    private String parseFile(String filePath) throws Exception
    {
        File file = new File(filePath);

        if (file.canRead()) {

            try {
                String fileContent= "";
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String text;

                while ((text = reader.readLine()) != null) {
                    fileContent += text;
                }

                return fileContent;
            }
            catch (FileNotFoundException e){

                throw new Exception("File not found ..");
            }
        }
        else{
            throw new InvalidPathException(filePath, "File not readable ..");
        }
    }


    /**
     * @param fileContent string
     * @return true if the content of the file is ASCII content, false otherwise
     */
    private boolean isFileContentPureASCII(String fileContent)
    {
        return Charset
                .forName("US-ASCII")
                .newEncoder()
                .canEncode(fileContent);
    }

}
