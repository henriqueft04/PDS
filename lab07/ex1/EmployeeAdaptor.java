package ex1;
public class EmployeeAdaptor extends Empregado implements EmployeeAdaptorInterface {
    public EmployeeAdaptor(String nome, String apelido, int codigo, double salario) {
        super(nome, apelido, codigo, salario);
    }

    public String getName() {
        return nome();
    }

    public long getId() {
        return (long)super.codigo();
    }

    public double getSalary() {
        return salario();
    }
    
}
