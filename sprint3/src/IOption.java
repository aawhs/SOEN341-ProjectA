public interface IOption {
    default void printUsage() {
        System.out.println("CommandLine = wcOO CommandName { Option } { Argument }\n" +
                "Options Available\n"+
                "HelpOption    = \"-?\" | \"-h\" | \"-help\"\n" +
                "VerboseOption = \"-v\" | \"-verbose\"\n" +
                "BannerOption  = \"-b\" | \"-banner\"\n");
    }
    boolean isValid();
    boolean isOption();
    boolean isEnabled();
    boolean isRequired();
    void process();
    String[] getOptShort();
    String getOptLong   ();
    String getUsage     ();
    String getClassName ();
    void setEnable(boolean en);
}



