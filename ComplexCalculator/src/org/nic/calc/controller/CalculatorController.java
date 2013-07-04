package org.nic.calc.controller;

import java.text.DecimalFormat;
import java.util.HashMap;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import org.nic.calc.model.Add;
import org.nic.calc.model.BinaryMathOperator;
import org.nic.calc.model.ComplexNumber;
import org.nic.calc.model.Divide;
import org.nic.calc.model.Multiply;
import org.nic.calc.model.Subtract;
import org.nic.calc.util.IPaneController;

public class CalculatorController implements IPaneController {

	private static final DecimalFormat DF = new DecimalFormat("#0.###");
	
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
	private TextField resultOutput;
	
	private HashMap<Toggle, BinaryMathOperator> operatorMap = new HashMap<>();
	
	private BinaryMathOperator actualOperator;
	
	private Add add = new Add();
	private Subtract sub = new Subtract();
	private Multiply mul = new Multiply();
	private Divide div = new Divide();
	
	private double r1, r2, i1, i2;
	
	private SimpleStringProperty resultStr = new SimpleStringProperty();

	
	@FXML
	private void initialize()
	{		
		real1Output.textProperty().bind(real1Input.textProperty());
		real2Output.textProperty().bind(real2Input.textProperty());
		imag1Output.textProperty().bind(imag1Input.textProperty().concat("i"));
		imag2Output.textProperty().bind(imag2Input.textProperty().concat("i"));
		
		operatorMap.put(toggleAdd, add);
		operatorMap.put(toggleSub, sub);
		operatorMap.put(toggleMul, mul);
		operatorMap.put(toggleDiv, div);
		
		resultOutput.textProperty().bind(resultStr);
		resultStr.set("0");
		
		actualOperator = operatorMap.get(toggleAdd);
		toggleAdd.disableProperty().set(true);
		
		real1Input.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldString, String newString) {
				try {
					newString = newString.replace(',', '.');
					r1 = Double.parseDouble(newString);
				} catch(NullPointerException e) {
					resultStr.set("No valid input");
				} catch(NumberFormatException e) {
					resultStr.set("No valid input");
				}
				showResult();
			}
			
		});
		
		real2Input.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldString, String newString) {
				try {
					newString = newString.replace(',', '.');
					r2 = Double.parseDouble(newString);
				} catch(NullPointerException e) {
					resultStr.set("No valid input");
				} catch(NumberFormatException e) {
					resultStr.set("No valid input");
				}
				showResult();
			}
			
		});
		
		imag1Input.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldString, String newString) {
				try {
					newString = newString.replace(',', '.');
					i1 = Double.parseDouble(newString);
				} catch(NullPointerException e) {
					resultStr.set("No valid input");
				} catch(NumberFormatException e) {
					resultStr.set("No valid input");
				}
				showResult();
			}
			
		});
		
		imag2Input.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldString, String newString) {
				try {
					newString = newString.replace(',', '.');
					i2 = Double.parseDouble(newString);
				} catch(NullPointerException e) {
					resultStr.set("No valid input");
				} catch(NumberFormatException e) {
					resultStr.set("No valid input");
				}
				showResult();
			}
			
		});
		
		operatorGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable,
					Toggle oldValue, Toggle newValue) 
			{
				ToggleButton a = (ToggleButton) newValue;
				ToggleButton b = (ToggleButton) oldValue;
				a.disableProperty().set(true);
				b.disableProperty().set(false);
				actualOperator = operatorMap.get(newValue);
				showResult();
		
			}		
		});
		
	}
	
	private void showResult()
	{
		try {
			ComplexNumber result = actualOperator.execute(new ComplexNumber(r1, i1), new ComplexNumber(r2, i2));
			
			resultStr.set(DF.format(result.getReal()) + " + " + DF.format(result.getImag()) + "i");
			
		} catch(NumberFormatException e) {
			resultStr.set("No valid input");
		} catch(NullPointerException ex) {
			resultStr.set("null");
		} catch(StringIndexOutOfBoundsException ex) {
			resultStr.set("null");
		}
	}
	
	@Override
	public void setScreenParent(RootController rootController) {
		this.rootController = rootController;
	}

}
