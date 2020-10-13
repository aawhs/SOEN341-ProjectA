// Project A - Sprint 1
// Student Name : Ahmed Ali
// Student ID  : 40102454
// wc.java - wordcount, linecount and charcount sourceFiles+


import java.io.IOException;
import java.net.URISyntaxException;

public class wcOO {
    public static void main(String [] args) throws IOException, URISyntaxException {
        //args = new String[]{"charcount", "test.txt"};
        Administrator admin = new Administrator();
        admin.parse(args);
    }
}
