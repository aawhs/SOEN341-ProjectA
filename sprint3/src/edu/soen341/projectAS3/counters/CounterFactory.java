package edu.soen341.projectAS3.counters;

//CounterFactory returns counter object relevant to user arguments
public class CounterFactory {
    public Counter createCounter(String counterType){
        if(counterType == null) {
            return null;
        }
        if(counterType.equalsIgnoreCase("charcount")){
            return new CharCounter();
        } else if(counterType.equalsIgnoreCase("wordcount")){
            return new WordCounter();
        } else if(counterType.equalsIgnoreCase("linecount")){
            return new LineCounter();
        } else if(counterType.equalsIgnoreCase("copy")){
            return new CopyCounter();
        } else if(counterType.equalsIgnoreCase("wc")){
            return new WcCounter();
        }
        return null;
    }
}
