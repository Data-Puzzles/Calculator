/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Calculation;
import Exceptions.CalculatorException;

/**
 *
 * @author Ahmed El-esseily (Crypt212)
 */
public interface OperationFunction {
	public Double compute(Double[] operands) throws CalculatorException;
};
