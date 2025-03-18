package dep.src;
import java.util.List;
import java.util.ArrayList;

public class SubDepartment implements Employee{

    private String name;
    private String description;
    private List<Employee> employees;
    
    public SubDepartment(String name, String description){
        this.name = name;
        this.description = description;
        employees = new ArrayList<>();
    }
    
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return "SubDepartment: " + getName() + ", " + getDescription();
    }

    public void showDetails(){
        System.out.println("SubDepartment: " + name + ", " + description);
        for (Employee e : employees){
            e.showDetails();
        }
    }
}