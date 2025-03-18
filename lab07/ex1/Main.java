    package ex1;
public class Main {
   
    public static void main(String[] args) {
        Empregado emp1 = new Empregado("João", "Silva", 1, 1000);
        Empregado emp2 = new Empregado("Maria", "Santos", 2, 2000);
        Empregado emp3 = new Empregado("Manuel", "Fernandes", 3, 3000);
        Empregado emp4 = new Empregado("Ana", "Sousa", 4, 4000);
        Empregado emp5 = new Empregado("Rui", "Oliveira", 5, 5000);
        Registos reg = new Registos();
        reg.insere(emp1);
        reg.insere(emp2);
        reg.insere(emp3);
        reg.insere(emp4);
        reg.insere(emp5);
        System.out.println("Lista de empregados:");
        for (Empregado emp : reg.listaDeEmpregados()) {
            System.out.println(emp.nome() + " " + emp.apelido() + " " + emp.codigo() + " " + emp.salario());
        }
        System.out.println("Empregado com código 3 existe? " + reg.isEmpregado(3));
        System.out.println("Empregado com código 6 existe? " + reg.isEmpregado(6));
        reg.remove(3);
        System.out.println("Lista de empregados:");
        for (Empregado emp : reg.listaDeEmpregados()) {
            System.out.println(emp.nome() + " " + emp.apelido() + " " + emp.codigo() + " " + emp.salario());
        }

        Database db = new Database();
        Employee employ1 = new Employee("João", 1, 1000);
        Employee employ2 = new Employee("Mali", 2, 1000);
        Employee employ3 = new Employee("Manu", 3, 1000);
        Employee employ4 = new Employee("Ana", 4, 1000);
        db.addEmployee(employ4);
        db.addEmployee(employ1);
        db.addEmployee(employ2);
        db.addEmployee(employ3);

        System.out.println("Lista de empregados:");
        for (Employee emp : db.getAllEmployees()) {
            System.out.println(emp.getName() + " " + emp.getEmpNum() + " " + emp.getSalary());
        }

        db.deleteEmployee(3);
        System.out.println("Lista de empregados:");
        for (Employee emp : db.getAllEmployees()) {
            System.out.println(emp.getName() + " " + emp.getEmpNum() + " " + emp.getSalary());
        }

        System.out.println("Bons testes pá!");

    }
}
