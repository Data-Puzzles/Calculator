/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author Ahmed El-esseily (Crypt212)
 */
public class CalculatorException extends Exception {
	public String errorType;
	public String error;
	public CalculatorException (String errorType, String error) {
		super(errorType + ": " + error);
		this.errorType = errorType;
		this.error = error;
	}
}
