/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.calc;

import Calculation.Evaluator;
import Exceptions.CalculatorException;
import Calculation.Operation;

import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Stack;
import static javax.management.Query.gt;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;


/**
 *
 * @author Mostafa Mahmoud
 */
public class MainFrame extends javax.swing.JFrame {

    // my vairiables-
    private JButton btw[];
    private JButton Operations[];
    private Evaluator ev;
    private String resultTemp;
    private String eqTemp;
    private Stack<String> eqStack = new Stack<>();
    private Stack<String> resultStack = new Stack<>();
    private Boolean resultDone;
    
    /**
     * Creates new form NewJFrame
     */
    public MainFrame() {
        resultDone = false;
        initComponents();
        Color col = new Color(39,49,57);
        getContentPane().setBackground(col);
       jTabbedPane1.setSelectedIndex(9);
       
        
        try {
            ev = new Evaluator();
        } catch (CalculatorException e) {
            
        }
        
      //buttons in main 
    Component[] components = this.getContentPane().getComponents();
    JButton[] buttons = new JButton[0];
    for (Component component : components) {
        if (component instanceof JButton) {
            buttons = Arrays.copyOf(buttons, buttons.length + 1);
            buttons[buttons.length - 1] = (JButton) component;
        }
    }
    for (JButton button : buttons) {
        button.setBackground(Color.RED);
    }
        btw = new JButton[25];
        btw[0] = zero;
        btw[1] = one;
        btw[2] = two;
        btw[3] = three;
        btw[4] = four;
        btw[5] = five;
        btw[6] = six;
        btw[7] = seven;
        btw[8] = eight;
        btw[9] = nine;
        btw[10] = DEL;
        btw[11] = mult;
        btw[12] = divid;
        btw[13] = plus;
        btw[14] = minus;
        btw[15] =AC;
        btw[16] =equal;
        btw[17] =tan;
        btw[18] =ANS;
        btw[19] =dot;
        btw[20] =leftPerantheses;
        btw[21] =rightPerantheses;
        btw[22] =sin;
        btw[23] =cos;
        btw[24] =tan;
    }
    
    //my functions-
    
    private void numberOnly(java.awt.event.KeyEvent evt){
               char c =evt.getKeyChar();
        if(!Character.isDigit(c)&&c!='.'){
            evt.consume();
        }
    }
    private void handleAreaCalculation(String shapeType, String dimensionText1, String dimensionText2, JTextField lawTxt, JTextField resultTxt) {
        try {
            double dimension1 = Double.parseDouble(dimensionText1);
            double dimension2 = 0.0;
            if (!dimensionText2.isEmpty()) {
                   dimension2 = Double.parseDouble(dimensionText2);
                } else {
                    dimension2 = 0;
                }

            double result = 0;
            Shape s;
            switch (shapeType.toLowerCase()) {
                case "square":
                    s = new Square(dimension1);
                    break;
                case "rectangle":
                    s = new Rectangle(dimension1,dimension2);
                    break;
                case "triangle":
                    s= new Triangle(dimension1,dimension2);
                    break;
                case "circle":
                    s= new Circle(dimension1);
                    break;
                default:
                    throw new Exception();
            }
                result = s.calculateArea();
                resultTxt.setText(String.valueOf(result));
                lawTxt.setText(s.getLaw());

        } catch (Exception e) {
            showMessageDialog(null, "ERROR\nINVALID INPUT", "INVALID INPUT", ERROR_MESSAGE);
        }
    }
    private void set(String s, boolean basicOperator){
        if (resultDone && !basicOperator) 
            txt.setText("");

        resultDone = false;
				
        String all = txt.getText()+s;
        txt.setText(all);
    }
    private void setBtwColor(Color color) {
        for(JButton b:btw){
            b.setBackground(color);
        }
}
    private void setBtwTxtColor(Color color){
        for(JButton b:btw){
            b.setForeground(color);
        }
    }
    private void History(String resultTemp, String EqTemp,JTextPane  txtHistory){
        String eq = eqStack.push(EqTemp);
        String result =resultStack.push(resultTemp);
        txtHistory.setText(txtHistory.getText() + "\n" + eq + " = \n" + result + "\n_________________________");
    }

    

