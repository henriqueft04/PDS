package ex3;

import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class Document {
    private String filename;

    public Document(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public String getResume() {
        return readDocument()[0].substring(0, Math.min(20, readDocument()[0].length()-1)) + "...";
    }

    public String[] readDocument() {
        try {
            Scanner sc = new Scanner(new File(filename));
            List<String> lines = new ArrayList<>();

            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }

            sc.close();

            return lines.toArray(new String[0]);
        } catch (Exception e) {
            return null;
        }
    }

}
