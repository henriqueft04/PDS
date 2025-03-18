package dep.src;
import java.util.ArrayList;
import java.util.List;

public class Department implements Employee{

    private String name;
    private String description;
    private List<SubDepartment> subDepartments;
    
    public Department(String name, String description){
        this.name = name;
        this.description = description;
        subDepartments = new ArrayList<>();
    }
    
    public void addSubDepartment(SubDepartment subDepartment){
        subDepartments.add(subDepartment);
    }

    public void removeSubDepartment(SubDepartment subDepartment){
        subDepartments.remove(subDepartment);
    }

    public List<SubDepartment> getSubDepartments(){
        return subDepartments;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return "Department: " + getName() + ", " + getDescription();
    }

    public void showDetails(){
        System.out.println("Department: " + name + ", " + description);
        for (SubDepartment sd : subDepartments){
            sd.showDetails();
        }
    }
} 
