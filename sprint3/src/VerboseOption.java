public class VerboseOption extends Option {
    String verboseCharacter;
    public VerboseOption() {
        super(new String[]{"-v"}, "-verbose");
        setEnable(true);
    }


    @Override
    public void process() {
        setReq(true);
    }
}
