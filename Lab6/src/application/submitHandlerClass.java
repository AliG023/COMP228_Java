package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class submitHandlerClass implements EventHandler<ActionEvent> {

	private final TextField firstNameField;
	private final TextField lastNameField;
	private final TextField emailField;
	private final TextField portfolioField;
	private final TextField positionField;
	private final TextField salaryField;
	private final TextField startDateField;
	private final TextField phoneField;
	private final TextField faxField;
	private final TextField companyField;

	// Constructor
	public submitHandlerClass(TextField firstNameField, TextField lastNameField, TextField emailField,
			TextField portfolioField, TextField positionField, TextField salaryField,
			TextField startDateField, TextField phoneField, TextField faxField,
			TextField companyField) {
		this.firstNameField = firstNameField;
		this.lastNameField = lastNameField;
		this.emailField = emailField;
		this.portfolioField = portfolioField;
		this.positionField = positionField;
		this.salaryField = salaryField;
		this.startDateField = startDateField;
		this.phoneField = phoneField;
		this.faxField = faxField;
		this.companyField = companyField;
	}

	@Override
	public void handle(ActionEvent event) {
		Applicant applicant = new Applicant();
		applicant.setFirstName(firstNameField.getText().trim());
		applicant.setLastName(lastNameField.getText().trim());
		applicant.setEmail(emailField.getText().trim());
		applicant.setWebsite(portfolioField.getText().trim());
		applicant.setPosition(positionField.getText().trim());

		// Validate Number Fields
		try {
			String salaryStr = salaryField.getText().trim();
			int salary = salaryStr.isEmpty() ? 0 : Integer.parseInt(salaryStr);
			applicant.setSalary(salary);

			String phoneStr = phoneField.getText().trim();
			int phone = phoneStr.isEmpty() ? 0 : Integer.parseInt(phoneStr);
			applicant.setPhone(phone);

			String faxStr = faxField.getText().trim();
			int fax = faxStr.isEmpty() ? 0 : Integer.parseInt(faxStr);
			applicant.setFax(fax);
		} catch (NumberFormatException nfe) {
			Alert bad = new Alert(AlertType.ERROR);
			bad.setTitle("Validation Error");
			bad.setHeaderText(null);
			bad.setContentText("Please enter numeric values for Salary, Phone, and Fax.");
			bad.showAndWait();
			return;
		}

		applicant.setStartDate(startDateField.getText().trim());
		applicant.setCompany(companyField.getText().trim());

		// Save Applicant to Database
		boolean saved = Database.saveApplicant(applicant);
		Alert alert = new Alert(saved ? AlertType.INFORMATION : AlertType.ERROR);
		alert.setTitle(saved ? "Success" : "Error");
		alert.setHeaderText(null);
		alert.setContentText(
				saved ? "Application submitted successfully." : "Failed to submit application. Check logs.");
		alert.showAndWait();

		// Clear All Form Fields
		firstNameField.clear();
		lastNameField.clear();
		emailField.clear();
		portfolioField.clear();
		positionField.clear();
		salaryField.clear();
		startDateField.clear();
		phoneField.clear();
		faxField.clear();
		companyField.clear();
	}

}
