/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculation;
import java.util.Stack;
import java.util.HashMap;
import Exceptions.CalculatorException;

/**
 *
 * @author crypt
 */
public final class Evaluator {
	private static HashMap<String, Operation> textToOperation;
	private static HashMap<String, Double> variable;
	private Stack<Token> result;
	
	Evaluator () {
    setOperation("(", 1, -10, n -> {return n[0];}); // operandCount, precedence and method are 
    																								// just placeholders and are not required here.
		setOperation("+", 2, 1, n -> {
			return n[0] + n[1];
		});
		setOperation("-", 2, 1, n -> {
			return n[0] - n[1];
		});
		setOperation("*", 2, 2, n -> {
			return n[0] * n[1];
		});
		setOperation("/", 2, 2, n -> {
			return n[0] / n[1];
		});
		setOperation("^", 2, 3, n -> {
			return Math.pow(n[0], n[1]);
		});
		setOperation("!", 1, 3, n -> {
			Double fact = 1.0;
			for (int i = 1; i <= n[0]; i++) {
				fact *= i;
			}
			return fact;
		});
		setOperation("root", 2, -1, n -> {
			return Math.pow(n[0], 1 / n[1]);
		});
		setOperation("sqrt", 1, -1, n -> {
			return Math.sqrt(n[0]);
		});
		setOperation("max", 2, -1, n -> {
			return Math.max(n[0], n[1]);
		});
		setOperation("min", 2, -1, n -> {
			return Math.min(n[0], n[1]);
		});
		setOperation("sin", 1, -1, n -> {
			return Math.sin(n[0]);
		});
	}
	/**
		textToOperation converts the operation in a string to actual
		operation that can be applied to operands. Example:

	textToOperation.put("+", new Operation(2, 1, (n) -> {
		return n[0] + n[1];
	}));
		This converts "+" sign into an operation that takes to arguments
		and its precedence is 1, and finally the function itself.
		
		Note: if precedence is -1 that means it well be treated as a function.
	*/
  public void addVariable () {}
	public void setOperation (String text,
													 int operandCount,
													 int precedence,
													 OperationFunction fun) {
		textToOperation.put(text, new Operation(operandCount, precedence, fun));
	}
	public void calculateExpression (String expr) throws CalculatorException {
		Stack<Operation> operations = new Stack<> ();
		Stack<Token> postfix = new Stack<> ();
		boolean notOperation = false;
		char c;
		for (int i = 0; i < expr.length(); i++) {
			c = expr.charAt(i);
			if ((c >= '0' && c <= '9') || c == '.') {
				if (notOperation)
					throw new CalculatorException("Syntax Error: Couldn't find operation at " + i);
				notOperation = true;
				int end = endOfParseToDouble(expr, i);
				Double num = Double.valueOf(expr.substring(i, end));
				Token tok = new Token(Token.TokenType.OPERAND);
				tok.setNumber(num);
				postfix.push(tok);
				i = end + 1;
			} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				if (notOperation)
					throw new CalculatorException("Syntax Error: Couldn't find operation at " + i);
				notOperation = true;
				int end = endOfParseToNotNumber(expr, i);
				String tokenString = expr.substring(i, end);
				if (textToOperation.containsKey(tokenString)) {	// tokenString is function or operator
					Operation op = textToOperation.get(tokenString);
					if (op.getPrecedence() == -1) { // function 

						// check to see the parentheses after the function
						for (int j = i; j < expr.length(); j++) { 
							if (expr.charAt(j) == ' ') continue;
							if (expr.charAt(j) == '(') break; // OK
							throw new CalculatorException("Syntax Error: There must be perantheses after function at " + j);
						}
						Token function = new Token(Token.TokenType.OPERATION);
						function.setOperation(op);
						postfix.push(function);
					} else if (op.getPrecedence() >= 0) { // operator
						while (!postfix.empty() &&
							op.getPrecedence() <=
							postfix.lastElement().getOperation().getPrecedence()) {
							Token t = new Token(Token.TokenType.OPERATION);
							t.setOperation(operations.pop());
							postfix.push(t);
						}
						operations.push(op);
					}
					
				} else if(variable.containsKey(tokenString)) {	// tokenString is variable
					
				} else { 				// tokenString is typo
					throw new CalculatorException("Syntax Error: Unknown token at " + i);
				}
			}
		}
	}
	private int endOfParseToDouble (String expr, int start) throws CalculatorException {
		boolean pointFound = false;
		char c;
		for (int i = start; i < expr.length(); i++) {
			c = expr.charAt(i);
			if (c == '.') {
				if (pointFound)
					throw new CalculatorException("Syntax Error: More than one decimal point at character " + i);
				pointFound = true;
				continue;
			}
			if (c >= '0' && c <= '9') continue;
			return i;
		}
		return expr.length() - 1;
	}
	private int endOfParseToNotNumber (String expr, int start) throws CalculatorException {
		char c;
		for (int i = start; i < expr.length(); i++) {
			c = expr.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) continue;
			return i;
		}
		return expr.length() - 1;
	}
};

/*

1 * 1 + 2 * 5 / 2

opr
* 
postfix
1 1

result
*/