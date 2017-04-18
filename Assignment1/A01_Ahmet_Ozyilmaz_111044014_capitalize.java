package com.company;

import java.io.*;
import java.util.Vector;

/**
 * Created by ASUS on 1.03.2017.
 */
public class A01_Ahmet_Ozyilmaz_111044014_capitalize {

    private Vector<Character> data = new Vector<>();

    public static void main(String[] args) throws IOException {
        // write your code here

        if(args.length == 0)
        {
            System.out.println("Proper Usage is: java program filename.c");
            System.exit(0);
        }
        else  {

            A01_Ahmet_Ozyilmaz_111044014_capitalize customer=new A01_Ahmet_Ozyilmaz_111044014_capitalize();
            customer.DoCapitalizeComment(args[0]);

          // System.out.print(args[0]);
        }

    }
    public void ReadDate(String filename){
        try {
            FileReader reader = new FileReader(filename);
            int character;

            while ((character = reader.read()) != -1) {

                data.add((char) character);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void WriteDate(String filename) throws IOException{

        FileOutputStream writer = new FileOutputStream(filename);
        writer.write(("").getBytes());
        writer.close();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {

            //String content = "This is the content to write into file\n";

            for (int i = 0 ; i< data.size();++i) {
                //   System.out.print(data.get(i));
                bw.write(data.get(i));

            }

            // no need to close it.
            //bw.close();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }
    public void DoCapitalizeComment(String filename) throws IOException {
        boolean f1= false;
        ReadDate(filename);

        for (int i = 1 ; i< data.size();++i){
            if(f1 ==true ){
                data.set(i,Character.toUpperCase(data.get(i)));
                //System.out.println(data.get(i));

            }
            if(data.get(i)=='*'&& data.get(i-1) =='/'){
                f1 = true;
            }
            else if(data.get(i-1)=='*'&& data.get(i) =='/'){
                f1 = false;
            }

        }

        for (int i = 0 ; i< data.size();++i) {
            System.out.print(data.get(i));

        }
        WriteDate(filename);
    }

}
