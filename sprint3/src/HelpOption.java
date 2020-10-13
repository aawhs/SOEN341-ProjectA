import static java.lang.System.exit;

public class HelpOption extends Option {

    public HelpOption() {
        super(new String[]{"-?","-h"}, "-help");
        setEnable(true);
    }

    @Override
    public void printUsage() {
        //System.out.println("\n"+ usage);
        System.out.println("CommandLine = wcOO CommandName { Option } { Argument }\n" +
                "Options Available\n"+
                "HelpOption    = \"-?\" | \"-h\" | \"-help\"\n" +
                "VerboseOption = \"-v\" | \"-verbose\"\n" +
                "BannerOption  = \"-b\" | \"-banner\"\n");
    }

    @Override
    public void process() {
        printUsage();
        exit(1);
    }
}
