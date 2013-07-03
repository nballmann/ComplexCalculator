package org.nic.calc.model;

public class Multiply extends BinaryMathOperator {

	@Override
	protected ComplexNumber executeImplementation(ComplexNumber lhs,
			ComplexNumber rhs) {
		return new ComplexNumber((lhs.getReal()*rhs.getReal()-lhs.getImag()*rhs.getImag()), 
				(lhs.getReal()*rhs.getImag()+lhs.getImag()*rhs.getReal()));
	}

}
