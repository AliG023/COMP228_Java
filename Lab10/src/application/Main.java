package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Pane Setup ---------------------------------------
			BorderPane pane = new BorderPane();
			GridPane lottoPicker = new GridPane();
			primaryStage.setTitle("Lotto Picker");
			Label pickerTitle = new Label("Quick Pick Lotto");
			pickerTitle.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
			pickerTitle.setAlignment(Pos.CENTER);
			lottoPicker.add(pickerTitle,0,0,2,1);
			pane.setCenter(lottoPicker);
			
			// Form Layout Settings ------------------------------

			lottoPicker.setAlignment(Pos.CENTER);
			lottoPicker.setHgap(10);
			lottoPicker.setVgap(10);
			lottoPicker.setPadding(new Insets(10));
			ColumnConstraints col1 = new ColumnConstraints();
			ColumnConstraints col2 = new ColumnConstraints();
			ColumnConstraints col3 = new ColumnConstraints();
			col1.setPercentWidth(33);
			col2.setPercentWidth(33);
			col3.setPercentWidth(33);
			col1.setHgrow(Priority.ALWAYS);
			col2.setHgrow(Priority.ALWAYS);
			col3.setHgrow(Priority.ALWAYS);
			lottoPicker.getColumnConstraints().addAll(col1, col2, col3);
			

			// Picker Options -------------------------------------

			lottoPicker.add(new Label("Minimum Number:" ), 0, 1);
			Spinner<Integer> minNumber = new Spinner<>(1, 100, 1);
			minNumber.setEditable(true);
			lottoPicker.add(minNumber, 1, 1);

			lottoPicker.add(new Label("Maximum Number: "), 0, 2);
			Spinner<Integer> maxNumber = new Spinner<>(1,100,100);
			maxNumber.setEditable(true);
			lottoPicker.add(maxNumber, 1, 2);

			lottoPicker.add(new Label("Quantity Of Balls: "), 0, 3);
			Spinner<Integer> qtyBalls = new Spinner<>(1,6,6);
			qtyBalls.setEditable(true);
			lottoPicker.add(qtyBalls, 1, 3);
			

			// Button ---------------------------------------------
			
			HBox buttonBox = new HBox(10);
			buttonBox.setAlignment(Pos.CENTER);
			
			Button genNumbers = new Button("Generate Lotto Numbers");
			
			buttonBox.getChildren().addAll(genNumbers);
			lottoPicker.add(buttonBox, 1, 6);
			

			// Generator ------------------------------------------

			VBox resultsBox = new VBox(5);
			resultsBox.setAlignment(Pos.CENTER);

			Label resultsLabel = new Label("Your Lotto Numbers Are:");
			Label results = new Label();
			results.setId("results");
			resultsBox.getChildren().addAll(resultsLabel, results);
			lottoPicker.add(resultsBox, 1, 9);
			
			
			GenerateHandler generate = new GenerateHandler(minNumber, maxNumber, qtyBalls, results);
			genNumbers.setOnAction(generate);
			

			// Scene Creation --------------------------------------
			
			Scene scene = new Scene(pane,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
