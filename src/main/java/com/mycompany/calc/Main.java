/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calc;
import Calculation.Evaluator;
import Exceptions.CalculatorException;

/**
 *
 * @author Mostafa
 */
public class Main {

    public static void main(String[] args) {
      MainFrame frame = new MainFrame();
      frame.setVisible(true);
        
        String m = "ahmed(3 * 5 /2) - 2";
        try{
            Evaluator ev = new Evaluator();
           System.out.print(ev.calculateExpression(m)); 
        }catch (CalculatorException e){
            System.out.println(e);
        }

    }
}
