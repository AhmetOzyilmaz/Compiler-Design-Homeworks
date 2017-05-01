package com.company;

import com.company.ProjectPart2.FileOperationClass;

/**
 * Created by ASUS on 1.05.2017.
 */
public class Simulator {
    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }

    public String Filename ;
    public FileOperationClass f = new FileOperationClass(getFilename());



    public Simulator(String filename) {
        Filename = filename;
        f.setInputFile(filename);
    }

    public void Simulate() {

        f.ReadFile();
    }
}
