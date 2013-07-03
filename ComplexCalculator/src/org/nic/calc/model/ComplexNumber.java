package org.nic.calc.model;

import javafx.beans.property.SimpleDoubleProperty;

public class ComplexNumber 
{
	private SimpleDoubleProperty real;
	private SimpleDoubleProperty imag;
	
	public ComplexNumber() {}
	
	public ComplexNumber(double real, double imag) {
		this.real.set(real);
		this.imag.set(imag);
	}
		
	public SimpleDoubleProperty getRealProperty() { return real; }
	public SimpleDoubleProperty getImagProperty() { return imag; }
	
	public double getReal()	{ return real.get(); }
	public double getImag() { return imag.get(); }
	
	public void setReal(double newReal)	{ real.set(newReal); }	
	public void setImag(double newImag)	{ real.set(newImag); }
}
