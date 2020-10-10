// Project A - Sprint 1
// Student Name : Ahmed Ali
// Student ID  : 40102454
// copy.java - Copy sourceFile to destinationFile


import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class copy {
	private static int EOF = -1;
	private static File srcFile = null;
	private static File dstFile = null;
	private static String srcFilename = "<srcFilename>";
	private static String dstFilename = "<dstFilename>";
	public static void main(String[] args) throws IOException, URISyntaxException {

		// Check the number of arguments.
		// In Java, the command name 'copy' is considered as an argument.

		if (args.length != 2){
			//Help Option
			if(args.length != 0) {

				if ((args[0].equals("-?") || args[0].equals("-h") || args[0].equals("-help"))) {

					System.out.println("Usage: copy {SourccFilePath} {DestinationFilePath}");
					System.out.println("or	   copy [options]");
					System.out.println("[options] = '?' or '-h' or 'help' ");
					return;
				} else if((!args[0].contains(".txt"))){
					System.out.println("Error : Invalid Argument or Option Unknown");
					System.out.println("try 'wc -help' or 'wc -h' or 'wc -?'");
					return;
				}
			}

			System.out.println("Usage: copy {SourccFilePath} {DestinationFilePath}");
			return;
		}

		// Check if arguments are valid, if the srcFile exists, and if can create the dstFile.
		if (args[0] != null) { // Check <src>

			srcFilename = args[0];

			//Getting Absolute path from argument (if file exists in the same folder as class)
			Path srcPath = Paths.get(srcFilename);
			Path fileName = srcPath.getFileName();
			URL path = ClassLoader.getSystemResource(fileName.toString());
			path.toURI();
			srcFile = new File(path.toURI());

			System.out.println("copy: srcFilename = '" + srcFilename + "'");
			if (!srcFile.canRead()) {
				System.out.println("copy: Cannot open srcFile '" + srcFilename + "'");
				return;
			} else {
				System.out.println("copy: [OK] srcFilename = '" + srcFilename + "'");
			}
		}

		if (args[1] != null) { // Check <dst>
			dstFilename = args[1];
			dstFile = new File(dstFilename);
		} else {
			System.out.println("copy: [OK] dstFilename = '" + dstFilename + "'");
		}

		FileInputStream srcStream = new FileInputStream(srcFile);
		FileOutputStream dstStream = new FileOutputStream(dstFile);

		// Execute the copy.
		int c;

		while ( (c = srcStream.read()) != EOF ) {
			dstStream.write(c);
			System.out.print('.');
		}

		// Close and flush all the files.
		srcStream.close();
		dstStream.close();

		System.out.println(" copy: done.");
	}
}
