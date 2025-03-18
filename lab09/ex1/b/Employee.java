package b;

class Employee {

private double salary;
private BankAccount BankAccount;
	
	public Employee(String name, double salary) {
		this.salary = salary;
		this.BankAccount = new BankProxy(new BankAccountImpl("NAPA", 0));
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public BankAccount getBankAccount() {
		return BankAccount;
	}

	public void deposit(double amount) {
		BankAccount.deposit(amount);
	}

}