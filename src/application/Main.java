package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		BorderPane pane = new BorderPane();

		pane.setTop(new CustomHorizontalTop());
		pane.setRight(new CustomPane("Right"));
		pane.setBottom(new CustomHorizontalBottom());
		pane.setLeft(new CustomPane("Left"));
		pane.setCenter(new CustomPane("Center"));

		GridPane employmentForm = new GridPane();
		Label formTitle = new Label("Employment Application Form");
		formTitle.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		formTitle.setAlignment(Pos.CENTER);
		employmentForm.add(formTitle, 0, 0, 2, 1);
		pane.setCenter(employmentForm);

		// Form Layout Settings ------------------------------
		employmentForm.setAlignment(Pos.CENTER);
		employmentForm.setHgap(10);
		employmentForm.setVgap(10);
		employmentForm.setPadding(new Insets(10));
		ColumnConstraints col1 = new ColumnConstraints();
		ColumnConstraints col2 = new ColumnConstraints();
		col1.setPercentWidth(50);
		col2.setPercentWidth(50);
		col1.setHgrow(Priority.ALWAYS);
		col2.setHgrow(Priority.ALWAYS);
		employmentForm.getColumnConstraints().addAll(col1, col2);

		// Form Fields ---------------------------------------
		employmentForm.add(new Label("First Name *:"), 0, 1);
		employmentForm.add(new TextField(), 0, 2);
		employmentForm.add(new Label("Last Name *:"), 1, 1);
		employmentForm.add(new TextField(), 1, 2);
		employmentForm.add(new Label("Email *:"), 0, 3);
		TextField emailField = new TextField();
		employmentForm.add(emailField, 0, 4, 2, 1);
		employmentForm.add(new Label("Portfolio Website:"), 0, 5);
		TextField portfolioField = new TextField();
		portfolioField.setText("http://");
		employmentForm.add(portfolioField, 0, 6, 2, 1);
		employmentForm.add(new Label("Position You Are Applying For *:"), 0, 7);
		employmentForm.add(new TextField(), 0, 8);
		employmentForm.add(new Label("Salary Requirements:"), 0, 9);
		employmentForm.add(new TextField(), 0, 10);
		employmentForm.add(new Label("When Can You Start:"), 1, 9);
		employmentForm.add(new TextField(), 1, 10);
		employmentForm.add(new Label("Phone *:"), 0, 11);
		employmentForm.add(new TextField(), 0, 12);
		employmentForm.add(new Label("Fax:"), 1, 11);
		employmentForm.add(new TextField(), 1, 12);
		employmentForm.add(new Label("Are You Willing to Relocate?"), 0, 13);

		// Radio Options ------------------------------------
		HBox relocateBox = new HBox(10);
		relocateBox.setAlignment(Pos.CENTER);
		ToggleGroup relocateGroup = new ToggleGroup();
		RadioButton relocateYes = new RadioButton("Yes");
		relocateYes.setToggleGroup(relocateGroup);
		RadioButton relocateNo = new RadioButton("No");
		relocateNo.setToggleGroup(relocateGroup);
		relocateNo.setSelected(true);
		RadioButton relocateNotSure = new RadioButton("Not Sure");
		relocateNotSure.setToggleGroup(relocateGroup);

		employmentForm.add(relocateYes, 0, 14);
		employmentForm.add(relocateNo, 1, 14);
		employmentForm.add(relocateNotSure, 2, 14);

		relocateBox.getChildren().addAll(relocateYes, relocateNo, relocateNotSure);
		employmentForm.add(relocateBox, 0, 14);
		// ---------------------------------------------------

		employmentForm.add(new Label("Last Company You Worked For:"), 0, 15);
		employmentForm.add(new TextField(), 0, 16);
		employmentForm.add(new Label("Reference / Comments / Questions:"), 0, 17);
		TextArea commentArea = new TextArea();
		employmentForm.add(commentArea, 0, 18, 2, 1);

		// Buttons ------------------------------------------
		HBox buttonBox = new HBox(10);
		buttonBox.setAlignment(Pos.CENTER);
		Button sendButton = new Button("Send Application");
		sendHandlerClass sendHandler = new sendHandlerClass();
		sendButton.setOnAction(sendHandler);
		buttonBox.getChildren().add(sendButton);
		employmentForm.add(buttonBox, 0, 19);
		// ---------------------------------------------------

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowBorderPane"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	public static void main(String[] args) {
		launch(args);
	}
}