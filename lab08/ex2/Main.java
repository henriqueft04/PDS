package ex2;

public class Main {
    public static void main(String[] args) {
        TextReaderInterface reader = new TextReader("test.txt");
        reader = new CapitalizationFilter(reader);
        reader = new NormalizationFilter(reader);
        reader = new VowelFilter(reader);
        reader = new TermFilter(reader);
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
    }
}
