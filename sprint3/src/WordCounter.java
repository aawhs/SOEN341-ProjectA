import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class WordCounter extends Counter {

    @Override
    public void count(ArrayList<IFileManager> file, IOption opt) throws IOException, URISyntaxException {
        System.out.println("\n---------- Word Counter Program ----------");

        optConfig(opt);
        opt.process();

        int character;
            count = 0;
            if(file != null) {
                for (IFileManager iFileManager : file) {
                    iFileManager.openInputStream();
                    iFileManager.canReadFile();
                    if (opt.isEnabled() && opt.isRequired()) {
                        System.out.print("Verbose : ");
                    }
                while ((character = iFileManager.getFileInStream().read()) != EOF) {

                        if (isSpace(character)) {
                            if (!whiteSpace) {
                                whiteSpace = true;
                                ++count;
                                if (opt.isEnabled() && opt.isRequired()) {
                                    System.out.print("w");
                                }
                            }
                            whiteSpace = false;
                        }
                    }
                    System.out.println("\nWords Count : " + getCount());
                    count = 0;
                }

            }
    }

    @Override
    public void optConfig(IOption opt){
        if(opt.isEnabled()){
            opt.setUsage("CommandLine = wcOO wordcount [Option] {SourceFilePath+}");
            opt.setClassName("wordcount");
        }

    }
}
