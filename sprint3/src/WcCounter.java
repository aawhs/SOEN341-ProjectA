import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class WcCounter extends Counter{
    ICounter counter;
    CounterFactory counterFactory= new CounterFactory();


    @Override
    public void count(ArrayList<IFileManager> file, IOption opt) {
        System.out.println("\n---------- WC Program ----------");

    	try {
    	    for(int i = 0; i < file.size() ; i++){
                //Character Counter
                counter = counterFactory.getCounter("charcount");
                counter.count(file,opt);
                file.get(i).reset();

                //Word Counter
                counter = counterFactory.getCounter("wordcount");
                counter.count(file,opt);
                file.get(i).reset();

                //Line Counter
                counter = counterFactory.getCounter("linecount");
                counter.count(file,opt);
                file.get(i).reset();
            }

    	}
    	catch (IOException e) {
    		System.out.println("Error in reading files");
    	}
    	catch (URISyntaxException e2) {
    		System.out.println("URI Syntax error");
    	}
    }
}
