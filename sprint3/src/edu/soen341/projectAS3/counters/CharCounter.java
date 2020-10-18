package edu.soen341.projectAS3.counters;

import edu.soen341.projectAS3.fileManager.IFileManager;

import java.util.ArrayList;

//Return the number of characters in the file
class CharCounter extends Counter {
    @Override
    public void count(ArrayList<String> line){
        //Count override method splits file into lines, and lines into characters, while ignoring whitespaces
        for (String s : line) {
            for (int j = 0; j < s.length(); j++) {
                if (!isSpace((int) s.charAt(j))) {
                    ++count;
                }
            }
        }

        //Verifies for verbose option
        if (opt.isEnabled() && opt.isRequired()) {
            System.out.print("Verbose : ");
            for(int i = 0; i < count; i++)
                System.out.print("c");
        }

        //Print character count
        System.out.println("\nCharacter Count : " + getCount()+"\n");
        count = 0;
    }

    @Override
    public void resetCount() {
        count = 0;
    }

    @Override
    public void setFiles(ArrayList<IFileManager> file) {

    }

}
