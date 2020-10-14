abstract class Counter implements ICounter {
    Integer count = 0;
    boolean whiteSpace = false;

    public Integer getCount() {
        return this.count;
    }
    public boolean isSpace(Integer C) {
        return (C == ' ' || C == '\t');
    }
}
