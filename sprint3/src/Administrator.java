import java.util.ArrayList;

public class Administrator {
    private static final OptionFactory optionFactory = new OptionFactory();
    private static final CounterFactory counterFactory = new CounterFactory();
    private static Composite counterList = new Composite();

    private static IOption option;
    private static ICounter counter;

    ArrayList<IFileManager> file = new ArrayList<>();

    //needs comments
    public void parse(String[] args){

        //Asserting Arguments
        if (args.length == 0) {
            System.out.println("CommandLine = wcOO CommandName { Option } { Argument }");
            return;
        }

        //Instantiating Counter Object
        for (String arg : args) {
            if (!arg.contains(".") && !arg.contains("-")) {
                counter = counterFactory.createCounter(arg);
                counterList.add(counter);
            }else if (arg.contains("-")) {
                //Instantiating Option Object
                option = optionFactory.getOption(arg);
                option.setClassName(counter.getClass().getName());
                option.process();
            } else if(arg.contains(".")){
                //Instantiating File Objects
                file.add(new FileManager(arg));
            } else {
                option = optionFactory.getOption(null);
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

    public Composite getCounterList(){return counterList;}

}