    //---------------------------------------------------
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    BasicWin = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    ligtingMode = new javax.swing.JToggleButton();
    txt = new javax.swing.JTextField();
    zero = new javax.swing.JButton();
    one = new javax.swing.JButton();
    two = new javax.swing.JButton();
    three = new javax.swing.JButton();
    four = new javax.swing.JButton();
    five = new javax.swing.JButton();
    six = new javax.swing.JButton();
    seven = new javax.swing.JButton();
    eight = new javax.swing.JButton();
    nine = new javax.swing.JButton();
    DEL = new javax.swing.JButton();
    mult = new javax.swing.JButton();
    divid = new javax.swing.JButton();
    plus = new javax.swing.JButton();
    minus = new javax.swing.JButton();
    AC = new javax.swing.JButton();
    equal = new javax.swing.JButton();
    dot = new javax.swing.JButton();
    ANS = new javax.swing.JButton();
    leftPerantheses = new javax.swing.JButton();
    rightPerantheses = new javax.swing.JButton();
    sin = new javax.swing.JButton();
    cos = new javax.swing.JButton();
    tan = new javax.swing.JButton();
    root = new javax.swing.JButton();
    fact = new javax.swing.JButton();
    log10 = new javax.swing.JButton();
    logN = new javax.swing.JButton();
    dot1 = new javax.swing.JButton();
    pow = new javax.swing.JButton();
    mode = new javax.swing.JButton();
    jLabel9 = new javax.swing.JLabel();
    mode1 = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jToggleButton1 = new javax.swing.JToggleButton();
    jLabel25 = new javax.swing.JLabel();
    mode2 = new javax.swing.JButton();
    mode3 = new javax.swing.JButton();
    ModeWin = new javax.swing.JPanel();
    jButton7 = new javax.swing.JButton();
    jLabel11 = new javax.swing.JLabel();
    jButton8 = new javax.swing.JButton();
    jButton10 = new javax.swing.JButton();
    jButton15 = new javax.swing.JButton();
    jButton11 = new javax.swing.JButton();
    AreasWin = new javax.swing.JPanel();
    jButton9 = new javax.swing.JButton();
    jLabel12 = new javax.swing.JLabel();
    jButton13 = new javax.swing.JButton();
    jButton14 = new javax.swing.JButton();
    jButton18 = new javax.swing.JButton();
    jButton22 = new javax.swing.JButton();
    squareWin = new javax.swing.JPanel();
    txt_sideLength = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton12 = new javax.swing.JButton();
    jLabel10 = new javax.swing.JLabel();
    SqAreaLaw = new javax.swing.JTextField();
    squareAreaResult = new javax.swing.JTextField();
    rectangularWin = new javax.swing.JPanel();
    txtLength = new javax.swing.JTextField();
    txtWidth = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jButton3 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jButton17 = new javax.swing.JButton();
    jLabel15 = new javax.swing.JLabel();
    RecAreaLaw = new javax.swing.JTextField();
    RecAreaResult = new javax.swing.JTextField();
    volumeCalcWin = new javax.swing.JPanel();
    jLabel13 = new javax.swing.JLabel();
    jButton19 = new javax.swing.JButton();
    jPanel1 = new javax.swing.JPanel();
    jLabel7 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextPane1 = new javax.swing.JTextPane();
    jButton5 = new javax.swing.JButton();
    jButton6 = new javax.swing.JButton();
    triangleWin = new javax.swing.JPanel();
    jButton16 = new javax.swing.JButton();
    jLabel14 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    txtbase = new javax.swing.JTextField();
    txtheight = new javax.swing.JTextField();
    jLabel17 = new javax.swing.JLabel();
    jLabel18 = new javax.swing.JLabel();
    jLabel19 = new javax.swing.JLabel();
    jButton20 = new javax.swing.JButton();
    jButton21 = new javax.swing.JButton();
    triLaw = new javax.swing.JTextField();
    triResult = new javax.swing.JTextField();
    circalWin = new javax.swing.JPanel();
    jLabel20 = new javax.swing.JLabel();
    jButton23 = new javax.swing.JButton();
    jLabel22 = new javax.swing.JLabel();
    txtRadius = new javax.swing.JTextField();
    jButton24 = new javax.swing.JButton();
    jButton25 = new javax.swing.JButton();
    circalAreaLaw = new javax.swing.JTextField();
    circalAreaResult = new javax.swing.JTextField();
    jPanel2 = new javax.swing.JPanel();
    jLabel21 = new javax.swing.JLabel();
    jLabel23 = new javax.swing.JLabel();
    jLabel24 = new javax.swing.JLabel();
    jButton26 = new javax.swing.JButton();
    jButton27 = new javax.swing.JButton();
    jButton28 = new javax.swing.JButton();
    jButton29 = new javax.swing.JButton();
    jButton30 = new javax.swing.JButton();
    jButton31 = new javax.swing.JButton();
    jButton32 = new javax.swing.JButton();
    jButton33 = new javax.swing.JButton();
    jButton34 = new javax.swing.JButton();
    jButton35 = new javax.swing.JButton();
    jButton36 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(32, 39, 44));
    setForeground(java.awt.Color.orange);
    setResizable(false);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    BasicWin.setBackground(new java.awt.Color(32, 39, 44));
    BasicWin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("MODE");
    BasicWin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 250, 30, 22));

    ligtingMode.setBackground(new java.awt.Color(54, 67, 76));
    ligtingMode.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
    ligtingMode.setForeground(new java.awt.Color(226, 241, 231));
    ligtingMode.setText("ON");
    ligtingMode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    ligtingMode.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ligtingModeActionPerformed(evt);
      }
    });
    ligtingMode.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        ligtingModeKeyPressed(evt);
      }
    });
    BasicWin.add(ligtingMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 270, 62, 30));

    txt.setBackground(new java.awt.Color(32, 39, 44));
    txt.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
    txt.setForeground(new java.awt.Color(255, 255, 255));
    txt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    txt.setCaretColor(new java.awt.Color(255, 255, 255));
    txt.setDisabledTextColor(new java.awt.Color(255, 255, 255));
    txt.setName("txt"); // NOI18N
    txt.setSelectedTextColor(new java.awt.Color(255, 255, 255));
    txt.setSelectionColor(new java.awt.Color(255, 255, 255));
    txt.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtActionPerformed(evt);
      }
    });
    BasicWin.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, 190));

    zero.setBackground(new java.awt.Color(54, 67, 76));
    zero.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    zero.setForeground(new java.awt.Color(226, 241, 231));
    zero.setText("0");
    zero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    zero.setName("zero"); // NOI18N
    zero.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        zeroActionPerformed(evt);
      }
    });
    BasicWin.add(zero, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 597, 62, 50));
    zero.getAccessibleContext().setAccessibleDescription("");

    one.setBackground(new java.awt.Color(54, 67, 76));
    one.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    one.setForeground(new java.awt.Color(226, 241, 231));
    one.setText("1");
    one.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    one.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        oneActionPerformed(evt);
      }
    });
    BasicWin.add(one, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 542, 62, 50));
    one.getAccessibleContext().setAccessibleDescription("");

    two.setBackground(new java.awt.Color(54, 67, 76));
    two.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    two.setForeground(new java.awt.Color(226, 241, 231));
    two.setText("2");
    two.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    two.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        twoActionPerformed(evt);
      }
    });
    BasicWin.add(two, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 542, 62, 50));
    two.getAccessibleContext().setAccessibleDescription("");

    three.setBackground(new java.awt.Color(54, 67, 76));
    three.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    three.setForeground(new java.awt.Color(226, 241, 231));
    three.setText("3");
    three.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    three.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        threeActionPerformed(evt);
      }
    });
    BasicWin.add(three, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 542, 62, 50));
    three.getAccessibleContext().setAccessibleDescription("");

    four.setBackground(new java.awt.Color(54, 67, 76));
    four.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    four.setForeground(new java.awt.Color(226, 241, 231));
    four.setText("4");
    four.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    four.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fourActionPerformed(evt);
      }
    });
    BasicWin.add(four, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 487, 62, 50));
    four.getAccessibleContext().setAccessibleDescription("");

    five.setBackground(new java.awt.Color(54, 67, 76));
    five.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    five.setForeground(new java.awt.Color(226, 241, 231));
    five.setText("5");
    five.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    five.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fiveActionPerformed(evt);
      }
    });
    BasicWin.add(five, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 487, 62, 50));
    five.getAccessibleContext().setAccessibleDescription("");

    six.setBackground(new java.awt.Color(54, 67, 76));
    six.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    six.setForeground(new java.awt.Color(226, 241, 231));
    six.setText("6");
    six.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    six.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        sixActionPerformed(evt);
      }
    });
    BasicWin.add(six, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 487, 62, 50));
    six.getAccessibleContext().setAccessibleDescription("");

    seven.setBackground(new java.awt.Color(54, 67, 76));
    seven.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    seven.setForeground(new java.awt.Color(226, 241, 231));
    seven.setText("7");
    seven.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    seven.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        sevenActionPerformed(evt);
      }
    });
    BasicWin.add(seven, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 432, 62, 50));
    seven.getAccessibleContext().setAccessibleDescription("");

    eight.setBackground(new java.awt.Color(54, 67, 76));
    eight.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    eight.setForeground(new java.awt.Color(226, 241, 231));
    eight.setText("8");
    eight.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    eight.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        eightActionPerformed(evt);
      }
    });
    BasicWin.add(eight, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 432, 62, 50));
    eight.getAccessibleContext().setAccessibleDescription("");

    nine.setBackground(new java.awt.Color(54, 67, 76));
    nine.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    nine.setForeground(new java.awt.Color(226, 241, 231));
    nine.setText("9");
    nine.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    nine.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nineActionPerformed(evt);
      }
    });
    BasicWin.add(nine, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 432, 62, 50));
    nine.getAccessibleContext().setAccessibleDescription("");

    DEL.setBackground(new java.awt.Color(35, 89, 35));
    DEL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    DEL.setForeground(new java.awt.Color(226, 241, 231));
    DEL.setText("DEL");
    DEL.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    DEL.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        DELActionPerformed(evt);
      }
    });
    BasicWin.add(DEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 432, 62, 50));
    DEL.getAccessibleContext().setAccessibleDescription("");

    mult.setBackground(new java.awt.Color(54, 67, 76));
    mult.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    mult.setForeground(new java.awt.Color(226, 241, 231));
    mult.setText("x");
    mult.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    mult.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        multActionPerformed(evt);
      }
    });
    BasicWin.add(mult, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 487, 62, 50));
    mult.getAccessibleContext().setAccessibleDescription("");

    divid.setBackground(new java.awt.Color(54, 67, 76));
    divid.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    divid.setForeground(new java.awt.Color(226, 241, 231));
    divid.setText("÷");
    divid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    divid.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        dividActionPerformed(evt);
      }
    });
    BasicWin.add(divid, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 487, 62, 50));
    divid.getAccessibleContext().setAccessibleDescription("");

    plus.setBackground(new java.awt.Color(54, 67, 76));
    plus.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    plus.setForeground(new java.awt.Color(226, 241, 231));
    plus.setText("+");
    plus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    plus.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        plusActionPerformed(evt);
      }
    });
    BasicWin.add(plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 542, 62, 50));
    plus.getAccessibleContext().setAccessibleDescription("");

    minus.setBackground(new java.awt.Color(54, 67, 76));
    minus.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    minus.setForeground(new java.awt.Color(226, 241, 231));
    minus.setText("-");
    minus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    minus.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        minusActionPerformed(evt);
      }
    });
    BasicWin.add(minus, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 542, 62, 50));
    minus.getAccessibleContext().setAccessibleDescription("");

    AC.setBackground(new java.awt.Color(35, 89, 35));
    AC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    AC.setForeground(new java.awt.Color(226, 241, 231));
    AC.setText("AC");
    AC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    AC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ACActionPerformed(evt);
      }
    });
    BasicWin.add(AC, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 432, 62, 50));
    AC.getAccessibleContext().setAccessibleDescription("");

    equal.setBackground(new java.awt.Color(54, 67, 76));
    equal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    equal.setForeground(new java.awt.Color(226, 241, 231));
    equal.setText("=");
    equal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    equal.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        equalActionPerformed(evt);
      }
    });
    BasicWin.add(equal, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 597, 62, 50));
    equal.getAccessibleContext().setAccessibleDescription("");

    dot.setBackground(new java.awt.Color(54, 67, 76));
    dot.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    dot.setForeground(new java.awt.Color(226, 241, 231));
    dot.setText(".");
    dot.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    dot.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        dotActionPerformed(evt);
      }
    });
    BasicWin.add(dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 597, 62, 50));
    dot.getAccessibleContext().setAccessibleDescription("");

    ANS.setBackground(new java.awt.Color(54, 67, 76));
    ANS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    ANS.setForeground(new java.awt.Color(226, 241, 231));
    ANS.setText("ANS");
    ANS.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    ANS.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ANSActionPerformed(evt);
      }
    });
    BasicWin.add(ANS, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 597, 62, 50));
    ANS.getAccessibleContext().setAccessibleDescription("");

    leftPerantheses.setBackground(new java.awt.Color(54, 67, 76));
    leftPerantheses.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    leftPerantheses.setForeground(new java.awt.Color(226, 241, 231));
    leftPerantheses.setText("(");
    leftPerantheses.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    leftPerantheses.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        leftPeranthesesActionPerformed(evt);
      }
    });
    BasicWin.add(leftPerantheses, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 260, 30, 50));
    leftPerantheses.getAccessibleContext().setAccessibleDescription("");

    rightPerantheses.setBackground(new java.awt.Color(54, 67, 76));
    rightPerantheses.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    rightPerantheses.setForeground(new java.awt.Color(226, 241, 231));
    rightPerantheses.setText(")");
    rightPerantheses.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    rightPerantheses.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        rightPeranthesesActionPerformed(evt);
      }
    });
    BasicWin.add(rightPerantheses, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 260, 30, 50));
    rightPerantheses.getAccessibleContext().setAccessibleDescription("");

    sin.setBackground(new java.awt.Color(54, 67, 76));
    sin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    sin.setForeground(new java.awt.Color(226, 241, 231));
    sin.setText("sin");
    sin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    sin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        sinActionPerformed(evt);
      }
    });
    BasicWin.add(sin, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 377, 62, 50));
    sin.getAccessibleContext().setAccessibleDescription("");

    cos.setBackground(new java.awt.Color(54, 67, 76));
    cos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    cos.setForeground(new java.awt.Color(226, 241, 231));
    cos.setText("cos");
    cos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    cos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cosActionPerformed(evt);
      }
    });
    BasicWin.add(cos, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 377, 62, 50));
    cos.getAccessibleContext().setAccessibleDescription("");

    tan.setBackground(new java.awt.Color(54, 67, 76));
    tan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    tan.setForeground(new java.awt.Color(226, 241, 231));
    tan.setText("tan");
    tan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    tan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tanActionPerformed(evt);
      }
    });
    BasicWin.add(tan, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 377, 62, 50));
    tan.getAccessibleContext().setAccessibleDescription("");

    root.setBackground(new java.awt.Color(54, 67, 76));
    root.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    root.setForeground(new java.awt.Color(226, 241, 231));
    root.setText("<html><sup style=\"font-size:10px;\">n</sup> &radic; x</html>");
    root.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    root.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        rootActionPerformed(evt);
      }
    });
    BasicWin.add(root, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 322, 62, 50));

    fact.setBackground(new java.awt.Color(54, 67, 76));
    fact.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    fact.setForeground(new java.awt.Color(226, 241, 231));
    fact.setText("X!");
    fact.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    fact.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        factActionPerformed(evt);
      }
    });
    BasicWin.add(fact, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 322, 62, 50));

    log10.setBackground(new java.awt.Color(54, 67, 76));
    log10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    log10.setForeground(new java.awt.Color(226, 241, 231));
    log10.setText("ln");
    log10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    log10.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        log10ActionPerformed(evt);
      }
    });
    BasicWin.add(log10, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 377, 62, 50));

    logN.setBackground(new java.awt.Color(54, 67, 76));
    logN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    logN.setForeground(new java.awt.Color(226, 241, 231));
    logN.setText("<html>log<sub style=\"font-size:10px;\">n</sub>[]</html>");
    logN.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    logN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        logNActionPerformed(evt);
      }
    });
    BasicWin.add(logN, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 377, 62, 50));

    dot1.setBackground(new java.awt.Color(54, 67, 76));
    dot1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    dot1.setForeground(new java.awt.Color(226, 241, 231));
    dot1.setText(",");
    dot1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    dot1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        dot1ActionPerformed(evt);
      }
    });
    BasicWin.add(dot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 597, 62, 50));

    pow.setBackground(new java.awt.Color(54, 67, 76));
    pow.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    pow.setForeground(new java.awt.Color(226, 241, 231));
    pow.setText("<html>x<sup style =\"font-size:10px\">n</sup></html>");
    pow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    pow.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        powActionPerformed(evt);
      }
    });
    BasicWin.add(pow, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 322, 62, 50));

    mode.setBackground(new java.awt.Color(54, 67, 76));
    mode.setForeground(new java.awt.Color(226, 241, 231));
    mode.setText("M");
    mode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    mode.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        modeActionPerformed(evt);
      }
    });
    BasicWin.add(mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 270, 62, 30));

    jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("DARKMODE");
    BasicWin.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 250, 60, 22));

    mode1.setBackground(new java.awt.Color(54, 67, 76));
    mode1.setForeground(new java.awt.Color(226, 241, 231));
    mode1.setText("H");
    mode1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    mode1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mode1ActionPerformed(evt);
      }
    });
    BasicWin.add(mode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 270, 62, 30));

    jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("ANGLE");
    BasicWin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 250, 40, 22));

    jToggleButton1.setBackground(new java.awt.Color(54, 67, 76));
    jToggleButton1.setForeground(new java.awt.Color(226, 241, 231));
    jToggleButton1.setText("DEG");
    jToggleButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jToggleButton1ActionPerformed(evt);
      }
    });
    BasicWin.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 270, 60, 30));

    jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
    jLabel25.setForeground(new java.awt.Color(255, 255, 255));
    jLabel25.setText("HISTORY");
    BasicWin.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 250, 50, 22));

    mode2.setBackground(new java.awt.Color(54, 67, 76));
    mode2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    mode2.setForeground(new java.awt.Color(226, 241, 231));
    mode2.setText("π");
    mode2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    mode2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mode2ActionPerformed(evt);
      }
    });
    BasicWin.add(mode2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 322, 62, 50));

    mode3.setBackground(new java.awt.Color(54, 67, 76));
    mode3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    mode3.setForeground(new java.awt.Color(226, 241, 231));
    mode3.setText("e");
    mode3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    mode3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mode3ActionPerformed(evt);
      }
    });
    BasicWin.add(mode3, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 322, 60, 50));

    jTabbedPane1.addTab("tab1", BasicWin);

    ModeWin.setBackground(new java.awt.Color(32, 39, 44));
    ModeWin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton7.setBackground(new java.awt.Color(54, 67, 76));
    jButton7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton7.setForeground(new java.awt.Color(255, 255, 255));
    jButton7.setText("Area calculation ");
    jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton7ActionPerformed(evt);
      }
    });
    ModeWin.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, 50));

    jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(255, 255, 255));
    jLabel11.setText("MODE");
    ModeWin.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

    jButton8.setBackground(new java.awt.Color(54, 67, 76));
    jButton8.setForeground(new java.awt.Color(255, 255, 255));
    jButton8.setText("Back");
    jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton8ActionPerformed(evt);
      }
    });
    ModeWin.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));

    jButton10.setBackground(new java.awt.Color(54, 67, 76));
    jButton10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton10.setForeground(new java.awt.Color(255, 255, 255));
    jButton10.setText("volume calculation ");
    jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton10.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton10ActionPerformed(evt);
      }
    });
    ModeWin.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 170, 50));

    jButton15.setBackground(new java.awt.Color(54, 67, 76));
    jButton15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton15.setForeground(new java.awt.Color(255, 255, 255));
    jButton15.setText("even or odd ");
    jButton15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton15.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton15ActionPerformed(evt);
      }
    });
    ModeWin.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 170, 50));

    jButton11.setBackground(new java.awt.Color(54, 67, 76));
    jButton11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton11.setForeground(new java.awt.Color(255, 255, 255));
    jButton11.setText("prime");
    jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton11.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton11ActionPerformed(evt);
      }
    });
    ModeWin.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 170, 50));

    jTabbedPane1.addTab("tab2", ModeWin);

    AreasWin.setBackground(new java.awt.Color(32, 39, 44));
    AreasWin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton9.setBackground(new java.awt.Color(54, 67, 76));
    jButton9.setForeground(new java.awt.Color(255, 255, 255));
    jButton9.setText("Back");
    jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton9ActionPerformed(evt);
      }
    });
    AreasWin.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));

    jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(255, 255, 255));
    jLabel12.setText("Area calculation");
    AreasWin.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

    jButton13.setBackground(new java.awt.Color(54, 67, 76));
    jButton13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton13.setForeground(new java.awt.Color(255, 255, 255));
    jButton13.setText("rectangular");
    jButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton13.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton13ActionPerformed(evt);
      }
    });
    AreasWin.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 170, 50));

    jButton14.setBackground(new java.awt.Color(54, 67, 76));
    jButton14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton14.setForeground(new java.awt.Color(255, 255, 255));
    jButton14.setText("square");
    jButton14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton14.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton14ActionPerformed(evt);
      }
    });
    AreasWin.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, 50));

    jButton18.setBackground(new java.awt.Color(54, 67, 76));
    jButton18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton18.setForeground(new java.awt.Color(255, 255, 255));
    jButton18.setText("Triangle");
    jButton18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton18.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton18ActionPerformed(evt);
      }
    });
    AreasWin.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 170, 50));

    jButton22.setBackground(new java.awt.Color(54, 67, 76));
    jButton22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton22.setForeground(new java.awt.Color(255, 255, 255));
    jButton22.setText("Circle");
    jButton22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton22.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton22ActionPerformed(evt);
      }
    });
    AreasWin.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 170, 50));

    jTabbedPane1.addTab("tab3", AreasWin);

    squareWin.setBackground(new java.awt.Color(32, 39, 44));
    squareWin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    txt_sideLength.setBackground(new java.awt.Color(32, 39, 44));
    txt_sideLength.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
    txt_sideLength.setForeground(new java.awt.Color(226, 241, 231));
    txt_sideLength.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 241, 231)));
    txt_sideLength.setCaretColor(new java.awt.Color(32, 39, 44));
    txt_sideLength.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txt_sideLengthActionPerformed(evt);
      }
    });
    txt_sideLength.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        txt_sideLengthKeyTyped(evt);
      }
    });
    squareWin.add(txt_sideLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 263, 59));

    jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(226, 241, 231));
    jLabel2.setText("Length (L) meter");
    squareWin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

    jButton1.setBackground(new java.awt.Color(89, 89, 89));
    jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jButton1.setForeground(new java.awt.Color(226, 241, 231));
    jButton1.setText("Clear");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    squareWin.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, 59));

    jButton2.setBackground(new java.awt.Color(54, 67, 76));
    jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jButton2.setForeground(new java.awt.Color(226, 241, 231));
    jButton2.setText("Calculate");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });
    squareWin.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 173, 59));

    jButton12.setBackground(new java.awt.Color(54, 67, 76));
    jButton12.setForeground(new java.awt.Color(255, 255, 255));
    jButton12.setText("Back");
    jButton12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton12.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton12ActionPerformed(evt);
      }
    });
    squareWin.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));

    jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("Square area ");
    squareWin.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

    SqAreaLaw.setBackground(new java.awt.Color(32, 39, 44));
    SqAreaLaw.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    SqAreaLaw.setForeground(new java.awt.Color(255, 255, 255));
    SqAreaLaw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    SqAreaLaw.setBorder(null);
    SqAreaLaw.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        SqAreaLawActionPerformed(evt);
      }
    });
    squareWin.add(SqAreaLaw, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 250, 50));

    squareAreaResult.setBackground(new java.awt.Color(32, 39, 44));
    squareAreaResult.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    squareAreaResult.setForeground(new java.awt.Color(255, 255, 255));
    squareAreaResult.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    squareAreaResult.setBorder(null);
    squareAreaResult.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        squareAreaResultActionPerformed(evt);
      }
    });
    squareWin.add(squareAreaResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 250, 50));

    jTabbedPane1.addTab("tab4", squareWin);

    rectangularWin.setBackground(new java.awt.Color(32, 39, 44));
    rectangularWin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    txtLength.setBackground(new java.awt.Color(32, 39, 44));
    txtLength.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
    txtLength.setForeground(new java.awt.Color(226, 241, 231));
    txtLength.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 241, 231)));
    txtLength.setCaretColor(new java.awt.Color(32, 39, 44));
    txtLength.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtLengthActionPerformed(evt);
      }
    });
    txtLength.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        txtLengthKeyTyped(evt);
      }
    });
    rectangularWin.add(txtLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 105, 59));

    txtWidth.setBackground(new java.awt.Color(32, 39, 44));
    txtWidth.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
    txtWidth.setForeground(new java.awt.Color(226, 241, 231));
    txtWidth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 241, 231)));
    txtWidth.setCaretColor(new java.awt.Color(32, 39, 44));
    txtWidth.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtWidthActionPerformed(evt);
      }
    });
    txtWidth.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        txtWidthKeyTyped(evt);
      }
    });
    rectangularWin.add(txtWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 105, 59));

    jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(226, 241, 231));
    jLabel3.setText("Width (w)");
    rectangularWin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

    jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(226, 241, 231));
    jLabel4.setText("Length (L)");
    rectangularWin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

    jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(226, 241, 231));
    jLabel5.setText("meter");
    rectangularWin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

    jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(226, 241, 231));
    jLabel6.setText("meter");
    rectangularWin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

    jButton3.setBackground(new java.awt.Color(89, 89, 89));
    jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jButton3.setForeground(new java.awt.Color(226, 241, 231));
    jButton3.setText("Clear");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });
    rectangularWin.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, -1, 59));

    jButton4.setBackground(new java.awt.Color(54, 67, 76));
    jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jButton4.setForeground(new java.awt.Color(226, 241, 231));
    jButton4.setText("Calculate");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });
    rectangularWin.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 173, 59));

    jButton17.setBackground(new java.awt.Color(54, 67, 76));
    jButton17.setForeground(new java.awt.Color(255, 255, 255));
    jButton17.setText("Back");
    jButton17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton17.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton17ActionPerformed(evt);
      }
    });
    rectangularWin.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));

    jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(255, 255, 255));
    jLabel15.setText("Rectangle area ");
    rectangularWin.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

    RecAreaLaw.setBackground(new java.awt.Color(32, 39, 44));
    RecAreaLaw.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    RecAreaLaw.setForeground(new java.awt.Color(255, 255, 255));
    RecAreaLaw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    RecAreaLaw.setBorder(null);
    RecAreaLaw.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        RecAreaLawActionPerformed(evt);
      }
    });
    rectangularWin.add(RecAreaLaw, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 250, 50));

    RecAreaResult.setBackground(new java.awt.Color(32, 39, 44));
    RecAreaResult.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    RecAreaResult.setForeground(new java.awt.Color(255, 255, 255));
    RecAreaResult.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    RecAreaResult.setBorder(null);
    RecAreaResult.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        RecAreaResultActionPerformed(evt);
      }
    });
    rectangularWin.add(RecAreaResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 250, 50));

    jTabbedPane1.addTab("tab5", rectangularWin);

    volumeCalcWin.setBackground(new java.awt.Color(32, 39, 44));
    volumeCalcWin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(255, 255, 255));
    jLabel13.setText("Volume calculation ");
    volumeCalcWin.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

    jButton19.setBackground(new java.awt.Color(54, 67, 76));
    jButton19.setForeground(new java.awt.Color(255, 255, 255));
    jButton19.setText("Back");
    jButton19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton19.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton19ActionPerformed(evt);
      }
    });
    volumeCalcWin.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));

    jTabbedPane1.addTab("tab8", volumeCalcWin);

    jPanel1.setBackground(new java.awt.Color(32, 39, 44));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("History");
    jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

    jScrollPane1.setFocusable(false);
    jScrollPane1.setRequestFocusEnabled(false);

    jTextPane1.setEditable(false);
    jTextPane1.setBackground(new java.awt.Color(32, 39, 44));
    jTextPane1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jTextPane1.setForeground(new java.awt.Color(255, 255, 255));
    jTextPane1.setToolTipText("");
    jTextPane1.setFocusable(false);
    jTextPane1.setVerifyInputWhenFocusTarget(false);
    jScrollPane1.setViewportView(jTextPane1);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, 350, 480));

    jButton5.setBackground(new java.awt.Color(54, 67, 76));
    jButton5.setForeground(new java.awt.Color(255, 255, 255));
    jButton5.setText("Back");
    jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton5ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 69, 30));

    jButton6.setBackground(new java.awt.Color(89, 89, 89));
    jButton6.setForeground(new java.awt.Color(255, 255, 255));
    jButton6.setText("clear");
    jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton6ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 64, 32));

    jTabbedPane1.addTab("tab6", jPanel1);

    triangleWin.setBackground(new java.awt.Color(32, 39, 44));
    triangleWin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton16.setBackground(new java.awt.Color(54, 67, 76));
    jButton16.setForeground(new java.awt.Color(255, 255, 255));
    jButton16.setText("Back");
    jButton16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton16.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton16ActionPerformed(evt);
      }
    });
    triangleWin.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));

    jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(255, 255, 255));
    jLabel14.setText("Triangle area ");
    triangleWin.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

    jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel16.setForeground(new java.awt.Color(255, 255, 255));
    jLabel16.setText("meter");
    triangleWin.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

    txtbase.setBackground(new java.awt.Color(32, 39, 44));
    txtbase.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
    txtbase.setForeground(new java.awt.Color(226, 241, 231));
    txtbase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 241, 231)));
    txtbase.setCaretColor(new java.awt.Color(32, 39, 44));
    txtbase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtbaseActionPerformed(evt);
      }
    });
    txtbase.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        txtbaseKeyTyped(evt);
      }
    });
    triangleWin.add(txtbase, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 105, 59));

    txtheight.setBackground(new java.awt.Color(32, 39, 44));
    txtheight.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
    txtheight.setForeground(new java.awt.Color(226, 241, 231));
    txtheight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 241, 231)));
    txtheight.setCaretColor(new java.awt.Color(32, 39, 44));
    txtheight.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtheightActionPerformed(evt);
      }
    });
    txtheight.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        txtheightKeyTyped(evt);
      }
    });
    triangleWin.add(txtheight, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 105, 59));

    jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jLabel17.setForeground(new java.awt.Color(255, 255, 255));
    jLabel17.setText("height (h)");
    triangleWin.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

    jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jLabel18.setForeground(new java.awt.Color(255, 255, 255));
    jLabel18.setText("base (b)");
    triangleWin.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

    jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel19.setForeground(new java.awt.Color(255, 255, 255));
    jLabel19.setText("meter");
    triangleWin.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

    jButton20.setBackground(new java.awt.Color(89, 89, 89));
    jButton20.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jButton20.setForeground(new java.awt.Color(226, 241, 231));
    jButton20.setText("Clear");
    jButton20.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton20ActionPerformed(evt);
      }
    });
    triangleWin.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, 59));

    jButton21.setBackground(new java.awt.Color(54, 67, 76));
    jButton21.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jButton21.setForeground(new java.awt.Color(226, 241, 231));
    jButton21.setText("Calculate");
    jButton21.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton21ActionPerformed(evt);
      }
    });
    triangleWin.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 173, 59));

    triLaw.setBackground(new java.awt.Color(32, 39, 44));
    triLaw.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    triLaw.setForeground(new java.awt.Color(255, 255, 255));
    triLaw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    triLaw.setBorder(null);
    triLaw.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        triLawActionPerformed(evt);
      }
    });
    triangleWin.add(triLaw, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 250, 50));

    triResult.setBackground(new java.awt.Color(32, 39, 44));
    triResult.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    triResult.setForeground(new java.awt.Color(255, 255, 255));
    triResult.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    triResult.setBorder(null);
    triResult.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        triResultActionPerformed(evt);
      }
    });
    triangleWin.add(triResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 250, 50));

    jTabbedPane1.addTab("tab7", triangleWin);

    circalWin.setBackground(new java.awt.Color(32, 39, 44));
    circalWin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel20.setForeground(new java.awt.Color(255, 255, 255));
    jLabel20.setText("Circle area ");
    circalWin.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

    jButton23.setBackground(new java.awt.Color(54, 67, 76));
    jButton23.setForeground(new java.awt.Color(255, 255, 255));
    jButton23.setText("Back");
    jButton23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton23.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton23ActionPerformed(evt);
      }
    });
    circalWin.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));

    jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel22.setForeground(new java.awt.Color(226, 241, 231));
    jLabel22.setText("radius(r) meter");
    circalWin.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

    txtRadius.setBackground(new java.awt.Color(32, 39, 44));
    txtRadius.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
    txtRadius.setForeground(new java.awt.Color(226, 241, 231));
    txtRadius.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 241, 231)));
    txtRadius.setCaretColor(new java.awt.Color(32, 39, 44));
    txtRadius.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtRadiusActionPerformed(evt);
      }
    });
    txtRadius.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        txtRadiusKeyTyped(evt);
      }
    });
    circalWin.add(txtRadius, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 263, 59));

    jButton24.setBackground(new java.awt.Color(54, 67, 76));
    jButton24.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jButton24.setForeground(new java.awt.Color(226, 241, 231));
    jButton24.setText("Calculate");
    jButton24.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton24ActionPerformed(evt);
      }
    });
    circalWin.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 173, 59));

    jButton25.setBackground(new java.awt.Color(89, 89, 89));
    jButton25.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jButton25.setForeground(new java.awt.Color(226, 241, 231));
    jButton25.setText("Clear");
    jButton25.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton25ActionPerformed(evt);
      }
    });
    circalWin.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, 59));

    circalAreaLaw.setBackground(new java.awt.Color(32, 39, 44));
    circalAreaLaw.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    circalAreaLaw.setForeground(new java.awt.Color(255, 255, 255));
    circalAreaLaw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    circalAreaLaw.setBorder(null);
    circalAreaLaw.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        circalAreaLawActionPerformed(evt);
      }
    });
    circalWin.add(circalAreaLaw, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 250, 50));

    circalAreaResult.setBackground(new java.awt.Color(32, 39, 44));
    circalAreaResult.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    circalAreaResult.setForeground(new java.awt.Color(255, 255, 255));
    circalAreaResult.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    circalAreaResult.setBorder(null);
    circalAreaResult.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        circalAreaResultActionPerformed(evt);
      }
    });
    circalWin.add(circalAreaResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 250, 50));

    jTabbedPane1.addTab("tab9", circalWin);

    jPanel2.setBackground(new java.awt.Color(32, 39, 44));
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
    jLabel21.setForeground(new java.awt.Color(255, 255, 255));
    jLabel21.setText("Data Puzzle");
    jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

    jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jLabel23.setForeground(new java.awt.Color(255, 255, 255));
    jLabel23.setText("members of");
    jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

    jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel24.setForeground(new java.awt.Color(255, 255, 255));
    jLabel24.setToolTipText("");
    jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, -1));

    jButton26.setBackground(new java.awt.Color(54, 67, 76));
    jButton26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton26.setForeground(new java.awt.Color(255, 255, 255));
    jButton26.setText("مصطفى نصر مصطفى");
    jButton26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel2.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 220, 30));

    jButton27.setBackground(new java.awt.Color(54, 67, 76));
    jButton27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton27.setForeground(new java.awt.Color(255, 255, 255));
    jButton27.setText("مصطفي محمود سعد");
    jButton27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton27.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton27ActionPerformed(evt);
      }
    });
    jPanel2.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 220, 30));

    jButton28.setBackground(new java.awt.Color(54, 67, 76));
    jButton28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton28.setForeground(new java.awt.Color(255, 255, 255));
    jButton28.setText("احمد سعيد فاروق");
    jButton28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton28.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton28ActionPerformed(evt);
      }
    });
    jPanel2.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 220, 30));

    jButton29.setBackground(new java.awt.Color(54, 67, 76));
    jButton29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton29.setForeground(new java.awt.Color(255, 255, 255));
    jButton29.setText("هيثم حساب مصطفي");
    jButton29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton29.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton29ActionPerformed(evt);
      }
    });
    jPanel2.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 220, 30));

    jButton30.setBackground(new java.awt.Color(54, 67, 76));
    jButton30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton30.setForeground(new java.awt.Color(255, 255, 255));
    jButton30.setText("مصطفي كمال محمود");
    jButton30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton30.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton30ActionPerformed(evt);
      }
    });
    jPanel2.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 220, 30));

    jButton31.setBackground(new java.awt.Color(54, 67, 76));
    jButton31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton31.setForeground(new java.awt.Color(255, 255, 255));
    jButton31.setText("الاء عليوه محمد");
    jButton31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton31.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton31ActionPerformed(evt);
      }
    });
    jPanel2.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 220, 30));

    jButton32.setBackground(new java.awt.Color(54, 67, 76));
    jButton32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton32.setForeground(new java.awt.Color(255, 255, 255));
    jButton32.setText("سيف خالد امين");
    jButton32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel2.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 220, 30));

    jButton33.setBackground(new java.awt.Color(54, 67, 76));
    jButton33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton33.setForeground(new java.awt.Color(255, 255, 255));
    jButton33.setText("تسنيم محسن جالل");
    jButton33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel2.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 220, 30));

    jButton34.setBackground(new java.awt.Color(54, 67, 76));
    jButton34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton34.setForeground(new java.awt.Color(255, 255, 255));
    jButton34.setText("شمس عماد عبدالفتاح");
    jButton34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel2.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 220, 30));

    jButton35.setBackground(new java.awt.Color(54, 67, 76));
    jButton35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton35.setForeground(new java.awt.Color(255, 255, 255));
    jButton35.setText("علي محمود اسماعيل");
    jButton35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel2.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 220, 30));

    jButton36.setBackground(new java.awt.Color(54, 67, 76));
    jButton36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jButton36.setForeground(new java.awt.Color(255, 255, 255));
    jButton36.setText("START");
    jButton36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jButton36.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton36ActionPerformed(evt);
      }
    });
    jPanel2.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 170, 30));

    jTabbedPane1.addTab("tab10", jPanel2);

    getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 350, 700));

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        handleAreaCalculation("rectangle",txtLength.getText(),txtWidth.getText(),RecAreaLaw,RecAreaResult);
        String s = "Rectangle area :\n"+txtLength.getText()+"*"+txtWidth.getText();
        History(RecAreaResult.getText(),s,jTextPane1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtLength.setText("");
        txtWidth.setText("");
        RecAreaResult.setText("");
        RecAreaLaw.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWidthKeyTyped
        numberOnly(evt);
    }//GEN-LAST:event_txtWidthKeyTyped

    private void txtWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWidthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWidthActionPerformed

    private void txtLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLengthKeyTyped
        numberOnly(evt);
    }//GEN-LAST:event_txtLengthKeyTyped

    private void txtLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLengthActionPerformed

    }//GEN-LAST:event_txtLengthActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       handleAreaCalculation("square",txt_sideLength.getText(),"",SqAreaLaw,squareAreaResult);
        String s = "square area :\n"+txt_sideLength.getText()+"*"+txt_sideLength.getText();
        History(squareAreaResult.getText(),s,jTextPane1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SqAreaLaw.setText("");
        squareAreaResult.setText("");
        txt_sideLength.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_sideLengthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sideLengthKeyTyped
        numberOnly(evt);
    }//GEN-LAST:event_txt_sideLengthKeyTyped

    private void txt_sideLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sideLengthActionPerformed

    }//GEN-LAST:event_txt_sideLengthActionPerformed

         //area caluc Panel
    private void ligtingModeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ligtingModeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ligtingModeKeyPressed

    private void ligtingModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ligtingModeActionPerformed
        if (ligtingMode.isSelected()) {//لو كان شغال هيشغل اليت مود

            jLabel1.setText("DARKMODE OFF");
            Color color_white = new Color(255, 255, 255);
            Color color_txt_light = new Color(207,209,208);
            Color color_label_dark = new Color(0,0,0);
            getContentPane().setBackground(color_white);
            txt.setBackground(color_txt_light );
            txt.setForeground(color_label_dark);
            jLabel1.setForeground(color_label_dark);
            setBtwColor(color_txt_light);
            setBtwTxtColor(color_label_dark);
            BasicWin.setBackground(color_txt_light);

        } else {

            jLabel1.setText("DARKMODE ON");
            Color color_dark = new Color(39,49,57);
            Color color_white = new Color(255, 255, 255);

            Color colot_btw_dark = new Color(54,67,76);
            getContentPane().setBackground(color_dark);
            jLabel1.setForeground(color_white);
            BasicWin.setBackground(colot_btw_dark);
            txt.setBackground(colot_btw_dark);
            txt.setForeground(color_white);
            setBtwColor(color_dark);
            setBtwTxtColor(color_white);
        }
    }//GEN-LAST:event_ligtingModeActionPerformed

    private void dot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dot1ActionPerformed
        set(", ", false);
    }//GEN-LAST:event_dot1ActionPerformed

    private void logNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logNActionPerformed
        set("log(", false);
    }//GEN-LAST:event_logNActionPerformed

    private void log10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log10ActionPerformed
        set("ln(", false);
    }//GEN-LAST:event_log10ActionPerformed

    private void factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factActionPerformed
        set("fact(", false);
    }//GEN-LAST:event_factActionPerformed

    private void rootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rootActionPerformed
        set("root(", false);
    }//GEN-LAST:event_rootActionPerformed

    private void tanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanActionPerformed
        set("tan(", false);
    }//GEN-LAST:event_tanActionPerformed

    private void cosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cosActionPerformed
        set("cos(", false);
    }//GEN-LAST:event_cosActionPerformed

    private void sinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinActionPerformed
        set("sin(", false);
    }//GEN-LAST:event_sinActionPerformed

    private void rightPeranthesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightPeranthesesActionPerformed
        set(")", false);
    }//GEN-LAST:event_rightPeranthesesActionPerformed

    private void leftPeranthesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftPeranthesesActionPerformed
        set("(", false);
    }//GEN-LAST:event_leftPeranthesesActionPerformed

    private void ANSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANSActionPerformed
			if(resultTemp == null){
					showMessageDialog(null,"NO RESULT TO SHOW","ERROR", ERROR_MESSAGE);
			}else{
				if (resultDone) 
					txt.setText("");

				resultDone = false;

				if (txt.getText().length() != 0) {
					// contains the operation at the end of the input text box, if not operation it will be null
					String lastOfTxt = txt.getText().substring(txt.getText().length() - 1);

					if (resultTemp.charAt(0) == '-' && ev.textToOperation.containsKey(lastOfTxt) &&
									ev.textToOperation.get(lastOfTxt).getPrecedence() > 0)
						txt.setText(txt.getText()+ "(" + resultTemp);
					else		
						txt.setText(txt.getText() + resultTemp);
					return;
				}
				txt.setText(txt.getText() + resultTemp);

			}
    }//GEN-LAST:event_ANSActionPerformed

    private void dotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dotActionPerformed
        set(".", false);
    }//GEN-LAST:event_dotActionPerformed

    private void equalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalActionPerformed
        resultDone = true;
        String m = txt.getText();
        eqTemp =m;
        try{
            
            Double res = ev.calculateExpression(m); 
            String resString = String.valueOf(Round(res, 8));
            String numberSide = resString;
            String ESide = "";

            if (resString.indexOf('E') != -1) {
                    ESide = resString.substring(resString.indexOf('E'));
                    numberSide = resString.substring(0, resString.indexOf('E'));
            }

            if (numberSide.substring(numberSide.length() - 2).compareTo(".0") == 0)
                    numberSide = numberSide.substring(0, numberSide.length() - 2);

            ESide = ESide.replace("E", "*10^");
            int minusSign = ESide.indexOf("-");
            if (minusSign != -1) {
                ESide = ESide.replace("-", "(-") + ")"; // turns 10^-4 into 10^(-4)
            }
            resString = numberSide + ESide;
           
            txt.setText(resString);
            resultTemp = resString ;
            History(resultTemp,eqTemp,jTextPane1);
            
            txt.setText(resString);

        }catch (CalculatorException e){
            showMessageDialog(null,e.error, e.errorType, ERROR_MESSAGE);
        }
    }//GEN-LAST:event_equalActionPerformed
    
    private Double Round(Double val, int n) {
        double valBig = Math.floor(val * Math.pow(10, n) + 0.5);
        return valBig / Math.pow(10, n);
    }
    private void ACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACActionPerformed
        txt.setText("");
    }//GEN-LAST:event_ACActionPerformed

    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed
      if (!txt.getText().isEmpty()) {
				String strOfLastChar = txt.getText().substring(txt.getText().length() - 1);
        if (ev.textToOperation.containsKey(strOfLastChar) &&            // if previous char is oparator
            ev.textToOperation.get(strOfLastChar).getPrecedence() > 0)  // make sure it is "operator"
            set("(", false);																						
			}
      set("-", true);
    }//GEN-LAST:event_minusActionPerformed

    private void plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusActionPerformed
        set("+", true);
    }//GEN-LAST:event_plusActionPerformed

    private void dividActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dividActionPerformed
        set("/", true);
    }//GEN-LAST:event_dividActionPerformed

    private void multActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multActionPerformed
        set("*", true);
    }//GEN-LAST:event_multActionPerformed

    private void DELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELActionPerformed
        String all = txt.getText();
        if(all.length()>0){
            all =all.substring(0,all.length()-1);
            txt.setText(all);
        }
    }//GEN-LAST:event_DELActionPerformed

    private void nineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nineActionPerformed
        set("9", false);
    }//GEN-LAST:event_nineActionPerformed

    private void eightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightActionPerformed
        set("8", false);
    }//GEN-LAST:event_eightActionPerformed

    private void sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed
        set("7", false);
    }//GEN-LAST:event_sevenActionPerformed

    private void sixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixActionPerformed
        set("6", false);
    }//GEN-LAST:event_sixActionPerformed

    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
        set("5", false);
    }//GEN-LAST:event_fiveActionPerformed

    private void fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
        set("4", false);
    }//GEN-LAST:event_fourActionPerformed

    private void threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
        set("3", false);
    }//GEN-LAST:event_threeActionPerformed

    private void twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
        set("2", false);
    }//GEN-LAST:event_twoActionPerformed

    private void oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
        set("1", false);
    }//GEN-LAST:event_oneActionPerformed

    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
        set("0", false);
    }//GEN-LAST:event_zeroActionPerformed

    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActionPerformed

    private void powActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powActionPerformed
        set("^", true);
    }//GEN-LAST:event_powActionPerformed

    private void modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeActionPerformed
       jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_modeActionPerformed

    private void mode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mode1ActionPerformed
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_mode1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextPane1.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void txtbaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbaseActionPerformed

    private void txtbaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbaseKeyTyped
       numberOnly(evt);
    }//GEN-LAST:event_txtbaseKeyTyped

    private void txtheightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtheightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtheightActionPerformed

    private void txtheightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtheightKeyTyped
        numberOnly(evt);
    }//GEN-LAST:event_txtheightKeyTyped

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        txtbase.setText("");
        txtheight.setText("");
        triLaw.setText("");
        triResult.setText("");
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        handleAreaCalculation("triangle",txtbase.getText(),txtheight.getText(),triLaw,triResult);
        String s = "Triangle area :\n}"+"0.5 *"+txtbase.getText()+"*"+txtheight.getText();
        History(triResult.getText(),s,jTextPane1);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void txtRadiusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRadiusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRadiusActionPerformed

    private void txtRadiusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRadiusKeyTyped
        numberOnly(evt);
    }//GEN-LAST:event_txtRadiusKeyTyped

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        handleAreaCalculation("circle",txtRadius.getText(),"",circalAreaLaw,circalAreaResult);
        String s = "circle area :\n π × "+txtRadius.getText()+"^2";
        History(circalAreaResult.getText(),s,jTextPane1);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        txtRadius.setText("");
        circalAreaLaw.setText("");
        circalAreaResult.setText("");
    }//GEN-LAST:event_jButton25ActionPerformed

    private void circalAreaLawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circalAreaLawActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_circalAreaLawActionPerformed

    private void circalAreaResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circalAreaResultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_circalAreaResultActionPerformed

    private void SqAreaLawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SqAreaLawActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SqAreaLawActionPerformed

    private void squareAreaResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareAreaResultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_squareAreaResultActionPerformed

    private void RecAreaLawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecAreaLawActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecAreaLawActionPerformed

    private void RecAreaResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecAreaResultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecAreaResultActionPerformed

    private void triLawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triLawActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_triLawActionPerformed

    private void triResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triResultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_triResultActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        jLabel24.setText("<html>GUI and handle pages <br>and make history <br>and combine scripts<br>light mode</html>");
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        jLabel24.setText("<html>Calculator's functioning<br> and logic,<br>Calculator Exception</html>");
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        jLabel24.setText("<html>even and odd<br>prime</html>");
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        jLabel24.setText("<html>make Area calculation</html>");
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        jLabel24.setText("<html>make volume calculation</html>");
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
					jToggleButton1.setText("RAD");
					ev.setOperation("sin", 1, -1, n -> {
						return Math.sin(n[0]);
					});
					ev.setOperation("cos", 1, -1, n -> {
						return Math.cos(n[0]);
					});
					ev.setOperation("tan", 1, -1, n -> {
						return Math.tan(n[0]);
					});
        } else {
					jToggleButton1.setText("DEG");
					ev.setOperation("sin", 1, -1, n -> {
						return Math.sin(n[0] * Math.PI / 180);
					});
					ev.setOperation("cos", 1, -1, n -> {
						return Math.cos(n[0] * Math.PI / 180);
					});
					ev.setOperation("tan", 1, -1, n -> {
						return Math.tan(n[0] * Math.PI / 180);
					});

        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void mode2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mode2ActionPerformed
        set("π", false);
    }//GEN-LAST:event_mode2ActionPerformed

    private void mode3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mode3ActionPerformed
        set("e", false);
    }//GEN-LAST:event_mode3ActionPerformed
           
  
    /**
     * @param args the command line arguments
     */



  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton AC;
  private javax.swing.JButton ANS;
  private javax.swing.JPanel AreasWin;
  private javax.swing.JPanel BasicWin;
  private javax.swing.JButton DEL;
  private javax.swing.JPanel ModeWin;
  private javax.swing.JTextField RecAreaLaw;
  private javax.swing.JTextField RecAreaResult;
  private javax.swing.JTextField SqAreaLaw;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JTextField circalAreaLaw;
  private javax.swing.JTextField circalAreaResult;
  private javax.swing.JPanel circalWin;
  private javax.swing.JButton cos;
  private javax.swing.JButton divid;
  private javax.swing.JButton dot;
  private javax.swing.JButton dot1;
  private javax.swing.JButton eight;
  private javax.swing.JButton equal;
  private javax.swing.JButton fact;
  private javax.swing.JButton five;
  private javax.swing.JButton four;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton10;
  private javax.swing.JButton jButton11;
  private javax.swing.JButton jButton12;
  private javax.swing.JButton jButton13;
  private javax.swing.JButton jButton14;
  private javax.swing.JButton jButton15;
  private javax.swing.JButton jButton16;
  private javax.swing.JButton jButton17;
  private javax.swing.JButton jButton18;
  private javax.swing.JButton jButton19;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton20;
  private javax.swing.JButton jButton21;
  private javax.swing.JButton jButton22;
  private javax.swing.JButton jButton23;
  private javax.swing.JButton jButton24;
  private javax.swing.JButton jButton25;
  private javax.swing.JButton jButton26;
  private javax.swing.JButton jButton27;
  private javax.swing.JButton jButton28;
  private javax.swing.JButton jButton29;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton30;
  private javax.swing.JButton jButton31;
  private javax.swing.JButton jButton32;
  private javax.swing.JButton jButton33;
  private javax.swing.JButton jButton34;
  private javax.swing.JButton jButton35;
  private javax.swing.JButton jButton36;
  private javax.swing.JButton jButton4;
  private javax.swing.JButton jButton5;
  private javax.swing.JButton jButton6;
  private javax.swing.JButton jButton7;
  private javax.swing.JButton jButton8;
  private javax.swing.JButton jButton9;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel18;
  private javax.swing.JLabel jLabel19;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel20;
  private javax.swing.JLabel jLabel21;
  private javax.swing.JLabel jLabel22;
  private javax.swing.JLabel jLabel23;
  private javax.swing.JLabel jLabel24;
  private javax.swing.JLabel jLabel25;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTextPane jTextPane1;
  private javax.swing.JToggleButton jToggleButton1;
  private javax.swing.JButton leftPerantheses;
  private javax.swing.JToggleButton ligtingMode;
  private javax.swing.JButton log10;
  private javax.swing.JButton logN;
  private javax.swing.JButton minus;
  private javax.swing.JButton mode;
  private javax.swing.JButton mode1;
  private javax.swing.JButton mode2;
  private javax.swing.JButton mode3;
  private javax.swing.JButton mult;
  private javax.swing.JButton nine;
  private javax.swing.JButton one;
  private javax.swing.JButton plus;
  private javax.swing.JButton pow;
  private javax.swing.JPanel rectangularWin;
  private javax.swing.JButton rightPerantheses;
  private javax.swing.JButton root;
  private javax.swing.JButton seven;
  private javax.swing.JButton sin;
  private javax.swing.JButton six;
  private javax.swing.JTextField squareAreaResult;
  private javax.swing.JPanel squareWin;
  private javax.swing.JButton tan;
  private javax.swing.JButton three;
  private javax.swing.JTextField triLaw;
  private javax.swing.JTextField triResult;
  private javax.swing.JPanel triangleWin;
  private javax.swing.JButton two;
  private javax.swing.JTextField txt;
  private javax.swing.JTextField txtLength;
  private javax.swing.JTextField txtRadius;
  private javax.swing.JTextField txtWidth;
  private javax.swing.JTextField txt_sideLength;
  private javax.swing.JTextField txtbase;
  private javax.swing.JTextField txtheight;
  private javax.swing.JPanel volumeCalcWin;
  private javax.swing.JButton zero;
  // End of variables declaration//GEN-END:variables
}
