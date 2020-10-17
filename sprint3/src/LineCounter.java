import java.util.ArrayList;

class LineCounter extends Counter {

    @Override
    public void count(ArrayList<String> line){
        count = line.size();

        if (opt.isEnabled() && opt.isRequired() && opt.getClass().getName().equals("VerboseOption")) {
            System.out.print("Verbose : ");
            for(int i = 0; i <= count; i++)
                System.out.print("l");
        }

        System.out.println("\nLine Count : " + getCount());
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
