import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.GridLayout;

public class CalculatorOperationPanel extends JPanel {
	
	private JPanel groupOperandBtn;
	private JPanel groupOperationBtn;
	private Button btnNum1;
	private Button btnNum2;
	private Button btnNum3;
	private Button btnNum4;
	private Button btnNum5;
	private Button btnNum6;
	private Button btnNum7;
	private Button btnNum8;
	private Button btnNum9;
	private Button btnPlus;
	private Button btnMinus;
	private Button btnMulti;
	private Button btnDivision;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CalculatorOperationPanel() {
		init();
	}
	
	public void init() {
		panelInit();
		btnInit();
		groupOperandBtn.add(btnNum1);
		groupOperandBtn.add(btnNum2);
		groupOperandBtn.add(btnNum3);
		groupOperandBtn.add(btnNum4);
		groupOperandBtn.add(btnNum5);
		groupOperandBtn.add(btnNum6);
		groupOperandBtn.add(btnNum7);
		groupOperandBtn.add(btnNum8);
		groupOperandBtn.add(btnNum9);
		groupOperandBtn.setLayout(new GridLayout(3,3));
		groupOperandBtn.setBorder(BorderFactory.createTitledBorder("Operand"));
		
		groupOperationBtn.add(btnPlus);
		groupOperationBtn.add(btnMinus);
		groupOperationBtn.add(btnMulti);
		groupOperationBtn.add(btnDivision);
		groupOperationBtn.setLayout(new GridLayout(2,2));
		groupOperationBtn.setBorder(BorderFactory.createTitledBorder("Operator"));
		
		this.add(groupOperandBtn);
		this.add(groupOperationBtn);
		this.setLayout(new GridLayout(2,1));
	}
	private void panelInit() {
		groupOperandBtn = new JPanel();
		groupOperationBtn = new JPanel();
	}
	private void btnInit() {
		btnNum1 = new Button("1");
		btnNum2 = new Button("2");
		btnNum3 = new Button("3");
		btnNum4 = new Button("4");
		btnNum5 = new Button("5");
		btnNum6 = new Button("6");
		btnNum7 = new Button("7");
		btnNum8 = new Button("8");
		btnNum9 = new Button("9");
		btnPlus = new Button("+");
		btnMinus = new Button("-");
		btnMulti = new Button("*");
		btnDivision = new Button("/");
	}

}
