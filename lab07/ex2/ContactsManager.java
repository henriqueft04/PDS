package ex2;

import java.util.List;
import java.util.ArrayList;

public class ContactsManager implements ContactsInterface {
    List<Contact> contacts;
    ContactsStorageInterface origin = null;

    public ContactsManager() {
        this.contacts = new ArrayList<>();
    }

    public ContactsManager(List<Contact> contacts) {
        this.contacts = new ArrayList<>(contacts);
        for (Contact contact : contacts) {
            this.contacts.add(contact);
        }
    }

    public ContactsManager(ContactsStorageInterface store) {
        this.openAndLoadContacts(store);
    }

    public void openAndLoadContacts(ContactsStorageInterface store) {
        this.contacts = store.loadContacts();
        this.origin = store;
    }

    public void saveAndClose() {
        if (this.origin != null) {
            this.origin.saveContacts(this.contacts);
        }
    }

    public void saveAndClose(ContactsStorageInterface store) {
        store.saveContacts(this.contacts);
    }

    public boolean exist(Contact contact) {
        return this.contacts.contains(contact);
    }

    public Contact getByName(String name) {
        for (Contact contact : this.contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }

        return null;
    }

    public boolean add(Contact contact) {
        if (!this.exist(contact)) {
            this.contacts.add(contact);
            return true;
        }

        return false;
    }

    public boolean remove(Contact contact) {
        return this.contacts.remove(contact);
    }
}