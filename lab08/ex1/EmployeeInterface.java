package ex1;
import java.util.Date;
import java.util.List;

public interface EmployeeInterface {
    
    public void work();
    public void start(Date date);
    public void terminate(Date date);
    public String getName();
    public int getNumber();
    public String toString();
    public void addRole(String role);
    public void removeRole(String role);
    public List<String> getRoles();
}
