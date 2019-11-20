package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Implementation.ImplementationService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JRadioButton;

public class registerPage extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	private final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private String user = "root";
	private String password = "Kuan890618";

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerPage frame = new registerPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public boolean checkStuUsername(String username) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			ImplementationService imp = new ImplementationService(conn);
			Object [][]data = imp.getAllStudent();
			boolean result = false;
			for (int i = 0; i < data.length; i++) {
				if (data[i][1].equals(username)) {
					result = true;
				}
			}
			return result;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean checkTeaUsername(String username) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			ImplementationService imp = new ImplementationService(conn);
			Object [][]data = imp.getAllTeacher();
			boolean result = false;
			for (int i = 0; i < data.length; i++) {
				if (data[i][1].equals(username)) {
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
	public registerPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRegisterPage = new JLabel("Register Page");
		lblRegisterPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterPage.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		
		JLabel label_1 = new JLabel("Username");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		usernameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JRadioButton rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password1 = new String(passwordField.getPassword());
				String password_check = new String(passwordField_1.getPassword());
				
				try {
					if (password1.equals(password_check)) {
						boolean stuCheck = checkStuUsername(usernameTextField.getText());
						boolean teaCheck = checkTeaUsername(usernameTextField.getText());
						int index = 2;
						String id = Integer.toString(index + 1);
						if (rdbtnStudent.isSelected()) {
							if (stuCheck == true) {
								JOptionPane.showMessageDialog(null, "Username Exists!");
							} else {
								Class.forName("com.mysql.jdbc.Driver");
								Connection conn = DriverManager.getConnection(url, user, password);
								String queryStu = "insert into student values('" + id + "', '" + usernameTextField.getText() + "', '" + password1 + "')";
								Statement statement = conn.createStatement();
								statement.executeUpdate(queryStu);
								JOptionPane.showMessageDialog(null, "Successfully Registration");
								setVisible(false);
							}
						} else if (rdbtnTeacher.isSelected()) {
							if (teaCheck == true) {
								JOptionPane.showMessageDialog(null, "Username Exists!");
							} else {
								Class.forName("com.mysql.jdbc.Driver");
								Connection conn = DriverManager.getConnection(url, user, password);
								String queryTea = "insert into teacher values('" + id + "', '" + usernameTextField.getText() + "', '" + password1 + "')";
								Statement statement = conn.createStatement();
								statement.executeUpdate(queryTea);
								JOptionPane.showMessageDialog(null, "Successfully Registration");
								setVisible(false);
							}
						}
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Password Does Not Match!");
					}
				} catch (Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Fail to register");
				}
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRegisterPage, GroupLayout.PREFERRED_SIZE, 628, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
									.addGap(128)
									.addComponent(usernameTextField, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
									.addGap(124)
									.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblConfirmPassword, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
									.addGap(31)
									.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)))
							.addGap(22))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(168)
					.addComponent(rdbtnStudent)
					.addGap(113)
					.addComponent(rdbtnTeacher)
					.addContainerGap(223, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(248)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(259, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblRegisterPage, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
						.addComponent(usernameTextField, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblConfirmPassword, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnStudent)
						.addComponent(rdbtnTeacher))
					.addGap(37)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
