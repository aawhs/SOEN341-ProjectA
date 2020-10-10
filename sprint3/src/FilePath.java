import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePath implements IFilePath {

    FilePath(String args) throws URISyntaxException, FileNotFoundException {
        getFilePath(args);
        open();
    }

    //Methods
    public void getFilePath(String args) throws URISyntaxException {
        Path srcPath = Paths.get(args);
        Path fileName = srcPath.getFileName();
        path = ClassLoader.getSystemResource(fileName.toString());
        path.toURI();
    }

    public void openFile() throws URISyntaxException {
        srcFile = new File(this.path.toURI());
    }

    public void open() throws FileNotFoundException, URISyntaxException {
        openFile();
        assert canReadFile();
        srcStream = new FileInputStream(srcFile);
        assert isOpen();
    }

    public void close() throws IOException {
        srcStream.close();
    }

    public void reset() throws IOException, URISyntaxException {
        srcStream.close();
        open();
    }

    public FileInputStream getFile() {
        return this.srcStream;
    }


    @Override
    public boolean canReadFile() {
        if (!srcFile.canRead()) {
            System.out.println("Cannot open srcFile '" + srcFile.getName() + "'");
            return false;
        }
        System.out.println("[OK] srcFilename = '" + srcFile.getName() + "'");
        return true;

    }

    @Override
    public boolean isOpen() {
        if (srcStream != null) {
            System.out.println("srcFilename = '" + srcFile.getName() + "'");
            return true;
        }
        System.out.println("Cannot open srcFile '" + srcFile.getName() + "'");
        return false;
    }


    private File srcFile;
    private FileInputStream srcStream;
    private URL path;

}
