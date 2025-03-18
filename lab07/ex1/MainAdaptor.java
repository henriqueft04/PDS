package ex1;

public class MainAdaptor {
    // main mas a usar os adpators
    public static void main(String[] args) {
        EmployeeAdaptorInterface emp1 = new EmployeeAdaptor("Joao", "Silva", 123, 1000);
        EmployeeAdaptorInterface emp2 = new EmployeeAdaptor("Maria", "Santos", 124, 2000);
        EmployeeAdaptorInterface emp3 = new EmployeeAdaptor("Manuel", "Fernandes", 125, 3000);
        EmployeeAdaptorInterface emp4 = new EmployeeAdaptor("Ana", "Sousa", 126, 4000);
        EmployeeAdaptorInterface emp5 = new EmployeeAdaptor("Rita", "Gomes", 127, 5000);
        EmployeeAdaptorInterface emp6 = new EmployeeAdaptor("Pedro", "Costa", 128, 6000);
        EmployeeAdaptorInterface emp7 = new EmployeeAdaptor("Marta", "Ribeiro", 129, 7000);
        EmployeeAdaptorInterface emp8 = new EmployeeAdaptor("Carlos", "Pereira", 130, 8000);
        EmployeeAdaptorInterface emp9 = new EmployeeAdaptor("Sofia", "Carvalho", 131, 9000);
        EmployeeAdaptorInterface emp10 = new EmployeeAdaptor("Luis", "Mendes", 132, 10000);
        
        System.out.println("Employee 1: " + emp1.getName() + " " + emp1.getId() + " " + emp1.getSalary());
        System.out.println("Employee 2: " + emp2.getName() + " " + emp2.getId() + " " + emp2.getSalary());
        System.out.println("Employee 3: " + emp3.getName() + " " + emp3.getId() + " " + emp3.getSalary());
        System.out.println("Employee 4: " + emp4.getName() + " " + emp4.getId() + " " + emp4.getSalary());
        System.out.println("Employee 5: " + emp5.getName() + " " + emp5.getId() + " " + emp5.getSalary());
        System.out.println("Employee 6: " + emp6.getName() + " " + emp6.getId() + " " + emp6.getSalary());
        System.out.println("Employee 7: " + emp7.getName() + " " + emp7.getId() + " " + emp7.getSalary());
        System.out.println("Employee 8: " + emp8.getName() + " " + emp8.getId() + " " + emp8.getSalary());
        System.out.println("Employee 9: " + emp9.getName() + " " + emp9.getId() + " " + emp9.getSalary());
        System.out.println("Employee 10: " + emp10.getName() + " " + emp10.getId() + " " + emp10.getSalary());

        //add to databaseadaptor

        DatabaseAdaptor db = new DatabaseAdaptor();
        db.novoEmployee((Empregado) emp1);
        db.novoEmployee((Empregado) emp2);
        db.novoEmployee((Empregado) emp3);
        db.novoEmployee((Empregado) emp4);
        db.novoEmployee((Empregado) emp5);
        db.novoEmployee((Empregado) emp6);
        db.novoEmployee((Empregado) emp7);
        db.novoEmployee((Empregado) emp8);
        db.novoEmployee((Empregado) emp9);
        db.novoEmployee((Empregado) emp10);

        System.out.println("Lista de empregados:");
        for (Employee emp : db.getEmployees()) {
            System.out.println(emp.getName() + " " + emp.getEmpNum() + " " + emp.getSalary());
        }

        db.removerEmployee(128);
        System.out.println("Lista de empregados:");
        for (Employee emp : db.getEmployees()) {
            System.out.println(emp.getName() + " " + emp.getEmpNum() + " " + emp.getSalary());
        }

        System.out.println("Bons testes pá!");

    }
}
