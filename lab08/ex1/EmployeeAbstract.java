package ex1;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class EmployeeAbstract implements EmployeeInterface {
    private String name;
    private int number;
    private Date starDate;
    private Date termDate;
    private List<String> roles;

    public EmployeeAbstract(String name, int number) {
        this.name = name;
        this.number = number;
        this.starDate = null;
        this.termDate = null;
        this.roles = new ArrayList<>();
    }

    public void work(){
        // print what roles he is + is working
        for (String role : roles) {
            System.out.println(name + " is working as " + role);
        }
    }

    public void start(Date date) {
        this.starDate = date;
    }

    public void terminate(Date date) {
        this.termDate = date;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void addRole(String role) {
        roles.add(role);
    }

    public void removeRole(String role) {
        roles.remove(role);
    }

    public List<String> getRoles() {
        return roles;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Name: " + name + " | ");
        sb.append("Number: " + number + " | ");
        if (starDate != null) {
            sb.append("Start Date: " + starDate + " | ");
        }
        if (termDate != null) {
            sb.append("Terminate Date: " + termDate + "\n");
        }
        sb.append("Roles: ");
        for (String role : roles) {
            sb.append(role + " ");
        }
        sb.append("\n");
        return sb.toString();
    }

}