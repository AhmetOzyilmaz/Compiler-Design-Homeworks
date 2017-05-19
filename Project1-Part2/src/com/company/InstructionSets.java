package com.company;

/**
 * Created by ASUS on 6.05.2017.
 */
public class InstructionSets {


    public String IN(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": IN "+par1+","+par2+","+par3;
        return value;
    }

    //*************
    //RO Instructions sets
    //*************

    //4: ADD 2,2,1 ; now we have an odd number,TOP
    public String ADD(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": ADD "+par1+","+par2+","+par3;
        return value;
    }

    public String SUB(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": SUB "+par1+","+par2+","+par3;
        return value;
    }

    public String MUL(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": MUL "+par1+","+par2+","+par3;
        return value;
    }

    public String DIV(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": DIV "+par1+","+par2+","+par3;

        //chech divide zero
        return value;
    }

    //*************
    //RM Instructions
    //***************
    //14: LDA 7,-11(7) ; jump to top
    public String LD(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": LD "+par1+","+par2+"("+par3+")";

        //par1  LD 7,0(1)where pc is register #7
        return value;
    }

   //14: LDA 7,-11(7) ; jump to top
   public String LDA(int lineNum,int par1,int par2, int par3){
       //read integer value form standart input
       String value = "";
       value = lineNum+": LDA "+par1+","+par2+"("+par3+")";
       return value;
   }

    public String LDC(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": LDC "+par1+","+par2+"("+par3+")";
        return value;
    }

    public String ST(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": ST "+par1+","+par2+"("+par3+")";

        //par1  LD 7,0(1)where pc is register #7
        return value;
    }

    //3: JLE 5,11(7);jump to other
    public String JLE(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": JLE "+par1+","+par2+"("+par3+")";
        return value;
    }

    // 18: LDC 0,0(0) ;reg0=0;

    //22: JGT 6,5(7); if sum_odd > sum_even
    public String JGT(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": JGT "+par1+","+par2+"("+par3+")";
        return value;
    }

    public String JLT(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": JLT "+par1+","+par2+"("+par3+")";
        return value;
    }

    public String JEQ(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": JEQ "+par1+","+par2+"("+par3+")";
        return value;
    }

    public String JNE(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": JNE "+par1+","+par2+"("+par3+")";
        return value;
    }

    //***************

    //27: HALT 0,0,0;
    public String HALT(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": HALT "+par1+","+par2+","+par3;
        return value;
    }

    //17: OUT 0,0,0; write sum_even
    public String OUT(int lineNum,int par1,int par2, int par3){
        //read integer value form standart input
        String value = "";
        value = lineNum+": OUT "+par1+","+par2+","+par3;
        return value;
    }







}
