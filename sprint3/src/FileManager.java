import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileManager implements IFileManager {

    Path srcPath;
    private URL filePathSystem;
    private String fileName;
    private File srcFile;
    private File dstFile;
    private FileInputStream srcStream;
    private FileOutputStream dstStream;
    private BufferedReader reader;



    FileManager(String args) {
        this.fileName = args;
    }

    //Methods
    public void setFilePath() {
        srcPath = Paths.get(fileName);
        filePathSystem = ClassLoader.getSystemResource(srcPath.toString());
    }

    public void openFile() throws URISyntaxException {

            srcFile = new File(filePathSystem.toURI());

    }

    public void openInputStream() throws FileNotFoundException, URISyntaxException {
        setFilePath();
        openFile();
        assert canReadFile();
        srcStream = new FileInputStream(srcFile);
        assert isOpen();
    }

    public void openOutputStream() throws FileNotFoundException {
        dstFile = new File(fileName);
        dstStream = new FileOutputStream(dstFile);
    }

    public void close() throws IOException {
        if(srcStream != null)
            srcStream.close();
        if(dstStream != null)
            dstStream.close();
    }

    public void reset() throws IOException, URISyntaxException {
        srcStream.close();
        openInputStream();
    }

    public File getFile(){
        return this.srcFile;
    }

    public FileInputStream getFileInStream() {
        return this.srcStream;
    }

    public FileOutputStream getFileOutStream(){
        return  this.dstStream;
    }

    public String getAbsolutePath(){
        if(dstFile != null)
            return dstFile.getAbsolutePath();
        else if (srcFile != null)
            return srcFile.getAbsolutePath();
        else
            return "No Path";
    }

    public String getFileName(){
        return this.fileName;
    }

    public void setBufferedReader() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(getFile()));
    }
    public BufferedReader getBufferedReader(){
      return reader;
    }


    @Override
    public boolean canReadFile() {
        if (!srcFile.canRead()) {
            System.out.println("\nSource File");
            System.out.println("Cannot open srcFile '" + srcFile.getName() + "'");
            return false;
        }
        System.out.println("\nSource File");
        System.out.println("[OK] srcFilePath = '" + getAbsolutePath() +"'\n"+
                "[OK] srcFileName = '" + srcFile.getName() + "'");
        return true;

    }

    public void dstFilePath(){
        System.out.println("\nDestination File");
        System.out.println("[OK] dstFilePath = '" + getAbsolutePath() +"'\n"+
                "[OK] dstFileName = '" + dstFile.getName() + "'");
    }

    @Override
    public boolean isOpen() {
        if (srcStream != null) {
            return true;
        }
        System.out.println("\nCannot open srcFile '" + fileName + "'");
        return false;
    }


}
