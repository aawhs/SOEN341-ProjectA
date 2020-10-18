package edu.soen341.projectAS3.counters;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

//Composite pattern creates objects of counters mentioned in arguments and adds to list
public class Composite extends Counter{

    List<ICounter> counters= new ArrayList<>();

    //Adds the counter object to the list
    public void add(ICounter obj) {
        this.counters.add(obj);
    }

    //Removes the counter object from the list
    public void remove(ICounter obj) {
        this.counters.remove(obj);
    }

    //For all counter objects in the list, call their count methods
    @Override
    public void count(ArrayList<String> line) throws IOException, URISyntaxException {
        for(ICounter obj:counters) {
            obj.setOpt(opt);
            obj.setFiles(files);
            obj.count(line);
        }
    }

    //Returns list of counters
    public List<ICounter> getList(){
        return counters;
    }

}