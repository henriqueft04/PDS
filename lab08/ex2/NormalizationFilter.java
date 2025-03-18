package ex2;

import java.text.Normalizer;

public class NormalizationFilter extends Filter {
    public NormalizationFilter(TextReaderInterface reader) {
        super(reader);
    }

    public String next() {
        String line = super.next();
        String normalizedString = Normalizer.normalize(line, Normalizer.Form.NFD)
            .replaceAll("[^\\p{ASCII}]", "");
        return normalizedString;
    }
}
