/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculation;

/**
 *
 * @author crypt
 */
public class Token {
	public final TokenType type;
	private Operation opr;
	private Double number;
	public enum TokenType {OPERAND, OPERATION};
	public Token (TokenType type) {
		number = 0.0;
		opr = null;
		this.type = type;
	}
	public TokenType getType () {
		return type;
	}
	public void setOperation (Operation opr) {
		this.opr = new Operation(opr);
	}
	public void setNumber (Double number) {
		this.number = number;
	}
	public Operation getOperation () {
		return this.opr;
	}
	public Double getNumber () {
		return this.number;
	}
};