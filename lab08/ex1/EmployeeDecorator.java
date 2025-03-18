package ex1;
import java.util.Date;
import java.util.List;

public class EmployeeDecorator implements EmployeeInterface {
    private EmployeeInterface employee;
    
    public EmployeeDecorator(EmployeeInterface employee) {
        this.employee = employee;
    }
    
    public void work() {
        employee.work();
    }
    
    public void start(Date date) {
        employee.start(date);
    }
    
    public void terminate(Date date) {
        employee.terminate(date);
    }
    
    public String getName() {
        return employee.getName();
    }
    
    public int getNumber() {
        return employee.getNumber();
    }
    
    public String toString() {
        return employee.toString();
    }
    
    public void setEmployee(EmployeeInterface employee) {
        this.employee = employee;
    }

    public void addRole(String role) {
        employee.addRole(role);
    }

    public void removeRole(String role) {
        employee.removeRole(role);
    }

    public List<String> getRoles() {
        return employee.getRoles();
    }

    
    public EmployeeInterface getEmployee() {
        return employee;
    }
}