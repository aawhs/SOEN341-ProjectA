import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Administrator {
    OptionFactory optionFactory = new OptionFactory();
    CounterFactory counterFactory = new CounterFactory();

    IOption option;
    ICounter counter;

    ArrayList<IFileManager> file = new ArrayList<>();

    public static void main(String[] args) throws IOException, URISyntaxException {
        args = new String[]{"wc", "-v", "test.txt"};
        Administrator admin = new Administrator();
        admin.parse(args);
        admin.execute();
    }

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
            option.process();
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

    public void execute() throws IOException, URISyntaxException {
        //Processing All Files
        counter.count(file, option);

        //Closing All Files
        for (IFileManager iFileManager : file)
            iFileManager.close();
    }
}
