public class CounterFactory {
    public Counter getCounter(String counterType){
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
