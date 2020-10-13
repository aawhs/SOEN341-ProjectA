import java.io.IOException;

public class WordCounter extends Counter {

    @Override
    public void process(IFilePath file, IOption opt) throws IOException {
        int character;
            count = 0;
            if(file != null) {
                file.canReadFile();
                while ((character = file.getFile().read()) != EOF) {

                    if (isSpace(character)) {
                        if (!whiteSpace) {
                            whiteSpace = true;
                            ++count;
                            if (opt.isEnabled() && opt.isRequired()) {
                                System.out.print("w");
                            }
                        }
                        whiteSpace = false;
                    }
                }
                System.out.println("\nWords Count : " + getCount());
            }
    }

    @Override
    public void process(IFilePath file, Object dst, IOption opt) throws IOException {

    }

}
