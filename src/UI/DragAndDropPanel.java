package UI;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Implementation.ImplementationService;

import java.awt.Font;

public class DragAndDropPanel extends JPanel {
	public JTextArea text, result;
	//private JLabel result;
	private JPanel dragAndDrop;
	private JPanel resultPanel;
	private JPanel operation;
	private JButton btn1;
	private JButton btn2;
	private JButton dropArea;
	private final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private String user = "root";
	private String password = "Kuan890618";
	public String Id;
	//private static int res = 0;
	//private int eqn_counter_start;
	//private char operator = '`';
	//private int flag;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1888406948735963582L;
	private JButton btnReturn;

	/**
	 * Create the panel.
	 */
	public DragAndDropPanel() {
		init();
	}
	public void init() {
		//this.setBorder(BorderFactory.createTitledBorder("Drag & Drop Area"));
		//this.setBackground(new Color(255,255,204));
		this.setBackground(Color.cyan);
		
		/***
		 * add jpanel and jbutton to the drag and drop area 
		 */
		dragAndDrop = new JPanel();
		dragAndDrop.setBorder(BorderFactory.createTitledBorder("Drag & Drop Area"));
		dragAndDrop.setBackground(Color.cyan);
		
		dropArea = new JButton("Drop Off Area");
		dropArea.setBackground(Color.cyan);
		dropArea.setOpaque(true);
		dropArea.setBorderPainted(false);
		
		text = new JTextArea();
		text.setFont(new Font("Rockwell", Font.PLAIN, 26));
		text.setColumns(20);
		text.setRows(4);
		text.setBorder(BorderFactory.createTitledBorder(""));
		text.setBackground(Color.cyan);
		resultPanel = new JPanel();
		resultPanel.setBorder(BorderFactory.createTitledBorder("Result"));
		resultPanel.setBackground(Color.cyan);
	
		
		dragAndDrop.add(text);
		dragAndDrop.add(dropArea);
		dragAndDrop.setLayout(new GridLayout(1, 2));
		
		//Trying JTextArea instead of Jlabel to display result
		result = new JTextArea();
		result.setFont(new Font("Rockwell", Font.PLAIN, 26));
		result.setColumns(19);
		result.setRows(4);
		//result.setBorder(BorderFactory.createTitledBorder("Drag & Drop Area"));
		result.setBackground(Color.cyan);
		result.setEditable(false);
		result.setLineWrap(true);
		result.setWrapStyleWord(true);
		resultPanel.add(result);
		
		operation = new JPanel();
		btn1 = new JButton("CLEAR");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn1.setBackground(Color.cyan);
		btn1.setOpaque(true);
		btn1.setBorderPainted(false);
		
		btn2 = new JButton("Submit");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn2.setBackground(Color.cyan);
		btn2.setOpaque(true);
		btn2.setBorderPainted(false);
		
		operation.add(btn1);
		operation.add(btn2);
		operation.setBorder(BorderFactory.createTitledBorder("more operation"));
		operation.setBackground(Color.cyan);
		operation.setLayout(new GridLayout(1, 2));
		
		//this.add(text);
		this.add(dragAndDrop);
		this.add(resultPanel);
		this.add(operation);
		
		btnReturn = new JButton("RETURN");
		btnReturn.setBackground(Color.cyan);
		btnReturn.setOpaque(true);
		btnReturn.setBorderPainted(false);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPage main = new mainPage();
				main.setVisible(true);
				studentCalculate stu = new studentCalculate();
				stu.dispose();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		operation.add(btnReturn);
		this.setLayout(new GridLayout(3, 1));
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//res = 0;
				//operator = '`';
				text.setText(null);
				result.setText("Result will show here");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConn db = new DatabaseConn(url, user, password);
				Connection conn = db.getMySqlConnection();		
				if(conn == null) {
					JOptionPane.showMessageDialog(null, "database connection failed");
					return;
				}
				ImplementationService imp = new ImplementationService(conn);
				if(imp.checkAnswer(Id, result.getText())) {
					result.setText("You answer is correct!");
				}
				else {
					result.setText("Your answer is wrong! Try again!");
				}
			}
		});
	}
	
	public void calculate(String eqn) {
		/*String eqn = text.getText();
		if(eqn.length() == 1 && (eqn!="*" || eqn!="/")) {
			eqn_counter_start = 0;
			res = Integer.parseInt(eqn);
			flag = res;
			result.setText("Your equation is : "+eqn);
		}
		else if(eqn.charAt(eqn.length()-1) == '+' || eqn.charAt(eqn.length()-1) == '-' || eqn.charAt(eqn.length()-1) == '/' || eqn.charAt(eqn.length()-1) == '*'){
			if(eqn.charAt(eqn.length()-1) == '+') 
				operator = '+';
			else if(eqn.charAt(eqn.length()-1) == '-')
				operator = '-';
			res = flag;
			flag = res;
			eqn_counter_start = eqn.length();
			//num1 = Integer.parseInt(eqn.subSequence(eqn_counter_start, eqn_counter_end).toString());
			result.setText("Your equation is : "+eqn);
		}
		else {
			if(operator == '`') {
				res = Integer.parseInt(eqn);
				flag = res;
				result.setText("Result = "+eqn);
			}
			else if(operator == '+') {
				flag = res + Integer.parseInt(eqn.substring(eqn_counter_start).toString());
				result.setText("Result = "+Integer.toString(flag));
			}
			
			else if(operator == '-') {
				flag = res - Integer.parseInt(eqn.substring(eqn_counter_start).toString());
				result.setText("Result = "+Integer.toString(flag));
			}
			
			else if(eqn.charAt(eqn.length()-2) == '*') {
				res = res * ( Character.getNumericValue(eqn.charAt(eqn.length()-1)));
				result.setText("Result = "+Integer.toString(res));
			}
		}
	*/
		
		//String eqn = text.getText();
		/*char[] tokens = eqn.toCharArray();
		
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		
		for(int i=0; i<tokens.length; i++) {
			//if(tokens[i]== ' ')
			//	continue;
			if(tokens[i]>='0' && tokens[i]<='9') {
				StringBuffer sbuf = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
			}
			else if (tokens[i] == ')')
            {
                while (operators.peek() != '(')
                  values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                operators.pop();
            }
			else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
           {
               // While top of 'operators' has same or greater precedence to current
               // token, which is an operator. Apply operator on top of 'ops'
               // to top two elements in values stack
               while (!operators.empty() && precedence(tokens[i], operators.peek()))
                 values.push(applyOp(operators.pop(), values.pop(), values.pop()));

               // Push current token to 'operators'.
               operators.push(tokens[i]);
           }
		}
		
		while (!operators.empty())
            values.push(applyOp(operators.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        result.setText(Integer.toString(values.pop())); 
	}
	
	
	public boolean precedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
	}

	public int applyOp(char op, int b, int a) {
		switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
	}*/
		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    //String foo = "40+2/3*45";
	    try {
			result.setText(engine.eval(eqn).toString());
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getCause());
			//result.setText("Enter a number after operator!");
			String error = "ERROR: " + "an operand is expected after the operator";
			result.setText(error);
			System.out.println(e.getColumnNumber());
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}
}