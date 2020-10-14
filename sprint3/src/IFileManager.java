import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface IFileManager {
    boolean canReadFile();
    boolean isOpen();
    void setFilePath() throws URISyntaxException;
    void openFile() throws URISyntaxException;
    void openInputStream() throws FileNotFoundException, URISyntaxException;
    void openOutputStream() throws FileNotFoundException, URISyntaxException;
    void close() throws IOException;
    void reset() throws IOException, URISyntaxException;
    void dstFilePath();
    FileInputStream getFile();
    FileOutputStream getFileOutStream();
}

