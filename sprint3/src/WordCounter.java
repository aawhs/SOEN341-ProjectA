import java.util.ArrayList;

class WordCounter extends Counter {
    @Override
    public void count(ArrayList<String> line){
        char[] characters;

        for (String s : line) {
            characters = s.toCharArray();
            for (int j = 0; j < characters.length; j++) {
                if (Character.isLetter(characters[j]) && j != characters.length - 1) {
                    isWord = true;
                } else if (!Character.isLetter(characters[j]) && isWord) {
                    count++;
                    isWord = false;
                } else if (Character.isLetter(characters[j]) && j == characters.length - 1) {
                    count++;
                }
            }
        }

        if (opt.isEnabled() && opt.isRequired() && opt.getClass().getName().equals("VerboseOption")) {
            System.out.print("Verbose : ");
            for(int i = 0; i < count; i++)
                System.out.print("w");
        }

        System.out.println("\nWords Count : " + getCount()+"\n");
        count = 0;
    }

    @Override
    public void setFiles(ArrayList<IFileManager> file) {

    }

    @Override
    public void resetCount() {
        count = 0;
    }
}
