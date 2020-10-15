import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class WcCounter extends Counter{
    ICounter counter;
    CounterFactory counterFactory= new CounterFactory();

    @Override
    public void count(ArrayList<IFileManager> file, IOption opt) {
        System.out.println("\n---------- WC Program ----------");

        optConfig(opt);
        opt.process();

    	try {
                //Character Counter
                counter = counterFactory.getCounter("charcount");
                counter.count(file,opt);

                //Word Counter
                counter = counterFactory.getCounter("wordcount");
                counter.count(file,opt);

                //Line Counter
                counter = counterFactory.getCounter("linecount");
                counter.count(file,opt);

    	}
    	catch (IOException e) {
    		System.out.println("Error in reading files");
    	}
    	catch (URISyntaxException e2) {
    		System.out.println("URI Syntax error");
    	}
    }

    @Override
    public void optConfig(IOption opt){
        if(opt.isEnabled()){
            opt.setUsage("CommandLine = wcOO wc [Option] {SourceFilePath+}");
            opt.setClassName("wc");
        }
    }
}
