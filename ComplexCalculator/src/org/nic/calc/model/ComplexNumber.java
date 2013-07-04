package org.nic.calc.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ComplexNumber 
{
	private DoubleProperty real = new SimpleDoubleProperty();
	private DoubleProperty imag = new SimpleDoubleProperty();
	
	public ComplexNumber() {
	}
	
	public ComplexNumber(double real, double imag) {
		setReal(real);
		setImag(imag);
	}
		
	public DoubleProperty getRealProperty() { return real; }
	public DoubleProperty getImagProperty() { return imag; }
	
	public double getReal()	{ return real.get(); }
	public double getImag() { return imag.get(); }
	
	public void setReal(double newReal)	{ real.set(newReal); }	
	public void setImag(double newImag)	{ imag.set(newImag); }
	
}
