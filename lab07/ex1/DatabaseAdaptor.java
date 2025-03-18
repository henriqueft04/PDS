package ex1;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAdaptor extends Registos implements DatabaseAdaptorInterface{

    private List<Employee> employees = new ArrayList<Employee>();
    
    public void novoEmployee(Empregado empregado) {
        String name = empregado.nome();
        Long id = (long)empregado.codigo();
        Double salary = empregado.salario();
        Employee employee = new Employee(name, id, salary);
        employees.add(employee);
    }

    public void removerEmployee(long id){
        for (Employee employee : employees) {
            if (employee.getEmpNum() == id) {
                employees.remove(employee);
                break;
            }
        }
    }

    public ArrayList<Employee> getEmployees(){
        return (ArrayList<Employee>) employees;
    }

    public Boolean isEmployee(long id){
        for (Employee employee : employees) {
            if (employee.getEmpNum() == id) {
                return true;
            }
        }
        return false;
    }
}
