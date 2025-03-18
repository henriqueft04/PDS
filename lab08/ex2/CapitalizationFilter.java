package ex2;

public class CapitalizationFilter extends Filter {
    public CapitalizationFilter(TextReaderInterface reader) {
        super(reader);
    }

    private boolean isWordStartOrTermination(String line, int i) {
        return Character.isLetter(line.charAt(i)) && (i == 0 || i == line.length() - 1 || !Character.isLetter(line.charAt(i - 1)) || !Character.isLetter(line.charAt(i + 1)));
    }

    public String next() {
        String line = super.next();
        for (int i = 0; i < line.length(); i++) {
            if (isWordStartOrTermination(line, i))  {
                line = line.substring(0, i) + Character.toUpperCase(line.charAt(i)) + line.substring(i + 1);
            }
        }
        return line;
    }
}
