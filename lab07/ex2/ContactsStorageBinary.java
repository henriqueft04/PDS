package ex2;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;


public class ContactsStorageBinary implements ContactsStorageInterface  {
    private String filename;

    public ContactsStorageBinary(String filename) {
        this.filename = filename;
    }

    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(filename);
            int i = 0;
            String name = "";
            String telephone = "";
            boolean isName = true;
            while ((i = file.read()) != -1) {
                if (i == 0) {
                    name = name.trim();
                    isName = false;
                } else if (i == 1) {
                    telephone = telephone.trim();
                    contacts.add(new Contact(name, telephone));
                    name = "";
                    telephone = "";
                    isName = true;
                } else {
                    if (isName) {
                        name += (char) i;
                    } else {
                        telephone += (char) i;
                    }
                }
            }

            file.close();

            return contacts;
        } catch (IOException e) {
            return null;
        }
    }

    public boolean saveContacts(List<Contact> list) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            
            for (Contact contact : list) {
                file.write(contact.getName().getBytes());
                file.write(0);
                file.write(contact.getTelephone().getBytes());
                file.write(1);
            }

            file.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
