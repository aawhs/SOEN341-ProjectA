package edu.soen341.projectAS3.options;

public interface IOption {
    default void printUsage() {
        System.out.println("CommandLine = wcOO CommandName { Option } { Argument }\n" +
                "Options Available\n"+
                "HelpOption    = \"-?\" | \"-h\" | \"-help\"\n" +
                "VerboseOption = \"-v\" | \"-verbose\"\n" +
                "BannerOption  = \"-b\" | \"-banner\"\n");
    }

    boolean isOption();
    boolean isEnabled();
    boolean isRequired();
    void process();
    void setEnable(boolean en);
    void setUsage(String usage);
    void setClassName(String className);

}



