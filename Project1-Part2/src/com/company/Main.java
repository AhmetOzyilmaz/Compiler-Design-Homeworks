package com.company;

import com.company.ProjectPart2.FileOperationClass;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        if(args.length != 1)
        {
            System.out.print("Usage ./Simulate input.c\n" + args.length);
            System.exit(0);
        }
        else if(args.length == 1)
        {
            String filename = args[0];
            Simulator Sim = new Simulator(filename);

            Sim.Simulate();
            //Simulate sim(filename,mode);
           // sim.cpuRun();
        }
    }
}
