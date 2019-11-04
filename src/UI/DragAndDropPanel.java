package UI;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;

public class DragAndDropPanel extends JPanel {
	private JTextArea text;
	private JLabel result;
	private JPanel resultPanel;
	private JPanel operation;
	private JButton btn1;
	private JButton btn2;
	private static int res = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1888406948735963582L;

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
		text = new JTextArea();
		text.setFont(new Font("Rockwell", Font.PLAIN, 26));
		text.setColumns(20);
		text.setRows(4);
		text.setBorder(BorderFactory.createTitledBorder("Drag & Drop Area"));
		text.setBackground(Color.cyan);
		
		resultPanel = new JPanel();
		resultPanel.setBorder(BorderFactory.createTitledBorder("Result"));
		resultPanel.setBackground(Color.cyan);
		result = new JLabel("result will show here");
		result.setFont(new Font("Tahoma", Font.PLAIN, 28));
		resultPanel.add(result);
		operation = new JPanel();
		btn1 = new JButton("btn1");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn2 = new JButton("btn2");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		operation.add(btn1);
		operation.add(btn2);
		operation.setBorder(BorderFactory.createTitledBorder("more operation"));
		operation.setBackground(Color.cyan);
		operation.setLayout(new GridLayout(1, 2));
		
		this.add(text);
		this.add(resultPanel);
		this.add(operation);
		this.setLayout(new GridLayout(3, 1));
		
	}
	
	public void calculate() {
		String eqn = text.getText();
		if(eqn.length() == 1) {
			res = Integer.parseInt(eqn);
			result.setText("Your equation is : "+eqn);
		}
		else if(eqn.charAt(eqn.length()-1) == '+' || eqn.charAt(eqn.length()-1) == '-' || eqn.charAt(eqn.length()-1) == '/' || eqn.charAt(eqn.length()-1) == '*'){
			result.setText("Your equation is : "+eqn);
		}
		else {
			if(eqn.charAt(eqn.length()-2) == '+') {
				res = res + ( Character.getNumericValue(eqn.charAt(eqn.length()-1)));
				result.setText("Result = "+Integer.toString(res));
			}
			
			else if(eqn.charAt(eqn.length()-2) == '-') {
				res = res - ( Character.getNumericValue(eqn.charAt(eqn.length()-1))) ;
				result.setText("Result = "+Integer.toString(res));
			}
			
			else if(eqn.charAt(eqn.length()-2) == '*') {
				res = res * ( Character.getNumericValue(eqn.charAt(eqn.length()-1)));
				result.setText("Result = "+Integer.toString(res));
			}
		}
	}
}
