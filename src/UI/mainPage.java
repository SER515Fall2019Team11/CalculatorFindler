package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class mainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage frame = new mainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentCalculate student = new studentCalculate();
				student.setVisible(true);
			}
		});
		btnStudent.setFont(new Font("Stencil", Font.PLAIN, 17));
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherInput teacher = new teacherInput();
				teacher.setVisible(true);
			}
		});
		btnTeacher.setFont(new Font("Stencil", Font.PLAIN, 17));
		
		JLabel lblWelcomePleaseSelect = new JLabel("Welcome! Please select your role :)");
		lblWelcomePleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomePleaseSelect.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(88)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTeacher, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
						.addComponent(btnStudent, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
					.addGap(88))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(140)
					.addComponent(lblWelcomePleaseSelect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(140))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomePleaseSelect, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(btnStudent, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(32)
					.addComponent(btnTeacher, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
					.addGap(46))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
