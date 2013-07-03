package org.nic.calc.model;

public class Add extends BinaryMathOperator {

	@Override
	protected ComplexNumber executeImplementation(ComplexNumber lhs,
			ComplexNumber rhs) {
		return new ComplexNumber((lhs.getReal()+rhs.getReal()), (lhs.getImag()+rhs.getImag()));
	}

}
