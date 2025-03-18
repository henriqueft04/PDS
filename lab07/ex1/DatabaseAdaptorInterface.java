package ex1;
import java.util.ArrayList;

public interface DatabaseAdaptorInterface {

    public void novoEmployee(Empregado employee);
    public void removerEmployee(long  id);
    public ArrayList<Employee> getEmployees();
    public Boolean isEmployee(long id);
}
