package a;

class Person {
	
private String name;
private BankAccount bankAccount;

	public Person(String n) {
		name = n;
        this.bankAccount = new BankProxy(new BankAccountImpl("PeDeMeia", 0));
	}

	public String getName() {
		return name;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
}