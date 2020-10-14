import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class CopyCounter extends Counter {
    @Override
    public void count(ArrayList<IFileManager> file, IOption opt) throws IOException, URISyntaxException {
        System.out.println("---------- Copy Counter Program ----------");
        int c;
        if(file != null){
            file.get(0).openInputStream();
            file.get(0).canReadFile();
            file.get(1).openOutputStream();
            if (opt.isEnabled() && opt.isRequired()) {
                System.out.print("Verbose : ");
            }
            while ( (c = file.get(0).getFileInStream().read()) != EOF ) {
                file.get(1).getFileOutStream().write(c);
                if(opt.isEnabled() && opt.isRequired()){
                    System.out.print(".");
                }
            }
            System.out.println("Copying Done");
            file.get(1).dstFilePath();
        }
    }
}
