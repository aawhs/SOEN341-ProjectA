import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface IFilePath {
    boolean canReadFile();
    boolean isOpen();
    void getFilePath(String args) throws URISyntaxException;
    void openFile() throws URISyntaxException;
    void open() throws FileNotFoundException, URISyntaxException;
    void close() throws IOException;
    void reset() throws IOException, URISyntaxException;
    FileInputStream getFile();

}

