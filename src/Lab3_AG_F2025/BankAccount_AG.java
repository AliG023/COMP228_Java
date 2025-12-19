package Lab3_AG_F2025;

public class BankAccount_AG {

	public final int accountNumber;
	public double balance;

	BankAccount_AG(int accountNumber, double balance) {
		if (balance < 0) {
			System.out.println("Balance Cannot Be Below 0");
		} else {
			this.balance = balance;
		}
		this.accountNumber = accountNumber;

	}

	public void deposit(double amount) {
		balance = getBalance() + amount;
		System.out.println("Your New Balance is: " + balance);
	}

	public void withdraw(double amount) {
		balance = getBalance() - amount;
		System.out.println("Your New Balance Is: " + balance);
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account Number= " + accountNumber + ", Balance= $" + balance;
	}

}
