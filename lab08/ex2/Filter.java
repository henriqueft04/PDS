package ex2;

public class Filter implements TextReaderInterface {
    private TextReaderInterface reader;
    
    public Filter(TextReaderInterface reader) {
        this.reader = reader;
    }

    public boolean hasNext() {
        return reader.hasNext();
    }

    public String next() {
        return reader.next();
    }
}
