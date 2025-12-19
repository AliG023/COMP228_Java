package Lab3_AG_F2025;

public class SavingsAccount_AG extends BankAccount_AG {

	public SavingsAccount_AG(int accountNumber, double balance) {
		super(accountNumber, balance);

	}

	@Override
	public void withdraw(double amount) {
		if (balance - amount < 50) {
			System.out.println("This Amount Would Take You Below $50. Your Balance Is: " + balance);
		} else {
			super.withdraw(amount);
		}
	}

}
