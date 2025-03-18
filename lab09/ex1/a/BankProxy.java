package a;
public class BankProxy implements BankAccount {
    private BankAccountImpl bankAccount;

    public BankProxy(BankAccountImpl bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (Company.user == User.OWNER) {
            return bankAccount.withdraw(amount);
        }
        return false;
    }

    @Override
    public double balance() {
        if (Company.user == User.OWNER) {
            return bankAccount.balance();
        }
        return 0;
    }
}
