package com.company.ProjectPart2;

/**
 * Created by ASUS on 1.05.2017.
 */
public class FileOperationClass {

    public void WriteFile(){


        //
    }
    public void ReadFile(){


        //

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
    private String outputFile;


    /**
     * Created by ASUS on 1.05.2017.
     */
    public static class mmry {
        mmry(int i,int v){
            index=i;
            value=v;
        }
        mmry(){
            index=0;
            value=0;
        }
        int index;
        int value;

    }

    /**
     * Created by ASUS on 1.05.2017.
     */
    public static class Simulator {

        FileOperationClass file = new FileOperationClass();
        public Simulator(String filename) {
            file.setInputFile(filename);// will converted file
        }
        public void Simulate(){


        }

    }
}
