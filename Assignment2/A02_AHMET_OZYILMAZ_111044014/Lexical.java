
/**
 * Created by ASUS on 25.03.2017.
 */
public class Lexical {

    public Lexical(){

    }
    public boolean isFactor(String line){

        if(isId(line) || isNum(line))
            return true;

        return false;
    }

    public boolean isId(String word){
        // System.out.println("is identifier function parameter ---> " +word);


        for (int i = 0 ; i< word.length();++i )
        {
            // System.out.println(word.charAt(i));

            if(false  == Character.isLetter(word.charAt(i))){

                return false;
            }
        }
        return true;
    }
    public boolean isNum(String word){

        for (int i = 0 ; i< word.length();++i )
        {
            if(false == Character.isDigit(word.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public boolean isEos(String word){
        if(word.equals(";"))
            return true;

        return false;
    }
    public boolean isaddop(String word){

        if(word.charAt(0)=='+' || word.charAt(0)=='-')
            return true;
        return false;
    }
    public boolean ismulop(String word){
        if(word.charAt(0)=='*' || word.charAt(0)=='/')
            return true;
        return false;
    }
    public boolean isassignnop(String word){
        if(word.equals(":="))
            return true;
        return false;
    }



    public boolean isTerm(String input){

        String out[] = input.split(" "); // we cut our line of code for parsing

        if(isFactor(out[0])== true && ismulop(out[1]) == true && isFactor(out[2]))
            return true;

        return false;
    }
    public boolean isExpression(String input){
        String out[] = input.split(" "); // we cut our line of code for parsing

        String par1 = out[0]+" "+out[1]+" "+" "+out[2];
        String par2 = out[4]+" "+out[5]+" "+" "+out[6];

        //String par1Term,String par2Addop, String par3Term
        if(isTerm(par1)== true && isaddop(out[3]) == true && isTerm(par2))
            return true;

        return false;
    }

    public boolean isReadStmt(String input){
        String out[] = input.split(" "); // we cut our line of code for parsing
        if(out[0].equals("read") && isId(out[1]))
            return true;
        return false;
    }
    public boolean isWriteStmt(String input){
        String out[] = input.split(" "); // we cut our line of code for parsing
        if(out[0].equals("read") && isId(out[1]))
            return true;
        return false;
    }
    public boolean assignStmt(String input){
        String out[] = input.split(" "); // we cut our line of code for parsing
        String exp ="";

        for (int i=2 ; i< out.length; ++i)
            exp+=out[i]+" ";

        if(isId(out[0])== true && isassignnop(out[1]) && isExpression(exp))
            return true;
        return false;
    }
    public boolean isStmt(String input){

        if(assignStmt(input)==true || isWriteStmt(input)== true)
            return true;
        return false;
    }
    public boolean isStrmts(String input){
        String out[] = input.split(" "); // we cut our line of code for parsing
        String stmt ="";
        int i = 0;

        for ( i = 0; i <out.length-1 ; i++) {
           if(isEos(out[i]) == true)
               break;
            stmt+=out[i]+" ";
        }
        String Strmts ="";

        for (int k = i+1; k <out.length ; k++) {
            Strmts += out[k]+" ";
        }
        if(isEos(out[i]) && isStmt(stmt) && isStrmts(Strmts))
            return true;
        else if(isStmt(stmt)  && isEos(out[out.length-1]))
            return true;

        return false;
    }
    
   /*
        *   program --> stmts
    * */

}