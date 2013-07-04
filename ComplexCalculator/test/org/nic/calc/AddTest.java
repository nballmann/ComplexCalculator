package org.nic.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.nic.calc.model.Add;
import org.nic.calc.model.ComplexNumber;

public class AddTest 
{
	@Test
	public void EveryAdditionShouldReturnAResult()
	{
		Add add = new Add();
		ComplexNumber a = new ComplexNumber(1.0, 2.0);
		ComplexNumber b = new ComplexNumber(3.0, 4.0);
		System.out.println(a.getReal() + " + " + a.getImag() + " / " + b.getReal() + " + " + b.getImag());
		ComplexNumber result = add.execute(a, b);
		System.out.println(a.getReal() + " + " + a.getImag() + " / " + b.getReal() + " + " + b.getImag());
		assertEquals(4, result.getReal(),0.0001);
		
	}
}
