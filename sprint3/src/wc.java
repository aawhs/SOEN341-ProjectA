// Project A - Sprint 1
// Student Name : Ahmed Ali
// Student ID  : 40102454
// wc.java - wordcount, linecount and charcount sourceFiles+

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class wc {
    private static boolean isSpace(int C) {
        return (C == ' ' || C == '\t');
    }
    private static final int EOF = -1;
    private static File srcFile = null;
    private static String srcFilename = "<srcFilename>";
    private static int totalLines, totalWords, totalChars;

    public static void main(String[] args) throws IOException, URISyntaxException {

        // Check the number of arguments.
        // In Java, the command name 'copy' is considered as an argument.

        //args= new String[]{"test.txt", "test2.txt", "test3.txt"};

        if (args.length < 1) {

            System.out.println("Usage: wc {SourceFilePath}+");
            System.out.println("wc [options] = '-?' or '-h' or 'help' ");
            return;
        }

        //Check if arguments are valid, if the srcFile exists

        if (args[0] != null) { // Check <src>
            totalLines = totalWords = totalChars = 0;
            //Help Option
                if ((args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) {

                    System.out.println("Usage: wc {SourccFilePath}+");
                    System.out.println("or	   wc [options]");
                    System.out.println("[options] = '-?' or '-h' or 'help' ");
                    return;
                }  else if((!args[0].contains(".txt"))){
                    System.out.println("Error : Invalid Argument or Option Unknown");
                    System.out.println("try 'wc -help' or 'wc -h' or 'wc -?'");
                    return;
                }
            for (String arg : args) {
                if (arg != null) {

                    srcFilename = arg;

                    //Getting Absolute path from argument (if file exists in the same folder as class)
                    Path srcPath = Paths.get(srcFilename);
                    Path fileName = srcPath.getFileName();
                    URL path = ClassLoader.getSystemResource(fileName.toString());
                    path.toURI();
                    srcFile = new File(path.toURI());

                    System.out.println("wc: srcFilename = '" + srcFile.getName() + "'");
                    if (!srcFile.canRead()) {
                        System.out.println("wc: Cannot open srcFile '" + srcFile.getName() + "'");
                        return;
                    } else {
                        System.out.println("wc: [OK] srcFilename = '" + srcFile.getName() + "'");
                    }

                    FileInputStream srcStream = new FileInputStream(srcFile);
                    //Execute the word count

                    int c;
                    int nChars, nLines, nWords;
                    boolean inWord = false;

                    nChars = nLines = nWords = 0;

                    while ((c = srcStream.read()) != EOF) {

                        //Count Characters
                        ++nChars;

                        //Count Lines
                        if (c == '\n') ++nLines;

                        //Count Words
                        if (isSpace(c)) {
                            if (!inWord) {
                                inWord = true;
                                ++nWords;
                            }
                        } else {
                            inWord = false;
                        }

                    }
                    //Close and flush all the files
                    srcStream.close();

                    System.out.printf("%s: %d lines, %d words, %d chars %n",
                            srcFilename, nLines, nWords, nChars);

                    totalLines += nLines;
                    totalWords += nWords;
                    totalChars += nChars;
                }
            }

        }
        if (args.length > 2) {
            System.out.printf("**Total: %d lines, %d words, %d chars %n",
                    totalLines, totalWords, totalChars);
        }
    }
}
