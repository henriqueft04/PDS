package ex2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class ContactsStorageTXT implements ContactsStorageInterface  {
    private String filename;

    public ContactsStorageTXT(String filename) {
        this.filename = filename;
    }

    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\t");

                contacts.add(new Contact(line[0], line[1]));
            }

            scanner.close();

            return contacts;

        } catch (IOException e) {
            return null;
        }
    }

    public boolean saveContacts(List<Contact> list) {
        try {
            FileWriter writer = new FileWriter(filename);

            for (Contact contact : list) {
                writer.write(contact.getName() + "\t" + contact.getTelephone() + "\n");
            }

            writer.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
