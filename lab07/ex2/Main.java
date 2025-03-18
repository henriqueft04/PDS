package ex2;

public class Main {
    public static void main(String[] args) {
        ContactsInterface contacts = new ContactsManager();
        contacts.openAndLoadContacts(new ContactsStorageTXT("contacts.txt"));
        contacts.add(new Contact("Manuel", "840275939"));
        contacts.add(new Contact("Maria", "840275939"));
        contacts.remove(contacts.getByName("Jane"));
            contacts.saveAndClose(new ContactsStorageCSV("contacts.csv"));
        }
}
