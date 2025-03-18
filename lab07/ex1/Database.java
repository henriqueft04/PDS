package ex1;
// import vector
import java.util.Vector;

public class Database {
    private Vector<Employee> employees; // Stores the employees

    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        // Code to add employee
        if (employees.contains(employee)){
            System.out.println("Employee " + employee.getName() + " already exists in database!");
            return false;
        }
        employees.add(employee);
        System.out.println("Employee added to database!");
        return true;
    }

    public void deleteEmployee(long emp_num) {
        // Code to delete employee
        for (Employee employee : employees) {
            if (employee.getEmpNum() == emp_num) {
                employees.remove(employee);
                System.out.println("Employee with emp_num " + emp_num + " deleted");
                break;
            }
        }
        System.out.println("Employee with emp_num " + emp_num + " not found");
    }

    public Employee[] getAllEmployees() {
        // Code to retrieve collection
        Employee[] employeeArray = new Employee[employees.size()];
        employees.toArray(employeeArray);
        return employeeArray;
    }
}
