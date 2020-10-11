public class noOption extends Option {

    public noOption() {
        super(new String[]{"-e"}, "-empty");
    }

    @Override
    public void process() {

    }
}
