import java.io.IOException;

public class CharCounter extends Counter {

    @Override
    public void process(IFilePath file, IOption opt) throws IOException {
                count = 0;
            if(file != null){
                file.canReadFile();
                while ((file.getFile().read()) != EOF) {
                    ++count;
                    if(opt.isEnabled() && opt.isRequired()){
                            System.out.print("c");
                    }
                }
                System.out.println("\nCharacters Count: " + getCount());

            }
    }

    @Override
    public void process(IFilePath file, Object dst, IOption opt) throws IOException {

    }
}
