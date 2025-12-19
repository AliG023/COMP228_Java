package application;

import java.security.SecureRandom;
import java.util.Hashtable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

public class GenerateHandler implements EventHandler<ActionEvent> , Runnable {

    // Field Declarations
    protected Spinner<Integer> minNumber;
    protected Spinner<Integer> maxNumber;
    protected Spinner<Integer> qtyBalls;
    private SecureRandom randomNumber = new SecureRandom();
    private Hashtable<Integer, int[]> lottoTable = new Hashtable<>();
	private int min, max, qty;
    private Label resultArea;

    // Constructor
    public GenerateHandler(Spinner<Integer> minNumber, Spinner<Integer> maxNumber,
                           Spinner<Integer> qtyBalls, Label resultArea) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.qtyBalls = qtyBalls;
        this.resultArea = resultArea;
    }

	@Override
    public void handle(ActionEvent event) {
        min = minNumber.getValue();
        max = maxNumber.getValue();
        qty = qtyBalls.getValue();

        // Input Validation
        if (min >= max) {
            resultArea.setText("Error: Minimum number must be less than Maximum number.");
            return;
        }
        if (qty > (max - min + 1)) {
            resultArea.setText("Error: Quantity of balls exceeds the range of numbers.");
            return;
        }
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {

        StringBuilder allResults = new StringBuilder();
        lottoTable.clear();

		// Generate 5 Picks
        for (int num = 0; num < 5; num++) {
            int[] numbers = generateNumbers(min, max, qty);
            lottoTable.put(num, numbers);

            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                if (i > 0) resultBuilder.append(" , ");
                	resultBuilder.append(numbers[i]);
            }

            synchronized (allResults) {
                allResults.append("Pick ")
                    .append(num + 1)
                    .append(":   ")
                    .append(resultBuilder)
                    .append("\n");
			}
        }

        String finalText;
		synchronized (allResults) {
            finalText = allResults.toString();
        }
        
		// Update UI with Results
		javafx.application.Platform.runLater(() -> resultArea.setText(finalText));

        // Save to Database
		LottoExport.savePicktoDatabase(min,max,qty,finalText);

    }

	// Method For Lotto Number
	private int[] generateNumbers(int min, int max, int qty) {
		int[] lottoNumbers = new int[qty];
		for (int i = 0; i < qty; i++) {
			lottoNumbers[i] = randomNumber.nextInt((max - min) + 1) + min;
		}
		return lottoNumbers;
	}
}


