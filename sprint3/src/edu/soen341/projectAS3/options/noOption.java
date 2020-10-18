package edu.soen341.projectAS3.options;

class noOption extends Option {

    public noOption() {
        super(new String[]{"-e"}, "-empty");
        setEnable(false);
    }

    @Override
    public void process() {

    }
}