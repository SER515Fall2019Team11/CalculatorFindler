package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Implementation.ImplementationService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class mainPage extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passwordField;
	
	private final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private String user = "root";
	private String password = "Kuan890618";

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
	
	public boolean checkStudent(String username, String password1) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			ImplementationService imp = new ImplementationService(conn);
			Object [][]data = imp.getAllStudent();
			boolean result = false;
			for (int i = 0; i < data.length; i++) {
				if (data[i][1].equals(username) && data[i][2].equals(password1)) {
					result = true;
				}
			}
			return result;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean checkTeacher(String username, String password1) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			ImplementationService imp = new ImplementationService(conn);
			Object [][]data = imp.getAllTeacher();
			boolean result = false;
			for (int i = 0; i < data.length; i++) {
				if (data[i][1].equals(username) && data[i][2].equals(password1)) {
					result = true;
				}
			}
			return result;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	/**
	 * Create the frame.
	 */
	public mainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/*JButton btnStudent = new JButton("Student");
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
		btnTeacher.setFont(new Font("Stencil", Font.PLAIN, 17));*/
		
		JLabel lblWelcomePleaseSelect = new JLabel("Welcome! Please Log in / Register");
		lblWelcomePleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomePleaseSelect.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		usernameTF = new JTextField();
		usernameTF.setFont(new Font("Tahoma", Font.PLAIN, 26));
		usernameTF.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblSelectRole = new JLabel("Select Role:");
		lblSelectRole.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblSelectLevel = new JLabel("Select Level:");
		lblSelectLevel.setEnabled(false);
		lblSelectLevel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JRadioButton rdbtnLow = new JRadioButton("Low");
		rdbtnLow.setEnabled(false);
		rdbtnLow.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JRadioButton rdbtnHigh = new JRadioButton("High");
		rdbtnHigh.setEnabled(false);
		rdbtnHigh.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setFont(new Font("Tahoma", Font.PLAIN, 26));
		rdbtnStudent.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				if (rdbtnStudent.isSelected()) {
					lblSelectLevel.setEnabled(true);
					rdbtnLow.setEnabled(true);
					rdbtnHigh.setEnabled(true);
				} else {
					lblSelectLevel.setEnabled(false);
					rdbtnLow.setEnabled(false);
					rdbtnHigh.setEnabled(false);
				}
		    }
		});
		
		JRadioButton rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JButton loginBtn = new JButton("Log in");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password1 = new String(passwordField.getPassword());
				boolean stuCheck = checkStudent(usernameTF.getText(), password1);
				boolean teaCheck = checkTeacher(usernameTF.getText(), password1);

				try {
					if (rdbtnStudent.isSelected()) {
						
						if (rdbtnLow.isSelected()) {
							
						} else if (rdbtnHigh.isSelected()) {
							
						}
						if (stuCheck == true) {
							studentCalculate student = new studentCalculate();
							student.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Fail to Login");
						}
					} else if (rdbtnTeacher.isSelected()) {
						if (teaCheck == true) {
							teacherInput teacher = new teacherInput();
							teacher.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Fail to Login");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Error! Please select role");
					}
				} catch (Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Fail to Login");
				}
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JButton registerBtn = new JButton("Register");
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerPage register = new registerPage();
				register.setVisible(true);
			}
		});
		registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(140)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblWelcomePleaseSelect, GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
							.addGap(140))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordField, 427, 427, 427))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(usernameTF, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)))
							.addGap(125)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectRole, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
								.addComponent(lblSelectLevel, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
							.addGap(358)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(859)
							.addComponent(rdbtnStudent, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
							.addGap(122))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(201)
							.addComponent(loginBtn, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
							.addGap(159)
							.addComponent(registerBtn, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
							.addGap(204)
							.addComponent(rdbtnLow, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
							.addGap(146)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnTeacher, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnHigh, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
							.addGap(15)))
					.addGap(103))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomePleaseSelect, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(usernameTF, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSelectRole, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(loginBtn, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
								.addComponent(registerBtn, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
							.addGap(7))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnTeacher, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnStudent, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addComponent(lblSelectLevel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnHigh, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnLow, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
					.addGap(73))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
