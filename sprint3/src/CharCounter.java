import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class CharCounter extends Counter {

    @Override
    public void count(ArrayList<IFileManager> file, IOption opt) throws IOException, URISyntaxException {
        System.out.println("\n---------- Character Counter Program ----------");
        count = 0;
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
                System.out.print("Characters Count: " + getCount());
                count = 0;
            }

        }
    }
}
