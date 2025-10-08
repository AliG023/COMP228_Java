package Lab4_AG_F2025;

import java.math.BigDecimal;

public class BankAccount_AG extends User {

	public double balance;

	BankAccount_AG(String firstName, String lastName, int accountNumber, double balance) {
		super(firstName, lastName, accountNumber);
		if (balance < 0) {
			System.out.println("Balance Cannot Be Below 0");
		} else {
			this.balance = balance;
		}
	}

	// Static Deposit Methods Overloaded to take Int, Double or BigDecimal
	public static void deposit(BankAccount_AG account, int amount) {
		account.balance = account.getBalance() + amount;
		System.out.println("Your New Balance is: " + String.format("%.2f", account.balance));
	}

	public static void deposit(BankAccount_AG account, double amount) {
		account.balance = account.getBalance() + amount;
		System.out.println("Your New Balance is: " + String.format("%.2f", account.balance));
	}

	public static void deposit(BankAccount_AG account, BigDecimal amount) {
		account.balance = BigDecimal.valueOf(account.getBalance()).add(amount).doubleValue();
		System.out.println("Your New Balance is: " + String.format("%.2f", account.balance));
	}

	// Withdraw Method Overloaded to take Int, Double or BigDecimal

	public void withdraw(int amount) {
		balance = getBalance() - amount;
		System.out.println("Your New Balance Is: " + String.format("%.2f", balance));
	}

	public void withdraw(double amount) {
		balance = getBalance() - amount;
		System.out.println("Your New Balance Is: " + String.format("%.2f", balance));
	}

	public void withdraw(BigDecimal amount) {
		balance = BigDecimal.valueOf(getBalance()).subtract(amount).doubleValue();
		System.out.println("Your New Balance Is: " + String.format("%.2f", balance));
	}

	// Get Balance Method

	public double getBalance() {
		return balance;
	}

	// Override toString Method to display account details

	@Override
	public String toString() {
		return "Account Number: " + accountNumber + " belongs to " + firstName + " " + lastName + " and the Balance= $"
				+ String.format("%.2f", balance);
	}

}
