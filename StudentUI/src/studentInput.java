import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import java.awt.Point;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class studentInput {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentInput window = new studentInput();
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
	public studentInput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLocation(new Point(250, 0));
		panel.setName("Numbers and Operators");
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setPreferredSize(new Dimension(250, 10));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		JLabel lblNums = new JLabel("NUMS");
		
		JButton button = new JButton("1");
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty())
					textField.setText("2");
				else
					textField_2.setText("2");
			}
		});
		
		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_9 = new JButton("0");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblOps = new JLabel("OPS");
		
		JButton button_10 = new JButton("+");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("+");
			}
		});
		
		JButton button_11 = new JButton("-");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_12 = new JButton("/");
		
		JButton button_13 = new JButton("=");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String op = textField_1.getText();
				int result=0;
				if(op.equals("+"))
					result = Integer.parseInt(textField.getText()) + Integer.parseInt(textField_2.getText());
				textField_3.setText(Integer.toString(result));
				
			}
		});
		
		JButton btnC = new JButton("C");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNums))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(button)
					.addGap(36)
					.addComponent(button_1)
					.addGap(35)
					.addComponent(button_2))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(button_3)
					.addGap(36)
					.addComponent(button_4)
					.addGap(35)
					.addComponent(button_5))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(button_6)
					.addGap(36)
					.addComponent(button_7)
					.addGap(35)
					.addComponent(button_8))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(106)
					.addComponent(button_9))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addComponent(lblOps))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(button_10)
					.addGap(36)
					.addComponent(button_11)
					.addGap(37)
					.addComponent(button_12))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(button_13)
					.addGap(35)
					.addComponent(btnC))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNums)
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_3)
						.addComponent(button_4)
						.addComponent(button_5))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_6)
						.addComponent(button_7)
						.addComponent(button_8))
					.addGap(5)
					.addComponent(button_9)
					.addGap(35)
					.addComponent(lblOps)
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_10)
						.addComponent(button_11)
						.addComponent(button_12))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_13)
						.addComponent(btnC)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(400, 10));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBorder(new TitledBorder(null, "Num 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Op", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBorder(new TitledBorder(null, "Num 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBorder(new TitledBorder(null, "Result", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_3.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_3)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(121)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
		);
		panel_1.setLayout(gl_panel_1);
	
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			textField.setText("1");
		}
		
	});
	}
}
