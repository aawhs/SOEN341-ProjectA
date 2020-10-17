import java.util.ArrayList;

class CharCounter extends Counter {
    @Override
    public void count(ArrayList<String> line){
        for (String s : line) {
            for (int j = 0; j < s.length(); j++) {
                if (!isSpace((int) s.charAt(j))) {
                    ++count;
                }
            }
        }

        if (opt.isEnabled() && opt.isRequired() && opt.getClass().getName().equals("VerboseOption")) {
            System.out.print("Verbose : ");
            for(int i = 0; i <= count; i++)
                System.out.print("c");
        }

        System.out.println("\nCharacter Count : " + getCount());
        count = 0;
    }

    @Override
    public void resetCount() {
        count = 0;
    }

    @Override
    public void setFiles(ArrayList<IFileManager> file) {

    }

}
