package edu.soen341.projectAS3.fileManager;

import java.io.*;
import java.net.URISyntaxException;

//Interface outline the required methods for the FileManager child class
public interface IFileManager {
    String getFileName();
    boolean canReadFile();
    boolean isOpen();
    void setFilePath() throws URISyntaxException;
    void openFile() throws URISyntaxException;
    File getFile();
    void openInputStream() throws FileNotFoundException, URISyntaxException;
    void openOutputStream() throws FileNotFoundException, URISyntaxException;
    void close() throws IOException;
    void dstFilePath();
    FileInputStream getFileInStream();
    FileOutputStream getFileOutStream();
}

