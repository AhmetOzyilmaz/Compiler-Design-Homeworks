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

    public Simulator() {   for (int i = 0; i <Register.length ; i++) Register[i]=0; }
    //Constructor 1 parameter
    public Simulator(String filename) {
        for (int i = 0; i <Register.length ; i++) Register[i]=0;
        Filename = filename;
        FOC.setInputFile(filename);
    }
    // Simulate all program input file converting and writing output file
    public void Simulate() throws IOException {
        customer.ReadData(getFilename());
        All_Data_Parser();
    }
    //Parsing line and working on it
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
            else if(true == lex.isReadStmt(line)){
                System.out.println("read sttmt");
                FOC.WriteFile(IS.IN(i,Register[0],Register[0],0));
            }
            else if(true == lex.repeatStmt(line)){
                //until görene kadar
            }
            else if(true == lex.isIfStmt(line)){
                //if in şartını kontrol etmesi lazım
                //if i sağlamıyorsa if ten sonraya jump etmesi lazım
                //uymuyorsa hiç girmicek
                // this program not working nested if
                while(false == lex.isEndifStmt(line)){ // until find "end" line execute if statement
                    break;
                }
            }
            else if(true == lex.assignStmt(line)) {

            }
            /*else if(true == lex.is(line)){
                System.out.println("read sttmt");
                FOC.WriteFile(IS.IN(i,Register[0],Register[0],0));
            }*/
            else
                System.out.println("else");
        }
        FOC.WriteFile(IS.HALT(customer.data.size(),0,0,0));
    }
    //if we have avilable register this function returnin this or if not return -1
    public int isExistNoneUseRegister(){
        for (int i = 0; i <Register.length ; i++) {
            if(Register[i]==0) return i;
        }
        return -1;
    }

}
