package edu.soen341.projectAS3.counters;

import edu.soen341.projectAS3.fileManager.IFileManager;

import java.util.ArrayList;

//Returns the number of words in the file
class WordCounter extends Counter {
    @Override
    public void count(ArrayList<String> line){
        char[] characters;
        //For every line in the ArrayList of lines, count number of words
        for (String s : line) {
            characters = s.toCharArray();
            for (int j = 0; j < characters.length; j++) {
                //Verify if word
                if (Character.isLetter(characters[j]) && j != characters.length - 1) {
                    isWord = true;
                } else if (!Character.isLetter(characters[j]) && isWord) {
                    count++;
                    isWord = false;
                } else if (Character.isLetter(characters[j]) && j == characters.length - 1) {
                    count++;
                }
            }
        }

        if (opt.isEnabled() && opt.isRequired()) {
            System.out.print("Verbose : ");
            for(int i = 0; i < count; i++)
                System.out.print("w");
        }

        System.out.println("\nWords Count : " + getCount()+"\n");
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
