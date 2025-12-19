package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CustomHorizontalTop extends HBox {

    public CustomHorizontalTop() {
        setSpacing(10);
        setPadding(new Insets(8));
        setAlignment(Pos.CENTER);

        Image img = new Image(getClass().getResourceAsStream("images/ice_hut.jpg"));
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(250);
        imgView.setPreserveRatio(true);

        getChildren().addAll(imgView);
    }

}