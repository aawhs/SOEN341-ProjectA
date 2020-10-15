import static java.lang.System.exit;

public class HelpOption extends Option {

    public HelpOption() {
        super(new String[]{"-?","-h"}, "-help");
        setEnable(true);
    }

    @Override
    public void printUsage() {
        //System.out.println("\n"+ usage);
        System.out.println(
                getUsage()+
                "\n\n" +
                "Options Available\n"+
                "Help    = \"-?\" | \"-h\" | \"-help\"\n" +
                "Verbose = \"-v\" | \"-verbose\"\n" +
                "Banner  = \"-b\" | \"-banner\"\n");
    }

    @Override
    public void process() {
        printUsage();
        exit(1);
    }
}
