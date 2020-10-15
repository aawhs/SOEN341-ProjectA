import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class CharCounter extends Counter {

    @Override
    public void count(ArrayList<IFileManager> file, IOption opt) throws IOException, URISyntaxException {
        System.out.println("\n---------- Character Counter Program ----------");
        count = 0;
        optConfig(opt);
        opt.process();
        if(file != null){
            for (IFileManager iFileManager : file) {
                iFileManager.openInputStream();
                iFileManager.canReadFile();
                if (opt.isEnabled() && opt.isRequired()) {
                    System.out.print("Verbose : ");
                }
                while ((iFileManager.getFileInStream().read()) != EOF) {
                    ++count;
                    if (opt.isEnabled() && opt.isRequired()) {
                        System.out.print("c");
                    }
                }
                System.out.println("\nCharacters Count: " + getCount());
                count = 0;
            }
        }
    }

    @Override
    public void optConfig(IOption opt){
        if(opt.isEnabled()){
            opt.setUsage("CommandLine = wcOO charcount [Option] {SourceFilePath+}");
            opt.setClassName("charcount");

        }

    }
}
