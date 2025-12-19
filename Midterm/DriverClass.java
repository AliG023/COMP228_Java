public class DriverClass {

	public static void main(String[] args) {
		
		// Constructing 3 Hourly Applicants.
		HourlyApplicantClass hourly1 = new HourlyApplicantClass("Bob", "Smith", 12345678, 34, 40);
		HourlyApplicantClass hourly2 = new HourlyApplicantClass("Sarah", "Tyler", 23456789, 46, 36);
		HourlyApplicantClass hourly3 = new HourlyApplicantClass("Gordon", "Brown", 34567891, 32, 46);
		
		// Constructing 3 Commission Applicants.
		CommissionApplicantClass commission1 = new CommissionApplicantClass("Jeff", "Flop", 45678912, 45000, 0.15);
		CommissionApplicantClass commission2 = new CommissionApplicantClass("Linda", "Lopeze", 56789123, 55000, 0.16);
		CommissionApplicantClass commission3 = new CommissionApplicantClass("Mary", "Marpole", 67891234, 32000, 0.12);
		
        // Printing 3 Hourly Applicants.
		System.out.println(hourly1.toString());
		System.out.println(hourly2.toString());
		System.out.println(hourly3.toString());
		System.out.println("======================================================================");
		// Printing 3 Commission Applicants.
		System.out.println(commission1.toString());
		System.out.println(commission2.toString());
		System.out.println(commission3.toString());

	}

}
