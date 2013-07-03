package org.nic.calc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import org.nic.calc.util.IPaneController;

public class CalculatorController implements IPaneController {

	@SuppressWarnings("unused")
	private RootController rootController;
	
	@FXML
	private ToggleGroup operatorGroup;
	@FXML
	private ToggleButton toggleAdd;
	
	@FXML
	private ToggleButton toggleSub;
	
	@FXML
	private ToggleButton toggleMul;
	
	@FXML
	private ToggleButton toggleDiv;
	
	@FXML
	private TextField real1Output;
	
	@FXML
	private TextField real2Output;
	
	@FXML
	private TextField imag1Output;
	
	@FXML
	private TextField imag2Output;
	
	@FXML
	private TextField real1Input;
	
	@FXML
	private TextField real2Input;
	
	@FXML
	private TextField imag1Input;
	
	@FXML
	private TextField imag2Input;
	
	
	
	
	@FXML
	private void initialize()
	{
		real1Output.textProperty().bind(real1Input.textProperty());
		real2Output.textProperty().bind(real2Input.textProperty());
		imag1Output.textProperty().bind(imag1Input.textProperty());
		imag2Output.textProperty().bind(imag2Input.textProperty());
	}
	
	@Override
	public void setScreenParent(RootController rootController) {
		this.rootController = rootController;
	}

}
