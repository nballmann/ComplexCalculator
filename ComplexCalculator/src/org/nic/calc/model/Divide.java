package org.nic.calc.model;

public class Divide extends BinaryMathOperator {

	@Override
	protected ComplexNumber executeImplementation(ComplexNumber lhs,
			ComplexNumber rhs) {
		return new ComplexNumber((lhs.getReal()*rhs.getReal()+lhs.getImag()*rhs.getImag())/
				(rhs.getReal()*rhs.getReal()+rhs.getImag()*rhs.getImag()),
				(lhs.getImag()*rhs.getReal()-lhs.getReal()*rhs.getImag())/
				(rhs.getReal()*rhs.getReal()+rhs.getImag()*rhs.getImag()));
	}

}
