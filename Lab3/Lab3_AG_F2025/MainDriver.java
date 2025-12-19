package Lab3_AG_F2025;

import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int accountNo;
		double balance;
		double amount;
		int choice;

		// Account 1
		System.out.println("Please Enter Your #1 Account Number: ");
		accountNo = scan.nextInt();
		System.out.println("Please Enter Your #1 Current Balance: ");
		balance = scan.nextDouble();
		SavingsAccount_AG Account1 = new SavingsAccount_AG(accountNo, balance);

		// Account 2
		System.out.println("Please Enter Your #2 Account Number: ");
		accountNo = scan.nextInt();
		System.out.println("Please Enter Your #2 Current Balance: ");
		balance = scan.nextDouble();
		SavingsAccount_AG Account2 = new SavingsAccount_AG(accountNo, balance);

		// Account 3
		System.out.println("Please Enter Your #3 Account Number: ");
		accountNo = scan.nextInt();
		System.out.println("Please Enter Your #3 Current Balance: ");
		balance = scan.nextDouble();
		SavingsAccount_AG Account3 = new SavingsAccount_AG(accountNo, balance);

		System.out.println(Account1.toString());
		System.out.println(Account2.toString());
		System.out.println(Account3.toString());

		// Deposit and Withdraw From Account 1
		for (int i = 0; i < 3; i++) {
			System.out.println("ACCOUNT #1 Please Enter \n 1 - Deposit \n 2 - Withdraw ");
			choice = scan.nextInt();
			if (choice == 1) {
				System.out.println("Deposit Amount for Account #1: ");
				amount = scan.nextDouble();
				Account1.deposit(amount);
			} else if (choice == 2) {
				System.out.println("Withdraw Amount for Account #1: ");
				amount = scan.nextDouble();
				Account1.withdraw(amount);
			} else {
				System.out.println("Please Enter A Valid Option ");
			}
		}

		// Deposit and Withdraw From Account 2
		for (int i = 0; i < 3; i++) {
			System.out.println("ACCOUNT #2 Please Enter \n 1 - Deposit \n 2 - Withdraw ");
			choice = scan.nextInt();
			if (choice == 1) {
				System.out.println("Deposit Amount for Account #2: ");
				amount = scan.nextDouble();
				Account2.deposit(amount);
			} else if (choice == 2) {
				System.out.println("Withdraw Amount for Account #2: ");
				amount = scan.nextDouble();
				Account2.withdraw(amount);
			} else {
				System.out.println("Please Enter A Valid Option ");
			}
		}

		// Deposit and Withdraw From Account 3
		for (int i = 0; i < 3; i++) {
			System.out.println("ACCOUNT #3 Please Enter \n 1 - Deposit \n 2 - Withdraw ");
			choice = scan.nextInt();
			if (choice == 1) {
				System.out.println("Deposit Amount for Account #3: ");
				amount = scan.nextDouble();
				Account3.deposit(amount);
			} else if (choice == 2) {
				System.out.println("Withdraw Amount for Account #3: ");
				amount = scan.nextDouble();
				Account3.withdraw(amount);
			} else {
				System.out.println("Please Enter A Valid Option ");
			}
		}

		System.out.println(Account1.toString());
		System.out.println(Account2.toString());
		System.out.println(Account3.toString());

		scan.close();
	}
}
