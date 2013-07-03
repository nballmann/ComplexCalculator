package org.nic.calc.util;

import org.nic.calc.model.ComplexNumber;

public interface MathOperatorInterface {
	
	public abstract ComplexNumber execute(ComplexNumber lhs, ComplexNumber rhs);

}
