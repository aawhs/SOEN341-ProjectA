// Project A - Sprint 1
// Student Name : Ahmed Ali
// Student ID  : 40102454
// wc.java - wordcount, linecount and charcount sourceFiles+


import java.io.*;
import java.util.*;
import java.net.*;


public class wcOO {

    private static ICounter counter;
    private static IOption option;
    private static ArrayList<IFileManager> file;
    private static ArrayList<String> data;
    private static Administrator admin;

    public static void main(String [] args) throws IOException, URISyntaxException {
        //args = new String[]{"copy","-v","test.txt", "testnew.txt"};
        admin = new Administrator();
        admin.parse(args);
        wcOO.init();
        wcOO.execute();
    }

    public static void init(){
        //Initializing Objects
        data = new ArrayList<>();
        counter = admin.getCounter();
        option = admin.getOption();
        file = admin.getFileList();

    }

    public static void execute() throws IOException, URISyntaxException {
        if(counter.getClass().getName().equals("Copy")) {
            for (IFileManager iFileManager : file) {
                iFileManager.openInputStream();
                BufferedReader fileReader = new BufferedReader(new FileReader(iFileManager.getFile().getPath()));
                while (fileReader.ready()) {
                    data.add(fileReader.readLine());
                }
                iFileManager.canReadFile();
                counter.setOpt(option);
                counter.count(data);
                data.clear();
            }
        }
        //Copy Program
        if(counter.getClass().getName().equals("Copy")){
            counter.setOpt(option);
            counter.setFiles(file);
            counter.count(data);
            return;
        }
        //Closing All Files
        for (IFileManager iFileManager : file)
            iFileManager.close();
    }
}
