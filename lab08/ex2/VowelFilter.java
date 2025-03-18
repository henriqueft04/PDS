package ex2;

public class VowelFilter extends Filter {
    public VowelFilter(TextReaderInterface reader) {
        super(reader);
    }

    public String next() {
        String line = super.next();
        return line.replaceAll("[aeiouAEIOU]", "");
    }
}
