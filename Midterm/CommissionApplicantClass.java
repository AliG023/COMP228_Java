public class CommissionApplicantClass extends ApplicantClass{

	// Fields
	double grossSales;
	double commissionRate;
	
	
	// Constructor
	public CommissionApplicantClass(String firstName, String lastName, int socialInsurance, double grossSales, double commissionRate) {
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
		if (grossSales <= 0) {
			System.out.println("Gross Sales Must Be Given");
		}
		if (commissionRate <= 0) {
			System.out.println("Commission Rate Must Be Given");
		}
		
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	
	// Getters and Setters
	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	
	
	// Override Earnings Method
	@Override
	public double earnings() {
		return grossSales * commissionRate;
	};
	
	// To String Override
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + " \nSIN: " + socialInsurance + " \nGross Sales: $" + grossSales + " \nCommission Rate: " + commissionRate + "\nEarnings: $" + earnings() + "\n" ;
	}
	
	
	
	
	
}
