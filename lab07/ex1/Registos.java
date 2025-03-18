package ex1;
import java.util.List;
import java.util.ArrayList;

public class Registos { 
    // Data elements 
    private ArrayList<Empregado> empregados; // Stores the employees 

    public Registos() { 
        empregados = new ArrayList<>(); 
    } 
    public void insere(Empregado emp) { 
        // Code to insert employee
        if (empregados.contains(emp)) {
            throw new IllegalArgumentException("Empregado já existe");
        }
        empregados.add(emp);
        System.out.println("Empregado inserido com sucesso");
    } 

    public void remove(int codigo) { 
        // Code to remove employee 
        for (Empregado emp : empregados) {
            if (emp.codigo() == codigo) {
                empregados.remove(emp);
                System.out.println("Empregado removido com sucesso");
                return;
            }
        }
        System.out.println("Empregado não existe");
    } 

    public boolean isEmpregado(int codigo) { 
        // Code to find employee 
        for (Empregado emp : empregados) {
            if (emp.codigo() == codigo) {
                return true;
            }
        }
        return false;
    } 

    public List<Empregado> listaDeEmpregados() { 
        // Code to retrieve collection 
        return empregados;
    } 
}