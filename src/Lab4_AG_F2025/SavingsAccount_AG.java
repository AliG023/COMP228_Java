package Lab4_AG_F2025;

public class SavingsAccount_AG extends BankAccount_AG {

	public SavingsAccount_AG(String firstName, String lastName, int accountNumber, double balance) {
		super(firstName, lastName, accountNumber, balance);

	}

	// Override the BankAccount withdraw method
	@Override
	public void withdraw(double amount) {
		if (balance - amount < 50) {
			System.out.println(
					"This Amount Would Take You Below $50. Your Balance Is: " + String.format("%.2f", balance));
		} else {
			super.withdraw(amount);
		}
	}

}
