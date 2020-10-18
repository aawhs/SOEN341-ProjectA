package edu.soen341.projectAS3.counters;

import edu.soen341.projectAS3.fileManager.IFileManager;
import edu.soen341.projectAS3.options.IOption;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

//Counter interface, outlines list of methods to be implemented in child class
public interface ICounter {
    int EOF = -1;
    void count(ArrayList <String> line) throws IOException, URISyntaxException;
    void resetCount();
    void setFiles(ArrayList<IFileManager> file);
    void setOpt(IOption opt);
    Integer getCount();
}

