import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

abstract class Counter implements ICounter {
    Integer count = 0;
    boolean whiteSpace = false;

    abstract public void count(ArrayList<IFileManager> file, IOption opt) throws IOException, URISyntaxException;
    public Integer getCount() {
        return this.count;
    }
    public boolean isSpace(Integer C) {
        return (C == ' ' || C == '\t');
    }
}
