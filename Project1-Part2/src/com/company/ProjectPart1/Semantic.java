package com.company.ProjectPart1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by ASUS on 25.03.2017.
 */
public class Semantic {
    public CodeGen code  = new CodeGen();
    public Lexical useFunc = new Lexical();
    private Vector<String> data = new Vector<>();//Dosyadan gelen input
    private HashMap<String, ArrayList<Integer>> TableData = new HashMap<String, ArrayList<Integer>>();
    private Map<String , String> reservedKeyWord = new HashMap();


    public Semantic(){
        FillReservedWord();
    }

    public void Syntex_Tree_Parse(String line,Integer line_Num) throws Exception {
        int my_space_counter = 1;

        line = code.RemoveSemicolonEndOFString(line);
        line = code.DeleteSpaceStartOfString(line);
        String out[] = line.split(" "); // we cut our line of code for parsing

        for (int i = 0; i< out.length; ++i){

            if(true == useFunc.isId(out[i])){
                //is identifier
                List<Integer> itemsList = TableData.get(out[i]);

                // if list does not exist create it
                if(itemsList == null) {
                    itemsList = new ArrayList<Integer>();
                    itemsList.add(line_Num);
                    TableData.put(out[i], (ArrayList<Integer>) itemsList);
                } else {
                    // add if item is not already in list
                    if(!itemsList.contains(line_Num)) itemsList.add(line_Num);
                }

            }

            if(out[i].equals(reservedKeyWord.get("read")) && useFunc.isId(out[i+1])){
                System.out.println("Read: " + out[i+1]);
            }
            if(out[i].equals("write") && useFunc.isId(out[i+1])){
                System.out.println("Write: " + out[i+1]);
            }

            else if(useFunc.isassignnop(out[i])){
                System.out.println("Assign to: " + out[i-1]);
                if(useFunc.isId(out[i-1])==false){
                    System.out.println("ERROR INPUT IS SHOULD BE A CORRECT IDENTIFIER");
                    throw new Exception();

                }
                for (int j = i+1; j < out.length ; j++) {
                    if(useFunc.ismulop(out[j]) || useFunc.isaddop(out[j])){
                        for (int k = 0; k <my_space_counter ; k++)  System.out.print("\t");
                        ++my_space_counter;

                        System.out.println("Op: " + out[j]);
                        if(useFunc.isId(out[j-1])){
                            for (int k = 0; k <my_space_counter ; k++)  System.out.print("\t");

                            System.out.println("Id: " + out[j-1]);
                        }
                        else if(useFunc.isNum(out[j-1])){
                            for (int k = 0; k <my_space_counter ; k++)  System.out.print("\t");

                            System.out.println("Const: " + out[j-1]);
                        }
                        if(useFunc.isId(out[j+1])){
                            for (int k = 0; k <my_space_counter ; k++)  System.out.print("\t");
                            System.out.println("Id: " + out[j+1]);
                        }
                        else if(useFunc.isNum(out[j+1])){
                            for (int k = 0; k <my_space_counter ; k++)  System.out.print("\t");

                            System.out.println("Const: " + out[j+1]);
                        }
                        else
                        {
                            System.out.println("ERROR INPUT");
                            throw new Exception();
                        }

                    }


                    }
                }
        }




    }
    public void Program(String filename) throws Exception {
        // System.out.println("Source code:" + filename);
        for (int i = 0 ; i < data.size(); ++ i){
            System.out.println(i+1 + ": " + data.get(i));
            LineParser(i+1, data.get(i));
        }

        System.out.println("\n\nSyntex tree: " + filename);

        for (int i = 0; i < data.size() ; i++) {
           Syntex_Tree_Parse(data.get(i),i);
        }
        DrawSymbolTable();

        System.out.println("\n\n Checking Types... ");


        for (int i = 0; i <data.size() ; i++) {
           String message =  TypeCheking(data.get(i));
            if(false == message.equals(""))
                System.out.println("\n\n Type error at line  " + (i+1) + message);
        }
        System.out.println("\n\n Type Checking Finished ");

    }
    public void Error_Check_Source(String[] out,int line_Num) throws Exception {
        if( out[0].equals("write") || out[0].equals("read")){

            if(out.length > 4)
                throw new Exception();

            for (int i= 1 ; i< out.length-1; ++i)
            {
                boolean check = useFunc.isId(out[i]);

                if(check == false)
                {
                    System.out.println("This Have to letter all element of identifier");
                    System.exit(0);
                }
            }
        }

    }
    public void LineParser(int line_Num, String line ) throws Exception {

        line = code.RemoveSemicolonEndOFString(line);
        line = code.DeleteSpaceStartOfString(line);
        String out[] = line.split(" "); // we cut our line of code for parsing
        Error_Check_Source( out,line_Num);

        for (int j = 0; j < out.length ; ++ j){

            if(useFunc.isReserved(out[j])){
                System.out.println("    " + line_Num + ": " +"reserved word: " + out[j]);
            }
            else if(true == useFunc.isId(out[j])){
                System.out.println("    " + line_Num + ": " +"ID, name " + out[j]);
            }
            else if(true == useFunc.isNum(out[j]))
            {
                System.out.println("    " + line_Num + ": " +"NUM ,val " + out[j]);

            }
            else
                System.out.println("    " + line_Num + ": " + out[j]);


        }

    }
    public void ReadData(String filename){
        String line = null;

        try {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);


            while ((line = br.readLine()) != null) {
                data.add(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Exception caughted" + e.toString() + " " + e.getStackTrace()[0
                    ].getLineNumber()+ "All Line Of Code have to end with semicolon");        }
        // PrintData();
    }
    public void PrintData() {
        for (int i =0  ; i < data.size() ; ++i){
            System.out.println(data.get(i));
        }
    }

    public String TypeCheking(String line){
        String message  = "";

        line = code.RemoveSemicolonEndOFString(line);
        line = code.DeleteSpaceStartOfString(line);
        String out[] = line.split(" "); // we cut our line of code for parsing

        if(out[0].equals("if") == true){
            for (int i = 1; i < out.length; i++) {
                if(out[i].equals("+" )|| out[i].equals("-") || out[i].equals("*")|| out[i].equals("/"))
                {
                    message=" if control statement's return value is not Boolean ";
                    break;
                }
            }
        }
        return message;
    }
    public void FillReservedWord(){
        reservedKeyWord.put("read","read");
        reservedKeyWord.put("write","write");
        reservedKeyWord.put("if","if");
        reservedKeyWord.put("then","then");
        reservedKeyWord.put("end","end");
        reservedKeyWord.put("until","until");
    }
    public void DrawSymbolTable(){
        System.out.println("Variable name        Location          Line numbers");
        System.out.println("--------------------------------------------------------------------");

        for (String key :TableData.keySet()) {
            List<Integer> l = TableData.get(key);
            System.out.print("\t"+key + "\t\t\t\t\t"+ l.get(0)+"\t\t\t" );

            for (int j = 0; j < l.size() ; j++)
                System.out.print("  "+l.get(j));

            System.out.println();
        }
    }
}
