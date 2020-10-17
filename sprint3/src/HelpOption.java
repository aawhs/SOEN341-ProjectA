import static java.lang.System.exit;

class HelpOption extends Option {

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

    public void setUsage(){
        switch (getClassName()){
            case "CopyCounter":
                usage = "CommandLine = wcOO copy [Option] {SourceFilePath} {DestinationFilePath}";
                break;
            case "CharCounter":
                usage = "CommandLine = wcOO charcount [Option] {SourceFilePath+}";
                break;
            case "WordCounter":
                usage = "CommandLine = wcOO wordcount [Option] {SourceFilePath+}";
                break;
            case "LineCounter":
                usage = "CommandLine = wcOO linecount [Option] {SourceFilePath+}";
                break;
            default:
                usage = "CommandLine = wcOO CommandName { Option } { Argument }";
                break;
        }
    }

    @Override
    public void process() {
        setUsage();
        printUsage();
        exit(1);
    }
}
