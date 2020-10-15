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
    public void count(ArrayList<IFileManager> file, IOption dst) {

    }

    @Override
    public void optConfig(IOption opt) {

    }
}
