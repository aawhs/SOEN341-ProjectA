import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class LineCounter extends Counter {

    @Override
    public void process(ArrayList<IFileManager> file, IOption opt) throws IOException, URISyntaxException {
        System.out.println("\n---------- Line Counter Program ----------");

            count = 0;
            if (file != null) {
                for (IFileManager iFileManager : file) {
                    iFileManager.openInputStream();
                    iFileManager.canReadFile();
                    iFileManager.setBufferedReader();
                    if (opt.isEnabled() && opt.isRequired()) {
                        System.out.print("Verbose : ");
                    }
                    while ((iFileManager.getBufferedReader().readLine() != null)) {
                            ++count;
                            if (opt.isEnabled() && opt.isRequired()) {
                                System.out.print("l");
                            }
                    }
                    System.out.println("\nLines: " + (getCount()));
                    count = 0;
                }

            }


    }
}
