package dep.src;
public class Main{
    public static void main(String[] args){
        Individual i1 = new Individual("John Doe", "Manager");
        Individual i2 = new Individual("Jane Doe", "Assistant Manager");
        Individual i3 = new Individual("Jack Doe", "Supervisor");
        
        SubDepartment sd1 = new SubDepartment("Sales", "Sales Department");
        SubDepartment sd2 = new SubDepartment("Marketing", "Marketing Department");
        
        sd1.addEmployee(i1);
        sd1.addEmployee(i2);
        sd2.addEmployee(i3);
        
        Department d1 = new Department("Sales and Marketing", "Sales and Marketing Department");
        d1.addSubDepartment(sd1);
        d1.addSubDepartment(sd2);
        
        d1.showDetails();
    }
}