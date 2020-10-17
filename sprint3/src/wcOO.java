import java.io.*;
import java.util.*;
import java.net.*;


public class wcOO {

    private static ICounter counter;
    private static IOption option;
    private static Composite counterList;
    private static ArrayList<IFileManager> file;
    private static ArrayList<String> data;
    private static Administrator admin;

    public static void main(String [] args) throws IOException, URISyntaxException {
        //args = new String[]{"charcount","-v","test.txt", "testingComposite.txt"};
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
        counterList = admin.getCounterList();

    }

    public static void execute() throws IOException, URISyntaxException {
        if(!counter.getClass().getName().equals("CopyCounter")) {
            for (IFileManager iFileManager : file) {
                iFileManager.openInputStream();
                BufferedReader fileReader = new BufferedReader(new FileReader(iFileManager.getFile().getPath()));
                while (fileReader.ready()) {
                    data.add(fileReader.readLine());
                }
                iFileManager.canReadFile();
                counterList.setOpt(option);
                counterList.count(data);
                data.clear();
            }
        }
        //Copy Program
        if(counter.getClass().getName().equals("CopyCounter")){
            counterList.setOpt(option);
            counterList.setFiles(file);
            counterList.count(data);
            return;
        }
        //Closing All Files
        for (IFileManager iFileManager : file)
            iFileManager.close();
    }
}
