package com.company;

import com.company.ProjectPart1.CodeGen;
import com.company.ProjectPart1.Lexical;
import com.company.ProjectPart1.Semantic;
import com.company.ProjectPart2.FileOperationClass;

import java.io.IOException;

/**
 * Created by ASUS on 1.05.2017.
 */
public class Simulator {
    private int[] Register = new int[8];
    private Semantic customer=new Semantic();
    private Lexical  lex = new Lexical();
    private CodeGen  code = new CodeGen();
    public String Filename ;
    public FileOperationClass FOC = new FileOperationClass(getFilename());
    public InstructionSets IS = new InstructionSets();

    public String getFilename() {
        return Filename;
    }

    public Simulator(String filename) {
        Filename = filename;
        FOC.setInputFile(filename);
    }

    public void Simulate() throws IOException {

        customer.ReadData(getFilename());
        All_Data_Parser();
    }
    public void All_Data_Parser() throws IOException {
        String line = "";
        System.out.println("customer " +  customer.data.size());

        for (int i = 0; i < customer.data.size(); i++) {

            line = code.RemoveSemicolonEndOFString( customer.data.get(i));

            //System.out.println("customer " + customer.data.get(i));

            if(true == lex.isWriteStmt(line)){
                System.out.println("Write sttmt");
                FOC.WriteFile(IS.OUT(i,Register[0],Register[0],0));
            }
            if(true == lex.isWriteStmt(line)){
                System.out.println("read sttmt");
                FOC.WriteFile(IS.IN(i,Register[0],Register[0],0));
            }

            else
                System.out.println("else");
        }
    }

}
