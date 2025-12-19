package application;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

public class readHandlerClass implements EventHandler<ActionEvent> {

	private TextArea outputArea;

	public readHandlerClass(TextArea outputArea) {
		this.outputArea = outputArea;
	}

	@Override
	public void handle(ActionEvent event) {
		List<Applicant> apps = Database.getAllApplicants();
		if (apps == null || apps.isEmpty()) {
			outputArea.setText("No applicants found.");
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < apps.size(); i++) {
			Applicant a = apps.get(i);
			sb.append("Applicant ").append(i + 1).append("\n");
			sb.append("Name: ").append(nullToEmpty(a.getFirstName()))
					.append(" ").append(nullToEmpty(a.getLastName())).append("\n");
			sb.append("Email: ").append(nullToEmpty(a.getEmail())).append("\n");
			sb.append("Website: ").append(nullToEmpty(a.getWebsite())).append("\n");
			sb.append("Position: ").append(nullToEmpty(a.getPosition())).append("\n");
			sb.append("Salary: ").append(a.getSalary()).append("\n");
			sb.append("Start Date: ").append(nullToEmpty(a.getStartDate())).append("\n");
			sb.append("Phone: ").append(a.getPhone()).append("\n");
			sb.append("Fax: ").append(a.getFax()).append("\n");
			sb.append("Last Company: ").append(nullToEmpty(a.getCompany())).append("\n");
			sb.append("---------------------------\n");
		}

		outputArea.setText(sb.toString());
	}

	private String nullToEmpty(String s) {
		return s == null ? "" : s;
	}
}