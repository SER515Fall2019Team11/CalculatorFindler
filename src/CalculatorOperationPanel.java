import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class CalculatorOperationPanel extends JPanel {
	
	private JPanel groupOperandBtn;
	private JPanel groupOperationBtn;
	/*
	private JButton btnNum1;
	private JButton btnNum2;
	private JButton btnNum3;
	private JButton btnNum4;
	private JButton btnNum5;
	private JButton btnNum6;
	private JButton btnNum7;
	private JButton btnNum8;
	private JButton btnNum9;*/
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMulti;
	private JButton btnDivision;
	private JTextArea dragPanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CalculatorOperationPanel(JTextArea dPanel) {
		dragPanel = dPanel;
		init();
	}
	
	public void init() {
		panelInit();
		btnInit();
		/*
		groupOperandBtn.add(btnNum1);
		groupOperandBtn.add(btnNum2);
		groupOperandBtn.add(btnNum3);
		groupOperandBtn.add(btnNum4);
		groupOperandBtn.add(btnNum5);
		groupOperandBtn.add(btnNum6);
		groupOperandBtn.add(btnNum7);
		groupOperandBtn.add(btnNum8);
		groupOperandBtn.add(btnNum9);*/
		groupOperandBtn.setLayout(new GridLayout(3,3));
		groupOperandBtn.setBorder(BorderFactory.createTitledBorder("Operand"));
		groupOperandBtn.setBackground(Color.cyan);
		
		groupOperationBtn.add(btnPlus);
		groupOperationBtn.add(btnMinus);
		groupOperationBtn.add(btnMulti);
		groupOperationBtn.add(btnDivision);
		groupOperationBtn.setLayout(new GridLayout(2,2));
		groupOperationBtn.setBorder(BorderFactory.createTitledBorder("Operator"));
		groupOperationBtn.setBackground(Color.cyan);
		
		this.add(groupOperandBtn);
		this.add(groupOperationBtn);
		this.setLayout(new GridLayout(2,1));
	}
	private void panelInit() {
		groupOperandBtn = new JPanel();
		groupOperationBtn = new JPanel();
		this.setBackground(new Color(255,255,204));
	}
	private void btnInit() {
		for(int i = 1; i <= 9; i++) {
			JButton btnOperand = new JButton(Integer.toString(i));
			btnOperand.setForeground(Color.cyan);
			//btnOperand.setBackground(Color.cyan);
			groupOperandBtn.add(btnOperand);
			/*
			btnOperand.addMouseListener(new MouseAdapter() {//add click event listener
				@Override
				public void mouseClicked(MouseEvent e) {
					Object obj = e.getSource();
					if(obj instanceof JButton) {
						JButton btn = (JButton)obj;
						JTextField textField = new JTextField(btn.getText());
						textField.setDragEnabled(true);
						dragPanel.add(textField);
						dragPanel.revalidate();
						System.out.println(btn.getText());
					}
				}
			});*/
			btnOperand.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					JButton btn = (JButton)e.getSource();
					//btn.setLocation(new Point(e.getX(), e.getY()));
				}
			});
			btnOperand.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					JButton btn = (JButton)e.getSource();
					System.out.println(btn.getText());
					dragPanel.setText(btn.getText());
				}
			});
		}
		btnPlus = new JButton("+");
		btnMinus = new JButton("-");
		btnMulti = new JButton("*");
		btnDivision = new JButton("/");
	}

}
