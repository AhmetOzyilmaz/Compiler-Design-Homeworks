package com.company.ProjectPart2;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Vector;

/**
 * Created by ASUS on 1.05.2017.
 */
public class FileOperationClass {

    private Vector<String> data = new Vector<>();


    public FileOperationClass(String inputFile) {
        this.inputFile = inputFile;



    }

    public void WriteFile(String line) throws IOException {

        try{
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(getOutputFile(), true), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.write(line);
            fbw.newLine();
            fbw.close();
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void ReadFile() throws IOException {
       GetALLLine();

        // for (int i = 0; i < data.size() ; i++) {
         //   System.out.println(data.get(i));
       // }

        //

    }
    public void GetALLLine(){
        String line = null;
        try {
            FileReader reader = new FileReader(getInputFile());
            BufferedReader br = new BufferedReader(reader);


            while ((line = br.readLine()) != null) {
                data.add(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Exception caughted" + e.toString() + " " + e.getStackTrace()[0
                    ].getLineNumber()+ "All Line Of Code have to end with semicolon");        }
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    private String inputFile;
    private String outputFile = "output.asm";




}
