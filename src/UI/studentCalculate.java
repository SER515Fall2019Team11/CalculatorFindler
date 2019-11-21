package UI;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class studentCalculate extends JFrame {

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentCalculate frame = new studentCalculate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public studentCalculate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		setBounds(100, 100, 1400, 500);
		DragAndDropPanel dPanel = new DragAndDropPanel();
		CalculatorOperationPanel operationPanel = new CalculatorOperationPanel(dPanel);
		QuestionDisplayPanel qPanel = new QuestionDisplayPanel(this, dPanel);
		
		add(operationPanel);
		add(dPanel);
		add(qPanel);
		
		setLayout(new GridLayout(1,3));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
