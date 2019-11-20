package UI;
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
import java.awt.Font;

@SuppressWarnings("unused")
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
	//private JButton sample;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMulti;
	private JButton btnDivision;
	private DragAndDropPanel dragPanel;
	
	//private JFrame dragPanelTest;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CalculatorOperationPanel(DragAndDropPanel dPanel) {
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
		groupOperandBtn.setLayout(new GridLayout(4,3));
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
		//this.setBackground(new Color(255,255,204));
		this.setBackground(Color.cyan);
	}
	private void btnInit() {
		DragMouseAdapter listener = new DragMouseAdapter();
		for(int i = 0; i <= 9; i++) {
			JButton btnOperand = new JButton(Integer.toString(i));
			btnOperand.setBackground(Color.cyan);
			btnOperand.setOpaque(true);
			btnOperand.setBorderPainted(false);
			groupOperandBtn.add(btnOperand);
			btnOperand.setFont(new Font("Rockwell", Font.PLAIN, 28));
			btnOperand.setTransferHandler(new ValueExportTransferHandler(Integer.toString(i), dragPanel));
			btnOperand.addMouseMotionListener(listener);
		}
		btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Rockwell", Font.PLAIN, 36));
		btnPlus.setBackground(Color.cyan);
		btnPlus.setOpaque(true);
		btnPlus.setBorderPainted(false);
		btnPlus.setTransferHandler(new ValueExportTransferHandler("+", dragPanel));
		btnPlus.addMouseMotionListener(listener);
		
		
		btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Rockwell", Font.PLAIN, 36));
		btnMinus.setBackground(Color.cyan);
		btnMinus.setOpaque(true);
		btnMinus.setBorderPainted(false);
		btnMinus.setTransferHandler(new ValueExportTransferHandler("-", dragPanel));
		btnMinus.addMouseMotionListener(listener);
		
		btnMulti = new JButton("*");
		btnMulti.setFont(new Font("Rockwell", Font.PLAIN, 36));
		btnMulti.setBackground(Color.cyan);
		btnMulti.setOpaque(true);
		btnMulti.setBorderPainted(false);
		btnMulti.setTransferHandler(new ValueExportTransferHandler("*", dragPanel));
		btnMulti.addMouseMotionListener(listener);
		
		btnDivision = new JButton("/");
		btnDivision.setFont(new Font("Rockwell", Font.PLAIN, 36));
		btnDivision.setBackground(Color.cyan);
		btnDivision.setOpaque(true);
		btnDivision.setBorderPainted(false);
		btnDivision.setTransferHandler(new ValueExportTransferHandler("/", dragPanel));
		btnDivision.addMouseMotionListener(listener);
	
	}

}
