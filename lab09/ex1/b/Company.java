package b;
import java.util.List;	
import java.util.ArrayList;
import java.util.Collections;
class Company {

public static User user;
private List<Employee> emps = new ArrayList<>();

	public void admitEmployee(Person employee, int salary) {
		if (user == User.COMPANY) {
			emps.add(new Employee(employee.getName(), salary));
		}
	}

	public void paySalaries(int month) {
		for (Employee e : emps) {
			e.deposit(month);
		}
	}

	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

}