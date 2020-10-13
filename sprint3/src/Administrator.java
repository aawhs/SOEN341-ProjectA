import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Administrator{
    OptionFactory optionFactory = new OptionFactory();
    CounterFactory counterFactory = new CounterFactory();

    IOption option;
    ICounter counter;

    //IFilePath[] file;

    ArrayList<IFilePath> file = new ArrayList<>();

    public static void main(String[] args) throws IOException, URISyntaxException {
        args = new String[]{"charcount","-v","test.txt", "testcopy.txt"};
        Administrator admin = new Administrator();
        admin.parse(args);
        admin.process();
    }

    //needs comments
    public void parse(String[] args) throws IOException, URISyntaxException {

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
        if (!option.isEnabled()) {
            for (int i = 1; i < args.length; i++) {
                file.add(new FilePath(args[i]));
            }
        } else {
            for (int i = 2; i < args.length; i++) {
                file.add(new FilePath(args[i]));
            }
        }
    }

    public void process() throws IOException {
        //Processing All Files
        for (IFilePath iFilePath : file)
            counter.process(iFilePath, option);


        //Closing All Files
        for (IFilePath iFilePath : file)
            iFilePath.close();
    }

    /*

        if(args.length == 0)
            return;
        for(int i = 0; i < args.length; i++){
            if(args[i] != null){
                for(int k = 0; k< args.length; k++){
                    if(args[k].contains("-")){
                        option = optionFactory.getOption(args[k]);
                        option.process();
                    }else if(option == null){
                        option = optionFactory.getOption(null);
                    }
                }
                counter = counterFactory.getCounter((args[i]));
                for(int j = 0; j< args.length ; j++){
                    if(counter.getClass().getName().equals("CopyCounter")){
                        if(option.isEnabled()){
                            file[j] = new FilePath(args[i+2]);
                            counter.process(file, args[i+3], option);
                            break;
                        }
                        file[j] = new FilePath(args[i+1]);
                        counter.process(file, args[i+2], option);
                        break;
                    }else if(!option.isEnabled()){
                        file[j] = new FilePath(args[j+1]);
                        break;
                    }else{
                        file[j] = new FilePath(args[j+2]);
                        break;
                    }
                }
                if(!option.isEnabled()) {
                    counter.process(file, option);
                }else{
                    counter.process(file, option);
                }

            }
            return;

        }

        for(int i = 0; i < file.length ; i++){
            file[i].close();
        }
    }



     */
}
