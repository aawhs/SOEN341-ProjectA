import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface ICounter {
    int EOF = -1;
    void count(ArrayList <String> line) throws IOException, URISyntaxException;
    void resetCount();
    void setFiles(ArrayList<IFileManager> file);
    void setOpt(IOption opt);
    Integer getCount();
}

