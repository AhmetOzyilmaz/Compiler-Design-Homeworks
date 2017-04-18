
/**
 * Created by ASUS on 25.03.2017.
 */
public class CodeGen {
    //this class helpfull function for out parser
    public String DeleteSpaceStartOfString(String s) {
        int i;
        for (i = 0; i <s.length() ; i++) {
            if(s.charAt(i) != ' '){
                break;
            }
        }
        String newS = s.substring(i, s.length());
        return newS;
    }

    public String RemoveSemicolonEndOFString(String s){

        if(s.charAt(s.length()-1)==(';')){
            s= s.replace(";", "");
            s+= " ;";
        }
        return s;
    }
}
