import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import javax.swing.TransferHandler;

import DragMouseAdapter.DragMouseAdapter;
import DragMouseAdapter.ValueExportTransferHandler;
import DragMouseAdapter.ValueImportTransferHandler;

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
	private JButton sample;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMulti;
	private JButton btnDivision;
	private JPanel dragPanel;
	
	//private JFrame dragPanelTest;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CalculatorOperationPanel(JPanel dPanel) {
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
		DragMouseAdapter listener = new DragMouseAdapter();
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
			btnOperand.setTransferHandler(new ValueExportTransferHandler(Integer.toString(i)));
			btnOperand.addMouseMotionListener(listener);
			/*btnOperand.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					JButton btn = (JButton)e.getSource();
					System.out.println(btn.getText());
					dragPanel.setText(btn.getText());
				}
			});*/ //Testing for Jframe
		}
		btnPlus = new JButton("+");
		
		btnPlus.setTransferHandler(new ValueExportTransferHandler("+"));
		btnPlus.addMouseMotionListener(listener);
		
		dragPanel.setLayout(new GridLayout(1,4));
		JLabel b1 = new JLabel("Enter");
		JLabel b2 = new JLabel("Enter");
		JLabel b3 = new JLabel("Enter");
		JLabel b4 = new JLabel("Enter");
		JLabel b5 = new JLabel("Enter");
		JLabel b6 = new JLabel("Enter");
		
		b1.setTransferHandler(new ValueImportTransferHandler());
		b2.setTransferHandler(new ValueImportTransferHandler());
		b3.setTransferHandler(new ValueImportTransferHandler());
		b4.setTransferHandler(new ValueImportTransferHandler());
		b5.setTransferHandler(new ValueImportTransferHandler());
		b6.setTransferHandler(new ValueImportTransferHandler());
		
		dragPanel.add(b1);
		dragPanel.add(b2);
		dragPanel.add(b3);
		dragPanel.add(b4);
		dragPanel.add(b5);
		dragPanel.add(b6);
		
		
		
		
		
		
		
		btnMinus = new JButton("-");
		btnMinus.setTransferHandler(new ValueExportTransferHandler("-"));
		btnMinus.addMouseMotionListener(listener);
		
		btnMulti = new JButton("*");
		btnMulti.setTransferHandler(new ValueExportTransferHandler("*"));
		btnMulti.addMouseMotionListener(listener);
		
		btnDivision = new JButton("/");
		btnDivision.setTransferHandler(new ValueExportTransferHandler("/"));
		btnDivision.addMouseMotionListener(listener);
	}

}
