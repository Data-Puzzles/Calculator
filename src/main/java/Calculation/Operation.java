/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculation;
import Exceptions.CalculatorException;

interface OperationFunction {
	Double compute(Double[] operands);
};

/**
 *
 * @author crypt
 */
public class Operation { 
	private int operandsCount;
	private int precedence;
	private OperationFunction method;
	public Operation(Operation opr) {
		this.operandsCount = opr.operandsCount;
		this.precedence = opr.precedence;
		this.method = opr.method;
	}
	public Operation(int operands_count, int precedence, OperationFunction method) {
		this.operandsCount = operands_count;
		this.precedence = precedence;
		this.method = method;
	}
	public int getOperandsCount() {
		return operandsCount;
	}
	public int getPrecedence() {
		return precedence;
	}
	public Double call(Double[] operands) throws CalculatorException {
		if (operands.length != operandsCount)
		throw new CalculatorException("Number operands doesn't match function's operands");
		return this.method.compute(operands);
	}
};
