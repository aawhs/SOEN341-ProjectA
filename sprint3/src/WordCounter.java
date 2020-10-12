import java.io.IOException;

public class WordCounter extends Counter {
    @Override
    public void process(IFilePath[] file) throws IOException {
    	int character; 
    	for(int i = 0; i < file.length; i++){
             count = 0;
             if(file[i] != null){
                 file[i].canReadFile();
                 while ((character = file[i].getFile().read()) != EOF) {
                     if(isSpace(character)) {
                    	 if (!whiteSpace) {
                             whiteSpace = true;
                             ++count;
                    	 }
                    	 whiteSpace = false;
                     }
                 }
                 System.out.println("\nWords Count: " + getCount());
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
        int character;
        for(int i = 0; i < file.length; i++){
            count = 0;
            if(file[i] != null){
                file[i].canReadFile();
                while ((character = file[i].getFile().read()) != EOF) {

                    if (isSpace(character)) {
                        if (!whiteSpace) {
                            whiteSpace = true;
                            ++count;
                            if(opt.isEnabled() && opt.isRequired()){
                                System.out.print("w");
                            }
                        }
                        whiteSpace = false;
                    }
                }
                System.out.println("\nWords Count : " + getCount());
            }
            for(int j = 0; j<i ; j++){
                file[j].close();
            }
            break;

        }
    }

    @Override
    public void process(IFilePath[] file, Object dst, IOption opt) throws IOException {

    }

}
