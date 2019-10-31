import java.awt.BorderLayout;
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

public class mainPage extends JFrame {
boolean m_bExit = false;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton loginButton = new JButton();
	JButton buttonExit = new JButton();
	JTextField UserNameText = new JTextField();
	JPasswordField PasswordText = new JPasswordField();
	JRadioButton StudentRadio = new JRadioButton();
	JRadioButton InstructorRadio = new JRadioButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	private String UserBox = null;
	private USER_TYPE UserType = USER_TYPE.Student; 

	public Login() {
		try {
			jbInit();
			setSize(500, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		jLabel1.setText("UserName");
		jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
		jLabel2.setText("Password");
		jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
		loginButton.setText("Login");
		loginButton.setBounds(new Rectangle(31, 212, 85, 28));
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButton_actionPerformed(e);
			}
		});
		buttonExit.setText("Exit");
		buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
		buttonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonExit_actionPerformed(e);
			}
		});
		UserNameText.setBounds(new Rectangle(119, 52, 144, 22));
		PasswordText.setBounds(new Rectangle(118, 119, 147, 22));
		StudentRadio.setSelected(true);
		StudentRadio.setText("Student");
		StudentRadio.setBounds(new Rectangle(37, 164, 103, 26));
		InstructorRadio.setText("Instructor");
		InstructorRadio.setBounds(new Rectangle(177, 162, 103, 26));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(loginButton, null);
		this.getContentPane().add(buttonExit, null);
		this.getContentPane().add(UserNameText, null);
		this.getContentPane().add(PasswordText, null);
		this.getContentPane().add(StudentRadio, null);
		this.getContentPane().add(InstructorRadio, null);
		buttonGroup1.add(StudentRadio);
		buttonGroup1.add(InstructorRadio);
	}

	void loginButton_actionPerformed(ActionEvent e) {
		BufferedReader file;
		m_bExit = false;
		System.out.println("login clicked");
		try {
			if (StudentRadio.isSelected() == true)//// student
			{
				UserType = USER_TYPE.Student; /// 0 for student
				file = new BufferedReader(new FileReader("StuInfo.txt"));
			} else// instructor
			{
				UserType = USER_TYPE.Instructor; // 1 for instructor
				file = new BufferedReader(new FileReader("InsInfor.txt"));
			}
			UserBox = UserNameText.getText();
			String PasswordBox = new String(PasswordText.getPassword());
			String LoginName = null;
			String aline = null, UserName = null, Password = null;
			while ((aline = file.readLine()) != null) {
				UserName = GetUserName(aline);
				Password = GetPassword(aline);
				if (UserName.compareTo(UserBox) == 0 && Password.compareTo(PasswordBox) == 0)
					LoginName = UserName;
			}
			if (LoginName != null) {
				this.hide();
			}
		} catch (Exception ee) {
			;
		}

	}

	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	private String GetPassword(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1, aline.length());
	}

	public String GetUserName() {
		return UserBox;
	}

	
	public USER_TYPE GetUserType() {
		return UserType;
	}

	public boolean isExit() {
		return m_bExit;
	}

	void buttonExit_actionPerformed(ActionEvent e) {
		m_bExit = true;
		hide();
	}
}
}
