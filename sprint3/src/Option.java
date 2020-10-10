import java.util.Arrays;

public abstract class Option implements IOption{

    //Constructor
    public Option(String[] optShort, String optLong){
        setOptShort(optShort);
        setOptLong (optLong);
    }

    //Interface Methods
    @Override
    public void printUsage(){
        System.out.println("CommandLine = wcOO CommandName { Option } { Argument }\n" +
                "Options Available\n"+
                "HelpOption    = \"-?\" | \"-h\" | \"-help\"\n" +
                "VerboseOption = \"-v\" | \"-verbose\"\n" +
                "BannerOption  = \"-b\" | \"-banner\"\n");
    }

    //Option Attributes
    protected String[] optShort;
    protected String optLong;
    protected String usage;
    protected String className;
    protected String[] opt;
    protected boolean en;
    protected boolean req;

    //Set & Get Functions
    protected final void setOptShort(String[] opt){this.optShort  = opt;}
    protected final void setOptLong (String opt)  {this.optLong   = opt;}
    protected final void setUsage(String usage)   {this.usage     = usage;}
    protected final void setClassName(String name){this.className = name;}
    public final void setEnable(boolean en)     {this.en        = en;}
    public final void setReq(boolean req)     {this.req        = req;}

    public final String[] getOptShort() {return this.optShort;}
    public final String   getOptLong()  {return this.optLong;}
    public final String   getUsage()    {return this.usage;}
    public final String   getClassName(){return this.className;}


    //Assertions
    @Override
    public boolean isValid(){
        if(optShort.length != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isOption(){
        if(Arrays.toString(optShort).contains("-"))
            return true;
        return false;
    }

    @Override
    public boolean isEnabled() {
        if(this.en)
            return true;
        return false;
    }

    @Override
    public boolean isRequired() {
        if(this.req)
            return true;
        return false;
    }
}

