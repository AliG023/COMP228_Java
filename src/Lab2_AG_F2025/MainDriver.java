package Lab2_AG_F2025;
import java.util.Scanner;
import java.math.BigDecimal;

public class MainDriver {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String choice = "";


	        while (!choice.equalsIgnoreCase("exit")) {
	            System.out.print("\nWhat type of interest would you like to calculate? (simple (s)/compound(c)/exit): ");
	            choice = scanner.next();

	            if (choice.equalsIgnoreCase("exit")) {
	                System.out.println("Thank you for using the calculator. Goodbye!");
	                break;
	            }

	            if (!choice.equalsIgnoreCase("s") && !choice.equalsIgnoreCase("c")) {
	                System.out.println("Invalid choice. Please type 's' for Simple Interest, 'c' for Compound Interest, or 'exit' to quit.");
	                continue;
	            }

	            System.out.print("Enter the principal amount: ");
	            double principal = scanner.nextDouble();
	            System.out.print("Enter the interest rate %: ");
	            double rate = scanner.nextDouble();
	            System.out.print("Enter the time in years: ");
	            BigDecimal timeBigDecimal = scanner.nextBigDecimal();
	            double time = timeBigDecimal.doubleValue();

	            try {
	            	
	                Interest userInterest = new Interest(principal, rate, time);

	                if (choice.equals("s")) {
	                    double simpleInterest = userInterest.calculateSimpleInterest(userInterest.getPrincipal(), userInterest.getRate(), userInterest.getTime());
	                    System.out.println("Calculated Simple Interest: $" + simpleInterest);
	                } else if (choice.equals("c")) {
	                    double compoundInterest = userInterest.calculateCompoundInterest(userInterest.getPrincipal(), userInterest.getRate(), userInterest.getTime());
	                    System.out.println("Calculated Compound Interest: $" + compoundInterest);
	                }
	            } catch (IllegalArgumentException e) {
	                System.out.println("\nError: " + e.getMessage());
	            }
	        }

	        scanner.close();
	    }
}
