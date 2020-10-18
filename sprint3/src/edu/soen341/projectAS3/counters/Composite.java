package edu.soen341.projectAS3.counters;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Composite extends Counter{

    List<ICounter> counters= new ArrayList<>();


    public void add(ICounter obj) {
        this.counters.add(obj);
    }

    public void remove(ICounter obj) {
        this.counters.remove(obj);
    }


    @Override
    public void count(ArrayList<String> line) throws IOException, URISyntaxException {
        for(ICounter obj:counters) {
            obj.setOpt(opt);
            obj.setFiles(files);
            obj.count(line);
        }
    }

    public List<ICounter> getList(){
        return counters;
    }

}