package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomHorizontalBottom extends HBox {
    public CustomHorizontalBottom() {
        setSpacing(10);
        setPadding(new Insets(8));
        setAlignment(Pos.CENTER);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        String today = LocalDate.now().format(fmt);

        Label lbl = new Label("Today: " + today);
        getChildren().add(lbl);
    }
}