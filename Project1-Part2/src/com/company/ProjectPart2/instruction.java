package com.company.ProjectPart2;

/**
 * Created by ASUS on 1.05.2017.
 */
public class instruction {
    instruction(int i,String s,int a,int b,int c){
        index=i;
        command=s;
        A = a;
        B = b;
        C = c;
    }

    int index;
    String command;                  //like "ADD" ,"SET" ...
    int A;
    int B;
    int C;
}


