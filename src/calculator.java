import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class calculator {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator window = new calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CalculatorOperationPanel operationPanel = new CalculatorOperationPanel();
		DragAndDropPanel dPanel = new DragAndDropPanel();
		QuestionDisplayPanel qPanel = new QuestionDisplayPanel();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.add(operationPanel);
		frame.add(dPanel);
		frame.add(qPanel);
		frame.setLayout(new GridLayout(1,3));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
