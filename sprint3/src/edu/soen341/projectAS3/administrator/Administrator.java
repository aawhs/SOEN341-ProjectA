package edu.soen341.projectAS3.administrator;

import edu.soen341.projectAS3.counters.*;
import edu.soen341.projectAS3.fileManager.*;
import edu.soen341.projectAS3.options.*;

import java.util.ArrayList;

public class Administrator {
    private static final OptionFactory optionFactory = new OptionFactory();
    private static final CounterFactory counterFactory = new CounterFactory();
    private static CounterList counterList = new CounterList();

    private static IOption option;
    private static ICounter counter;

    ArrayList<IFileManager> file = new ArrayList<>();

    //Parses user input arguments to guide program into execute relevant counter
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
                counterList.setOpt(option);
            }else if(!arg.contains("-") && arg.contains(".")){
                file.add(new FileManager(arg));
            }else if(arg.contains(".")){
                file.add(new FileManager(arg));
            }
        }
        //Null option in case none is given
        if(option == null){
            option = optionFactory.getOption(null);
        }

        //If no counter is specified in arguments, assume wc
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

    public CounterList getCounterList(){return counterList;}

}
