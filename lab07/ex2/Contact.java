package ex2;

public class Contact {
    private String name;
    private String telephone;

    public Contact(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " " + telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
