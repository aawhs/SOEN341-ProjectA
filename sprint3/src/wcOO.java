// Project A - Sprint 1
// Student Name : Ahmed Ali
// Student ID  : 40102454
// wc.java - wordcount, linecount and charcount sourceFiles+


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class wcOO {

    private static ICounter counter;
    private static IOption option;
    private static ArrayList<IFileManager> file;
    private static Administrator admin;

    public static void main(String [] args) throws IOException, URISyntaxException {
        args = new String[]{"wc", "test.txt"};
        admin = new Administrator();
        admin.parse(args);
        wcOO.execute();
    }

    public static void execute() throws IOException, URISyntaxException {
        //Initializing Objects
        counter = admin.getCounter();
        option = admin.getOption();
        file = admin.getFileList();

        //Processing All Files
        counter.count(file, option);

        //Closing All Files
        for (IFileManager iFileManager : file)
            iFileManager.close();
    }
}
