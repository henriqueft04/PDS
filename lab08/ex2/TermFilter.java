package ex2;

import java.util.Queue;
import java.util.LinkedList;

public class TermFilter extends Filter {
    private Queue<String> terms = new LinkedList<>();

    public TermFilter(TextReaderInterface reader) {
        super(reader);
    }

    public boolean hasNext() {
        if (terms.isEmpty()) {
            return super.hasNext();
        }
        return true;
    }

    public String next() {
        if (terms.isEmpty()) {
            String line = super.next();
            String[] words = line.split(" ");
            for (String word : words) {
                terms.add(word);
            }
        }
        return terms.remove();
    }
}
