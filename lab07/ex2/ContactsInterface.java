package ex2;

public interface ContactsInterface {
    public void openAndLoadContacts(ContactsStorageInterface store);
    public void saveAndClose();
    public void saveAndClose(ContactsStorageInterface store);
    public boolean exist(Contact contact);
    public Contact getByName(String name);
    public boolean add(Contact contact);
    public boolean remove(Contact contact);

}
