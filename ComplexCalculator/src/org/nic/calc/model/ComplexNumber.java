package org.nic.calc.model;

import javafx.beans.property.SimpleDoubleProperty;

public class ComplexNumber 
{
	private SimpleDoubleProperty real;
	private SimpleDoubleProperty imag;
		
	public SimpleDoubleProperty getRealProperty() { return real; }
	public SimpleDoubleProperty getImagProperty() { return imag; }
	
	public double getReal()	{ return real.get(); }
	public double getImag() { return imag.get(); }
	
	public void setReal(double newReal)	{ real.set(newReal); }	
	public void setImag(double newImag)	{ real.set(newImag); }
}
