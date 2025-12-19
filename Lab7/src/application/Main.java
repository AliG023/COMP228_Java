package application;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		UserDao userDao = new UserDao();

		primaryStage.setTitle("Emploement Application");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Personal Information");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label fullNameLabel = new Label("Full Name:");
		grid.add(fullNameLabel, 0, 1);

		TextField fullNameTextField = new TextField();
		grid.add(fullNameTextField, 1, 1);

		Label currentAddressLabel = new Label("Current Address:");
		grid.add(currentAddressLabel, 0, 2);

		TextField currentAddressTextField = new TextField();
		grid.add(currentAddressTextField, 1, 2);

		Label contactNumberLabel = new Label("Contact Number:");
		grid.add(contactNumberLabel, 0, 3);

		TextField contactNumberTextField = new TextField();
		grid.add(contactNumberTextField, 1, 3);

		Label emailAddressLabel = new Label("Email Address:");
		grid.add(emailAddressLabel, 0, 4);

		TextField emailAddressTextField = new TextField();
		grid.add(emailAddressTextField, 1, 4);

		Label highestEducationLabel = new Label("Highest Education:");
		grid.add(highestEducationLabel, 0, 5);

		TextField highestEducationTextField = new TextField();
		grid.add(highestEducationTextField, 1, 5);

		Label genderLabel = new Label("Gender:");
		grid.add(genderLabel, 0, 6);

		ToggleGroup genderGroup = new ToggleGroup();
		RadioButton maleRadio = new RadioButton("Male");
		maleRadio.setToggleGroup(genderGroup);
		RadioButton femaleRadio = new RadioButton("Female");
		femaleRadio.setToggleGroup(genderGroup);
		HBox genderBox = new HBox(10);
		genderBox.getChildren().addAll(maleRadio, femaleRadio);
		grid.add(genderBox, 1, 6);

		Label dateAvailableLabel = new Label("Date Available:");
		grid.add(dateAvailableLabel, 0, 7);

		TextField dateAvailableTextField = new TextField();
		grid.add(dateAvailableTextField, 1, 7);

		Label desiredPositionLabel = new Label("Desired Position:");
		grid.add(desiredPositionLabel, 0, 8);

		TextField desiredPositionTextField = new TextField();
		grid.add(desiredPositionTextField, 1, 8);

		Label desiredSalaryLabel = new Label("Desired Salary:");
		grid.add(desiredSalaryLabel, 0, 9);

		TextField desiredSalaryTextField = new TextField();
		grid.add(desiredSalaryTextField, 1, 9);

		Label areYouLegalLabel = new Label("Are you legally authorized to work in the Canada?");
		grid.add(areYouLegalLabel, 0, 10);

		ToggleGroup areYouLegalGroup = new ToggleGroup();
		RadioButton areYouLegalYes = new RadioButton("Yes");
		areYouLegalYes.setToggleGroup(areYouLegalGroup);
		RadioButton areYouLegalNo = new RadioButton("No");
		areYouLegalNo.setToggleGroup(areYouLegalGroup);
		HBox areYouLegalBox = new HBox(10);
		areYouLegalBox.getChildren().addAll(areYouLegalYes, areYouLegalNo);
		grid.add(areYouLegalBox, 1, 10);

		Label relativesWorkingLabel = new Label("Do you have Relatives Working for our company:");
		grid.add(relativesWorkingLabel, 0, 11);

		ToggleGroup relativesWorkingGroup = new ToggleGroup();
		RadioButton relativesWorkingYes = new RadioButton("Yes");
		relativesWorkingYes.setToggleGroup(relativesWorkingGroup);
		RadioButton relativesWorkingNo = new RadioButton("No");
		relativesWorkingNo.setToggleGroup(relativesWorkingGroup);
		HBox relativesWorkingBox = new HBox(10);
		relativesWorkingBox.getChildren().addAll(relativesWorkingYes, relativesWorkingNo);
		grid.add(relativesWorkingBox, 1, 11);

		Label ifYesLabel = new Label("If yes, please specify:");
		grid.add(ifYesLabel, 0, 12);

		TextField ifYesTextField = new TextField();
		grid.add(ifYesTextField, 1, 12);

		Button saveButton = new Button("Submit");
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.BOTTOM_RIGHT);
		hBox.getChildren().add(saveButton);
		grid.add(hBox, 1, 13);

		saveButton.setOnAction(actionEvent -> {
			String fullName = fullNameTextField.getText().trim();
			String currentAddress = currentAddressTextField.getText().trim();
			String contactNumberText = contactNumberTextField.getText().trim();
			String emailAddress = emailAddressTextField.getText().trim();
			String highestEducation = highestEducationTextField.getText().trim();
			String dateAvailable = dateAvailableTextField.getText().trim();
			String desiredPosition = desiredPositionTextField.getText().trim();
			String desiredSalaryText = desiredSalaryTextField.getText().trim();
			String ifYes = ifYesTextField.getText().trim();

			javafx.scene.control.Toggle selectedGender = genderGroup.getSelectedToggle();
			String gender = null;
			if (selectedGender != null) {
				gender = ((RadioButton) selectedGender).getText();
			}

			javafx.scene.control.Toggle selectedAreYouLegal = areYouLegalGroup.getSelectedToggle();
			String areYouLegal = null;
			if (selectedAreYouLegal != null) {
				areYouLegal = ((javafx.scene.control.RadioButton) selectedAreYouLegal).getText();
			}

			javafx.scene.control.Toggle selectedRelativesWorking = relativesWorkingGroup.getSelectedToggle();
			String relativesWorking = null;
			if (selectedRelativesWorking != null) {
				relativesWorking = ((javafx.scene.control.RadioButton) selectedRelativesWorking).getText();
			}

			if (!StringPool.BLANK.equals(fullName) && !StringPool.BLANK.equals(currentAddress) &&
					!StringPool.BLANK.equals(contactNumberText) && !StringPool.BLANK.equals(emailAddress) &&
					!StringPool.BLANK.equals(highestEducation) && gender != null && areYouLegal != null
					&& relativesWorking != null) {
				int contactNumber;
				try {
					contactNumber = Integer.parseInt(contactNumberText);
				} catch (NumberFormatException nfe) {
					this.alert("Error", "Contact number must be numeric!", AlertType.ERROR);
					return;
				}

				int desiredSalary = 0;
				if (!StringPool.BLANK.equals(desiredSalaryText)) {
					try {
						desiredSalary = Integer.parseInt(desiredSalaryText);
					} catch (NumberFormatException nfe) {
						this.alert("Error", "Desired salary must be numeric!", AlertType.ERROR);
						return;
					}
				}

				try {
					if (!userDao.userExists(fullName)) {
						User user = this.createUserObject(fullName, currentAddress, contactNumber, emailAddress,
								highestEducation, gender, dateAvailable, desiredPosition, desiredSalary, areYouLegal,
								relativesWorking, ifYes);
						int userId = userDao.saveUser(user);
						if (userId > 0) {
							this.alert("Submit", "Successful!", AlertType.INFORMATION);
						} else {
							this.alert("Error", "Failed!", AlertType.ERROR);
						}
					} else {
						this.alert("Error", "Applicant already exists!", AlertType.ERROR);
					}
				} catch (SQLException ex) {
					System.out.println("Exception occured");
					System.out.println(ex.getMessage());
					System.out.println(ex.getErrorCode());
					System.out.println(ex.getSQLState());
				}
			} else {
				this.alert("Error", "Please complete fields!", AlertType.ERROR);
			}

		});

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public void alert(String title, String message, AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}

	public User createUserObject(String fullName, String currentAddress, int contactNumber,
			String emailAddress, String highestEducation, String gender, String dateAvailable, String desiredPosition,
			int desiredSalary, String areYouLegal, String relativesWorking, String ifYes) {
		User user = new User();
		user.setfullName(fullName);
		user.setcurrentAddress(currentAddress);
		user.setContactNumber(contactNumber);
		user.setEmailAddress(emailAddress);
		user.setHighestEducation(highestEducation);
		user.setGender(gender);
		user.setDateAvailable(dateAvailable);
		user.setDesiredPosition(desiredPosition);
		user.setDesiredSalary(desiredSalary);
		user.setAreYouLegal(areYouLegal);
		user.setRelativesWorking(relativesWorking);
		user.setIfYes(ifYes);

		return user;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
