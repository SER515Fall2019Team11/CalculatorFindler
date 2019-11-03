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
		//this.setBackground(new Color(255,255,204));
		this.setBackground(Color.cyan);
	}
	private void btnInit() {
		DragMouseAdapter listener = new DragMouseAdapter();
		for(int i = 1; i <= 9; i++) {
			JButton btnOperand = new JButton(Integer.toString(i));
			//btnOperand.setForeground(Color.cyan);
			//btnOperand.setBackground(Color.cyan);
			groupOperandBtn.add(btnOperand);
			btnOperand.setTransferHandler(new ValueExportTransferHandler(Integer.toString(i)));
			btnOperand.addMouseMotionListener(listener);
		}
		btnPlus = new JButton("+");
		
		btnPlus.setTransferHandler(new ValueExportTransferHandler("+"));
		btnPlus.addMouseMotionListener(listener);
		
		
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
