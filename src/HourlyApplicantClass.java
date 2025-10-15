public class HourlyApplicantClass extends ApplicantClass {
	
	//Fields
	int wage;
	int hours;
	
	
	// Constructor
	public HourlyApplicantClass(String firstName, String lastName, int socialInsurance, int wage, int hours) {
		super(firstName, lastName, socialInsurance);
		
		// Validation to check fields are not empty
		if (firstName == null) {
			System.out.println("First Name Must Be Given");
		}
		if (lastName == null) {
			System.out.println("Last Name Must Be Given");
		}
		if (socialInsurance <= 0) {
			System.out.println("Social Insurance Must Be Given");
		}		
		if (wage <= 0) {
			System.out.println("Wage Must Be Given");
		}
		if (hours <= 0) {
			System.out.println("Hours Must Be Given");
		}
		
		this.wage = wage;
		this.hours = hours;
	}
	
	// Getters and Setters
	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	
	// Override Earnings Method
	@Override
	public double earnings() {
		return wage * hours;
	};
	
	// To String Override
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + " \nSIN: " + socialInsurance + " \nHour Rate: $" + wage + " \nHours worked: " + hours + "\nEarnings: $" + earnings() + "\n";
	}
	
	
	
}
