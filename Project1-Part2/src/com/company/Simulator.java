package com.company;

import com.company.ProjectPart1.Semantic;
import com.company.ProjectPart2.FileOperationClass;

import java.io.IOException;

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

    public void Simulate() throws IOException {

        Semantic customer=new Semantic();
        customer.ReadData(getFilename());
        try {
            customer.Program(getFilename());
        } catch (Exception e) {
            System.out.println("Exception caughted" + e.toString() + " " + e.getStackTrace()[0
                    ].getLineNumber());
        }






    }
}
