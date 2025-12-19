import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class MainDriver {

	public static void main(String[] args) {

		Account account1 = new Account("BS026","Bob Smith", 2000.00);

		HashSet<Transaction> transactions = new HashSet<Transaction>();

		Scanner scan = new Scanner(System.in);
		System.out.println("======================================");
		System.out.println("     Welcome To The Banking App");
		System.out.println("======================================");
		System.out.println(" ");

		for(int i = 0; i < 5; i++){
			System.out.println("Enter CREDIT transaction " + (i+1) + " amount:");
			double amount = scan.nextDouble();
			transactions.add(new Transaction(amount, "Credit"));
		}

		for(int i = 0; i < 3; i++){
			System.out.println("Enter DEBIT transaction " + (i+1) + " amount:");
			double amount = scan.nextDouble();
			transactions.add(new Transaction(amount, "Debit"));
		}

		scan.close();
		System.out.println(" ");
		System.out.println("======================================");
		System.out.println("     Account ID: " + account1.getAccountId());
		System.out.println("     Account Holder: " + account1.getAccountHolder());
		System.out.println("     Starting Balance: $" + account1.getBalance());
		System.out.println("======================================");

		Iterator<Transaction> iterator = transactions.iterator();
		while (iterator.hasNext()) {
			Transaction t = iterator.next();

			if(t.getTransType().equals("Credit")) {
				double newBalance = account1.getBalance() + t.getAmount();
				account1.setBalance(newBalance);
				System.out.println("Transaction ID: " + t.generateId() + " | Type: " + t.getTransType() + " | Amount: $" + t.getAmount() + " | New Balance: $" + account1.getBalance());
			} else if(t.getTransType().equals("Debit")) {
				double newBalance = account1.getBalance() - t.getAmount();
				account1.setBalance(newBalance);
				System.out.println("Transaction ID: " + t.generateId() + " | Type: " + t.getTransType() + " | Amount: $" + t.getAmount() + " | New Balance: $" + account1.getBalance());
			}
		}
		System.out.println(" ");
		System.out.println("======================================");
		System.out.println("Final Balance: $" + account1.getBalance());
		System.out.println("======================================");
	}

}
