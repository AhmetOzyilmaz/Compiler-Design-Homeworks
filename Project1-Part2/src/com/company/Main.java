package com.company;

import com.company.ProjectPart2.FileOperationClass;

public class Main {

    public static void main(String[] args) {
	// write your code here

        if(args.length != 1)
        {
            System.out.print("Usage ./Simulate input.c\n" + args.length);
            System.exit(0);
        }
        else if(args.length == 1)
        {
            String filename = args[0];
            FileOperationClass.Simulator Sim = new FileOperationClass.Simulator(filename);

            Sim.Simulate();
            //Simulate sim(filename,mode);
           // sim.cpuRun();
        }
    }
}
