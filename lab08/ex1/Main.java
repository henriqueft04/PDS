package ex1;
import java.util.Date;

public class Main {
   // atribuir várias competencias a um empregado
    public static void main(String[] args) {
        EmployeeInterface emp = new Employee("João Murcão", 1);
        emp.work();
        emp.start(new Date());
        emp.terminate(null);
        System.out.println(emp);

        emp = new Manager(emp, "IT");
        emp.work();

        emp = new Manager(emp, "HR");
        emp.work();
        ((Manager) emp).manage();
        System.out.println(emp);

        emp = new TeamLeader(emp, "Trolhas");
        emp.work();

        emp = new TeamMember(emp, "AETTUA");
        System.out.println(emp);

    }
}
