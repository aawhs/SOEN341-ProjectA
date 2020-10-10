import java.io.*;

public class LineCounter extends Counter {

    @Override
    public void process(IFilePath[] file) {

    }

    @Override
    public void process(IFilePath[] file, IOption opt) throws IOException {
        int character;
        for (IFilePath iFilePath : file) {
            count = 0;
            if (iFilePath != null) {
                iFilePath.canReadFile();
                while ((character = iFilePath.getFile().read()) != EOF) {
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
        for (IFilePath iFilePath : file) {
            if (iFilePath != null) {
                iFilePath.close();
            }
        }

    }

    @Override
    public void process(IFilePath[] file, Object dst, IOption opt) throws IOException {
        for(int i = 0; i < file.length; i++){
            count = 0;
            if(file[i] != null){
                file[i].canReadFile();
                while ((file[i].getFile().read()) != EOF) {
                    ++count;
                    if(opt.isEnabled()){
                        System.out.print("c");
                    }
                }
                System.out.println("Characters Count: " + getCount());
            }
            for(int j = 0; j<i ; j++){
                file[j].close();
            }
            break;
        }
        return;
    }

}
