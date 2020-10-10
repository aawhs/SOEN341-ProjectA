// Project A - Sprint 1
// Student Name : Ahmed Ali
// Student ID  : 40102454
// charcount.java - Character count of sourcefile


import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class charcount {
    private static final int EOF = -1;
    private static File srcFile = null;
    private static String srcFilename = "<srcFilename>";

    public static void main(String[] args) throws IOException, URISyntaxException {
        //Check number of arguments
        if (args.length != 1){

            System.out.println("Usage: charcount {SourccFilePath}");
            return;
        }
        //Check if arguments are valid, if the srcFile exists
        if (args[0] != null) { // Check <src>
            //Help abstractOptions
            if ((args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) {

                System.out.println("Usage: charcount {SourceFilePath}");
                System.out.println("or	   charcount [options]");
                System.out.println("[options] = '?' or '-h' or 'help' ");
                return;
            } else if((!args[0].contains(".txt"))){
                System.out.println("Error : Invalid Argument or Option Unknown");
                System.out.println("try 'wc -help' or 'wc -h' or 'wc -?'");
                return;
            }
            srcFilename = args[0];

            //Getting Absolute path from argument (if file exists in the same folder as class)
            Path srcPath = Paths.get(srcFilename);
            Path fileName = srcPath.getFileName();
            URL path = ClassLoader.getSystemResource(fileName.toString());
            path.toURI();
            srcFile = new File(path.toURI());

            System.out.println("charcount: srcFilename = '" + srcFile.getName() + "'");
            if (!srcFile.canRead()) {
                System.out.println("charcount: Cannot open srcFile '" + srcFile.getName() + "'");
                return;
            }else {
                System.out.println("charcount: [OK] srcFilename = '" + srcFile.getName() + "'");
            }
        }

        FileInputStream srcStream = new FileInputStream(srcFile);

        //Execute Character Count
        int nChars = 0;

        while ((srcStream.read()) != EOF){
            ++nChars;
        }

        //Close and flush all the files
        srcStream.close();

        System.out.printf("charcount : %d Characters %n",nChars);
    }


}
