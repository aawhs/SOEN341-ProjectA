import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class Composite implements Counter{

	List<Counter> counters= new ArrayList<Counter>();

	public void count(File file) throws IOException {
		for(Counter obj:counters)

			obj.count(file);
	}


	public void count_multipleFiles(ArrayList<File> files) throws IOException {
		for(Counter obj:counters) {
			for(int i=0;i<files.size();i++) {
				File file = files.get(i);
				obj.count(file);
			}
		}

	}

	public void add(Counter obj) {
		this.counters.add(obj);
	}

	public void remove(Counter obj) {
		this.counters.remove(obj);
	}





}
