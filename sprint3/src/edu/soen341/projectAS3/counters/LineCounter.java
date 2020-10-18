package edu.soen341.projectAS3.counters;

import edu.soen341.projectAS3.fileManager.IFileManager;

import java.util.ArrayList;

//Counts the number of lines in file
class LineCounter extends Counter {

    //Returns the size of the ArrayList of lines
    @Override
    public void count(ArrayList<String> line){
        count = line.size();

        if (opt.isEnabled() && opt.isRequired()) {
            System.out.print("Verbose : ");
            for(int i = 0; i < count; i++)
                System.out.print("l");
        }

        System.out.println("\nLine Count : " + getCount()+"\n");
        count = 0;
    }

    @Override
    public void setFiles(ArrayList<IFileManager> file) {
    }

    @Override
    public void resetCount() {
        count = 0;
    }
}
