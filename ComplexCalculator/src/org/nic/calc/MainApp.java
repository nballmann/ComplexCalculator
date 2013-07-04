package org.nic.calc;

import org.nic.calc.controller.RootController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application 
{
	public static final String ROOT_SCREEN_ID = "root";
	public static final String ROOT_SCREEN_FILE = "../view/RootPane.fxml";
	public static final String CALC_SCREEN_ID = "calc";
	public static final String CALC_SCREEN_FILE = "../view/CalculatorPane.fxml";
	
//	private Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
//		stage = primaryStage;
		RootController rootController = new RootController(primaryStage);
		
		rootController.loadScreen(ROOT_SCREEN_ID, ROOT_SCREEN_FILE);
		rootController.loadScreen(CALC_SCREEN_ID, CALC_SCREEN_FILE);
		
		BorderPane mainPane = (BorderPane) rootController.getScreen(ROOT_SCREEN_ID);
		mainPane.setCenter(rootController.getScreen(CALC_SCREEN_ID));
		
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.show();
	}
	

	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
