import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by ASUS on 25.03.2017.
 */
public class Semantic {
    public Lexical useFunc = new Lexical();
    private Vector<String> data = new Vector<>();

    public void Syntex_Tree_Parse(String line,Integer line_Num) throws Exception {
        int my_space_counter = 1;
        if(line.charAt(line.length()-1)==(';')){
            line= line.replace(";", "");
            line+= " ;";
        }
        String out[] = line.split(" "); // we cut our line of code for parsing
        for (int i = 0; i< out.length; ++i){

            if(out[i].equals("read") && useFunc.isId(out[i+1])){
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

        if(line.charAt(line.length()-1)==(';')){
            line= line.replace(";", "");
            line+= " ;";
        }
        String out[] = line.split(" "); // we cut our line of code for parsing
        Error_Check_Source( out,line_Num);

        for (int j = 0; j < out.length ; ++ j){

            if(out[j].equals("write") || out[j].equals("read")){
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

}
