import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CounterList extends Counter{

    private List<ICounter> counterList = new ArrayList<>();

    public void addCounter(Counter cr){
        counterList.add(cr);
    }
    public void removeCounter(Counter cr){
        counterList.remove(cr);
    }

    @Override
    public void process(IFilePath file, IOption dst) throws IOException, URISyntaxException {

    }

    @Override
    public void process(IFilePath file, Object dst, IOption opt) throws IOException {

    }
}
