package ex1;
public class Manager extends EmployeeDecorator{
    private String department;
    
    public Manager(EmployeeInterface employee, String department) {
        super(employee);
        this.department = department;
        if (!employee.getRoles().contains("Manager")) {
            employee.addRole("Manager");
        }
    }
    
    public void work() {
        System.out.println("Manager " + getName() + " is working in department " + department);
    }

    public void manage(){
        System.out.println("Manager " + getName() + " is managing department " + department);
    }

    public String toString() {
        return super.toString() + " | Department Manger of: " + department + "\n";
    }
}
