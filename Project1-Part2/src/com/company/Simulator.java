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
    private int[] RegisterLastRecentUse = new int[8];
    private String[] VariableName = new String[8];


    private Semantic customer=new Semantic();
    private Lexical  lex = new Lexical();
    private CodeGen  code = new CodeGen();
    public String Filename ;
    public FileOperationClass FOC = new FileOperationClass(getFilename());
    public InstructionSets IS = new InstructionSets();

    public String getFilename() {
        return Filename;
    }

    public Simulator() {   for (int i = 0; i <Register.length ; i++){ Register[i]=0; VariableName[i]="";} }
    //Constructor 1 parameter
    public Simulator(String filename) {
        for (int i = 0; i <Register.length ; i++){ Register[i]=0;VariableName[i]="";}
        Filename = filename;
        FOC.setInputFile(filename);
    }
    // Simulate all program input file converting and writing output file
    public void Simulate() throws IOException {
        customer.ReadData(getFilename());
        All_Data_Parser();
    }
    //Parsing line and working on it

    //This function returning emthy register
    public int returnEmthyRegister(){
        for (int i = 0; i < RegisterLastRecentUse.length ; i++)
            if(RegisterLastRecentUse[i] == 0)
                return i;
        return -1;
    }
    public void All_Data_Parser() throws IOException {
        String line = "";
        System.out.println("Size of Program " +  customer.data.size());

        for (int i = 0; i < customer.data.size(); i++) {

            line = code.RemoveSemicolonEndOFString( customer.data.get(i));
            String out[] = line.split(" "); // we cut our line of code for parsing

            //System.out.println("customer " + customer.data.get(i));

            if(true == lex.isWriteStmt(line)){
                System.out.println("Write sttmt");
                    for (int t = 0; t <VariableName.length ; t++) {
                       // System.out.println("1-Write sttmt  " +out[1]);
                       // System.out.println("2-Write sttmt  " +VariableName[t]);
                        //System.out.println("3-Write sttmt  " +t);

                        if(VariableName[t].equals(out[1]) == true)
                        {
                            FOC.WriteFile(IS.OUT(i,t,0,0));
                            break;
                        }
                    }
            }
            else if(true == lex.isReadStmt(line)){
                System.out.println("read sttmt");
                int index = returnEmthyRegister();

                FOC.WriteFile(IS.IN(i,Register[index],0,0));
                VariableName[index] = out[1];
                System.out.println( VariableName[index] + "*read**" +index );
                RegisterLastRecentUse[index] = -1; // used  register


            }
            else if(true == lex.repeatStmt(line)){
                //until görene kadar
                // aranan şart sağlanana kadar dönücek
                while (true){
                    break;
                }
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

                boolean flag = false;
                int j = 0;

                if(out.length >= 4 ){

                    //aritmetik işlem var demek
                    for (j = 0; j < 8 ; ++j) {
                       // System.out.println( VariableName[j] + "*loop**");

                        if(VariableName[j].equals(out[0])) {
                            flag = true;
                            System.out.println( "*true flag**");
                            break;
                        }
                    }
                    int par1 = 0,par2 = 0 ,par3 = 0 ;

                    if(flag == false){

                        par1 =  returnEmthyRegister();
                        //Register[returnEmthyRegister()] =
                        VariableName[par1] = out[0];
                        RegisterLastRecentUse[par1] = 1;

                       // Register[par1] =
                    }else {
                        par1 = j ;

                    }

                    if(true == lex.isId(out[2]) ){
                      int k = 0;
                        for ( k = 0; k < 8 ; k++) {
                            if(out[2]== VariableName[k]){
                                par2 = Register[k];
                                RegisterLastRecentUse[k] = 1;// register ın kullanıldığı anlama gelir
                                break;
                            }
                        }
                    }else {
                        par2 = Integer.parseInt(out[2]);

                    }

                    if(true == lex.isId(out[4]) ){
                        int t = 0;
                        for ( t = 0;t < 8 ; t++) {
                            if(out[4].equals(VariableName[t])){
                                par3 = t;
                                RegisterLastRecentUse[t] = 1;// register ın kullanıldığı anlama gelir
                                break;

                            }
                        }
                    }else {
                        par3 = Integer.parseInt(out[4]);
                    }

                   // System.out.println(out[3] + "**** ");

                    if(out[3].charAt(0) == '+'){
                        FOC.WriteFile(IS.ADD(i,par1,par2,par3));

                    }else if(out[3].charAt(0) == '-'){
                        FOC.WriteFile(IS.SUB(i,par1,par2,par3));

                    }else if(out[3].charAt(0) == '*'){
                        FOC.WriteFile(IS.MUL(i,par1,par2,par3));

                    }else if(out[3].charAt(0) == '/'){
                        FOC.WriteFile(IS.DIV(i,par1,par2,par3));

                    }

                   
                   // System.exit(1);
                }

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
