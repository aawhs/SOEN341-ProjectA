import java.io.IOException;
import java.net.URISyntaxException;

public class WcCounter extends Counter{
    ICounter counter;
    CounterFactory counterFactory= new CounterFactory();


    @Override
    public void process(IFilePath file, IOption opt) {
        //Character Counter
    	try {
        counter = counterFactory.getCounter("charcount");
        counter.process(file,opt);
        file.reset();

        //Word Counter
        counter = counterFactory.getCounter("wordcount");
        counter.process(file,opt);
        file.reset();

        //Line Counter
        counter = counterFactory.getCounter("linecount");
        counter.process(file,opt);
        file.reset();
    	}
    	catch (IOException e) {
    		System.out.println("Error in reading files");
    	}
    	catch (URISyntaxException e2) {
    		System.out.println("URI Syntax error");
    	}
    }

    @Override
    public void process(IFilePath file, Object dst, IOption opt) throws IOException {

    }
}
