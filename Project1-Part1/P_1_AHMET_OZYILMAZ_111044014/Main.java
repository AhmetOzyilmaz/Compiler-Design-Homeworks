
public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here

        if(args.length == 0)
        {
            System.out.println("Proper Usage is: java program filename.c");
            System.exit(0);
        }
        else  {

            Semantic customer=new Semantic();
            customer.ReadData(args[0]);
            try {
                customer.Program(args[0]);
            } catch (Exception e) {
                System.out.println("Exception caughted" + e.toString() + " " + e.getStackTrace()[0
                        ].getLineNumber());            }
        }

    }
}
