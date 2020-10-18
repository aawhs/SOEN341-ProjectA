package edu.soen341.projectAS3.options;

//Null option used in case there are no options in the argument
class noOption extends Option {

    public noOption() {
        super(new String[]{"-e"}, "-empty");
        setEnable(false);
    }

    @Override
    public void process() {

    }
}