import java.io.IOException;

public interface ICounter {
    int EOF = -1;
    void process(IFilePath[] file) throws IOException;
    void process(IFilePath[] file, IOption dst)throws IOException;
    void process(IFilePath[] file, Object dst, IOption opt)throws IOException;
    Integer getCount();
}

