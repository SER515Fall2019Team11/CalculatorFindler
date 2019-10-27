import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.TransferHandler;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class CalculatorOperationPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7448758552520728876L;
	private JPanel groupOperandBtn;
	private JPanel groupOperationBtn;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMulti;
	private JButton btnDivision;
	private JTextArea textArea;
	public CalculatorOperationPanel(JTextArea dPanel) {
		this.textArea = dPanel;
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
		this.setBackground(new Color(255,255,204));
	}
	private void btnInit() {
		for(int i = 1; i <= 9; i++) {
			JButton btnOperand = new JButton(Integer.toString(i));
			btnOperand.setForeground(Color.cyan);
			groupOperandBtn.add(btnOperand);
			btnOperand.setTransferHandler(new ValueExportTransferHandler(btnOperand.getText()));
			btnOperand.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					JButton btn = (JButton)e.getSource();
                    TransferHandler handle = btn.getTransferHandler();
                    handle.exportAsDrag(btn, e, TransferHandler.COPY);
                    //System.out.println(textArea.getText());
				}
			});
		}
		
		btnPlus = new JButton("+");
		btnMinus = new JButton("-");
		btnMulti = new JButton("*");
		btnDivision = new JButton("/");
	}

}
