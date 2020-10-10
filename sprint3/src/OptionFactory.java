public class OptionFactory {
    public Option getOption(String optionType){
        if(optionType == null){
            return null;
        }


        boolean h = (optionType.equalsIgnoreCase("-h")) ||
                (optionType.equalsIgnoreCase("-?")) ||
                (optionType.equalsIgnoreCase("-help"));

        boolean v = (optionType.equalsIgnoreCase("-v")) ||
                (optionType.equalsIgnoreCase("-verbose"));

        boolean b = (optionType.equalsIgnoreCase("-b")) ||
                (optionType.equalsIgnoreCase("-banner"));


        if(h){
            return new HelpOption();

        } else if (v){
            return new VerboseOption();

        }else if (b){
            return new BannerOption();
        }
        return null;
    }

}
