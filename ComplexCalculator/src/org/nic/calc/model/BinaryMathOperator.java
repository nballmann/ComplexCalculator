package org.nic.calc.model;

import org.nic.calc.util.MathOperatorInterface;

public abstract class BinaryMathOperator implements MathOperatorInterface
{
	@Override
	public final ComplexNumber execute(ComplexNumber lhs, ComplexNumber rhs)
	{
		ComplexNumber result = executeImplementation(lhs, rhs);
		return result;
	}

	abstract protected ComplexNumber executeImplementation(ComplexNumber lhs, ComplexNumber rhs);
}
