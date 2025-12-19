public abstract class ApplicantClass {

	// Fields
	String firstName;
	String lastName;
	int socialInsurance;
	
	// Constructor
	public ApplicantClass(String firstName, String lastName, int socialInsurance) {
		super();
		
	// Validation to check fields are not empty
		if (firstName == null) {
			System.out.println("First Name Must Be Given");
		}
		if (lastName == null) {
			System.out.println("Last Name Must Be Given");
		}
		if (socialInsurance <= 0 ) {
			System.out.println("Social Insurance Must Be Given");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialInsurance = socialInsurance;
	}
	
	// Earnings Method
	public double earnings() {
		return 0;
	};
}

