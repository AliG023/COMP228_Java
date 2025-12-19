package Lab4_AG_F2025;

public abstract class User {
	
	public final String firstName;
	public final String lastName;
	public final int accountNumber;
	
	User(String firstName, String lastName, int accountNumber){
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}
}
