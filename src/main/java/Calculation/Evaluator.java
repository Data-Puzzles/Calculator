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
 * @author Ahmed El-esseily (Crypt212)
 */
public final class Evaluator {
	final private static HashMap<String, Operation> textToOperation = new HashMap<>();
	final private static HashMap<String, Double> variable = new HashMap<>();
	final private Stack<Token> postfix;
	final private Stack<Double> result;
	
	public Evaluator () throws CalculatorException {
		postfix = new Stack<>();
		result = new Stack<>();
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
			
    setOperation("(", 1, 0, n -> {return n[0];}); // operandCount, precedence and method are 
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
			if (n[1] == 0) 
				throw new CalculatorException("Math Error: Can't divid by zero");
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
		setOperation("cos", 1, -1, n -> {
			return Math.cos(n[0]);
		});
		setOperation("tan", 1, -1, n -> {
			return Math.tan(n[0]);
		});
		setOperation("fib", 1, -1, n -> {
			if (n[0] == 0 || n[0] == 1) return 1.0;
			Double f0 = 1.0; Double f1 = 1.0;
			for (int i = 2; i <= n[0]; i++) {
				f1 += f0;
				f0 = f1 - f0;
			}
			return f1;
		});
	}
	private int endOfParseToNumber (String expr, int start) throws CalculatorException {
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
			return i - 1;
		}
		return expr.length() - 1;
	}
	private int endOfParseToNotNumber (String expr, int start) throws CalculatorException {
		char c;
		for (int i = start; i < expr.length(); i++) {
			c = expr.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) continue;
			return i - 1;
		}
		return expr.length() - 1;
	}
	private void posfixPushDouble (Double num) {
		Token tok = new Token(Token.TokenType.OPERAND);
		tok.setNumber(num);
		postfix.push(tok);
	}
	private void posfixPushOperation (Operation opr) {
		Token tok = new Token(Token.TokenType.OPERATION);
		tok.setOperation(opr);
		postfix.push(tok);
	}
	private String checkExpressionFront (String expr, int start) throws CalculatorException {
		char c;
		for (int i = start; i < expr.length(); i++) {
			c = expr.charAt(i);
			if (c == ' ') {} // do nothing
			else if ((c >= '0' && c <= '9') || c == '(') // first of expression is a number 
				break;
			else if (c == '+' ||c == '-') { // found plus or minus sign infront of expression 
				String firstHalf = new String(expr.substring(0, i));
				String secondHalf = new String(expr.substring(i, expr.length()));
				expr = firstHalf + "0" + secondHalf; // add 0 befor the sign
				break;
			}
			else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				int end = endOfParseToNotNumber(expr, i);
				String tok = expr.substring(i, end + 1);
				
				if (variable.containsKey(tok))
					break; // first of expression is a variable
				
				if (textToOperation.containsKey(tok) && textToOperation.get(tok).getPrecedence() == -1)
					break; // first of expression is a function
				
			}
			else
				throw new CalculatorException("Syntax Error: operator at index " + i + " is not allawed");
		}
		return expr;
	}
	public void setVariable (String name, Double value) throws CalculatorException {
		if (textToOperation.containsKey(name)) 
			throw new CalculatorException("This variable name is resevred in operations.");
		variable.put(name, value);
	}
	public void setOperation (String name,
	                          int operandCount,
	                          int precedence,
	                          OperationFunction fun) {
		textToOperation.put(name, new Operation(name, operandCount, precedence, fun));
	}
	public Double calculateExpression(String expr) throws CalculatorException {
		preparePostfix(expr);
		
		result.clear();
		for (int i = 0; i < postfix.size(); i++) {
			switch (postfix.elementAt(i).getType()) {
				case OPERAND -> result.push(postfix.elementAt(i).getNumber());
				case OPERATION -> {
					Operation op = new Operation(postfix.elementAt(i).getOperation());
					int size = op.getOperandsCount();
					Double[] operands = new Double [size];
					for (int j = 0; j < size; j++) {
						if (postfix.empty()) 
							throw new CalculatorException ("Syntax Error: Number of arguments for " + op.getName() + " operation can only be " + op.getOperandsCount());
						operands[size - j - 1] = result.pop();
					}
					result.push(op.method.compute(operands));
				}

			}
		}
		if (result.size() != 1) throw new CalculatorException ("WTF1" + result.size());
		
		return result.peek();
	}


	public void preparePostfix (String expr) throws CalculatorException {
		Stack<Operation> operations = new Stack<> ();
		boolean lastNotOperator = false; // first element to be scaned must not be an operator
		int commaCount = 0; // for function calls
		char c;

		// make sure if first is a number
		expr = checkExpressionFront(expr, 0);
		for (int i = 0; i < expr.length(); i++) {
			c = expr.charAt(i);
			
			// -------space--------
			if (c == ' ') continue;

			// ------------------------- leteral number -----------------------------
			if ((c >= '0' && c <= '9') || c == '.') { 

				if (lastNotOperator)
					throw new CalculatorException("Syntax Error: Couldn't find operator at index " + i);
				lastNotOperator = true;
				int end = endOfParseToNumber(expr, i);
				Double num = Double.valueOf(expr.substring(i, end + 1));
				posfixPushDouble(num);
				i = end;
						
			// ---------------------- function or variable ---------------------------
			} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
					
				if (lastNotOperator)
					throw new CalculatorException("Syntax Error: Couldn't find operator at index " + i);
				lastNotOperator = true;

				int end = endOfParseToNotNumber(expr, i);
				String tokenString = expr.substring(i, end + 1);
				i = end;
				if (textToOperation.containsKey(tokenString)	// function  ----------
					&& textToOperation.get(tokenString).getPrecedence() == -1) {
					Operation op = textToOperation.get(tokenString);

					// check to see the perantheses after the function
					for (int j = i + 1; j < expr.length(); j++) { 
						if (expr.charAt(j) == ' ') continue;
						if (expr.charAt(j) != '(') 
							throw new CalculatorException("Syntax Error: There must be perantheses after function at index " + j);
						break; // OK!
					}
					commaCount = op.operandsCount - 1; // need exactly commaCount comma's to end this function
					operations.push(op);
					
					
				} else if (variable.containsKey(tokenString)) {	// variable -----------
					
					posfixPushDouble(variable.get(tokenString));
					
				} else // token is typo -----------------------------------------------
					
					throw new CalculatorException("Syntax Error: Unknown token at index " + i);

			// --------------------------- operator ---------------------------------
			} else if (textToOperation.containsKey(String.valueOf(c))) {

				if ((c != '(') && !lastNotOperator) // two operators in a row, (ex. 1 + + 2)
					throw new CalculatorException("Syntax Error: Operand needed at index " + i);
				lastNotOperator = false;
				
				if (c == '(') expr = checkExpressionFront(expr, i + 1);
				Operation op = textToOperation.get(String.valueOf(c));
				if (!(op.getPrecedence() <= 0)) 
					while (!operations.empty() &&
						op.getPrecedence() <=
						operations.peek().getPrecedence()) {
						posfixPushOperation(operations.pop());
					}
				
				operations.push(op);
						
			// -------------- end of perantheses or function comma ------------------
			} else if (c == ')' || c == ',') {
				
				lastNotOperator = false;
				while (!operations.empty() && 
					operations.peek().getPrecedence() != 0) // not the '(' operator
					posfixPushOperation(operations.pop());
				
				if (operations.empty()) 
					throw new CalculatorException("Syntax Error: Found closing ) at index " + i + ", but did find the opening");
				if (c == ')') {
					lastNotOperator = true;
					operations.pop(); // throw the ')' operator
					if (!operations.empty() &&
					     operations.peek().getPrecedence() == -1) // function
						posfixPushOperation(operations.pop());
					if (commaCount != 0) {
						throw new CalculatorException("Syntax Error: Function at index " + i + " must take more arguements");
					}
				}
				if (c == ',') {
					expr = checkExpressionFront(expr, i + 1);
					if (commaCount-- < 0)
						throw new CalculatorException("Syntax Error: Function at index " + i + " must take less arguements");
				}
				
			// ------------------------ Unknown -------------------------------------
			} else
				throw new CalculatorException("Syntax Error: Unknown token at index " + i);
		}

		// cleanup the operations stack
		if (!lastNotOperator)
			throw new CalculatorException("Syntax Error: An operand is required at the end of expression");
		while (!operations.empty()) {
			if (operations.peek().getPrecedence() == 0) // found '('
				throw new CalculatorException("Syntax Error: Found opening ( but didn't find the closing");
			posfixPushOperation(operations.pop());
		}

		
	}
};