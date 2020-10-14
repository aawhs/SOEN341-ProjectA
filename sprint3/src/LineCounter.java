import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class LineCounter extends Counter {

    @Override
    public void process(ArrayList<IFileManager> file, IOption opt) throws IOException, URISyntaxException {
        System.out.println("\n---------- Line Counter Program ----------");
        int character;

            count = 0;
            if (file != null) {
                for (IFileManager iFileManager : file) {
                    iFileManager.openInputStream();
                    iFileManager.canReadFile();
                    if (opt.isEnabled() && opt.isRequired()) {
                        System.out.print("Verbose : ");
                    }
                    while ((character = iFileManager.getFile().read()) != EOF) {
                        if (character == '\n') {
                            ++count;
                            if (opt.isEnabled() && opt.isRequired()) {
                                System.out.print("l");
                            }
                        }
                    }
                    System.out.println("\nLines: " + (getCount() + 1));
                    count = 0;
                }

            }


    }
}
