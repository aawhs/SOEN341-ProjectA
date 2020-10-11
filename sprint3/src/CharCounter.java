import java.io.IOException;

public class CharCounter extends Counter {
    @Override
    public void process(IFilePath[] file) throws IOException {
        for(int i = 0; i < file.length; i++){
            count = 0;
            if(file[i] != null){
                file[i].canReadFile();
                while ((file[i].getFile().read()) != EOF) {
                    ++count;
                }
                System.out.println("\nCharacters Count: " + getCount());
            }
            for(int j = 0; j<i ; j++){
                file[j].close();
            }
            break;
        }
        return;
    }

    @Override
    public void process(IFilePath[] file, IOption opt) throws IOException {
        for(int i = 0; i < file.length; i++){
                count = 0;
            if(file[i] != null){
                file[i].canReadFile();
                while ((file[i].getFile().read()) != EOF) {
                    ++count;
                    if(opt.isEnabled() == false){
                        if(opt.isRequired()){
                            System.out.print("c");
                        }
                    }
                }
                System.out.println("\nCharacters Count: " + getCount());
            }
            for(int j = 0; j<i ; j++){
                file[j].close();
            }
            break;
        }
        return;
    }

    @Override
    public void process(IFilePath[] file, Object dst, IOption opt) throws IOException {

    }
}
