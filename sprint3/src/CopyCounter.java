import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyCounter extends Counter {

    @Override
    public void process(IFilePath[] file) throws IOException {
    }

    @Override
    public void process(IFilePath[] file, IOption opt) throws IOException {

    }

    @Override
    public void process(IFilePath[] file, Object dstFileName, IOption opt) throws IOException {
        File dstFile = new File((String) dstFileName);
        FileOutputStream dstStream = new FileOutputStream(dstFile);


        int c;
        file[0].canReadFile();
        while ( (c = file[0].getFile().read()) != EOF ) {
            dstStream.write(c);
            if(opt.isEnabled() && opt.isRequired()){
                System.out.print(".");
            }
        }
        System.out.println("Copy Done");
    }
}
