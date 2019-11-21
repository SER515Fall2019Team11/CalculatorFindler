package UI;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class studentCalculate extends JFrame {

	private int level;
	/**
	 * Create the application.
	 */
	public studentCalculate(int level) {
		this.level = level;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		setBounds(100, 100, 1400, 500);
		DragAndDropPanel dPanel = new DragAndDropPanel(level);
		CalculatorOperationPanel operationPanel = new CalculatorOperationPanel(dPanel, level);
		QuestionDisplayPanel qPanel = new QuestionDisplayPanel(this);
		
		add(operationPanel);
		add(dPanel);
		add(qPanel);
		
		setLayout(new GridLayout(1,3));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
