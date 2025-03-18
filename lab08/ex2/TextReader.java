package ex2;

import java.util.Scanner;
import java.io.File;

public class TextReader implements TextReaderInterface {
    Scanner sc;

    public TextReader(String filename) {
        setFile(filename);
    }

    public void setFile(String filename) {
        try {
            sc = new Scanner(new File(filename));
        } catch (Exception e) {
            sc = null;
        }
    }

    public void close() {
        if (sc != null) {
            sc.close();
        }
    }

    public boolean hasNext() {
        if (sc == null) {
            System.err.println("Error: file was not opened.");
            return false;
        }
        return sc.hasNextLine();
    }

    public String next() {
        return sc.nextLine();
    }
}