import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Administrator {
    private static OptionFactory optionFactory = new OptionFactory();
    private static CounterFactory counterFactory = new CounterFactory();

    private static IOption option;
    private static ICounter counter;

    ArrayList<IFileManager> file = new ArrayList<>();

    /*
    public static void main(String[] args) throws IOException, URISyntaxException {
        args = new String[]{"wc", "-v", "test.txt","testnew.txt"};
        Administrator admin = new Administrator();
        admin.parse(args);
    }

     */

    //needs comments
    public void parse(String[] args){

        //Asserting Arguments
        if (args.length == 0) {
            System.out.println("CommandLine = wcOO CommandName { Option } { Argument }");
            return;
        }

        //Instantiating Counter Object
        counter = counterFactory.getCounter(args[0]);

        //Instantiating Option Object
        if (args[1].contains("-")) {
            option = optionFactory.getOption(args[1]);
        } else {
            option = optionFactory.getOption(null);
        }

        //Instantiating File Objects
        int j = 0;
        if (!option.isEnabled()) {
            for (int i = 1; i < args.length; i++) {
                file.add(new FileManager(args[i]));
            }
        } else {
            for (int i = 2; i < args.length; i++) {
                file.add(new FileManager(args[i]));
            }
        }
    }


    public ICounter getCounter(){
        return counter;
    }

    public IOption getOption(){
        return option;
    }

    public ArrayList<IFileManager> getFileList(){
        return file;
    }

}
