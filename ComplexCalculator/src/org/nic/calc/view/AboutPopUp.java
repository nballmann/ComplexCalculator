package org.nic.calc.view;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class AboutPopUp extends Popup
{
	final Label about = new Label("About");
	final Label description = new Label("Complex Calculator");
	final Label author = new Label("N.Ballmann");
	final Button okBtn = new Button("Ok");
	final VBox vBox = new VBox();
	
	public AboutPopUp(Stage stage)
	{
		okBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				hide();
			}
			
		});
		vBox.getChildren().addAll(about, description, author, okBtn);
		
		setAutoFix(true);
		setHideOnEscape(true);
		getContent().addAll(vBox);
		setX(200);
		setY(150);
		
		
		show(stage);
	}
	
}
