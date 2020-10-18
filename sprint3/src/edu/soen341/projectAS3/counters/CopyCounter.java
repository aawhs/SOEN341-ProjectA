package edu.soen341.projectAS3.counters;

import edu.soen341.projectAS3.fileManager.IFileManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

//CopyCounter copies the contents of a source file into the destination file
class CopyCounter extends Counter{

    //Contains all files listed in arguments, such as source file and destination file
    ArrayList<IFileManager> file = new ArrayList<>();
    //Count method overriden to copy file contents line by line to destination file
    @Override
    public void count(ArrayList<String> line) throws IOException, URISyntaxException {
        System.out.println("---------- Copy Program ----------");
        int c;
        if(file != null){
            file.get(0).openInputStream();
            file.get(0).canReadFile();
            file.get(1).openOutputStream();

            while ( (c = file.get(0).getFileInStream().read()) != EOF ) {
                file.get(1).getFileOutStream().write(c);
                count++;
            }
            //Verifies for verbose option
            if (opt.isEnabled() && opt.isRequired()) {
                System.out.print("Verbose : ");
                for(int i = 0; i <= count; i++)
                    System.out.print(".");
            }

            System.out.println("\nCopying Done");
            file.get(1).dstFilePath();
        }
    }

    @Override
    public void resetCount() {
        count = 0;
    }

    @Override
    public void setFiles(ArrayList<IFileManager> file){
        this.file = file;
    }

}
