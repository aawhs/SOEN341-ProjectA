import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Administrator{
    OptionFactory optionFactory = new OptionFactory();
    CounterFactory counterFactory = new CounterFactory();

    IOption option;
    ICounter counter;

    IFilePath[] file = new FilePath[9];

    public static void main(String[] args) throws IOException, URISyntaxException {
        args = new String[]{"charcount","test.txt"};
        Administrator admin = new Administrator();
        admin.parse(args);
    }

    //This is vily's comment
    //hi
    //Needs Comments
    public void parse(String[] args) throws IOException, URISyntaxException {

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
                for(int j = 0; j< args.length-1 ; j++){
                    if(counter.getClass().getName().equals("CopyCounter")){
                        if(option.isEnabled()){
                            file[j] = new FilePath(args[i+2]);
                            counter.process(file, args[i+3], option);
                            break;
                        }
                        file[j] = new FilePath(args[i+1]);
                        counter.process(file, args[i+2], option);
                        break;
                    }else if(option != null){
                        file[j] = new FilePath(args[j+2]);
                        break;
                    }
                    file[j] = new FilePath(args[j+1]);
                }
                if(option != null) {
                    counter.process(file, option);
                }
                counter.process(file);
            }
            return;

        }

        for(int i = 0; i < file.length ; i++){
            file[i].close();
        }
    }




}
