package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class sendHandlerClass implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Application Sent!");
    }

}
