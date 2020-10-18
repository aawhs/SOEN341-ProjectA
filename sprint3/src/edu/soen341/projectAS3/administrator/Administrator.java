package edu.soen341.projectAS3.administrator;

import edu.soen341.projectAS3.counters.*;
import edu.soen341.projectAS3.fileManager.*;
import edu.soen341.projectAS3.options.*;

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
                option.setClassName(counterList.getClass().getName());
                option.process();
                counterList.setOpt(option);
            }else if(!arg.contains("-") && arg.contains(".")){
                file.add(new FileManager(arg));
            }else if(arg.contains(".")){
                file.add(new FileManager(arg));
            }
        }

        if(option == null){
            option = optionFactory.getOption(null);
        }

        if(counter == null){
            counter=counterFactory.createCounter("wc");
            counterList.add(counter);
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
