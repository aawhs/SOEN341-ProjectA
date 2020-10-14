import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface ICounter {
    int EOF = -1;
    void process(ArrayList<IFileManager> file, IOption opt) throws IOException, URISyntaxException;
    Integer getCount();
}

