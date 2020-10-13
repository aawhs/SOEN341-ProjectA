import java.io.*;

public class LineCounter extends Counter {

    @Override
    public void process(IFilePath file, IOption opt) throws IOException {
        int character;

            count = 0;
            if (file != null) {
                file.canReadFile();
                while ((character = file.getFile().read()) != EOF) {
                    if (character == '\n') {
                        ++count;
                        if (opt.isEnabled() && opt.isRequired()) {
                            System.out.print("l");
                        }
                    }
                }
                System.out.println("\nLines: " + +getCount());
            }


    }

    @Override
    public void process(IFilePath file, Object dst, IOption opt) throws IOException {
    }

}
