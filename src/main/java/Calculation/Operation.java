/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculation;
import Exceptions.CalculatorException;

/**
 *
 * @author Ahmed El-esseily (Crypt212)
 */

public class Operation { 
	final public String name;
	final public int operandsCount;
	final public int precedence;
	final public OperationFunction method;

	public Operation(Operation opr) {
		this.name = opr.name;
		this.operandsCount = opr.operandsCount;
		this.precedence = opr.precedence;
		this.method = opr.method;
	}
	public Operation(String name, int operands_count, int precedence, OperationFunction method) {
		this.name = name;
		this.operandsCount = operands_count;
		this.precedence = precedence;
		this.method = method;
	}
	public String getName() {
		return name;
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
