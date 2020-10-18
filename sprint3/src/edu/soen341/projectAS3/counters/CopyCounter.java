package edu.soen341.projectAS3.counters;

import edu.soen341.projectAS3.fileManager.IFileManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

class CopyCounter extends Counter{

    ArrayList<IFileManager> file = new ArrayList<>();
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

            if (opt.isEnabled() && opt.isRequired() && opt.getClass().getName().equals("VerboseOption")) {
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
